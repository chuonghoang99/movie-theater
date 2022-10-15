package fa.appcode.services;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.repositories.AccountRepository;
import fa.appcode.services.impl.AccountServiceImpl;
import fa.appcode.web.entities.Account;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountServiceTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void findAccountByUserName() {

        final String userName = "chuong";
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = DateFor.parse("08/07/2021");
        } catch (ParseException e) {
            LogUtils.getLogger().info("Convert date fail !!!");
        }
        Account account = new Account("G3_0000001", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong1");
        Mockito.when(accountRepository.findByUserName(userName)).thenReturn(account);
        Account actual = accountService.findAccountByUserName(userName);
        assertEquals(account, actual);
    }

    @Test
    void findAccountByAccountId() {
        final String id = "G3_0000001";
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = DateFor.parse("08/07/2021");
        } catch (ParseException e) {
            LogUtils.getLogger().info("Convert date fail !!!");
        }
        Account account = new Account("G3_0000001", "ha noi", date, "chuong@gmail.com", "hoang van chuong", "M", "123456", "image", "123", "0983012606", date, 1, "chuong1");
        Mockito.when(accountRepository.findByAccountId(id)).thenReturn(account);
        Account actual = accountService.findAccountByAccountId(id);
        assertEquals(account, actual);
    }

}