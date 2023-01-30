package arrays.programs_involving_multidimensional_data.easy.q8;

/*
Make a Java program that generates a 5 by 5 2D array of random integers ranging from 1-1000 (inclusive on both ends),
and print it. Then, multiply all the elements of the array by 5 if the element is even and by 3 if the element is odd.
Lastly, print out the array at the end of the program with each row of numbers on a separate line.
 */

public class EvenOrOdd {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 1000) + 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 2 == 0)
                    arr[i][j] = arr[i][j] * 5;
                else
                    arr[i][j] = arr[i][j] * 3;
            }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
