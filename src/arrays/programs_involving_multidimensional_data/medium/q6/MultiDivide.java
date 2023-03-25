package arrays.programs_involving_multidimensional_data.medium.q6;

/*
Write a Java program that initializes a 2D integer array of size 10 by 10, with randomly generated numbers in
range of 1 to 10 (inclusive of both values), and print each row of the array on a separate line. Then, multiply each value by 10 and divide
each by 3.14. Lastly, print the resulting array.

Sample Output:
    Generated array:
    9 7 9 5 ... 7 6
    .             .
    .             .
    .             .
    3 9 8 5 ... 5 5
    Multiplied array:
    28 22 28 15 ... 22 19
    .                  .
    .                  .
    .                  .
    9 28 25 15 ... 15 15

Distractors:
    arr[i][j] = arr[i][j]/10 / 3.14;
    arr[i] = arr[i][j]*10 / 3.14;
    arr[j][j] = arr[i][j]*10/3;
    arr[i][j] = ( int ) (Math.random() * 9) + 1;
    for( int i=0; i<arr.length; i++ )
    for( int j=0; j<arr[i].length; j++ )
    for( int j=0; j<arr[0].length; j++ )
    for( int j=0; j<arr.length; j++ )
    for( int i=0; i<arr.length; i++ )
    for( int i=0; i<arr.length; i++ )
 */

public class MultiDivide {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        System.out.println("Generated array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 10 + 1);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Multiplied array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (arr[i][j] * 10 / 3.14);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
