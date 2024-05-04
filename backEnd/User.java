package backEnd;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class User implements Serializable {
    private String userName = "";
    private String password = "";
    private List<Collateral> collaterals = new ArrayList<Collateral>();

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
