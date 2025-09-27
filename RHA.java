package pillars.Encapsulation;
abstract class Vehicle{
    private String vehicleId;
    public String driverName;
    public int ratePerKm;
    abstract void calculateFare(double distance);
    Vehicle( String vehicleId, String driverName, int ratePerKm){
        this.vehicleId=vehicleId;
        this.driverName=driverName;
        this.ratePerKm=ratePerKm;
    }
    public void getItemDetails(){
        System.out.println("Vehicle ID " + vehicleId + ", Driver Name: " + driverName + ", rate per km: " + ratePerKm);
    }
 }
 class Car extends Vehicle{
    Car(String vehicleId, String driverName, int ratePerKm){
    super(vehicleId, driverName, ratePerKm);
    }
    @Override
    void calculateFare(double distance){
        double fare=distance*ratePerKm;
        System.out.println("Car Fare: " + fare);
    }
 }
 class Bike extends Vehicle{
    Bike(String vehicleId, String driverName, int ratePerKm){
    super(vehicleId, driverName, ratePerKm);
    }
    @Override
    void calculateFare(double distance){
        double fare=distance*ratePerKm;
        System.out.println("Bike Fare: " + fare);
    }
 }
 class auto extends Vehicle{
    auto(String vehicleId, String driverName, int ratePerKm){
    super(vehicleId, driverName, ratePerKm);
    }
    @Override
    void calculateFare(double distance){
        double fare=distance*ratePerKm;
        System.out.println("Auto Fare: " + fare);
    }
 }
public class RHA {
    public static void main(String[] args) {
        Vehicle car = new Car("C001", "Alice", 10);
        Vehicle bike = new Bike("B001", "Bob", 5);
        Vehicle auto = new auto("A001", "Charlie", 8);

        car.getItemDetails();
        car.calculateFare(15);

        bike.getItemDetails();
        bike.calculateFare(10);

        auto.getItemDetails();
        auto.calculateFare(12);
    }
}
