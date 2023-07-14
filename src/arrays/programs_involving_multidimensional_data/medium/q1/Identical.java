package arrays.programs_involving_multidimensional_data.medium.q1;

/*
Make a Java program that initializes two integer arrays of the same size and checks if each element in the first array
matches the corresponding element in the second array. If any pair of elements are not the same print the index of the
differing elements. For example, if arr1[x][y] = 5, and arr2[x][y] = 6, you would print "The elements at index [x][y]
are different".

Sample output:
    The elements at index [0][0] are different
    The elements at index [0][4] are different
    The elements at index [1][1] are different
    The elements at index [2][2] are different
    The elements at index [3][0] are different
    The elements at index [3][3] are different
    The elements at index [4][0] are different
    The elements at index [4][3] are different

Distractors:
for (int i = 0; i <= a.length; i++)
for (int i = 0; i <= a.length; i++)
for (int j = 0; j <= a[i].length; j++)
if ( a[i][j] == b[i][j] )
if( a[i] == b[i] )
int[][] a = new int[][]{
int[][] b = new int[][]{
int[] a = {
int[] b = {
public static void main (String args)
int[][] b =
 */

public class Identical {
    public static void main(String[] args) {
        int[][] a = {
                {26, 4, 12, 67, 325}, //a1
                {89, 448, 59, 32, 5}, //a2
                {9, 53, 282, 3, 413}, //a3
                {782, 24, 6, 462, 13}, //a4
                {40, 12, 424, 404, 9} //a5
        };
        int[][] b = {
                {27, 4, 12, 67, 31}, //b1
                {89, 4, 59, 32, 5}, //b2
                {9, 53, 281, 3, 413}, //b3
                {72, 24, 6, 926, 13}, //b4
                {42, 12, 424, 414, 9} //b5
        };

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] != b[i][j])
                    System.out.println("The elements at index [" + i + "][" + j + "] are different");

    }
}
