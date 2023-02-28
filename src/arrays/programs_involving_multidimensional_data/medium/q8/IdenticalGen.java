package arrays.programs_involving_multidimensional_data.medium.q8;

/*
Write a Java program that creates a random integer x in the range of 1 to 1000 (inclusive of both values), and print it.
Then, the program will also create a 10 * 10 2D array, using a method called squareRoot that takes the number x, and
two numbers n and m and return a 2D double array which all its elements are the square root of x, and finally print
that 2D array in the main method. Your method should be general enough to work with any size of array.

Sample Output:
    Random number: 16
    The 2D array of square root is:
    4.0 4.0 4.0 ... 4.0
    4.0 4.0 4.0 ... 4.0
    .               .
    .               .
    .               .
    4.0 4.0 4.0 ... 4.0

Distractors:
    out[i] = Math.sqrt( size );
    out[j] = Math.sqrt( size );
    out[i][j] = Math.round( size );
    out[i][j] = Math.ceil( size );
    out[i][j] = Math.floor( size );
 */

public class IdenticalGen {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 1000 + 1);
        System.out.print("Random number: ");
        System.out.println(num);
        double[][] out = squareRoot(num, 10, 10);
        System.out.println("The 2D array of square root is:");
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[i].length; j++)
                System.out.print(out[i][j] + " ");
            System.out.println();
        }
    }

    public static double[][] squareRoot(int x, int n, int m) {
        double[][] ans = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                ans[i][j] = Math.sqrt(x);
        }
        return ans;
    }

}
