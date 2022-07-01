package global.utils;

import global.tools.Logger;
import global.tools.TestOption;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

public class MethodUtil {
    private static ByteArrayOutputStream methodOutput;

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, Object[] arguments, Class<?>... methodArgumentTypes) throws Throwable {
        setUpMethodOutput();
        try {
            Method testMethodInvoke = methodClass.getMethod(methodName, methodArgumentTypes);
            return testMethodInvoke.invoke(null, arguments);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            fail(Objects.requireNonNullElseGet(
                    TestOption.invalidMethodMessage,
                    () -> String.join("", methodClass.getSimpleName(), " does not contain method ", methodName, "."))
            );
            return null;
        } catch (InvocationTargetException e){
            throw e.getCause();
        }
    }

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName) throws Throwable {
        return invokeIfMethodExists(methodClass, methodName, null, null);
    }

    private static void setUpMethodOutput() {
        methodOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(methodOutput));
    }

    public static String getMethodOutput() {
        return methodOutput.toString();
    }
}
