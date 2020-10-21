public class dump {
    public static void main(String[] args) {
    ABC a1 = new C();// Within heirarchy therfore it works
    a1.show();
    B b1 = (B) a1;
    b1.show();
    }
}

class Box{
    double l,b,h;
    Box (double l, double b,double h){
        this.l=l;
        this.b=b;
        this.h=h;
    }

    boolean isEqual(Box other){
        System.out.println("This is calling Non static:");
        if (this.l==other.l && this.b==other.b && this.h==other.h){
            return true;
        }else return false;
    }

    static boolean isEqual(Box b1, Box b2){
        System.out.println("This is a call to static");
        if (b1.l==b2.l && b1.b==b2.b && b1.h==b2.h){
            return true;
        }else return false;
    }
}
class ABC{
    final int a =10;
    int b;
    double c;
    double d;//Cannot declare final variable without instantiating directly or in the constructor
    ABC(){

    }
    ABC(int x,double c, int d){
        b=x;
        this.c=c;
        this.d=d;
    }

    void show(){
        System.out.println("a="+a);
    }
}

class B extends ABC{
    void show(){
        System.out.println("This is B");
    }
}

class C extends B{
    void show(){
        System.out.println("This is C");
    }
}