package oop.user_defined_classes.medium.q3;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static global.tools.CustomAssertions._assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String className = "Horse";
    private final String doubleFieldName = "weight";
    private final String methodName = "makeSound";
    private final String methodSound = "Neigh!!";

    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        Class<?>[] arguments = {
                double.class
        };
        String classString = "oop.user_defined_classes.medium.q3." + className;
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        classInstance = new ObjectTest(classString);
        assertTrue(classInstance.hasField(doubleFieldName, double.class), modifiedClassMessage);
        assertTrue(classInstance.hasModifier(doubleFieldName, "private"), modifiedClassMessage);
        assertTrue(classInstance.hasConstructor(arguments), modifiedClassMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(534.32),
                Arguments.of(354.4),
                Arguments.of(93828.12),
                Arguments.of(2232.3),
                Arguments.of(-534.32),
                Arguments.of(-354.4),
                Arguments.of(-93828.12),
                Arguments.of(-2232.3)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void horseConstructorInitializesObjectCorrectly(double number) throws Throwable {
        Object[][] arguments = {
                {number, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        if (number > 0)
            _assertEquals(number, classInstance.getFieldValue(instance, doubleFieldName),
                    "Your " + className + " constructor does not correctly initialize the " + doubleFieldName + " attribute.");
        else
            _assertEquals(0.000, classInstance.getFieldValue(instance, doubleFieldName), 0.000001,
                    "Your " + className + " constructor does not correctly initialize the " + doubleFieldName + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctMakeSoundMethod(double number) throws Throwable {
        Object[][] arguments = {
                {number, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        Object output = classInstance.callMethod(methodName, instance);
        _assertEquals(methodSound, Output, "Your " + className + " " + methodName + " method does not return the correct string.");
    }
}
