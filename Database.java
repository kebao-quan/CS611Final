import java.util.List;
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
    private Map<String, List<Transaction>>  accountTransactions;        // accountId -> List<Transaction>
    private Map<String, Account>            accounts;                   // accountId -> Account
    private Set<Transaction>                transactions;               // List of all transactions
    private Set<Stock>                      stocks;                     // List of all stocks

    private Database() {
        users                   = new HashMap<>();
        userAccounts            = new HashMap<>();
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

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }


    /**
     * Return false if the user already exists
     */
    public User createUser(String userName, String password) {
        if (users.containsKey(userName)) 
            return null;
        User user = new User(userName, password);
        users.put(userName, user);
        persist();
        return user;
    }

    public void addAccount(String username, Account account) {
        List<Account> userAccountList = userAccounts.get(username);
        userAccountList.add(account);
        accounts.put(account.getAccountId(), account);
        persist();
    }

    public void addTransaction(String AccountID, Transaction transaction) {
        List<Transaction> accountTransactionsList = accountTransactions.get(AccountID);
        accountTransactionsList.add(transaction);
        transactions.add(transaction);
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
            System.out.println("Serialized data is saved in database.ser");
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
            System.out.println("Deserialized data is read from database.ser");
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
