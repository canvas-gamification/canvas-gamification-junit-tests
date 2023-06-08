package arrays.creating_arrays.hard.q1;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {
    // Java

    private static boolean correctStructure = false;
    private static final int maxSizeIncrement = 0;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Enter the size of the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Printing out numbers in your array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        RandomArray.main(new String[0]);
    }

    public static Stream<Integer> createRandomArrayInputProvider() {
        return Stream.of(1000, 1001, 1010, 1100, 1250, 1500);
    }

    public static Stream<Integer> mainMethodInputProvider() {
        return Stream.of(0, 1, 5, 60);
    }

    @ParameterizedTest
    @MethodSource("createRandomArrayInputProvider")
    public void correctCreateRandomArrayMethod(int in) throws Throwable {
        Object[][] arguments = {
                {in, int.class}
        };
        MethodTest m = new MethodTest(RandomArray.class, "createRandomArray", arguments);
        Object output = m.callMethod();
        try {
            int[] arr = (int[]) output;
            ArrayList<Integer> response = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
            RandomInteger randomInteger = new RandomInteger(0, in);
            assertTrue(randomInteger.validateRandom(response), "Your program does not correctly create a random array.");
            assertEquals(in, arr.length, "Your createRandomArray method does not return an array of the correct size.");
        } catch (Exception e) {
            fail("Your createRandomArray method does not return an array of integers.");
        }
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    public void correctMainMethodOutput(int in) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not follow the structure in the sample output.";
        runWithInput(String.valueOf(in), clauseBuilder(in));
        correctStructure = true;
    }

    @EnabledIf("getCorrectStructure")
    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    public void correctRandomization(int in) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly randomize the array values.";
        runWithInput(String.valueOf(in), randomClauseBuilder(in));
    }

    Clause[][] clauseBuilder(int x) {
        x += maxSizeIncrement;
        int length = x * 2 - 1;
        if (x <= 0) {
            Clause[][] c = new Clause[1][1];
            c[0][0] = new Optional(new NewLine());
            return c;
        }
        if (x == 1) {
            length = 1;
        }
        Clause[][] c = new Clause[1][length];

        int count = 0;
        for (int i = 0; i < x - 1; i++) {
            c[0][count++] = new IntegerLiteral();
            c[0][count++] = new NewLine();
        }
        c[0][count] = new IntegerLiteral();
        return c;
    }

    Clause[][] randomClauseBuilder(int x) {
        x += maxSizeIncrement;
        int length = x * 2 - 1;
        if (x <= 0) {
            Clause[][] c = new Clause[1][1];
            c[0][0] = new Optional(new NewLine());
            return c;
        }
        if (x == 1) {
            length = 1;
        }
        Clause[][] c = new Clause[1][length];
        int count = 0;
        for (int i = 0; i < x - 1; i++) {
            c[0][count++] = new RandomInteger(0, x);
            c[0][count++] = new NewLine();
        }
        c[0][count] = new RandomInteger(0, x);
        return c;
    }

    public static boolean getCorrectStructure() {
        return correctStructure;
    }
}
