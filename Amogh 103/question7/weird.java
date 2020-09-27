import java.util.Scanner;

public class weird {

    public int splitodd(int innumber){
        int i=0,place,fnumber=0, inter=innumber;
        while (inter>0){

            place=inter%10;
            inter=inter/10;
            if(place%2==0){
                continue;
            }

            fnumber = (int) (fnumber + (place*(Math.pow(10,i))));
            i++;

        }
        System.out.println("The odd number is "+fnumber);
        return fnumber;
    }

    public int spliteven(int innumber){
        int i=0,place,fnumber=0, inter=innumber;
        while (inter>0){

            place=inter%10;
            inter=inter/10;
            if(place%2!=0){
                continue;
            }

            fnumber = (int) (fnumber + (place*(Math.pow(10,i))));
            i++;

        }
        System.out.println("The even number is "+fnumber);
        return fnumber;
    }

    public void compare(int odd, int even){
        if (odd>even){
            System.out.printf("%d is greater than %d \n",odd,even);
        }else if (even>odd){
            System.out.printf("%d is greater than %d \n",even,odd);
        }else {
            System.out.printf("They are equal \n");
        }
    }

    public static void main(String[] args) {
        weird master = new weird();
        System.out.println("Give me the number:");
        Scanner input = new Scanner(System.in);
        int innumber= input.nextInt();
        int odd = master.splitodd(innumber);
        int even = master.spliteven(innumber);
        master.compare(odd,even);
    }
}
