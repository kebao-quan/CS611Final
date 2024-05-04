package backEnd;
import java.io.Serializable;

public class Collateral implements Serializable{
    String name = "";
    double value = 0.0;

    public Collateral(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public String toString() {
        return name + " - " + value;
    }
}
