package Online_classes.Parameters;

class A {
    private int a;
    private int b;

    A(int a, int b){
        this.a=a;//Here this refer to the object you are calling on which you are calling
        this.b=b;
    }

    public void displayValues(){
        System.out.println("a="+a);
        System.out.println("a="+b);
    }
}


public class Parameterized{
public static void main(String[] args) { // Dont forget to add the String[] args
    A a1=new A(20,40);
    a1.displayValues();
}

}