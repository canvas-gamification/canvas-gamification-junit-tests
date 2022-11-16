package arrays.referencing_array_and_its_elements.hard.q5;
/*
Write a Java program that takes an array of 10 doubles between 0 and 100, indicating scores for ten students. Then,
traverse through the array and print out the index of students on the same line separated by spaces (Eg: "3 4 6 " )
who got below 60% in the course, indicating that those students need help. Your program should use a method called SNH
that takes a double array and print the indices of the students needing help, and the method should be general enough to
work with any array length. Assume that the user will enter numbers between 0 and 100 (inclusive).

Sample Output:
    Enter 10 double numbers:
    76.9 50.8 68.4 95.7 88.6 81.2 89.5 74.9 12.76 64.0
    The indices of students needing help are:
    1 8
 */

import java.util.Scanner;

public class StudentsNeedHelp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[10];
        System.out.println("Enter 10 double numbers:");
        for (int i = 0; i < 10; i++)
            arr[i] = in.nextDouble();
        System.out.println("The indices of students needing help are:");
        SNH(arr);
    }

    public static void SNH(double[] arr) {
        String ans = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 60.0) {
                ans += i + " ";

            }
        }
        System.out.print(ans.trim());
    }
}
