package conditionals.programs_with_decision_points.medium.q2;
/*
Write a program that will ask the user for their score and assign a grade to the user based on the following criteria:
A+ for 90 and above, A for 80 and above, B for 70 and above, C for 60 and above, D for 50 and above, and F for anything
below 50. Assume the user provides a valid double.

Sample Output:
Enter your grade in percentage:
85
A
*/

import java.util.Scanner;

public class LetterGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your grade in percentage:");
        double percent = input.nextDouble();
        if (percent >= 90)
            System.out.println("A+");
        else if (percent >= 80 && percent < 90)
            System.out.println("A");
        else if (percent >= 70 && percent < 80)
            System.out.println("B");
        else if (percent >= 60 && percent < 70)
            System.out.println("C");
        else if (percent >= 50 && percent < 60)
            System.out.println("D");
        else
            System.out.println("F");
    }
}
