package arrays.referencing_array_and_its_elements.medium.q12;

/*
Write a Java program that asks the user to input the cost of 35 purchases and stores those values in an array of 35
doubles. Then it will take an integer x, and print the sum of the doubles in the array from index 0 to x - 1. The
program then calculates the total cost of the purchases and displays the total.

Sample Output:
    Enter the price of 35 purchases:
    24.75 14.06 20.00 21.16 ... 5.26 5.23 14.46 13.76 25.42 23.54
    Enter an integer:
    3
    The sum of first 3 purchases is 58.81.
 */

import java.util.Scanner;

public class SumPurchase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[35];
        System.out.println("Enter the price of 35 purchases:");
        for (int i = 0; i < arr.length; i++)
            arr[i] = in.nextDouble();
        System.out.println("Enter an integer:");
        int x = in.nextInt();
        double sum = 0;
        for (int i = 0; i < x; i++)
            sum += arr[i];
        System.out.println("The sum of the first " + x + " purchases is " + sum + ".");
    }
}
