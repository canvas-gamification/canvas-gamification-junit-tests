package pre_defined_classes.simple_programs_taking_user_input.hard.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("How many hours have you worked\\Q?\\E"),
                new NewLine(),
                new StringLiteral("What is your hourly wage\\Q?\\E"),
                new NewLine(),
                new StringLiteral("What is the tax rate\\Q?\\E \\Q(\\EEnter 0\\Q.\\E12 for 12\\Q%\\E\\Q)\\E"),
                new NewLine(),
                new StringLiteral("Pay Amount: "),
                new DoubleLiteral("pay"),
                new NewLine(),
                new StringLiteral("Tax Amount: "),
                new DoubleLiteral("tax"),
                new NewLine(),
                new StringLiteral("Net Earnings: "),
                new DoubleLiteral("net")
        };
    }

    public void runMain() {
        provideInput("48.75 59.86 0.16 ");
        PayrollTax.main(new String[0]);
    }

    @Test
    public void outputTest(){
        assertEquals(Double.parseDouble(getItemByName("pay")), 2918.0, 0.5, "Calculated pay value is incorrect");
        assertEquals(Double.parseDouble(getItemByName("tax")), 466.9, 0.5, "Calculated tax value is incorrect");
        assertEquals(Double.parseDouble(getItemByName("net")), 2451.0, 0.5, "Calculated net earnings is wrong");
    }
}
