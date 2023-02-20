package arrays.multidimensional_arrays.hard.q7;

/*
Imagine a 2D array that has 3 rows and 3 columns, forming a square shape. In a square 2D array, there are
two diagonals that form an "X". Make a program that defines a 2D array and prints the sum of all the elements in both
diagonals of a square 2D array. For example, suppose the square 2D has 4 rows and 4 columns and is:
1 2 3 4
5 6 7 8
9 8 3 1
3 4 5 8
Then your program should print 18 and 22, because you get 1 + 6 + 3 + 8 = 18 from one diagonal and 4 + 7 + 8 + 3 = 22
from the other. Note that the square array can be of any size (that means, <i>k</i> can be any value), but it will
always have the same number of rows and columns.

Distractors:
    for( int i = 0; i < nums.length(); i++ )
    for( int j = 0; j < nums[count].length; j++ )
    for( int j = 0; j < nums[i].length(); j++ )
    for( int j = 0; j < nums[i].length; i++ )
    sumDiagOpp += nums[count][j];
    sumDiagOpp = sumDiagOpp + nums[i][j];
    count++;
    int count = nums[0].length;
    sumDiag++;
    sumDiag += nums[i][count];
    if( i != j )
    break;


 */

public class SumDiags {
    public static void main(String[] args) {
        int[][] nums = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}};
        int count = nums[0].length - 1;
        int sumDiag = 0;
        int sumDiagOpp = 0;
        for (int i = 0; i < nums.length; i++) {
            sumDiagOpp += nums[i][count];
            count--;
            for (int j = 0; j < nums[i].length; j++)
                if (i == j)
                    sumDiag += nums[i][j];
        }
        System.out.println("Sum of diagonal 1  = " + sumDiag + ", Sum of diagonal 2 = " + sumDiagOpp);
    }
}
