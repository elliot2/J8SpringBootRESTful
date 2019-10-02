package codingChallenge.service;

import codingChallenge.models.Account;
import codingChallenge.models.AccountRepository;
import codingChallenge.models.AccountType;
import codingChallenge.models.CurrencyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static codingChallenge.utilities.DateUtility.getExampleDate;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    @PostConstruct
    public void createTestData() {
        Date exampleDate = null;
        try {
            exampleDate = getExampleDate("8/11/2018");
            // This is just mock data for in memory database.  With a JDBC to relational database, this method would not be used.
            List<Account> accounts = Arrays.asList(
                    new Account("585309209", "SGSavings726", AccountType.Savings, exampleDate, CurrencyCode.SGD, BigDecimal.valueOf(84327.51)),
                    new Account("791066619", "AUSavings933", AccountType.Savings, exampleDate, CurrencyCode.AUD, BigDecimal.valueOf(88005.93)),
                    new Account("321143048", "AUCurrent433", AccountType.Current, exampleDate, CurrencyCode.AUD, BigDecimal.valueOf(38010.62)),
                    new Account("347546123", "SGCurrent166", AccountType.Current, exampleDate, CurrencyCode.SGD, BigDecimal.valueOf(50664.65)),
                    new Account("680456441", "AUCurrent374", AccountType.Current, exampleDate, CurrencyCode.AUD, BigDecimal.valueOf(41327.28)),
                    new Account("136151648", "AUCurrent938", AccountType.Savings, exampleDate, CurrencyCode.AUD, BigDecimal.valueOf(48928.79)),
                    new Account("453489511", "SGSavings842", AccountType.Savings, exampleDate, CurrencyCode.SGD, BigDecimal.valueOf(72117.53)),
                    new Account("334651897", "AUSavings253", AccountType.Savings, exampleDate, CurrencyCode.AUD, BigDecimal.valueOf(88005.93)),
                    new Account("793445614", "AUCurrent754", AccountType.Current, exampleDate, CurrencyCode.AUD, BigDecimal.valueOf(20588.16)),
                    new Account("768456461", "SGCurrent294", AccountType.Current, exampleDate, CurrencyCode.SGD, BigDecimal.valueOf(5906.55)),
                    new Account("847498496", "AUCurrent591", AccountType.Current, exampleDate, CurrencyCode.AUD, BigDecimal.valueOf(925613.68))
            );
            accountRepository.saveAll(accounts);
            Logger.getAnonymousLogger().info("Account table initialised.");

            transactionService.generateTransactionsOnAccounts(accounts);

        } catch (Exception e) {
            Logger.getAnonymousLogger().info("Account table initialise failed.");
            e.printStackTrace();
        }
    }


    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
