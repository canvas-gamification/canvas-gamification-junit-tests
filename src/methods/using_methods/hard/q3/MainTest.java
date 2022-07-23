package methods.using_methods.hard.q3;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Please enter your favourite number: "),
                new NewLine(),
                new StringLiteral("Your favourite number is "),
                new PlaceHolder()
        };
    }

    public void runMain(){Using3.main(new String[0]);}

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, String failMessage, Object[] arguments, Class<?>... methodArgumentTypes){
        try{
            Method m = methodClass.getMethod(methodName, methodArgumentTypes);
            return m.invoke(null, arguments);
        }
        catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            fail(failMessage);
            return null;
        }
    }
}
