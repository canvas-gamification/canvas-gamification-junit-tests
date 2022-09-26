package arrays.arrays_with_methods.medium.q9;

/*
Make a program that will calculate the factorial of each element in a 2D array and store the factorial of each element
of the array into a separate 2D array, and print the resulting array. Use a method called fact to calculate the factorial
of a given number.
Sample output:
24 120 720
2 1 2
6 6 40320
 */

public class TwoDAndThatsAFact
{
    public static int fact( int n )
    {
        int res = 1;
        for( int i = 1; i <= n; i++ )
            res *= i;
        return res;
    }
    public static void main( String [] args )
    {
        int [][] a = {
                {4, 5, 6},
                {2, 1, 2},
                {3, 3, 8}
        };
        int [][] c = new int[ a.length ][ a[0].length ];
        for( int i = 0; i < c.length; i++ )
            for( int j = 0; j < c[i].length; j++ )
                c[i][j] = fact( a[i][j] );
        for( int i = 0; i < c.length; i++ )
        {
            for( int j = 0; j < c[i].length; j++ )
                System.out.print(c[i][j]+" ");
            System.out.println();
        }
    }
}
