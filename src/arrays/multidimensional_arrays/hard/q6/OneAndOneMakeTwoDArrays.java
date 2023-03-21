package arrays.multidimensional_arrays.hard.q6;

/*
Make a program that defines two 2D integer arrays and uses a method called addMatrices to add them together to create a
new 2D array. The main method should define the two initial arrays and pass them to the addMatrices method. The method
should check that the two arrays have the same dimensions, otherwise returning null. To add two arrays you take the
elements at the same index, add them together, and place the new number at the same index in the new array. For the sake
of simplicity, assume that the rows in an array have a consistent length. In the main method, if the method returned null,
print an error message and otherwise print the newly created 2D array.
Sample Output:
    The sum of the matrices are:
    4437 2321 9885
    728 208 742
    678 1096 597
    1112 2346 4586
 */

public class OneAndOneMakeTwoDArrays {
    public static void main(String[] args) {
        int[][] a = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583}};
        int[][] b = {{4433, 2316, 9879}, {662, 154, 721}, {69, 98, 54}, {1, 4, 3}};
        int[][] c = addMatrices(a, b);
        if (c != null) {
            System.out.println("The sum of the matrices are:");
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[0].length; j++)
                    System.out.print(c[i][j] + " ");
                System.out.println();
            }
        } else
            System.out.println("Can't add the arrays because they are different sizes!");
    }

    public static int[][] addMatrices(int[][] a, int[][] b) {
        if (a.length == b.length && a[0].length == b[0].length) {
            int[][] c = new int[a.length][a[0].length];
            for (int i = 0; i < c.length; i++)
                for (int j = 0; j < c[i].length; j++)
                    c[i][j] = a[i][j] + b[i][j];
            return c;
        } else
            return null;
    }

}


