package loops.while_loops.hard.q1;
/*
Write a program that will print the numbers from 0 to -100 (inclusive) using a while loop.

Distractors:
    while(i >= -100 );
    while i >= -100
    int i == 0;
    while(i > -100 )
    while(i <= -100 )
    i--
    while(i <= -100 );
 */

public class RevDown {
    public static void main(String[] args) {
        int i = 0;
        while (i >= -100) {
            System.out.print(i + " ");
            i -= 1;
        }
    }
}
