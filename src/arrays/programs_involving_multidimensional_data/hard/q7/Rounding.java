package arrays.programs_involving_multidimensional_data.hard.q7;

/*
Suppose you have a 2D array that stores student assignment grades.  You have to enter the student grades into a database
and suddenly realize that the database only takes integers, so you will need to round the student's grades.
Write a Java Program that makes a 5 by 5 2D array, fills it with random
numbers between 0 to 100, and prints it. Then create a method called rounding to round each of the grades in the
array by thaking the double array, and returns that integer array. Finally, print the rounded 2D array.
Note that your rounding method should be general enough to work with any size of 2D array.

Sample Output:
    The random 2D array:
    1.9338482384426119 46.59835249491862 81.01173638264179 63.70336265471519 26.896058098483472
    65.98237391038224 79.72196744223793 56.33921258158885 23.213405222932785 60.21131681612218
    100.34856192363331 47.33455010753071 42.184489896873785 20.145072072441497 91.68668195260074
    8.313453517738312 61.67094917049669 54.11214691680937 5.907644791339368 68.3065090623183
    78.1290800203377 89.60667150546287 13.015885961478071 46.95144084024514 21.19032689829607
    The rounded 2D array:
    2 47 81 64 27
    66 80 56 23 60
    100 47 42 20 92
    8 62 54 6 68
    78 90 13 47 21
 */

public class Rounding {
    public static void main(String[] args) {
        System.out.println("The random 2D array:");
        double arr[][] = new double[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (Math.random() * 101);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The rounded 2D array:");
        int[][] ans = rounding(arr);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] rounding(double[][] arr) {
        int[][] ans = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                ans[i][j] = (int) Math.round(arr[i][j]);
            }
        return ans;
    }

}
