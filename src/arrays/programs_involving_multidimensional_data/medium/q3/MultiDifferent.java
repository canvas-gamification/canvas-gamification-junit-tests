package arrays.programs_involving_multidimensional_data.medium.q3;

/*
Write a Java program that initializes two integer 2D arrays, size 5 by 5, with numbers randomly generated
in the range of 1 to 5 (inclusive of both values), then prints both of them in each row in a line. Then, use a method called
multiply to multiply every element in one array with the respective element in the second array, and display the elements
in the resulting 2D array, your method should only display the multiplied numbers, everything else should be printed in
the main method. Your multiply method should be general enough to work with any length of a 2D array.

Sample Output:
    First array:
    5 4 1 1 3
    1 3 3 2 2
    4 3 4 4 2
    5 1 1 3 5
    4 1 5 1 1
    Second array:
    1 3 5 3 3
    3 5 3 4 5
    1 1 3 1 3
    2 2 1 4 3
    5 3 4 4 5
    Result:
    5 12 5 3 9
    3 15 9 8 10
    4 3 12 4 6
    10 2 1 12 15
    20 3 20 4 5

Distractors:
    int[][] a = int[5][5];
    int[][] b = int[5][5];
    result[i] = a[i] * b[i];
    result = a * b;
    result[i][j] = arr[i][i] * b[j][j];
    for( int j=0; j < a.length; j++ )
    System.out.println( result );
    int[][] result = a;
    int [][] result = new int[ 5 ][ 5 ];
    int [][] result = new int [ a.length - 1 ][ b[0].length - 1];
 */

public class MultiDifferent {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        int[][] b = new int[5][5];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int) (Math.random() * 5 + 1);
                b[i][j] = (int) (Math.random() * 5 + 1);
            }
        }
        System.out.println("First array:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
        System.out.println("Second array:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++)
                System.out.print(b[i][j] + " ");
            System.out.println();
        }
        System.out.println("Result:");
        multiply(a, b);
    }

    public static void multiply(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                result[i][j] = a[i][j] * b[i][j];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }

}
