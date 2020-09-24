package classes;
public class Item {
    int id;
    int price;
    int qty;
    Item(int i, int p, int q)
    { id= i; price=p; qty=q; }
    void Buy(int q) {qty+=q;}
    int Sales(int q){
        if (q > qty )
        {System.out.println("This much quantity is not available"); return -1;}
        else
        { qty=qty-q;
            return q*price;
        } } }

class store
{ Item array[];
    store(Item a[])
    {array= new Item[10];
        array=a;
    }
    void BuyBulk(Item a[])
    { for(int i=0;i<a.length;i++)
        for(int j=0;j<array.length;j++)
            if(a[i].id==array[j].id)
                array[j].qty+=a[i].qty;
    }

    void display()
    { for(int i=0;i<array.length;i++)
        System.out.println("Item id "+ array[i].id + " qty " + array[i].qty + " price " + array[i].price);
    }
}
class driver
{ public static void main(String args[])
{
// id price quant
    Item itm1 = new Item(1,10,10);
    Item itm2 = new Item(2,20,20);
    Item itm3 = new Item(3,30,30);
    Item itm4 = new Item(4,40,40);
    Item itm5 = new Item(5,50,50);
    Item a[]={itm1,itm2,itm3,itm4,itm5};
    store s = new store(a);
    Item itm44 = new Item(4,40,4);
    Item itm22 = new Item(2,20,2);
    Item b[]={itm44,itm22};
    s.BuyBulk(b);
    s.display();
}
}