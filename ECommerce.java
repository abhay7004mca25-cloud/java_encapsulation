/*Description: Develop a simplified e-commerce platform:
Create an abstract class Product with fields like productId, name, and price, and an abstract method calculateDiscount().
Extend it into concrete classes: Electronics, Clothing, and Groceries.
Implement an interface Taxable with methods calculateTax() and getTaxDetails() for applicable product categories.
Use encapsulation to protect product details, allowing updates only through setter methods.
Showcase polymorphism by creating a method that calculates and prints the final price (price + tax - discount) for a list of Product. */
package pillars.Encapsulation;
interface Taxable{
    double calculateTax();
    String getTaxDetails();
}
abstract class Product{
    private String productId;
    private String name;
    private double price;
    Product(String productId, String name, double price){
        this.productId=productId;
        this.name=name;
        this.price=price;
    }
    public void getProductDetails(){
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public String getName(){
        return name;
    }
    abstract double calculateDiscount();
}
class Electronics extends Product implements Taxable{
    Electronics(String productId, String name, double price){
        super(productId, name, price);
    }
    double calculateDiscount(){
        return getPrice() * 0.1;
    }
    public double calculateTax(){
        return getPrice() * 0.18;
    }
    public String getTaxDetails(){
        return "Electronics Tax details: 18% GST";
    }
}
class Clothing extends Product implements Taxable{
    Clothing(String productId, String name, double price){
        super(productId, name, price);
    }
    double calculateDiscount(){
        return getPrice() * 0.2;
    }
    public double calculateTax(){
        return getPrice() * 0.12;
    }
    public String getTaxDetails(){
        return "Clothing Tax details: 12% GST";
    }
}
class Groceries extends Product{
    Groceries(String productId, String name, double price){
        super(productId, name, price);
    }
    double calculateDiscount(){
        return 0;
    }
}
public class ECommerce {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics("E001", "Laptop", 1000),
            new Clothing("C001", "T-Shirt", 20),
            new Groceries("G001", "Apple", 1)
        };
        for (Product product : products) {
            product.getProductDetails();
            double tax = 0;
            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
            }
            double finalPrice = product.getPrice() + tax - product.calculateDiscount();
            System.out.println("Final Price: " + finalPrice);
        }
    }
}
