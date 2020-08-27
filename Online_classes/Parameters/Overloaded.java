class Triangle{
    private double a;
    private double b;
    private double c;

    Triangle(double side){
        this.a=this.b=this.c=side;
        displaySides();
    }

    Triangle(double side1, double side2){
        this.a=this.b=side1;
        this.c=side2;
        displaySides();
    }

    Triangle(double side1, double side2,double side3){
        this.a=side1;
        this.b=side2;
        this.c=side3;
        displaySides();
    }

    public void displaySides() {
        System.out.println("Side 1="+this.a);
        System.out.println("Side 2="+this.b);
        System.out.println("Side 3="+this.c);
    }
}

public class Overloaded {
    public static void main(String[] args) {
        Triangle T1=new Triangle(10);
        System.out.println(" ");
        Triangle T2 =new Triangle(20, 30);
        System.out.println(" ");
        Triangle T3=new Triangle(10, 6, 8);
    }
}