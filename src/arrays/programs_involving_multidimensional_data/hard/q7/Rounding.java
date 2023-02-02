package arrays.programs_involving_multidimensional_data.hard.q7;

/*
Suppose you have a 2D array that stores student assignment grades. In particular, each row represents the grades for a
different assignment from all the students. You have to enter the student grades into a database and suddenly realize
that the database only takes integers and not decimal numbers. So you will round the grade down for each student. Write
a program that carries this conversion out. Write a Java Program , that makes a 5 * 5 2D array and fills it with random
numbers between 0 to 100, and prints it. Then create a called rounding function to round down each of the grades in the
array to the floor, then return that integer array. Finally, print the rounded 2D array.

Sample Output:
    The random 2D array:
    13.544899944021337 64.70135979770244 94.23929312655405 76.63092238189374 30.521198148351885
    73.87021267607889 55.60484892629431 98.77330545415433 67.68255298571691 41.130201268970794
    55.973958811385735 40.962744378988404 53.3910570924838 64.24435158238697 88.942819126096
    6.243920961189118 19.73357192213495 51.13095170984741 78.86428587056578 22.313021248589447
    26.246488602006227 30.86133848517529 3.8830410017390524 52.67181102841428 8.485511662236396
    The rounded 2D array:
    13 64 94 76 30
    73 55 98 67 41
    55 40 53 64 88
    6 19 51 78 22
    26 30 3 52 8
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
        for(int i = 0; i < ans.length; i ++){
            for(int j = 0; j < ans[i].length; j ++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] rounding(double[][] arr) {
        int[][] ans = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                ans[i][j] = (int)Math.floor(arr[i][j]);
            }
        return ans;
    }

}
