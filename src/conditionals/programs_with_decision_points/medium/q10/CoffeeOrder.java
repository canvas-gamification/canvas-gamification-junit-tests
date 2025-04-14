package conditionals.programs_with_decision_points.medium.q10;
/*
 * Write a Java program that prompts the user to select a size by entering a number from 1 to 5
 *  and then displays the corresponding output.
 * If the user enters ‘s’ then print out 'small', if the user enters ‘t’ then print out 'tall', 
 * if the user enters ‘g’ then print out 'grande', user enters ‘v’ then print out 'venti', 
 * user enters ‘r’ then print out 'trenta'.
 * If the user enters any other character, print out 'Invalid. Please enter a valid character.'
 */


import java.util.Scanner;
public class CoffeeOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a character: "); 
        char size = scanner.next().charAt(0);

        switch (size) {
            case 's':
                System.out.println("small");
                break;
            case 't':
                System.out.println("tall");
                break;
            case 'g':
                System.out.println("grande");
                break;
            case 'v':
                System.out.println("venti");
                break;
            case 'r':
                System.out.println("trenta");
                break;
            default:
                System.out.println("Invalid. Please enter a valid character.");
        }

        scanner.close();
    }
}