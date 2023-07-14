package arrays.programs_involving_data_sequences.easy.q4;

import global.BaseTest;
import global.MethodTest;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
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

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(6, new String[]{"Sam", "Ham", "Mam", "Clam", "Slam", "Pam"}),
                Arguments.of(3, new String[]{"Liam", "Miam", "Siam"}),
                Arguments.of(17, new String[]{"There", "once", "was", "a", "boy", "who", "repeat", "named", "Eustace",
                        "Clarence", "Scrubb", "and", "he", "almost", "deserved", "it", "."}),
                Arguments.of(50, new String[]{"portrait", "lecture", "old", "promotion", "exemption", "summit", "pride", "well", "attraction", "past", "ostracize", "jockey", "progressive", "egg", "morale", "eternal", "clash", "exploit", "owe", "experienced", "water", "favor", "change", "shaft", "burst", "area", "reflect", "church", "displace", "situation", "dentist", "basis", "commemorate", "doubt", "couple", "bloody", "waterfall", "recovery", "forward", "lodge", "home", "gas", "courage", "concede", "crystal", "fastidious", "rock", "horseshoe", "bride", "infection"})
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctMusicalChairsMethod(int size, String[] in) throws Throwable {
        int[][] numbers = new int[size][1000];
        String[] answers = new String[size];
        System.arraycopy(in, 0, answers, 0, in.length);

        Object[][] arguments = {
                {in, String[].class}
        };
        MethodTest m = new MethodTest(GameNight.class, "musicalChairs", arguments);

        for (int a = 0; a < 1000; a++) {
            m.callMethod();

            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (answers[y].equals(in[x])) {
                        numbers[y][a] = x;
                    }
                }
            }
            System.arraycopy(answers, 0, in, 0, answers.length);
        }

        int count = 0;

        for (int x = 0; x < size; x++) {
            ArrayList<Integer> response = Arrays.stream(numbers[x]).boxed().collect(Collectors.toCollection(ArrayList::new));
            RandomInteger randomInteger = new RandomInteger(0, size);
            if (randomInteger.validateRandom(response))
                count++;
        }

        String s = "Your musicalChairs method does not randomly shuffle the names in the array.";

        if (size <= 5) {
            assertEquals(size, count, s);
        } else {
            assertTrue(size - 2 <= count, s);
        }
    }
}
