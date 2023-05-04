package oop.special_class_method.medium.q2;

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
    private final String className = "Lamp";
    private final String attributeName1 = "brightness";
    private final String getAttributeMethodName1 = "getBrightness";
    private final String setAttributeMethodName1 = "setBrightness";
    private final String attributeName2 = "isOn";
    private final String getAttributeMethodName2 = "getIsOn";
    private final String setAttributeMethodName2 = "setIsOn";

    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.medium.q2." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void lampClassHasCorrectField() {
        String missingFieldMessage = "Your " + className + " class is missing the " + attributeName1 + " field.";
        String incorrectVisibilityModifierMessage =
                "Your " + attributeName1 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName1, double.class), missingFieldMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), incorrectVisibilityModifierMessage);

        String missingFieldMessage2 = "Your " + className + " class is missing the " + attributeName2 + " field.";
        String incorrectVisibilityModifierMessage2 =
                "Your " + attributeName2 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName2, boolean.class), missingFieldMessage2);
        assertTrue(testClass.hasModifier(attributeName2, "private"), incorrectVisibilityModifierMessage2);
    }

    private static Stream<Double> doubleInputProvider() {
        return Stream.of(
                0.0, 23.3233, 553233333.55655334324, -111111.333342, 3554 / 3.7
        );
    }

    @ParameterizedTest
    @MethodSource("doubleInputProvider")
    public void correctLampConstructor(double value) throws Throwable {
        String incorrectValueMessage = "Your " + className + " constructor does not correctly initialize the " +
                attributeName1 + " field.";
        String incorrectValueMessage2 = "Your " + className + " constructor does not correctly initialize the " +
                attributeName2 + " field.";
        String incorrectVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        Object[][] arguments = {
                {value, double.class}
        };
        Class<?>[] classes = {double.class};
        Object testInstance = testClass.createInstance(arguments);
        _assertEquals(value, testClass.getFieldValue(testInstance, attributeName1), incorrectValueMessage);
        _assertEquals(true, testClass.getFieldValue(testInstance, attributeName2), incorrectValueMessage2);
        assertTrue(testClass.hasModifier(classes, "public"), incorrectVisibilityModifier);
    }

    @ParameterizedTest
    @MethodSource("doubleInputProvider")
    public void correctGetBrightnessMethod(double value) throws Throwable {
        Object[][] arguments = {
                {value, double.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the size field.");
    }

    private static Stream<Arguments> twoDoubleInputProvider() {
        return Stream.of(
                Arguments.of(5.4, 6.4),
                Arguments.of(654.3, 54.2),
                Arguments.of(43.3, 43.2),
                Arguments.of(432.2, 899.8)
        );
    }

    @ParameterizedTest
    @MethodSource("twoDoubleInputProvider")
    public void correctSetBrightnessMethod(double initialValue, double updatedValue) throws Throwable {
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
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName1, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName1 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
    }

    private static Stream<Arguments> booleanDoublesInputProvider() {
        return Stream.of(
                Arguments.of(4.23232, false),
                Arguments.of(343434.44364, true),
                Arguments.of(5.67, true),
                Arguments.of(Math.PI, false)
        );
    }

    @ParameterizedTest
    @MethodSource("booleanDoublesInputProvider")
    public void correctLampConstructor(double value, boolean on) throws Throwable {
        String incorrectValueMessage = "Your " + className + " constructor does not correctly initialize the " +
                attributeName1 + " field.";
        String incorrectValueMessage2 = "Your " + className + " constructor does not correctly initialize the " +
                attributeName2 + " field.";
        String incorrectVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        Object[][] arguments = {
                {value, double.class},
                {on, boolean.class}
        };
        Class<?>[] classes = {double.class, boolean.class};
        Object testInstance = testClass.createInstance(arguments);
        _assertEquals(value, testClass.getFieldValue(testInstance, attributeName1), incorrectValueMessage);
        _assertEquals(on, testClass.getFieldValue(testInstance, attributeName2), incorrectValueMessage2);
        assertTrue(testClass.hasModifier(classes, "public"), incorrectVisibilityModifier);
    }

    @ParameterizedTest
    @MethodSource("booleanDoublesInputProvider")
    public void correctGetIsOnMethod(double value, boolean on) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {on, boolean.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(on, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the size field.");
    }

    private static Stream<Arguments> twoBooleanInputProvider() {
        return Stream.of(
                Arguments.of(1.2, true, false),
                Arguments.of(2.3, false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("twoBooleanInputProvider")
    public void correctSetIsOnMethod(double value, boolean initialValue, boolean updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value, double.class},
                {initialValue, boolean.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, boolean.class}
        };
        Class<?>[] methodModifierClasses = {
                boolean.class
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName2, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName2 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }
}
