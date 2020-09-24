package question6;

import java.util.Scanner;

public class status {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i =0,trooms=0,unoccupied=0;
        int[][] rooms = new int[10][];
        while (i<10){
            System.out.printf("How many rooms do you want in %d floor:\n",i+1);
            int broom = input.nextInt();
            trooms+=broom;
            int[] inter = new int[broom];
            for(int j=0;j<broom;j++){
                System.out.println("Is room"+ (j+1)+" free");
                System.out.println("(Insert 1 for filled and 0 for free)");
                inter[j]=input.nextInt();
                if(inter[j]==0){
                    unoccupied++;
                }
            }
            rooms[i]=inter;
            i++;
        }

        for (i = 0; i < rooms.length; ++i) {
            System.out.println("____________");
            System.out.println("Floor: "+(i+1));
            for(int j = 0; j < rooms[i].length; ++j) {
                System.out.printf(" %d ",rooms[i][j]);
            }
            System.out.println("");
        }

        System.out.println("Total rooms: " + trooms + "\nRooms filled: "+ (trooms-unoccupied)+"\nUnoccupied rooms: "+unoccupied);
    }

}
