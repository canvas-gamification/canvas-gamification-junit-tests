package arrays.programs_involving_multidimensional_data.hard.q5;

/*
Write a Java program that initializes a 2 in 13 2D array with random integer between 97 to 122 (Inclusive of both ends),
and print it. The program will then convert each one of those integer values into a character and display each row of
the 2D array on a separate line.
Note: the characters within a line do not need any spaces in between them.

Sample Output:
    105 112 110 121 109 112 115 117 99 111 108 113 116
    118 105 100 121 122 97 112 115 105 122 110 120 109
    ipnympsucolqt
    vidyzapsiznxm
 */

public class ChartoInt {
    public static void main(String[] args) {
        int[][] arr = new int[2][13];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 97 + (int) (Math.random() * 26);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print((char) arr[i][j]);
            }
            System.out.println();
        }
    }

}
