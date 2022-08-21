package methods.modular_programs.easy.q3;

/*
Write a program that takes three initialized and declared integer variables and determines their mean and median.
Note that the mean is the average of the three numbers and that the median is the middle number when the numbers are
sorted from least to greatest. The program should have separate methods for computing both of these values.
Sample output:
The average of the three integers is 13.0
The median of the three integers is 5
 */

public class MeanNMedian {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        int c = 34;
        System.out.println("The average of the three integers is " + averageCalc(a, b, c));
        System.out.println("The median of the three integers is " + medianCalc(a, b, c));
    }

    public static double averageCalc(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    public static int medianCalc(int a, int b, int c) {
        if ((a < b && b < c) || (c < b && b < a))
            return b;
        else if ((b < a && a < c) || (c < a && a < b))
            return a;
        else
            return c;
    }
}
