package methods.modular_programs.hard.q1;

import java.util.Scanner;

/*
Write a program that will ask the user for a number and determine if it is a right-truncatable prime. This is a special
type of number where after removing each digit from the right, the resulting number after each digit removal is a prime
number. Your program should have a method called isRightPrime which accepts an integer parameter and returns true or false
for it the number is a right-truncatable prime. The main method should then print out the returned boolean from isRightPrime.

Example of right-truncatable prime:
    Eg: 2393 (prime)
    239 ( Remove 3, still prime)
    23 (remove 9, still prime)
    2 (remove 3, still prime)

Sample Output:
    Enter a number:
	5
	true
 */

public class RightPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = input.nextInt();
        System.out.println(isRightPrime(num));
    }

    public static boolean isRightPrime(int num) {
        if(num <= 0)
            return false;
        while (num > 0) {
            int factors = 0;
            for (int i = 1; i <= num; i++)
                if (num % i == 0)
                    factors++;
            if (factors != 2)
                return false;
            num /= 10;
        }
        return true;
    }

}
