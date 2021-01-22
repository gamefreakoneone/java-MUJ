package Lab.Lecture1;

import java.util.Scanner;

class item_detail

{

    int price;

    // Create an array to keep detail of the ingredient used in an item
    String[] details;

    String name;

    int id;

    static int total_order=0;

    item_detail(String name) /*create a constructor to initialize the class variable, make use of variable length arguments for input of ingredient*/

    {
        Scanner input = new Scanner(System.in);
        this.name=name;
        System.out.println("Give me the price of the item:");
        int i_price= input.nextInt();
        this.price=i_price;
        System.out.println("Give me the id of the item:");
        int i_id = input.nextInt();
        this.id=i_id;
        System.out.println("How many details would you like to add?");
        int size = input.nextInt();
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

    int mobile_no;

    int order_no=0;

// create an array to keep track of items the person order during his/her visit, a person can visit restaurant multiple time

    item_detail[] order_history;

    person(String name,int mobile_no)

    {

        this.name=name;

        this.mobile_no=mobile_no;

        order_no=0;

    }

    void placeOrder(item_detail[] a) // this method will accept the item_detail for one order and store the detail in order history

    {
        int size = a.length;
        if (size==0){
            order_history[order_no]=a[0];
            order_no++;
        }
        for (int i = 0;i<size;i++){
            order_history[order_no] = a[i];
            order_no++;
        }
    }

    void displayHistory()

    {
        // this method will traverse array and display the detail of order the person has placed
        for (int i=0;i<order_no;i++){
            System.out.println("Name: " +order_history[i].name);
            System.out.println("Price: " +order_history[i].price);
            System.out.println("Id: " +order_history[i].id);
            System.out.println("The details:");
            for (String i_detail: order_history[i].details){
                System.out.println(i_detail);
            }
        }
    }

    int return_Bill(){
        int amount = 0;
        for (item_detail order : this.order_history) {
            amount += order.price;
        }
        return amount;
    }
}

// end of class

class Restaurant {

    // create an array to store the item serve by the restaurant
    item_detail[] items;

    // create an array that will hold the detail of the customer that visit restaurant
    person[] customer_history;

    int customer_index = 0;

    person[] premium_customer;
    int premium_index = 0;

    Restaurant() // this constructor will initialize the menu of the restaurant
    {
        System.out.println("Give me the size of the menu:");
        String name;
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        items = new item_detail[size];
        for (int i = 0; i < size; i++) {
            System.out.println("What is the name of the product?");
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
            for (String i_detail : item.details) {
                System.out.println("  " + i_detail);
            }
        }
    }

    void DisplayBill(person p) // this method will display the bill of a person

    {
        System.out.println("Displaying bill:");
        int amount = 0;
        for (item_detail order : p.order_history) {
            System.out.println("Item: " + order.name + " Price:" + order.price);
            amount += order.price;
            ;
        }
        System.out.println("Total: " + amount);
    }



    void totalrevenue() // this method will display the total revenue of the restaurant

    {
        int revenue=0;
        System.out.println("Calculating total revenue:\n");
        for (person p : customer_history) {
            revenue+=p.return_Bill();
        }
        System.out.println("The total revenue is: ");
    }

    void displayPremiumCustomer()// this method will display the customer who has spent more than 1000 rs in the restaurant

    {
        for (person p: customer_history){
            if(p.return_Bill()>1000){
                System.out.println(p.name);
            }
        }

    }
}
//end of class

// create a main class that will display option to user for viewing menu of the restaurant.
public class Menu {
    
}

// view total revenue of the restaurant

// view order history of a person and current bill of a person, a person is identified by his/her mobile number

// view premium customer

// place order

//add customer


