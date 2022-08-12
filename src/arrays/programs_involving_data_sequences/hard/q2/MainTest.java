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

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    private static final int tileLength = 10;
    private static final int meldLength = 3;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.intArrayToInput(ArrayUtil.generateRandomIntArray(0, 10, tileLength));
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

    static Stream<Arguments> meld3MethodInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 4, 6, 6, 7, 7, 8, 8, 9}, true),
                Arguments.of(new int[]{1, 3, 4, 4, 5, 5, 6, 8, 8, 9}, false),
                Arguments.of(new int[]{7, 7, 7}, true),
                Arguments.of(new int[]{6, 6, 8}, false),
                Arguments.of(new int[]{3, 5, 6}, false)
        );
    }

    static Stream<Arguments> meld4MethodInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, true),
                Arguments.of(new int[]{8, 8, 8, 8}, true),
                Arguments.of(new int[]{4, 5, 5, 7}, false),
                Arguments.of(new int[]{7, 7, 7, 8}, false),
                Arguments.of(new int[]{1, 3, 4, 6, 6, 7, 8, 9, 9, 9, 9}, true),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 7, 7, 8, 8, 8}, false)
        );
    }

    static Stream<Arguments> meld5MethodInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 6, 7, 8, 9}, true),
                Arguments.of(new int[]{1, 2, 3, 4, 6}, false),
                Arguments.of(new int[]{4, 4, 4, 4, 4}, true),
                Arguments.of(new int[]{1, 2, 3, 6, 7}, false),
                Arguments.of(new int[]{1, 4, 7, 9, 9}, false),
                Arguments.of(new int[]{2, 5, 7, 8, 9}, false),
                Arguments.of(new int[]{3, 3, 3, 4, 4}, false),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 8, 9, 9}, true),
                Arguments.of(new int[]{1, 2, 3, 4, 6, 6, 6, 7, 8, 8, 8, 8, 9, 9, 9, 9}, false)
        );
    }

    static Stream<Arguments> meld3MainMethodInputProvider() {
        return Stream.of(
                Arguments.of("1 2 3 " + ArrayUtil.intArrayToInput(Arrays.stream(ArrayUtil.generateRandomIntArray(4, 20, tileLength - 3)).sorted().toArray()), "Valid"),
                Arguments.of(ArrayUtil.intArrayToInput(Arrays.stream(ArrayUtil.generateRandomIntArray(0, 14, tileLength - 3)).sorted().toArray()) + "15 15 15 ", "Valid"),
                Arguments.of(ArrayUtil.intArrayToInput(generateArrayWithNoMeld()), "Not Valid")
        );
    }

    static Stream<Arguments> meld4MainMethodInputProvider() {
        return Stream.of(
                Arguments.of("1 2 3 4 " + ArrayUtil.intArrayToInput(Arrays.stream(ArrayUtil.generateRandomIntArray(4, 20, tileLength - 4)).sorted().toArray()), "Valid"),
                Arguments.of(ArrayUtil.intArrayToInput(Arrays.stream(ArrayUtil.generateRandomIntArray(0, 14, tileLength - 4)).sorted().toArray()) + "15 15 15 15 ", "Valid"),
                Arguments.of(ArrayUtil.intArrayToInput(generateArrayWithNoMeld()), "Not Valid")
        );
    }

    static Stream<Arguments> meld5MainMethodInputProvider() {
        return Stream.of(
                Arguments.of("1 2 3 4 5 " + ArrayUtil.intArrayToInput(Arrays.stream(ArrayUtil.generateRandomIntArray(4, 20, tileLength - 5)).sorted().toArray()), "Valid"),
                Arguments.of(ArrayUtil.intArrayToInput(Arrays.stream(ArrayUtil.generateRandomIntArray(0, 20, tileLength - 5)).sorted().toArray()) + "21 21 21 21 21 ", "Valid"),
                Arguments.of(ArrayUtil.intArrayToInput(generateArrayWithNoMeld()), "Not Valid")
        );
    }

    @ParameterizedTest
    @MethodSource("meld3MethodInputProvider")
    void correctValidMeldMethod(int[] input, boolean isMeld) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(MyJong.class, "containsValidMeld",
                new Object[]{input}, int[].class);
        assertEquals(isMeld, output, "Your method does not identify valid melds.");
        String consoleOutput = MethodUtil.getMethodOutput();
        assertEquals("", consoleOutput, "Your method should not have printed output.");
    }

    @ParameterizedTest
    @MethodSource("meld3MainMethodInputProvider")
    void printsCorrectOutput(String input, String message) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message based on if the array contains a valid meld.";
        runWithInput(input, new Clause[]{
                new StringLiteral(message)
        });
    }

    private static int[] generateArrayWithNoMeld() {
        int[] arr;
        boolean containsRun = false;
        boolean containsConsecutive = false;
        do {
            arr = ArrayUtil.generateRandomIntArray(0, 20, tileLength);
            Arrays.sort(arr);
            switch (meldLength) {
                case 3:
                    for (int i = 0; i < arr.length - 2; i++) {
                        if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2])
                            containsConsecutive = true;
                        if (Math.abs(arr[i] - arr[i + 1]) == 1 && Math.abs(arr[i + 1] - arr[i + 2]) == 1)
                            containsRun = true;
                    }
                    break;
                case 4:
                    for (int i = 0; i < arr.length - 3; i++) {
                        if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2] && arr[i + 2] == arr[i + 3])
                            containsConsecutive = true;
                        if (Math.abs(arr[i] - arr[i + 1]) == 1 && Math.abs(arr[i + 1] - arr[i + 2]) == 1 && Math.abs(arr[i + 2] - arr[i + 3]) == 1)
                            containsRun = true;
                    }
                    break;
                case 5:
                    for (int i = 0; i < arr.length - 4; i++) {
                        if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2] && arr[i + 2] == arr[i + 3] && arr[i + 3] == arr[i + 4])
                            containsConsecutive = true;
                        if (Math.abs(arr[i] - arr[i + 1]) == 1 && Math.abs(arr[i + 1] - arr[i + 2]) == 1 && Math.abs(arr[i + 2] - arr[i + 3]) == 1 && Math.abs(arr[i + 3] - arr[i + 4]) == 1)
                            containsRun = true;
                    }
                    break;
            }
        } while (containsRun || containsConsecutive);
        return arr;
    }

}
