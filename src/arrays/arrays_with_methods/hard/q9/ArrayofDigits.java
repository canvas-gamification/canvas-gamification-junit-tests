package arrays.arrays_with_methods.hard.q9;

/*
Write a Java program that asks the user to enter 5 integers to be stored in an integer array. Next, define a method
that takes an integer array, computes the 2nd power of each element, and does not return any output. Back in the main
method of the program, call this method with the array consisting of the user inputted values, then display each element
in the array after calling the method.

Sample output:
Enter 5 integers:
5 2 3 4 6
25
4
9
16
36
 */

import java.util.Scanner;
public class ArrayofDigits
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter 5 integers: ");
        int[] sent = new int[5];
        for( int i = 0; i < sent.length; i++ )
            sent[i] = input.nextInt();
        powerN( sent );
        for( int i = 0; i < sent.length; i++ )
            System.out.println(sent[i]);
    }
    public static void powerN(int[] arr)
    {
        for( int i = 0; i < arr.length; i++ )
            arr[i] = (int) Math.pow(arr[i], 2);
    }
}

