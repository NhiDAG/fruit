package models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import views.Validation;

public class OrderManager {

    Product p = new Product();

    LinkedHashMap<Fruit, Integer> table;
    ArrayList<Order> orderList = new ArrayList<>();
    ArrayList<Fruit> listOfFruit;

    Validation val = new Validation();

    public OrderManager(Product product) {
        this.p = product;
    }

    public OrderManager() {
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void ordering() {
        listOfFruit = p.getList();
        table = new LinkedHashMap<>();
        while (true) {
            int productID = val.getInteger("Enter item's id:");
            Fruit fruit = listOfFruit.get(productID - 1);
            System.out.println("Your selected: " + fruit.getFruitName() + ". Storage: " + fruit.getQuantity());
            val.getValue("");
            int proQuantity = val.getAndValidQuantity("Numbers of fruit you want to buy: ");
            if (val.isEnoughQuantity(fruit, proQuantity)) {
                if (table.containsKey(fruit)) {
                    table.put(listOfFruit.get(productID - 1), table.get(fruit) + proQuantity);
                } else {
                    table.put(listOfFruit.get(productID - 1), proQuantity);
                }
                updateQuantity(fruit);
            } else {
                System.out.println("The quantity you entered exceeds the quantity in stock");
                continue;
            }
            if (!val.askToCheck()) {
                String customer = val.getValue("Enter customer name: ");
                Order order = new Order(customer, table);
                orderList.add(order);
                System.out.println("Thank you!\n");
                return;
            }
        }
    }

    public void showOrder() {
        if (orderList.isEmpty()) {
            System.out.println("Not found data");
        } else {
            for (Order o : orderList) {
                System.out.print(o);
            }
        }
    }

    public void shopping() {
        System.out.println("| ++Item++ | ++Fruit Name++ | ++Origin++ | ++Price++ |");
    }

    public void updateQuantity(Fruit fruit) {
        listOfFruit = p.getList();
        for (Map.Entry<Fruit, Integer> entry : table.entrySet()) {
            int quantityToDeduct = entry.getValue();
            int result = 0;
            if(fruit.equals(entry.getKey())){
                result = fruit.getQuantity()  - quantityToDeduct;
                fruit.setQuantity(result);
            } else{ System.out.println("Error!");}
            return;
        }
    }
}
