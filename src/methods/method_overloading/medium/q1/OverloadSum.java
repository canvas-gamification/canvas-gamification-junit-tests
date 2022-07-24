package methods.method_overloading.medium.q1;

/*
Write a Java Program that takes three declared and initialized integer variables a, b, and c and calculates the sum of a and b,
and the sum of a, b, and c. Write two methods called sum to complete this, with one accepting two integers and the other
accepting three integers. The program should output the returned sum form both methods.
Sample Output:
    The output of both sum methods is: 50 and 66
 */
public class OverloadSum {
    public static void main(String[] args) {
        int a = 5;
        int b = 45;
        int c = 16;
        System.out.println("The output of both sum methods is: " + sum(a, b) + " and " + sum(a, b, c));
    }

    public static int sum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static int sum(int a, int b, int c) {
        int sum = a + b + c;
        return sum;
    }
}
