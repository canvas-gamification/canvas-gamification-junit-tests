package loops.simple_programs_with_repetition.hard.q9;

/*
Write a Java program that asks for a binary number as input and converts it to decimal. To convert a binary number to decimal, each digit must be
extracted from the number and multiplied by 2^n (the digits place value), where n is the index of the digit. For example,
to convert the number 1010: (0 * 2^0) + (1 * 2^1) + (0 * 2^2) + (1 * 2^3) = 0 + 2 + 0 + 8 = 10. Also, the program should
make sure that the input number is in binary (each digit should be 1 or 0, and the number should be greater than or equal to 0).
If it is not a binary number, print "Invalid number!". Otherwise, the program should print "x in base ten is equal to y",
where x is the binary number input, and y the decimal equivalent.

Sample Output:
    Enter a binary number:
    1010
    1010 in base ten is equal to 10
*/

import java.util.Scanner;

public class OutTheBin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a binary number: ");
        int binary = input.nextInt();
        int n = binary;
        int i = 0;
        int d;
        int result = 0;
        boolean isBinary = binary >= 0;
        while (n > 0) {
            d = n % 10;
            if (d != 1 && d != 0) {
                isBinary = false;
                break;
            }
            result += d * Math.pow(2, i);
            i++;
            n = n / 10;
        }
        if (isBinary)
            System.out.printf("%d in base ten is equal to %d\n", binary, result);
        else
            System.out.println("Invalid number!");
    }
}
