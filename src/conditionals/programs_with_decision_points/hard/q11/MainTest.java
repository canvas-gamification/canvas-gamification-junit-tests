package conditionals.programs_with_decision_points.hard.q11;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class MainTest extends BaseTest {
    // Java

    private static final int currentDay = 27;
    private static final int currentMonth = 9;
    private static final int diff = 45;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "12 11";
        return new Clause[]{
                new StringLiteral("Enter your birth day: "),
                new NewLine(),
                new StringLiteral("Enter your birth month as a number: "),
                new NewLine(),
                new PlaceHolder()
        };

    }

    public void runMain() {
        Discount.main(new String[0]);
    }

    public static boolean calcAns(int birthDay, int birthMonth) {
        int monthDiff = currentMonth - birthMonth;
        int dayDiff = currentDay - birthDay;
        if (Math.abs(monthDiff * 30 + dayDiff) <= diff)
            return true;
        else
            return false;
    }

    static int[][] qualifieds = new int[diff * 2 + 1][2];
    static int[][] unqualifieds = new int[360 - diff * 2 - 1][2];

    static Stream<int[]> InputProviderQualified() {
        int t = 0;
        for (int i = 1; i <= 12; i++) {
            if (calcAns(1, i))
                qualifieds[t++] = new int[]{1, i};
            if (calcAns(30, 12))
                qualifieds[t++] = new int[]{30, i};
        }
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j <= 12; j++) {
                if (calcAns(i, j) && !calcAns(i - 1, j))
                    qualifieds[t++] = new int[]{i, j};
                if (calcAns(i, j) && !calcAns(i + 1, j))
                    qualifieds[t++] = new int[]{i, j};
            }
        }
        int[][] ans = new int[t][2];
        for (int i = 0; i < t; i++)
            ans[i] = qualifieds[i];
        return Stream.of(ans);
    }

    @ParameterizedTest
    @MethodSource("InputProviderQualified")
    void testWithInputQualified(int[] in) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not display the correct answer";
        runWithInput(in[0] + " " + in[1], new Clause[]{
                new StringLiteral("You qualify for a 10% discount!")});
    }

    static Stream<int[]> InputProviderUnqualified() {
        int t = 0;
        for (int i = 1; i <= 12; i++) {
            if (!calcAns(1, i))
                unqualifieds[t++] = new int[]{1, i};
            if (!calcAns(30, 12))
                unqualifieds[t++] = new int[]{30, i};
        }
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j <= 12; j++) {
                if (!calcAns(i, j) && calcAns(i - 1, j))
                    unqualifieds[t++] = new int[]{i, j};
                if (!calcAns(i, j) && calcAns(i + 1, j))
                    unqualifieds[t++] = new int[]{i, j};
            }
        }
        int[][] ans = new int[t][2];
        for (int i = 0; i < t; i++)
            ans[i] = qualifieds[i];
        return Stream.of(ans);
    }

    @ParameterizedTest
    @MethodSource("InputProviderUnqualified")
    void testWithInputUnqualified(int[] in) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not display the correct answer";
        runWithInput(in[0] + " " + in[1], new Clause[]{
                new StringLiteral("You do not qualify for any discounts.")});
    }

}
