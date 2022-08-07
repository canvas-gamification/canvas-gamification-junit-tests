package methods.defining_methods.hard.q1;
/*
Write a Java Program that asks the user for a double value indicating their height as a double (in metres) and an integer
indicating their weight (in kg) and calculates their BMI. Create a method called "bmiCalc" that takes the height and
then the weight parameter and returns computed BMI. The formula for BMI is BMI = mass/height^2. Make sure to check whether
the parameters passed into the method are positive numbers (greater than zero), otherwise return 0. The main method
should print out "Your BMI is: (value)", with value being the number returned by bmiCalc(). Use printf to ensure the
printed BMI value has at most 2 decimals. Ensure that your output matches the sample.

Sample Output:
    Enter your height in metres:
    1.75
    Enter your weight in kg:
    65
    Your BMI is: 21.22
 */

import java.util.Scanner;

public class BMIMethodTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your height in metres:");
        double height = input.nextDouble();
        System.out.println("Enter your weight in kg:");
        int weight = input.nextInt();
        System.out.printf("Your BMI is: %.2f", bmiCalculator(height, weight));
    }

    public static double bmiCalculator(double a, int b) {
        if (!(a > 0 && b > 0)) {
            return 0;
        }
        double x = b / Math.pow(a, 2);
        return x;
    }
}
