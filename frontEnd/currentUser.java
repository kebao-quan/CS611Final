/*
 * class for keeping track of the current user
 */
package frontEnd;

import backEnd.Stock;

public class currentUser {
    private static currentUser myInstance;

    private String username = "";
    private String selectedAccountId;
    private Stock selectedStock;

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

    public Stock getStock()
    {
        return selectedStock;
    }

    public void setStock(Stock stock)
    {
        this.selectedStock = stock;
    }
}
