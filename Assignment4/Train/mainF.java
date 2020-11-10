package Assignment4.Train;

import java.util.Scanner;

public class mainF {

    public static void main(String[] args) {
        Station[] stations = new Station[10];
        for(int j=0;j<10;j++){
            stations[j]=new Station();
        }
        System.out.println("Starting the Train program:");
        int cont =0;
        int stat=0;
        while(cont == 0) {
            System.out.printf("\n");
            System.out.println("Do you want to start off with:\n1.Creating a station\n2.Check out the stations created.\n3.Add a train to a station\n4.Delete a train from a station\n5.Exit");
            Scanner input = new Scanner(System.in);
            String stringinput;
            int checkint, choice;
            checkint = input.nextInt();
            switch (checkint) {
                case 1:
                    System.out.println("Which Line is this going to be for?\n1.Western\n2.Eastern\n3.Harbour. (Input the number)");
                    choice = input.nextInt();
                    stations[stat].setLine(choice);
                    System.out.println("What is the name of the station?\n");
                    stringinput=input.nextLine();
                    stringinput=input.nextLine();
                    stations[stat].setName(stringinput);
                    System.out.println("Station has been created!");
                    stat=stat+1;
                    break;
                case 2:
                    for (int i=0;stations[i].getName()!=null;i++){
                        stations[i].display();
                        System.out.println("\n*************\n");
                    }
                    break;
                case 3:
                    System.out.println("Which station will it be: ");
                    for(int k=0;stations[k].getName()!=null;k++){
                        System.out.println( (k+1)+". "+stations[k].getName());
                    }
                    choice=input.nextInt();
                    choice=choice-1;
                    stations[choice].add();
                    break;
                case 4:
                    System.out.println("Which station will it be?");
                    for(int k=0;stations[k].getName()!=null;k++){
                        System.out.println( (k+1)+". "+stations[k].getName());
                    }
                    choice=input.nextInt();
                    choice = choice-1;
                    stations[choice].delete();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    cont=1;
            }
        }


    }
}
