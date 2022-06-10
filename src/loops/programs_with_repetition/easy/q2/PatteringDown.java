package loops.programs_with_repetition.easy.q2;
/*

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

