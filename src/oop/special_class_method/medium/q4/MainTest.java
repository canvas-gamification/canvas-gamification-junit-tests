package oop.special_class_method.medium.q4;

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
    private final String className = "Plant";
    private final String attributeName = "breed";
    private final String getAttributeMethodName = "getBreed";
    private final String setAttributeMethodName = "setBreed";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.medium.q4." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void circleClassHasCorrectField() {
        String missingFieldMessage = "Your " + className + " class is missing the " + attributeName + " field.";
        String incorrectVisibilityModifierMessage =
                "Your " + attributeName + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName, String.class), missingFieldMessage);
        assertTrue(testClass.hasModifier(attributeName, "private"), incorrectVisibilityModifierMessage);
    }

    private static Stream<String> stringInputProvider() {
        return Stream.of(
                "Normal", "Exotic", "Green", "Flower", "Cactus"
        );
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void correctCircleConstructor(String value) throws Throwable {
        String incorrectValueMessage = "Your " + className + " constructor does not correctly initialize the " +
                attributeName + " field.";
        String incorrectVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        Object[][] arguments = {
                {value, String.class}
        };
        Class<?>[] classes = {String.class};
        Object testInstance = testClass.createInstance(arguments);
        _assertEquals(value, testClass.getFieldValue(testInstance, attributeName), incorrectValueMessage);
        assertTrue(testClass.hasModifier(classes, "public"), incorrectVisibilityModifier);
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void correctGetSizeMethod(String value) throws Throwable {
        Object[][] arguments = {
                {value, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName, null, "public"),
                "Your " + getAttributeMethodName + " method does not have the correct visibility modifier.");
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName + " method does not return the value of the size field.");
    }

    private static Stream<Arguments> twoStringsInputProvider() {
        return Stream.of(
                Arguments.of("Cactus", "Flower"),
                Arguments.of("Green", "Normal"),
                Arguments.of("Exotic", "Tree")
        );
    }

    @ParameterizedTest
    @MethodSource("twoStringsInputProvider")
    public void correctSetSizeMethod(String initialValue, String updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {initialValue, String.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        Class<?>[] methodModifierClasses = {
                String.class
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
    @MethodSource("twoStringsInputProvider")
    public void correctGetSetMethods(String initialValue, String updatedValue) throws Throwable {
        String errorMessage = "Your " + className + " class " + getAttributeMethodName +
                " method does not return the updated value after calling the " + setAttributeMethodName + " method.";
        Object[][] instantiationArguments = {
                {initialValue, String.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        _assertEquals(updatedValue, getMethodOutput, errorMessage);
    }
}
