package arrays.creating_arrays.hard.q5;

/*
Write a Java program called AlphabetRays to initialize an integer array with 500 randomly generated lowercase letters
of the English alphabet and print each character on the same line. Then print the same array in reverse. Recall that
the character a has the integer equivalent value of 97.

Sample output:
    Array of random letters:
    m y n m ... v b y t
    Reversed array:
    t y b v ... m n y m
 */

public class AlphabetRays {
    public static void main(String[] args) {
        char[] arr = new char[500];
        System.out.println("Array of random letters: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (97 + Math.random() * 26);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Reversed array: ");
        for (int i = arr.length-1; i >= 0; i--)
            System.out.print(arr[i] + " ");
    }
}
