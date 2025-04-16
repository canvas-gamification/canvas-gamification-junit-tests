package conditionals.nested_statements.hard.q12;

import java.util.Scanner;

/*
 * Rearrange the following Java code snippets in the correct order to correctly implement a nested switch
 * statement that divide students into groups based on their grade.
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
