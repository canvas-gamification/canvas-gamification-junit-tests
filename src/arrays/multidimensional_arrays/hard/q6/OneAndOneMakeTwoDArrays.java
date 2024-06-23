package arrays.multidimensional_arrays.hard.q6;

/*
Make a program that defines two 2D integer arrays and adds them together to create a new 2D array. The program should
check that the two arrays have the same dimensions, otherwise printing an error message. To add two arrays you take the
elements at the same index, add them together, and place the new number at the same index in the new array. For the sake
of simplicity, assume that the rows in an array have a consistent length. Finally, print the newly created 2D array.

Sample Output:
    The sum of the matrices are:
    443 221 885
    78 20 72
    67 1096 57
    The sum of the matrices are:
    1 1
    1 1
 */

public class OneAndOneMakeTwoDArrays {
    public static void main(String[] args) { //convert to 3d arrays to have one array of each type and construct parsons lines to force all code lines
        int[][][] a = {{{4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583}}, {{1, 0}, {0, 1}}};
        int[][][] b = {{{4433, 2316, 9879}, {662, 154, 721}, {69, 98, 54}, {1, 4, 3}}, {{65, 43, 12}, {54, 65, 32}, {43, 1, 2}}};
        for (int x = 0; x < a.length; x++) {
            if (a[x].length == b[x].length && a[x][0].length == b[x][0].length) {
                int[][] c = new int[a[x].length][a[x][0].length];
                for (int i = 0; i < c.length; i++)
                    for (int j = 0; j < c[i].length; j++)
                        c[i][j] = a[x][i][j] + b[x][i][j];

                System.out.println("The sum of the matrices are:");
                for (int i = 0; i < c.length; i++) {
                    for (int j = 0; j < c[0].length; j++)
                        System.out.print(c[i][j] + " ");
                    System.out.println();
                }
            } else
                System.out.println("Can't add the arrays because they are different sizes!");
        }
    }
}


