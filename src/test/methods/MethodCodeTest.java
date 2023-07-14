package test.methods;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodCodeTest extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Hello there";
        return new Clause[]{
                new StringLiteral("This is the main method"),
                new NewLine(),
                new StringLiteral("Print something"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        MethodCode.main(new String[0]);
    }

    static Stream<String> inputProvider() {
        return Stream.of("Git gud", "Dance until you are dead");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void worksWithOtherStuff(String input) throws InvalidClauseException {
        runWithInput(input, new Clause[]{
                new StringLiteral(input)
        });
    }

    @Test
    void testOutput() throws Throwable {
        MethodUtil.invokeIfMethodExists(MethodCode.class, "printSomething");
        String s = MethodUtil.getMethodOutput();
        assertEquals(s, "Print something" + System.lineSeparator(), "Failed at assert");
    }

    @Test
    void testWithInput() throws Throwable {
        provideInput("print this");
        TestOption.invalidMethodMessage = "Fail";
        MethodUtil.invokeIfMethodExists(MethodCode.class, "printThis");
        String s = MethodUtil.getMethodOutput();
        getOutput();
        assertEquals("print this" + System.lineSeparator(), s, "Failed at assert");
    }

    @Test
    void checkGetMethodOutput() throws Throwable {
        TestOption.invalidMethodMessage = "Invoke failed";
        double f = (double) MethodUtil.invokeIfMethodExists(MethodCode.class, "max", new Object[]{5, 9}, int.class, int.class);
        String s = MethodUtil.getMethodOutput();
        assertEquals(f, 9.0, "Assert failed");
    }

    @Test
    public void checkMaxReturnType() {
        Object[][] arguments = {
                {4, int.class},
                {5, int.class}
        };
        MethodTest methodTest = new MethodTest(MethodCode.class, "max", arguments);
        assertEquals(double.class, methodTest.getMethodReturnType(),
                "Return types were different.");
    }
}
