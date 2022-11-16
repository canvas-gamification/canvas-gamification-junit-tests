package arrays.referencing_array_and_its_elements.hard.q4;

/*
Write a Java program that takes an array of 10 doubles between 0 and 100, indicating course grades for ten students.
Then, traverse through the array and print out the index of students on the same line separated by spaces (Eg: "3 4 6 " )
who got above 88% in the course, indicating they are potential candidates for teaching assistants next year. To do this,
create a method called PGS that takes the double array of grades and prints out the indices of the candidate students.
Your method should be general enough to work with any length of array.

Sample Output:
    Enter 10 double numbers:
    76.9 50.8 68.4 95.7 88.6 81.2 89.5 74.9 12.76 64.0
    The indices of potential candidates for teaching assistants are:
    3 4 6
 */

import java.util.Scanner;

public class PotentialGoodStudents {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[10];
        System.out.println("Enter 10 double numbers:");
        for (int i = 0; i < 10; i++)
            arr[i] = in.nextDouble();
        System.out.println("The indices of potential candidates for teaching assistants are:");
        PGS(arr);
    }

    public static void PGS(double[] arr) {
        String ans = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 88.0) {
                ans += i + " ";

            }
        }
        System.out.print(ans.trim());
    }
}
