import java.util.Scanner;
class FoodOrder {
   
    
    void order(String item) {
        System.out.println("Ordered 1 item: " + item);
    }
   
    void order(String item1, String item2) {
        System.out.println("Ordered 2 items: " + item1 + " and " + item2);
    }
   
    void order(String item, int quantity) {
        System.out.println("Ordered " + quantity + " x " + item);
    }
   
    // 2. METHOD TO BE OVERRIDDEN
    void prepareFood() {
        System.out.println("Preparing food in general kitchen...");
    }
   
    void bill(int amount) {
        System.out.println("Total Bill: Rs." + amount);
    }
}

// Child class 1 - Overrides prepareFood
class Dominos extends FoodOrder {
   
    @Override
    void prepareFood() {  // METHOD OVERRIDING - Same signature, different body
        System.out.println("Preparing Pizza in Dominos style with extra cheese!");
    }
   
    @Override
    void bill(int amount) {
        amount = amount + 40; // delivery charge
        System.out.println("Dominos Bill with delivery: Rs." + amount);
    }
}

// Child class 2 - Overrides prepareFood
class McDonalds extends FoodOrder {
   
    @Override
    void prepareFood() {  // METHOD OVERRIDING
        System.out.println("Preparing Burger and Fries in McDonalds style!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("=== Welcome to Food App ===");
        System.out.println("1. Dominos");
        System.out.println("2. McDonalds");
        System.out.print("Choose restaurant: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
       
        // Runtime Polymorphism - Parent ref, Child object
        FoodOrder order;
       
        if(choice == 1) {
            order = new Dominos();  // Upcasting
        } else {
            order = new McDonalds();
        }
       
        // METHOD OVERRIDING in action
        order.prepareFood();
       
        System.out.print("Enter item name: ");
        String item = sc.nextLine();
       
        // METHOD OVERLOADING in action
        System.out.println("How do you want to order?");
        System.out.println("1. Single item 2. Two items 3. With quantity");
        int opt = sc.nextInt();
       
        if(opt == 1) {
            order.order(item);
            order.bill(200);
        } else if(opt == 2) {
            sc.nextLine();
            System.out.print("Enter second item: ");
            String item2 = sc.nextLine();
            order.order(item, item2);
            order.bill(350);
        } else {
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            order.order(item, qty);
            order.bill(200 * qty);
        }
       
        sc.close();
    }
}