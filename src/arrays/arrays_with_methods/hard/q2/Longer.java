package arrays.arrays_with_methods.hard.q2;
/*
Create a method called whoIsLonger that takes two integer arrays as input and returns the one with more elements in it.
If they are the same length, the first array should be returned.
 */

public class Longer {
    public static int[] whoIsLonger(int[] a, int[] b) {
        if (a.length < b.length)
            return b;
        else
            return a;
    }
}
