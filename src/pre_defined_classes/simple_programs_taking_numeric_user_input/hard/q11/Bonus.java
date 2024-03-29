package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q11;
/*
Your professor has decided to give everyone in the class a bonus of 10% on an exam! Write a java program asking the
user how many marks the exam is out of (as an integer) and the grade they received (as a double). Then, calculate their
new score with the bonus, and print this new score with a formatted string to round the percentage to two decimal
places. Assume the user will provide valid input, and that the score will be less than or equal to the total marks.

Sample Output:
    Enter how many marks the exam is out of:
    50
    Enter your score on the exam:
    30.75
    Your scored a 71.50% on the exam!

Distractors:
    double score = input.nextInt();
    int marks = input.next();
    double bonusScore = score + marks * 0.1 * 100;
    System.out.println(“Your scored a “ + percentScore + “on the exam!”);
    Import java.util.scanner
*/

import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many marks the exam is out of: ");
        int marks = input.nextInt();
        System.out.println("Enter your score on the exam: ");
        double score = input.nextDouble();
        double bonusScore = (score + marks * 0.1) * 100;
        double percentScore = bonusScore / marks;
        System.out.printf("Your scored a %.2f%% on the exam!", percentScore);
    }
}
