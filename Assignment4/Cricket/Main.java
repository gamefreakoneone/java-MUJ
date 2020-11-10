package Assignment4.Cricket;

import java.util.Scanner;

class Main {

    static Team[] teams = new Team[3];

    static int getTeamChoice() {
        int index;
        Scanner scan = new Scanner(System.in);
        System.out.println("--- Select Team ---");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + teams[i].getTeamName());
        }
        index = scan.nextInt();
        index -= 1;
        if (index > 2 || index < 0) {
            System.out.println("Invalid Input");
            System.exit(0);
        }
        return index;
    }

    static public void initPlayers(T20Team t) {
        for (int i = 0; i < 11; i++) {
            t.players[i] = new T20Player();
        }
    }

    public static void main(String[] args) {
        int choice;
        String var;
        String stringInput;
        int intInput;
        int switchChoice;
        Scanner scan = new Scanner(System.in);

        int team1Index;
        int team2Index;
        String team1Name;
        String team2Name;
        String winner = "null";

        boolean isTeam1InstanceT20 = false;
        boolean isTeam2InstanceT20;

        System.out.println("Create 3 teams\n");

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter team format (Enter '1' for T20 and '2' for ODI): ");
            intInput = scan.nextInt();
            if (intInput > 2 || intInput < 1) {
                System.out.println("Invalid Input");
                System.exit(0);
            }
            if (intInput == 1) {
                teams[i] = new T20Team();
                teams[i].initTeamObject();
            } else {
                teams[i] = new ODITeam();
                teams[i].initTeamObject();
            } // to clear screen
            var = scan.nextLine();
            System.out.println("Enter team name: ");
            stringInput = scan.nextLine();
            teams[i].setTeamName(stringInput);

        }

        while (true) {
            System.out.println(
                    "----------------------------------\n1. Add Player\n2. Delete Player\n3. Display Team Details\n4. Create match\n5. Display matches of team\n ----------------------------------\n");
            switchChoice = scan.nextInt();

            switch (switchChoice) {
                case 1:
                    intInput = getTeamChoice();
                    teams[intInput].addPlayer();
                    break;

                case 2:
                    intInput = getTeamChoice();
                    teams[intInput].deletePlayer();
                    break;
                case 3:
                    intInput = getTeamChoice();
                    System.out.println("--- Details ---");
                    System.out.println("Name: " + teams[intInput].getTeamName());
                    System.out.println("Matches Played: " + teams[intInput].getNumOfMatches());
                    System.out.println("Players: ");
                    teams[intInput].displayPlayers();
                    break;
                case 4:
                    System.out.println("Select Team 1: ");
                    intInput = getTeamChoice();
                    team1Index = intInput;
                    team1Name = teams[intInput].getTeamName();
                    if(teams[intInput] instanceof T20Team) {
                        isTeam1InstanceT20 = true;
                    }
                    if(teams[intInput].getNumOfMatches() == 3) {
                        System.out.println("Matches full.");
                        break;
                    }
                    while (true) {
                        System.out.println("Select Team 2: ");
                        intInput = getTeamChoice();
                        team2Index = intInput;
                        team2Name = teams[intInput].getTeamName();
                        if(teams[intInput] instanceof T20Team) {
                            isTeam2InstanceT20 = true;
                        }
                        else{
                            isTeam2InstanceT20 = false;
                        }
                        if (team1Name != team2Name && isTeam1InstanceT20 == isTeam2InstanceT20) {
                            if(teams[intInput].getNumOfMatches() == 3) {
                                System.out.println("Matches full.");
                                continue;
                            }
                            break;
                        }
                        System.out.println("Teams are same or Teams have diffent format.");
                    }
                    System.out.println("Select Winner: ");
                    System.out.println("1. "+team1Name+"\n2. "+team2Name);
                    intInput = scan.nextInt();
                    if(intInput == 1) {
                        winner = team1Name;
                    }
                    else if(intInput == 2) {
                        winner = team2Name;
                    }
                    else {
                        System.out.println("Invalid Input");
                        System.exit(0);
                    }
                    teams[team1Index].matches[teams[team1Index].getNumOfMatches()] = new Match(team1Name, team2Name, winner);
                    teams[team2Index].matches[teams[team2Index].getNumOfMatches()] = new Match(team1Name, team2Name, winner);
                    break;
                case 5:
                    intInput = getTeamChoice();
                    teams[intInput].displayMatches();
                    break;

                default:
                    System.out.println("Invalid Input");
                    System.exit(0);
                    break;
            }
        }
    }
}
abstract class Team {
    String teamName;
    Match[] matches = new Match[3];

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getNumOfMatches() {
        int length = 0;
        for (Match match : matches) {
            if (match != null)
                length += 1;
        }
        return length;
    }

    abstract public void addPlayer();

    abstract public void deletePlayer();

    abstract public int getNumOfPlayers();

    abstract public void displayPlayers();

    abstract public void initTeamObject();

    public void displayMatches() {
        for (int i = 0; i < this.getNumOfMatches(); i++) {
            System.out.println("--- Match " + (i + 1) + " ---");
            matches[i].getMatchDetails();
        }
    }

}

class T20Team extends Team {
    T20Player[] players = new T20Player[11];

    public void initTeamObject() {
        for (int i = 0; i < 11; i++) {
            players[i] = new T20Player();
        }
    }

    public void addPlayer() {

        String stringInput;
        int intInput;
        float floatInput;
        int currentNumOfPlayers;
        Scanner scan = new Scanner(System.in);
        if (getNumOfPlayers() != 11) {
            currentNumOfPlayers = getNumOfPlayers();
            System.out.println("Enter player name and jersey number: ");
            stringInput = scan.nextLine();
            intInput = scan.nextInt();
            players[currentNumOfPlayers].setPlayerName(stringInput);
            players[currentNumOfPlayers].setJerseyNumber(intInput);
            players[currentNumOfPlayers].setTeamName(this.getTeamName());
            System.out.println("Enter number of thirties and strike rate: ");
            intInput = scan.nextInt();
            floatInput = scan.nextFloat();
            players[currentNumOfPlayers].setNumOfThirties(intInput);
            players[currentNumOfPlayers].setStrikeRate(floatInput);
        } else {
            System.out.println("Team is full.");
        }
    }

    public void deletePlayer() {
        int index;
        Scanner scan = new Scanner(System.in);
        System.out.println("Select player to delete");
        this.displayPlayers();
        index = scan.nextInt() - 1;
        players[index] = null;
        if (index == 10) {
            players[index] = null;
            return;
        }
        for (int i = index; i < 10; i++) {
            players[i] = players[i + 1];
        }
        System.out.println("Successfully deleted player.");
    }

    public int getNumOfPlayers() {
        int length = 0;
        for (T20Player player : players) {
            if (player.getPlayerName() != null)
                length += 1;
        }
        return length;
    }

    public void displayPlayers() {
        for (int i = 0; i < getNumOfPlayers(); i++) {
            System.out.println((i + 1) + ". " + players[i].getPlayerName() + " (" + players[i].getJerseyNumber() + ")");
        }
    }
}

class ODITeam extends Team {
    ODIPlayer[] players = new ODIPlayer[11];

    public void initTeamObject() {

        for (int i = 0; i < 11; i++) {
            players[i] = new ODIPlayer();
        }


    }

    public void addPlayer() {
        String stringInput;
        int intInput;
        int currentNumOfPlayers;
        Scanner scan = new Scanner(System.in);
        if (getNumOfPlayers() != 11) {
            currentNumOfPlayers = getNumOfPlayers();
            System.out.println("Enter player name and jersey number: ");
            stringInput = scan.nextLine();
            intInput = scan.nextInt();
            System.out.println(intInput);
            players[currentNumOfPlayers].setPlayerName(stringInput);
            players[currentNumOfPlayers].setJerseyNumber(intInput);
            players[currentNumOfPlayers].setTeamName(this.getTeamName());
            System.out.println("Enter number of fifties and centuries: ");
            intInput = scan.nextInt();
            players[currentNumOfPlayers].setNumOfFifties(intInput);
            intInput = scan.nextInt();
            players[currentNumOfPlayers].setNumOfCenturies(intInput);
        } else {
            System.out.println("Team is full.");
        }
    }

    public void deletePlayer() {
        int index;
        Scanner scan = new Scanner(System.in);
        System.out.println("Select player to delete");
        this.displayPlayers();
        index = scan.nextInt() - 1;
        players[index] = null;
        if (index == 10) {
            players[index] = null;
            return;
        }
        for (int i = index; i < 10; i++) {
            players[i] = players[i + 1];
        }
        System.out.println("Successfully deleted player.");
    }

    public int getNumOfPlayers() {
        int length = 0;
        for (ODIPlayer player : players) {
            if (player.getPlayerName() != null)
                length += 1;
        }
        return length;
    }

    public void displayPlayers() {
        for (int i = 0; i < getNumOfPlayers(); i++) {
            System.out.println((i + 1) + ". " + players[i].getPlayerName() + " (" + players[i].getJerseyNumber() + ")");
        }
    }
}
class Match {

    String team1;
    String team2;
    String winner;

    Match(String team1, String team2, String winner) {
        this.team1 = team1;
        this.team2 = team2;
        this.winner = winner;
    }


    public void getMatchDetails() {
        System.out.println("  Teams: "+team1 + " v/s "+team2);
        System.out.println("  Winner: "+winner);
    }
}

class Player {
    String playerName;
    int jerseyNumber;
    String teamName;

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getJerseyNumber() {
        return this.jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}

class T20Player extends Player {
    int numOfThirties;
    float strikeRate;

    public int getNumOfThirties() {
        return this.numOfThirties;
    }

    public void setNumOfThirties(int numOfThirties) {
        this.numOfThirties = numOfThirties;
    }

    public float getStrikeRate() {
        return this.strikeRate;
    }

    public void setStrikeRate(float strikeRate) {
        this.strikeRate = strikeRate;
    }

}

class ODIPlayer extends Player {
    int numOfFifties;
    int numOfCenturies;

    public int getNumOfFifties() {
        return this.numOfFifties;
    }

    public void setNumOfFifties(int numOfFifties) {
        this.numOfFifties = numOfFifties;
    }

    public int getNumOfCenturies() {
        return this.numOfCenturies;
    }

    public void setNumOfCenturies(int numOfCenturies) {
        this.numOfCenturies = numOfCenturies;
    }

}