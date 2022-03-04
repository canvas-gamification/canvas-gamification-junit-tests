package pre_defined_classes.mathematical_program.hard.q4;

/*
Make a Java program that determines the cost of some take-out sushi, given that you tip at 15% and want to round your
answer to the next whole dollar because you don't usually carry coins with you.

Distractors:
int total = 23.75;
double withTips = total * 0.15;
double withTips = total * 0.85;
double total, withTips;
int payment = Math.floor( withTips );
int payment = Math.round( withTips );
System.out.print( "With tips, the amount you need to pay is: + payment" );
 */
public class CalcBill {
    public static void main(String[] args) {
        double total = 23.75;
        double withTips = total * 1.15;
        double payment = Math.ceil(withTips);
        System.out.println("With tips, the amount you need to pay is: " + payment);
    }
}
