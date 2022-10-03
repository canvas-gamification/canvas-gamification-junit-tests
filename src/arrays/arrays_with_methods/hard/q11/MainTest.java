package arrays.arrays_with_methods.hard.q11;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
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
                Arguments.of(new String[]{"Hello", "World"}, new char[]{'H', 'W'}),
                Arguments.of(new String[]{"Don't", "Shut", "Down", "On", "me", "Now"}, new char[]{'D', 'S', 'D', 'O', 'm', 'N'}),
                Arguments.of(new String[]{"chairs", "eat", "hair"}, new char[]{'c', 'e', 'h'}),
                Arguments.of(new String[]{"oneWord"}, new char[]{'o'}),
                Arguments.of(new String[]{"nOt", "cAsE", "sEnSitiVe", "Please"}, new char[]{'n', 'c', 's', 'P'}),
                Arguments.of(new String[]{"764", "583", "3"}, new char[]{'7', '5', '3'}),
                Arguments.of(new String[]{"!@", "////%!", "#@#", "&<>/'"}, new char[]{'!', '/', '#', '&'}),
                Arguments.of(new String[]{"+<3u", "m1x", "!t", "U9!"}, new char[]{'+', 'm', '!', 'U'}),
                Arguments.of(new String[]{"a", "s", "i", "n", "g", "l", "e", "l", "e", "t", "t", "e", "r"}, new char[]{'a', 's', 'i', 'n', 'g', 'l', 'e', 'l', 'e', 't', 't', 'e', 'r'})
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("nOt Case sEnSitive PleaSE", new String[]{"n", "C", "s", "P"}),
                Arguments.of("741 518 3", new String[]{"7", "5", "3"}),
                Arguments.of("L3t's m!x 1t 0p!", new String[]{"L", "m", "1", "0"}),
                Arguments.of("!@ ////%! #@# &<>/'", new String[]{"!", "/", "#", "&"}),
                Arguments.of("Run down the rabbit hole, swore i would never go, back to bad habbits I'm thorugh.", new String[]{"R", "d", "t", "r", "h", "s", "i", "w", "n", "g", "b", "t", "b", "h", "I", "t"})
        );
    }

    @ParameterizedTest
    @MethodSource("charFinderInputProvider")
    void correctCharFinderMethod(String[] words, char[] expected) throws Throwable {
        Object ouput = MethodUtil.invokeIfMethodExists(ArrayofLetters.class, "charFinder", new Object[]{words}, String[].class);
        CustomAssertions._assertArrayEquals(expected, ouput, "Your charFinder method does not return the char array with the correct characters.");
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
