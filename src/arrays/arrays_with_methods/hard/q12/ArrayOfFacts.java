package arrays.arrays_with_methods.hard.q12;

/*
Write a Java program that asks the user to input the length of an array called n. Then, the program initializes an
integer array with a series of factorial numbers 1!, 2!, 3!, 4!, ...etc. up to n! And prints the array. Recall that n!
is calculated as follows:
n! = n x (n - 1) x (n - 2) x … x 1.
In particular, write a method called factorial that takes an integer and returns the factorial of that number (e.g.,
calling factorial(3) returns 6).
Sample output:
Enter the size of the array:
5
1
2
6
24
120
 */

import java.util.Scanner;

public class ArrayOfFacts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = factorial(i + 1);
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static int factorial(int n) {
        int fact = 1;
        while (n > 0) {
            fact *= n;
            n--;
        }
        return fact;
    }
}
