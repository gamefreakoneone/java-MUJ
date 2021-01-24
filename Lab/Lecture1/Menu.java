package Lab.Lecture1;

import java.util.Random;
import java.util.Scanner;

class item_detail

{

    int price;

    // Create an array to keep detail of the ingredient used in an item
    String[] details;

    String name;

    int id;

//    static int total_order=0;

    item_detail(String name) /*create a constructor to initialize the class variable, make use of variable length arguments for input of ingredient*/

    {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        this.name=name;
        System.out.println("Give me the price of the item:");
        this.price= input.nextInt();
//        this.price = rand.nextInt(2000);
        System.out.println("Give me the id of the item:");
        this.id = input.nextInt();
        System.out.println("How many details would you like to add?");
        int size = input.nextInt();
//        int size =1;
        details = new String[size];
        System.out.println("Alright give me the details:");
        for (int i=0;i<size;i++){
            details[i]=input.next();
        }
    }


}

// end of class

class person

{

    String name;

    double mobile_no;

    int order_no;

// create an array to keep track of items the person order during his/her visit, a person can visit restaurant multiple time

    item_detail[] order_history = new item_detail[100];

    person(String name,double mobile_no)

    {

        this.name=name;

        this.mobile_no=mobile_no;

        order_no=0;

    }

    void placeOrder(item_detail[] a) // this method will accept the item_detail for one order and store the detail in order history

    {
        int size = a.length;
        if (size==1){
            order_history[order_no]=a[0];
            order_no++;
            return;
        }
        for (Lab.Lecture1.item_detail item : a) {  //for (int i = 0;i<size;i++)
            order_history[order_no] = item;
            order_no++;
        }
    }

    void displayHistory()

    {
        // this method will traverse array and display the detail of order the person has placed
//        for (int i=0;i<order_no-1;i++){
//            System.out.println("Name: " +order_history[i].name);
//            System.out.println("Price: " +order_history[i].price);
//            System.out.println("Id: " +order_history[i].id);
//            System.out.println("The details:");
//            for (String i_detail: order_history[i].details){
//                System.out.println(i_detail);
//            }
//        }
        try {
            for (item_detail order : this.order_history) {
                System.out.println("Item: " + order.name + " Price:" + order.price);
            }
        }catch (Exception E){}
    }

    int return_Bill(){
        int amount = 0;
        try{
        for (item_detail order : this.order_history) {
            amount += order.price;
        }}
        catch (Exception E){}
        return amount;
    }
}

// end of class

class Restaurant {

    // create an array to store the item serve by the restaurant
    item_detail[] items;

    // create an array that will hold the detail of the customer that visit restaurant
    person[] customer_history = new person[100];

    int customer_index = 0;


    Restaurant() // this constructor will initialize the menu of the restaurant
    {
        System.out.println("Give me the size of the menu:");
        String name;
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
//        int size = 5;
        items = new item_detail[size];
        for (int i = 0; i < size; i++) {
            System.out.println("What is the name of the product?");
            System.out.println(" ");
            name = input.next();
            items[i] = new item_detail(name);
        }
    }

    void addcustomer(person p) // this method will add customer to the restaurant

    {
        customer_history[customer_index] = p;
        customer_index++;
    }

    void placeOrder(person p) // this method will accept person object and update the order placed by the person in his/her order history
    {
        int index;
        this.DisplayMenu();
        Scanner input = new Scanner(System.in);
        System.out.println("How many items would you like to order:");
        int size = input.nextInt();
        item_detail[] order = new item_detail[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Which items labeled according to the menu would you like to order:\n");
            index = input.nextInt();
            order[i] = items[index - 1];
        }
        p.placeOrder(order);
    }

    void DisplayPersonHistory(person p) // this method will display the detail of the order placed by the person

    {
        System.out.println("The order history is:");
        p.displayHistory();
    }

    void DisplayMenu() // this method will display the item served by the restaurant

    {
        int i = 1;
        for (item_detail item : items) {
            System.out.println(i + " Name: " + item.name);
            System.out.println("  Price: " + item.price);
            System.out.println("  Id: " + item.id);
            System.out.println("  The details:");
            i++;
            for (String i_detail : item.details) {
                System.out.println("  " + i_detail);
            }
        }
    }

    void DisplayBill(person p) // this method will display the bill of a person

    {
        System.out.println("Displaying bill:");
        int amount = 0;
        try {
            for (item_detail order : p.order_history) {
                System.out.println("Item: " + order.name + " Price:" + order.price);
                amount += order.price;
            }
        }catch (Exception E){}
        System.out.println("Total: " + amount);
    }



    void totalrevenue() // this method will display the total revenue of the restaurant

    {
        int revenue = 0;
        System.out.println("Calculating total revenue:\n");
        try {
            for (person p : customer_history) {
                revenue += p.return_Bill();
            }
        }catch(Exception E){}


        System.out.println("The total revenue is: "+revenue);
    }

    void displayPremiumCustomer()// this method will display the customer who has spent more than 1000 rs in the restaurant

    {
        try{
        for (person p: customer_history){
            if(p.return_Bill()>1000){
                System.out.println(p.name);
            }
        }}catch (Exception e){}
    }
}
//end of class

// create a main class that will display option to user for viewing menu of the restaurant.
public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Restaurant KFC = new Restaurant();
        boolean leave = true;
        String name;
        double p_number;
        int option;
        System.out.println("Hello! Lets get started shall we!");
        while (leave){
            int i=0,choice;
            System.out.println("What are we going to do ?");
            System.out.println("1.)Add a customer");
            System.out.println("2.)Place an Order");
            System.out.println("3.)Premium User");
            System.out.println("4.)Bill of customer");
            System.out.println("5.)Total Revenue");
            System.out.println("6.)Customer History");
            System.out.println("7.)Exit!");
            option=input.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Give me the name and phone number of the customer:");
                    name = input.next();
                    System.out.println(" ");
                    p_number = input.nextDouble();
                    person new_customer = new person(name, p_number);
                    KFC.addcustomer(new_customer);
                }
                case 2 -> {
                    System.out.println("Which customer:");
                    for (person p : KFC.customer_history) {
                        try {
                            System.out.println((i + 1) + ". " + p.name);
                            i++;
                        } catch (Exception E) {
                        }
                    }
                    choice = input.nextInt();
                    KFC.placeOrder(KFC.customer_history[choice - 1]);
                }
                case 3 -> KFC.displayPremiumCustomer();
                case 4 -> {
                    System.out.println("Which customer:");
                    try {
                        for (person p : KFC.customer_history) {
                            System.out.println((i + 1) + ".)" + p.name);
                            i++;
                        }
                    } catch (Exception e) {
                    }
                    choice = input.nextInt();
                    KFC.DisplayBill(KFC.customer_history[choice - 1]);
                }
                case 5 -> KFC.totalrevenue();
                case 6 -> {
                    System.out.println("Which customer:");
                    try {
                        for (person p : KFC.customer_history) {
                            System.out.println((i + 1) + ".)" + p.name);
                            i++;
                        }
                    } catch (Exception e) {
                    }
                    choice = input.nextInt();
                    KFC.DisplayPersonHistory(KFC.customer_history[choice - 1]);
                }
                case 7 -> leave = false;
            }
            System.out.println("__________________");
        }
        System.out.println("Thanks!");
    }
}
