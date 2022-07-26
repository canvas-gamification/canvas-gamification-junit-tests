package loops.simple_programs_with_repetition.hard.q3;
/*
* This question should vary the n
Write a program that will calculate an approximation of 𝜋 (pi) from n = 0 until n = 10000, using the following series:
4 *  ( (1/1) - (1 / 3) + (1/ 5) - (1 / 7) + …. + ( -1 )n / ( 2n + 1 ) ).
Sample Output:
	Approximation of pi using n = 10000 is 3.14…
 */
public class SliceOfPi {
    public static void main(String[] args) {
        double sum = 0;
        for (int n = 0; n <= 10000; n++) {
            sum += Math.pow(-1, n) * (1 / ((2.0 * n) + 1));
        }
        sum *= 4;
        System.out.println("Approximation of pi using n = 10000 is " + sum);
    }
}
