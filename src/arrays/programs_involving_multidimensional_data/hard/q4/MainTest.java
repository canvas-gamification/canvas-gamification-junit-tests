package arrays.programs_involving_multidimensional_data.hard.q4;

import global.BaseRandomTest;
import global.MethodTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomBoolean;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertTrue;

public class MainTest extends BaseRandomTest {
    // Java

    public static final int n = 3;

    public Clause[] testSentence() {
        Clause[] c = new Clause[n * n + n + 2];
        int t = 0;
        c[t++] = new StringLiteral("The generated board is:");
        c[t++] = new NewLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomBoolean("X", "O", i + " " + j);
            }
            c[t++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        TicTac.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(33),
                Arguments.of(60),
                Arguments.of(50),
                Arguments.of(100)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctGenerateTicTac(int size) throws Throwable {
        Object[][] arguments = {
                {size, int.class}
        };
        MethodTest m = new MethodTest(TicTac.class, "generateTicTac", arguments);
        Object output = m.callMethod();
        char[][] ans = (char[][]) output;
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size; j ++) {
                    arr.add(String.valueOf(ans[i][j]));
            }
        }
        RandomBoolean rand = new RandomBoolean("X", "O");
        assertTrue("Your generateTicTac method does not return a random Tic Tac board correctly.",
                rand.validateRandom(arr));
    }
}
