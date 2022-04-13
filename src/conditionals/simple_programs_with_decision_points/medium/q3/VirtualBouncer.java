package conditionals.simple_programs_with_decision_points.medium.q3;

import java.util.Scanner;

/*
Write a program to ask the user for their age and check whether they are of legal age to drink in the Java Programmer
province, where the drinking age is 19. You don’t need to account for negative numbers.
 */

public class VirtualBouncer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your age? ");
        int age = input.nextInt();
        if (age >= 19)
            System.out.println("Step right in sir.");
        else
            System.out.println("Whoa there kiddo, it's past your bedtime.");
    }

}
