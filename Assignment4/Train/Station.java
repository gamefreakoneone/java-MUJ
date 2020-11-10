package Assignment4.Train;

import java.util.Scanner;

public class Station {
    private String Name;
    private String SLine;
    Train[] trains = new Train[6];
    maintenance[] mtrains = new maintenance[5];
    local[] ltrains = new local[5];
    private int status=0;
    private int lstatus=0;
    private int mstatus=0;

    public void setName(String Name) {
        this.Name = Name;
    }
    public String getName(){
        return this.Name;
    }

    public void setLine(int F) {
        if (F == 1) {
            SLine = "Western";
        } else if (F == 2) {
            SLine = "Eastern";
        } else if (F == 3) {
            SLine = "Harbour";
        } else {
            System.out.println("Invalid input");
            System.exit(0);
        }
    }

    public void add() {
        Scanner input = new Scanner(System.in);
        String inputc;
        if (status < 6) {
            int inter;
            System.out.println("Is the train going to be local or maintenance?\n1.Local\n2.Maintenance");
            inter=input.nextInt();
            if(inter==1){
                ltrains[lstatus]=new local();
                System.out.println("Give me the name and train number");
                inputc=input.nextLine();
                inputc=input.nextLine();
                ltrains[lstatus].setName(inputc);

                inputc=input.nextLine();
                ltrains[lstatus].setTrainNo(inputc);
                ltrains[lstatus].setLinename(this.SLine);
                System.out.println("Give me the schedule of the train: Arrival and Departure");
                String arrival = input.nextLine();
                String departure = input.nextLine();
                ltrains[lstatus].setPersonal(this.Name,arrival,departure);
                System.out.println("The train has been added to Station:"+Name);
                lstatus=lstatus+1;
            }else{
                mtrains[mstatus]=new maintenance();
                System.out.println("Give me the name and train number");
                inputc=input.nextLine();
                inputc=input.nextLine();
                mtrains[mstatus].setName(inputc);
//                inputc=input.nextLine();
                inputc=input.nextLine();
                mtrains[mstatus].setTrainNo(inputc);
                mtrains[mstatus].setLinename(this.SLine);
                System.out.println("The train has been added to Station:"+Name);
                mstatus=mstatus+1;
            }
//            inter = noTrains();

        }else {
            System.out.println("No more Trains can be added to this Station.");
        }
        status=status+1;
    }

    public void delete() {
        System.out.println("Starting the deletion program!");
        Scanner input = new Scanner(System.in);
        int index;
        if(this.status==0){
            System.out.println("Its already empty");
            return;
        }else {
            System.out.println("Do you want to delete local trains (1) or maintenance trains (2):");
            index=input.nextInt();
            if(index==1){
                for (int i = 0; i < lstatus; i++) {
                    System.out.println(i + 1 + ". " + ltrains[i].getName());
                }
                System.out.println("Which train do you want to delete?");
                index = input.nextInt();
                index = index - 1;
                if (index == 3) {
                    ltrains[3] = null;
                }

                for (int i = index; i < 3; i++) {
                    ltrains[i] = ltrains[i + 1];
                }
                lstatus=lstatus-1;
            }else if(index==2){
                for (int i = 0; i < mstatus; i++) {
                    System.out.println(i + 1 + ". " + mtrains[i].getName());
                }
                System.out.println("Which train do you want to delete?");
                index = input.nextInt();
                index = index - 1;
                if (index == 3) {
                    mtrains[3] = null;
                }

                for (int i = index; i < 4; i++) {
                    mtrains[i] = mtrains[i + 1];
                }

                mstatus=mstatus-1;
            }
//            for (int i = 0; i < status; i++) {
//                System.out.println(i + 1 + ". " + trains[i].getName());
//            }
//            System.out.println("Which train do you want to delete?");
//            index = input.nextInt();
//            index = index - 1;
//            if (index == 4) {
//                trains[4] = null;
//            }
//
//            for (int i = index; i < 5; i++) {
//                trains[i] = trains[i + 1];
//            }
        }
        System.out.println("Done the deletion!");
        status=status-1;
    }

    public int noTrains() {
        int number = 0;
        for (Train inter : trains) {
          if(inter.getName()==null){
              break;
          }else{
              number=number+1;
          }
        }
        return number;
    }
    public void display(){
        System.out.println("The trains of Station '"+this.Name +"' are:");
        if(this.status==0){
            System.out.println("Empty!");
        }else {
            System.out.println("Local Trains are:");
            if(this.lstatus==0){
                System.out.println("Empty!");
            }else{
                for (int i = 0; i < this.lstatus; i++) {
                    ltrains[i].Display();
                    System.out.println("_________________________________");
                }
            }
            System.out.println("Maintenance Trains are:");
            if(this.mstatus==0){
                System.out.println("Empty!");
            }else{
                for (int i = 0; i < this.mstatus; i++) {
                    mtrains[i].Display();
                    System.out.println("_________________________________");
                }
            }


        }

    }
}


