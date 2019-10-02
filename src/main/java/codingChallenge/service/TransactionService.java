package codingChallenge.service;

import codingChallenge.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static codingChallenge.utilities.DateUtility.getExampleDate;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    public Iterable<Transaction> getTransactionsByAccountId(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    /**
     * Generate 4 mock transactions per account in the given account list.
     * @param accounts
     */
    void generateTransactionsOnAccounts(List<Account> accounts) {
        try {
            final Date exampleDate = getExampleDate("12/01/2012");
            accounts.forEach(account -> {
                List<Transaction> transactions = Arrays.asList(
                        new Transaction(account.getAccountNumber(), account.getAccountName(), exampleDate,
                                CurrencyCode.SGD, BigDecimal.ZERO, BigDecimal.valueOf(Math.random()*80000), DebitCredit.Credit, "Some credit"),
                        new Transaction(account.getAccountNumber(), account.getAccountName(), exampleDate,
                                CurrencyCode.SGD, BigDecimal.ZERO, BigDecimal.valueOf(Math.random()*80000), DebitCredit.Credit, "Some credit 2"),
                        new Transaction(account.getAccountNumber(), account.getAccountName(), exampleDate,
                                CurrencyCode.SGD, BigDecimal.valueOf(Math.random()*80000), BigDecimal.ZERO, DebitCredit.Debit, "Some debit"),
                        new Transaction(account.getAccountNumber(), account.getAccountName(), exampleDate,
                                CurrencyCode.SGD,BigDecimal.valueOf(Math.random()*80000), BigDecimal.ZERO, DebitCredit.Debit, "Some debit 2")
                );
                transactionRepository.saveAll(transactions);
            });

            Logger.getAnonymousLogger().info("Transaction table initialised.");
        } catch (Exception e) {
            Logger.getAnonymousLogger().info("Transaction table initialise failed.");
            e.printStackTrace();
        }
    }
}
