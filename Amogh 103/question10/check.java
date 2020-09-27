import java.awt.*;
import java.util.Scanner;

public class check {

    public void oddoreven(int sacrifice){
        if(sacrifice%2==0){
            System.out.println("Its even.");
        }else {
            System.out.println("Its odd");
        }
    }

    public static void main(String[] args) {
        check master =new check();
        Scanner input = new Scanner(System.in);
        int sacrifice;
        Boolean check=true;
        while (check==true){
            System.out.println("Give me the number to verify its even or odd:");
            sacrifice = input.nextInt();
            master.oddoreven(sacrifice);
            System.out.println("Want to continue?\ntrue or false");
            check=input.nextBoolean();
        }
    }
}
