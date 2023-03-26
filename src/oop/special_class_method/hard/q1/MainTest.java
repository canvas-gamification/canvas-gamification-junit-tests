package oop.special_class_method.hard.q1;

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

    private static Stream<Arguments> setSizeInputProvider() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(22431.21, 6669.21458764),
                Arguments.of(1, 0.0),
                Arguments.of(843739243.2229, 163.35)
        );
    }

    @ParameterizedTest
    @MethodSource("setSizeInputProvider")
    public void bubbleClassHasCorrectSetSizeMethod(double initialValue, double setValue) throws Throwable {
        Object[][] arguments = {
                {initialValue, double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {setValue, double.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setDoubleMethodName, "does not correctly set the value of the", doubleFieldName, "field.");
        Object setMethodOutput = testClass.callMethod(setDoubleMethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, doubleFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setDoubleMethodName, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void bubbleClassHasCorrectGetSizeMethod(double value) throws Throwable {
        Object[][] arguments = {
                {value, double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getDoubleMethodName, "does not correctly get the value of the", doubleFieldName, "field.");
        Object getMethodOutput = testClass.callMethod(getDoubleMethodName, getMethodModifiers, classInstance);
        _assertEquals(value, getMethodOutput, incorrectGetMethodMessage);
    }

    private static Stream<Arguments> twoBooleanInputProvider() {
        return Stream.of(
                Arguments.of(false, false),
                Arguments.of(false, true),
                Arguments.of(true, false),
                Arguments.of(true, true)
        );
    }

    @ParameterizedTest
    @MethodSource("twoBooleanInputProvider")
    public void bubbleClassHasCorrectSetIsPoppedMethod(boolean initialValue, boolean updatedValue) throws Throwable {
        Object[][] arguments = {
                {Math.PI, double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, initialValue, booleanFieldName);
        Object[][] setMethodArguments = {
                {updatedValue, boolean.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setBooleanMethodName, "does not correctly set the value of the", booleanFieldName, "field.");
        Object setMethodOutput = testClass.callMethod(setBooleanMethodName, setMethodArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue, testClass.getFieldValue(classInstance, booleanFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setBooleanMethodName, "should not return any output"));
    }

    private static Stream<Boolean> booleanInputProvider() {
        return Stream.of(true, false);
    }

    @ParameterizedTest
    @MethodSource("booleanInputProvider")
    public void bubbleClassHasCorrectGetIsPoppedMethod(boolean value) throws Throwable {
        Object[][] arguments = {
                {Math.PI, double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, value, booleanFieldName);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getBooleanMethodName, "does not correctly get the value of the", booleanFieldName, "field.");
        Object getMethodOutput = testClass.callMethod(getBooleanMethodName, getMethodModifiers, classInstance);
        _assertEquals(value, getMethodOutput, incorrectGetMethodMessage);
    }


    private static Stream<Arguments> doubleBooleanInputProvider() {
        return Stream.of(
                Arguments.of(556.8, false),
                Arguments.of(0.941, true),
                Arguments.of(339.5553323, true),
                Arguments.of(0, false),
                Arguments.of(34, true)
        );
    }

    @ParameterizedTest
    @MethodSource("doubleBooleanInputProvider")
    public void bubbleClassHasCorrectToStringMethod(double value, boolean b) throws Throwable {
        Object[][] arguments = {
                {Math.random(), double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, value, doubleFieldName);
        testClass.setFieldValue(classInstance, b, booleanFieldName);
        String[] methodModifiers = {"public"};
        String expected = "size: " + value + ", isPopped: " + b;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("doubleBooleanInputProvider")
    public void bubbleClassMethodsWorkTogether(double value, boolean b) throws Throwable {
        double initialValue = Math.random() * 100;
        Object[][] arguments = {
                {initialValue, double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(initialValue, testClass.callMethod(getDoubleMethodName, classInstance),
                "Your " + getDoubleMethodName + " method does not return the correct value.");
        _assertEquals(false, testClass.callMethod(getBooleanMethodName, classInstance),
                "Your " + getBooleanMethodName + " method does not return the correct value.");
        Object[][] setDoubleArguments = {
                {value, double.class}
        };
        testClass.callMethod(setDoubleMethodName, setDoubleArguments, classInstance);
        _assertEquals(value, testClass.callMethod(getDoubleMethodName, classInstance),
                "Your " + getDoubleMethodName + " method does not return the correct value calling the " + setDoubleMethodName + " method.");
        Object[][] setBooleanArguments = {
                {b, boolean.class}
        };
        testClass.callMethod(setBooleanMethodName, setBooleanArguments, classInstance);
        _assertEquals(b, testClass.callMethod(getBooleanMethodName, classInstance),
                "Your " + getBooleanMethodName + " method does not return the correct value calling the " + setBooleanMethodName + " method.");
        String expectedToString = "size: " + value + ", isPopped: " + b;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String after updating the values of its fields using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }
}
