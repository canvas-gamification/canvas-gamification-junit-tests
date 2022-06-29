package arrays.arrays_with_methods.medium.q2;
/*
Create a method called highest that takes as input two arrays of type double and returns the array that has the highest
number in it. For example, suppose the two input arrays are [ 2.6, 11.9, 5.3] and [ 3.2, 99.9], the method returns [3.2, 99.9].
You can assume that all the elements in the arrays will be positive numbers.

 */
public class HighestArray {
    public static double[] highest(double[] a, double[] b) {
        double higha = -9999999;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > higha)
                higha = a[i];
        }
        double highb = -9999999;
        for (int i = 0; i < b.length; i++) {
            if (b[i] > highb)
                highb = b[i];
        }
        if (higha > highb)
            return a;
        else
            return b;
    }

}
