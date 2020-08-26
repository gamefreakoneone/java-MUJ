public class main{
    // instance field
    int A;
    float F;
    char C;

    //methods
    void setA(int a){
        A=a;
    }

    int getA(){
        return A;
    }

    public static void main(String args[]) {
        main obj = new main(); //Tis a constructor
        System.out.println(obj.A);
    }
}