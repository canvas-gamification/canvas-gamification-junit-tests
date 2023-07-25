package oop.special_class_method.hard.q2;

import global.ObjectTest;
import global.variables.Clause;
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

    private final String className = "Glasses";
    private final String doubleFieldName = "size";
    private final String stringFieldName = "type";
    private final String setStringMethodName = "setType";
    private final String getStringMethodName = "getType";
    private final String getDoubleMethodName = "getSize";
    private final String setDoubleMethodName = "setSize";
    private final String testClassName = "TestClass";
    private final double outputSize = 7.5;
    private final String outputType = "Long";
    private ObjectTest testClass;
    private ObjectTest outputClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.hard.q2." + className;
        testClass = new ObjectTest(classString);
        String outputClassString = "oop.special_class_method.hard.q2." + testClassName;
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
                new StringLiteral("This " + className + " class have a size of " + outputSize * 10 + ", and are type " + outputType),
                new Optional(new StringLiteral(" "))
        });
    }

    @Test
    public void glassesClassHasCorrectFields() {
        assertTrue(testClass.hasField(doubleFieldName),
                "Your " + className + " class is missing the " + doubleFieldName + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(doubleFieldName, double.class),
                "Your " + doubleFieldName + " does not have the correct return type.");
        assertTrue(testClass.hasModifier(doubleFieldName, "private"),
                "Your " + doubleFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(stringFieldName),
                "Your " + className + " class is missing the " + stringFieldName + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(stringFieldName, String.class),
                "Your " + stringFieldName + " does not have the correct return type.");
        assertTrue(testClass.hasModifier(stringFieldName, "private"),
                "Your " + stringFieldName + " does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(543.34, "Long"),
                Arguments.of(222342.43, "Round"),
                Arguments.of(3.3, "Tall"),
                Arguments.of(4323.4, "Short")

        );
    }

    @Test
    public void glassesClassHasRequiredConstructor() {
        Class<?>[] classArguments = {double.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void glassesClassHasCorrectConstructor(double value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, String.class}
        };
        Class<?>[] constructorClasses = {double.class, String.class};
        Object classInstance = testClass.createInstance(arguments);
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor does not initialize the " + doubleFieldName + " attribute to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor does not initialize the " + stringFieldName + " attribute to the correct value.";
        String incorrectConstructorVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        _assertEquals(value1 * 10, testClass.getFieldValue(classInstance, doubleFieldName),
                incorrectDoubleValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, stringFieldName),
                incorrectStringValueMessage);
        assertTrue(testClass.hasModifier(constructorClasses, "public"), incorrectConstructorVisibilityModifier);
    }

    private static Stream<Arguments> setSizeInputProvider() {
        return Stream.of(
                Arguments.of(22431.21, 6669.21458764),
                Arguments.of(1, 0.0),
                Arguments.of(843739243.2229, 163.35)
        );
    }

    @ParameterizedTest
    @MethodSource("setSizeInputProvider")
    public void glassesClassHasCorrectSetSizeMethod(double initialValue, double setValue) throws Throwable {
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
    public void glassesClassHasCorrectGetSizeMethod(double value) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {"Initial String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getDoubleMethodName, "method does not correctly get the value of the", doubleFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getDoubleMethodName, getMethodModifiers, classInstance);
        _assertEquals(value * 10, getMethodOutput, incorrectGetMethodMessage);
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
    public void glassesClassHasCorrectSetTypeMethod(String initialValue, String updatedValue) throws Throwable {
        Object[][] arguments = {
                {Math.PI, double.class},
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

    private static Stream<String> stringInputProvider() {
        return Stream.of("Tall", "Red", "Horizontal");
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void glassesClassHasCorrectGetTypeMethod(String value) throws Throwable {
        Object[][] arguments = {
                {Math.PI, double.class},
                {value, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getStringMethodName, "method does not correctly get the value of the", stringFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getStringMethodName, getMethodModifiers, classInstance);
        _assertEquals(value, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void glassesClassHasCorrectToStringMethod(double value, String b) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {b, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "This " + className + " class have a size of " + value * 10 + ", and are type " + b;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void glassesClassMethodsWorkTogether(double value, String b) throws Throwable {
        double initialValue = Math.random() * 100;
        Object[][] arguments = {
                {initialValue, double.class},
                {"First String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(initialValue * 10, testClass.callMethod(getDoubleMethodName, classInstance),
                "Your " + getDoubleMethodName + " method does not return the correct value.");
        _assertEquals("First String", testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value.");
        Object[][] setDoubleArguments = {
                {value, double.class}
        };
        testClass.callMethod(setDoubleMethodName, setDoubleArguments, classInstance);
        _assertEquals(value, testClass.callMethod(getDoubleMethodName, classInstance),
                "Your " + getDoubleMethodName + " method does not return the correct value calling the " + setDoubleMethodName + " method.");
        Object[][] setStringArguments = {
                {b, String.class}
        };
        testClass.callMethod(setStringMethodName, setStringArguments, classInstance);
        _assertEquals(b, testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value calling the " + setStringMethodName + " method.");
        String expectedToString = "This " + className + " class have a size of " + value + ", and are type " + b;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }
}
