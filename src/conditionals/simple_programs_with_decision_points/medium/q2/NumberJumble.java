package conditionals.simple_programs_with_decision_points.medium.q2;

import java.util.Scanner;

/*
Write a program that asks the user for a number and divides the number by 10 (using integer division) if it is greater
than 10; otherwise, it multiplies it by 10.
 */

public class NumberJumble {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = input.nextInt();
        if (n > 10)
            n = n / 10;
        else
            n = n * 10;
        System.out.println("Number = " + n);
    }

}
