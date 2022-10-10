package arrays.programs_involving_data_sequences.easy.q6;

import java.util.Scanner;

/*
Make a program that reads the height and weights of 10 people, calculates their BMI by storing the results in an array,
and prints the values of their BMIs.
 */

public class BMWhy {
    public static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double height = 0;
        double weight = 0;
        double[] bmiList = new double[10];
        for (int i = 0; i < bmiList.length; i++) {
            System.out.println("Enter Height " + (i + 1) + ": ");
            height = input.nextDouble();
            System.out.println("Enter Weight " + (i + 1) + ": ");
            weight = input.nextDouble();
            bmiList[i] = calculateBMI(height, weight);
        }
        for (int i = 0; i < bmiList.length; i++)
            System.out.println("BMI " + (i + 1) + ": " + bmiList[i]);
    }
}
