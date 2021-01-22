package Threading;

class PandC
{
    public static void main(String args[])
    {
        Q q= new Q();
        producer p1 = new producer("producer-1",q,100);
        consumer c= new consumer("consumer",q);
    }
}


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
        while(true)
        {
            int i=  q.get();
            System.out.println(t.getName()+" "+ i);
        }
    }
} // end of consumer

class producer implements Runnable
{
    int n;
    Q q;
    Thread t;
    producer(String name, Q q,int n)
    {
        this.n=n;
        this.q = q;
        t= new Thread(this,name);
        t.start();
    }
    public void run()
    {
        while(true)
        {
            q.put(n);
            System.out.println(t.getName() + " "+ n);
            n++;
        }
    }
}
class Q
{
    int n;
    boolean valueset=false;
    synchronized int get()
    {
        try{
            while(valueset==false) // busy waiting
                wait(); // leave the lock
        }
        catch(InterruptedException e) {}
        valueset=false;
        notify();
// it will not leave the lock but inform the other thread
// other thread will join the
//
//
//
//
//ing queue
        return n;
    }
    synchronized void put(int n)
    {
        try
        {
            while(valueset == true) // busy waiting
                wait();  // leave the lock
            this.n=n;
            valueset=true;
            notify();
        }
        catch(InterruptedException e){}
    }
} // end of class Q

