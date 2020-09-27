import java.util.Scanner;

public class primefind {
    public void prime(int hrange){
        int value=0;
        for(int i=2;i<hrange;i++){
            value=0;
            if(hrange%i==0){
                value=1;
                break;
            }
        }
        if (value==0)
        {
            System.out.printf("%d is a prime number\n",hrange);
        }
        else {
            System.out.printf("%d is not a prime number\n",hrange);
        }

    }

    public static void main(String[] args) {
        System.out.println("Give me the number to verify whether or not it's prime:");
        Scanner input=new Scanner(System.in);
        int hrange = input.nextInt();
        primefind master = new primefind();
        master.prime(hrange);
    }
}
