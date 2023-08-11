package oop.programs_with_interesting_classes.easy.q4;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static global.tools.CustomAssertions._assertEquals;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final String className = "Tree";
    private final String attributeName1 = "type";
    private final String attributeName2 = "size";
    private final String methodName = "gettingOlder";
    private final String getAttributeName1 = "getType";
    private final String setAttributeName1 = "setType";
    private final String getAttributeName2 = "getSize";
    private final String setAttributeName2 = "setSize";

    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.easy.q4." + className;
        testClass = new ObjectTest(packageString);
    }

    @Test
    public void treeHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(testClass.hasField(attributeName1), String.format(missingAttributeMessage, className, attributeName1));
        assertTrue(testClass.hasField(attributeName1, String.class), String.format(wrongTypeMessage, attributeName1, className));
        assertTrue(testClass.hasModifier(attributeName1, "private"), String.format(wrongModifierMessage, attributeName1, className));
        assertTrue(testClass.hasField(attributeName2), String.format(missingAttributeMessage, className, attributeName2));
        assertTrue(testClass.hasField(attributeName2, double.class), String.format(wrongTypeMessage, attributeName2, className));
        assertTrue(testClass.hasModifier(attributeName2, "private"), String.format(wrongModifierMessage, attributeName2, className));
    }

    @Test
    public void treeHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{String.class, double.class};
        assertTrue(testClass.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Oak", 21.54, "Apple", 54.3),
                Arguments.of("Apple", 1.43, "Pistachio", 324.4),
                Arguments.of("Orange", 0.5, "White", 32.3),
                Arguments.of("White", 35.43, "Brown", 75.4),
                Arguments.of("Brown", 36.23, "Coconut", 34.1),
                Arguments.of("Nut", 364.32, "Oak", 92.3),
                Arguments.of("Pistachio", 36.24, "Orange", 83.8),
                Arguments.of("Coconut", 232.432, "Nut", 3.2)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void treeConstructorInitializesValuesCorrectly(String value1, double value2) throws Throwable {
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, double.class}
        };
        Object checkupInstance = testClass.createInstance(constructorArgs);
        _assertEquals(value1, testClass.getFieldValue(checkupInstance, attributeName1), String.format(wrongValueMessage, className, attributeName1));
        _assertEquals(value2, testClass.getFieldValue(checkupInstance, attributeName2), String.format(wrongValueMessage, className, attributeName2));
    }

    @Test
    public void gettingOlderIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(testClass.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(testClass.hasReturnType(methodName, null, Void.TYPE), String.format(incorrectReturnType, methodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void treeClassHasCorrectGettingOlderMethod(String value1, double value2) throws Throwable {
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, double.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        String incorrectNumDays = "The %s method in the %s class does not correctly change the %s attribute.";
        testClass.callMethod(methodName, classInstance);
        _assertEquals(value2 + 4, testClass.getFieldValue(classInstance, attributeName2),
                String.format(incorrectNumDays, methodName, className, attributeName2));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void treeClassHasCorrectGetTypeMethod(String value1, double value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName1, "does not correctly get the value of the", attributeName1, "attribute.");
        Object getMethodOutput = testClass.callMethod(getAttributeName1, getMethodModifiers, classInstance);
        _assertEquals(value1, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void treeClassHasCorrectGetSizeMethod(String value1, double value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName2, "does not correctly get the value of the", attributeName2, "attribute.");
        Object getMethodOutput = testClass.callMethod(getAttributeName2, getMethodModifiers, classInstance);
        _assertEquals(value2, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void treeClassHasCorrectSetTypeMethod(String value1, double value2, String updatedValue1) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {updatedValue1, String.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setAttributeName1, "does not correctly set the value of the", attributeName1, "attribute.");
        Object setMethodOutput = testClass.callMethod(setAttributeName1, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue1, testClass.getFieldValue(classInstance, attributeName1), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setAttributeName1, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void treeClassHasCorrectSetSizeMethod(String value1, double value2, String updatedValue1, double updatedValue2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {updatedValue2, double.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setAttributeName2, "does not correctly set the value of the", attributeName2, "attribute.");
        Object setMethodOutput = testClass.callMethod(setAttributeName2, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue2, testClass.getFieldValue(classInstance, attributeName2), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setAttributeName2, "should not return any output"));
    }
}
