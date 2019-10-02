package codingChallenge.service;

import codingChallenge.models.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void createTestData() {
        accountService.createTestData();
        Iterable<Account> allAccounts = accountService.getAllAccounts();
        assertEquals(11, StreamSupport.stream(allAccounts.spliterator(), false).count());
    }

    @Test
    public void getAllAccounts() {
        Iterable<Account> allAccounts = accountService.getAllAccounts();
        assertEquals(11, StreamSupport.stream(allAccounts.spliterator(), false).count());
        Optional<String> optional = StreamSupport.stream(allAccounts.spliterator(), false).findFirst().map(Account::getAccountName);
        assertTrue(optional.isPresent());
        optional.ifPresent(nameCurrent -> assertEquals("SGSavings726", nameCurrent));
    }
}