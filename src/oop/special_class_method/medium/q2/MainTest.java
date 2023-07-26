package oop.special_class_method.medium.q2;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final String className = "Lamp";
    private final String attributeName1 = "brightness";
    private final String getAttributeMethodName1 = "getBrightness";
    private final String setAttributeMethodName1 = "setBrightness";
    private final String attributeName2 = "isOn";
    private final String getAttributeMethodName2 = "getIsOn";
    private final String setAttributeMethodName2 = "setIsOn";
    private final boolean isOnValue = true;

    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q2." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, double.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), modifiedClassMessage);
        assertTrue(testClass.hasField(attributeName2, boolean.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName2, "private"), modifiedClassMessage);
        double[] tests = new double[]{0.0, 23.3233, 553233333.55655334324, -111111.333342, 3554 / 3.7};
        for (int i = 0; i < tests.length; i++) {
            double value = tests[i];
            Object[][] arguments = {
                    {value, double.class}
            };
            Class<?>[] classes = {double.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(value, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
            _assertEquals(isOnValue, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);
        }
    }


    private static Stream<Double> doubleInputProvider() {
        return Stream.of(
                0.0, 23.3233, 553233333.55655334324, -111111.333342, 3554 / 3.7
        );
    }

    @ParameterizedTest
    @MethodSource("doubleInputProvider")
    public void correctGetBrightnessMethod(double value) throws Throwable {
        Object[][] arguments = {
                {value, double.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null, double.class, new String[]{"public"}),
                "Your " + className + " class does not include the correct " + getAttributeMethodName1 + " method.");
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
    }

    private static Stream<Arguments> twoDoubleInputProvider() {
        return Stream.of(
                Arguments.of(5.4, 6.4),
                Arguments.of(654.3, 54.2),
                Arguments.of(43.3, 43.2),
                Arguments.of(432.2, 899.8)
        );
    }

    @ParameterizedTest
    @MethodSource("twoDoubleInputProvider")
    public void correctSetBrightnessMethod(double initialValue, double updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {initialValue, double.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, double.class}
        };
        Class<?>[] methodModifierClasses = {
                double.class
        };
        assertTrue(testClass.hasMethod(setAttributeMethodName1, methodModifierClasses, Void.TYPE),
                "Your " + className + " class does not include the correct " + setAttributeMethodName1 + " method.");
        assertTrue(testClass.hasModifier(setAttributeMethodName1, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName1 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
    }

    private static Stream<Arguments> booleanDoublesInputProvider() {
        return Stream.of(
                Arguments.of(4.23232, false),
                Arguments.of(343434.44364, true),
                Arguments.of(5.67, true),
                Arguments.of(Math.PI, false)
        );
    }

    @ParameterizedTest
    @MethodSource("booleanDoublesInputProvider")
    public void correctLampConstructor(double value, boolean on) throws Throwable {
        String incorrectValueMessage = "Your " + className + " constructor does not correctly initialize the " +
                attributeName1 + " attribute.";
        String incorrectValueMessage2 = "Your " + className + " constructor does not correctly initialize the " +
                attributeName2 + " attribute.";
        String incorrectVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        Object[][] arguments = {
                {value, double.class},
                {on, boolean.class}
        };
        Class<?>[] classes = {double.class, boolean.class};
        Object testInstance = testClass.createInstance(arguments);
        _assertEquals(value, testClass.getFieldValue(testInstance, attributeName1), incorrectValueMessage);
        _assertEquals(on, testClass.getFieldValue(testInstance, attributeName2), incorrectValueMessage2);
        assertTrue(testClass.hasModifier(classes, "public"), incorrectVisibilityModifier);
    }

    @ParameterizedTest
    @MethodSource("booleanDoublesInputProvider")
    public void correctGetIsOnMethod(double value, boolean on) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {on, boolean.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null, boolean.class, new String[]{"public"}),
                "Your " + className + " class does not include the correct " + getAttributeMethodName2 + " method.");
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

    @ParameterizedTest
    @MethodSource("twoBooleanInputProvider")
    public void correctSetIsOnMethod(double value, boolean initialValue, boolean updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value, double.class},
                {initialValue, boolean.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, boolean.class}
        };
        Class<?>[] methodModifierClasses = {
                boolean.class
        };
        Object setMethodOutput = testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName2, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName2 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setAttributeMethodName2, "method should not return any output"));
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
        String expectedOutput = "My brightness is " + value1 + " and isOn is " + value2;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("booleanDoublesInputProvider")
    public void lampMethodsWorkCorrectlyWorkTogether(double firstValue, boolean secondValue) throws Throwable {
        Object[][] instantiationArguments = {
                {1.234, double.class},
                {false, boolean.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {firstValue, double.class}
        };
        Object[][] setMethodArguments2 = {
                {secondValue, boolean.class}
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        testClass.callMethod(setAttributeMethodName2, setMethodArguments2, testInstance);
        Object output1 = testClass.callMethod(getAttributeMethodName1, testInstance);
        Object output2 = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(firstValue, output1,
                "Your " + getAttributeMethodName1 + " does not return the correct value after using " + setAttributeMethodName1);
        _assertEquals(secondValue, output2,
                "Your " + getAttributeMethodName2 + " does not return the correct value after using " + setAttributeMethodName2);
        String expectedOutput = "My brightness is " + firstValue + " and isOn is " + secondValue;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput,
                "Your toString method does not return the correct value after using the accessor and mutators.");
    }

}
