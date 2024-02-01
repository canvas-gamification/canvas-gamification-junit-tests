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
                "Your " + className + " class is missing the " + attributeName + " attribute, or it is spelled incorrectly.");
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

    @Test
    public void getIsFullIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName, null), String.format(incorrectMethodDefinition, getAttributeMethodName, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName, null, boolean.class), String.format(incorrectReturnType, getAttributeMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetIsFullMethod(boolean value) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName, null), String.format(incorrectMethodDefinition, getAttributeMethodName, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName, null, boolean.class), String.format(incorrectReturnType, getAttributeMethodName, className));
        Object testInstance = testClass.createInstance();
        testClass.setFieldValue(testInstance, value, attributeName);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName + " method does not return the value of the " + attributeName + " attribute.");
    }

    @Test
    public void setIsFullIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName, new Class<?>[]{boolean.class}), String.format(incorrectMethodDefinition, setAttributeMethodName, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName, new Class<?>[]{boolean.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName, new Class<?>[]{boolean.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctSetIsFullMethod(boolean initialiValue, boolean updatedValue) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName, new Class<?>[]{boolean.class}), String.format(incorrectMethodDefinition, setAttributeMethodName, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName, new Class<?>[]{boolean.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName, new Class<?>[]{boolean.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName, className));
        Object testInstance = testClass.createInstance();
        testClass.setFieldValue(testInstance, initialiValue, attributeName);
        Object[][] setMethodArguments = {
                {updatedValue, boolean.class}
        };
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName + " method does not correctly update the value of " + attributeName + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctToStringMethod(boolean value) throws Throwable {
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
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
                "Your " + getAttributeMethodName + " method does not correctly return the value of " + attributeName + " after using the " + setAttributeMethodName + " method.");
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
