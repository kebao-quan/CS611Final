/**
 * User class
 * This class represents a user of the application. It contains the username, password, debt, and a list of collaterals.
 */


package backEnd;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class User implements Serializable {
    private String userName = "";
    private String password = "";
    private double debt = 0;
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

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public List<Collateral> getCollaterals() {
        return collaterals;
    }

    public void addCollateral(Collateral collateral) {
        collaterals.add(collateral);
    }
    
    private String printCollaterals() {
        String result = "";
        for (Collateral collateral : collaterals) {
            result += collateral.toString() + "  ";
        }
        return result;
    }

    @Override
    public String toString() {
        return "Username: " + userName + "   " +
                "Debt: " + debt + "   " +
                "Collaterals: " + printCollaterals();
    }
}
