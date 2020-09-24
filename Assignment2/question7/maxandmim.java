package question7;

import java.util.Scanner;

public class maxandmim {
    int [] arr(){
        Scanner input = new Scanner(System.in);
        int[] arr;
        System.out.println("How large should the array be?\n");
        int size = input.nextInt();
        arr = new int[size];
        System.out.println("Give me the values of the array:");
        for (int i =0;i<size;i++){
            arr[i]=input.nextInt();
        }
        return arr;
    }

    void mandm(int[] arr){
        int max,min;
        max=min=arr[0];
        for (int a:arr){
            if(a>max){
                max=a;
                continue;
            }
            if(a<min){
                min=a;
                continue;
            }
        }
        System.out.println("The maximum value is "+max);
        System.out.println("The minimum value is "+ min);
    }

    public static void main(String[] args) {
        maxandmim master = new maxandmim();
        Scanner input = new Scanner(System.in);
        int []arr = master.arr();
        master.mandm(arr);
    }
}
