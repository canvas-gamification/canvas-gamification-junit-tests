package loops.programs_with_repetition.hard.q2;
/*
Write a java program using nested loops that asks the user for a number 'N' and prints the following pattern up to 'N'
lines. Assume the user enters an integer, and that your output matches the sample. Note how every line after the first
one is obtained by replacing every occurrence of "A" in the previous line with "BA" and every occurrence of "B" in the
previous line with "AA", use this to your advantage when designing this nested-loops solution.
Sample Output:
    A
    BA
    AABA
    BABAAABA
    AABAAABABABAAABA
    …
    N Lines
 */
import java.util.Scanner;

public class Replication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lines: ");
        int n = input.nextInt();
        String str = "A";
        for (int i = 0; i < n; i++) {
            System.out.println(str);
            String temp = "";
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'A')
                    temp += "BA";
                else
                    temp += "AA";
            }
            str = temp;
        }
    }
}
