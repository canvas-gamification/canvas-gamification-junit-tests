package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q3;
/*
Write a program that receives the input of three people's age and displays the oldest one using the max()
method. Assume the user only enters non-negative integers.

Sample Output:
    Enter three integers:
    10
    20
    30
    The oldest age is: 30

Distractors:
    Scanner input = new Scanner();
    max = 0;
    int n2 = input.nextLine();
    int max = 0;
    max = Math.max( n1,n2 );
    max = Math.max( n1,n3 );
    max = Math.max( n2,n3);

 */

import java.util.Scanner;

public class OldFolks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three integers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();
        int max;
        max = Math.max(n1, Math.max(n2, n3));
        System.out.println("The oldest age is: " + max);
    }
}
