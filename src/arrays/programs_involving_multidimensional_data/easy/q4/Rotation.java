package arrays.programs_involving_multidimensional_data.easy.q4;

/*
Make a Java program that initalizes a 4 by 4 2D array of random integers ranging between 1 and 99 inclusive of both
values. Then, "rotate" the elements in the four corners of the array clockwise by passing the array to a method called
rotateArray. The method should be able to handle a square 2D array of any size. Print the array before the rotation in
the main method, and the array after the rotation (including the line declaring it to be after the rotation) in rotateArray.

Rotation example:
    Before the rotation:
    17 ... 30
    ... ...
    47 ... 90
    After the rotation:
    47 ... 17
    ... ...
    90 ... 30
 */

public class Rotation {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        System.out.println("Before the rotation:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 99) + 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
