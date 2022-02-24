package pre_defined_classes.simple_programs_taking_user_input.hard.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.RepeatedTest;

import java.nio.channels.NonWritableChannelException;

public class PayrollTaxTest extends BaseTest {

    public Clause[] testSentence() {
        provideInput("48.75 59.86 0.16 ");
        return new Clause[]{
                new StringLiteral("How many hours have you worked?"),
                new NewLine(),
                new StringLiteral("What is your hourly wage?"),
                new NewLine(),
                new StringLiteral("What is the tax rate? (Enter 0.12 for 12%)"),
                new NewLine(),
                new StringLiteral("Pay Amount: 2918.175"),
                new NewLine(),
                new StringLiteral("Tax Amount: 466.908"),
                new NewLine(),
                new StringLiteral("Net Earnings: 2451.2670000000003"),
                new NewLine()
        };
    }

    public void runMain() {
        PayrollTax.main(new String[0]);
    }
}
