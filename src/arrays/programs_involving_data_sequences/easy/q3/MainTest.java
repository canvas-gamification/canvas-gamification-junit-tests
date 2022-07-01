package arrays.programs_involving_data_sequences.easy.q3;

import global.BaseTest;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
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

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(new String[]{"Travis", "Laura", "Liam", "Matthew", "Sam", "Marisha"},
                new String[]{"Laura", "Liam", "Matthew", "Sam", "Marisha", ""}, "Travis", "Laura"),
                Arguments.of(new String[]{}, new String[]{}, "", ""));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctNextPleaseMethod(String [] names, String [] nextName, String removed, String front) throws Throwable{
        runWithInput("", new Clause[]{
                new StringLiteral(removed),
                new StringLiteral(front)
        });
        String [] output = (String[]) MethodUtil.invokeIfMethodExists(StringyMovement.class, "nextPlease", new Object[]{names}, String[].class);
        assertArrayEquals(nextName, output, "Your method does not correctly remove the individual at the front of the queue.");
    }

}
