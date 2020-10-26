package Assignment3;

public class Car {
    private double Mileage;

    void displayMileage(){
        System.out.println("Mileage: " + this.Mileage);
    }

    public Car(double Mileage){
        this.Mileage=Mileage;
    }

    double returnMileage(){
        return this.Mileage;
    }
}
