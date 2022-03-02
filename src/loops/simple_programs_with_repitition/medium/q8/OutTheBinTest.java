package loops.simple_programs_with_repitition.medium.q8;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class OutTheBinTest extends BaseTest {

    int input1 = 1001101001;

    public Clause[] testSentence() {
        return new Clause[] {
                new StringLiteral("Enter a binary number : "),
                new NewLine(),
                new StringLiteral("Decimal Number: "),
                new IntegerLiteral(convertBinaryToDecimal(input1)),
        };
    }

    public void runMain() {
        provideInput("" + input1);
        OutTheBin.main(new String[0]);
    }

    public int convertBinaryToDecimal(int n) {
        int i = 0;
        int d;
        int result = 0;
        while (n > 0) {
            d = n % 10;
            result += d * Math.pow(2, i);
            i++;
            n = n / 10;
        }
        return(result);
    }
}