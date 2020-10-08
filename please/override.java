package please;

class A{
    void show(){
        System.out.println("THis is A");
    }
}

class B extends A{
    void show(){
        System.out.println("This is B");
    }
}

public class override {
    public static void main(String[] args) {
        A a1 = new A();
        a1.show();
        a1 = new B();
        a1.show();
    }
}
