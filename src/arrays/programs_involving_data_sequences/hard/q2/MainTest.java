package arrays.programs_involving_data_sequences.hard.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.utils.ArrayUtil;
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
    // Java
    /**
     * Length of the input which is varied by the website
     */
    private static final int tileLength = 10;
    /**
     * Length of the meld, which is varied by the website from 3 to 5
     */
    private static final int meldLength = 3;
    /**
     * The number of inputs minus the length of the meld
     */
    public static final int remainingLength = tileLength - meldLength;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray(0, 10, tileLength));
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

    static Stream<Arguments> validMeldInputProvider() {
        return Stream.of(
                Arguments.of(
                        ArrayUtil.merge(ArrayUtil.generateAscendingArray(4, meldLength),
                        ArrayUtil.generateAscendingArray(6, tileLength - meldLength, 3)), true),
                Arguments.of(ArrayUtil.generateAscendingArray(1, tileLength, 2), false),
                Arguments.of(
                        ArrayUtil.merge(ArrayUtil.merge(ArrayUtil.generateAscendingArray(5, 3, 4),
                        ArrayUtil.replicateArray(13, meldLength)),
                        ArrayUtil.generateAscendingArray(15, tileLength - meldLength - 3, 4)), true),
                Arguments.of(ArrayUtil.replicateArray(5, meldLength), true),
                Arguments.of(ArrayUtil.merge(ArrayUtil.replicateArray(4, meldLength - 1), new int[]{5}), false),
                Arguments.of(ArrayUtil.merge(new int[]{3}, ArrayUtil.generateAscendingArray(5, meldLength - 1)), false),
                Arguments.of(ArrayUtil.generateAscendingArray(39, meldLength), true)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray(1, meldLength)) +
                        ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray(meldLength + 2, remainingLength, 3)),
                        "Valid"),
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray(0, remainingLength, 4)) +
                        ArrayUtil.arrayToInput(ArrayUtil.replicateArray(50, meldLength)), "Valid"),
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray(1, tileLength, 2)), "Not Valid"),
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray(5, 4, 2)) +
                        ArrayUtil.arrayToInput(ArrayUtil.replicateArray(50, meldLength - 1)) +
                        ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray(51, remainingLength - 3, 2)),
                        "Not Valid")
        );
    }

    @ParameterizedTest
    @MethodSource("validMeldInputProvider")
    void correctValidMeldMethod(int[] input, boolean isMeld) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(MyJong.class, "validMeld",
                new Object[]{input}, int[].class);
        assertEquals(isMeld, output, "Your method does not identify valid melds.");
        String consoleOutput = MethodUtil.getMethodOutput();
        assertEquals("", consoleOutput, "Your method should not have printed output.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsCorrectOutput(String input, String message) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message based on if the array contains a valid meld.";
        runWithInput(input, new Clause[]{
                new StringLiteral(message)
        });
    }

}
