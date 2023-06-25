package oop.special_class_method.medium.q3;

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
    private final String className = "Speaker";
    private final String attributeName = "volume";
    private final String getAttributeMethodName = "getVolume";
    private final String setAttributeMethodName = "setVolume";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q3." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName, double.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName, "private"), modifiedClassMessage);
        double[] tests = new double[]{0.0, 23.3233, 553233333.55655334324, -111111.333342, 3554 / 3.7};
        for (int i = 0; i < tests.length; i++) {
            double value = tests[i];
            Object[][] arguments = {
                    {value, double.class}
            };
            Class<?>[] classes = {double.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(value, testClass.getFieldValue(testInstance, attributeName), modifiedClassMessage);
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
    public void correctGetVolumeMethod(double value) throws Throwable {
        Object[][] arguments = {
                {value, double.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName, null, "public"),
                "Your " + getAttributeMethodName + " method does not have the correct visibility modifier.");
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName + " method does not return the value of the " + attributeName + " attribute.");
    }

    private static Stream<Arguments> twoDoublesInputProvider() {
        return Stream.of(
                Arguments.of(4.23232, 0.0),
                Arguments.of(343434.44364, -343434.44364),
                Arguments.of(5.67, 2 / 3),
                Arguments.of(Math.PI, Math.E)
        );
    }

    @ParameterizedTest
    @MethodSource("twoDoublesInputProvider")
    public void correctSetVolumeMethod(double initialValue, double updatedValue) throws Throwable {
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
        Object setMethodOutput = testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName + " method does not correctly update the value of " + attributeName + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName),
                incorrectSetterMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setAttributeMethodName, "method should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("twoDoublesInputProvider")
    public void correctGetSetMethods(double initialValue, double updatedValue) throws Throwable {
        String errorMessage = "Your " + className + " class " + getAttributeMethodName +
                " method does not return the updated value after calling the " + setAttributeMethodName + " method.";
        Object[][] instantiationArguments = {
                {initialValue, double.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, double.class}
        };
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        _assertEquals(updatedValue, getMethodOutput, errorMessage);
    }

    @ParameterizedTest
    @MethodSource("doubleInputProvider")
    public void correctToStringMethod(double value) throws Throwable {
        Object[][] arguments = {
                {value, double.class},

        };
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance(arguments);
        String expectedOutput = "My volume is " + value;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }
}
