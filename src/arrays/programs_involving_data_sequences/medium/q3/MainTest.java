package arrays.programs_involving_data_sequences.medium.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
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
        TestOption.defaultInput = "1 2 3 4 5 6 7 8 9 10";
        return new Clause[]{
                new PlaceHolder()
        };
    }

    public void runMain() {
        BuildAnArray.main(new String[0]);
    }

//    static Stream<Arguments> inputProvider(){
//        return Stream.of(Arguments.of("-1"));
//    }
//
//    @ParameterizedTest
//    @MethodSource("inputProvider")
//    void printsArrayCorrectly(String input) throws InvalidClauseException {
//        runWithInput(input, new Clause[]{
//                new StringLiteral(input)
//        });
//    }
}
