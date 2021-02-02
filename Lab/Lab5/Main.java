package Lab.Lab5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

interface Movable{
    public void moveUp();
    //Complete the implementation
    public void moveDown();
    public void moveLeft();
    public void moveRight();
}

class MovablePoint implements Movable , Comparator<MovablePoint>{
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    MovablePoint(int x, int y, int xspeed, int yspeed){
        this.x = x;
        this.y = y;
        this.xSpeed=xspeed;
        this.ySpeed=yspeed;
    }

    @Override
    public void moveUp(){
        y-=ySpeed;
    }

    @Override
    public void moveDown() {
        y+=ySpeed;
    }

    @Override
    public void moveLeft() {
        x-=xSpeed;
    }

    @Override
    public void moveRight() {
        x+=xSpeed;
    }

    public String toString(){
        return String.format(" Point x:%1$d, y:2$d  has xSpeed:%3$d and ySpeed:%4$d",x,y,xSpeed,ySpeed);
    }


    @Override
    public int compare(MovablePoint o1, MovablePoint o2) {
        if((o1.x>o2.x) && (o1.y>o2.y) ){
            return -1;
        }else{
            return 1;
        }
    }
}

class MovableCircle implements Movable, Comparator<MovableCircle>{
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
        super();
        center = new MovablePoint(x,y,xSpeed,ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.y-= center.ySpeed;
    }

    @Override
    public void moveDown() {
        center.y+=center.ySpeed;
    }

    @Override
    public void moveLeft() {
        center.x-=center.xSpeed;
    }

    @Override
    public void moveRight() {
        center.x+=center.xSpeed;
    }

    public String toString() {
        return String.format("Circle at point %1$s has radius : %2$d", center.toString(), radius);
    }

    @Override
    public int compare(MovableCircle o1, MovableCircle o2) {
        if(o1.radius>o2.radius){
            return -1;
        }else if(o1.radius<o2.radius){
            return 1;
        }else if(o1.radius==o2.radius){
            MovablePoint temp1 = o1.center;
            MovablePoint temp2 = o2.center;
            if((temp1.x>temp2.x) && (temp1.y>temp2.y) ){
                return -1;
            }else{
                return 1;
            }
        }else if(o1.center.x==o2.center.x){
            return 0;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Movable m1 = new MovablePoint(5, 6, 10,11); // upcast

        System.out.println(m1);

        m1.moveLeft();

        System.out.println(m1);

        Movable m2 = new MovableCircle(2, 1, 2, 3,20); // upcast

        System.out.println(m2);

        m2.moveRight();

        System.out.println(m2);

    }
}
