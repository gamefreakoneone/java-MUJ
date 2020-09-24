package question10;

import java.util.Scanner;

public class bus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] busseats = new String[10][];
        System.out.println("There are ten seats in the bus. As we iterate through the seats, input 0 for unfilled and 1 for filled");
        for(int i =0;i<10;i++){
            System.out.println("Is seat "+(i+1)+" free");
            int value =input.nextInt();
            if(value==1){
                String[] inter = new String[2];
                System.out.println("Give me the name");
                inter[0]=input.next();
                System.out.println("Give me the destination: ");
                inter[1]=input.next();
                busseats[i]=inter;
            }
            else{
                String[] inter = {"empty"};
                busseats[i]=inter;
            }
        }

        System.out.printf("Seat   Name Destination\n");

        for(int i = 0;i<10;i++){
            System.out.printf("Seat %d: ",i+1);
            for(int j=0;j<busseats[i].length;j++){
                System.out.printf(" %s ", busseats[i][j]);
            }
            System.out.println("");
        }

    }
}
