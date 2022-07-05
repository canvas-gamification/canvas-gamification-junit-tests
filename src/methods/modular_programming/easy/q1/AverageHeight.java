package methods.modular_programming.easy.q1;
/*
Write a Java Program that asks users for their height, then prints out if the user is above the average height in Canada
or not (The average height in Canada is 168.7 cm). Write two methods to complete this, one method that asks the user for
their height, and another method that determines and prints the user's classification. If the user provides an invalid
height, the “heightChecker” method should print an error message.
Sample Output:
    Please enter your height in cm:
    179.38
    You're above the average height in Canada!
 */
import java.util.Scanner;

public class AverageHeight {
    public static void main(String[] args) {
        double height = userInput();
        heightChecker(height);
    }

    public static double userInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your height in cm: ");
        double in = input.nextDouble();
        return in;
    }

    public static void heightChecker(double height) {
        if (height < 0)
            System.out.println("Invalid height input!");
        else if (height > 168.7)
            System.out.println("You're above the average height in Canada!");
        else
            System.out.println("You're below the average height in Canada!");
    }
}
