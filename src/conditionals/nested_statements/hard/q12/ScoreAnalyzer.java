package conditionals.nested_statements.hard.q12;

import java.util.Scanner;

/*
 * Rearrange the following Java code snippets in the correct order to correctly implement a nested switch statement that 
 * divides students into groups based on their score. Students with even scores are assigned to Group 2, and those with odd 
 * scores are assigned to Group 1. Then, based on the score range, a letter grade is assigned as follows: 90 and above = A, 
 * 80–89 = B, 70–79 = C, 60–69 = D, and below 60 = F. The program should print a single line in the format "Group X - Y", 
 * where X is the group number and Y is the corresponding letter grade. 
 * 
 * Sample output:
 * Enter score: 95
 * Group 1 - A
 * 
 * Enter score: 84
 * Group 2 - B
 */

public class ScoreAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter score: ");
        int score = scanner.nextInt();

        switch (score % 2) {
            case 0:
                switch (score / 10) {
                    case 10:
                    case 9:
                        System.out.println("Group 2 - A");
                        break;
                    case 8:
                        System.out.println("Group 2 - B");
                        break;
                    case 7:
                        System.out.println("Group 2 - C");
                        break;
                    case 6:
                        System.out.println("Group 2 - D");
                        break;
                    default:
                        System.out.println("Group 2 - F");
                        break;
                }
                break;

            case 1:
                switch (score / 10) {
                    case 10:
                    case 9:
                        System.out.println("Group 1 - A");
                        break;
                    case 8:
                        System.out.println("Group 1 - B");
                        break;
                    case 7:
                        System.out.println("Group 1 - C");
                        break;
                    case 6:
                        System.out.println("Group 1 - D");
                        break;
                    default:
                        System.out.println("Group 1 - F");
                        break;
                }
                break;
        }

        scanner.close();
    }
}
