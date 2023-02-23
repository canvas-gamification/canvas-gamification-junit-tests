package arrays.arrays_with_methods.hard.q11;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Hello my old heart";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ArrayofLetters.main(new String[0]);
    }

    static Stream<Arguments> charFinderInputProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"Hello", "World"}),
                Arguments.of((Object) new String[]{"Don't", "Shut", "Down", "On", "me", "Now"}),
                Arguments.of((Object) new String[]{"chairs", "eat", "hair"}),
                Arguments.of((Object) new String[]{"oneWord"}),
                Arguments.of((Object) new String[]{"nOt", "cAsE", "sEnSitiVe", "Please"}),
                Arguments.of((Object) new String[]{"764", "583", "3"}),
                Arguments.of((Object) new String[]{"!@", "////%!", "#@#", "&<>/'"}),
                Arguments.of((Object) new String[]{"+<3u", "m1x", "!t", "U9!"}),
                Arguments.of((Object) new String[]{"a", "s", "i", "n", "g", "l", "e", "l", "e", "t", "t", "e", "r"}),
                Arguments.of((Object) ArrayUtil.generateRandomWordArray(150)),
                Arguments.of((Object) ArrayUtil.generateRandomWordArray(300)),
                Arguments.of((Object) ArrayUtil.generateRandomWordArray(500))
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("nOt Case sEnSitive PleaSE", new String[]{"n", "C", "s", "P"}),
                Arguments.of("741 518 3", new String[]{"7", "5", "3"}),
                Arguments.of("L3t's m!x 1t 0p!", new String[]{"L", "m", "1", "0"}),
                Arguments.of("!@ ////%! #@# &<>/'", new String[]{"!", "/", "#", "&"}),
                Arguments.of("Run down the rabbit hole, swore i would never go, back to bad habits I'm through.", new String[]{"R", "d", "t", "r", "h", "s", "i", "w", "n", "g", "b", "t", "b", "h", "I", "t"})
        );
    }

    public static char[] ans(String[] input) {
        char[] arr = new char[input.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = input[i].charAt(0);
        return arr;
    }

    @ParameterizedTest
    @MethodSource("charFinderInputProvider")
    void correctCharFinderMethod(String[] words) throws Throwable {
        Object[][] arguments = {
                {words, String[].class}
        };
        MethodTest m = new MethodTest(ArrayofLetters.class, "charFinder", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(ans(words), output, "Your charFinder method does not return the char array with the correct characters.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(String in, String[] out) throws InvalidClauseException {
        Clause[][] c = new Clause[1][out.length * 2];
        int count = 0;

        for (int x = 0; x < out.length; x++) {
            c[0][count++] = new StringLiteral(out[x]);
            c[0][count++] = new NewLine();
        }

        runWithInput(in, c);
    }
}
