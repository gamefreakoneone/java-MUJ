package Test;
import java.util.*;

import java.util.ArrayList;

abstract class convert

{ int decimal;

    public ArrayList<Integer> n= new ArrayList(8);

    abstract public void toBinary ();

    public void print() // this function prints the binary representation of a number in reverse order

    {for(int i=n.size()-1;i>=0;i--)

        System.out.print(n.get(i));
    }


}

class binary extends convert

{
    @Override
    public void toBinary() {

    }

    /* this class converts the decimal number into binary number. A number can be positive or negative. write code here */

}

class one extends binary

{

/* this class converts the decimal number int one’s complement number. It uses the functionality of its super class. Write code here

If the number is negative, then it is represented using 1's complement. First represent the number with positive sign and then take 1's complement of that number. (ii) Take 1's complement of 0 0101 and that is 1 1010. MSB is 1 which indicates that number is negative. */

}

public class driver

{public static void main(String args[])

{

    /* write code here to show polymorphism. */

}

}