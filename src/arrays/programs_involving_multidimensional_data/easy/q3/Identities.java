package arrays.programs_involving_multidimensional_data.easy.q3;

/*
Write a Java program that generates a 2D array of size 3 by 3 made up of random integers that are either 0 or 1, and
print it. Then, use a method called checkMatrix to print out true if the array is an identity matrix and print false
otherwise. Recall that an identity matrix is a square array that has only 1's across its diagonal and 0's everywhere else.
The diagonal of a square matrix are the elements from the top left to the bottom right corner of the matrix.

Below is an example of an identity matrix:
1 0 0
0 1 0
0 0 1

 */

public class Identities {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = (int) (Math.random() * 2);
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[i].length; j ++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        boolean result = checkMatrix(arr);
        System.out.println(result);

    }

    public static boolean checkMatrix(int[][] arr) {
        boolean check = true;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                if (j == i) {
                    if (arr[i][j] != 1)
                        check = false;
                } else {
                    if (arr[i][j] != 0)
                        check = false;
                }
            }
        return check;
    }

}
