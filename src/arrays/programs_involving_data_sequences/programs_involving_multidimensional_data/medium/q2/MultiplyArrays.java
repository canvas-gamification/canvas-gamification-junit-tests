package arrays.programs_involving_data_sequences.programs_involving_multidimensional_data.medium.q2;

/*
Write a Java program that defines a 2D array of size 2 by 3 with integers in the range of 1 and 5 (inclusive of both
values). Next, the program needs to randomly generate an integer multiplier in the range of 5 and 10 (inclusive of both
values). The program prints the multiplier, then calls a method increaseBy that takes the 2D array and the multiplier as
input, multiplies all the elements in the 2D array by the multiplier, and returns nothing as output. Lastly, the program
displays all the elements in the array.

Distractors:
return arr;
{
}
arr = increaseBy( mult, arr );
arr = increaseBy( arr, mult );
increaseBy( arr );
increaseBy( mult );
arr[i][j] += mult;
arr[i][j] /= mult;
arr[i][j] = mult;
 */

public class MultiplyArrays
{
    public static void main (String[] args)
    {
        int[][] arr = {{2,3,4}, {4,5,1} };
        int mult = ( int ) (Math.random() * (6)+5);
        System.out.println(mult);
        increaseBy( arr, mult);
        for( int i = 0; i < arr.length; i++ )
        {
            for( int j = 0; j < arr[i].length; j++ )
                System.out.print( arr[i][j] + " " );
            System.out.println();
        }
    }
    public static void increaseBy( int[][] arr,int m)
    {
        for( int i = 0; i < arr.length; i++ )
            for( int j = 0; j < arr[i].length; j++ )
                arr[i][j] = arr[i][j] * m;
    }
}
