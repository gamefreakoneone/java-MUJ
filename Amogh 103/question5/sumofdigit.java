import java.util.Scanner;

public class sumofdigit {
    public void sumofdigits(int inNumber){
        int sum=0, place=inNumber;
        int inter;
        while (place>0){
            inter=place%10;
            sum=sum+inter;
            place=place/10;
        }
        System.out.println("The sum of digits is: "+sum);
    }

    public static void main(String[] args) {
        sumofdigit master = new sumofdigit();
        Scanner input = new Scanner(System.in);
        System.out.println("Give me the number:\n");
        int inNumber = input.nextInt();
        master.sumofdigits(inNumber);
    }
}
