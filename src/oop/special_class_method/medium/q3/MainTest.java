package oop.special_class_method.medium.q3;

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
    private final String className = "Speaker";
    private final String attributeName = "volume";
    private final String getAttributeMethodName = "getVolume";
    private final String setAttributeMethodName = "setVolume";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.medium.q3." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void circleClassHasCorrectField() {
        String missingFieldMessage = "Your " + className + " class is missing the " + attributeName + " field.";
        String incorrectVisibilityModifierMessage =
                "Your " + attributeName + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName, double.class), missingFieldMessage);
        assertTrue(testClass.hasModifier(attributeName, "private"), incorrectVisibilityModifierMessage);
    }

    private static Stream<Double> doubleInputProvider() {
        return Stream.of(
                0.0, 23.3233, 553233333.55655334324, -111111.333342, 3554 / 3.7
        );
    }

    @ParameterizedTest
    @MethodSource("doubleInputProvider")
    public void correctCircleConstructor(double value) throws Throwable {
        String incorrectValueMessage = "Your " + className + " constructor does not correctly initialize the " +
                attributeName + " field.";
        String incorrectVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        Object[][] arguments = {
                {value, double.class}
        };
        Class<?>[] classes = {double.class};
        Object testInstance = testClass.createInstance(arguments);
        _assertEquals(value, testClass.getFieldValue(testInstance, attributeName), incorrectValueMessage);
        assertTrue(testClass.hasModifier(classes, "public"), incorrectVisibilityModifier);
    }

    @ParameterizedTest
    @MethodSource("doubleInputProvider")
    public void correctGetSizeMethod(double value) throws Throwable {
        Object[][] arguments = {
                {value, double.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName, null, "public"),
                "Your " + getAttributeMethodName + " method does not have the correct visibility modifier.");
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName + " method does not return the value of the size field.");
    }

    private static Stream<Arguments> twoDoublesInputProvider() {
        return Stream.of(
                Arguments.of(4.23232, 0.0),
                Arguments.of(343434.44364, -343434.44364),
                Arguments.of(5.67, 2 / 3),
                Arguments.of(Math.PI, Math.E)
        );
    }

    @ParameterizedTest
    @MethodSource("twoDoublesInputProvider")
    public void correctSetSizeMethod(double initialValue, double updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {initialValue, double.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, double.class}
        };
        Class<?>[] methodModifierClasses = {
                double.class
        };
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName + " method does not correctly update the value of " + attributeName + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("twoDoublesInputProvider")
    public void correctGetSetMethods(double initialValue, double updatedValue) throws Throwable {
        String errorMessage = "Your " + className + " class " + getAttributeMethodName +
                " method does not return the updated value after calling the " + setAttributeMethodName + " method.";
        Object[][] instantiationArguments = {
                {initialValue, double.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, double.class}
        };
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        _assertEquals(updatedValue, getMethodOutput, errorMessage);
    }
}
