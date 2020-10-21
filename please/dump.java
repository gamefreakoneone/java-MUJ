package please;

class c{
public static void show(){
    System.out.println("Hello! This show in C");
}
}

class d extends c{

    public static void show(){
        System.out.println("This is in D");
    }
    void display(){
        System.out.println("This is display!");
    }

}


public class dump {
    public static void main(String[] args) {
        c c1 = new c();
        c1.show();
        c1=new d();
        c1.show();
    }
}
