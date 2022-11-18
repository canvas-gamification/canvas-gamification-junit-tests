package arrays.creatings_arrays.medium.q3;

/*
Make a Java program that creates an array of 100 random integers from the range of 0-9, inclusive of both 0 and 9, using
the Math.random() function, then prints them out on separate lines.

Sample output:
    5
    7
    1
    ...
    6
 */

public class RandomNum
{
    public static void main(String[] args)
    {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++)
            arr[i] = (int)(Math.random() * (9+1));
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
