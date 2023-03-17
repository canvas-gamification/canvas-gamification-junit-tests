package oop.special_class_method.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String className = "Bubble";
    private final String doubleFieldName = "size";
    private final String booleanFieldName = "isPopped";
    private final String setBooleanMethodName = "setIsPopped";
    private final String getBooleanMethodName = "getIsPopped";
    private final String getDoubleMethodName = "getSize";
    private final String setDoubleMethodName = "setSize";
    private final String testClassName = "Test";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.hard.q1." + className;
        testClass = new ObjectTest(classString);
    }

    @Test
    public void bubbleClassHasCorrectFields() {
        assertTrue(testClass.hasField(doubleFieldName, double.class),
                "Your " + className + " class is missing the " + doubleFieldName + " field.");
        assertTrue(testClass.hasModifier(doubleFieldName, "private"),
                "Your " + doubleFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(booleanFieldName, boolean.class),
                "Your " + className + " class is missing the " + doubleFieldName + " field.");
        assertTrue(testClass.hasModifier(booleanFieldName, "private"),
                "Your " + booleanFieldName + " does not have the correct visibility modifier.");
    }

    private static Stream<Double> constructorInputProvider() {
        return Stream.of(
                0.0, -1.22322, 0.0000000001, 23344.33442, 10.0
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void bubbleClassHasCorrectConstructor(double value) throws Throwable {
        Object[][] arguments = {
                {value, double.class}
        };
        Class<?>[] constructorClasses = {double.class};
        Object classInstance = testClass.createInstance(arguments);
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor does not initialize the " + doubleFieldName + " filed to the correct value.";
        String incorrectBooleanValueMessage =
                "Your " + className + " constructor does not initialize the " + booleanFieldName + " filed to the correct value.";
        String incorrectConstructorVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        _assertEquals(value, testClass.getFieldValue(classInstance, doubleFieldName),
                incorrectDoubleValueMessage);
        _assertEquals(false, testClass.getFieldValue(classInstance, booleanFieldName),
                incorrectBooleanValueMessage);
        assertTrue(testClass.hasModifier(constructorClasses, "public"), incorrectConstructorVisibilityModifier);
    }
}
