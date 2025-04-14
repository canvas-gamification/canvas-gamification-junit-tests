package conditionals.programs_with_decision_points.hard.q14;
/*
Write a program that asks the user for two words, word1 and word2.
Then, check if the combined length of both words:
Less than 10: Print "Short phrase."
Between 10 and 15 (inclusive): Print "Medium phrase."
Greater than 15: If word1 starts with lowercase "a", print "a-start long phrase."
Otherwise, print "Long phrase."
 */
import java.util.Scanner;

public class checkWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter word1 ");
        String word1 = scanner.nextLine();

        System.out.println("Enter word2 ");
        String word2 = scanner.nextLine();

        int totalLength = word1.length() + word2.length();
        
        // Define category correctly based on requirements
        int category;
        if (totalLength < 10) {
            category = 1; // Short phrase
        } else if (totalLength >= 10 && totalLength <= 15) {
            category = 2; // Medium phrase
        } else {
            category = 3; // Long phrase
        }

        switch (category) {
            case 1:
                System.out.println("Short phrase.");
                break;
            case 2:
                System.out.println("Medium phrase.");
                break;
            case 3:
                // Check for 'a' at the start but not 'A'
                switch (word1.charAt(0)) {
                    case 'a':
                        System.out.println("a-start long phrase.");
                        break;
                    default:
                        System.out.println("Long phrase.");
                }
                break;
            default:
                System.out.println("Invalid input.");
        }

        scanner.close();
    }
}