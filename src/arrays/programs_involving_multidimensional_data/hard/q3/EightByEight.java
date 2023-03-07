package arrays.programs_involving_multidimensional_data.hard.q3;

/*
Write a Java program that initializes an 8 by 8 2D array with random values from 0 to 10 (inclusive of both values) and
prints it. Then write a function called find that takes a 2D array
and an index, and prints out the value at that index.
Consider some examples with an 8 by 8 array. The index of an element in row i and column j in an n * m 2D array is
i * n + j (We are using 0 based numbering).
Generate a random index value from 0 to 64 and print it. Consider that the input is always valid.
Note that your find method should be general enough to work with any size of a 2D array.

Sample Output:
    Generated 2D array:
    2 3 3 6 8 5 3 4
    6 2 4 8 9 0 9 7
    4 2 5 2 2 5 4 6
    1 7 8 0 6 10 3 3
    8 7 5 2 3 6 10 0
    7 6 1 5 8 6 3 8
    0 10 9 2 0 8 6 8
    1 6 9 3 3 4 4 9
    Generated index: 7
    The value at index 7 is: 4
 */

public class EightByEight {
    public static void main(String[] args) {
        int[][] arr = new int[8][8];
        System.out.println("Generated 2D array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 11);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int index = (int) (Math.random() * 64);
        System.out.println("Generated index: " + index);
        System.out.println("The value at index " + index + " is: " + find(arr, index));
    }

    public static int find(int[][] arr, int postion) {
        int row = postion / arr.length;
        int column = postion % arr.length;
        return (arr[row][column]);
    }

}
