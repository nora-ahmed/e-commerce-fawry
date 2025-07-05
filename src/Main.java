import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Date now= new Date(123, 0, 15);
        ExpirableProduct p1=new ExpirableProduct("cheese",30,4, now);
        ShippableProduct p2=new ShippableProduct("tv",50,3,50);
        Product p4=new Product("mobile",1000,20);
        Product p3=new Product("scratch card",10,20);
       Cart cart =new Cart();
       Customer c=new Customer(cart,"nora", 5000.0);
       System.out.println("------------------------------");
       //check expired items
       c.addToCart(p1,1);
       c.addToCart(p2,2);
       c.addToCart(p3,5);
       c.checkout();
        System.out.println("------------------------------");
        //check for deleting
       c.deleteItem("cheese");
        c.checkout();
        System.out.println("------------------------------");
        //check for empty cart
        c.checkout();
        System.out.println("------------------------------");
        // normal checkout
        c.addToCart(p2,2);
        c.addToCart(p3,5);
        c.checkout();
        System.out.println("------------------------------");
        //check for balance
        c.addToCart(p4,200);
        c.checkout();
        System.out.println("------------------------------");
        //normal checkout
        c.addToCart(p3,5);
       c.checkout();

    }
}