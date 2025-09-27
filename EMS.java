package pillars.Encapsulation;
abstract class Employee{
    private String empId;
    private String name;
    double baseSalary;
    Employee(String empId, String name, double baseSalary) {
        this.empId = empId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public void displayDetails(){
        System.out.println("Employee ID: " + empId + ", Name: " + name + ", Salary: " + baseSalary);
    }

    abstract public void calculateSalary();
}
class FullTimeEmployee extends Employee{
    double bonus;

    FullTimeEmployee(String empId, String name, double baseSalary, double bonus) {
        super(empId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public void calculateSalary() {
        double totalSalary = baseSalary + bonus;
        System.out.println("Full-Time Employee Total Salary: " + totalSalary);
    }
}
class PartTimeEmployee extends Employee{
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(String empId, String name, double hourlyRate, int hoursWorked) {
        super(empId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void calculateSalary() {
        double totalSalary = hourlyRate * hoursWorked;
        System.out.println("Part-Time Employee Total Salary: " + totalSalary);
    }
}
public class EMS {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee("1", "Ajay", 5000, 1000);
        Employee emp2 = new PartTimeEmployee("2", "Abhay", 20, 80);

        emp1.displayDetails();
        emp1.calculateSalary();

        emp2.displayDetails();
        emp2.calculateSalary();
    }
}
