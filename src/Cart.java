import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Sorry, the quantity you asked for is not available!");

        } else {
            cartItems.add(new CartItem(product, quantity));
        }
    }

    public List<CartItem> getItems() {
        return cartItems;
    }

    public boolean ckeckExpirableProduct(ExpirableProduct product) {
        if (product.isExpired()) {
            System.out.println("The item:" + product.getName() + " is expired, please delete it and then return to checkout!");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkShippableProduct(ShippableProduct product, int quantity) {
        if (!((ShippableProduct) product).isAvaliable(quantity)) {
            System.out.println("The item:" + product.getName() + " is not available in this quantity, please delete it and then return to checkout!");
            return false;
        } else {
            return true;
        }
    }
    public void ship() {
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cartItems) {
            Product p = item.getProduct();
            if (p instanceof Shippable) {
                shippableItems.add((Shippable) p);
            }
        }

        if (!shippableItems.isEmpty()) {
            ShippingService.shipItems(shippableItems);
        }
    }
    public boolean checkCart() {
        if (this.getItems().isEmpty()) {
            System.out.println("The cart is empty, please add some items and return to checkout!");
            return false;
        }
        Date currentDate = new Date();
        for (CartItem item : this.getItems()) {
            Product product = item.getProduct();
            if (product instanceof ExpirableProduct) {
                if (!ckeckExpirableProduct((ExpirableProduct) product)) {
                    return false;
                }
            }
            if (product instanceof ShippableProduct) {
                if (!checkShippableProduct((ShippableProduct) product, item.getQuantity())) {
                    return false;
                }
            }
        }
        return true;
    }

    public double calculateSum() {
        double currentSum = 0;
        for (CartItem item : this.getItems()) {
            Product product = item.getProduct();
            currentSum += item.getQuantity() * product.getPrice();
        }
        return currentSum;
    }

    public void printAllItems() {
        System.out.println("Items: -------------- Price");
        for (CartItem item : this.getItems()) {
            Product product = item.getProduct();
            System.out.println(item.getQuantity() + "x " + product.getName() + " ---------- " + item.getQuantity() * product.getPrice() + "$");
        }
    }

    public void clearCart() {
        for (CartItem item : this.getItems()) {
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }
        this.cartItems.clear();
    }

    public void deleteItem(String name) {
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().getName().equals(name)) {
                iterator.remove();
            }
        }
    }
}