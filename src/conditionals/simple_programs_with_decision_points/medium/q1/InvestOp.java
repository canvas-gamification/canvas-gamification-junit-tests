package conditionals.simple_programs_with_decision_points.medium.q1;

import java.util.Scanner;

/*
Write a program that will ask the user for their investment and double it if it is above $5000
Sample Output:
	What is your investment in $ (rounded to the nearest dollar)?
	6000
	Investment : $12000
 */

public class InvestOp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your investment in $ (rounded to the nearest dollar)? ");
        int invest = input.nextInt();
        if (invest > 5000)
            invest = invest * 2;
        System.out.println("Investment : $" + invest);
    }
}