package loops.simple_programs_with_repitition.hard.q1;
/*
Write a program that asks the user for a number and determines if it is an "Armstrong Number". A number is an Armstrong
number if the sum of its own digits raised to the power of the number of digits is equal to the number itself.
(Eg: 8208 = 8^4 + 2^4 + 0^4 + 8^4). If the number is an Armstrong number, print “(input number here) is an Armstrong
Number!”, otherwise, print “(input number here) is NOT an Armstrong Number!”. Assume the user provides a valid integer
greater than or equal to 0. Hint: You need one loop to check how many digits are in the number and another to check
whether it is an Armstrong number. Make sure your output matches the sample.
Sample Output:
    Enter a number:
    8208
    8208 is an Armstrong Number!
 */

import java.util.Scanner;

public class ArmsAreStrong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = input.nextInt();
        int nn = n;
        int numDigits = 0;
        int result = 0;
        while (nn > 0) {
            numDigits++;
            nn = nn / 10;
        }
        nn = n;
        while (n > 0) {
            result += Math.pow(n % 10, numDigits);
            n = n / 10;
        }
        if (result == nn)
            System.out.println(nn + " is an Armstrong Number!");
        else
            System.out.println(nn + " is NOT an Armstrong Number!");
    }
}
