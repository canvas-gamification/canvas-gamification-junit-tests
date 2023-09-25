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
    public void horseHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{};
        assertTrue(classInstance.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className));
        assertTrue(classInstance.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className));
    }

    @Test
    public void bankConstructorInitializesObjectCorrectly() throws Throwable {
        Object instance = classInstance.createInstance();
        _assertEquals(initialFee, classInstance.getFieldValue(instance, var), 0.000001,
                "Your " + className + " constructor does not correctly initialize the " + var + " attribute.");
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(0),
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
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(classInstance.hasMethod(methodName, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(classInstance.hasModifier(methodName, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(classInstance.hasReturnType(methodName, new Class<?>[]{int.class}, double.class), String.format(incorrectReturnType, methodName, className));
        Object instance = classInstance.createInstance();
        Object output = classInstance.callMethod(methodName, arguments, (new String[]{"public"}), instance);
        Object fee = classInstance.getFieldValue(instance, var);
        assertTrue(classInstance.hasMethod(methodName, new Class<?>[]{int.class}, double.class, new String[]{"public"}));
        _assertEquals((double) fee * (num + 0.95), output, 0.0001,
                "Your " + className + " " + methodName + " does not correctly calculate the future " + var);

    }
}
