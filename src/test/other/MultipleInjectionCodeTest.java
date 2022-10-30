package test.other;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import test.other.MultipleInjectionCode;

import java.util.stream.Stream;

public class MultipleInjectionCodeTest extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "something" + System.lineSeparator() + "1";

        return new Clause[]{
                new StringLiteral("Enter a sentence: "),
                new StringLiteral("Enter a number: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        MultipleInjectionCode.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("apple", 1),
                Arguments.of("banana", 3),
                Arguments.of("strobbery", 9)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String sentence, int numRepeats) throws InvalidClauseException {
        Clause[] injected = new Clause[numRepeats*2];
        for (int i = 0; i < numRepeats*2; i+=2) {
            injected[i] = new StringLiteral(sentence);
            injected[i+1] = new NewLine();
        }

        runWithInput(sentence + System.lineSeparator() + numRepeats + System.lineSeparator(), new Clause[][]{
                injected
        });
    }
}
