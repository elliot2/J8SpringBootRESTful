package codingChallenge.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Account {

    @Id
    private String accountNumber;
    private String accountName;
    private AccountType accountType;
    private Date balanceDate;
    private CurrencyCode currencyCode;
    private BigDecimal openingAvailableBalance;

    public Account() {
    }

    public Account(String accountNumber, String accountName, AccountType accountType, Date balanceDate,
                   CurrencyCode currencyCode, BigDecimal openingAvailableBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate = balanceDate;
        this.currencyCode = currencyCode;
        this.openingAvailableBalance = openingAvailableBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getOpeningAvailableBalance() {
        return openingAvailableBalance;
    }

    public void setOpeningAvailableBalance(BigDecimal openingAvailableBalance) {
        this.openingAvailableBalance = openingAvailableBalance;
    }
}
