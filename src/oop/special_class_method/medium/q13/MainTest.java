package oop.special_class_method.medium.q13;

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

    private final String className = "Detergent";
    private final String attributeName1 = "volume";
    private final String attributeName2 = "manufacturer";
    private final String getAttributeMethodName = "getManufacturer";
    private final String setAttributeMethodName = "setManufacturer";
    private final String specialMethodName = "upgradeSize";
    private final String expectedString = "%sml of %s Detergent";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q13." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided %s attribute in the " + className + " class. Please revert it to its original state.";
        assertTrue(testClass.hasField(attributeName1, double.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        assertTrue(testClass.hasField(attributeName2, String.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        Object[][] tests = new Object[][]{
                {5435.4, "myCompany"},
                {544.3, "Best Det"},
                {876.3, "clearer"},
                {75.3, "Get Clean"},
                {3.5, "Good Detergent"}
        };
        for (int i = 0; i < tests.length; i++) {
            double value1 = (double) tests[i][0];
            String value2 = (String) tests[i][1];
            Object[][] arguments = {
                    {value1, double.class},
                    {value2, String.class}
            };
            Object testInstance = testClass.createInstance(arguments);
            modifiedClassMessage = "You have modified the provided constructor in the " + className + " class for the %s attribute. Please revert it to its original state.";
            _assertEquals(value1, testClass.getFieldValue(testInstance, attributeName1),
                    String.format(modifiedClassMessage, attributeName1));
            _assertEquals(value2, testClass.getFieldValue(testInstance, attributeName2),
                    String.format(modifiedClassMessage, attributeName2));
        }
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(34.3, "myCompany", "Best Det"),
                Arguments.of(432.2, "Best Det", "Get Clean"),
                Arguments.of(5.5, "clearer", "Good Detergent"),
                Arguments.of(23.3, "Get Clean", "myCompany"),
                Arguments.of(78.7, "Good Detergent", "clearer")

        );
    }

    @Test
    public void getManufacturerIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName, null), String.format(incorrectMethodDefinition, getAttributeMethodName, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName, null, String.class), String.format(incorrectReturnType, getAttributeMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetManufacturerMethod(double value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName, null), String.format(incorrectMethodDefinition, getAttributeMethodName, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName, null, String.class), String.format(incorrectReturnType, getAttributeMethodName, className));
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        _assertEquals(value2, getMethodOutput,
                "Your " + getAttributeMethodName + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    @Test
    public void setManufacturerIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctSetManufacturerMethod(double value, String initialValue, String updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value, double.class},
                {initialValue, String.class}
        };
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName, className));
        Object testInstance = testClass.createInstance(instantiationArguments);
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctToStringMethod(double value1, String value2) throws Throwable {
        Object[][] instantiationArguments = {
                {value1, double.class},
                {value2, String.class}
        };
        String incorrectMethodDefinition = "The toString method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The toString method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The toString method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, className));
        Object testInstance = testClass.createInstance(instantiationArguments);
        String output = (String) testClass.callMethod("toString", testInstance);
        String incorrectToStringMethodMessage =
                "Your " + className + " toString method does not return the correct String.";
        _assertEquals(String.format(expectedString, value1, value2), output,
                incorrectToStringMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodsWorkingTogether(double value1, String initialValue, String updatedValue) throws Throwable {
        Object[][] initialArguments = {
                {value1, double.class},
                {initialValue, String.class}
        };
        Object testInstance = testClass.createInstance(initialArguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        _assertEquals(initialValue, getMethodOutput,
                "Your " + getAttributeMethodName + " method does not return the value of the " + attributeName2 + " attribute.");
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        _assertEquals(updatedValue, testClass.callMethod(getAttributeMethodName, testInstance),
                "Your " + getAttributeMethodName + " method does not correctly update the value of " + setAttributeMethodName + " after using the " + getAttributeMethodName + " method.");

        String output = (String) testClass.callMethod("toString", testInstance);
        _assertEquals(String.format(expectedString, value1, updatedValue), output,
                "Your " + className + " toString method does not return the correct String after calling the " + setAttributeMethodName + " method.");
    }
}
