package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q10;
/*
A company called HappyWorkLife has decided to give everybody a raise with an increase of 5% for each year of
their service. The raise only given to those who have served at least a year or more,
and the raise is calculated annually. Make a program that asks the user for the salary and the number of years worked
at the company, then display the increased salary amount. Assuming all user enters valid salary and years of serving,
meaning both inputs are entered as non-negative integers.

Sample output:
Enter your salary:
1200
Enter years of service:
6
Your increased salary is 1560.0

Distractors:
    int salary, years, bonus;
    double salary, bonus, years;
    int salary = input.nextInt();
    double bonus = salary * 5%;
    double bonus = salary * 1.05;

 */

import java.util.Scanner;

public class NewSalaryCalculator {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter your salary: " );
        double salary = input.nextDouble();
        System.out.println( "Enter years of service:" );
        double years = input.nextDouble();
        double bonus = 0.05 * years * salary;
        salary = salary + bonus;
        System.out.println( "Your increased salary is " + salary );
    }

}
