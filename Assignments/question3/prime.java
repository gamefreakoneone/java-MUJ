import java.util.Scanner;

public class prime {
    public void findprime(int base, int position){
    int number, sacrifice , value=0;
    number=1;
    sacrifice=base+1;
    while (number<=position){
        for(int i=2;i<sacrifice;i++){
            value=0;
            if(sacrifice%i==0){
                value=1;
                break;
            }
        }
        if (value==0)
        {
            number=number+1;
        }
        sacrifice+=1;
    }
        System.out.printf("%d is the prime number\n",sacrifice-1);
    }

    public static void main(String[] args) {
        prime starter =new prime();
        System.out.println("Give me the starting number: ");
        Scanner input =new Scanner(System.in);
        int base = input.nextInt();
        System.out.println("Give me the position to be found:");
        int position = input.nextInt();
        starter.findprime(base,position);

    }
}
