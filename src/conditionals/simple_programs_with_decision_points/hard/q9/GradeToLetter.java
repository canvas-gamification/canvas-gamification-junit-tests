package conditionals.simple_programs_with_decision_points.hard.q9;

import java.util.Scanner;

/*
 Suppose there is a Java program that takes <tt>grade</tt> as integer input from the user and prints the letter correspondingly 
 using the if-else statement below. Translate the following statement into a switch statement block, and use the sentence 
 “Enter the numerical grade: “ to ask for input.

<code>
        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80) {
            System.out.println("B");
        } else if (grade >= 70) {
            System.out.println("C");
        } else if (grade >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
</code>

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

