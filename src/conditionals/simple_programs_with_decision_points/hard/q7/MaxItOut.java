package conditionals.simple_programs_with_decision_points.hard.q7;
/*
Write a program that asks for two numbers and prints the minimum of 2 numbers. Assume the user enters integers.

Sample Output:
	Enter the first number:
    6
    Enter the second number:
    5
    5 is the min

Distractors:
    int n2 = input.next();
    int n2 = input.nextDouble();
    n2 = input.nextInt();
    if( n1 == n2 )
    else if( n1 < n2 )
    else( n1 < n2 )
    if( n1 > n2 )
 */

import java.util.Scanner;

public class MaxItOut {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int n1 = input.nextInt();
        System.out.println("Enter the second number: ");
        int n2 = input.nextInt();
        if (n1 < n2)
            System.out.println(n1 + " is the min");
        else
            System.out.println(n2 + " is the min");
    }
}
