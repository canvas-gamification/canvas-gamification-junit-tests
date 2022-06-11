package loops.nested_loops.hard.q2;
/*
Print the following pattern for n = 4, where n is the number of lines and the numbers per line, using nested loops.
Sample Output:
    1 2 3 4
    1 2 3 4
    1 2 3 4
    1 2 3 4
 */

public class RepeatTheRepeat {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 4; j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
