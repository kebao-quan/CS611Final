package frontEnd;
import backEnd.Account;

public class currentUser {
    private static currentUser myInstance;

    private String username = "";
    private String selectedAccountId;
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

    public String getAccount()
    {
        return selectedAccountId;
    }

    public void setAccount(String account)
    {
        this.selectedAccountId = account;
    }
}
