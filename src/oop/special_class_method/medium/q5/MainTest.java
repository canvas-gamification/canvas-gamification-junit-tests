package oop.special_class_method.medium.q5;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String className = "Calculator";
    private final String attributeName1 = "sum";
    private final String getAttributeMethodName1 = "getSum";
    private final String setAttributeMethodName1 = "setSum";
    private final String attributeName2 = "isCorrect";
    private final String getAttributeMethodName2 = "getIsCorrect";
    private final String setAttributeMethodName2 = "setIsCorrect";

    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q5." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, double.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), modifiedClassMessage);
        assertTrue(testClass.hasField(attributeName2, boolean.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName2, "private"), modifiedClassMessage);
        Object[][] tests = new Object[][]{
                {4.23232, false},
                {343434.44364, true},
                {5.67, true},
                {Math.PI, false}
        };
        for (int i = 0; i < tests.length; i++) {
            double value = (double) tests[i][0];
            boolean on = (boolean) tests[i][1];
            Object[][] arguments = {
                    {value, double.class},
                    {on, boolean.class}
            };
            Class<?>[] classes = {double.class, boolean.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(value * 7, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
            _assertEquals(on, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);
        }
    }

    private static Stream<Arguments> booleanDoublesInputProvider() {
        return Stream.of(
                Arguments.of(4.23232, false),
                Arguments.of(343434.44364, true),
                Arguments.of(5.67, true),
                Arguments.of(Math.PI, false)
        );
    }

    @Test
    public void getSumIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, double.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
    }

    @ParameterizedTest
    @MethodSource("booleanDoublesInputProvider")
    public void correctGetSumMethod(double sum, boolean correct) throws Throwable {
        Object[][] arguments = {
                {sum, double.class},
                {correct, boolean.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, double.class), String.format(incorrectReturnType, getAttributeMethodName1, className));

        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(sum * 7, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
    }

    private static Stream<Arguments> twoDoubleInputProvider() {
        return Stream.of(
                Arguments.of(5.4, true, 6.4),
                Arguments.of(654.3, false, 54.2),
                Arguments.of(43.3, true, 43.2),
                Arguments.of(432.2, false, 899.8)
        );
    }

    @Test
    public void setSumIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName1, new Class<?>[]{double.class}), String.format(incorrectMethodDefinition, setAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName1, new Class<?>[]{double.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName1, new Class<?>[]{double.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName1, className));
    }

    @ParameterizedTest
    @MethodSource("twoDoubleInputProvider")
    public void correctSetSumMethod(double initialValue, boolean c, double updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {initialValue, double.class},
                {c, boolean.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, double.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName1, new Class<?>[]{double.class}), String.format(incorrectMethodDefinition, setAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName1, new Class<?>[]{double.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName1, new Class<?>[]{double.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName1, className));

        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
    }

    @Test
    public void getIsCorrectIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, boolean.class), String.format(incorrectReturnType, getAttributeMethodName2, className));
    }

    @ParameterizedTest
    @MethodSource("booleanDoublesInputProvider")
    public void correctGetIsCorrectMethod(double value, boolean on) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {on, boolean.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, boolean.class), String.format(incorrectReturnType, getAttributeMethodName2, className));

        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(on, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    private static Stream<Arguments> twoBooleanInputProvider() {
        return Stream.of(
                Arguments.of(1.2, true, false),
                Arguments.of(2.3, false, true)
        );
    }

    @Test
    public void setIsCorrectIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName2, new Class<?>[]{boolean.class}), String.format(incorrectMethodDefinition, setAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName2, new Class<?>[]{boolean.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName2, new Class<?>[]{boolean.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName2, className));
    }

    @ParameterizedTest
    @MethodSource("twoBooleanInputProvider")
    public void correctSetIsCorrectMethod(double value, boolean initialValue, boolean updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value, double.class},
                {initialValue, boolean.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, boolean.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName2, new Class<?>[]{boolean.class}), String.format(incorrectMethodDefinition, setAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName2, new Class<?>[]{boolean.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName2, new Class<?>[]{boolean.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName2, className));

        Object setMethodOutput = testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }

    @Test
    public void toStringIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
    }

    @ParameterizedTest
    @MethodSource("booleanDoublesInputProvider")
    public void correctToStringMethod(double value1, boolean value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, boolean.class}
        };
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance(arguments);
        String expectedOutput = "The sum is " + value1 * 7 + " and it is " + value2;
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }
    @ParameterizedTest
    @MethodSource("booleanDoublesInputProvider")
    public void methodsWorkingTogether(double value1, boolean value2) throws Throwable {
        Object[][] initialArguments = {
                {1.23, double.class},
                {true, boolean.class}
        };
        Object testInstance = testClass.createInstance(initialArguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals(1.23 * 7.0, getMethodOutput, 0.001,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
        getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(true, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
        Object[][] setMethodArguments = {
                {value1, double.class}
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        _assertEquals(value1, testClass.getFieldValue(testInstance, attributeName1),
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + " after using the " + getAttributeMethodName1 + " method.");
        setMethodArguments = new Object[][]{
                {value2, boolean.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        _assertEquals(value2, testClass.getFieldValue(testInstance, attributeName2),
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + " after using the " + getAttributeMethodName2 + " method.");
        String expectedOutput = "The sum is " + value1  + " and it is " + value2;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput,
                "Your toString method does not print the correct String after using the getter and setter methods.");
    }
}
