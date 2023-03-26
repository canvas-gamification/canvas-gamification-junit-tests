package test.random.general_random_testing;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomWithInputCodeTest extends BaseRandomTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "something" + System.lineSeparator() + "1";

        return new Clause[]{
                new StringLiteral("This is a test with retrieval."),
                new NewLine(),
                new PlaceHolder(),
                new NewLine(),
                new PlaceHolder(),
                new NewLine(),
                new RandomInteger(0, 10),
        };
    }

    public void runMain() {
        RandomWithInputCode.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("apple", 1),
                Arguments.of("banana", 6),
                Arguments.of("banana", -2)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input, int addedInput) throws InvalidClauseException {
        runWithInput(String.join(System.lineSeparator(), input, addedInput + ""), new Clause[]{
                new StringLiteral(input, "injected"),
                new RandomInteger(addedInput, 10 + addedInput)
        });
        assertEquals(getItemByName("injected"), input);
    }
}
