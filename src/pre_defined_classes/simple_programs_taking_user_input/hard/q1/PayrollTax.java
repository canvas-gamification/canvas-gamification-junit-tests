package pre_defined_classes.simple_programs_taking_user_input.hard.q1;

/*
Make a program that calculates an employee's pay cheque. The program should ask the user how many hours were worked,
the hourly wage, and the tax rate. The program will display the amount of earnings and the amount of tax deductions on
the paycheque.
 */

import java.util.Scanner;

public class PayrollTax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many hours have you worked?");
        double hoursWorked = input.nextDouble();
        System.out.println("What is your hourly wage?");
        double payRate = input.nextDouble();
        System.out.println("What is the tax rate? (Enter 0.12 for 12%)");
        double taxRate = input.nextDouble();
        double pay, tax, net;
        pay = hoursWorked * payRate;
        tax = hoursWorked * payRate * taxRate;
        net = pay - tax;
        System.out.println("Pay Amount: " + pay);
        System.out.println("Tax Amount: " + tax);
        System.out.println("Net Earnings: " + net);
    }

}
