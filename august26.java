public class august26 {
    public static void main(String[] args) {
        Student s =new Student();
        System.out.println(s.getID());
        System.out.println(s.name);
        s.setID(5);
        s.setName('n');
    
        
        System.out.println(s.getID());
        System.out.println(s.getName());
        }
}

class Student{
    private int id; //Its a private package
    char name; //Its a protected package.
    void setID(int i){
        id=i;
    }
    void setName(char n){
        name=n;
    }
    int getID(){
        return id;
    }
    char getName(){
        return name;
    }
}