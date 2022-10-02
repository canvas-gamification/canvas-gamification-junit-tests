package arrays.arrays_with_methods.hard.q10;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3 9";
        return new Clause[]{
                new StringLiteral("Enter two integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){
        ArrayofDigits.main(new String[0]);
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(
                Arguments.of("5 2", 5, 2),
                Arguments.of("999999 100", 999999, 100),
                Arguments.of("-82 3", -82, 3),
                Arguments.of("7 0", 7, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(String in, int a, int b) throws InvalidClauseException {
        Clause[][] c = new Clause[1][b*2];
        int count = 0;
        for(int x = 0; x < b; x ++){
            c[0][count++] = new IntegerLiteral(a);
            c[0][count++] = new NewLine();
        }

        runWithInput(in, c);
    }
}
