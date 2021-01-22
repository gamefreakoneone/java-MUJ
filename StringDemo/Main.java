package StringDemo;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("Geeks for geeks!");
        StringBuffer s2 = new StringBuffer(2);
        int p = s2.length();
        int q = s2.capacity();

        System.out.println(s1);

        s2.append("check this out");

        System.out.println(s2);

        s2.delete(6,10);

        System.out.println(s2);

        s2.insert(6, "my ass");

        System.out.println(s2);

        s2.deleteCharAt(4);

        System.out.println(s2);

        s2.replace(0,5,"Rip and Tear ");
        System.out.println(s2);
        s2.reverse();
        System.out.println(s2.capacity());
        s2.ensureCapacity(40);
        System.out.println(s2.capacity());
    }
}
