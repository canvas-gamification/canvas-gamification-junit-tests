package oop.special_class_method.medium.q10;

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

    private final String className = "Shoe";
    private final String attributeName1 = "size";
    private final String getAttributeMethodName1 = "getSize";
    private final String setAttributeMethodName1 = "setSize";
    private final String attributeName2 = "colour";
    private final String getAttributeMethodName2 = "getColour";
    private final String setAttributeMethodName2 = "setColour";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q10." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided %s attribute. Please revert it to the original state.";
        assertTrue(testClass.hasField(attributeName1, int.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        assertTrue(testClass.hasField(attributeName2, String.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName2));
        Object[][] tests = new Object[][]{
                {3, "Red"},
                {10, "Black"},
                {12, "Blue"},
                {43, "White"},
                {7, "Yellow"}
        };
        modifiedClassMessage =
                "You have modified the provided %s constructor. Please revert it to the original state.";
        for (int i = 0; i < tests.length; i++) {
            int size = (int) tests[i][0];
            String colour = (String) tests[i][1];
            Object[][] arguments = {
                    {size, int.class},
                    {colour, String.class}
            };
            Class<?>[] classes = {int.class, String.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(size, testClass.getFieldValue(testInstance, attributeName1),
                    String.format(modifiedClassMessage, className));
            _assertEquals(colour, testClass.getFieldValue(testInstance, attributeName2),
                    String.format(modifiedClassMessage, className));
            assertTrue(testClass.hasModifier(classes, "public"),
                    String.format(modifiedClassMessage, className));
        }
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

    private static Stream<Arguments> updateIntegerInputProvider() {
        return Stream.of(
                Arguments.of(3, "Red", 5),
                Arguments.of(10, "Black", 12),
                Arguments.of(12, "Blue", 10),
                Arguments.of(43, "White", 37),
                Arguments.of(7, "Yellow", 4)

        );
    }

    private static Stream<Arguments> updateStringInputProvider() {
        return Stream.of(
                Arguments.of(3, "Red", "White"),
                Arguments.of(10, "Black", "Green"),
                Arguments.of(12, "Blue", "Red"),
                Arguments.of(43, "White", "Gray"),
                Arguments.of(7, "Yellow", "Orange")

        );
    }

    @Test
    public void getSizeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, int.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetSizeMethod(int value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, int.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
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
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, String.class), String.format(incorrectReturnType, getAttributeMethodName2, className));
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(value2, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the correct value of the " + attributeName2 + " attribute.");
    }

    @Test
    public void setSizeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName1, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName1, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName1, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName1, className));
    }

    @ParameterizedTest
    @MethodSource("updateIntegerInputProvider")
    public void correctSetSizeMethod(int initialiValue, String value2, int updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {initialiValue, int.class},
                {value2, String.class}
        };
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName1, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName1, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName1, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName1, className));
        Object testInstance = testClass.createInstance(instantiationArguments);
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
    }

    @Test
    public void setColourIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName2, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName2, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName2, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName2, className));
    }

    @ParameterizedTest
    @MethodSource("updateStringInputProvider")
    public void correctSetColourMethod(int value1, String initialValue, String updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value1, int.class},
                {initialValue, String.class}
        };
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName2, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName2, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName2, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName2, className));
        Object testInstance = testClass.createInstance(instantiationArguments);
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctToStringMethod(int value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        String expectedOutput = "The size of this shoe is " + value1 + " and its colour is " + value2;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodsWorkingTogether(int value1, String value2) throws Throwable {
        Object[][] initialArguments = {
                {123, int.class},
                {"Initial String", String.class}
        };
        Object testInstance = testClass.createInstance(initialArguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals(123, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
        getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals("Initial String", getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
        Object[][] setMethodArguments = {
                {value1, int.class}
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        _assertEquals(value1, testClass.callMethod(getAttributeMethodName1, testInstance),
                "Your " + getAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + " after using the " + setAttributeMethodName1 + " method.");
        setMethodArguments = new Object[][]{
                {value2, String.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        _assertEquals(value2, testClass.callMethod(getAttributeMethodName2, testInstance),
                "Your " + getAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + " after using the " + setAttributeMethodName2 + " method.");
        String expectedOutput = "The size of this shoe is " + value1 + " and its colour is " + value2;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput,
                "Your toString method does not print the correct String after using the getter and setter methods.");
    }
}
