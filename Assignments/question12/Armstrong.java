import java.util.Scanner;

public class Armstrong {

    public void checkArmstrong(int sacrifice){
        int test=sacrifice;
        int sum=0,inter;
        while (test>0)
        {
            inter=test%10;
            test=test/10;
            sum=sum+(inter*inter*inter);
        }
        if (sum==sacrifice)
        {
            System.out.println("Its an Armstrong number!");
        }else
        {
            System.out.println("It's not an Armstrong number");
        }
    }

    public static void main(String[] args) {
        Armstrong master =new Armstrong();
        Scanner input = new Scanner(System.in);
        System.out.println("Give me the armstrong number:");
        int sacrifice = input.nextInt();
        master.checkArmstrong(sacrifice);
    }
}
