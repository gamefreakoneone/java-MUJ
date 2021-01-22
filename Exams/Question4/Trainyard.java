package Exams.Question4;
import java.util.*;

public class Trainyard {
    public static void main(String[] args) {
        train t = new train("Hyderabad","Jaipur",1234,3);
        train.coach c = t.new coach();
    }
}

class train {
    String source, destination;
    int train_no, coaches;
    coach c[];


    train(String source, String destination, int train_no, int coaches) {
        this.source = source;
        this.destination = destination;
        this.train_no = train_no;
        this.coaches = coaches;
        for(int i =0;i<10;i++){
            c[i]=new coach();
        }
    }

    public void display(){
        System.out.println("Train Number:"+train_no);
        System.out.println("Source:"+source);
        System.out.println("Destination:"+destination);
        System.out.println("Number of coaches:"+coaches);
        for(int i=0;i<coaches;i++){
            c[i].display();
        }
    }


    class coach {
        seat s[];
        int coachID;
        public void display(){
            System.out.println("Coach Id"+coachID);
        }

        coach(){
            System.out.println("Enter Coach ID");
            Scanner input = new Scanner(System.in);
            coachID=input.nextInt();
            System.out.println("Enter the number of seats:");
            int seats = input.nextInt();
            s=new seat[seats];
            for (int i=0;i<10;i++){
                s[i]=new seat(i+1);
            }
        }

        class seat{
            int seat_number;
            boolean status;
            seat(int seat_number){
                this.seat_number=seat_number;
            }
        }
    }
}