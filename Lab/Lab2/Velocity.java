package Lab.Lab2;

import java.util.Scanner;
import java.lang.Math;

class MyException extends Exception{
    /*
     * MyException class. Accept error message through constructor
     */
    String message;
    MyException(String msg) {
        message = msg;
    }
    public String toString(){
        return ("Exception Occurred: " + message) ;
    }
}

public class Velocity
{
    public static void main(String[] args) {
        double s1, s2, R;
        int n;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter the values");
            System.out.print("Minspeed, s1 : ");
            s1 = sc.nextDouble();
            if(s1 <= 0){
                throw new MyException("Minimum speed less than or equal to zero exception");
            }

            System.out.print("Maxspeed, s2 : ");
            s2 = sc.nextDouble();
            if(s2 <= 0){
                throw new MyException("Maximum speed less than or equal to zero exception");
            }

            System.out.print("number of speeds, n : ");
            n = sc.nextInt();
            if(n <= 1){
                throw new MyException("Number of speed less than or equal to one exception");
            }

            R = Math.pow((s2 / s1), ((double) 1 / (n - 1)));
            System.out.printf("Geometric progression, R : %f\n", R);



        }
        catch(MyException exp){
            System.out.println(exp) ;
        }catch(Exception exp){
            System.out.println(exp);
        }finally{
            System.out.println("Program ending..");
        }
    }
}