public class NewClass{
    int x;
    int y;
    private NewClass(int a, int b){
        x=a;
        y=b;
    }
    NewClass(int a){
        this(a,a);
        x=a;
    }

        public static void main(String[] args) {
            NewClass obj = new NewClass(5,5);
            System.out.print(obj.x);
            System.out.println(obj.x);
        }

    }

/**
 * driver
 */
class driver {

    
}