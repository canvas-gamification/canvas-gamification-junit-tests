package oop.special_class_method.hard.q5;

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
    private final String className = "Road";
    private final String intFieldName = "lanes";
    private final String StringFieldName = "typeOfRoad";
    private final String int2FieldName = "maxCapacity";
    private final String setStringMethodName = "setTypeOfRoad";
    private final String getStringMethodName = "getTypeOfRoad";
    private final String getIntMethodName = "getLanes";
    private final String setIntMethodName = "setLanes";
    private final String getInt2MethodName = "getMaxCapacity";
    private final String setInt2MethodName = "setMaxCapacity";
    private final String testClassName = "TestClass";
    private final int outputLanes = 3;
    private final String outputTypeOfRoad = "Highway";
    private final int outputMaxCapacity = 100;
    private ObjectTest testClass;
    private ObjectTest outputClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.hard.q5." + className;
        testClass = new ObjectTest(classString);
        String outputClassString = "oop.special_class_method.hard.q5." + testClassName;
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
                new StringLiteral(className + "\\{" + intFieldName + ": " + outputLanes + ", " + StringFieldName + ": " + outputTypeOfRoad + ", " + int2FieldName + ": " + outputMaxCapacity + "\\}"),
                new Optional(new StringLiteral(" ")),
                new Optional(new NewLine())
        });
    }

    @Test
    public void roadClassHasCorrectFields() {
        assertTrue(testClass.hasField(intFieldName, int.class),
                "Your " + className + " class is missing the " + intFieldName + " field.");
        assertTrue(testClass.hasModifier(intFieldName, "private"),
                "Your " + intFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(StringFieldName, String.class),
                "Your " + className + " class is missing the " + StringFieldName + " field.");
        assertTrue(testClass.hasModifier(StringFieldName, "private"),
                "Your " + StringFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(int2FieldName, int.class),
                "Your " + className + " class is missing the " + int2FieldName + " field.");
        assertTrue(testClass.hasModifier(int2FieldName, "private"),
                "Your " + int2FieldName + " does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(4, "Highway", 653),
                Arguments.of(3, "Road", 5645),
                Arguments.of(1, "Way", 434),
                Arguments.of(6, "Street", 545443)

        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void roadClassHasCorrectConstructor(int value1, String value2, int value3) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class},
                {value3, int.class}
        };
        Class<?>[] constructorClasses = {int.class, String.class, int.class};
        Object classInstance = testClass.createInstance(arguments);
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor does not initialize the " + intFieldName + " filed to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor does not initialize the " + StringFieldName + " filed to the correct value.";
        String incorrectIntValueMessage =
                "Your " + className + " constructor does not initialize the " + int2FieldName + " filed to the correct value.";
        String incorrectConstructorVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        _assertEquals(value1, testClass.getFieldValue(classInstance, intFieldName),
                incorrectDoubleValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, StringFieldName),
                incorrectStringValueMessage);
        _assertEquals(value3, testClass.getFieldValue(classInstance, int2FieldName),
                incorrectIntValueMessage);
        assertTrue(testClass.hasModifier(constructorClasses, "public"), incorrectConstructorVisibilityModifier);
    }

    private static Stream<Arguments> twoIntInputProvider() {
        return Stream.of(
                Arguments.of(4, 3),
                Arguments.of(3, 6),
                Arguments.of(1, 4),
                Arguments.of(6, 1)

        );
    }

    @ParameterizedTest
    @MethodSource("twoIntInputProvider")
    public void roadClassHasCorrectSetLanesMethod(int initialValue, int setValue) throws Throwable {
        Object[][] arguments = {
                {initialValue, int.class},
                {"Initial String", String.class},
                {2, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {setValue, int.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setIntMethodName, "method does not correctly set the value of the", intFieldName, "field.");
        Object setMethodOutput = testClass.callMethod(setIntMethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, intFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setIntMethodName, "method should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void roadClassHasCorrectGetLanesMethod(int value1, String value2, int value3) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class},
                {value3, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getIntMethodName, "method does not correctly get the value of the", intFieldName, "field.");
        Object getMethodOutput = testClass.callMethod(getIntMethodName, getMethodModifiers, classInstance);
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
    public void roadClassHasCorrectSetTypeOfRoadMethod(String initialValue, String updatedValue) throws Throwable {
        Object[][] arguments = {
                {2, int.class},
                {initialValue, String.class},
                {100, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, initialValue, StringFieldName);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setStringMethodName, "method does not correctly set the value of the", StringFieldName, "field.");
        Object setMethodOutput = testClass.callMethod(setStringMethodName, setMethodArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue, testClass.getFieldValue(classInstance, StringFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setStringMethodName, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void roadClassHasCorrectGetTypeOfRoadMethod(int value1, String value2, int value3) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class},
                {value3, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, value2, StringFieldName);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getStringMethodName, "does not correctly get the value of the", StringFieldName, "field.");
        Object getMethodOutput = testClass.callMethod(getStringMethodName, getMethodModifiers, classInstance);
        _assertEquals(value2, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("twoIntInputProvider")
    public void roadClassHasCorrectSetMaxCapacityMethod(int initialValue, int setValue) throws Throwable {
        Object[][] arguments = {
                {2, int.class},
                {"Initial String", String.class},
                {initialValue, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {setValue, int.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setInt2MethodName, "does not correctly set the value of the", int2FieldName, "field.");
        Object setMethodOutput = testClass.callMethod(setInt2MethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, int2FieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setInt2MethodName, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void roadClassHasCorrectGetMaxCapacityMethod(int value1, String value2, int value3) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class},
                {value3, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getInt2MethodName, "does not correctly get the value of the", int2FieldName, "field.");
        Object getMethodOutput = testClass.callMethod(getInt2MethodName, getMethodModifiers, classInstance);
        _assertEquals(value3, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void chairClassHasCorrectToStringMethod(int value1, String value2, int value3) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class},
                {value3, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = className + "{" + intFieldName + ": " + value1 + ", " + StringFieldName + ": " + value2 + ", " + int2FieldName + ": " + value3 + "}";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

}
