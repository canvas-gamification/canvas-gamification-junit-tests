package oop.special_class_method.hard.q6;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
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
    @Tag("dependency1")
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
                "The attribute " + doubleFieldName + " could not be found in your class. Please make sure you have added it, and it is spelled correctly.");
        assertTrue(testClass.hasField(doubleFieldName, double.class),
                "Your " + doubleFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(doubleFieldName, "private"),
                "Your " + doubleFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(stringFieldName),
                "The attribute " + stringFieldName + " could not be found in your class. Please make sure you have added it, and it is spelled correctly.");
        assertTrue(testClass.hasField(stringFieldName, String.class),
                "Your " + stringFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(stringFieldName, "private"),
                "Your " + stringFieldName + " does not have the correct visibility modifier.");
    }

    @Test
    public void carClassHasRequiredConstructorWithParameters() {
        Class<?>[] classArguments = {double.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor with parameters does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor with parameters does not have the correct modifier.");
    }

    @Test
    public void carClassHasRequiredConstructorWithNoParameters() {
        Class<?>[] classArguments = {};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " parameterless constructor cannot be found.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " parameterless constructor does not have the correct modifier.");
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
    @Tag("dependent1")
    public void carClassHasCorrectConstructorWithParameters(double value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor with input does not initialize the " + doubleFieldName + " attribute to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor with input does not initialize the " + stringFieldName + " attribute to the correct value.";
        _assertEquals(value1, testClass.getFieldValue(classInstance, doubleFieldName),
                incorrectDoubleValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, stringFieldName),
                incorrectStringValueMessage);
    }

    @Test
    @Tag("dependent1")
    public void carClassHasCorrectConstructorWithoutParameters() throws Throwable {
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

    @Test
    public void setTopSpeedIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setDoubleMethodName, new Class<?>[]{double.class}), String.format(incorrectMethodDefinition, setDoubleMethodName, className));
        assertTrue(testClass.hasModifier(setDoubleMethodName, new Class<?>[]{double.class}, "public"), String.format(incorrectModifierMessage, setDoubleMethodName, className));
        assertTrue(testClass.hasReturnType(setDoubleMethodName, new Class<?>[]{double.class}, Void.TYPE), String.format(incorrectReturnType, setDoubleMethodName, className));
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
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setDoubleMethodName, new Class<?>[]{double.class}), String.format(incorrectMethodDefinition, setDoubleMethodName, className));
        assertTrue(testClass.hasModifier(setDoubleMethodName, new Class<?>[]{double.class}, "public"), String.format(incorrectModifierMessage, setDoubleMethodName, className));
        assertTrue(testClass.hasReturnType(setDoubleMethodName, new Class<?>[]{double.class}, Void.TYPE), String.format(incorrectReturnType, setDoubleMethodName, className));
        testClass.callMethod(setDoubleMethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, doubleFieldName), incorrectSetMethodMessage);
    }

    @Test
    public void getTopSpeedIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getDoubleMethodName, null), String.format(incorrectMethodDefinition, getDoubleMethodName, className));
        assertTrue(testClass.hasModifier(getDoubleMethodName, null, "public"), String.format(incorrectModifierMessage, getDoubleMethodName, className));
        assertTrue(testClass.hasReturnType(getDoubleMethodName, null, double.class), String.format(incorrectReturnType, getDoubleMethodName, className));
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
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getDoubleMethodName, null), String.format(incorrectMethodDefinition, getDoubleMethodName, className));
        assertTrue(testClass.hasModifier(getDoubleMethodName, null, "public"), String.format(incorrectModifierMessage, getDoubleMethodName, className));
        assertTrue(testClass.hasReturnType(getDoubleMethodName, null, double.class), String.format(incorrectReturnType, getDoubleMethodName, className));
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

    @Test
    public void setTypeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setStringMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setStringMethodName, className));
        assertTrue(testClass.hasModifier(setStringMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setStringMethodName, className));
        assertTrue(testClass.hasReturnType(setStringMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setStringMethodName, className));
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
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setStringMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setStringMethodName, className));
        assertTrue(testClass.hasModifier(setStringMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setStringMethodName, className));
        assertTrue(testClass.hasReturnType(setStringMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setStringMethodName, className));
        testClass.callMethod(setStringMethodName, setMethodArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue, testClass.getFieldValue(classInstance, stringFieldName), incorrectSetMethodMessage);
    }

    @Test
    public void getTypeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getStringMethodName, null), String.format(incorrectMethodDefinition, getStringMethodName, className));
        assertTrue(testClass.hasModifier(getStringMethodName, null, "public"), String.format(incorrectModifierMessage, getStringMethodName, className));
        assertTrue(testClass.hasReturnType(getStringMethodName, null, String.class), String.format(incorrectReturnType, getStringMethodName, className));
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
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getStringMethodName, null), String.format(incorrectMethodDefinition, getStringMethodName, className));
        assertTrue(testClass.hasModifier(getStringMethodName, null, "public"), String.format(incorrectModifierMessage, getStringMethodName, className));
        assertTrue(testClass.hasReturnType(getStringMethodName, null, String.class), String.format(incorrectReturnType, getStringMethodName, className));

        Object getMethodOutput = testClass.callMethod(getStringMethodName, getMethodModifiers, classInstance);
        _assertEquals(value2, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    @Tag("dependent1")
    public void carClassHasCorrectToStringMethod(double value, String b) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {b, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        String[] methodModifiers = {"public"};
        String expected = "This " + className + " has a " + doubleFieldName + " of " + value + " with the " + stringFieldName + " " + b + ".";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void carClassWithParametersMethodsWorkTogether(double value, String b) throws Throwable {
        double initialValue = Math.random() * 100;
        Object[][] arguments = {
                {initialValue, double.class},
                {"First String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(initialValue, testClass.callMethod(getDoubleMethodName, classInstance), 0.0001,
                "Your " + getDoubleMethodName + " method does not return the correct value.");
        _assertEquals("First String", testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value.");
        Object[][] setDoubleArguments = {
                {value, double.class}
        };
        testClass.callMethod(setDoubleMethodName, setDoubleArguments, classInstance);
        _assertEquals(value, testClass.callMethod(getDoubleMethodName, classInstance), 0.0001,
                "Your " + getDoubleMethodName + " method does not return the correct value after calling the " + setDoubleMethodName + " method.");
        Object[][] setArguments = {
                {b, String.class}
        };
        testClass.callMethod(setStringMethodName, setArguments, classInstance);
        _assertEquals(b, testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value after calling the " + setStringMethodName + " method.");
        String expectedToString = "This " + className + " has a " + doubleFieldName + " of " + value + " with the " + stringFieldName + " " + b + ".";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void carClassMethodsWorkTogether2(double value, String b) throws Throwable {
        Object classInstance = testClass.createInstance();
        _assertEquals(180.0, testClass.callMethod(getDoubleMethodName, classInstance), 0.0001,
                "Your " + getDoubleMethodName + " method does not return the correct value.");
        assertNull(testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value.");
        Object[][] setDoubleArguments = {
                {value, double.class}
        };
        testClass.callMethod(setDoubleMethodName, setDoubleArguments, classInstance);
        _assertEquals(value, testClass.callMethod(getDoubleMethodName, classInstance), 0.0001,
                "Your " + getDoubleMethodName + " method does not return the correct value after calling the " + setDoubleMethodName + " method.");
        Object[][] setArguments = {
                {b, String.class}
        };
        testClass.callMethod(setStringMethodName, setArguments, classInstance);
        _assertEquals(b, testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value after calling the " + setStringMethodName + " method.");
        String expectedToString = "This " + className + " has a " + doubleFieldName + " of " + value + " with the " + stringFieldName + " " + b + ".";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }
}
