package oop.special_class_method.hard.q4;

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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String className = "Detergent";
    private final String string2FieldName = "name";
    private final String stringFieldName = "strength";
    private final String setStringMethodName = "setStrength";
    private final String getStringMethodName = "getStrength";
    private final String getString2MethodName = "getName";
    private final String setString2MethodName = "setName";
    private final String testClassName = "TestClass";
    private final String outputName = "Bleach";
    private final String outputStrength = "High";
    private ObjectTest testClass;
    private ObjectTest outputClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.hard.q4." + className;
        testClass = new ObjectTest(classString);
        String outputClassString = "oop.special_class_method.hard.q4." + testClassName;
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
                new StringLiteral("The " + className + " instance " + string2FieldName + " is " + outputName + " and its " + stringFieldName + " is " + outputStrength + "."),
                new Optional(new StringLiteral(" ")),
                new Optional(new NewLine())
        });
    }

    @Test
    public void detergentClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @Test
    public void detergentClassHasCorrectFields() {
        assertTrue(testClass.hasField(string2FieldName, String.class),
                "The attribute " +  string2FieldName + " could not be found in your class. Please make sure you have added it, it is spelled correctly, and has the correct type");
        assertTrue(testClass.hasModifier(string2FieldName, "private"),
                "Your " + string2FieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(stringFieldName, String.class),
                "The attribute " +  stringFieldName + " could not be found in your class. Please make sure you have added it, it is spelled correctly, and has the correct type");
        assertTrue(testClass.hasModifier(stringFieldName, "private"),
                "Your " + stringFieldName + " does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Test String", "Long"),
                Arguments.of("MyString", "Round"),
                Arguments.of("First", "Second"),
                Arguments.of("Third", "Fourth")

        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void detergentClassHasCorrectConstructor(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Class<?>[] constructorClasses = {String.class, String.class};
        Object classInstance = testClass.createInstance(arguments);
        String incorrectString1ValueMessage =
                "Your " + className + " constructor does not initialize the " + string2FieldName + " attribute to the correct value.";
        String incorrectString2ValueMessage =
                "Your " + className + " constructor does not initialize the " + stringFieldName + " attribute to the correct value.";
        String incorrectConstructorVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        _assertEquals(value1, testClass.getFieldValue(classInstance, string2FieldName),
                incorrectString1ValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, stringFieldName),
                incorrectString2ValueMessage);
        assertTrue(testClass.hasModifier(constructorClasses, "public"), incorrectConstructorVisibilityModifier);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void detergentClassHasCorrectSetNameMethod(String initialValue, String setValue) throws Throwable {
        Object[][] arguments = {
                {initialValue, String.class},
                {"Initial String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {setValue, String.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setString2MethodName, "method does not correctly set the value of the", string2FieldName, "attribute.");
        Object setMethodOutput = testClass.callMethod(setString2MethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, string2FieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setString2MethodName, "method should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void detergentClassHasCorrectGetNameMethod(String value) throws Throwable {
        Object[][] arguments = {
                {value, String.class},
                {"Initial String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getString2MethodName, "method does not correctly get the value of the", string2FieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getString2MethodName, getMethodModifiers, classInstance);
        _assertEquals(value, getMethodOutput, incorrectGetMethodMessage);
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
    public void detergentClassHasCorrectSetStrengthMethod(String initialValue, String updatedValue) throws Throwable {
        Object[][] arguments = {
                {"Constant Value", String.class},
                {initialValue, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, initialValue, stringFieldName);
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

    private static Stream<String> stringInputProvider() {
        return Stream.of("Tall", "Red", "Horizontal");
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void detergentClassHasCorrectGetStrengthMethod(String value) throws Throwable {
        Object[][] arguments = {
                {"Value", String.class},
                {value, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, value, stringFieldName);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getStringMethodName, "method does not correctly get the value of the", stringFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getStringMethodName, getMethodModifiers, classInstance);
        _assertEquals(value, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void detergentClassHasCorrectToStringMethod(String value, String b) throws Throwable {
        Object[][] arguments = {
                {value, String.class},
                {b, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "The " + className + " instance " + string2FieldName + " is " + value + " and its " + stringFieldName + " is " + b + ".";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void detergentClassMethodsWorkTogether(String value, String b) throws Throwable {
        String initialValue = "" + Math.random() * 100;
        Object[][] arguments = {
                {initialValue, String.class},
                {"First String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(initialValue, testClass.callMethod(getString2MethodName, classInstance),
                "Your " + getString2MethodName + " method does not return the correct value.");
        _assertEquals("First String", testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value.");
        Object[][] setDoubleArguments = {
                {value, String.class}
        };
        testClass.callMethod(setString2MethodName, setDoubleArguments, classInstance);
        _assertEquals(value, testClass.callMethod(getString2MethodName, classInstance),
                "Your " + getString2MethodName + " method does not return the correct value calling the " + setString2MethodName + " method.");
        Object[][] setArguments = {
                {b, String.class}
        };
        testClass.callMethod(setStringMethodName, setArguments, classInstance);
        _assertEquals(b, testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value calling the " + setStringMethodName + " method.");
        String expectedToString = "The " + className + " instance " + string2FieldName + " is " + value + " and its " + stringFieldName + " is " + b + ".";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }
}
