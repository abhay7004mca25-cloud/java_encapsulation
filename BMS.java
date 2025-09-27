package pillars.Encapsulation;
abstract class BankAccount{
    String accountNumber;
    String holderName;
    double balance;

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of: " + amount);
        }
    }

    abstract void calculateInterest();
}
class SavingsAccount extends BankAccount{
    double interestRate;

    SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    @Override
    void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println("Savings Account Interest: " + interest);
    }
}
class CurrentAccount extends BankAccount{
    double interestRate;

    CurrentAccount(String accountNumber, String holderName, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    @Override
    void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println("Current Account Interest: " + interest);
    }
}
public class BMS {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA123", "Alice", 1000, 5);
        BankAccount current = new CurrentAccount("CA123", "Bob", 2000, 3);

        savings.deposit(500);
        savings.withdraw(200);
        savings.calculateInterest();

        current.deposit(1000);
        current.withdraw(500);
        current.calculateInterest();
    }
}