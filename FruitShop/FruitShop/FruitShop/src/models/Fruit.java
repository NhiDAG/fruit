package models;

public class Fruit {

    protected int fruitID;
    protected String fruitName;
    protected double price;
    protected int quantity;
    protected String origin;

    public Fruit(int fruitID, String fruitName, String origin, double price, int quantity) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public Fruit() {
    }

    public int getFruitID() {
        return fruitID;
    }

    public void setFruitID(int fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return String.format("| %10s | %10s | %10s | %10s |\n", String.format("%-" + (10 + fruitID) / 2 + "s", fruitID),
                String.format("%-" + (10 + fruitName.length()) / 2 + "s", fruitName),
                String.format("%-" + (10 + origin.length()) / 2 + "s", origin),
                String.format("%-" + (10 + String.format("%.2f", price).length()) / 2 + "s", price));
    }

}
