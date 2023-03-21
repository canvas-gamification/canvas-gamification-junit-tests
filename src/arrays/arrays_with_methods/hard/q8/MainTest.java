package arrays.arrays_with_methods.hard.q8;

public class MainTest {
    // Java

    private static int[] result( int size )
    {
        int [] result = new int[size];
        result[0] = 1;
        result[1] = 1;
        for( int i = 2; i < result.length; i++ )
            result[i] = result[ i - 1 ] + result[ i - 2 ];
        return result;
    }
}
