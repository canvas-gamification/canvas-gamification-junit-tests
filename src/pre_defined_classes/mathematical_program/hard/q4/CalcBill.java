package pre_defined_classes.mathematical_program.hard.q4;

/*
Make a Java program that determines the cost of some take-out sushi, given that you tip at 15% and want to round your
answer to the next whole dollar because you don't usually carry coins with you.
 */
public class CalcBill {
    public static void main(String[] args) {
        double total = 23.75;
        double withTips = total * 0.85;
        double payment = Math.ceil(withTips);
        System.out.println("With tips, the amount you need to pay is: " + payment);
    }
}
