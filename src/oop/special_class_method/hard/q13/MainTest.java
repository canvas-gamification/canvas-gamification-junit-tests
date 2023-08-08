package oop.special_class_method.hard.q13;

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

    private final String className = "Cup";
    private final String attributeName1 = "colour";
    private final String attributeName2 = "volume";
    private final String attributeName3 = "liquid";
    private final String getAttributeMethodName2 = "getVolume";
    private final String setAttributeMethodName3 = "setLiquid";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.hard.q13." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void alienClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(attributeName1),
                "Your " + className + " class is missing the " + attributeName1 + " attributes, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName1, String.class),
                "Your " + attributeName1 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName1, "private"),
                "Your " + attributeName1 + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(attributeName2),
                "Your " + className + " class is missing the " + attributeName2 + " attributes, or it is spelled incorrectly..");
        assertTrue(testClass.hasField(attributeName2, double.class),
                "Your " + attributeName2 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName2, "private"),
                "Your " + attributeName2 + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(attributeName3),
                "Your " + className + " class is missing the " + attributeName3 + " attributes, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName3, String.class),
                "Your " + attributeName3 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName3, "private"),
                "Your " + attributeName3 + " does not have the correct visibility modifier.");
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Red", 3423.4, "Milk", "Water"),
                Arguments.of("Black", 54.5, "Water", "Lava"),
                Arguments.of("Blue", 934.3, "Mercury", "Juice"),
                Arguments.of("White", 49374.43, "Blood", "Water"),
                Arguments.of("Yellow", 434.43, "Lava", "Whiskey")
        );
    }


    @Test
    public void cupClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, double.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct visibility modifiers.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void alienClassHasCorrectConstructor(String value1, double value2, String value3) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class},
                {value3, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(value1, testClass.getFieldValue(classInstance, attributeName1),
                "Your " + className + " constructor does not initialize the " + attributeName1 + " attribute to the correct value.");
        _assertEquals(value2, testClass.getFieldValue(classInstance, attributeName2),
                "Your " + className + " constructor does not initialize the " + attributeName2 + " attribute to the correct value.");
        _assertEquals(value3, testClass.getFieldValue(classInstance, attributeName3),
                "Your " + className + " constructor does not initialize the " + attributeName3 + " attribute to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetVolumeMethod(String value1, double value2, String value3) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class},
                {value3, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(value2, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctSetLiquidMethod(String value1, double value2, String initialiValue, String updatedValue) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class},
                {initialiValue, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        Class<?>[] methodModifierClasses = {
                String.class
        };
        assertTrue(testClass.hasMethod(setAttributeMethodName3, methodModifierClasses, Void.TYPE),
                "Your " + setAttributeMethodName3 + " method does not have the correct name, return type, or parameters.");
        testClass.callMethod(setAttributeMethodName3, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName3, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName3 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName3 + " method does not correctly update the value of " + attributeName3 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName3),
                incorrectSetterMessage);
    }
}
