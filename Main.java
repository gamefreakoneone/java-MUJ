import java.util.*;
class A
{
    public void display()
    {
        System.out.println("Class A");
    }
}

class B extends A
{
    public void display1()
    {
        System.out.println("Class B");
    }
}
class C extends B
{
    public void display()
    {
        System.out.println("Class C");
    }
}
