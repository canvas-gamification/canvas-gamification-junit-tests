package arrays.programs_involving_data_sequences.hard.q10;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    //Java
    @Override
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The middle letters of the array are\\: "),
                new NewLine(),
                new StringLiteral("delilah"),
                new NewLine()
        };
    }

    @Override
    public void runMain() {
        ArrayThereDelilah.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new String[]{"add", "here", "lilly", "president", "jelly", "advance", "archers"}, "delilah".toCharArray()),
                Arguments.of(new String[]{"archers", "get", "hello", "island", "cloud"}, "hello".toCharArray()),
                Arguments.of(new String[]{"fireworks", "acorn", "array", "pilot", "hedge"}, "world".toCharArray()),
                Arguments.of(new String[]{"funky", "opera", "flowers"}, "new".toCharArray()),
                Arguments.of(new String[]{"rhyme", "yolk", "corks", "bookcase"}, "york".toCharArray()),
                Arguments.of(new String[]{"lucid", "doing", "retry", "thyme"}, "city".toCharArray()),
                Arguments.of(new String[]{"lemon", "faith", "pylon", "field", "backslash"}, "miles".toCharArray())
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctMiddleMethod(String[] input, char[] word) throws Throwable {
        Object[][] arguments = {
                {input, String[].class},
        };
        MethodTest m = new MethodTest(ArrayThereDelilah.class, "middle", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(word, output, "Your middle method does not return the correct array of middle characters.");
    }
}
