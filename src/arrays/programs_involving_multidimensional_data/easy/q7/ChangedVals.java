package arrays.programs_involving_multidimensional_data.easy.q7;

/*
Write a Java program that creates a 2D array of random double values of size 3 by 3, with a range of values from 1-1000
(inclusive of both values), print the generated 2D array each row in a line. Then convert all of its values into a new
integer array and add 30 to each value. Finally, print out the contents of the new integer array, each row in a line.
 */

public class ChangedVals {
    public static void main(String[] args) {
        double[][] arr = new double[3][3];
        int[][] arr2 = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (Math.random() * 1000) + 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = (int) arr[i][j] + 30;
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}

