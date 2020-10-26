package Assignment3;

public class Box {
    private double height;
    private double length;
    private double width;

    void displayDimension(){
        System.out.println("Height: "+this.height +" Width: "+this.width +" Length: "+this.length);
    }

    public Box(int h, int l, int w){
        this.height=h;
        this.width=w;
        this.length=l;
    }

    double Volume(){
        return this.length*this.width*this.height;
    }

    public double getHeight(){
        return this.height;
    }

    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
    }
}
