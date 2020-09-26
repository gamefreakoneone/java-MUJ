package classes;

import java.util.Scanner;

public class box {
    double height;
    double ID;
    double width;

    public static void change(int a, int b){
        a=20;
        b=40;
    }
    public static void main(String[] args) {
        box box1 = new box();
        System.out.println("Give me the ID of the box:\n");
        Scanner input = new Scanner(System.in);
        box1.ID=input.nextDouble();
        int a=1,b=2;
        change(a,b);
        System.out.println(a+" "+b);
    }
}
