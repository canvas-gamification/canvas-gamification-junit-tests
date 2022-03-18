package pre_defined_classes.mathematical_program.hard.q4;

/*
Make a Java program that determines the total cost of some take-out sushi priced at $23.75, given that you tip at 15% and want to round
your answer to the next whole dollar because you don't usually carry coins with you.

Distractors:
int price = 23.75;
double withTips = price * 0.15;
double withTips = price * 0.85;
double price, withTips;
int total = Math.floor( withTips );
int total = Math.round( withTips );
System.out.print( "With tips, the amount you need to pay is: + total" );
 */
public class CalcBill {
    public static void main(String[] args) {
        double price = 23.75;
        double withTips = price * 1.15;
        double total = Math.ceil(withTips);
        System.out.println("With tips, the amount you need to pay is: " + total);
    }
}
