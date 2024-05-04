
import frontEnd.*;
import backEnd.*;

public class Main {
    public static void main(String[] args) {
        //Database.getInstance().createUser("abc", "123456");
        //App.createAccount("abc", "Checking", 0, java.util.Currency.getInstance("USD"));
        //User user = Database.getInstance().getUser("abc");
        //String password = user.getPassword();
        //System.out.println(password);
        mainGUI mainGUI = new mainGUI();
        mainGUI.login.frame.setVisible(true);
    }
}