package codingChallenge.models;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

import static junit.framework.TestCase.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void canSaveAccount() {
        Account account = new Account("foo","bar",AccountType.Savings, new Date(), CurrencyCode.SGD, BigDecimal.valueOf(300000));
        accountRepository.save(account);

        Optional<Account> optional = accountRepository.findById("foo");
        assertTrue(optional.isPresent());
        optional.ifPresent(accountCurrent -> {
            Logger.getAnonymousLogger().info("*** Account balance date : " + accountCurrent.getBalanceDate());
            assertEquals("bar", accountCurrent.getAccountName());
            assertEquals(BigDecimal.valueOf(300000), accountCurrent.getOpeningAvailableBalance());
        });

    }
}