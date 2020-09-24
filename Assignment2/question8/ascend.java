package question8;

import java.util.Scanner;

public class ascend {

    void printarr(int[] arr){
        for (int a: arr){
            System.out.printf(" %d ",a);
        }
    }

    int[] reorder(int [] arr){
        int length =arr.length;
        int inter;
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                if(arr[j]>arr[i]){
                    inter = arr[j];
                    arr[j] = arr[i];
                    arr[i]=inter;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ascend master = new ascend();
        System.out.println("Give me the size of the array");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i =0; i<5;i++){
            arr[i]=input.nextInt();
        }
        arr = master.reorder(arr);
        master.printarr(arr);
    }
}
