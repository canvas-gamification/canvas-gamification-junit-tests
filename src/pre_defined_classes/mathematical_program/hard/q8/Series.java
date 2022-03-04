package pre_defined_classes.mathematical_program.hard.q8;

/*
A geometric sequence is a sequence of numbers where each term is determined by multiplying the previous term using the general formula:
Nth _term = first_term(r)^(n-1)
where r is a constant and n is an integer representing the nth term in the sequence.
As an example, let's suppose that the first term is 3 and r=2. Then, the second term is calculated with n=2 as follows:
second_term = 3(2)^(2-1) = 3(2) = 6. Similarly, the fourth term is calculated with n=4 as follows: fourth_term = 3(2)^(4-1) = 3(8) = 24.
Following this approach, make a Java program that computes the seventh term in a sequence where r=1/4 and the first_term=1.

Distractors:
int firstTerm = 1.0;
double r = 1/4;
r = n;
int firstTerm = 1/4;
double nthTerm = firstTerm*r^(n - 1);
System.out.println( "The 6th term in the geometric sequence is: " + nthTerm);
double nthTerm=  firstTerm*Math.exp(r, n-1);
double nthTerm=  firstTerm*Math.exp(r, n);
 */
public class Series {
    public static void main(String[] args) {
        int firstTerm = 1;
        double r = 0.25;
        int n = 7;
        double nthTerm = firstTerm * Math.pow(r, n - 1);
        System.out.println("The 7th term in the geometric sequence is: " + nthTerm);
    }

}
