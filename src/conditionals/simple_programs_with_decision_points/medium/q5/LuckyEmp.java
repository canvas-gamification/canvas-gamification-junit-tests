package conditionals.simple_programs_with_decision_points.medium.q5;
/*
Write a program that will give out a bonus of 15% of their salary to someone's yearly salary if their salary is less
than $12000.
 */

import java.util.Scanner;

public class LuckyEmp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your annual salary in $?");
        double salary = input.nextDouble();
        if (salary < 12000) {
            salary = salary + (0.15 * salary);
            System.out.println("Congratulations!, you received a bonus of 15%!");
        }
        System.out.println("Annual Salary: $" + salary);
    }

}
