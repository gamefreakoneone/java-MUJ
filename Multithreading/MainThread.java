package Multithreading;

class thread2 extends Thread
{
    int k;

    public void run()
    { for(int i=0;i<5;i++)
        System.out.println(this.getName()+" " +k++);
    }

}

class ThreadTest implements Runnable{
    Thread t;
    ThreadTest(String t1)
    {
        t = new Thread(this);
        t.start();
        try {
            t.join();
        }catch (Exception e){}
        System.out.println(t.getState()+ " "+ t.getName());
    }

    public void run(){
        for (int i =0; i<2;i++){
            System.out.println(t.getState() + "  " + t.getName());
        }
    }
}

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        thread3 obj = new thread3("th1");
        thread3 obj1 = new thread3("th2");
        for(int i=0;i<5;i++)
        {
            System.out.println("Main"+i);

        }  //thread3 obj2 = new thread3("ss2");


}
}

class thread3 implements Runnable {
    int k;
    Thread t;
    String name;

    thread3(String s) {
        t = new Thread(this); // passing the reference of runnable
        name = s;
        t.start();
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println(this.name + " " + k++);
    }
}