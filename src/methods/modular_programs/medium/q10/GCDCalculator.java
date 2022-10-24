package methods.modular_programs.medium.q10;
/*
Write a java program that calculates the greatest common divisor (GCD) of two integers. The GCD of two integers is the
largest integer which divides the two integers evenly. In other words, it is the largest integer that when you divide
both integers, the remainders are both equal to zero. For example, the GCD of 18 and 30 is 6, as 6 is the largest
integer which divides both 18 and 30 evenly.

Your program should ask the user to input two integers in the main method, and then call a method named findGCD which
accepts two integers as parameters, and returns the GCD of those two integers. Then, print what the gcd of the two
integers is in the main method. Assume that all input numbers are positive.

    Sample Output:
	Enter two integers:
    18
    30
    The greatest common factor of 18 and 30 is 6.

 */
import java.util.Scanner;
public class GCDCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        int x = input.nextInt();
        int y = input.nextInt();
        int gcd = findGCD(x, y);
        System.out.println("The greatest common factor of " + x + " and " + y + " is " + gcd + ".");
    }
    public static int findGCD(int x, int y){
        int gcd = 1;
        int max = Math.max(x, y);
        for (int i = 1; i <= max; i++){
            if (x % i == 0 && y % i == 0)
                gcd = i;
        }
        return gcd;
    }
}
