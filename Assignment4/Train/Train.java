package Assignment4.Train;

public class Train {
    private String Name;
    private String TrainNo;
    private String Linename;

    public void setName(String Name){
        this.Name=Name;
    }

    public String getName(){
        return this.Name;
    }

    public void setTrainNo(String Number){
        this.TrainNo=Number;
    }

    public String getTrainNo(){
        return this.TrainNo;
    }

    public  void setLinename(String Line){
        this.Linename=Line;
    }

    public String getLinename(){
    return this.Linename;
    }

    public void Display(){
        System.out.println("The name of the train is: "+ getName() +"\nThe Train Number is: "+ getTrainNo()+ "\nThe Line of the train is: "+ getLinename());
    }
}

class local extends Train{
    Schedule personal;

    public void setPersonal(String Station, String Arrival, String Departure){
        personal = new Schedule(Station,Arrival,Departure);
    }

    public void Display(){
        System.out.println("The name of the train is: "+ getName() +"\nThe Train Number is: "+ getTrainNo()+ "\nThe Line of the train is: "+ getLinename()+"\nThe Arrival time of the train is: "+personal.getArrival()+"\nThe Departure time of the train is "+personal.getDeparture());
    }
}

class maintenance extends Train{

}