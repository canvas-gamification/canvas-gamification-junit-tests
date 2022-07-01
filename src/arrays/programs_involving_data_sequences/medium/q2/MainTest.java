package arrays.programs_involving_data_sequences.medium.q2;

import global.BaseTest;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
            new StringLiteral("Stringbuild")
        };
    }

    public void runMain() {
        WordleBuilder.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider(){
        return Stream.of(Arguments.of("storm", new char[]{'e', 'a', 'r', 'l', 's'}, "stormearls"),
                Arguments.of("", new char[]{}, ""),
                Arguments.of("Hello", new char[]{'t', 'h', 'e', 'r', 'e'}, "Hellothere"),
                Arguments.of("", new char[]{'e', 'l', 'y', 'z', 'q', '?'}, "elyzq?"),
                Arguments.of("Yikes", new char[]{}, "Yikes"));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctCharzIIStringMethod(String word, char[] letters, String result) throws Throwable{
        String output = (String) MethodUtil.invokeIfMethodExists(WordleBuilder.class, "charzIIString",
                new Object[]{word, letters}, String.class, char[].class);
        assertEquals(result, output, "Your method does not correctly combine the input word and char array.");
    }
}
