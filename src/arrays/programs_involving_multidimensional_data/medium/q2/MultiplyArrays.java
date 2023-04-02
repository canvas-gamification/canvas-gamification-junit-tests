package arrays.programs_involving_multidimensional_data.medium.q2;

/*
Write a Java program that initializes a 2 x 3 2D array with values {{2, 3, 4}, {4, 5, 1}} and then randomly generates
an integer multiplier in the range of 5 and 10 (inclusive of both values). The program prints the multiplier then calls
a method increaseBy that takes the 2D array and the multiplier as input, multiplies all the elements in the 2D array by
the multiplier, and then prints the array in the main method. The increaseBy method should not return the array. Note
that you increaseBy method should be generalized to work with any 2D array length.

Sample output:
    Random Multiplier: 8
    Modified Array:
    16 24 32
    32 40 8

Distractors:
    return arr;
    {
    }
    arr = increaseBy( mult, arr );
    arr = increaseBy( arr, mult );
    increaseBy( arr );
    increaseBy( mult );
    arr[i][j] += mult;
    arr[i][j] /= mult;
    arr[i][j] = mult;
    int mult = (int) (Math.random() * (5) + 10);
    int mult = (int) (Math.random() * (5) + 6);
 */

public class MultiplyArrays {
    public static void main(String[] args) {
        int[][] arr = {{2, 3, 4}, {4, 5, 1}};
        int mult = (int) (Math.random() * (6) + 5);
        System.out.println("Random Multiplier: " + mult);
        increaseBy(arr, mult);
        System.out.println("Modified Array: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void increaseBy(int[][] arr, int m) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = arr[i][j] * m;
    }
}
