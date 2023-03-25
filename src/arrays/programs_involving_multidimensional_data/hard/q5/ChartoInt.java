package arrays.programs_involving_multidimensional_data.hard.q5;

/*
Write a Java program that initializes a 2 by 13 2D array with random integers between 97 to 122 (Inclusive of both ends), 
and print it. The program will then with a method called intToChar to convert each one of those integer values into a 
character and display each row of the 2D array on a separate line in that method. Note: the characters within a line do 
not need any spaces between them, and your intToChar method should only print the values of the array and not return anything. 

Sample Output:
    Initialized array:
    105 112 110 121 109 112 115 117 99 111 108 113 116
    118 105 100 121 122 97 112 115 105 122 110 120 109
    Converted to char:
    ipnympsucolqt
    vidyzapsiznxm
 */

public class ChartoInt {
    public static void main(String[] args) {
        int[][] arr = new int[2][13];
        System.out.println("Initialized array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 97 + (int) (Math.random() * 26);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Converted to char:");
        intToChar(arr);
    }

    public static void intToChar(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print((char) arr[i][j]);
            }
            System.out.println();
        }
    }

}
