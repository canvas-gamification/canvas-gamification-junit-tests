package oop.special_class_method.hard.q14;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Parsons with Distractors

    private final String className = "Bottle";
    private final String attributeName = "isFull";
    private final String getAttributeMethodName = "getIsFull";
    private final String setAttributeMethodName = "setIsFull";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.hard.q14." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void bottleClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(attributeName),
                "Your " + className + " class is missing the " + attributeName + " attributes, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName, boolean.class),
                "Your " + attributeName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName, "private"),
                "Your " + attributeName + " does not have the correct visibility modifier.");
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(true, false),
                Arguments.of(false, true),
                Arguments.of(true, true),
                Arguments.of(false, false)
        );
    }

    @Test
    public void bottleClassHasRequiredConstructor() {
        Class<?>[] classArguments = {};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct visibility modifiers.");
    }

    @Test
    public void bottleClassHasCorrectConstructor() throws Throwable {
        Object classInstance = testClass.createInstance();
        _assertEquals(false, testClass.getFieldValue(classInstance, attributeName),
                "Your " + className + " constructor does not initialize the " + attributeName + " attribute to the correct value.");
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetIsFullMethod(boolean value) throws Throwable {
        Object testInstance = testClass.createInstance();
        testClass.setFieldValue(testInstance, value, attributeName);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName, null, "public"),
                "Your " + getAttributeMethodName + " method does not have the correct visibility modifier.");
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName + " method does not return the value of the " + attributeName + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctSetYearMadeMethod(boolean initialiValue, boolean updatedValue) throws Throwable {
        Object testInstance = testClass.createInstance();
        testClass.setFieldValue(testInstance, initialiValue, attributeName);
        Object[][] setMethodArguments = {
                {updatedValue, boolean.class}
        };
        Class<?>[] methodModifierClasses = {
                boolean.class
        };
        assertTrue(testClass.hasMethod(setAttributeMethodName, methodModifierClasses, Void.TYPE),
                "Your " + setAttributeMethodName + " method does not have the correct name, return type, or parameters.");
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName + " method does not correctly update the value of " + attributeName + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctToStringMethod(boolean value) throws Throwable {
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance();
        testClass.setFieldValue(testInstance, value, attributeName);
        String expectedOutput;
        if (value)
            expectedOutput = "I am full";
        else
            expectedOutput = "I am empty";
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodsWorkingTogether(boolean initialValue, boolean updatedValue) throws Throwable {
        Object testInstance = testClass.createInstance();
        testClass.setFieldValue(testInstance, initialValue, attributeName);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        _assertEquals(initialValue, getMethodOutput,
                "Your " + getAttributeMethodName + " method does not return the value of the " + attributeName + " attribute.");
        Object[][] setMethodArguments = {
                {updatedValue, boolean.class}
        };
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        _assertEquals(updatedValue, testClass.callMethod(getAttributeMethodName, testInstance),
                "Your " + getAttributeMethodName + " method does not correctly update the value of " + setAttributeMethodName + " after using the " + getAttributeMethodName + " method.");
        String expectedOutput;
        if (updatedValue)
            expectedOutput = "I am full";
        else
            expectedOutput = "I am empty";
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput,
                "Your toString method does not work properly after using " + getAttributeMethodName + " method and " + setAttributeMethodName + " method.");
    }
}
