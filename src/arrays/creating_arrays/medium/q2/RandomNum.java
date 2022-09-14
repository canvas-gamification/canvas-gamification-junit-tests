package arrays.creating_arrays.medium.q2;

/*
Make a Java program that stores 26 lowercase alphabet characters from  'a' to  'z' in an array. Print the results of
the array to the console.
Sample output:
a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z,
 */

public class RandomNum
{
    public static void main(String[] args)
    {
        char[] arr = new char[26];
        int index = 0;
        for (int i = 97; i < 123; i++)
        {
            arr[index] = (char) i;
            index++;
        }
        for (int j = 0; j < 26; j++)
            System.out.print( arr[j] + ", " );
    }
}
