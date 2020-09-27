import java.util.Scanner;

public class switching {

    public void switchitup(){
        Scanner input = new Scanner(System.in);
        System.out.println("Give the two numbers a and b:");
        float a = input.nextFloat();
        float b = input.nextFloat();
        System.out.println("Give the arithmetic operator in between a and b:");
        char in = input.next().charAt(0);

        switch (in){
            case '+':
                System.out.printf(" %f + %f = %f \n",a,b,(a+b));
                break;
            case '-':
                System.out.printf(" %f - %f = %f \n",a,b,(a-b));
                break;
            case '*':
                System.out.printf(" %f * %f = %f \n",a,b,(a*b));
                break;
            case '/':
                System.out.printf(" %f / %f = %f \n",a,b,(a/b));
                break;
            case '%':
                System.out.printf(" The remainder of %f / %f is %f \n",a,b,(a%b));
                break;
            default:
                System.out.println(" Invalid operator");
                break;
        }

    }

    public static void main(String[] args) {
        int tocontinue=1;
        switching master = new switching();
        Scanner input = new Scanner(System.in);
        while (tocontinue!=0){
            master.switchitup();
            System.out.println("Do you want to exit?\nEnter 0 to exit or enter any other number ");
            tocontinue=input.nextInt();
        }

    }
}
