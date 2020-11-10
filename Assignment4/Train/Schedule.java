package Assignment4.Train;

public class Schedule {
    private String Station;
    private String Arrival;
    private String Departure;

    Schedule(String Station, String arrival, String Departure){
        this.Station=Station;
        this.Arrival=arrival;
        this.Departure=Departure;
    }

    public String getArrival(){
        return this.Arrival;
    }

    public String getDeparture(){
        return this.Departure;
    }
}
