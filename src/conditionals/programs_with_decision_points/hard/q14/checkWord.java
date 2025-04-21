package conditionals.programs_with_decision_points.hard.q14;
/*
Write a program that asks the user for two words, word1 and word2. 
Use an if statement to check the combined length of both words and categorize them into three categories:
1. Short phrase: If the combined length of both words is less than 10.
2. Medium phrase: If the combined length of both words is between 10 and 15 (inclusive).
3. Long phrase: If the combined length of both words is greater than 15.
Then use a switch statement to check if word1 starts with lowercase "a" and print the phrase types accordingly.
If the combined length of both words is less than 10, print "Short phrase." 
If it's between 10 and 15 (inclusive) print "Medium phrase." 
If it is greater than 15 and word1 starts with lowercase "a", print "a-start long phrase." 
Otherwise, print "Long phrase."
 */
import java.util.Scanner;

public class CheckWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter word1: ");
        String word1 = scanner.nextLine();

        System.out.println("Enter word2: ");
        String word2 = scanner.nextLine();

        int totalLength = word1.length() + word2.length();
        
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