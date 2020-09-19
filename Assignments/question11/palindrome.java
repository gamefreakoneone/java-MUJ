import java.util.Scanner;

public class palindrome {

    public void checkpalindrome(int sacrifice){
        int newnum=0,inter=sacrifice,left;
        while (inter>0){
            left=inter%10;
            newnum=(newnum*10)+left;
            inter=inter/10;
        }
        if (newnum==sacrifice){
            System.out.println("Its a pallindrome!");
        }else {
            System.out.println("Its not a pallindrome!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Give me the number to check if its a pallindrome or not:");
        Scanner input = new Scanner(System.in);
        int sacrifice=input.nextInt();
        palindrome master=new palindrome();
        master.checkpalindrome(sacrifice);
    }
}
