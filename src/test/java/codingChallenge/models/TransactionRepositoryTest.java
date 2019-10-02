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
public class TransactionRepositoryTest {
    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void canSaveTransaction() {
        Transaction transaction = new Transaction(
                "foo", "bar", new Date(), CurrencyCode.SGD, BigDecimal.valueOf(100), null, DebitCredit.Debit, "qux"
        );
        transactionRepository.save(transaction);

        Optional<Transaction> optional = transactionRepository.findById(transaction.getTransactionId());
        assertTrue(optional.isPresent());
        optional.ifPresent(transactionCurrent -> {
            Logger.getAnonymousLogger().info("*** TransactionId : " + transactionCurrent.getTransactionId());
            Logger.getAnonymousLogger().info("*** Account number : " + transactionCurrent.getAccountNumber());
            assertEquals("bar", transactionCurrent.getAccountName());
            assertEquals(transactionCurrent.getDebitAmount(), BigDecimal.valueOf(100));
        });


    }
}