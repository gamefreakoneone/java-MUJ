package Threading;
import java.util.*;
class callMe
{
    public void call(String msg)
    {
        System.out.println("[" + msg);
        try{
            Thread.sleep(1000);
        }
        catch(Exception e) {}
        System.out.println("]");
    }
}

class caller implements Runnable {
    String msg;
    callMe target; //shared object
    Thread th;

    caller(String s, callMe t) {
        msg = s;
        target = t;
        th = new Thread(this); // Made a change here
        th.start();
    }

    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}

public class Sync{
    public static void main(String args[])
    {   callMe obj = new callMe();
        caller th1 = new caller("one",obj);
        caller th2 = new caller("two",obj);
        caller th3 = new caller("three",obj);
        System.out.println("Main Thread");
    }

}

