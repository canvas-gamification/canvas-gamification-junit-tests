package arrays.programs_involving_multidimensional_data.medium.q6;

/*
Write a Java program that initializes a 2D integer array of size 5 by 5, with numbers that are randomly generated in
range of 1 to 10 (inclusive of both values), and print it each row in a line. Then, multiply each value by 10 and divide
each by 3.14. Lastly, print the resulting array.

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
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 10 + 1);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (arr[i][j] * 10 / 3.14);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
