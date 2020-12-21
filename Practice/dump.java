package Practice;


public class dump {
    public static void main(String[] args) {

    }
}

class A{
    private int a;
    protected static int b=20;
    A(int a){
        this.a=a;
    }
    void print(){
        System.out.println("a="+a);
    }

    void show(){
        int x =10;
        class B{
            private int b;

            B(int b){
                this.b=b;
            }

            void display(){
                System.out.println("a="+a);
                System.out.println("b="+b);
                System.out.println("x="+x);
            }
        }
    }

    public static void display(){
        System.out.println("b="+b);
    }


}

