package loops.for_loops.hard.q5;
/*
Write a program that will print the first 10 numbers in the fibonacci sequence. The nth term in the fibonacci
series is obtained by adding the previous two terms together. Assume the sequence starts with 0 and 1, so the next term
would be 1, the term after that would be 2, then 3, then 5, and so on.

Sample output: Fibonacci Sequence: 0, 1, 1, 3, 6, 12, 24, 48, 96, 192,

 */
public class FiboWhat {
    public static void main(String[] args) {
        int n1 = 0, n2 = 1;
        System.out.print("Fibonacci Sequence: 0, 1, ");
        for (int i = 0; i < 8; i++) {
            System.out.print((n1 + n2) + ", ");
            n1 = n2;
            n2 = n1 + n2;
        }
    }
}
