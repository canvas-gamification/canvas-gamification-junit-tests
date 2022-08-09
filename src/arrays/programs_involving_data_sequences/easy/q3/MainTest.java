package arrays.programs_involving_data_sequences.easy.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The name removed from the queue is: "),
                new PlaceHolder(),
                new NewLine(),
                new StringLiteral("The first person in the queue is now: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        StringyMovement.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(Arguments.of(new String[]{"Travis", "Laura", "Liam", "Matthew", "Sam", "Marisha"},
                        new String[]{"Laura", "Liam", "Matthew", "Sam", "Marisha", ""}, "The name removed from the queue is: Travis" + System.lineSeparator()),
                Arguments.of(new String[]{"Seth", "Steve", "Spencer", "Stephanie", "Shirley"},
                        new String[]{"Steve", "Spencer", "Stephanie", "Shirley", ""}, "The name removed from the queue is: Seth" + System.lineSeparator()),
                Arguments.of(new String[]{}, new String[]{"The queue is empty."}, ""),
                Arguments.of(new String[]{"Theophania"}, new String[]{""}, "The name removed from the queue is: Theophania" + System.lineSeparator()));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctNextPleaseMethod(String[] names, String[] nextName, String stringOutput) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(StringyMovement.class, "nextPlease", new Object[]{names}, String[].class);
        String removedName = MethodUtil.getMethodOutput();
        CustomAssertions._assertArrayEquals(nextName, output, "Your nextPlease method does not correctly remove the individual at the front of the queue.");
        assertEquals(stringOutput, removedName, "Your nextPlease method does not correctly print the name removed from the queue.");
    }

    @Test
    void printsCorrectOutput() throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct output.";
        runWithInput("", new Clause[]{
                new StringLiteral("Travis"),
                new StringLiteral("Laura")
        });
    }

}
