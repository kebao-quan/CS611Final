import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database {
    // Singleton instance
    private static Database instance = null;
    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Database tables
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    // Generate a random account ID
    private String generateAccountId() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    // Create a new account
    public Account createAccount(double initialBalance) {
        String accountId = generateAccountId();
        Account account = new CheckingAccount(accountId, initialBalance);
        accounts.add(account);
        return account;
    }


}
