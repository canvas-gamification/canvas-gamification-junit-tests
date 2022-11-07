package arrays.programs_involving_data_sequences.programs_involving_multidimensional_data.medium.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons with distractors

    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral("multiplier"),
                new NewLine(),
                new IntegerLiteral("1 1"),
                new StringLiteral(" "),
                new IntegerLiteral("1 2"),
                new StringLiteral(" "),
                new IntegerLiteral("1 3"),
                new StringLiteral(" "),
                new NewLine(),
                new IntegerLiteral("2 1"),
                new StringLiteral(" "),
                new IntegerLiteral("2 2"),
                new StringLiteral(" "),
                new IntegerLiteral("2 3"),
                new StringLiteral(" ")
        };
    }

    public void runMain(){
        MultiplyArrays.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(
                Arguments.of(new int[][]{
                        {5, 20, 1, 3},
                        {2, 17},
                        {15, 0, 12, 5, 7}
                }, 6, new int[][]{
                        {30, 120, 6, 18},
                        {12, 102},
                        {90, 0, 72, 30, 42}
                }),
                Arguments.of(new int[][]{
                        {}
                }, 0, new int[][]{

                }),
                Arguments.of(new int[][]{
                        {}
                }, -7, new int[][]{

                }),
                Arguments.of(new int[][]{
                        {}
                }, 27, new int[][]{

                })
        );
    }

    public void correctMainMethodOutput(){
        runMain();

        int multiplier = Integer.parseInt(getItemByName("multiplier"));

        boolean b = true;

        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 3; y++){
                if(Integer.parseInt(getItemByName(x + " " + y))%multiplier != 0){
                    b = false;
                }
            }
        }

        assertTrue(b, "Your main method does not output a correctly multiplied array.");

    }
}
