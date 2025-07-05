import java.util.List;

interface Shippable {
    String getName();

    double getWeight();
}

class ShippingService {
    public static void shipItems(List<Shippable> items) {
        for (Shippable item : items) {
            System.out.println("Shipping: " + item.getName() + " - " + item.getWeight() + " kg");
        }
    }
}
public class ShippableProduct extends Product  implements Shippable{
    private double weight;

    public ShippableProduct(String name, double price, int quantity,double weight) {
        super(name, price, quantity);
        this.weight=weight;
    }
    public boolean isAvaliable(int quantity){
        if (quantity<=this.getQuantity())
            return true;
        else
            return false;
    }

    public double getWeight() {
        return this.weight;
    }


    public String getName() {
        return super.getName();
    }
}
