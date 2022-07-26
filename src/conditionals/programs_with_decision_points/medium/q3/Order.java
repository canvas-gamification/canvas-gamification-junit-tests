package conditionals.programs_with_decision_points.medium.q3;
/*
Write a program that takes in three integers and orders them in ascending order. Assume the user provides valid input.
Sample Output:
    Enter number 1:
    1
    Enter number 2:
    3
    Enter number 3:
    0
    0, 1, 3
 */

import java.util.Scanner;

public class Order {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int n1 = input.nextInt();
        System.out.println("Enter number 2: ");
        int n2 = input.nextInt();
        System.out.println("Enter number 3: ");
        int n3 = input.nextInt();
        if (n1 > n2 && n1 > n3 && n2 > n3)
            System.out.println(n3 + ", " + n2 + ", " + n1);
        else if (n1 > n2 && n1 > n3 && n3 > n2)
            System.out.println(n2 + ", " + n3 + ", " + n1);
        else if (n2 > n1 && n1 > n3 && n2 > n3)
            System.out.println(n3 + ", " + n1 + ", " + n2);
        else if (n1 > n2 && n3 > n1 && n3 > n2)
            System.out.println(n2 + ", " + n1 + ", " + n3);
        else if (n2 > n1 && n3 > n1 && n2 > n3)
            System.out.println(n1 + ", " + n3 + ", " + n2);
        else
            System.out.println(n1 + ", " + n2 + ", " + n3);
    }
}
