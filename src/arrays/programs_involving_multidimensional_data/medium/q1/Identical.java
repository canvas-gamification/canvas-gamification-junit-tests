package arrays.programs_involving_multidimensional_data.medium.q1;

/*
Write a Java program that initializes two integer arrays of size 5 by 5 and prompts the user to input values for them.
Then, check to see if each element in the first array matches the corresponding element in the second array. If any pair
of elements are not the same, print "different", otherwise, do nothing. For example, if arr1[x][y] = 5, and arr2[x][y]
= 6, you would print different.

Sample output:
    Enter 5 values for array a row 0:
    1 2 3 4 5
    Enter 5 values for array a row 1:
    1 2 3 4 5
    Enter 5 values for array a row 2:
    1 2 3 4 5
    Enter 5 values for array a row 3:
    1 2 3 4 5
    Enter 5 values for array a row 4:
    1 2 3 4 5
    Enter 5 values for array b row 0:
    1 2 3 4 5
    Enter 5 values for array b row 1:
    1 2 3 4 5
    Enter 5 values for array b row 2:
    5 4 3 2 1
    Enter 5 values for array b row 3:
    1 2 3 4 5
    Enter 5 values for array b row 4:
    1 2 3 4 5
    different
    different
    different
    different

Distractors:
for (int i = 0; i <= a.length; i++)
for (int i = 0; i <= a.length; i++)
for (int j = 0; j <= a[i].length; j++)
if ( a[i][j] == b[i][j] )
if( a[i] == b[i] )
int[][] a = new int[][];
int[][] b = new int[][];
int[] a = new int[5];
int[] b = new int[5];
public static void main (String args)
int[][] b = new int[5][5]
 */

import java.util.Scanner;

public class Identical {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] a = new int[5][5];
        int[][] b = new int[5][5];
        for (int i = 0; i < a.length; i++) {
            System.out.println("Enter 5 values for array a row " + i + ": ");
            a[i][0] = input.nextInt();
            a[i][1] = input.nextInt();
            a[i][2] = input.nextInt();
            a[i][3] = input.nextInt();
            a[i][4] = input.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("Enter 5 values for array b row " + i + ": ");
            b[i][0] = input.nextInt();
            b[i][1] = input.nextInt();
            b[i][2] = input.nextInt();
            b[i][3] = input.nextInt();
            b[i][4] = input.nextInt();
        }
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] != b[i][j])
                    System.out.println("different");

    }
}
