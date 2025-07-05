import java.util.Date;

public class ExpirableProduct extends Product {
    private Date expireDate;

    public ExpirableProduct(String name, double price, int quantity,Date expireDate) {
        super(name, price, quantity);
        this.expireDate=expireDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }
    public boolean isExpired(){
        Date currentDate = new Date();
        return currentDate.after(expireDate);
    }
}
