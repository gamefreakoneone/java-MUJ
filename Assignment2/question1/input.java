package question1;

import java.util.Scanner;

public class input {

    void printarr(int[] arr){
        for (int a: arr){
            System.out.printf(" %d ",a);
        }
    }

    public static void main(String[] args) {
        input master = new input();
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[10];
        for (int i =0 ; i<10;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("");
        master.printarr(arr);
    }
}
