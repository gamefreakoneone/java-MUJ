
import java.util.Scanner;

public class fibonacci {

    public void getNumber(int n){
        int num1=0, num2=1;
        if(n==1){
            System.out.println("The fibonacci number is 0");
            return;
        }else if (n==2){
            System.out.println("The fibonacci number is 1");
            return;
        }
        int thisnum;
        for (int i=3;i<=n;i++){
            thisnum=num1+num2;
            num1=num2;
            num2=thisnum;
            if(i==n){
                System.out.printf("The fibonacci number is %d",thisnum);
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        fibonacci start =new fibonacci();
        Scanner inputnumber = new Scanner(System.in);
        System.out.println("Give me the position of the number:");
        int n = inputnumber.nextInt();
        start.getNumber(n);
    }
}
