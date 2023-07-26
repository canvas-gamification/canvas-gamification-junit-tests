package oop.special_class_method.hard.q6;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    // Java
    private final String className = "Car";
    private final String doubleFieldName = "topSpeed";
    private final String stringFieldName = "type";
    private final String setStringMethodName = "setType";
    private final String getStringMethodName = "getType";
    private final String getDoubleMethodName = "getTopSpeed";
    private final String setDoubleMethodName = "setTopSpeed";
    private final String testClassName = "TestClass";
    private final double outputTopSpeed = 220;
    private final String outputType = "Ford";
    private ObjectTest testClass;
    private ObjectTest outputClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.hard.q6." + className;
        testClass = new ObjectTest(classString);
        String outputClassString = "oop.special_class_method.hard.q6." + testClassName;
        outputClass = new ObjectTest(outputClassString);
    }

    @Test
    public void correctTestClass() throws Throwable {
        Object classInstance = outputClass.createInstance();
        String[] methodModifiers = {"public"};
        Object[][] arguments = {
                {new String[0], String[].class}
        };
        outputClass.callMethod("main", arguments, methodModifiers, classInstance, new Clause[]{
                new StringLiteral("This " + className + " has a " + doubleFieldName + " of " + outputTopSpeed + " with the " + stringFieldName + " " + outputType + "."),
                new Optional(new StringLiteral(" ")),
                new Optional(new NewLine())
        });
    }

    @Test
    public void carClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(doubleFieldName),
                "The attribute " + doubleFieldName + " could not be found in your class. Please make sure you have added it, it is spelled correctly.");
        assertTrue(testClass.hasField(doubleFieldName, double.class),
                "Your " + doubleFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(doubleFieldName, "private"),
                "Your " + doubleFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(stringFieldName),
                "The attribute " + stringFieldName + " could not be found in your class. Please make sure you have added it, it is spelled correctly.");
        assertTrue(testClass.hasField(stringFieldName, String.class),
                "Your " + stringFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(stringFieldName, "private"),
                "Your " + stringFieldName + " does not have the correct visibility modifier.");
    }

    @Test
    public void carClassHasRequiredConstructor() {
        Class<?>[] classArguments = {double.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @Test
    public void carClassHasRequiredConstructor2() {
        Class<?>[] classArguments = {};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(4535.4, "Long"),
                Arguments.of(234.4, "Round"),
                Arguments.of(654.45, "Second"),
                Arguments.of(43.3, "Fourth")

        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void carClassHasCorrectConstructor(double value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, String.class}
        };
        Class<?>[] constructorClasses = {double.class, String.class};
        Object classInstance = testClass.createInstance(arguments);
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor with input does not initialize the " + doubleFieldName + " attribute to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor with input does not initialize the " + stringFieldName + " attribute to the correct value.";
        String incorrectConstructorVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        _assertEquals(value1, testClass.getFieldValue(classInstance, doubleFieldName),
                incorrectDoubleValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, stringFieldName),
                incorrectStringValueMessage);
        assertTrue(testClass.hasModifier(constructorClasses, "public"), incorrectConstructorVisibilityModifier);
    }

    @Test
    public void carClassHasCorrectConstructor2() throws Throwable {
        Object classInstance = testClass.createInstance();
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor without input does not initialize the " + doubleFieldName + " attribute to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor without input does not initialize the " + stringFieldName + " attribute to the correct value.";
        _assertEquals(180.0, testClass.getFieldValue(classInstance, doubleFieldName),
                incorrectDoubleValueMessage);
        assertEquals(null, testClass.getFieldValue(classInstance, stringFieldName),
                incorrectStringValueMessage);
    }

    private static Stream<Arguments> doubleInputProvider() {
        return Stream.of(
                Arguments.of(4535.4, 432.2),
                Arguments.of(234.4, 655.3),
                Arguments.of(654.45, 453.3),
                Arguments.of(43.3, 654.2)

        );
    }

    @ParameterizedTest
    @MethodSource("doubleInputProvider")
    public void carClassHasCorrectSetTopSpeedMethod(double initialValue, double setValue) throws Throwable {
        Object[][] arguments = {
                {initialValue, double.class},
                {"Initial String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {setValue, double.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setDoubleMethodName, "method does not correctly set the value of the", doubleFieldName, "attribute.");
        Object setMethodOutput = testClass.callMethod(setDoubleMethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, doubleFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setDoubleMethodName, "method should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void carClassHasCorrectGetTopSpeedMethod(double value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getDoubleMethodName, "method does not correctly get the value of the", doubleFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getDoubleMethodName, getMethodModifiers, classInstance);
        _assertEquals(value1, getMethodOutput, incorrectGetMethodMessage);
    }

    private static Stream<Arguments> twoStringInputProvider() {
        return Stream.of(
                Arguments.of("Short", "Tall"),
                Arguments.of("Window", "Cup"),
                Arguments.of("Blue", "Red"),
                Arguments.of("Horizontal", "Vertical")
        );
    }

    @ParameterizedTest
    @MethodSource("twoStringInputProvider")
    public void carClassHasCorrectSetTypeMethod(String initialValue, String updatedValue) throws Throwable {
        Object[][] arguments = {
                {Math.random() * 1000, double.class},
                {initialValue, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setStringMethodName, "method does not correctly set the value of the", stringFieldName, "attribute.");
        Object setMethodOutput = testClass.callMethod(setStringMethodName, setMethodArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue, testClass.getFieldValue(classInstance, stringFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setStringMethodName, "method should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void carClassHasCorrectGetTypeMethod(double value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getStringMethodName, "method does not correctly get the value of the", stringFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getStringMethodName, getMethodModifiers, classInstance);
        _assertEquals(value2, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void carClassHasCorrectToStringMethod(double value, String b) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {b, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "This " + className + " has a " + doubleFieldName + " of " + value + " with the " + stringFieldName + " " + b + ".";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void carClassMethodsWorkTogether(double value, String b) throws Throwable {
        double initialValue = Math.random() * 100;
        Object[][] arguments = {
                {initialValue, double.class},
                {"First String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(initialValue, testClass.callMethod(getDoubleMethodName, classInstance),
                "Your " + getDoubleMethodName + " method does not return the correct value.");
        _assertEquals("First String", testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value.");
        Object[][] setDoubleArguments = {
                {value, double.class}
        };
        testClass.callMethod(setDoubleMethodName, setDoubleArguments, classInstance);
        _assertEquals(value, testClass.callMethod(getDoubleMethodName, classInstance),
                "Your " + getDoubleMethodName + " method does not return the correct value after calling the " + setDoubleMethodName + " method.");
        Object[][] setArguments = {
                {b, String.class}
        };
        testClass.callMethod(setStringMethodName, setArguments, classInstance);
        _assertEquals(b, testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value after calling the " + setStringMethodName + " method.");
        String expectedToString = "This " + className + " has a " + doubleFieldName + " of " + value + " with the " + stringFieldName + " " + b + ".";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }
}
