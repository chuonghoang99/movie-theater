package fa.appcode.services;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.repositories.EmployeeRepository;
import fa.appcode.services.impl.EmployeeServiceImpl;
import fa.appcode.web.entities.Account;
import fa.appcode.web.entities.Employee;
import fa.appcode.web.vo.EmployeeVo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    /*
     *  Test find all employee
     * */
    @Test
    void findAllEmployee() {
        int pageIndex = 1;
        int pageSize = 6;
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = DateFor.parse("08/07/2021");

        } catch (ParseException e) {
            LogUtils.getLogger().info("Convert date fail !!!");
        }
        List<EmployeeVo> employeeVos = new ArrayList<>();
        employeeVos.add(new EmployeeVo("G3_0000011", "G3_0000001", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong1"));
        employeeVos.add(new EmployeeVo("G3_0000002", "G3_0000002", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong2"));
        employeeVos.add(new EmployeeVo("G3_0000003", "G3_0000003", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong3"));
        employeeVos.add(new EmployeeVo("G3_0000004", "G3_0000004", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong4"));
        employeeVos.add(new EmployeeVo("G3_0000005", "G3_0000005", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong5"));
        employeeVos.add(new EmployeeVo("G3_0000006", "G3_0000006", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong6"));

        Page<EmployeeVo> page = new PageImpl<>(employeeVos);
        Mockito.when(employeeRepository.findAllEmployee(pageable)).thenReturn(page);

        Page<EmployeeVo> actual = employeeService.findAllEmployee(pageIndex, pageSize);
        LogUtils.getLogger().info(actual.toList().get(0).toString());
        assertEquals(page,actual);

    }


    /*
     *  Test find all employee with key search
     *  Case 1
     * */
    @Test
    void testFindAllEmployeeWithSearch1() {
        int pageIndex = 1;
        int pageSize = 6;
        String dataSearch = "";
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = DateFor.parse("08/07/2021");
        } catch (ParseException e) {
            LogUtils.getLogger().info("Convert date fail !!!");
        }
        List<EmployeeVo> employeeVos = new ArrayList<>();
        employeeVos.add(new EmployeeVo("G3_0000011", "G3_0000001", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong1"));
        employeeVos.add(new EmployeeVo("G3_0000002", "G3_0000002", "nam dinh", date, "kien@gmail.com", "hoang van kien", "M", "123456", "image", "123", "0983012606", date, 1, "chuong2"));
        employeeVos.add(new EmployeeVo("G3_0000003", "G3_0000003", "giao thuy", date, "thang@gmail.com", "hoang van thang", "M", "123456", "image", "123", "0983012606", date, 1, "chuong3"));
        employeeVos.add(new EmployeeVo("G3_0000004", "G3_0000004", "quat lam", date, "thanh@gmail.com", "hoang van thanh", "M", "123456", "image", "123", "0983012606", date, 1, "chuong4"));
        employeeVos.add(new EmployeeVo("G3_0000005", "G3_0000005", "ha noi", date, "truong@gmail.com", "hoang van truong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong5"));
        employeeVos.add(new EmployeeVo("G3_0000006", "G3_0000006", "ha noi", date, "oanh@gmail.com", "hoang thi oanh", "M", "123456", "image", "123", "0983012606", date, 1, "chuong6"));
        Page<EmployeeVo> page = new PageImpl<>(employeeVos);

        Mockito.when(employeeRepository.findAllEmployee(dataSearch,pageable)).thenReturn(page);

        Page<EmployeeVo> actual = employeeService.findAllEmployee( pageIndex, pageSize,dataSearch);
        LogUtils.getLogger().info(actual.toList().toString());
        assertEquals(page,actual);
    }

    /*
     *  Test find all employee with key search
     *  Case 2
     * */
    @Test
    void testFindAllEmployeeWithSearch2() {
        int pageIndex = 1;
        int pageSize = 6;
        String dataSearch = "kien";
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = DateFor.parse("08/07/2021");
        } catch (ParseException e) {
            LogUtils.getLogger().info("Convert date fail !!!");
        }
        List<EmployeeVo> employeeVos = new ArrayList<>();
        employeeVos.add(new EmployeeVo("G3_0000011", "G3_0000001", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong1"));
        employeeVos.add(new EmployeeVo("G3_0000002", "G3_0000002", "nam dinh", date, "kien@gmail.com", "hoang van kien", "M", "123456", "image", "123", "0983012606", date, 1, "chuong2"));
        employeeVos.add(new EmployeeVo("G3_0000003", "G3_0000003", "giao thuy", date, "thang@gmail.com", "hoang van thang", "M", "123456", "image", "123", "0983012606", date, 1, "chuong3"));
        employeeVos.add(new EmployeeVo("G3_0000004", "G3_0000004", "quat lam", date, "thanh@gmail.com", "hoang van thanh", "M", "123456", "image", "123", "0983012606", date, 1, "chuong4"));
        employeeVos.add(new EmployeeVo("G3_0000005", "G3_0000005", "ha noi", date, "truong@gmail.com", "hoang van truong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong5"));
        employeeVos.add(new EmployeeVo("G3_0000006", "G3_0000006", "ha noi", date, "oanh@gmail.com", "hoang thi oanh", "M", "123456", "image", "123", "0983012606", date, 1, "chuong6"));
        Page<EmployeeVo> page = new PageImpl<>(employeeVos);
        Mockito.when(employeeRepository.findAllEmployee(dataSearch,pageable)).thenReturn(page);
        Page<EmployeeVo> actual = employeeService.findAllEmployee( pageIndex, pageSize, dataSearch);
        assertEquals(page,actual);
    }

    /*
     *  Test find all employee with key search -> data return null
     *  Case 3
     * */
    @Test
    void testFindAllEmployeeWithSearch3() {
        int pageIndex = 1;
        int pageSize = 6;
        String dataSearch = "kien";
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = DateFor.parse("08/07/2021");
        } catch (ParseException e) {
            LogUtils.getLogger().info("Convert date fail !!!");
        }
        List<EmployeeVo> employeeVos = new ArrayList<>();
//        employeeVos.add(new EmployeeVo("G3_0000011", "G3_0000001", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong1"));
//        employeeVos.add(new EmployeeVo("G3_0000002", "G3_0000002", "nam dinh", date, "kien@gmail.com", "hoang van kien", "M", "123456", "image", "123", "0983012606", date, 1, "chuong2"));
//        employeeVos.add(new EmployeeVo("G3_0000003", "G3_0000003", "giao thuy", date, "thang@gmail.com", "hoang van thang", "M", "123456", "image", "123", "0983012606", date, 1, "chuong3"));
//        employeeVos.add(new EmployeeVo("G3_0000004", "G3_0000004", "quat lam", date, "thanh@gmail.com", "hoang van thanh", "M", "123456", "image", "123", "0983012606", date, 1, "chuong4"));
//        employeeVos.add(new EmployeeVo("G3_0000005", "G3_0000005", "ha noi", date, "truong@gmail.com", "hoang van truong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong5"));
//        employeeVos.add(new EmployeeVo("G3_0000006", "G3_0000006", "ha noi", date, "oanh@gmail.com", "hoang thi oanh", "M", "123456", "image", "123", "0983012606", date, 1, "chuong6"));
        Page<EmployeeVo> page = new PageImpl<>(employeeVos);
        Mockito.when(employeeRepository.findAllEmployee(dataSearch,pageable)).thenReturn(page);
        Page<EmployeeVo> actual = employeeService.findAllEmployee( pageIndex, pageSize, dataSearch);
        assertEquals(page,actual);
    }


    /*Test save employee
     * Case 1
     */
    @Test
    void saveEmployee() {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = DateFor.parse("08/07/2021");
        } catch (ParseException e) {
            LogUtils.getLogger().info("Convert date fail !!!");
        }
        Account account = new Account("G3_0000001", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong1");
        Employee employee = new Employee("G3_0000011", null);
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        boolean actual = employeeService.save(employee);
        assertTrue(actual);
    }



    /*Test get employee by id
     * Case 1
     */
    @Test
    void findEmployeeById() {
        final String id = "G3_0000001";
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = DateFor.parse("08/07/2021");
        } catch (ParseException e) {
            LogUtils.getLogger().info("Convert date fail !!!");
        }
        Account account = new Account("G3_0000001", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong1");
        Employee employee = new Employee("G3_0000011", account);
        Mockito.when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        Optional<Employee> actual = employeeService.findById(id);
        assertTrue(actual.isPresent());
    }


    /*Test get employee by id
     * Case 2 with id null
     */
    @Test
    void findEmployeeById2() {
        final String id = "G3_0000001";
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = DateFor.parse("08/07/2021");
        } catch (ParseException e) {
            LogUtils.getLogger().info("Convert date fail !!!");
        }
        Account account = new Account("G3_0000001", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong1");
        Employee employee = new Employee("G3_0000011", account);
        Mockito.when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        Optional<Employee> actual = employeeService.findById(null);
        assertTrue(actual.isEmpty());
    }


}