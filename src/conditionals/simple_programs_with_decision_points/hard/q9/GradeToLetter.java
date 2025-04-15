package conditionals.simple_programs_with_decision_points.hard.q9;

import java.util.Scanner;

/*
 Write a Java program that prompts the user to enter a numerical grade and outputs the corresponding letter grade.
 
 Your program must use a switch statement to determine the letter based on the input grade.

 Use the sentence:
     "Enter the numerical grade: "
 as your prompt to the user.

 Grading scale:
 - 90 and above: A
 - 80–89: B
 - 70–79: C
 - 60–69: D
 - Below 60: F

 Your program should handle all possible valid integer inputs accordingly.
 */


public class GradeToLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the numerical grade: ");
        int grade = scanner.nextInt();

        switch (grade / 10) {
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
                break;
        }

        scanner.close();
    }
}

