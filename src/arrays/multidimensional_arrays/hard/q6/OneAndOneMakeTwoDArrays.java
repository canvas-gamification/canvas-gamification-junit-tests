package arrays.multidimensional_arrays.hard.q6;

/*
Make a program that defines two 2D integer arrays and add them together to create a new 2D array. That is, you add each
element of the array at the same position and store them in the respective position in the new array. Make sure to check
if the two 2D arrays are of equal dimensions, because otherwise they cannot be added together. To keep things simple,
you can assume that all the rows of the 2D array are always of the same length. Lastly, print the newly created 2D array.
 */

public class OneAndOneMakeTwoDArrays {
    public static void main( String [] args ) {
        int [][] a = { {4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583}  };
        int [][] b = { {4433, 2316, 9879}, {662, 154, 721}, {69, 98, 54},{1, 4, 3}  };
        if( a.length == b.length  && a[0].length == b[0].length ){
            int [][] c = new int[ a.length ][ a[0].length ];
            for( int i = 0; i < c.length; i++ )
                for( int j = 0; j < c[i].length; j++ )
                    c[i][j] = a[i][j] + b[i][j];
            for( int i = 0; i < c.length; i++){
                for( int j = 0; j < c[i].length; j++ )
                    System.out.print(c[i][j] + " ");
                System.out.println();
            }
        }
        else
            System.out.println("Can't add because arrays of different sizes!");
    }
}


