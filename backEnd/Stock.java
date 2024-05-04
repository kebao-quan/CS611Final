package backEnd;
import java.io.Serializable;

public class Stock implements Serializable {
    String symbol = "";
    String name = "";
    double price = 0.0;

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
