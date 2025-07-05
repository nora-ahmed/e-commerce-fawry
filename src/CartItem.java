public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity){
        if(quantity>product.getQuantity()){
            System.out.println("Sorry, the quantity you asked for is not available!");
            throw new Error("Please try Again");
        }
        else{
            this.product=product;
            this.quantity=quantity;
        }
    }
    public Product getProduct(){
        return this.product;
    };

    public int getQuantity() {
        return quantity;
    }
}
