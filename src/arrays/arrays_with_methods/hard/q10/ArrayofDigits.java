package arrays.arrays_with_methods.hard.q10;

/*
Write a Java program that asks the user to enter two integers, where the first number n represents the numeric value to
be stored and the second number k represents the repetitions of the first number. Then, call a method that you will also
need to define called digitInt, which returns an integer array of size k all initialized to the value of n. Lastly,
in the main method, display the resulting array that was outputted from the method call.
Sample output:
Enter two integers:
5 2
5
5
 */

import java.util.Scanner;

public class ArrayofDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        int number = input.nextInt();
        int repetitions = input.nextInt();
        int[] sent = digitInt(number, repetitions);
        for (int i = 0; i < sent.length; i++)
            System.out.println(sent[i]);
    }

    public static int[] digitInt(int num, int reps) {
        int[] temp = new int[reps];
        for (int i = 0; i < temp.length; i++)
            temp[i] = num;
        return temp;
    }
}
