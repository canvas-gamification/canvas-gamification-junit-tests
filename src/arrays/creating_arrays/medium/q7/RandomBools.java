package arrays.creating_arrays.medium.q7;

/*
Make a Java program that creates a boolean array of 100 elements whose initial value is set to true 50% of the
time and set to false otherwise. Print the resulting array to the console.
Sample output:
false
true
true
...
true
false
 */

public class RandomBools
{
    public static void main (String[] args)
    {
        boolean [] brr = new boolean[100];
        for( int i = 0; i < 100; i++)
        {
            double val = Math.random();
            if ( val > 0.5 )
                brr[i] = true;
            else
                brr[i] = false;
        }
        for (int i = 0; i < brr.length; i++)
            System.out.println(brr[i]);

    }
}
