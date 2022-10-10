package arrays.programs_involving_data_sequences.easy.q7;

/*
Make a Java program that calls a method that takes as input an array of integers in an unknown order and returns the
smallest element in the array. You can assume the numbers in the array are in the range of 0 and 100. In the main method,
print the smallest element.
 */

public class WhereIsIt
{
    public static void main( String [] args )
    {
        int [] arr = {71,3,95,67,99};
        int min = smallestFinder(arr);
        System.out.println(min);
    }
    public static int smallestFinder( int[] input )
    {
        int smallest = 101;
        for (int i = 0;i <input.length;i++)
            if (smallest>input[i])
                smallest = input[i];
        return smallest;
    }
}
