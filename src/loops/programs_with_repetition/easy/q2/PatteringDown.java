package loops.programs_with_repetition.easy.q2;
/*
Write a program to print the following pattern using nested loops for n = 5, where n is the number of lines:
1
23
456
78910
1112131415
 */
public class PatteringDown {
    public static void main(String[] args) {
        int x = 1;
        for (int i = 1; i <= 5; i++) {
            for (int k = 1; k <= i; k++)
                System.out.print(x++);
            System.out.println();
        }
    }
}

