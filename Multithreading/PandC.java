package Multithreading;
class Q
{
    int n;
    synchronized int get()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e) {}
        return n;

    }
    synchronized void put(int n)
    {
        this.n=n;
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){}
    }
}
 // end of class Q
class producer implements Runnable
{ Q q;
    Thread t;
    producer(String name, Q q)
    {
        this.q = q;
        t= new Thread(this,name);
        t.start();
    }
    public void run()
    {
        int i=0;
        while(i<10)
        {
            q.put(i);
            System.out.println("producer " + i);
            i++;
        }
    } // end of run
} // end of producer

class consumer implements Runnable
{
    Q q;
    Thread t;
    consumer(String name, Q q)
    {
        this.q = q;
        t= new Thread(this,name);
        t.start();
    }
    public void run()
    {
        int i=0;
        while(i<9)
        {
            i=  q.get();
            System.out.println("consumer "+ i);
        }
    } // end of run
} // end of consumer
public class PandC
{
    public static void main(String args[])
    {
        Q q= new Q();
        producer p = new producer("producer",q);
        producer p2 = new producer("producer-2",q);
        consumer c= new consumer("consumer",q);
//        try{
//    p.t.join();
//    c.t.join();
//    }
//    catch(InterruptedException e){}
//        System.out.println(Thread.currentThread().getName());
//    }
}
}
