package oop.special_class_method.medium.q6;

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
    private final String className = "Scissors";
    private final String attributeName1 = "isSharp";
    private final String getAttributeMethodName1 = "getIsSharp";
    private final String setAttributeMethodName1 = "setIsSharp";
    private final String attributeName2 = "canCut";
    private final String getAttributeMethodName2 = "getCanCut";
    private final String setAttributeMethodName2 = "setCanCut";

    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.medium.q6." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void scissorsClassHasCorrectField() {
        String missingFieldMessage = "Your " + className + " class is missing the " + attributeName1 + " field.";
        String incorrectVisibilityModifierMessage =
                "Your " + attributeName1 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName1, boolean.class), missingFieldMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), incorrectVisibilityModifierMessage);

        String missingFieldMessage2 = "Your " + className + " class is missing the " + attributeName2 + " field.";
        String incorrectVisibilityModifierMessage2 =
                "Your " + attributeName2 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName2, boolean.class), missingFieldMessage2);
        assertTrue(testClass.hasModifier(attributeName2, "private"), incorrectVisibilityModifierMessage2);
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
                "Your " + getAttributeMethodName1 + " method does not return the value of the size field.");
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
    public void correctCalculatorConstructor(boolean sharp, boolean cut) throws Throwable {
        String incorrectValueMessage = "Your " + className + " constructor does not correctly initialize the " +
                attributeName1 + " field.";
        String incorrectValueMessage2 = "Your " + className + " constructor does not correctly initialize the " +
                attributeName2 + " field.";
        String incorrectVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        Object[][] arguments = {
                {sharp, boolean.class},
                {cut, boolean.class}
        };
        Class<?>[] classes = {boolean.class, boolean.class};
        Object testInstance = testClass.createInstance(arguments);
        _assertEquals(sharp, testClass.getFieldValue(testInstance, attributeName1), incorrectValueMessage);
        _assertEquals(cut, testClass.getFieldValue(testInstance, attributeName2), incorrectValueMessage2);
        assertTrue(testClass.hasModifier(classes, "public"), incorrectVisibilityModifier);
    }

    @ParameterizedTest
    @MethodSource("twoBooleanInputProvider")
    public void correctGetCanCutMethod(boolean sharp, boolean cut) throws Throwable {
        Object[][] arguments = {
                {sharp, boolean.class},
                {cut, boolean.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(cut, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the size field.");
    }


    @ParameterizedTest
    @MethodSource("threeBooleanInputProvider")
    public void correctSetCanCutMethod(boolean initialValue, boolean updatedValue, boolean c) throws Throwable {
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
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName2, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName2 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }
}
