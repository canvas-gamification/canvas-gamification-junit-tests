package arrays.programs_involving_multidimensional_data.hard.q3;

/*
Write a Java program that initializes an 8 by 8 2D array with random values from 0 to 10 (inclusive of both values) and 
generates a random index between 0 and 63 (exclusive), printing both to the console. Then, write a function called find 
that takes a 2D array and an index and prints out the value at that index. Note that the index is some number from 0 to 
n * m, where n is the number of rows and m is the number of columns in the passed 2D array. For example, if we want to 
fetch the value at index 37, that would mean the value at row 3, column 7. Use this function to print the value in the 
generated 2D array at the randomized index.

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
