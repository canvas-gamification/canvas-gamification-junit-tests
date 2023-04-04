package oop.user_defined_classes.medium.q1;

import global.ObjectTest;
import global.variables.clauses.RandomInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {
    // Java

    // Constants for Variation
    private final String className = "Circle";
    private final String intFieldName = "position";
    private final String stringFieldName = "colour";
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String classString = "oop.user_defined_classes.medium.q1." + className;
        classInstance = new ObjectTest(classString);

        // Check to make sure they have not changed any of the fields
        assertTrue(classInstance.hasField(intFieldName, int.class, new String[]{"private"}),
                "You have modified the " + intFieldName + " field, please revert it back to the original state."
        );
        assertTrue(classInstance.hasField(stringFieldName, String.class, new String[]{"private"}),
                "You have modified the " + stringFieldName + " field, please revert it back to the original state.");
    }

    @Test
    public void circleClassHasCorrectConstructor() {
        Class<?>[] arguments = {
                int.class, String.class
        };
        assertTrue(classInstance.hasConstructor(arguments),
                "Your " + className + " class is missing a required constructor.");
        assertTrue(classInstance.hasModifier(arguments, "public"),
                "Your " + className + " class constructor does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(5, "Red"),
                Arguments.of(-1, "Mario time!"),
                Arguments.of(93828, "One stringy boi is what this is.    :)"),
                Arguments.of(223333222, "344124124")
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void circleConstructorInitializesObjectCorrectly(int number, String string) throws Throwable {
        Object[][] arguments = {
                {number, int.class},
                {string, String.class}
        };
        Object instance = classInstance.createInstance(arguments);
        _assertEquals(number, classInstance.getFieldValue(instance, intFieldName),
                "Your " + className + " constructor does not correctly initialize the " + intFieldName + " field.");
        _assertEquals(string, classInstance.getFieldValue(instance, stringFieldName),
                "Your " + className + " constructor does not correctly initialize the " + stringFieldName + " field.");
    }
}
