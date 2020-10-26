package Assignment3;

public class Hotel {
    private String HotelName;
    private String Address;

    public void display_source(){
        System.out.println("The Hotel Name:: "+this.HotelName+"\nThe destination"+this.Address);
    }

    public Hotel(String Name, String add){
        this.HotelName=Name;
        this.Address=add;
    }

    public String returnName(){
        return this.HotelName;
    }

    public String  returnAddress(){
        return this.Address;
    }
}

class Room{
    int capacity;
    int rent;
    String type;
    String status;
    String checkin;
    String checkout;

    Room(int Capacity, int Rent, String type, String Status, String checkin, String checkout){
        this.capacity=Capacity;
        this.rent=Rent;
        this.type=type;
        this.status=Status;
        this.checkin=checkin;
        this.checkout=checkout;
    }

    public void showStatus(){
        System.out.println("The room is:"+this.status);
    }
}