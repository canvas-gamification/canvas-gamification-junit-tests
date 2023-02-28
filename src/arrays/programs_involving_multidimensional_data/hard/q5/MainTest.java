package arrays.programs_involving_multidimensional_data.hard.q5;

import global.BaseRandomTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Java

    public static final int n = 2;
    public static final int m = 13;
    public static final int down = 97;
    public static final int up = 122;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * m + n + n * m + n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[t++] = new RandomInteger(down, up + 1, i + " " + j);
                if (j != m - 1)
                    c[t++] = new StringLiteral(" ");
                else
                    c[t++] = new Optional(new StringLiteral(" "));
            }
            if (i != n - 1)
                c[t++] = new NewLine();
            else
                c[t++] = new Optional(new NewLine());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                c[t++] = new RandomChar((char) down, (char) (up + 1), i + "c" + j);
            if (i != n - 1)
                c[t++] = new NewLine();
            else
                c[t++] = new Optional(new NewLine());
        }
        return c;
    }

    public void runMain() {
        ChartoInt.main(new String[0]);
    }

    @RepeatedTest(10)
    public void printsCorrectOutput() throws InvalidClauseException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                CustomAssertions._assertEquals(((char) Integer.parseInt(getItemByName(i + " " + j))) + "", getItemByName(i + "c" + j)
                        , "Your program does not correctly convert the generated integers to characters and print them.");
            }
        }
    }


    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {'a', 'b', 'c'},
                                {'d', 'e', 'f'},
                                {'g', 'h', 'i'}
                        },
                        new char[][]{
                                {'a', 'b', 'c'},
                                {'d', 'e', 'f'},
                                {'g', 'h', 'i'}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {'a', 'b', 'c'},
                                {'d', 'e', 'f'},
                                {'g', 'h', 'i'},
                                {'j', 'k', 'l'},
                                {'m', 'n', 'o'},
                                {'p', 'q', 'r'},
                                {'s', 't', 'u'},
                                {'v', 'w', 'x'},
                                {'y', 'z', 'x'}
                        },
                        new char[][]{
                                {'a', 'b', 'c'},
                                {'d', 'e', 'f'},
                                {'g', 'h', 'i'},
                                {'j', 'k', 'l'},
                                {'m', 'n', 'o'},
                                {'p', 'q', 'r'},
                                {'s', 't', 'u'},
                                {'v', 'w', 'x'},
                                {'y', 'z', 'x'}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {'a', 'a', 'a', 'a', 'a', 'a',},
                                {'a', 'a', 'a', 'a', 'a', 'a',},
                                {'a', 'a', 'a', 'a', 'a', 'a',}
                        },
                        new char[][]{
                                {'a', 'a', 'a', 'a', 'a', 'a',},
                                {'a', 'a', 'a', 'a', 'a', 'a',},
                                {'a', 'a', 'a', 'a', 'a', 'a',}
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctIntToCharMethod(int[][] a, char[][] b) throws Throwable {
        Clause[] c = new Clause[b.length * 2];
        int t = 0;
        for (int i = 0; i < b.length; i++) {
            String st = "";
            for (int j = 0; j < b[i].length; j++)
                st += b[i][j];
            c[t++] = new StringLiteral(st);
            c[t++] = new NewLine();
        }
        Object[][] arguments = {
                {a, int[][].class},
        };
        MethodTest m = new MethodTest(ChartoInt.class, "intToChar", arguments, c);
        m.callMethod();
    }
}
