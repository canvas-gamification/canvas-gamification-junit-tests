package oop.special_class_method.medium.q11;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
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
    private final int changeValue = 10;
    private final int changeLimit = 100;

    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q11." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + " class in the %s attribute part. Please revert them to the original state.";
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
            _assertEquals(temp, testClass.getFieldValue(testInstance, attributeName0), modifiedClassMessage);
            _assertEquals(size, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
            _assertEquals(colour, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);

            Object getMethodOutput = testClass.callMethod(getAttributeMethodName0, testInstance);
            assertTrue(testClass.hasModifier(getAttributeMethodName0, null, "public"), modifiedClassMessage);
            _assertEquals(temp, getMethodOutput, modifiedClassMessage);

            getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
            assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), modifiedClassMessage);
            _assertEquals(size, getMethodOutput, modifiedClassMessage);

            getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
            assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), modifiedClassMessage);
            _assertEquals(colour, getMethodOutput, modifiedClassMessage);

            Object[][] setMethodArguments = {
                    {updatedValue, double.class}
            };
            Class<?>[] methodModifierClasses = {
                    double.class
            };
            assertTrue(testClass.hasMethod(setAttributeMethodName0, methodModifierClasses, Void.TYPE), modifiedClassMessage);
            testClass.callMethod(setAttributeMethodName0, setMethodArguments, testInstance);
            assertTrue(testClass.hasModifier(setAttributeMethodName0, methodModifierClasses, "public"), modifiedClassMessage);

            _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName0), modifiedClassMessage);
        }
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(3.2, 3.4, "Red"),
                Arguments.of(432.3, 10.2, "Black"),
                Arguments.of(1023.4, 11.0, "Blue"),
                Arguments.of(434.3, 43.4, "White"),
                Arguments.of(43.34, 7, "Yellow"),
                Arguments.of(100, 7, "Yellow")
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
        String expectedOutput = "The " + value3 + " Oven with size of " + value2 + " has the tempeture of " + value1;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
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
        assertTrue(testClass.hasMethod(methodName1, null),
                "Your " + className + " class does not include a " + methodName1 + " method.");
        assertTrue(testClass.hasMethod(methodName1, null, Void.TYPE),
                "Your " + methodName1 + " method should not return anything.");
        assertTrue(testClass.hasMethod(methodName1, null, Void.TYPE, new String[]{"public"}),
                "Your " + methodName1 + " method does not have the correct visibility modifier.");
        testClass.callMethod(methodName1, testInstance);
        _assertEquals(value1 - changeValue, testClass.getFieldValue(testInstance, attributeName0),
                "Your " + methodName1 + " method does not decrease the value of " + attributeName0 + " correctly.");
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
        assertTrue(testClass.hasMethod(methodName2, null),
                "Your " + className + " class does not include a " + methodName2 + " method.");
        assertTrue(testClass.hasMethod(methodName2, null, Void.TYPE),
                "Your " + methodName2 + " method should not return anything.");
        assertTrue(testClass.hasMethod(methodName2, null, Void.TYPE, new String[]{"public"}),
                "Your " + methodName2 + " method does not have the correct visibility modifier.");
        testClass.callMethod(methodName2, testInstance);
        _assertEquals(value1 + changeValue, testClass.getFieldValue(testInstance, attributeName0),
                "Your " + methodName2 + " method does not increase the value of " + attributeName0 + " correctly.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctChangePowerMethod(double value1, double value2, String value3) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, double.class},
                {value3, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        assertTrue(testClass.hasMethod(methodName3, null),
                "Your " + className + " class does not include a " + methodName3 + " method.");
        assertTrue(testClass.hasMethod(methodName3, null, Void.TYPE),
                "Your " + methodName3 + " method should not return anything.");
        assertTrue(testClass.hasMethod(methodName3, null, Void.TYPE, new String[]{"public"}),
                "Your " + methodName3 + " method does not have the correct visibility modifier.");
        testClass.callMethod(methodName3, testInstance);
        if (value1 > changeLimit) {
            _assertEquals(value1 - changeValue, testClass.getFieldValue(testInstance, attributeName0),
                    "Your " + methodName3 + " method does not change the value of " + attributeName0 + " correctly.");
        } else {
            _assertEquals(value1 + changeValue, testClass.getFieldValue(testInstance, attributeName0),
                    "Your " + methodName3 + " method does not change the value of " + attributeName0 + " correctly.");
        }
    }
}
