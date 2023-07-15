package oop.special_class_method.hard.q7;

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
    private final String className = "PiggyBank";
    private final String doubleFieldName = "money";
    private final String intFieldName = "time";
    private final String setIntMethodName = "setTime";
    private final String getIntMethodName = "getTime";
    private final String getDoubleMethodName = "getMoney";
    private final String setDoubleMethodName = "setMoney";
    private final String testClassName = "TestClass";
    private final double outputMoney = 125.5;
    private final int outputTime = 30;
    private ObjectTest testClass;
    private ObjectTest outputClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.hard.q7." + className;
        testClass = new ObjectTest(classString);
        String outputClassString = "oop.special_class_method.hard.q7." + testClassName;
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
                new StringLiteral("I have " + outputMoney + " dollars in me after " + outputTime + " days."),
                new Optional(new StringLiteral(" ")),
                new Optional(new NewLine())
        });
    }

    @Test
    public void piggyBankClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(doubleFieldName, double.class),
                "Your " + className + " class is missing the " + doubleFieldName + " attributes.");
        assertTrue(testClass.hasModifier(doubleFieldName, "private"),
                "Your " + doubleFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(intFieldName, int.class),
                "Your " + className + " class is missing the " + intFieldName + " attributes.");
        assertTrue(testClass.hasModifier(intFieldName, "private"),
                "Your " + intFieldName + " does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(4535.4, 300),
                Arguments.of(234.4, 100),
                Arguments.of(654.45, 365),
                Arguments.of(43.3, 14)

        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void piggyBankClassHasCorrectConstructor(double value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, int.class}
        };
        Class<?>[] constructorClasses = {double.class, int.class};
        Object classInstance = testClass.createInstance(arguments);
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor does not initialize the " + doubleFieldName + " attribute to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor does not initialize the " + intFieldName + " attribute to the correct value.";
        String incorrectConstructorVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        _assertEquals(value1, testClass.getFieldValue(classInstance, doubleFieldName),
                incorrectDoubleValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, intFieldName),
                incorrectStringValueMessage);
        assertTrue(testClass.hasModifier(constructorClasses, "public"), incorrectConstructorVisibilityModifier);
    }

    @Test
    public void piggyBankClassHasCorrectConstructor2() throws Throwable {
        Class<?>[] constructorClasses = {double.class, int.class};
        Object classInstance = testClass.createInstance();
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor does not initialize the " + doubleFieldName + " attribute to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor does not initialize the " + intFieldName + " attribute to the correct value.";
        String incorrectConstructorVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        _assertEquals(0.0, testClass.getFieldValue(classInstance, doubleFieldName),
                incorrectDoubleValueMessage);
        assertEquals(0, testClass.getFieldValue(classInstance, intFieldName),
                incorrectStringValueMessage);
        assertTrue(testClass.hasModifier(constructorClasses, "public"), incorrectConstructorVisibilityModifier);
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
    public void piggyBankClassHasCorrectSetMoneyMethod(double initialValue, double setValue) throws Throwable {
        Object[][] arguments = {
                {initialValue, double.class},
                {0, int.class}
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
    public void piggyBankClassHasCorrectGetMoneyMethod(double value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getDoubleMethodName, "method does not correctly get the value of the", doubleFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getDoubleMethodName, getMethodModifiers, classInstance);
        _assertEquals(value1, getMethodOutput, incorrectGetMethodMessage);
    }

    private static Stream<Arguments> twoIntInputProvider() {
        return Stream.of(
                Arguments.of(10, 15),
                Arguments.of(30, 10),
                Arguments.of(100, 120),
                Arguments.of(1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("twoIntInputProvider")
    public void piggyBankClassHasCorrectSetTimeMethod(int initialValue, int updatedValue) throws Throwable {
        Object[][] arguments = {
                {Math.random() * 1000, double.class},
                {initialValue, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, initialValue, intFieldName);
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setIntMethodName, "method does not correctly set the value of the", intFieldName, "attribute.");
        Object setMethodOutput = testClass.callMethod(setIntMethodName, setMethodArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue, testClass.getFieldValue(classInstance, intFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setIntMethodName, "method should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void piggyBankClassHasCorrectGetTimeMethod(double value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, value2, intFieldName);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getIntMethodName, "method does not correctly get the value of the", intFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getIntMethodName, getMethodModifiers, classInstance);
        _assertEquals(value2, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void piggyBankClassHasCorrectToStringMethod(double value, int b) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {b, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "I have " + value + " dollars in me after " + b + " days.";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void piggyBankClassMethodsWorkTogether(double value, int b) throws Throwable {
        double initialValue = Math.random() * 100;
        Object[][] arguments = {
                {initialValue, double.class},
                {0, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(initialValue, testClass.callMethod(getDoubleMethodName, classInstance),
                "Your " + getDoubleMethodName + " method does not return the correct value.");
        _assertEquals(0, testClass.callMethod(getIntMethodName, classInstance),
                "Your " + getIntMethodName + " method does not return the correct value.");
        Object[][] setDoubleArguments = {
                {value, double.class}
        };
        testClass.callMethod(setDoubleMethodName, setDoubleArguments, classInstance);
        _assertEquals(value, testClass.callMethod(getDoubleMethodName, classInstance),
                "Your " + getDoubleMethodName + " method does not return the correct value calling the " + setDoubleMethodName + " method.");
        Object[][] setBooleanArguments = {
                {b, int.class}
        };
        testClass.callMethod(setIntMethodName, setBooleanArguments, classInstance);
        _assertEquals(b, testClass.callMethod(getIntMethodName, classInstance),
                "Your " + getIntMethodName + " method does not return the correct value calling the " + setIntMethodName + " method.");
        String expectedToString = "I have " + value + " dollars in me after " + b + " days.";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }
}
