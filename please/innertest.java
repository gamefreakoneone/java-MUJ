package please;

interface X{
    int sum(int a, int b);
    int mult(int a, int b);
}

public class innertest {
    public static void main(String[] args) {
        X x1 = new X(){
            public int sum(int a,int b){
                return a+b;
            }
            public  int mult(int a,int b){
                return a*b;
            }
        };

        System.out.println(x1.sum(3,5));
        System.out.println(x1.mult(3,5));
    }
}
