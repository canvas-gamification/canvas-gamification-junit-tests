package methods.modular_programs.easy.q4;

/*
Write a Java Program that initializes three double variables and passes them to a method called valueAfterCalc to
return the value after the decimal point. (e.g. if the number is 14.5673, return 0.5673). If the variables are
negative, the returned value should be negative.

Sample output:
    The values after the decimal point for the first variable are 0.12300000000000111
    The values after the decimal point for the second variable are -0.2400000000000002
    The values after the decimal point for the third variable are 0.7899999999999991
 */

public class ReturnChange {
    public static void main(String[] args) {
        double a = 22.123;
        double b = -6.24;
        double c = 11.79;
        System.out.println("The values after the decimal point for the first variable are " + valueAfterCalc(a));
        System.out.println("The values after the decimal point for the second variable are " + valueAfterCalc(b));
        System.out.println("The values after the decimal point for the third variable are " + valueAfterCalc(c));
    }

    public static double valueAfterCalc(double a) {
        if (a < 0)
            return (a - Math.ceil(a));
        else
            return a - Math.floor(a);
    }
}

