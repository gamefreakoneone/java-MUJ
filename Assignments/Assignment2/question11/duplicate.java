package question11;

import java.util.Scanner;

public class duplicate {

    void printarr(int[] arr){
        for (int a: arr){
            System.out.printf(" %d ",a);
        }
    }

    void duplicates(int[] arr){
    int[] duplicatearr= new int[(arr.length)/2];
    duplicate master = new duplicate();

    int k=0;
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    duplicatearr[k]=arr[i];
                    k++;
                    continue;
                }
            }
        }

        if (k==0){
            System.out.println("Sorry, no duplicates were found");
        }else {
            System.out.println("Here are the duplicates:\n");
            master.printarr(duplicatearr);
        }
    }

    int[] createarray(){
        Scanner input = new Scanner(System.in);
        int [] arr;
        System.out.println("How big is the array:");
        int size = input.nextInt();
        arr = new int[size];
        System.out.println("Give me the values for the array:");
        for (int i =0; i<arr.length;i++){
            arr[i]=input.nextInt();
        }

        return arr;
    }

    public static void main(String[] args) {
        duplicate master = new duplicate();
        int[] arr = master.createarray();
        master.duplicates(arr);
    }
}
