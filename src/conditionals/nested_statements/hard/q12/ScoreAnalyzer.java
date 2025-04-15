package conditionals.nested_statements.hard.q12;
import java.util.Scanner;
/*
 * Rearrange the following Java code snippets in the correct order to correctly implement a nested switch
 * statement that determines a grade category based on a score.
 */

public class ScoreAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter score: ");
        int score = scanner.nextInt();
        switch (score % 2) {
            case 0:
                System.out.println("Even Score");

                switch (score / 10) {
                    case 9:
                        System.out.println("Excellent");
                        break;
                    case 8:
                        System.out.println("Good");
                        break;
                    case 7:
                        System.out.println("Fair");
                        break;
                    case 6:
                        System.out.println("Needs Improvement");
                        break;
                    default:
                        System.out.println("Fail");
                        break;
                }
                break;

            case 1:
                System.out.println("Odd Score");

                switch (score / 10) {
                    case 9:
                        System.out.println("Amazing");
                        break;
                    case 8:
                        System.out.println("Pretty Good");
                        break;
                    case 7:
                        System.out.println("Okay");
                        break;
                    case 6:
                        System.out.println("Almost there");
                        break;
                    default:
                        System.out.println("Try again next time");
                        break;
                }
                break;
        }
        scanner.close();
    }
}
