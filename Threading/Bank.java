package Threading;
import java.util.*;

public class Bank extends Thread {
    private final double[] accounts;

    public void run(){
        System.out.println("Thread is Running!");
    }

    public Bank(int n , double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance); // Makes all the values in accounts equal to initia; balance
    }

    public void transfer(int from, int to, double amount){
        if( accounts[from] < amount){
            return;
        }
        System.out.println(Thread.currentThread());
        accounts[from]-=amount;
        System.out.printf(" %10.2f from %d to %d ", amount, from , to);
        accounts[to]+=amount;
        System.out.printf(" Total Balance: %10.2f%n",getTotalBalance());
    }

    public double getTotalBalance(){
        double sum = 0;

        for(double a: accounts){
            sum+=a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }

    public static void main(String[] args) {
        Bank obj = new Bank(12,23);
        obj.run();
    }
}
