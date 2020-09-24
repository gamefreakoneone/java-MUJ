package question9;

import java.util.Scanner;

public class search {

    void searching(int [] arr){
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to search for?");
        int searchterm =  input.nextInt();
        for (int i=0;i<arr.length;i++){
            if(arr[i]==searchterm){
                System.out.printf("Found %d at %d position",searchterm,i+1);
                return;
            }
        }
        System.out.println("Couldn't find the value, try again later! ");
        return;
    }

    int[] createarray(){
        Scanner input = new Scanner(System.in);
        int [] arr;
        System.out.println("How big is the array:");
        int size = input.nextInt();
        arr = new int[size];
        System.out.println("Give me the values for the array:");
        for (int i =0; i<5;i++){
            arr[i]=input.nextInt();
        }

        return arr;
    }

    public static void main(String[] args) {
        search master = new search();
        int [] arr =master.createarray();
        master.searching(arr);
    }
}
