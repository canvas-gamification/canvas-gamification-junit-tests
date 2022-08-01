package methods.modular_programs.easy.q2;

import global.BaseTest;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Please enter your favourite integer: "),
                new NewLine(),
                new PlaceHolder(),
                new NewLine(),
                new StringLiteral("Your number multiplied by PI is: "),
                new DoubleLiteral("multipi")
        };
    }

    public void runMain() {
        FavWholeNum.main(new String[0]);
    }

    static Stream<Arguments> isEvenInputProvider() {
        return Stream.of(
                Arguments.of(0, true), Arguments.of(2, true), Arguments.of(-1, false), Arguments.of(1, false),
                Arguments.of(39, false), Arguments.of(105, false), Arguments.of(-768, true)
        );
    }

    static Stream<Arguments> piMultInputProvider() {
        return Stream.of();
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of();
    }

    @ParameterizedTest
    @MethodSource("isEvenInputProvider")
    void correctIsEvenMethod(int input, boolean isEven) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(FavWholeNum.class, "isEven", new Object[]{input},
                int.class);

    }
}
