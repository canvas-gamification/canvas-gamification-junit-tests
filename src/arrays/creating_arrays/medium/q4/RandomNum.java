package arrays.creating_arrays.medium.q4;

/*
Make a Java program that initializes an array of 100 random integers from the range of 0-9, inclusive of both 0 and 9,
using the Random class.
Sample output:
5
7
1
...
6
 */

import java.util.Random;

public class RandomNum {
    public static void main(String[] args) {
        Random gen = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = gen.nextInt(10);
            System.out.println(arr[i]);
        }
    }
}
