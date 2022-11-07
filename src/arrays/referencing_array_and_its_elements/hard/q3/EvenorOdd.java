package arrays.referencing_array_and_its_elements.hard.q3;
/*
Write a Java program that input an array of 10 integers with positive numbers.
The program creates an array of even numbers and another array of odd numbers. Make a method call EorO that takes the
array and return a string. The string should contain all the even numbers of the array following by all the odd
numbers of the array, separating all the numbers by space. The order between the even numbers and odd number should be
the same as the first array. For example, {4, 1, 2, 3} should be "4 2 1 3" and not "2 4 1 3". Your program should not
add any extra space at the end of the string. Finally, print the string in the main method.

Sample Output:
    Enter 10 positive integers:
    1 2 3 4 ... 6 7 8 9 10
    The separated array is:
    2 4 6 ... 5 7 9
 */

import java.util.Scanner;

public class EvenorOdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 positive integers:");
        for(int i = 0; i < 10; i ++)
            arr[i] = in.nextInt();
        System.out.println("The separated array is:");
        System.out.print(EorO(arr));

    }

    public static String EorO(int[] EvOdd) {
        String ans = "";
        int[] even = new int[EvOdd.length];
        int[] odd = new int[EvOdd.length];
        for (int i = 0; i < EvOdd.length; i++) {
            even[i] = -1;
            odd[i] = -1;
        }
        int evenInd = 0;
        int oddInd = 0;
        for (int i = 0; i < EvOdd.length; i++) {
            if (EvOdd[i] % 2 == 0) {
                even[evenInd] = EvOdd[i];
                evenInd++;
            } else {
                odd[oddInd] = EvOdd[i];
                oddInd++;
            }
        }
        for (int i = 0; i < even.length; i++)
            if (even[i] != -1)
                ans += even[i] + " ";
        for (int i = 0; i < odd.length; i++)
            if (odd[i] != -1)
                ans += odd[i] + " ";
        ans = ans.trim();
        return ans;
    }
}
