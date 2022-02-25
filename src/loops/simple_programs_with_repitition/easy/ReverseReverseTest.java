package loops.simple_programs_with_repitition.easy;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class ReverseReverseTest extends BaseTest {

    int input = 9268236;

    public Clause[] testSentence() {
        
        Clause[] output = new Clause[4];
        
        output[0] = new StringLiteral("Enter a number : ");
        output[1] = new NewLine();

        output[2] = new StringLiteral("Reversed Number: ");
        output[3] = new IntegerLiteral(reverse(input));

        return output;

    }

    public void runMain() {
        provideInput("" + input);
        ReverseReverse.main(new String[0]);
    }
    
    public static int reverse(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = (reverse * 10) + (n % 10);
            n = n / 10;
        }
        return reverse;
    }

}
