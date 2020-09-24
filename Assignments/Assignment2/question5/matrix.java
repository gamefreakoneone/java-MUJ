package question5;

import java.util.Scanner;

public class matrix {

    void display(int[][] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.printf(" %d ",arr[i][j]);
            }
            System.out.println("");
        }
    }

    int[][] multiply(int[][] arr1,int i1,int j1, int[][] arr2, int i2,int j2){
        int[][] narr = new int [i1][j2];
        for (int i =0;i<i1;i++){
            for(int j=0;j<j2;j++){
                narr[i][j]=0;
                for (int k =0; k < j1;k++){
                    narr[i][j]+=arr1[i][k]*arr2[k][j];
                }
            }
        }
        return narr;
    }

    public static void main(String[] args) {
        matrix master = new matrix();
        Scanner input = new Scanner(System.in);
        int [][] arr1;
        int [][] arr2;

        System.out.println("How many rows and column does the first array have:");

        int i1=input.nextInt();
        int j1 =input.nextInt();
        arr1=new int[i1][j1];
        System.out.println("How many rows and column does the second array have:");
        int i2=input.nextInt();
        int j2=input.nextInt();
        arr2=new int[i2][j2];
        if(j1!=i2){
            System.out.println("The given matrices wont be able to multiple!");
            return;
        }
        int[][] arr3 = new int [i1][j2];
        System.out.println("Give me the values of the first array:");

        for(int i=0;i<arr1.length;i++){
            for (int j=0;j<arr1[i].length;j++){
                arr1[i][j]=input.nextInt();
            }
        }
        System.out.println("The first array!");
        master.display(arr1);

        System.out.println("Give me the values of the second array:");

        for(int i=0;i<arr2.length;i++){
            for (int j=0;j<arr2[i].length;j++){
                arr2[i][j]=input.nextInt();
            }
        }

        System.out.println("The second array");
        master.display(arr2);

        arr3 = master.multiply(arr1,i1,j1,arr2,i2,j2);
        System.out.println("The final array:\n");
        master.display(arr3);
    }
}
