package arrays.referencing_array_and_its_elements.medium.q12;

/*
Write a Java program that takes an array of 10 doubles. Each value represents a purchase, and you need to sum up the
total cost of the purchases and display the total.

Sample Output:
    Enter the price of 10 purchases:
    24.75 14.06 20.00 21.16 5.26 5.23 14.46 13.76 25.42 23.54
    The sum of purchases is 167.64.
 */

import java.util.Scanner;

public class SumPurchase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[10];
        System.out.println("Enter the price of 10 purchases:");
        for (int i = 0; i < arr.length; i++)
            arr[i] = in.nextDouble();
        double sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        System.out.println("The sum of purchases is " + sum + ".");
    }
}
