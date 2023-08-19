package oop.user_defined_classes.medium.q5;

import global.ObjectTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String className = "Bank";
    private final String var = "fee";
    private final String methodName = "increase";
    private final double initialFee = 5.25;

    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.user_defined_classes.medium.q5." + className;
        classInstance = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(classInstance.hasField(var, double.class), modifiedClassMessage);
        assertTrue(classInstance.hasModifier(var, "private"), modifiedClassMessage);

    }

    @Test
    void hasCorrectConstructor() throws Throwable {
        String incorrectCons = "Your " + className + " class does not have the correct constructor.";
        String incorrectModi = "Your " + className + " constructor does not have the correct visibility modifier.";
        Class<?>[] classArguments = {};
        assertTrue(classInstance.hasConstructor(classArguments), incorrectCons);
        assertTrue(classInstance.hasModifier(classArguments, "public"), incorrectModi);
        Object instance = classInstance.createInstance();
        _assertEquals(initialFee, classInstance.getFieldValue(instance, var), incorrectCons);
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(2),
                Arguments.of(7),
                Arguments.of(12),
                Arguments.of(24)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void bankCorrectIncreaseMethod(int num) throws Throwable {
        Object[][] arguments = {
                {num, int.class}
        };
        Object instance = classInstance.createInstance();
        Object output = classInstance.callMethod(methodName, arguments, (new String[]{"public"}), instance);
        Object fee = classInstance.getFieldValue(instance, var);
        assertTrue(classInstance.hasMethod(methodName, new Class<?>[]{int.class}, double.class, new String[]{"public"}));
        _assertEquals((double) fee * (num + 0.95), output,
                "Your " + className + " " + methodName + " does not correctly calculate the future " + var);

    }
}
