package oop.special_class_method.hard.q5;

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
    private final String className = "Road";
    private final String intFieldName = "lanes";
    private final String stringFieldName = "typeOfRoad";
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
    @Tag("dependency1")
    public void correctTestClass() throws Throwable {
        Object classInstance = outputClass.createInstance();
        String[] methodModifiers = {"public"};
        Object[][] arguments = {
                {new String[0], String[].class}
        };
        outputClass.callMethod("main", arguments, methodModifiers, classInstance, new Clause[]{
                new StringLiteral("The " + className + " instance " + intFieldName + " is " + outputLanes + ", its " + stringFieldName + " is " + outputTypeOfRoad + ", and its " + int2FieldName + " is " + outputMaxCapacity),
                new Optional(new StringLiteral(".")),
                new Optional(new StringLiteral(" "))
        },
                "Your " + testClassName + " class does not print the correct output.");
    }

    @Test
    public void roadClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class, int.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @Test
    public void roadClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(intFieldName),
                "The attribute " + intFieldName + " could not be found in your class. Please make sure you have added it, it is spelled correctly.");
        assertTrue(testClass.hasField(intFieldName, int.class),
                "Your " + intFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(intFieldName, "private"),
                "Your " + intFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(stringFieldName),
                "The attribute " + stringFieldName + " could not be found in your class. Please make sure you have added it, it is spelled correctly.");
        assertTrue(testClass.hasField(stringFieldName, String.class),
                "Your " + stringFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(stringFieldName, "private"),
                "Your " + stringFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(int2FieldName),
                "The attribute " + int2FieldName + " could not be found in your class. Please make sure you have added it, it is spelled correctly.");
        assertTrue(testClass.hasField(int2FieldName, int.class),
                "Your " + int2FieldName + " does not have the correct type.");
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
    @Tag("dependent1")
    public void roadClassHasCorrectConstructor(int value1, String value2, int value3) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class},
                {value3, int.class}
        };
        Class<?>[] constructorClasses = {int.class, String.class, int.class};
        Object classInstance = testClass.createInstance(arguments);
        String incorrectIntValueMessage =
                "Your " + className + " constructor does not initialize the " + intFieldName + " attribute to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor does not initialize the " + stringFieldName + " attribute to the correct value.";
        String incorrectInt2ValueMessage =
                "Your " + className + " constructor does not initialize the " + int2FieldName + " attribute to the correct value.";
        String incorrectConstructorVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        _assertEquals(value1, testClass.getFieldValue(classInstance, intFieldName),
                incorrectIntValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, stringFieldName),
                incorrectStringValueMessage);
        _assertEquals(value3, testClass.getFieldValue(classInstance, int2FieldName),
                incorrectInt2ValueMessage);
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

    @Test
    public void setLanesIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setIntMethodName, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setIntMethodName, className));
        assertTrue(testClass.hasModifier(setIntMethodName, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setIntMethodName, className));
        assertTrue(testClass.hasReturnType(setIntMethodName, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setIntMethodName, className));
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
                "Your", setIntMethodName, "method does not correctly set the value of the", intFieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setIntMethodName, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setIntMethodName, className));
        assertTrue(testClass.hasModifier(setIntMethodName, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setIntMethodName, className));
        assertTrue(testClass.hasReturnType(setIntMethodName, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setIntMethodName, className));

        testClass.callMethod(setIntMethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, intFieldName), incorrectSetMethodMessage);
    }

    @Test
    public void getLanesIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getIntMethodName, null), String.format(incorrectMethodDefinition, getIntMethodName, className));
        assertTrue(testClass.hasModifier(getIntMethodName, null, "public"), String.format(incorrectModifierMessage, getIntMethodName, className));
        assertTrue(testClass.hasReturnType(getIntMethodName, null, int.class), String.format(incorrectReturnType, getIntMethodName, className));
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
                "Your", getIntMethodName, "method does not correctly get the value of the", intFieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getIntMethodName, null), String.format(incorrectMethodDefinition, getIntMethodName, className));
        assertTrue(testClass.hasModifier(getIntMethodName, null, "public"), String.format(incorrectModifierMessage, getIntMethodName, className));
        assertTrue(testClass.hasReturnType(getIntMethodName, null, int.class), String.format(incorrectReturnType, getIntMethodName, className));

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

    @Test
    public void setTypeOfRoadIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setStringMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setStringMethodName, className));
        assertTrue(testClass.hasModifier(setStringMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setStringMethodName, className));
        assertTrue(testClass.hasReturnType(setStringMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setStringMethodName, className));
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
    public void getTypeOfRoadIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getStringMethodName, null), String.format(incorrectMethodDefinition, getStringMethodName, className));
        assertTrue(testClass.hasModifier(getStringMethodName, null, "public"), String.format(incorrectModifierMessage, getStringMethodName, className));
        assertTrue(testClass.hasReturnType(getStringMethodName, null, String.class), String.format(incorrectReturnType, getStringMethodName, className));
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

    @Test
    public void setMaxCapacityIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setInt2MethodName, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setInt2MethodName, className));
        assertTrue(testClass.hasModifier(setInt2MethodName, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setInt2MethodName, className));
        assertTrue(testClass.hasReturnType(setInt2MethodName, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setInt2MethodName, className));
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
                "Your", setInt2MethodName, "method does not correctly set the value of the", int2FieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setInt2MethodName, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setInt2MethodName, className));
        assertTrue(testClass.hasModifier(setInt2MethodName, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setInt2MethodName, className));
        assertTrue(testClass.hasReturnType(setInt2MethodName, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setInt2MethodName, className));

        testClass.callMethod(setInt2MethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, int2FieldName), incorrectSetMethodMessage);
    }

    @Test
    public void getMaxCapacityIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getInt2MethodName, null), String.format(incorrectMethodDefinition, getInt2MethodName, className));
        assertTrue(testClass.hasModifier(getInt2MethodName, null, "public"), String.format(incorrectModifierMessage, getInt2MethodName, className));
        assertTrue(testClass.hasReturnType(getInt2MethodName, null, int.class), String.format(incorrectReturnType, getInt2MethodName, className));
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
                "Your", getInt2MethodName, "method does not correctly get the value of the", int2FieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getInt2MethodName, null), String.format(incorrectMethodDefinition, getInt2MethodName, className));
        assertTrue(testClass.hasModifier(getInt2MethodName, null, "public"), String.format(incorrectModifierMessage, getInt2MethodName, className));
        assertTrue(testClass.hasReturnType(getInt2MethodName, null, int.class), String.format(incorrectReturnType, getInt2MethodName, className));

        Object getMethodOutput = testClass.callMethod(getInt2MethodName, getMethodModifiers, classInstance);
        _assertEquals(value3, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    @Tag("dependent1")
    public void roadClassHasCorrectToStringMethod(int value1, String value2, int value3) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class},
                {value3, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "The " + className + " instance " + intFieldName + " is " + value1 + ", its " + stringFieldName + " is " + value2 + ", and its " + int2FieldName + " is " + value3 + ".";
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
    public void roadClassMethodsWorkTogether(int value1, String value2, int value3) throws Throwable {
        int in1 = (int) (Math.random() * 100);
        int in2 = (int) (Math.random() * 100);
        Object[][] arguments = {
                {in1, int.class},
                {"This is a String", String.class},
                {in2, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(in1, testClass.callMethod(getIntMethodName, classInstance),
                "Your " + getIntMethodName + " method does not return the correct value.");
        _assertEquals("This is a String", testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value.");
        _assertEquals(in2, testClass.callMethod(getInt2MethodName, classInstance),
                "Your " + getInt2MethodName + " method does not return the correct value.");
        Object[][] setIntArguments = {
                {value1, int.class}
        };
        testClass.callMethod(setIntMethodName, setIntArguments, classInstance);
        _assertEquals(value1, testClass.callMethod(getIntMethodName, classInstance),
                "Your " + getIntMethodName + " method does not return the correct value calling the " + setIntMethodName + " method.");
        Object[][] setStringArguments = {
                {value2, String.class}
        };
        testClass.callMethod(setStringMethodName, setStringArguments, classInstance);
        _assertEquals(value2, testClass.callMethod(getStringMethodName, classInstance),
                "Your " + getStringMethodName + " method does not return the correct value calling the " + setStringMethodName + " method.");
        Object[][] setInt2Arguments = {
                {value3, int.class}
        };
        testClass.callMethod(setInt2MethodName, setInt2Arguments, classInstance);
        _assertEquals(value3, testClass.callMethod(getInt2MethodName, classInstance),
                "Your " + getInt2MethodName + " method does not return the correct value calling the " + setInt2MethodName + " method.");

        String expectedToString = "The " + className + " instance " + intFieldName + " is " + value1 + ", its " + stringFieldName + " is " + value2 + ", and its " + int2FieldName + " is " + value3 + ".";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }

}
