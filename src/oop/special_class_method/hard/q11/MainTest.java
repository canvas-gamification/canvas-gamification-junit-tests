package oop.special_class_method.hard.q11;

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
    // Java

    private final String className = "Alien";
    private final String attributeName1 = "numEyes";
    private final String getAttributeMethodName1 = "getNumEyes";
    private final String attributeName2 = "colour";
    private final String getAttributeMethodName2 = "getColour";
    private final String toString = "The %s Alien has %s eyes";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.hard.q11." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void alienClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(attributeName1),
                "Your " + className + " class is missing the " + attributeName1 + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName1, int.class),
                "Your " + attributeName1 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName1, "private"),
                "Your " + attributeName1 + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(attributeName2),
                "Your " + className + " class is missing the " + attributeName2 + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName2, String.class),
                "Your " + attributeName2 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName2, "private"),
                "Your " + attributeName2 + " does not have the correct visibility modifier.");
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(3, "Red"),
                Arguments.of(10, "Black"),
                Arguments.of(12, "Blue"),
                Arguments.of(43, "White"),
                Arguments.of(7, "Yellow")
        );
    }

    @Test
    public void alienClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct visibility modifiers.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void alienClassHasCorrectConstructor(int value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(value1, testClass.getFieldValue(classInstance, attributeName1),
                "Your " + className + " constructor does not initialize the " + attributeName1 + " attribute to the correct value.");
        _assertEquals(value2, testClass.getFieldValue(classInstance, attributeName2),
                "Your " + className + " constructor does not initialize the " + attributeName2 + " attribute to the correct value.");
    }

    @Test
    public void getNumEyesIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, int.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetNumEyesMethod(int value1, String value2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, int.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals(value1, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
    }

    @Test
    public void getColourIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, String.class), String.format(incorrectReturnType, getAttributeMethodName2, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetColourMethod(int value1, String value2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, String.class), String.format(incorrectReturnType, getAttributeMethodName2, className));
         Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(value2, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctToStringMethod(int value1, String value2) throws Throwable {
        String incorrectMethodDefinition = "The toString method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The toString method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The toString method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, className));
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object methodOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(String.format(toString, value2, value1), methodOutput,
                "Your " + className + " toString method does not return the correct String.");
    }
}
