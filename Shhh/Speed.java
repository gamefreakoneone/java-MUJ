package Shhh;

import java.util.Scanner;

class MyExceptions extends Exception{
        String message;

        MyExceptions(String msg){
            message = msg;
        }

        public String toString(){
            return ("Exception Occurred: " + message) ;
        }
}


public class Speed {

    public static void main(String[] args) {
        double s1, s2, R;
        int n;
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Enter the values");
            System.out.printf("Minspeed s1: ");
            s1 = input.nextDouble();

            if(s1<=0){
                throw new MyExceptions("Minspeed is less than or equal to zero");
            }
            System.out.println("Maxspeed d2:");
            s2 = input.nextDouble();

            if(s2<=0){
                throw new MyExceptions("Maximum Speed is lesser than or equal to 0");
            }

            System.out.println("Number of speeds: ");
            n=input.nextInt();
            if(n<=1){
                throw new MyExceptions("Number of speeds is less than or equal to one exception");
            }

            R = Math.pow((s2/s1) , ((double) 1 /(n-1)));
            System.out.printf("Geometric Progression R: %f\n",R );

        }
        catch (MyExceptions e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("Done!");
        }
    }

}
