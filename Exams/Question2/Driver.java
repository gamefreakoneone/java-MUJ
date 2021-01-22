package Exams.Question2;

import java.util.List;

abstract class circle{
    private int radius;

    circle(int radius){
        this.radius=radius;
    }

    abstract double area();

    int getRadius(){
        return radius;
    }
}

class cylinder extends circle implements Comparable{ // Implementing the Comparable interface
    private int height;

    cylinder(int radius, int height){
        super(radius);  // We need to call the super constructor
        this.height=height;
    }

    double area(){
        return 2*3.14*getRadius()*height; // Has to be getRadius() since radius is private
    }

    @Override
    public int compareTo(Object o) {
        cylinder c1 = (cylinder) o;
        if(this.area()<c1.area()){
            return -1;
        }else{
            return 1;
        }
    }
}

public class Driver {
    public static void main(String[] args) {
        circle list[] = new circle[5];
        list[0]= new cylinder(15,3);
        list[1]= new cylinder(32,3);
        list[2]= new cylinder(1,33);
        list[3]= new cylinder(5,36);
        list[4]= new cylinder(4,38);

        java.util.Arrays.sort(list);

        for (circle c: list){
            System.out.println(c.area());
        }
    }
}
