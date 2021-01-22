package Exams;

public class Profile {
    private static boolean v1;
    private static short s1;
    private static double d1;

    public static void main(String[] args) {
        if(v1 && d1==s1){
            System.out.println("ONE");
        }else if (v1 && d1>s1){
            System.out.println("TWO");
        }else if(v1 && d1<s1){
            System.out.println("THREE");
        }else
            System.out.println("FOUR");
    }
}

