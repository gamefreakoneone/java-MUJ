package Online_classes;

public class august26 {
    public static void main(final String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        System.out.println(s1.getID());
        System.out.println(s1.name);
        s2.setID(5);
        s3.setName('n');
        

        System.out.println(s1.getID());
        System.out.println(s1.getName());

    }
}
class Student{
    private int id; //Its a private package
    char name; //Its a protected package.
    void setID(final int i){
        id=i;
    }

    Student(){
        System.out.println("Default constructor is called!");
        id=69;
        name='a';
    }

    void setName(final char n){
        name=n;
    }
    int getID(){
        return id;
    }
    char getName(){
        return name;
    }
}
