package pre_defined_classes.mathematical_program.medium.q10;
/*
Many of us borrow money from the bank and want to find out how much we owe at a later time. Make a Java program that
calculates the amount of a compounded interest loan using the formula: A = P(1+r/n)^(nt) where r is the interest rate,
n is the number of times the interest is applied, t is the time period of the loan, P is the principal amount borrowed,
and A is the amount owing. For this program, let's say that the interest is compounded bi-yearly (twice per year), and
the time period is 5 years, and the initial loan amount is 5000 dollars at an interest rate of 9%.
 */

public class Compounding {
    public static void main(String[] args) {
        int initialBorrowed = 5000;
        double interestRate = 0.09;
        int n = 2;
        int timePeriod = 5;
        double quantity = 1 + (interestRate / n);
        double raisedExponent = n * timePeriod;
        double amount = initialBorrowed * Math.pow(quantity, raisedExponent);
        System.out.println("The amount owing is " + amount + " dollars.");
    }
}
