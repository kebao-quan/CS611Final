package frontEnd;
import backEnd.Account;

public class currentUser {
    private static currentUser myInstance;

    private String username = "";
    private Account selectedAccount;
    private currentUser()
    {

    }

    public static currentUser getInstance()
    {
        if (myInstance == null) {
            myInstance = new currentUser();
         }
   
         return myInstance;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String name)
    {
        this.username = name;
    }

    public Account getAccount()
    {
        return selectedAccount;
    }

    public void setAccount(Account account)
    {
        this.selectedAccount= account;
    }
}
