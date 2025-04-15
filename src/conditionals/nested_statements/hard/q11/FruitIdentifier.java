package conditionals.nested_statements.hard.q11;
import java.util.Scanner;

/*
 Rearrange the following Java code snippets to correctly implement a nested switch statement that determines 
 an item based on two input Strings giving it's color and taste. The outer switch should handle color, and the inner 
 switch should handle taste within certain cases. The output should be a single string indicating the item matching 
 those descriptors.

 Sample output:

 Enter color: 
 Red
 Enter taste: 
 Spicy

 Chili
 */


public class FruitIdentifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        System.out.println("Enter taste: ");
        String taste = scanner.nextLine();
        scanner.close();

        switch (color) {
            case "Red":
                switch (taste) {
                    case "Sweet":
                        System.out.print("Apple");
                        break;
                    case "Spicy":
                        System.out.print("Chili");
                        break;
                    default:
                        System.out.print("Not found");
                        break;
                }
                break;
            case "Yellow":
                switch (taste) {
                    case "Sweet":
                        System.out.print("Banana");
                        break;
                    default:
                        System.out.print("Not found");
                        break;
                }
                break;
        }
    }
}
