/**
 * Database.java
 * This class is the database of the application, it stores all the users, accounts, transactions and stocks.
 * It is a singleton class, and the instance can be accessed by calling Database.getInstance().
 */

package backEnd;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Database implements Serializable {
    // Singleton instance
    private static Database instance = null;

    // Database tables
    private Map<String, User>               users;                      // username -> User
    private Map<String, List<Account>>      userAccounts;               // username -> List<Account>
    private Map<String, List<Stock>>        accountStocks;              // accountId -> List<Stock>
    private Map<String, List<Transaction>>  accountTransactions;        // accountId -> List<Transaction>
    private Map<String, Account>            accounts;                   // accountId -> Account
    private Set<Transaction>                transactions;               // List of all transactions
    private Set<Stock>                      stocks;                     // List of all stocks

    private Database() {
        users                   = new HashMap<>();
        userAccounts            = new HashMap<>();
        accountStocks           = new HashMap<>();
        accountTransactions     = new HashMap<>();
        accounts                = new HashMap<>();
        transactions            = new HashSet<>();
        stocks                  = new HashSet<>();
    }

    /**
     *  Always use this method to get the current singleton instance, note that old reference might be refering to an outdated database.
     *  If the database is not read from the file, a new instance will be created.
     */
    public static Database getInstance() {
        if (!readPersist() && instance == null) {
            instance = new Database();
        }
        return instance;
    }


    // Getters
    public User getUser(String userName) {
        return users.get(userName);
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        for (User user : users.values()) {
            allUsers.add(user);
        }
        return allUsers;
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public List<Transaction> getTransactions(String username) {
        List<Transaction> userTransactions = new ArrayList<>();
        
        List<Account> userAccountList = userAccounts.get(username);
        for (Account account : userAccountList) {
            List<Transaction> TransactionsList = accountTransactions.get(account.getAccountId());
            
            for (Transaction transaction : TransactionsList) {
                userTransactions.add(transaction);
            }
        }
        return userTransactions;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public List<Stock> getStocks(String accountId) {
        List<Stock> userStocksList = accountStocks.get(accountId);
        return userStocksList;
    }

    public void accountBuyStock(String accountId, Stock stock, int quantity) {
        List<Stock> stocksList = accountStocks.get(accountId);

        // create a copy of stock
        Stock stock_copy = new Stock(stock.getSymbol(), stock.getName(), stock.getPrice());
        stock_copy.setQuantity(quantity);
        stocksList.add(stock_copy);
        persist();
    }

    public List<Account> getAccountsByUserID(String username) {
        return userAccounts.get(username);
    }

    public List<Account> getAllAccounts() {
        List<Account> allAccounts = new ArrayList<>();
        for (Account account : accounts.values()) {
            allAccounts.add(account);
        }
        return allAccounts;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> allTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            allTransactions.add(transaction);
        }
        return allTransactions;
    }


    /**
     * Return false if the user already exists
     */
    public User createUser(String userName, String password) {
        if (users.containsKey(userName)) 
            return null;
        User user = new User(userName, password);
        users.put(userName, user);

        List<Account> userAccountList = new ArrayList<>();
        userAccounts.put(userName, userAccountList);
        persist();
        return user;
    }

    public void addAccount(String username, Account account) {
        List<Account> userAccountList = userAccounts.get(username);
        if (userAccountList == null) {
            userAccountList = new ArrayList<>();
            userAccounts.put(username, userAccountList);
        }
        userAccountList.add(account);
        accounts.put(account.getAccountId(), account);
        
        List<Transaction> accountTransactionsList = new ArrayList<>();
        accountTransactions.put(account.getAccountId(), accountTransactionsList);
        

        persist();
    }

    public void addTransaction(String AccountID, Transaction transaction) {
        List<Transaction> accountTransactionsList = accountTransactions.get(AccountID);
        if (accountTransactionsList == null) {
            accountTransactionsList = new ArrayList<>();
            accountTransactions.put(AccountID, accountTransactionsList);
        }
        accountTransactionsList.add(transaction);
        transactions.add(transaction);
        persist();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
        persist();
    }

    /*
     * persist() and readPersist() methods are used to serialize and deserialize the database
     */
    public static boolean persist() {
        try {
            // Serialize the database
            FileOutputStream fileOut = new FileOutputStream("data/database.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Database.instance);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException i) {
            i.printStackTrace();
        }
        return false;
    }

    public static boolean readPersist() {
        try {
            // Deserialize the database
            FileInputStream fileIn = new FileInputStream("data/database.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Database db = (Database) in.readObject();
            Database.instance = db;
            in.close();
            fileIn.close();
            return true;
        } catch(FileNotFoundException f) {
            System.out.println("Database file not found");
            return false;
        } catch (ClassNotFoundException c) {
            System.out.println("Database class not found");
            return false;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        } 
    }
}
