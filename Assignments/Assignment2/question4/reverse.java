package question4;

import java.util.Scanner;

public class reverse {
    void printarr(int[] arr){
        for (int a: arr){
            System.out.printf(" %d ",a);
        }
    }

    public static void main(String[] args) {
        reverse master = new reverse();
        Scanner input = new Scanner(System.in);
        int [] arr = new int[10];
        int length = arr.length -1;
        int temp;
        System.out.println("Give me the elements of the array:\n");
        for (int i =0; i<=length;i++){
            arr[i]=input.nextInt();
        }
        System.out.println("The reversed array  is starting now");
        for (int i =0; i<=length/2;i++){
            temp=arr[i];
            arr[i]=arr[length-i];
            arr[length-i]=temp;
        }

        master.printarr(arr);
    }
}
