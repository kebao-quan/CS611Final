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

    /**
     * Get the accounts of the user with the given username.
     * 
     * @param username The username of the user
     * @return The list of accounts of the user
     */
    public static List<Account> getAccounts(String username) {
        return Database.getInstance().getAccountsByUserID(username);
    }

    public static List<Account> getAllAccounts() {
        return Database.getInstance().getAllAccounts();
    }

    public static List<User> getAllUsers() {
        return Database.getInstance().getAllUsers();
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
    public static String createAccount(String username, String accountType, double initialBalance, Currency currency) {
        AccountFactory accountFactory = new AccountFactory();
        Account account = accountFactory.createAccount(username, accountType, initialBalance, currency);
        if (account == null) {
            System.out.println("Invalid account type.");
            return null;
        }
        Database.getInstance().addAccount(username, account);
        return account.getAccountId();
    }

    /**
     * Deposit the given amount to the account with the given account ID.
     * 
     * @param accountId The ID of the account
     * @param amount The amount to deposit
     */
    public static void deposit(String accountId, double amount) {
        if (amount <= 0) {
            return;
        }
        Transaction transaction = new DepositTransaction(accountId, amount);
        Database.getInstance().addTransaction(accountId, transaction);
        try {
            transaction.execute();
        } catch (InsufficientFundsException e) {
            // This should not happen
        }
    }


    /**
     * Withdraw the given amount from the account with the given account ID.
     * 
     * @param accountId The ID of the account
     * @param amount The amount to withdraw
     * @throws InsufficientFundsException If the account does not have enough balance to withdraw
     */
    public static void withdraw(String accountId, double amount) throws InsufficientFundsException {
        Transaction transaction = new WithdrawalTransaction(accountId, amount);
        Database.getInstance().addTransaction(accountId, transaction);
        transaction.execute();
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
        Transaction transaction = new TransferTransaction(sourceAccountId, destinationAccountId, amount);
        Database.getInstance().addTransaction(sourceAccountId, transaction);
        Database.getInstance().addTransaction(destinationAccountId, transaction);
        transaction.execute();
        Database.persist();
    }

    /**
     * Loan the given amount to the account with the given account ID.
     * 
     * @param accountId The ID of the account
     * @param amount The amount to loan
     * @param collat The collateral of the loan
     * @param collatValue The value of the collateral
     */
    public static void loan(String accountId, double amount, String collat, double collatValue) {
        Transaction transaction = new LoanTransaction(accountId, amount, collat, collatValue);
        Database.getInstance().addTransaction(accountId, transaction);
        try {
            transaction.execute();
        } catch ( InsufficientFundsException e ) {
            // This should not happen
        }
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
