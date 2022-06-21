package loops.programs_with_repetition.medium.q3;
/*
Write a program to print the following pattern using nested loops with n = 5, where n is the number of lines. Make sure
your output matches the sample.
Sample Output (n = 5):
    123454321
    1234 4321
    123   321
    12     21
    1       1

 */
public class ThisPatternLooksLikePants {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int k = 1; k <= 5 - i; k++)
                System.out.print(k);
            for (int j = 1; j <= (2 * (i - 1) + 1); j++)
                System.out.print(" ");
            int o = 4 - i;
            if (i > 0)
                o++;
            for (; o >= 1; o--)
                System.out.print(o);
            System.out.println();
        }
    }
}
