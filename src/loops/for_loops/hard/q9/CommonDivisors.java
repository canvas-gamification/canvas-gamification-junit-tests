package loops.for_loops.hard.q9;
/*
Write a java program that determines if two integers have a common divisor which is greater than 1. The program should
ask the user to input two numbers, try finding if they have a common divisor greater than 1, and prints true if they do
and false if they do not. Assume that the first number entered is larger than the second and that the user enters
numbers greater than zero.

Sample Output:
    Enter two integers:
    67
    9
    false

 */

import java.util.Scanner;

public class CommonDivisors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        int x = input.nextInt();
        int y = input.nextInt();
        boolean hasCommonDivisor = false;
        for (int i = 2; i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                hasCommonDivisor = true;
                break;
            }
        }
        System.out.println(hasCommonDivisor);
    }
}
