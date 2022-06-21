package global.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.fail;

public class MethodUtil {
    private static ByteArrayOutputStream methodOutput = new ByteArrayOutputStream();

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, String failMessage, Object[] arguments, Class<?>[] methodArgumentTypes){
        setUpOutput();
            try {
                Method testMethodInvoke = methodClass.getMethod(methodName, methodArgumentTypes);
                return testMethodInvoke.invoke(null, arguments);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                fail(failMessage);
                return null;
            }
    }

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, String failMessage, Object[] arguments, Class<?> [] methodArgumentTypes, String input){
        setUpOutput();
        setUpInput(input);
        try {
            Method testMethodInvoke = methodClass.getMethod(methodName, methodArgumentTypes);
            return testMethodInvoke.invoke(null, arguments);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            fail(failMessage);
            return null;
        }
    }

    public static void setUpOutput(){
        System.setOut(new PrintStream(methodOutput));
    }

    public static void setUpInput(String data){
        ByteArrayInputStream methodInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(methodInput);
    }

    public static String getMethodOutput(){
        if(methodOutput != null)
            return methodOutput.toString().trim();
        else
            return null;
    }
}
