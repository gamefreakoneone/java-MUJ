package Collections;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("Swift");
        System.out.println(languages);

        languages.add(0, "C++");
        System.out.println(languages.get(1));
        languages.set(0, "Javascript");
        System.out.println(languages.get(0));

        for(String language : languages){
            System.out.println(language);
        }

        Iterator<String> iterate = languages.iterator();
        String name = iterate.next();
        System.out.println(name);

        while (iterate.hasNext()){
            System.out.println(iterate.next());
        }

    }
}
