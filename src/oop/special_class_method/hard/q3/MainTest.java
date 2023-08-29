package oop.special_class_method.hard.q3;

import global.ObjectTest;
import global.variables.Clause;
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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String className = "Chair";
    private final String doubleFieldName = "size";
    private final String stringFieldName = "softness";
    private final String setStringMethodName = "setSoftness";
    private final String getStringMethodName = "getSoftness";
    private final String getDoubleMethodName = "getSize";
    private final String setDoubleMethodName = "setSize";
    private final String testClassName = "TestClass";
    private final double outputSize = 10.2;
    private final String outputType = "Soft";
    private ObjectTest testClass;
    private ObjectTest outputClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.hard.q3." + className;
        testClass = new ObjectTest(classString);
        String outputClassString = "oop.special_class_method.hard.q3." + testClassName;
        outputClass = new ObjectTest(outputClassString);
    }

    @Test
    @Tag("dependent1")
    @Tag("dependent2")
    public void correctTestClass() throws Throwable {
        Object classInstance = outputClass.createInstance();
        String[] methodModifiers = {"public"};
        Object[][] arguments = {
                {new String[0], String[].class}
        };
        outputClass.callMethod("main", arguments, methodModifiers, classInstance, new Clause[]{
                new StringLiteral("This " + className + "'s " + doubleFieldName + " is " + outputSize + ", and it's " + stringFieldName + " is " + outputType),
                new Optional(new StringLiteral(" "))
        });
    }

    @Test
    public void chairClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(doubleFieldName),
                "Your " + className + " class is missing the " + doubleFieldName + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(doubleFieldName, double.class),
                "Your " + doubleFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(doubleFieldName, "private"),
                "Your " + doubleFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(stringFieldName),
                "Your " + className + " class is missing the " + stringFieldName + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(stringFieldName, String.class),
                "Your " + stringFieldName + " does not have the correct type.");
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
    public void chairClassHasRequiredConstructor() {
        Class<?>[] classArguments = {double.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }


    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    @Tag("dependent1")
    public void chairClassHasCorrectConstructor(double value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor does not initialize the " + doubleFieldName + " attribute to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor does not initialize the " + stringFieldName + " attribute to the correct value.";
        _assertEquals(value1, testClass.getFieldValue(classInstance, doubleFieldName),
                incorrectDoubleValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, stringFieldName),
                incorrectStringValueMessage);
    }

    private static Stream<Arguments> setSizeInputProvider() {
        return Stream.of(
                Arguments.of(22431.21, 6669.21458764),
                Arguments.of(1, 0.0),
                Arguments.of(843739243.2229, 163.35)
        );
    }

    @Test
    public void setSizeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setDoubleMethodName, new Class<?>[]{double.class}), String.format(incorrectMethodDefinition, setDoubleMethodName, className));
        assertTrue(testClass.hasModifier(setDoubleMethodName, new Class<?>[]{double.class}, "public"), String.format(incorrectModifierMessage, setDoubleMethodName, className));
        assertTrue(testClass.hasReturnType(setDoubleMethodName, new Class<?>[]{double.class}, Void.TYPE), String.format(incorrectReturnType, setDoubleMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("setSizeInputProvider")
    public void chairClassHasCorrectSetSizeMethod(double initialValue, double setValue) throws Throwable {
        Object[][] arguments = {
                {initialValue, double.class},
                {"Initial String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {setValue, double.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setDoubleMethodName, new Class<?>[]{double.class}), String.format(incorrectMethodDefinition, setDoubleMethodName, className));
        assertTrue(testClass.hasModifier(setDoubleMethodName, new Class<?>[]{double.class}, "public"), String.format(incorrectModifierMessage, setDoubleMethodName, className));
        assertTrue(testClass.hasReturnType(setDoubleMethodName, new Class<?>[]{double.class}, Void.TYPE), String.format(incorrectReturnType, setDoubleMethodName, className));

        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = "Your " + setDoubleMethodName + " method does not correctly set the value of the " + doubleFieldName + " attribute.";
        testClass.callMethod(setDoubleMethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, doubleFieldName), incorrectSetMethodMessage);
    }

    @Test
    public void getSizeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getDoubleMethodName, null), String.format(incorrectMethodDefinition, getDoubleMethodName, className));
        assertTrue(testClass.hasModifier(getDoubleMethodName, null, "public"), String.format(incorrectModifierMessage, getDoubleMethodName, className));
        assertTrue(testClass.hasReturnType(getDoubleMethodName, null, double.class), String.format(incorrectReturnType, getDoubleMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void chairClassHasCorrectGetSizeMethod(double value) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {"Initial String", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getDoubleMethodName, null), String.format(incorrectMethodDefinition, getDoubleMethodName, className));
        assertTrue(testClass.hasModifier(getDoubleMethodName, null, "public"), String.format(incorrectModifierMessage, getDoubleMethodName, className));
        assertTrue(testClass.hasReturnType(getDoubleMethodName, null, double.class), String.format(incorrectReturnType, getDoubleMethodName, className));

        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getDoubleMethodName, "method does not correctly get the value of the", doubleFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getDoubleMethodName, getMethodModifiers, classInstance);
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

    @Test
    public void setSoftnessIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setStringMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setStringMethodName, className));
        assertTrue(testClass.hasModifier(setStringMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setStringMethodName, className));
        assertTrue(testClass.hasReturnType(setStringMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setStringMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("twoStringInputProvider")
    public void chairClassHasCorrectSetSoftnessMethod(String initialValue, String updatedValue) throws Throwable {
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
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setStringMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setStringMethodName, className));
        assertTrue(testClass.hasModifier(setStringMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setStringMethodName, className));
        assertTrue(testClass.hasReturnType(setStringMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setStringMethodName, className));

        testClass.callMethod(setStringMethodName, setMethodArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue, testClass.getFieldValue(classInstance, stringFieldName), incorrectSetMethodMessage);
    }

    private static Stream<String> stringInputProvider() {
        return Stream.of("Tall", "Red", "Horizontal");
    }

    @Test
    public void getSoftnessIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getStringMethodName, null), String.format(incorrectMethodDefinition, getStringMethodName, className));
        assertTrue(testClass.hasModifier(getStringMethodName, null, "public"), String.format(incorrectModifierMessage, getStringMethodName, className));
        assertTrue(testClass.hasReturnType(getStringMethodName, null, String.class), String.format(incorrectReturnType, getStringMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void chairClassHasCorrectGetSoftnessMethod(String value) throws Throwable {
        Object[][] arguments = {
                {Math.PI, double.class},
                {value, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getStringMethodName, null), String.format(incorrectMethodDefinition, getStringMethodName, className));
        assertTrue(testClass.hasModifier(getStringMethodName, null, "public"), String.format(incorrectModifierMessage, getStringMethodName, className));
        assertTrue(testClass.hasReturnType(getStringMethodName, null, String.class), String.format(incorrectReturnType, getStringMethodName, className));

        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getStringMethodName, "method does not correctly get the value of the", stringFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getStringMethodName, getMethodModifiers, classInstance);
        _assertEquals(value, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    @Tag("dependent2")
    public void chairClassHasCorrectToStringMethod(double value, String b) throws Throwable {
        Object[][] arguments = {
                {value, double.class},
                {b, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "This " + className + "'s " + doubleFieldName + " is " + value + ", and it's " + stringFieldName + " is " + b;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void chairClassMethodsWorkTogether(double value, String b) throws Throwable {
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
        String expectedToString = "This " + className + "'s " + doubleFieldName + " is " + value + ", and it's " + stringFieldName + " is " + b;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }
}
