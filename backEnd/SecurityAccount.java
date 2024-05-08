package backEnd;


import java.util.Currency;
import java.util.List;
import java.util.ArrayList;


public class SecurityAccount extends Account{
    private static final double TRANSACTION_FEE = 2.0;
    private static final String ACCOUNT_TYPE = "Securities";
    private List<Stock> stocks;

    public SecurityAccount(String username, double initialBalance, Currency currency) {
        super(username, initialBalance, currency);
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount - TRANSACTION_FEE;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount + TRANSACTION_FEE > balance) {
            throw new InsufficientFundsException("Not enough funds.");
        }
        this.balance -= (amount + TRANSACTION_FEE);
    }

    @Override
    public String getAccountType() {
        return ACCOUNT_TYPE;
    }
}
