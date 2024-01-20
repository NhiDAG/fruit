
package controller;

import models.OrderManager;
import models.Product;
import views.Menu;

public class ShopManager extends Menu<String>{
    
    static String[] menu = {"Create Fruit", "View Orders", "Shopping(for buyers) ", "Exit"};
    Product listOfFruit = new Product();
    OrderManager list;

    public ShopManager(){
        super("FRUIT SHOP SYSTEM", menu);
        list = new OrderManager(listOfFruit);
    }

    public ShopManager(String t, String[] c){
        super(t, c);
    }
    
    @Override
    public void execute(int n) {
        switch(n){
            case 1: 
                listOfFruit.createFruit();
                break;
            case 2:
                list.showOrder();
                break;
            case 3:
                list.shopping();
                listOfFruit.display();
                list.ordering();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
    

    public static void main(String[] args) {
        ShopManager s = new ShopManager();
        s.run();
    }  
}