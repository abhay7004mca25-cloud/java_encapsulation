package pillars.Encapsulation;
interface Discountable{
    void applyDiscount(double percentage);
    void getDiscountDetails();
}
abstract class FoodItem{
    private String itemName;
    protected double price;
    protected int quantity;

    FoodItem(String itemName, double price, int quantity){
        this.itemName=itemName;
        this.price=price;
        this.quantity=quantity;
    }
    public void getItemDetails(){
        System.out.println("Item Name: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
    abstract double calculateTotalPrice();
}
class VegItem extends FoodItem implements Discountable{
    private int extraVeggies;
    VegItem(String itemName, double price, int quantity, int extraVeggies){
        super(itemName, price, quantity);
        this.extraVeggies=extraVeggies;
    }
    @Override
    double calculateTotalPrice() {
        return (price * quantity) + (extraVeggies * 20);
    }
    @Override
    public void applyDiscount(double percentage) {
        double discountAmount = (calculateTotalPrice() * percentage) / 100;
        System.out.println("Discount Applied: " + discountAmount);
    }
    @Override
    public void getDiscountDetails() {
        System.out.println("Veg items have an additional charge of " + extraVeggies + " for extra veggies.");
    }
}
class NonVegItem extends FoodItem implements Discountable{
    private int extraCharges;
    NonVegItem(String itemName, double price, int quantity, int extraCharges){
        super(itemName, price, quantity);
        this.extraCharges=extraCharges;
    }
    @Override
    double calculateTotalPrice() {
        return (price * quantity) + (extraCharges * 30);
    }
    @Override
    public void applyDiscount(double percentage) {
        double discountAmount = (calculateTotalPrice() * percentage) / 100;
        System.out.println("Discount Applied: " + discountAmount);
    }
    @Override
    public void getDiscountDetails() {
        System.out.println("Non-Veg items have an additional charge of " + extraCharges + " per item.");
    }
}
public class FDS {
    public static void main(String[] args) {
        VegItem vegItem = new VegItem("Veg Pizza", 300, 2, 3);
        NonVegItem nonVegItem = new NonVegItem("Chicken Burger", 250, 1, 2);

        vegItem.getItemDetails();
        vegItem.applyDiscount(10);
        vegItem.getDiscountDetails();
        System.out.println("Total Price of Veg Item: " + vegItem.calculateTotalPrice());
        System.out.println();
        

        nonVegItem.getItemDetails();
        System.out.println("Total Price of Non-Veg Item: " + nonVegItem.calculateTotalPrice());
        nonVegItem.applyDiscount(15);
        nonVegItem.getDiscountDetails();
    }
}
