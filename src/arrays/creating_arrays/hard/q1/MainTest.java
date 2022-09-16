package arrays.creating_arrays.hard.q1;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {
    // Java
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

    public void runMain(){
        RandomArray.main(new String[0]);
    }

    public static Stream<Integer> createRandomArrayInputProvider(){
        return Stream.of(0, 1, 2, 3, 5, 10, 50, 100);
    }

    public static Stream<Integer> mainMethodInputProvider(){
        return Stream.of(0, 1, 5, 60);
    }

    @ParameterizedTest
    @MethodSource("createRandomArrayInputProvider")
    public void correctCreateRandomArrayMethod(int in) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(RandomArray.class, "createRandomArray", new Object[]{in}, int.class);
        assertTrue(output != null, "Your createRandomArray method does not return anything.");
        boolean b = output.getClass().isArray();
        assertTrue(b, "Your createRandomArray method does not return an array.");
        try{
            int[] arr = (int[]) output;
            boolean allInts = true;
            for(int x: arr){
                if(x > in)
                    allInts= false;
            }
            assertTrue(allInts, "Your createRandomArray method generates numbers larger than the size of the array.");
        }
        catch(Exception e){
            fail("Your createRandomArray method does not return an array of integers.");
        }

    }


}
