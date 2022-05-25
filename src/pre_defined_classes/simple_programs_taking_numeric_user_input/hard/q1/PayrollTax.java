package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q1;

/*
(vary double with: int (for hoursWorked and payRate);
vary variable name for "pay": payAmount; payAmt;
vary variable name for "tax": taxAmount; taxAmt;
vary variable name for "net": netAmount; netAmt;
vary 12% with: integer in 10 to 49;)

Make a program that calculates an employee's pay cheque. The program should ask the user how many hours were worked,
the hourly wage, and the tax rate. The program will display the amount of earnings and the amount of tax deductions on
the paycheque.

Sample Output:
	How many hours have you worked?
    5
    What is your hourly wage?
    16
    What is the tax rate? (Enter 0.12 for 12%)
    0.12
    Pay Amount: 80.0
    Tax Amount: 9.6
    Net Earnings: 70.4
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
