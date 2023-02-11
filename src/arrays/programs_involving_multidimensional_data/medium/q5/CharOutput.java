package arrays.programs_involving_multidimensional_data.medium.q5;

/*
Write a Java program that defines a 2D array of characters of size 2 by 13, initialized with the character corresponding
to the ASCII numbers starting at 97, then 98, 99, and so on until 122. The program also prints out all the
characters in each row (without any space separator). Repeat for each row printed on a separate
line.

Distractors:
    char[][] arr = new char[13][2];
    int index = 0;
    index = 97;
    char index = 97;
    arr[i][j] = index;
    {
    }
    char[][] arr = new char[3][14];
    arr[i][j] = ( char ) 97;
 */

public class CharOutput {
    public static void main(String[] args) {
        char[][] arr = new char[2][13];
        int index = 97;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (char) index;
                index++;
            }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }

}
