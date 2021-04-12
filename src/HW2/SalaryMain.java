package HW2;

import java.util.Scanner;

public class SalaryMain {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter base salary.");
        double baseSalary = validDouble();

        Salary salary = new Salary(baseSalary);

        boolean repeat = true;
        while (repeat) {

            System.out.println("Please  select the operation you want to do.\n" +
                    "1 -> Show the initial salary.\n" +
                    "2 -> Raise the salary.\n" +
                    "3 -> Reduce the salary.\n" +
                    "4 -> Quit");
            String operation = scanner.nextLine(); // To select operation.

            switch (operation) {
                case "1":
                    salary.showSalary();
                    break;
                case "2":
                case "3":
                    //We will store the operation info here
                    String operationInfo;
                    //This will control if operation is valid or not.
                    boolean isValidOperation = true;

                    System.out.println("Enter Percentage :");
                    double percentage = validDouble();

                    salary.calculateAmount(percentage);

                    if (operation.equals("2")) {
                        operationInfo = "Increase";
                        salary.raiseSalary();
                    } else {
                        operationInfo = "Decreased";
                        if ((salary.salary - salary.amount) < baseSalary) {
                            isValidOperation = false;
                            System.out.println("You cannot lower the salary under the basic salary.");
                        } else {
                            salary.reduceSalary();
                        }
                    }

                    if (isValidOperation) {
                        salary.displayAmount(operationInfo, salary.amount);
                        salary.showSalary();
                    }

                    break;
                case "4":
                    repeat = false;
                    break;
                default:
                    System.out.println("Please select valid operation.\n");
                    break;
            }

        }
    }

    //Get positive double number.
    private static Double validDouble () {
        double input = 0;

        boolean repeat = true;
        while(repeat) {
            input = getDouble();
            if (input <= 0) {
                System.out.println("Invalid input, Enter a positive salary. Respect for labor!\"");
            } else {
                repeat = false;
            }
        }
        //This will empty scanner.
        scanner.nextLine();

        return input;
    }

    //Get double number.
    private static Double getDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input, Type Double:");
            scanner.next();
        }
        return scanner.nextDouble();
    }

}


