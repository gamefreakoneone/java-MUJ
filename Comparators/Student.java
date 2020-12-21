package Comparators;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    int marks;
    String name;

    public Student(int marks, String name){
        super();
        this.marks=marks;
        this.name=name;
    }

    public String toString(){
        return "Student [marks= "+this.marks+", name= "+this.name+"]";
    }

    public int getMarks(){
        return this.marks;
    }

    public void setMarks(int marks){
        this.marks=marks;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    @Override
    public int compareTo(Student obj) {
        // THis is in increasing order
        if(this.marks>obj.marks){
            return 1;
        }
        else if(this.marks<obj.marks){
            return -1;
        }
        return this.name.compareTo(obj.name);
    }
}

class SortByNameThenMarks implements Comparator<Student>{
    public int compare(Student o1, Student o2){
        if(o1.name.equals(o2.name)){
            return o1.marks-o2.marks;
        }else {
            return o1.name.compareTo(o2.name);
        }
    }
}