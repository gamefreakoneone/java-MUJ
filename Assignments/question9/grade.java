import java.util.Scanner;

public class grade {

    public void sgrades(){
        System.out.println("Give me the marks:");
        Scanner input = new Scanner(System.in);
        double marks = input.nextDouble();
        if (marks>90){
            System.out.println("The grade is: A+");
        }else if (marks<90 && marks>80){
            System.out.println("The grade is: A");
        }else if (marks<80 && marks>70){
            System.out.println("The grade is: B");
        }else if (marks<70 && marks>60){
            System.out.println("The grade is: C");
        }else if (marks<60 && marks>50){
            System.out.println("The grade is: D");
        }else if (marks<50 && marks>40){
            System.out.println("The grade is: E");
        }else if (marks<40){
            System.out.println("The grade is: F");
        }
    }


    public static void main(String[] args) {
        grade master = new grade();
        Scanner input = new Scanner(System.in);
        boolean tocontinue=true;
        while (tocontinue==true){
            master.sgrades();
            System.out.println("Would you like to continue?\ntrue or false");
            tocontinue = input.nextBoolean();
        }
        System.out.println("Thank you.");
    }

}
