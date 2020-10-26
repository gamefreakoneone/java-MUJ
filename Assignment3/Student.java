package Assignment3;

public class Student {
    private String name;
    private double marks[] = new double [3];
    private double percentage;

    void displayName(){
        System.out.println("The name of the student is :"+ this.name);
    }

    public Student(String name){
        this.name=name;
    }

    public void Percentage(){
        this.percentage=this.marks[0]+this.marks[1]+this.marks[2];
        this.percentage = (this.percentage/60)*100;
    }
}
