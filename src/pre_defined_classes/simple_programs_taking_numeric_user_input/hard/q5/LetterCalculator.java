package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q5;
/*
Many schools calculate a student's grade point average (GPA) by using the following formula : GPA=percentage grade20-1.
Using this formula, make a program that asks the user for a percentage average, then convert that percentage to a GPA
score. Assume the user only enters valid integer percentages.

Sample Output:
    Enter your grade in percentage: 85
    Your GPA is 3.25

Distractors:
    double gpa = grade/20;
    double gpa = grade - 1 / 20;
    int gpa = grade/20 - 1;
    System.out.println( "Your GPA is: " + grade);
    int grade = input.nextDouble();

 */

import java.util.Scanner;

public class LetterCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your grade in percentage: ");
        int grade = input.nextInt();
        double gpa = grade / 20.0 - 1;
        System.out.println("Your GPA is: " + gpa);
    }
}
