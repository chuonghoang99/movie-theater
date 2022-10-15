/*
 *
 * @author: ChuongHV1
 * @date: Nov 27, 2021
 */

package fa.appcode.web.controller;

import fa.appcode.common.utils.Constants;
import fa.appcode.config.MessageConfig;
import fa.appcode.config.PageConfig;
import fa.appcode.services.AccountService;
import fa.appcode.services.EmployeeService;
import fa.appcode.services.StorageService;
import fa.appcode.web.entities.Account;
import fa.appcode.web.entities.Employee;
import fa.appcode.web.entities.Roles;
import fa.appcode.web.vo.EmployeeVo;
import fa.appcode.web.vo.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/admin/employee/")
public class EmployeeController {

    @Autowired
    private PageConfig pageConfig;

    @Autowired
    private MessageConfig messageConfig;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * @param model model add attribute push to view
     * @return view list employee
     * @throws Exception convert page index , page size -> Exception
     */
    @GetMapping("list-employee")
    public ModelAndView showListEmployee(Model model) throws Exception {
        int pageIndex = pageConfig.getInitPage();
        int pageSize = pageConfig.getSizePage();
        Page<EmployeeVo> page = employeeService.findAllEmployee(pageIndex - 1, pageSize);
        model.addAttribute("employeeVos", page.toList());
        model.addAttribute("numOfPages", page.getTotalPages());
        model.addAttribute("pageIndex", pageIndex);
        return new ModelAndView("employee/list-employee");
    }

    /**
     * @param dataSearch input search
     * @param pageIndex  index of page
     * @param pageSize   size of page
     * @param model      model add attribute push to view
     * @return table list employee
     */
    @GetMapping("list-employee/filter")
    public ModelAndView showListEmployeeSearch(
            @RequestParam(name = "dataSearch", required = true, defaultValue = "") String dataSearch,
            @RequestParam(name = "pageIndex", required = true) int pageIndex,
            @RequestParam(name = "pageSize", required = true) int pageSize, Model model) {
        Page<EmployeeVo> page = employeeService.findAllEmployee(pageIndex - 1, pageSize, dataSearch);
        model.addAttribute("employeeVos", page.toList());
        model.addAttribute("numOfPages", page.getTotalPages());
        model.addAttribute("pageIndex", pageIndex);
        return new ModelAndView("employee/table-employee");
    }

    /**
     * @return add/edit employee screen
     */
    @GetMapping("detail-employee")
    public ModelAndView detailEmployeeShow() {
        return new ModelAndView("employee/detail-employee");
    }

    /**
     * @param id id of employee
     * @return find employee by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable String id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok()
                    .body(new ResponseObject(messageConfig.getStatusFindSuccess(),
                            messageConfig.getMessageFindSuccess(),
                            employee));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseObject(messageConfig.getStatusFindFail(),
                            messageConfig.getMessageFindFail(),
                            employee));
        }
    }


    /**
     * API - save employee
     *
     * @param file          : image upload
     * @param account       information of account
     * @param bindingResult valid backend
     * @return json (status - message - data ) save employee
     * @throws IOException save file error
     */
    @PostMapping(value = "save")
    public ResponseEntity<ResponseObject> saveEmployee(
            @RequestParam(name = "employeeId", required = false) String employeeId,
            @RequestParam(name = "file", required = false) MultipartFile file, @Valid Account account,
            BindingResult bindingResult) throws IOException {

        Employee employeeSave = new Employee();

        // check validate data
        if (bindingResult.hasErrors()) {
            Map<String, String> errorList = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseObject(messageConfig.getStatusAddDataInvalid(),
                            messageConfig.getMessageAddDataInvalid(),
                            errorList));
        }


        // check file upload -set image for account
        if (file != null && !file.isEmpty()) {
            String storageFolder = Constants.PATH_EMPLOYEE_IMG;
            try {
                String fileName = storageService.storeFile(file, storageFolder);
                account.setImage(fileName);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                        .body(new ResponseObject(messageConfig.getStatusAddImageInvalid(),
                                messageConfig.getMessageAddImageInvalid(),
                                ""));
            }
        }

        //// check edit or add
        // edit employee
        if (!employeeId.isEmpty() && !account.getAccountId().isEmpty()) {
            employeeSave.setEmployeeId(employeeId);
            Account accountDb = accountService.findAccountByAccountId(account.getAccountId());
            // user change username- check exists
            if (!accountDb.getUserName().equals(account.getUserName())){
                Account accountCheck = accountService.findAccountByUserName(account.getUserName());
                if (accountCheck != null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new ResponseObject(messageConfig.getStatusAddAccountExists(),
                                    messageConfig.getMessageAddAccountExists(),
                                    ""));
                }

            }

            // check edit id card - id card duplicate
            if (!accountDb.getIdentityCard().equals(account.getIdentityCard())) {
                Account accountCheckIdentityCard = accountService.findAccountByIdentityCard(account.getIdentityCard());
                if (accountCheckIdentityCard != null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new ResponseObject(messageConfig.getStatusAddIdentityCardExists(),
                                    messageConfig.getMessageAddIdentityCardExists(),
                                    ""));
                }
            }


            accountDb.setUserName(account.getUserName());
            accountDb.setFullName(account.getFullName());
            accountDb.setGender(account.getGender());
            accountDb.setDateOfBirth(account.getDateOfBirth());
            accountDb.setAddress(account.getAddress());
            accountDb.setPhoneNumber(account.getPhoneNumber());
            accountDb.setIdentityCard(account.getIdentityCard());
            if (file != null && !file.isEmpty()) {
                accountDb.setImage(account.getImage());
            }
            employeeSave.setAccount(accountDb);

        }
        //add new employee
        else {
            // check userName exits
            Account accountCheck = accountService.findAccountByUserName(account.getUserName());
            if (accountCheck != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ResponseObject(messageConfig.getStatusAddAccountExists(),
                                messageConfig.getMessageAddAccountExists(),
                                ""));
            }

            // check identity card exits
            Account accountCheckIdentityCard = accountService.findAccountByIdentityCard(account.getIdentityCard());
            if (accountCheckIdentityCard != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ResponseObject(messageConfig.getStatusAddIdentityCardExists(),
                                messageConfig.getMessageAddIdentityCardExists(),
                                ""));
            }

            String password = account.getPassword();
            account.setAccountId(null);
            account.setPassword(bCryptPasswordEncoder.encode(password));
            account.setRegisterDate(new Date());
            account.setStatus(1);
            account.setRoles(new Roles(2));
            employeeSave = new Employee();
            employeeSave.setAccount(account);
        }

        // add/edit employee
        if (employeeService.save(employeeSave)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject(messageConfig.getStatusAddSuccess(),
                            messageConfig.getMessageAddSuccess(),
                            employeeSave));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseObject(messageConfig.getStatusAddServerError(),
                        messageConfig.getMessageAddServerError(),
                        employeeSave));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> delete(@PathVariable String id) {
        boolean result = employeeService.deleteById(id);
        if (result) {
            return ResponseEntity.ok()
                    .body(new ResponseObject(messageConfig.getStatusDeleteSuccess(),
                            messageConfig.getMessageDeleteSuccess(),
                            ""));
        }

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body(new ResponseObject(messageConfig.getStatusDeleteFail(),
                        messageConfig.getMessageDeleteFail(),
                        ""));
    }


}