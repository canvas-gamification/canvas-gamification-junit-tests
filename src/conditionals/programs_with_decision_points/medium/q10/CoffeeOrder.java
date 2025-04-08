package conditionals.programs_with_decision_points.medium.q10;
/*
 * Write a Java program that prompts the user to select a size by entering a number from 1 to 5
 *  and then displays the corresponding output.
 * If the user enters ‘1’ then print out 'small', if the user enters ‘2’ then print out 'tall', 
 * if the user enters ‘3’ then print out 'grande', user enters ‘4’ then print out 'venti', 
 * user enters ‘5’ then print out 'trenta'.
 */


import java.util.Scanner;
public class CoffeeOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a size from 1 to 5: "); 

        int size = scanner.nextInt();

        switch (size) {
            case 1:
                System.out.println("small");
                break;
            case 2:
                System.out.println("tall");
                break;
            case 3:
                System.out.println("grande");
                break;
            case 4:
                System.out.println("venti");
                break;
            case 5:
                System.out.println("trenta");
                break;
            default:
                System.out.println("Invalid. Please enter a number between 1 and 5.");
        }

        scanner.close();
    }
}