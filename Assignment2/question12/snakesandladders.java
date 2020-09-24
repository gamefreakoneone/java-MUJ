package question12;

public class snakesandladders {
    public static void main(String[] args) {
        int[] players= {0,0,0,0};
        int max=6,min=1;
        int[][] map ={{0,0,2,1,0},{1,0,0,2,1},{0,2,1,0,2},{2,0,1,1,2},{0,0,2,1,0}};
        while(players[0]<25 && players[1]<25 && players[2]<25 && players[3]<25 ){
            System.out.println("New round!");
            for(int i=0;i<4;i++){
                System.out.println("Player "+(i+1)+ ":");
                int Dice=(int)(Math.random()*(max-min+1)+min);
                System.out.println("Player "+(i+1)+" rolled "+Dice);
                players[i]+=Dice;
                System.out.println("Player position: "+ players[i]);
                int pos=1,Action=0;
                out:
                for (int j=0;j<map.length;j++){
                    for(int k=0;k<map[j].length;k++){
                        Action=map[j][k];
                        pos++;
                        if(pos==players[i]){
                            break out;
                        }
                    }
                }
            switch (Action){
                case 1:
                    System.out.println("Player landed on a snake! Losing 2 positons");
                    players[i]=players[i]-2;
                    System.out.println("New Player position: "+players[i]);
                    break;
                case 2:
                    System.out.println("Player landed on a snake! Losing 2 positons");
                    players[i]=players[i]+3;
                    System.out.println("New Player position: "+players[i]);
                    break;
                case 0:
                    System.out.println("Player is safe!");
                    players[i]=players[i];
                    break;
                default:
                    System.out.println("ERROR");
            }
                if (players[i]>=25){
                    System.out.println("_____________________________");
                    System.out.println("Player "+ (i+1) +" Won!!!" );
                    break;
                }
                System.out.println("");
            }

        }
    }
}
