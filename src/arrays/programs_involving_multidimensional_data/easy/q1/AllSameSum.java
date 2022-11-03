package arrays.programs_involving_multidimensional_data.easy.q1;

/*
A magic square is a box of numbers where each row and column has the same sum. Write a Java program that initialises a
4 by 4 multidimensional array of integers with values between 1 to 10 (inclusive of both ends), and prints true if all
the rows have the same sum and false otherwise.
 */

public class AllSameSum
{
    public static void main(String[] args)
    {
        int[][] arr = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 7, 1, 2}, {3,4,5,6}};
        boolean sumEqual = true;
        int [] sumArray = new int[arr.length];
        for( int i = 0; i < arr.length; i++ )
            for( int j = 0; j < arr[i].length; j++ )
                sumArray[i] += arr[i][j];
        for( int i = 0; i < sumArray.length - 1; i++ )
            if( sumArray[i] != sumArray[i + 1])
                sumEqual = false;
        System.out.println(sumEqual);
    }
}
