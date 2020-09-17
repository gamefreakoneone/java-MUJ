package Online_classes.Boxing;

public class autoboxing {
    public static void main(String[] args) {
        Integer i =30; //It is a class here ot a primitive type. A reper type is a collection of primitive types.
        int j=20; // it is a primitive time.
        String s ="20";
        Integer l =new Integer(s);
        Integer ii = new  Integer(30); //this is the same as line 5. This line is technically executed in the background. This is known as boxing.
        int k = i.intValue();
        int kk=i;
    }

}
