package arrays.programs_involving_multidimensional_data.easy.q5;

/*
Write a Java program that generates a 2D array of size 5 by 5, with random integers in the range of 1 and 999
(inclusive of both values). Then, print out those values with each row on its own line and the numbers separated by a
space.
 */

public class ValueLock {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = (int) (Math.random() * 999) + 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

}
