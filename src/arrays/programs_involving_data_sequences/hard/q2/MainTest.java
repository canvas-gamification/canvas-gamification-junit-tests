package arrays.programs_involving_data_sequences.hard.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 2 3 2 2 4 1 8 9 3 ";
        return new Clause[]{
                new StringLiteral("Please enter the 10 tile set:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        MyJong.main(new String[0]);
    }

    static Stream<Arguments> validMeldInputProvider(){
        return Stream.of(Arguments.of(new int[]{2, 3, 4, 7, 1, 3, 9, 5, 3, 9}, true),
                Arguments.of(new int[]{1, 3, 4, 2, 9, 4, 8, 5, 6, 8}, false),
                Arguments.of(new int[]{7, 7, 7}, true),
                Arguments.of(new int[]{6, 6, 8}, false),
                Arguments.of(new int[]{3, 5, 6}, false),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{8, 8, 8, 8}, false),
                Arguments.of(new int[]{4, 5, 5, 7}, false),
                Arguments.of(new int[]{7, 7, 7, 3}, false),
                Arguments.of(new int[]{5, 6, 7, 8, 9}, false),
                Arguments.of(new int[]{1, 2, 3, 4, 6}, false),
                Arguments.of(new int[]{4, 4, 4, 4, 4}, false),
                Arguments.of(new int[]{1, 2, 3, 6, 7}, false),
                Arguments.of(new int[]{1, 4, 7, 2 ,9 }, false),
                Arguments.of(new int[]{2, 5, 7, 8, 9}, false),
                Arguments.of(new int[]{3, 3, 3, 4, 4}, false));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(
                Arguments.of("10 2 3 4 6 1 2 4 9 6", "Valid")
        );
    }

    @ParameterizedTest
    @MethodSource("validMeldInputProvider")
    void correctValidMeldMethod(int[] input, boolean isMeld) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(MyJong.class, "containsValidMeld",
                new Object[]{input}, int[].class);
        assertEquals(isMeld, output, "Your method does not identify valid melds.");
        String consoleOutput = MethodUtil.getMethodOutput();
        assertEquals("", consoleOutput, "Your method should not have printed output.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsCorrectOutput(String input, String message) throws InvalidClauseException {
        runWithInput(input, new Clause[]{
                new StringLiteral(message)
        });
    }
}
