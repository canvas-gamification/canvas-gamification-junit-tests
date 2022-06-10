package loops.programs_with_repetition.medium.q2;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.PlaceHolder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MainTest extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2";
        return new Clause[]{
                new PlaceHolder()
        };
    }

    public void runMain() {
        VerifiedComposite.main(new String[0]);
    }

    static Stream<Integer> validInputProvider() {
        return Stream.of(267, 2, 3, 10589);
    }

    static Stream<Arguments> invalidInputProvider() {
        return Stream.of();
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void worksWithValidInputs(int input) {
        TestOption.incorrectStructureErrorMessage = "Your program does not print all the composite numbers between 2 and the input n.";
        ArrayList<Integer> compositeNumbers = compositeNumberList(input);
    }

    private static ArrayList<Integer> compositeNumberList(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            int c = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    c++;
                if (c > 2) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}
