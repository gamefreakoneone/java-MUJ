import java.util.Scanner;

public class table {

    public void multiplicationTable(int start, int end){
        for (int i=1;i<end;i++){
            System.out.printf(" %d x %d = %d", start,i, (start * i));
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        table master = new table();
        Scanner input =new Scanner(System.in);
        int start,end;
        System.out.println("Whose table do you want? (i.e is x)");
        start=input.nextInt();
        System.out.println("Up to which number do you want?");
        end=input.nextInt();
        master.multiplicationTable(start,end);
        input.close();
    }
}
