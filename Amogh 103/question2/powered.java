import java.util.Scanner;


public class powered {

    public void powerup(int base, int upper){
        int value=base;
        for(int i=1;i<upper;i++){
            value=value*base;
        }
        System.out.println("The answer is "+value);
    }

    public static void main(String[] args) {
        powered object = new powered();
        Scanner input =new Scanner(System.in);
        System.out.println("Give me the value of x and value of the for x^y: ");
        int base = input.nextInt();
        int upper=input.nextInt();
        object.powerup(base,upper);
    }
}
