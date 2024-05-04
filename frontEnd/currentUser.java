package frontEnd;

public class currentUser {
    private static currentUser myInstance;

    private String username = "";

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
}
