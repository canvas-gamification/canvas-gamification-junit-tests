package arrays.arrays_with_methods.hard.q14;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    static final double a = 2;
    static final double r = 0.5;
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[]{
            new StringLiteral("Enter a value for n: "),
            new NewLine(),
            new StringLiteral("The first "),
            new PlaceHolder(),
            new StringLiteral(" values of the sequence are: "),
            new NewLine(),
            new PlaceHolder()
        };
    }
    public void runMain() {
        GeometricSequence.main(new String[0]);
    }
    static Stream<String> InputProvider(){
        String[] st = new String[25];
        for(int i = 0; i < 25; i ++)
            st[i] = Integer.toString(i + 1);
        return Stream.of(st);
    }
    @ParameterizedTest
    @MethodSource("InputProvider")
    void testWithInputFalse(String n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not display the correct answer";
        String ans = "";
        for(int i = 0; i < Integer.parseInt(n); i ++)
            ans += a * Math.pow(r, i) + " ";
        runWithInput(n, new Clause[]{
                new StringLiteral(n),
                new StringLiteral(ans)});
    }
}
