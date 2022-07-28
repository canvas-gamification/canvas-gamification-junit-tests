package loops.for_loops.hard.q1;

/*
Write a program using a for loop that will print the numbers from 0 to -100 (inclusive).

Distractors:
    for(int i = 0 ; i > -100; i--);
    for int i = 0 ; i >= -100; i--
    for(int i = 0 , i >= -100 , i-)
    for(int i = 0 ; i > -100; i--)
    for(int i = 0 ; i <= -100; i--)
    for(int i = 0 ; i <= -100; i--);
    for(int i = 0 ; i >= -100; i--):
 */

public class RevDown {
    public static void main(String[] args) {
        for (int i = 0; i >= -100; i--)
            System.out.print(i + " ");
    }
}
