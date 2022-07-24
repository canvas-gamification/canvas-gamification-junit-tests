package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q10;
/*
A company called HappyWorkLife has decided to give everybody a raise with an increase of 5% for each year of
their service. The raise is only given to those who have worked at least a year or more,
and the raise is calculated annually. Make a program that asks the user for the salary (as a double) and the number of
years worked at the company (as an integer), then displays the increased salary amount. Assume the user enters non-negative values.

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
        int years = input.nextInt();
        double bonus = 0.05 * years * salary;
        salary = salary + bonus;
        System.out.println( "Your increased salary is " + salary );
    }

}
