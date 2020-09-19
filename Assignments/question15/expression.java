public class expression {

    public static void main(String[] args) {
    System.out.println("Expression 1:\nbyte a=10;\n" +
            "a=a+10;");
    byte a =10;
    a= (byte) (a+10);
    System.out.println("This is fixed by writing a= (byte) (a+10);\n");
    System.out.println("Expression 2:\nshort b=15;\n" +
            "int c=b/3.0;");
        short b=15;
        int c= (int) (b/3.0);
    System.out.println("This is fixed by writing:int c= (int) (b/3.0);\n");
    System.out.println("Expression3:\ndouble a=12.9;\n" +
            "float b= (float)a/3.5;");
        double i=12.9;
        float j= (float) ((float)i/3.5);
    System.out.println("This can be fixed by assigning new variables:double i=12.9;\n" +
            "        float j= (float) ((float)i/3.5);");
    }

}
