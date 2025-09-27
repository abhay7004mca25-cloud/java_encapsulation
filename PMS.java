package pillars.Encapsulation;
abstract class Patient{
    private String patientId;
    private String name;
    private int age;

    Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public void getPatientDetails(){
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    abstract public void CalculateBill();
}
class InPatient extends Patient{
    private int daysAdmitted;
    private double dailyRate;

    InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public void CalculateBill() {
        double totalBill = daysAdmitted * dailyRate;
        System.out.println("In-Patient Total Bill: " + totalBill);
    }
}
class OutPatient extends Patient{
    private double consultationFee;

    OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public void CalculateBill() {
        System.out.println("Out-Patient Total Bill: " + consultationFee);
    }
}
public class PMS {
    public static void main(String[] args) {
        Patient inPatient = new InPatient("IP001", "Jashan", 30, 5, 200.0);
        inPatient.getPatientDetails();
        inPatient.CalculateBill();

        Patient outPatient = new OutPatient("OP001", "Harman", 25, 150.0);
        outPatient.getPatientDetails();
        outPatient.CalculateBill();
    }
}
