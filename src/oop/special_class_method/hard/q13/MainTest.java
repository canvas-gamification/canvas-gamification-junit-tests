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
    public void cupClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(attributeName1),
                "Your " + className + " class is missing the " + attributeName1 + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName1, String.class),
                "Your " + attributeName1 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName1, "private"),
                "Your " + attributeName1 + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(attributeName2),
                "Your " + className + " class is missing the " + attributeName2 + " attribute, or it is spelled incorrectly..");
        assertTrue(testClass.hasField(attributeName2, double.class),
                "Your " + attributeName2 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName2, "private"),
                "Your " + attributeName2 + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(attributeName3),
                "Your " + className + " class is missing the " + attributeName3 + " attribute, or it is spelled incorrectly.");
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
    public void cupClassHasCorrectConstructor(String value1, double value2, String value3) throws Throwable {
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

    @Test
    public void getVolumeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, double.class), String.format(incorrectReturnType, getAttributeMethodName2, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetVolumeMethod(String value1, double value2, String value3) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class},
                {value3, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, double.class), String.format(incorrectReturnType, getAttributeMethodName2, className));
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(value2, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    @Test
    public void setLiquidIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName3, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName3, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName3, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName3, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName3, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName3, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctSetLiquidMethod(String value1, double value2, String initialiValue, String updatedValue) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class},
                {initialiValue, String.class}
        };
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName3, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName3, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName3, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName3, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName3, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName3, className));
        Object testInstance = testClass.createInstance(arguments);
        testClass.callMethod(setAttributeMethodName3, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName3 + " method does not correctly update the value of " + attributeName3 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName3),
                incorrectSetterMessage);
    }
}
