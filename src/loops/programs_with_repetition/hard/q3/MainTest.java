package loops.programs_with_repetition.hard.q3;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseTest {
    public Clause[] testSentence() {
        // Java
        TestOption.isInputTest = true;
        TestOption.defaultInput = "369";
        return new Clause[]{
                new StringLiteral("Enter a 3-digit number:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new IntegerLiteral("permutation1"),
                new NewLine(),
                new IntegerLiteral("permutation2"),
                new NewLine(),
                new IntegerLiteral("permutation3"),
                new NewLine(),
                new IntegerLiteral("permutation4"),
                new NewLine(),
                new IntegerLiteral("permutation5"),
                new NewLine(),
                new IntegerLiteral("permutation6")
        };
    }

    public void runMain() {
        PermutateThis.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(369, new ArrayList<>(Arrays.asList(369, 396, 639, 693, 936, 963))),
                Arguments.of(724, new ArrayList<>(Arrays.asList(724, 742, 472, 427, 247, 274))),
                Arguments.of(472, new ArrayList<>(Arrays.asList(724, 742, 472, 427, 247, 274))),
                Arguments.of(581, new ArrayList<>(Arrays.asList(581, 518, 851, 815, 158, 185)))
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPermutationsCorrectly(int input, ArrayList<Integer> permutationList) {
        runWithInput(String.valueOf(input));
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 1; i <= 6; i++)
            output.add(Integer.parseInt(getItemByName("permutation" + i)));
        Collections.sort(output);
        Collections.sort(permutationList);
        assertEquals(output, permutationList, "Your program does not print out all the unique permutations of the input 3 digit number.");
    }
}
