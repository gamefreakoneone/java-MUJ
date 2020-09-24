package question2;

import java.util.Scanner;

public class sum {
    int sumofarrays(int [] arr){
        int sum=0;
        for (int a : arr){
            sum=sum+a;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println("Give me the values of the array:");
        Scanner input = new Scanner(System.in);
        sum master = new sum();
        for (int i =0; i<10;i++){
            arr[i]=input.nextInt();
        }
        int sum = master.sumofarrays(arr);
        System.out.println("The sum of array is " + sum);
    }
}
