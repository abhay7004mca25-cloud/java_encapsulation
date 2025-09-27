/*Description: Design a system to manage vehicle rentals:
Define an abstract class Vehicle with fields like vehicleNumber, type, and rentalRate.
Add an abstract method calculateRentalCost(int days).
Create subclasses Car, Bike, and Truck with specific implementations of calculateRentalCost().
Use an interface Insurable with methods calculateInsurance() and getInsuranceDetails().
Apply encapsulation to restrict access to sensitive details like insurance policy numbers.
Demonstrate polymorphism by iterating over a list of vehicles and calculating rental and insurance costs for each.
 */
package pillars.Encapsulation;
interface Insurable{
    void calculateInsurance();
    void getInsuranceDetails();
}
class Vehicle{
    private String vehicleId;
    public String driverName;
    public int ratePerKm;
    Vehicle( String vehicleId, String driverName, int ratePerKm){
        this.vehicleId=vehicleId;
        this.driverName=driverName;
        this.ratePerKm=ratePerKm;
    }
    public void getItemDetails(){
        System.out.println("Vehicle ID " + vehicleId + ", Driver Name: " + driverName + ", rate per km: " + ratePerKm);
    }
    public void calculateFare(double distance){
        double fare=distance*ratePerKm;
        System.out.println("Vehicle Fare: " + fare);
    }
}
class Car extends Vehicle implements Insurable{
    Car(String vehicleId, String driverName, int ratePerKm){
    super(vehicleId, driverName, ratePerKm);
    }
    public void calculateFare(double distance){
        double fare=distance*ratePerKm;
        System.out.println("Car Fare: " + fare);
    }
    public void calculateInsurance(){
        System.out.println("Car Insurance: " + (ratePerKm * 0.1));
    }
    public void getInsuranceDetails(){
        System.out.println("Car Insurance details: Comprehensive coverage");
    
 }
}
    class Bike extends Vehicle implements Insurable{
        Bike(String vehicleId, String driverName, int ratePerKm){
        super(vehicleId, driverName, ratePerKm);
        }
        public void calculateFare(double distance){
            double fare=distance*ratePerKm;
            System.out.println("Bike Fare: " + fare);
        }
        public void calculateInsurance(){
            System.out.println("Bike Insurance: " + (ratePerKm * 0.05));
        }
        public void getInsuranceDetails(){
            System.out.println("Bike Insurance details: Third-party coverage");
        }
    }
    class Truck extends Vehicle implements Insurable   {
        Truck(String vehicleId, String driverName, int ratePerKm){
            super(vehicleId, driverName, ratePerKm);
        }
        public void calculateFare(double distance){
            double fare=distance*ratePerKm;
            System.out.println("Truck Fare: " + fare);
        }
        public void calculateInsurance(){
            System.out.println("Truck Insurance: " + (ratePerKm * 0.15));
        }
        public void getInsuranceDetails(){
            System.out.println("Truck Insurance details: Full coverage");
        }
    }

public class VRS {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C001", "John", 10),
            new Bike("B001", "Bob", 5),
            new Truck("T001", "Charlie", 15)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.getItemDetails();
            vehicle.calculateFare(100);
            if (vehicle instanceof Insurable) {
                ((Insurable) vehicle).calculateInsurance();
                ((Insurable) vehicle).getInsuranceDetails();
            }
        }
    }
}
