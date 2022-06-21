package test;

import global.BaseTest;
import global.annotations.MethodTest;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodCodeTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Hello there"),
                new NewLine(),
                new StringLiteral("Print something"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        MethodCode.main(new String[0]);
    }

    static Stream<Arguments> testInput(){
        return Stream.of();
    }

    @Test
    @MethodTest
    void test() {
        MethodUtil.invokeIfMethodExists(MethodCode.class, "printSomething", "Your method does not work", null, null);
        String s = MethodUtil.getMethodOutput();
        assertEquals(s, "Print something", "Output does not match");
    }

    @Test
    void testWithInput(){
        MethodUtil.invokeIfMethodExists(MethodCode.class, "printThis", "Your method is big bad", null, null, "this" );
        assertEquals(MethodUtil.getMethodOutput(), "this", "rip me");
    }
}
