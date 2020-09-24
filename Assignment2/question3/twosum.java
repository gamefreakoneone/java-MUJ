package question3;

import java.util.Scanner;

public class twosum {

    int[] sumoftwo(int [] arr1, int [] arr2){
        int[] arr3 = new int[5];
        for (int i=0;i<5;i++){
            arr3[i]=arr1[i]+arr2[i];
        }

        return arr3;
    }

    void printarr(int[] arr){
        for (int a: arr){
            System.out.printf(" %d ",a);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        twosum master = new twosum();
        int [] arr1 = new int [5];
        int [] arr2 = new int [5];
        System.out.println("Give me the first 5 elements of the first arrays");
        for (int i =0; i<5;i++){
            arr1[i]=input.nextInt();
        }
        System.out.println("Give me the first 5 elements of the second arrays");
        for (int i =0; i<5;i++){
            arr2[i]=input.nextInt();
        }
        int [] arr3 = master.sumoftwo(arr1,arr2);
        master.printarr(arr3);
    }
}
