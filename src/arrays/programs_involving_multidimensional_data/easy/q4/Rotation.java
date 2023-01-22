package arrays.programs_involving_multidimensional_data.easy.q4;

/*
Write a Java program that initializes a 2D array of random integers of size 4 by 4, with the range of values from 1 - 99
(inclusive of both values). Then, "rotate" the elements in the four corners of the array towards the clockwise direction
using a method called rotateArray and print the result in the method. You should print the 2D array before and after the
rotation.
 */

public class Rotation {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        System.out.println("Before the rotation:");
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 99) + 1;
                System.out.println(arr[i][j]);
            }
        System.out.println("After the rotation:");
        rotateArray(arr);
    }

    public static void rotateArray(int[][] arr) {
        int temp = arr[0][0];
        arr[0][0] = arr[arr.length - 1][0];
        arr[arr.length - 1][0] = arr[arr.length - 1][arr[0].length - 1];
        arr[arr.length - 1][arr[0].length - 1] = arr[0][arr[0].length - 1];
        arr[0][arr[0].length - 1] = temp;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                System.out.println(arr[i][j]);
    }
}
