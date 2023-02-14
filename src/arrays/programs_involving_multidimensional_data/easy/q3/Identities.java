package arrays.programs_involving_multidimensional_data.easy.q3;

/*
Write a Java program that randomly generates a 2D integer array of size 3 by 3 where each element is either 0 or 1, and
prints it. Pass that array to a method called checkMatrix which prints out true if the array is an identity matrix and
false otherwise. Recall that an identity matrix is a square array where every element is 0 except the elements in the
top left to the bottom right diagonal which are 1's.

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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
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
