package arrays.programs_involving_multidimensional_data.hard.q2;

/*
Write a Java program called Swapped, in the main method initialize a 5 by 5 array and fill it with random numbers
between 0 and 100, inclusive. Print out the original array, with spaces between each number and a new line between each
row in the array. Add an extra new line. Then swap the first and last item in each row of the array, and print the
results with spaces in between numbers and a new line in between each row of the array.

Sample output:
    48 9 38 32 69
    3 85 29 30 70
    1 96 34 68 81
    52 8 24 86 47
    40 50 19 59 55

    69 9 38 32 48
    70 85 29 30 3
    81 96 34 68 1
    47 8 24 86 52
    55 50 19 59 40
 */

public class Swapped
{
    public static void main( String[] args )
    {
        int[][] arr = new int[5][5];
        for( int i = 0; i < arr.length; i++ )
            for( int j = 0; j < arr[i].length; j++ )
                arr[i][j] = ( int ) ( Math.random() *100 ) + 1;

        for( int i = 0; i < arr.length; i++ ) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();

        for( int i = 0; i < arr.length; i++ ){
            int first = arr[i][ 0 ];
            int last = arr[i][ arr[i].length - 1];
            arr[i][ arr[i].length - 1] = first;
            arr[i][0] = last;
        }
        for( int i = 0; i < arr.length; i++ ) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
