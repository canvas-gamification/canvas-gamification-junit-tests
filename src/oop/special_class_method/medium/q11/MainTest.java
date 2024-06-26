package oop.special_class_method.medium.q11;

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

    private final String className = "Oven";
    private final String attributeName0 = "currTemp";
    private final String getAttributeMethodName0 = "getCurrTemp";
    private final String setAttributeMethodName0 = "setCurrTemp";
    private final String attributeName1 = "size";
    private final String getAttributeMethodName1 = "getSize";
    private final String attributeName2 = "colour";
    private final String getAttributeMethodName2 = "getColour";
    private final String methodName1 = "powerDecrease";
    private final String methodName2 = "powerIncrease";
    private final String methodName3 = "changePower";
    private final String toString = "The %s Oven with size of %s has the temperature of %s";
    private final static int changeValue = 10;
    private final static int changeLimit = 100;

    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q11." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided %s attribute from the " + className + " class. Please revert it to its original state.";
        assertTrue(testClass.hasField(attributeName0, double.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName0));
        assertTrue(testClass.hasField(attributeName1, double.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        assertTrue(testClass.hasField(attributeName2, String.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName2));
        Object[][] tests = new Object[][]{
                {3.2, 3.4, "Red", 43243.3},
                {432.3, 10.2, "Black", 432.2},
                {1023.4, 11.0, "Blue", 565.4},
                {434.3, 43.4, "White", 543.3},
                {43.34, 7.2, "Yellow", 5555.4}
        };
       for (int i = 0; i < tests.length; i++) {
            double temp = (double) tests[i][0];
            double size = (double) tests[i][1];
            String colour = (String) tests[i][2];
            double updatedValue = (double) tests[i][3];
            Object[][] arguments = {
                    {temp, double.class},
                    {size, double.class},
                    {colour, String.class}
            };
            Class<?>[] classes = {double.class, double.class, String.class};
            Object testInstance = testClass.createInstance(arguments);
            modifiedClassMessage = "You have modified the provided constructor for the " + className + " class. Please revert the initialization of the %s attribute to its original state.";
            _assertEquals(temp, testClass.getFieldValue(testInstance, attributeName0), modifiedClassMessage);
            _assertEquals(size, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
            _assertEquals(colour, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);

            assertTrue(testClass.hasModifier(getAttributeMethodName0, null, "public"),
                   String.format(modifiedClassMessage, getAttributeMethodName0));
            Object getMethodOutput = testClass.callMethod(getAttributeMethodName0, testInstance);
            modifiedClassMessage = "You have modified the provided portions of the %s method. Please revert it to its original state.";
            _assertEquals(temp, getMethodOutput,
                    String.format(modifiedClassMessage, getAttributeMethodName0));

            assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                   String.format(modifiedClassMessage, getAttributeMethodName1));
            getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
            _assertEquals(size, getMethodOutput,
                    String.format(modifiedClassMessage, getAttributeMethodName1));

            assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                   String.format(modifiedClassMessage, getAttributeMethodName2));
            getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
            _assertEquals(colour, getMethodOutput,
                    String.format(modifiedClassMessage, getAttributeMethodName2));

            Object[][] setMethodArguments = {
                    {updatedValue, double.class}
            };
            Class<?>[] methodModifierClasses = {
                    double.class
            };
            assertTrue(testClass.hasMethod(setAttributeMethodName0, methodModifierClasses, Void.TYPE),
                    String.format(modifiedClassMessage, setAttributeMethodName0));
            testClass.callMethod(setAttributeMethodName0, setMethodArguments, testInstance);
            assertTrue(testClass.hasModifier(setAttributeMethodName0, methodModifierClasses, "public"),
                    String.format(modifiedClassMessage, setAttributeMethodName0));

            _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName0),
                    String.format(modifiedClassMessage, setAttributeMethodName0));
        }
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(3.2, 3.4, "Red"),
                Arguments.of(432.3, 10.2, "Black"),
                Arguments.of(1023.4, 11.0, "Blue"),
                Arguments.of(changeLimit, 3.4, "Red"),
                Arguments.of(changeLimit - 0.01, 10.2, "Black"),
                Arguments.of(changeLimit + 0.01, 11.0, "Blue"),
                Arguments.of(434.3, 43.4, "White"),
                Arguments.of(43.34, 7, "Yellow"),
                Arguments.of(100, 7, "Yellow"),
                Arguments.of(-changeValue, 5.5, "Red"),
                Arguments.of(-changeLimit, 9.3, "Purple")
        );
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctToStringMethod(double value1, double value2, String value3) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, double.class},
                {value3, String.class}
        };
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        String expectedOutput = String.format(toString, value3, value2, value1);
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }

    @Test
    public void powerDecreaseIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName1, null), String.format(incorrectMethodDefinition, methodName1, className));
        assertTrue(testClass.hasModifier(methodName1, null, "public"), String.format(incorrectModifierMessage, methodName1, className));
        assertTrue(testClass.hasReturnType(methodName1, null, Void.TYPE), String.format(incorrectReturnType, methodName1, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctPowerDecreaseMethod(double value1, double value2, String value3) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, double.class},
                {value3, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName1, null), String.format(incorrectMethodDefinition, methodName1, className));
        assertTrue(testClass.hasModifier(methodName1, null, "public"), String.format(incorrectModifierMessage, methodName1, className));
        assertTrue(testClass.hasReturnType(methodName1, null, Void.TYPE), String.format(incorrectReturnType, methodName1, className));

        testClass.callMethod(methodName1, testInstance);
        _assertEquals(value1 - changeValue, testClass.getFieldValue(testInstance, attributeName0),
                "Your " + methodName1 + " method does not correctly decrease the value of the " + attributeName0 + " attribute.");
    }

    @Test
    public void powerIncreaseIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName2, null), String.format(incorrectMethodDefinition, methodName2, className));
        assertTrue(testClass.hasModifier(methodName2, null, "public"), String.format(incorrectModifierMessage, methodName2, className));
        assertTrue(testClass.hasReturnType(methodName2, null, Void.TYPE), String.format(incorrectReturnType, methodName2, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctPowerIncreaseMethod(double value1, double value2, String value3) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, double.class},
                {value3, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName2, null), String.format(incorrectMethodDefinition, methodName2, className));
        assertTrue(testClass.hasModifier(methodName2, null, "public"), String.format(incorrectModifierMessage, methodName2, className));
        assertTrue(testClass.hasReturnType(methodName2, null, Void.TYPE), String.format(incorrectReturnType, methodName2, className));
        testClass.callMethod(methodName2, testInstance);
        _assertEquals(value1 + changeValue, testClass.getFieldValue(testInstance, attributeName0),
                "Your " + methodName2 + " method does not correctly increase the value of " + attributeName0 + " attribute.");
    }

    @Test
    public void changePowerIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName3, null), String.format(incorrectMethodDefinition, methodName3, className));
        assertTrue(testClass.hasModifier(methodName3, null, "public"), String.format(incorrectModifierMessage, methodName3, className));
        assertTrue(testClass.hasReturnType(methodName3, null, Void.TYPE), String.format(incorrectReturnType, methodName3, className));
    }

    private static Stream<Arguments> changePowerInputProvider() {
        return Stream.of(
                Arguments.of(changeLimit - 0.01, 10.2, "Black"),
                Arguments.of(changeLimit + 0.01, 11.0, "Blue"),
                Arguments.of(434.3, 43.4, "White"),
                Arguments.of(43.34, 7, "Yellow"),
                Arguments.of(100, 7, "Yellow"),
                Arguments.of(changeLimit - changeValue, 5.5, "red"),
                Arguments.of(0, 5.5, "red"),
                Arguments.of(changeLimit * 2, 5.5, "red"),
                Arguments.of(-changeValue, 5.5, "Red"),
                Arguments.of(-changeLimit, 9.3, "Purple")
        );
    }

    @ParameterizedTest
    @MethodSource("changePowerInputProvider")
    public void correctChangePowerMethod(double value1, double value2, String value3) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, double.class},
                {value3, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName3, null), String.format(incorrectMethodDefinition, methodName3, className));
        assertTrue(testClass.hasModifier(methodName3, null, "public"), String.format(incorrectModifierMessage, methodName3, className));
        assertTrue(testClass.hasReturnType(methodName3, null, Void.TYPE), String.format(incorrectReturnType, methodName3, className));

        for(int x = 0; x < 4; x++) {
            testClass.callMethod(methodName3, testInstance);
            if (value1 > changeLimit) {
                value1 -= changeValue;
                _assertEquals(value1, testClass.getFieldValue(testInstance, attributeName0),
                        "Your " + methodName3 + " method does not correctly decrease the value of " + attributeName0 + " attribute.");
            } else {
                value1 += changeValue;
                _assertEquals(value1, testClass.getFieldValue(testInstance, attributeName0),
                        "Your " + methodName3 + " method does not correctly increase the value of " + attributeName0 + " attribute.");
            }
        }
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodsWorkTogether(double value1, double value2, String value3) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, double.class},
                {value3, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        testClass.callMethod(methodName1, testInstance);
        _assertEquals(value1 - changeValue, testClass.getFieldValue(testInstance, attributeName0),
                "Your " + methodName1 + " method does not decrease the value of " + attributeName0 + " correctly.");
        value1 -= changeValue;
        testClass.callMethod(methodName2, testInstance);
        _assertEquals(value1 + changeValue, testClass.getFieldValue(testInstance, attributeName0),
                "Your " + methodName2 + " method does not increase the value of " + attributeName0 + " correctly after calling the " + methodName1 + " method");
        value1 += changeValue;
        testClass.callMethod(methodName3, testInstance);
        if (value1 > changeLimit) {
            value1 -= changeValue;
            _assertEquals(value1, testClass.getFieldValue(testInstance, attributeName0),
                    "Your " + methodName3 + " method does not correctly decrease the value of the " + attributeName0 + " attribute after calling the " + methodName1 + " and " + methodName2 + " method.");
        } else {
            value1 += changeValue;
            _assertEquals(value1, testClass.getFieldValue(testInstance, attributeName0),
                    "Your " + methodName3 + " method does not correctly increase the value of the " + attributeName0 + " attribute after calling the " + methodName1 + " and " + methodName2 + " method.");
        }
        String incorrectToStringMessage = "Your toString method does not return the correct String after calling the  " + methodName1 + ",  " + methodName2 + " and " + methodName3 + " method.";
        String expectedOutput = String.format(toString, value3, value2, value1);
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }
}
