import java.util.Scanner;

public class ctof {

    public void tofahrenheit(){
        System.out.println("Give me the temperature in Celsius:");
        Scanner input =new Scanner(System.in);
        double celsius = input.nextDouble();
        double fahrenheit = (celsius*1.8)+32;
        System.out.println("The temperature in Fahrenheit is "+fahrenheit+" F");
    }

    public void tocelcius(){
        System.out.println("Give me the temperature in Fahrenheit");
        Scanner input =new Scanner(System.in);
        double fahrenheit = input.nextDouble();
        double celsius = (fahrenheit-32)/1.8;
        System.out.println("The temperature in Celsius is "+celsius+" C");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ctof master = new ctof();
        boolean econtinue = true ;
        while(econtinue==true){
            System.out.println("What do you want to convert from?\n@ Celsius -> 1\n@ Fahrenheit -> 2");
            int value = input.nextInt();
            if (value==1){
                master.tofahrenheit();
            }else if(value==2){
                master.tocelcius();
            }else {
                System.out.println("Give correct input");
                continue;
            }
            System.out.println("Do you want to continue? true or false");
            econtinue=input.nextBoolean();
        }
        System.out.println("Thank you!");
    }
}
