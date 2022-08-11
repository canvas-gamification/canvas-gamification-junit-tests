package arrays.programs_involving_data_sequences.hard.q2;
/*
In the tile-based game Mahjong, players compete to see who has the best combinations in a 10-tile set. One of these
combinations is called a meld, which are groups of three, four, or five tiles. To be a valid meld, the tiles must have
identical numbers {2, 2, 2}, or be a run of successive numbers {2, 3, 4}. Write a program where the main method prompts
the user to input a 10-tile set and then calls a method named validMeld that takes an array as input and returns true if
the array contains a valid 3-tile meld and false otherwise. Your program should print "Valid" if the method returns true
and "Not valid" if it returns false.

The method checks if a meld of identical numbers exists or if a meld of consecutive numbers exists. In the latter case,
you can assume that the input array will be in ascending order (smallest to largest). Note that your method should be
general enough to handle an input array of any length.

Sample Output:
    Please enter the 10 tile set:
    1
    2
    3
    5
    1
    8
    1
    4
    9
    3
    Valid
 */
import java.util.Scanner;

public class MyJong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the 10 tile set:");
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++)
            arr[i] = input.nextInt();
        if (containsValidMeld(arr))
            System.out.println("Valid");
        else
            System.out.println("Not Valid");
    }

    public static boolean containsValidMeld(int[] arr) {
        for(int i = 0; i < arr.length - 2; i ++) {
            if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2])
                return true;
            if (Math.abs(arr[i] - arr[i + 1]) == 1 && Math.abs(arr[i + 1] - arr[i + 2]) == 1)
                return true;
        }
        return false;
    }
}
