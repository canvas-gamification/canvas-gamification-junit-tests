package arrays.arrays_with_methods.medium.q3;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    // Parsons with distractors
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new String[]{"How", "Do", "You", "Do", "Fellow", "Kids"}, "K", "Kids"),
                Arguments.of(new String[]{}, " ", "/"),
                Arguments.of(new String[]{"Hello", "There", "How", "Are", "You"}, "H", "Hello"),
                Arguments.of(new String[]{"Perry", "the", "Platypus"}, "T", "/"),
                Arguments.of(new String[]{"What", "where", "Why", "when", "howard"}, "w", "where"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctFindItMethod(String[] input, char element, String match) {
        String output = (String) MethodUtil.invokeIfMethodExists(FindIt.class, "findIt", new Object[]{input, element},
                String[].class, char.class);
        assertEquals(match, output, "Your method does not return the correct element.");
    }
}
