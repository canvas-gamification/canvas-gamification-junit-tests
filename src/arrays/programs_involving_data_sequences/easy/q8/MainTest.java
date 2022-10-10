package arrays.programs_involving_data_sequences.easy.q8;

import global.BaseTest;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral(4),
                new NewLine(),
                new IntegerLiteral(4),
                new NewLine(),
                new IntegerLiteral(2),
                new NewLine(),
                new IntegerLiteral(10)
        };
    }

    public void runMain(){
        SuperCali.main(new String[0]);
    }

    //what if two words have the same length

    static Stream<Arguments> inputProvider(){
        return Stream.of(
                Arguments.of(ArrayUtil.generateRandomWordArray(5), 5),
                Arguments.of(ArrayUtil.generateRandomWordArray(10), 10),
                Arguments.of(ArrayUtil.generateRandomWordArray(15), 15),
                Arguments.of(ArrayUtil.generateRandomWordArray(7), 7),
                Arguments.of(ArrayUtil.generateRandomWordArray(20), 20),
                Arguments.of(ArrayUtil.generateRandomWordArray(50), 50),
                Arguments.of(ArrayUtil.generateRandomWordArray(100), 100)
        );
    }

    //hey self, you're gonna need to use the method print stuff and figure out what the longest element is and maybe what the length of each element is. Maybe with an array of ints and the largest one, get the index for an check it against the index of supercalli with .indexOf instead of .asList in the assert below
    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctLengthFinderMethod(String[] arr, int size){
        assertTrue(Arrays.asList(arr).contains("Supercalifragilisticexpialidocious"), "Your method does not substitue one element for the specified word.");
    }

}
