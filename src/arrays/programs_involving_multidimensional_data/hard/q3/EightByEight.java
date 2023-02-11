package arrays.programs_involving_multidimensional_data.hard.q3;

/*
Write a Java program that initializes an 8 by 8 2D array with random values from 0 to 10 (inclusive of both values) and
prints each row in a line. Then write a function called to find that takes a 2d array
and an index, and prints out the value at that index. Using that, find the value of the element at index 7.
Consider some examples with an 8 by 8 array. Index 2 points to the element in the first row and the third column. Index
8 points to the element in the second row and the first column. Index 16 points to the element in the third row and the
first column.
Note that your find method should be general enough to work with any size of a 2D array.

Sample Output:
    2 3 3 6 8 5 3 4
    6 2 4 8 9 0 9 7
    4 2 5 2 2 5 4 6
    1 7 8 0 6 10 3 3
    8 7 5 2 3 6 10 0
    7 6 1 5 8 6 3 8
    0 10 9 2 0 8 6 8
    1 6 9 3 3 4 4 9
    4
 */

public class EightByEight {
    public static void main(String[] args) {
        int[][] arr = new int[8][8];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 11);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(find(arr, 7));
    }

    public static int find(int[][] arr, int postion) {
        int row = postion / arr.length;
        int column = postion % arr.length;
        return (arr[row][column]);
    }

}
