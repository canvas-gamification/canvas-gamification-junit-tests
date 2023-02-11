package arrays.programs_involving_multidimensional_data.medium.q7;

/*
Write a Java program that initializes a 2D array of size 10 by 10, with randomly generated integers in the range of 1 to
100 (inclusive of both values), and print each row in a line. Then use a method called addorSub, which adds 4 to
the element if it is even and subtracts 3 from it if it is odd. Display the resulting array as output.

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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100 + 1);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
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
