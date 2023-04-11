package oop.user_defined_classes.medium.q3;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;

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
        classInstance = new ObjectTest(classString);
        classInstance.hasField(doubleFieldName, double.class);
        classInstance.hasModifier(doubleFieldName, "private");
        classInstance.hasConstructor(arguments);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(534.32),
                Arguments.of(354.4),
                Arguments.of(93828.12),
                Arguments.of(2232.3)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void horseConstructorInitializesObjectCorrectly(double number) throws Throwable {
        Object[][] arguments = {
                {number, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        _assertEquals(number, classInstance.getFieldValue(instance, doubleFieldName),
                "Your " + className + " constructor does not correctly initialize the " + doubleFieldName + " field.");
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctMakeSoundMethod(double number) throws Throwable {
        Object[][] arguments = {
                {number, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        Object Output = classInstance.callMethod(methodName, instance);
        _assertEquals(methodSound, Output, "Your " + className + " " + methodName + " method does not return the correct string.");
    }
}
