package StringDemo;

import java.util.Locale;


import java.util.ArrayList;

abstract class convert
{
    int decimal;

    public ArrayList < Integer > n = new ArrayList (8);

    abstract public void toBinary ();

    public void print ()		// this function prints the binary representation of a number in reverse order
    {
        for (int i = n.size () - 1; i >= 0; i--)

            System.out.print (n.get (i));
    }


}

class binary extends convert
{
    @Override public void toBinary ()
    {
        while (decimal > 0)
        {
            n.add (decimal % 2);
            decimal = decimal / 2;
        }
        n.set (n.size () - 1, 0);
    }

    /* this class converts the decimal number into binary number. A number can be positive or negative. write code here */

}

class one extends binary
{

/* this class converts the decimal number int oneb s complement number. It uses the functionality of its super class. Write code here

If the number is negative, then it is represented using 1's complement. First represent the number with positive sign and then take 1's complement of that number. (ii) Take 1's complement of 0 0101 and that is 1 1010. MSB is 1 which indicates that number is negative. */

    one (int decimal)
    {
        this.decimal = decimal;
    }

    public void checkDecimal ()
    {
        System.out.println ("Different Binary Representation of: " + decimal);
        if (decimal < 0)
        {
            this.decimal = this.decimal - 1;
            toBinary ();
            System.out.println ("Binary Representation: ");
            print ();
            System.out.println ("");

            for (int i = 0; i < n.size (); i++)
            {
                if (n.get (i) == 0)
                {
                    n.set (i, 1);
                }
                else if (n.get (i) == 1)
                {
                    n.set (i, 0);
                }
            }
            n.set (n.size () - 1, 1);
            System.out.println ("Ones complement:");

        }
        else
        {
            System.out.println ("Binary Representation:");
            print ();
            System.out.println ("");
            toBinary ();
        }
        print ();

    }

}


public class Main
{
    public static void main (String[]args)
    {
        one number = new one (-127);
        number.checkDecimal ();
    }
}
