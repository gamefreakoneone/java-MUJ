public class Command {
    void prime( int hrange){
        int value=0;
        for(int i=2;i<hrange;i++){
            value=0;
            if(hrange%i==0){
                System.out.printf("%d is not a prime\n",hrange);
                value=1;
                break;
            }  
        }
        if (value==0)
        {
            System.out.printf("%d is a prime number\n",hrange);
        }
    }
    public static void main(String[] args) {
        Command Prime = new Command();
        Prime.prime(13);
        Prime.prime(12);
    }
}
