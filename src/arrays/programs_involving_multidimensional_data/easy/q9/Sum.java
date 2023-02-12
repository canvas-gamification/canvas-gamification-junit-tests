package arrays.programs_involving_multidimensional_data.easy.q9;

/*
Write a Java program that generates a 20 by 20 2D array of random integers ranging from 100-1000 (inclusive on both ends),
and print the 2D array with each row a seperate line. Divide all the values by 5, then sum all the values in each row and
store those sums into a 1D array. Print the array of sums to the console.
 */

public class Sum {
    public static void main(String[] args) {
        int[][] arr = new int[20][20];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 100 + (int) (Math.random() * 901);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr[i][j] / 5;
                sum = sum + arr[i][j];
            }
            out[i] = sum;
        }
        for (int i = 0; i < out.length; i++)
            System.out.print(out[i] + " ");
    }
}
