public class label {

    public static void main(String[] args) {
        System.out.println("This is an example of a labeled break!");

        labelbreak:
        for (int i= 1;i<5;i++){
             System.out.println("This is the first for loop. This is only going to be executed once");
             for (int j =1;j<5;j++){
                 System.out.println("This is the second for loop. This is going to be executed once too.");
                 for (int k=1;k<5;k++){
                     System.out.println("This is the final for loop. Its going to execute");
                     break labelbreak;
                 }
             }
        }
        System.out.println("***********************");
        System.out.println("Demonstrating label continue:");
        System.out.println("***********************");

        labelcontinued:
        for (int i=1;i<=5;i++){
            System.out.printf("This for loop is going to be executed 5 times. Repeat: %d \n",i);
            for (int j=1;j<10;j++){
                System.out.printf("This for loop is not going to execute 10 times only 5 times. Its never going to completely execute. Repeat: %d\n",j);
                continue labelcontinued;
            }
        }

    }
}
