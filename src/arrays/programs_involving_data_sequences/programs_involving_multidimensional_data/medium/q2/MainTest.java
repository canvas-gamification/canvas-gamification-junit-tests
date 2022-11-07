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
                        {373892, 4832, 12903, 29},
                        {219, 1, 32142, 48214, 12849217, 493},
                        {37219, 42401, 38271, 43281},
                        {36, 1920, 327, 32},
                        {83921, 5880, 19230, 48}
                }, 0, new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                }),
                Arguments.of(new int[][]{
                        {712, 7, 7, 7, 7, 7, 7, 7, 7, 7},
                        {8, 2, -1, 8},
                        {23, 54, 6798, 56, 9},
                        {-89, -5, -567, -325, -7654, -65},
                        {-18, 901, 118}
                }, -7, new int[][]{
                        {-4984, -49, -49, -49, -49, -49, -49, -49, -49, -49},
                        {-56, -14, 7, -56},
                        {-161, -378, -47586, -392, 63},
                        {623, 35, 3969, 2275, 455},
                        {126, -6307, 826}
                }),
                Arguments.of(new int[][]{
                        {-32, 283, -12, -48},
                        {-2},
                        {89, 273, -27, 328, 4, -293, 7},
                        {0, 38, -1}
                }, 27, new int[][]{
                        {864, 7641, -324, -1296},
                        {-54},
                        {2403, 7371, -729, 8856, 108, -7911, 189},
                        {0, 1026, -27}
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
