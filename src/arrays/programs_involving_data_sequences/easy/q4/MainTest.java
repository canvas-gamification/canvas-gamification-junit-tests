package arrays.programs_involving_data_sequences.easy.q4;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Travis|Laura|Liam|Matthew|Sam|Marisha"),
                new NewLine(),
                new StringLiteral("Travis|Laura|Liam|Matthew|Sam|Marisha"),
                new NewLine(),
                new StringLiteral("Travis|Laura|Liam|Matthew|Sam|Marisha"),
                new NewLine(),
                new StringLiteral("Travis|Laura|Liam|Matthew|Sam|Marisha"),
                new NewLine(),
                new StringLiteral("Travis|Laura|Liam|Matthew|Sam|Marisha"),
                new NewLine(),
                new StringLiteral("Travis|Laura|Liam|Matthew|Sam|Marisha")
        };
    }

    public void runMain() {
        GameNight.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(
                Arguments.of(6, new String[]{"Sam", "Ham", "Mam", "Clam", "Slam", "Pam"}),
                Arguments.of(3, new String[]{"Liam", "Miam", "Siam"}),
                Arguments.of(17, new String[]{"There", "once", "was", "a", "boy", "who", "was", "named", "Eustace",
                        "Clarence", "Scrubb", "and", "he", "almost", "deserved", "it", "."}),
                Arguments.of(100, ArrayUtil.generateRandomWordArray(100))
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctMusicalChairsMethod(int size, String[] in) throws Throwable {
        int[][] numbers = new int[size][1000];
        String[] answers = new String[size];
        int count = 0;
        System.arraycopy(in, 0, answers, 0, in.length);

        Object[][] arguments = {
                {in, String[].class}
        };
        MethodTest m = new MethodTest(GameNight.class, "musicalChairs", arguments);

        StringBuilder s = new StringBuilder();

        for(int a = 0; a < 1000; a++) {
            m.callMethod();

            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (in[y].equals(answers[x])) {
                        numbers[y][count] = x;
                        s.append(x);
                    }
                }
            }
            count++;
            System.arraycopy(answers, 0, in, 0, answers.length);
            s.append("\n");
        }

        for (int[] storeRandom : numbers) {
            ArrayList<Integer> response = Arrays.stream(storeRandom).boxed().collect(Collectors.toCollection(ArrayList::new));
            RandomInteger randomInteger = new RandomInteger(0, size);
            assertTrue(randomInteger.validateRandom(response), s.toString());
        }

    }
}
