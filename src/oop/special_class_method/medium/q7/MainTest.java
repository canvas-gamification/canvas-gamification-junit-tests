package oop.special_class_method.medium.q7;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String className = "PiggyBank";
    private final String attributeName1 = "numPennies";
    private final String getAttributeMethodName1 = "getNumPennies";
    private final String setAttributeMethodName1 = "setNumPennies";
    private final String attributeName2 = "numNickels";
    private final String getAttributeMethodName2 = "getNumNickels";
    private final String setAttributeMethodName2 = "setNumNickels";
    private final String toStringMessage = "The total amount is $";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q7." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, int.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), modifiedClassMessage);
        assertTrue(testClass.hasField(attributeName2, int.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName2, "private"), modifiedClassMessage);
        Class<?>[] classes = {};
        Object testInstance = testClass.createInstance();
        _assertEquals(0, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
        _assertEquals(0, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
        assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);
    }


    private static Stream<Integer> intInputProvider() {
        return Stream.of(
                0, 23, 553233333, 111111, 3554
        );
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctGetNumPenniesMethod(int value) throws Throwable {
        Object testInstance = testClass.createInstance();
        testClass.setFieldValue(testInstance, value, attributeName1);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1+ " attribute.");
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctGetNumNickelsMethod(int value) throws Throwable {
        Object testInstance = testClass.createInstance();
        testClass.setFieldValue(testInstance, value, attributeName2);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctSetNumPenniesMethod(int updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        Class<?>[] methodModifierClasses = {
                int.class
        };
        Object output = testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName1, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName1 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
        assertNull(output, String.join(" ", "Your", setAttributeMethodName1, "method should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctSetNumNickelsMethod(int updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        Class<?>[] methodModifierClasses = {
                int.class
        };
        Object output = testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName2, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName2 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
        assertNull(output, String.join(" ", "Your", setAttributeMethodName1, "method should not return any output"));
    }

    private static Stream<Arguments> intInputProvider2() {
        return Stream.of(
                Arguments.of(2, 3),
                Arguments.of(32, 1323),
                Arguments.of(43, 213),
                Arguments.of(124332, 434343),
                Arguments.of(223, 0)

        );
    }


    @ParameterizedTest
    @MethodSource("intInputProvider2")
    public void correctToStringMethod(int value1, int value2) throws Throwable {
        double value = (value1 * 1 + value2 * 5) / 100.0;
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance(null);
        testClass.setFieldValue(testInstance, value1, attributeName1);
        testClass.setFieldValue(testInstance, value2, attributeName2);
        String expectedOutput = toStringMessage + value;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("intInputProvider2")
    public void methodsWorkingTogether(int value1, int value2) throws Throwable {
        Object testInstance = testClass.createInstance();
        Object[][] setMethodArguments = {
                {value1, int.class}
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        _assertEquals(value1, testClass.callMethod(getAttributeMethodName1, testInstance),
                "Your " + getAttributeMethodName1 + " method does not correctly update the value of " + setAttributeMethodName1 + " after using the " + getAttributeMethodName1 + " method.");
        setMethodArguments = new Object[][]{
                {value2, int.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        _assertEquals(value2, testClass.callMethod(getAttributeMethodName2, testInstance),
                "Your " + getAttributeMethodName2 + " method does not correctly update the value of " + setAttributeMethodName2 + " after using the " + getAttributeMethodName2 + " method.");
        String expectedOutput = "The total amount is $" + ((value1 * 1 + value2 * 5) / 100.0);
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput,
                "Your toString method does not print the correct String after using the getter and setter methods.");
    }
}
