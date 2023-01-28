package arrays.creating_arrays.medium.q6;

/*
Make a Java program that creates a boolean array with 100 elements all initialized to true and prints the array values to the console. 
Sample output:
true
true
...
true
 */

public class TrueBools
{
    public static void main (String[] args)
    {
        boolean [] brr = new boolean[100];
        for( int i = 0; i < 100; i++) {
            brr[i] = true;
            System.out.println(brr[i]);
        }
    }
}
