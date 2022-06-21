package global.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.fail;

public class MethodUtil {
    private static ByteArrayOutputStream methodOutput;

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, String failMessage, Object[] arguments, Class<?> ... methodArgumentTypes){
        setUpOutput();
            try {
                Method testMethodInvoke = methodClass.getMethod(methodName, methodArgumentTypes);
                return testMethodInvoke.invoke(null, arguments);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                fail(failMessage);
                return null;
            }
    }

    public static void setUpOutput(){
        methodOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(methodOutput));
    }

    public static String getMethodOutput(){
        return methodOutput.toString().trim();
    }
}
