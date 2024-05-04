package backEnd;
import java.util.Currency;
import java.util.List;


/**
 * This class define the method for frontend to interact with the backend.
 *
 * @author Kebao Quan, 
 * @since 2024-04-26
 */
public class App {
    /**
     * Return the user object if the username and password are valid.
     * 
     * @param username The username of the user
     * @param password The password of the user
     * @return The user object if the username and password are valid, null otherwise
     */
    public static User getUserValidate(String username, String password) {
        User user = Database.getInstance().getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public static List<Account> getAccounts(String username) {
        return Database.getInstance().getAccountsByUserID(username);
    }

    /**
     * Create a user with the given username and password.
     * 
     * @param username The username of the user
     * @param password The password of the user
     * @return The user object if the user is created successfully, null otherwise
     */
    public static User createUser(String username, String password) {
        return Database.getInstance().createUser(username, password);
    }

    /**
     * Create an account for the user with the given account type, initial balance and currency.
     * 
     * @param username The username of the user
     * @param accountType The type of the account, e.g. "Savings", "Checking", "Security"
     * @param initialBalance The initial balance of the account
     * @param currency The currency of the account
     */
    public static void createAccount(String username, String accountType, double initialBalance, Currency currency) {
        AccountFactory accountFactory = new AccountFactory();
        Account account = accountFactory.createAccount(accountType, initialBalance, currency);
        if (account == null) {
            System.out.println("Invalid account type.");
            return;
        }
        Database.getInstance().addAccount(username, account);
    }

    /**
     * Deposit the given amount to the account with the given account ID.
     * 
     * @param accountId The ID of the account
     * @param amount The amount to deposit
     */
    public static void deposit(String accountId, double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            return;
        }
        Account account = Database.getInstance().getAccount(accountId);
        Transaction transaction = new DepositTransaction(account, amount);
        Database.getInstance().addTransaction(accountId, transaction);
        transaction.execute();
        Database.persist();
    }


    /**
     * Withdraw the given amount from the account with the given account ID.
     * 
     * @param accountId The ID of the account
     * @param amount The amount to withdraw
     * @throws InsufficientFundsException If the account does not have enough balance to withdraw
     */
    public static void withdraw(String accountId, double amount) throws InsufficientFundsException {
        Account account = Database.getInstance().getAccount(accountId);
        Transaction transaction = new WithdrawalTransaction(account, amount);
        Database.getInstance().addTransaction(account.getAccountId(), transaction);
        transaction.execute();
        Database.persist();
    }


    /**
     * Transfer the given amount from the source account to the destination account.
     * 
     * @param sourceAccountId The ID of the source account
     * @param destinationAccountId The ID of the destination account
     * @param amount The amount to transfer
     * @throws InsufficientFundsException If the source account does not have enough balance to transfer
     */
    public static void transfer(String sourceAccountId, String destinationAccountId, double amount) throws InsufficientFundsException {
        Account sourceAccount = Database.getInstance().getAccount(sourceAccountId);
        Account destinationAccount = Database.getInstance().getAccount(destinationAccountId);
        Transaction transaction = new TransferTransaction(sourceAccount, destinationAccount, amount);
        Database.getInstance().addTransaction(sourceAccountId, transaction);
        Database.getInstance().addTransaction(destinationAccountId, transaction);
        transaction.execute();
        Database.persist();
    }
    

    /**
     * Get the balance of the account with the given account ID.
     * 
     * @param accountId The ID of the account
     * @return The balance of the account. If the account does not exist, return 0.
     */
    public static double getBalance(String accountId) {
        Account account = Database.getInstance().getAccount(accountId);
        return account.getBalance();
    }

}
