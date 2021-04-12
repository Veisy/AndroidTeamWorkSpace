package HW2;

public class Salary {

    double salary;
    double amount;

    public Salary(double salary) {
        this.salary = salary;
    }

    void calculateAmount(double rate) {
        amount = this.salary * (rate / 100);
    }

    void raiseSalary() {
        this.salary += amount;
    }

    void reduceSalary() {
        this.salary -= amount;
    }

    void displayAmount(String operation, double amount) {
        System.out.println(operation + " salary amount is: " + amount);
    }

    void showSalary() {
        System.out.println("Salary is " + this.salary+"\n");
    }

}
