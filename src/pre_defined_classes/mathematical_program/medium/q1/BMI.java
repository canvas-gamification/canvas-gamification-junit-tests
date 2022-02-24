package pre_defined_classes.mathematical_program.medium.q1;

/*
Make a program that calculates and prints the body mass index (BMI) of a person given their weight in kilograms and
height in metres. The formula for BMI is: weight / (height)^2
 */

public class BMI {
    public static void main(String[] args) {
        double weight = 70.5;
        double height = 1.63;
        double bmi = weight / Math.pow(height, 2);
        System.out.print("The BMI of a person that weighs " + weight + " kilograms");
        System.out.println(" and is " + height + " metres tall is: " + bmi);
    }
}
