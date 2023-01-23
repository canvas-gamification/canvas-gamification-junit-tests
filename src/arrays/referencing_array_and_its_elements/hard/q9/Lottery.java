package arrays.referencing_array_and_its_elements.hard.q9;

/*
Write a Java program that randomly generates an array of integers with 7 elements. Each element should have 5 digits
representing ticket numbers for a prize draw. Print out the list of tickets then generate a random index for the array
and display the index and corresponding ticket number as the winning ticket.

Sample Output:
    The list of tickets are:
    12312 24123 13123 45765 45626 13373 13153
    The winner is the ticket number 3 with number 13123.
 */

public class Lottery {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = 10000 + (int) (Math.random() * (100000 - 10000));
        System.out.println("The list of tickets are:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        int idx = (int) (Math.random() * arr.length);
        System.out.println("The winner is the ticket number " + (idx + 1) + " with number " + arr[idx] + ".");
    }

}
