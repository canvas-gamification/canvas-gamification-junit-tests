package arrays.programs_involving_multidimensional_data.medium.q7;

/*
Write a Java program that initializes a 2D array of size 10 by 10, with randomly generated integers in the range of 1 to 100 
(inclusive of both values), and prints each row on a separate line with spaces between the values. Then, create a method 
called addorSub, which accepts a 2D array, and goes through each element, adding four to it if it is even and subtracting three 
if it is odd. After, the method should print the resulting output. Call this method on your generated 2D array. Note that the 
only printed output from the method is the 2D array after applying the manipulations.

Sample Output:
    Generated array:
    71 42 33 ... 24
    .            .
    .            .
    .            .
    36 65 34 ... 73
    Resulting array:
    68 46 30 ... 28
    .            .
    .            .
    .            .
    40 62 38 ... 70

Distractors:
    if(arr[i] % 2 == 0)
    if(arr[i][j] / 2 == 0)
    arr[i][j] = arr[i][j] * 4;
    arr[i][j] = arr[i][j] / 4
    arr[j][i] = arr[i][j] * 4;
    arr[i][i] = arr[i][j]/arr[i][j] - 3;
 */

public class MultiDivide {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        System.out.println("Generated array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100 + 1);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Resulting array:");
        addorSub(arr);
    }

    public static void addorSub(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 2 == 0)
                    arr[i][j] = arr[i][j] + 4;
                else
                    arr[i][j] = arr[i][j] - 3;
            }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

}
