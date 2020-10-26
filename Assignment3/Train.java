package Assignment3;

public class Train {
    private String source;
    private String destination;

    public void display_source(){
        System.out.println("The source: "+this.source+"\nThe destination"+this.destination);
    }

    public Train(String Source, String Destination){
        this.source=Source;
        this.destination=Destination;
    }

    public String getSource(){
        return this.source;
    }

    public String getDestination(){
        return this.destination;
    }
}
