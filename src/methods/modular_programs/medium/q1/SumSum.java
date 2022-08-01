package methods.modular_programs.medium.q1;
/*
Write a Java Program that takes five initialized and declared integer variables, and using a method called sumAbsolute,
takes all five variables and returns the sum of the absolute value of all the variables.

Sample Output:
    The sum of the absolute value of the variables is x

Distractors:
    return a+b+c+d+e;
    public int sumAbsolute(int a, int b, int c, int e, int d)

 */
public class SumSum {
    public static void main(String[] args) {
        int a = 5;
        int b = -24;
        int c = 78;
        int d = 5;
        int e = -6;
        System.out.println("The sum of the absolute value of the variables is " + sumAbsolute(a, b, c, d, e));
    }

    public static int sumAbsolute(int a, int b, int c, int e, int d) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        int z = Math.abs(c);
        int w = Math.abs(d);
        int v = Math.abs(e);
        return x + y + z + w + v;
    }

}
