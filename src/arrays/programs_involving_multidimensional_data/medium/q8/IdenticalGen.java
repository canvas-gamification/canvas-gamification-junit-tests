package arrays.programs_involving_multidimensional_data.medium.q8;

/*
Write a Java program that creates a random integer in the range of 1 to 1000 (inclusive of both values), and print it.
Then, the program will also create a 10 * 10 2D array. Next, use a method called squareRoot to
initialize all the elements of the given array with the square root of the value and print out the elements in the
2D array.

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
        System.out.println(num);
        double[][] out = new double[10][10];
        for (int i = 0; i < out.length; i++)
            for (int j = 0; j < out[i].length; j++)
                out[i][j] = Math.sqrt(num);
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[i].length; j++)
                System.out.print(out[i][j] + " ");
            System.out.println();
        }
    }

}
