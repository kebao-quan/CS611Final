/**
 * Stock class that represents a stock object with a symbol, name, and price.
 * This class is used to store stock information.
 */


package backEnd;

import java.io.Serializable;

public class Stock implements Serializable {
    String symbol = "";
    String name = "";
    double price = 0.0;
    int quantity = 1;

    double boughtPrice = 0.0;

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

    public int getQuantity() {
        return quantity;
    }

    public double getBoughtPrice() {
        return boughtPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBoughtPrice(double boughtPrice) {
        this.boughtPrice = boughtPrice;
    }

    public double calculateProfit() {
        return (price - boughtPrice) * quantity;
    }

    @Override
    public String toString() {
        return "Stock Symbol: " + symbol + "  " +
                "Stock Name: " + name + "  " +
                "Stock Price: " + price + "  " +
                "Stock Quantity: " + quantity + "  " +
                "Bought Price: " + boughtPrice + "  " +
                "Unrealized Profit: " + calculateProfit();
    }
}
