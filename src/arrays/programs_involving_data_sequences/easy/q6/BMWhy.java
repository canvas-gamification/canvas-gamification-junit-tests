package arrays.programs_involving_data_sequences.easy.q6;

import java.util.Scanner;

/*
Make a program that reads the height and weights of 10 people, calculates their BMI by storing the results in an array,
and prints the values of their BMIs.

Sample Output:
    Enter the Height and Weight of 10 people in pairs:
    10.5 2.1
    7.8 3.8
    ...
    2.2 492
    59 3.2
    BMI 1: 0.01904761904761905
    BMI 2: 0.062458908612754764
    ...
    BMI 9: 101.65289256198345
    BMI 10: 9.192760700948004E-4
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
        System.out.println("Enter the Height and Weight of 10 people in pairs: ");
        for (int i = 0; i < bmiList.length; i++) {
            height = input.nextDouble();
            weight = input.nextDouble();
            bmiList[i] = calculateBMI(height, weight);
        }
        for (int i = 0; i < bmiList.length; i++)
            System.out.println("BMI " + (i + 1) + ": " + bmiList[i]);
    }
}
