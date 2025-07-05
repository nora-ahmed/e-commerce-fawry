import java.util.Date;

public class Customer {
    String name;
    double balance;
    private Cart cart;
    public Customer(Cart cart, String name,Double balance){
        this.cart=cart;
        this.name=name;
        this.balance=balance;
    }
    public void addToCart(Product product, int quantity){
        cart.addProduct(product,quantity);
    }
    public void checkout(){
    if(!cart.checkCart()){
        return;
    }
    double total=cart.calculateSum();
    int shippingFees=60;
    double subTotal=total+shippingFees;
if(subTotal>this.balance){
    System.out.println("Sorry you do not have enough balance");
    return;
}
this.balance-=subTotal;
cart.printAllItems();
System.out.println("Your total is: "+total);
System.out.println("the shipping fees: "+shippingFees);
System.out.println("your subtotal is : "+subTotal);
System.out.println("your current balance is : "+this.balance);
        cart.ship();
cart.clearCart();

    }
    public void deleteItem(String name){
        cart.deleteItem(name);
    }
}
