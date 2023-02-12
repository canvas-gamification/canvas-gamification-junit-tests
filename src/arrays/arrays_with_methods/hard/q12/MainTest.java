package arrays.arrays_with_methods.hard.q12;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class MainTest extends BaseTest {
    // Java

    int[] factorials = {1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 1932053504, 1278945280, 2004310016};

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Enter the size of the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ArrayOfFacts.main(new String[0]);
    }

    @RepeatedTest(15)
    void correctFactorialMethod(RepetitionInfo repetitionInfo) throws Throwable {
        Object[][] arguments = {
                {repetitionInfo.getCurrentRepetition(), int.class}
        };
        MethodTest m = new MethodTest(ArrayOfFacts.class, "factorial", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(factorials[repetitionInfo.getCurrentRepetition() - 1], output, "Your factorial method does not return the correct factorial value.");
    }

    @RepeatedTest(15)
    void correctMainMethodOutput(RepetitionInfo repetitionInfo) throws InvalidClauseException {
        int[] values = new int[repetitionInfo.getCurrentRepetition()];
        System.arraycopy(factorials, 0, values, 0, repetitionInfo.getCurrentRepetition());

        Clause[][] c = new Clause[1][values.length * 2];
        int count = 0;

        for (int x = 0; x < values.length; x++) {
            c[0][count++] = new IntegerLiteral(values[x]);
            c[0][count++] = new NewLine();
        }

        runWithInput(String.valueOf(repetitionInfo.getCurrentRepetition()), c);
    }
}
