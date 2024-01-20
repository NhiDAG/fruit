package  models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order{
    
    protected String customer;
    LinkedHashMap<Fruit,Integer> orderTable;
    Fruit fruit = new Fruit();

    public Order(String customer, LinkedHashMap<Fruit,Integer> orderTable) {
        this.customer = customer;
        this.orderTable = orderTable;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LinkedHashMap<Fruit, Integer> getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(LinkedHashMap<Fruit, Integer> orderTable) {
        this.orderTable = orderTable;
    }
    
    public Double calculateAmount(int quantity, double price){
        return (price*quantity);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Customer: " + customer + "\n" + 
                "| Product | Quantity | Price | Amount |\n");
        Fruit f = new Fruit();
        int i = 0;
        double total = 0;
        for(Map.Entry<Fruit, Integer> entry : orderTable.entrySet()){
            f = entry.getKey();
            i = entry.getValue();
            result.append("   ").append(f.getFruitName()).append(" \t").append(i).append(" \t")
                .append(f.getPrice()).append("$ \t").append(calculateAmount(i, f.getPrice())).append("$ \t\n");
                total += calculateAmount(i, f.getPrice());}
        result.append("Total: ").append(total).append("$\n");
        return result.toString();
    }
}