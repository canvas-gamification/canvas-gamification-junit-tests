package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q6;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //Parson's Problems with Distractors
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5 16 0.12";
        return new Clause[]{
                new StringLiteral("How many hours have you worked?"),
                new NewLine(),
                new StringLiteral("What is your hourly wage?"),
                new NewLine(),
                new StringLiteral("What is the tax rate? (Enter 0.12 for 12%)"),
                new NewLine(),
                new StringLiteral("Pay Amount: "),
                new DoubleLiteral("pay"),
                new StringLiteral("Tax Amount: "),
                new DoubleLiteral("tax"),
                new StringLiteral("Net Earnings: "),
                new DoubleLiteral("net")
        };
    }

    public void runMain() {PayrollTax.main(new String[0]);}

    @Test
    void calculateIncomeWithTaxCorrectly(){
        runWithInput("5 16 0.12");
        assertEquals(Double.parseDouble(getItemByName("pay")), 80.0);
        assertEquals(Double.parseDouble(getItemByName("tax")), 9.6);
        assertEquals(Double.parseDouble(getItemByName("net")), 70.4);
    }
}
