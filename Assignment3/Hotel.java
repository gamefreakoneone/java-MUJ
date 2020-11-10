package Assignment3;

public class Hotel extends Room{
    private String HotelName;
    private String Address;

    public void display_source(){
        System.out.println("The Hotel Name:: "+this.HotelName+"\nThe destination"+this.Address);
    }

    public Hotel(int Capacity, int Rent, String type, String Status, String checkin, String checkout,String Name, String add){
        super(Capacity, Rent,type,Status,checkin,checkout);
        this.HotelName=Name;
        this.Address=add;
    }

    public void checkIn(){
        if (this.status=="Occupied"){
            System.out.println("The room is occupied!");
            return;
        }else{
            System.out.println("Checking in room: ");
        }
    }

    public String returnName(){
        return this.HotelName;
    }

    public String  returnAddress(){
        return this.Address;
    }

    public static void main(String[] args) {
        
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