package arrays.creating_arrays.medium.q1;

/*
//vary length, and whether multiplication is 1 based or 0 based
Make a Java program that creates an array of 100 doubles that stores a random value, then multiplies it by the index of
the current element. Print the two numbers and the results of the array to the console.

Sample output:
0.5526888054528675 * 0 = 0.0
0.9078255328117201 * 1 = 0.9078255328117201
0.9997559500516289 * 2 = 1.9995119001032577
...
0.1623281059668099 * 99 = 16.07048249071418
 */

public class RandomNum
{
    public static void main (String[] args)
    {
        double[] arr1 = new double[100];
        for( int i = 0; i <  100; i++)
            arr1[i] = Math.random();
        double[] arr2 = new double[100];
        for( int i = 0; i <  100; i++)
            arr2[i] = arr1[i]*i;
        for( int i = 0; i <  arr2.length; i++)
            System.out.println(arr1[i] + " * " + i + " = " + arr2[i]);
    }
}
