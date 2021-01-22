package Exams.Question3;

import java.util.Scanner;

public class Cricketer {
    String name;
    String team;
    int age;

    Cricketer(String name){
        this.name=name;
    }

    Cricketer(String name, String team){
        this.name=name;
        this.team=team;
    }

    Cricketer(String name, String team, int age){
        this.name=name;
        this.team=team;
        this.age=age;
    }

    public String toString(){
        return "This is " + name + " of " + team;
    }
}

class Test{
    public static void main(String[] args) {
        Cricketer[][] Teams= new Cricketer[2][];

        for(int i=0;i<2;i++){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number of players on the team:");
            int num = input.nextInt();
            Teams[i]=new Cricketer[num];
            for (int j=0;j<num;j++){
                System.out.println("What is the name of the player?\n");
                String sentence = input.next();
                System.out.println("Which team?");
                String team = input.next();
                System.out.println("What is the age of the player?");
                int p_age = input.nextInt();
                Teams[i][j] = new Cricketer(sentence,team,p_age);
            }
        }

        for (int i=0;i<2;i++){
            for (int j=0;j<Teams[i].length;j++){
                System.out.println(Teams[i][j]);
            }
        }
    }
}
