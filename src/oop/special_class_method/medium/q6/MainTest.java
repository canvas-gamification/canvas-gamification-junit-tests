package oop.special_class_method.medium.q6;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String className = "Scissors";
    private final String attributeName1 = "isSharp";
    private final String getAttributeMethodName1 = "getIsSharp";
    private final String setAttributeMethodName1 = "setIsSharp";
    private final String attributeName2 = "outOfReach";
    private final String getAttributeMethodName2 = "getOutOfReach";
    private final String setAttributeMethodName2 = "setOutOfReach";

    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q6." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, boolean.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), modifiedClassMessage);
        assertTrue(testClass.hasField(attributeName2, boolean.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName2, "private"), modifiedClassMessage);
        boolean[][] tests = new boolean[][]{{true, true}, {true, false}, {false, true}, {false, false}};
        for (int i = 0; i < tests.length; i++) {
            boolean sharp = tests[i][0];
            boolean cut = tests[i][1];
            Object[][] arguments = {
                    {sharp, boolean.class},
                    {cut, boolean.class}
            };
            Class<?>[] classes = {boolean.class, boolean.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(sharp, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
            _assertEquals(cut, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);
        }
    }

    private static Stream<Arguments> twoBooleanInputProvider() {
        return Stream.of(
                Arguments.of(true, false),
                Arguments.of(false, true),
                Arguments.of(true, true),
                Arguments.of(false, false)
        );
    }

    @ParameterizedTest
    @MethodSource("twoBooleanInputProvider")
    public void correctGetIsSharpMethod(boolean sharp, boolean cut) throws Throwable {
        Object[][] arguments = {
                {sharp, boolean.class},
                {cut, boolean.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(sharp, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
    }

    private static Stream<Arguments> threeBooleanInputProvider() {
        return Stream.of(
                Arguments.of(false, true, false),
                Arguments.of(true, false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("threeBooleanInputProvider")
    public void correctSetIsSharpMethod(boolean initialValue, boolean updatedValue, boolean c) throws Throwable {
        Object[][] instantiationArguments = {
                {initialValue, boolean.class},
                {c, boolean.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, boolean.class}
        };
        Class<?>[] methodModifierClasses = {
                boolean.class
        };
        assertTrue(testClass.hasMethod(setAttributeMethodName1, methodModifierClasses, Void.TYPE),
                "Your " + setAttributeMethodName1 + " method does not have the correct name or arguments.");
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName1, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName1 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("twoBooleanInputProvider")
    public void correctGetOutOfReachMethod(boolean sharp, boolean cut) throws Throwable {
        Object[][] arguments = {
                {sharp, boolean.class},
                {cut, boolean.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(cut, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }


    @ParameterizedTest
    @MethodSource("threeBooleanInputProvider")
    public void correctSetOutOfReachMethod(boolean initialValue, boolean updatedValue, boolean c) throws Throwable {
        Object[][] instantiationArguments = {
                {c, boolean.class},
                {initialValue, boolean.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, boolean.class}
        };
        Class<?>[] methodModifierClasses = {
                boolean.class
        };
        assertTrue(testClass.hasMethod(setAttributeMethodName2, methodModifierClasses, Void.TYPE),
                "Your " + setAttributeMethodName2 + " method does not have the correct name or arguments.");
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName2, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName2 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("twoBooleanInputProvider")
    public void correctToStringMethod(boolean value1, boolean value2) throws Throwable {
        Object[][] arguments = {
                {value1, boolean.class},
                {value2, boolean.class}
        };
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance(arguments);
        String expectedOutput = "isSharp is " + value1 + " and outOfReach is " + value2;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("twoBooleanInputProvider")
    public void methodsWorkingTogether(boolean value1, boolean value2) throws Throwable {
        Object[][] initialArguments = {
                {false, boolean.class},
                {true, boolean.class}
        };
        Object testInstance = testClass.createInstance(initialArguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals(false, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
        getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(true, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
        Object[][] setMethodArguments = {
                {value1, boolean.class}
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        _assertEquals(value1, testClass.getFieldValue(testInstance, attributeName1),
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + " after using the " + getAttributeMethodName1 + " method.");
        setMethodArguments = new Object[][]{
                {value2, boolean.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        _assertEquals(value2, testClass.getFieldValue(testInstance, attributeName2),
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + " after using the " + getAttributeMethodName2 + " method.");
        String expectedOutput = "isSharp is " + value1 + " and outOfReach is " + value2;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput,
                "Your toString method does not print the correct String after using the getter and setter methods.");
    }
}