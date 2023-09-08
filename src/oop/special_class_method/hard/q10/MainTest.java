package oop.special_class_method.hard.q10;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    // Parsons with Distractors
    private final String className = "Award";
    private final String firstFieldName = "awardRecipient";
    private final String secondFieldName = "awardCategory";
    private final String setSecondMethodName = "setAwardCategory";
    private final String getSecondMethodName = "getAwardCategory";
    private final String getFirstMethodName = "getAwardRecipient";
    private final String setFirstMethodName = "setAwardRecipient";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.hard.q10." + className;
        testClass = new ObjectTest(classString);
    }

    @Test
    public void awardClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(firstFieldName),
                "Your " + className + " class is missing the " + firstFieldName + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(firstFieldName, String.class),
                "Your " + firstFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(firstFieldName, "private"),
                "Your " + firstFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(secondFieldName),
                "Your " + className + " class is missing the " + secondFieldName + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(secondFieldName, String.class),
                "Your " + secondFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(secondFieldName, "private"),
                "Your " + secondFieldName + " does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("First", "Second"),
                Arguments.of("Science", "Anna"),
                Arguments.of("Jack", "History"),
                Arguments.of("Finn", "Fiction")

        );
    }

    @Test
    public void awardClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassHasCorrectConstructor(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String incorrectString1ValueMessage =
                "Your " + className + " constructor does not initialize the " + firstFieldName + " attribute to the correct value.";
        String incorrectString2ValueMessage =
                "Your " + className + " constructor does not initialize the " + secondFieldName + " attribute to the correct value.";
        _assertEquals(value1, testClass.getFieldValue(classInstance, firstFieldName),
                incorrectString1ValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, secondFieldName),
                incorrectString2ValueMessage);
    }

    @Test
    public void setAwardRecipientIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setFirstMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setFirstMethodName, className));
        assertTrue(testClass.hasModifier(setFirstMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setFirstMethodName, className));
        assertTrue(testClass.hasReturnType(setFirstMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setFirstMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassHasCorrectSetAwardRecipientMethod(String initialValue, String setValue) throws Throwable {
        Object[][] arguments = {
                {initialValue, String.class},
                {"", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {setValue, String.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setFirstMethodName, "method does not correctly set the value of the", firstFieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setFirstMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setFirstMethodName, className));
        assertTrue(testClass.hasModifier(setFirstMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setFirstMethodName, className));
        assertTrue(testClass.hasReturnType(setFirstMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setFirstMethodName, className));

        testClass.callMethod(setFirstMethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, firstFieldName), incorrectSetMethodMessage);
    }

    @Test
    public void getAwardRecipientIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getFirstMethodName, null), String.format(incorrectMethodDefinition, getFirstMethodName, className));
        assertTrue(testClass.hasModifier(getFirstMethodName, null, "public"), String.format(incorrectModifierMessage, getFirstMethodName, className));
        assertTrue(testClass.hasReturnType(getFirstMethodName, null, String.class), String.format(incorrectReturnType, getFirstMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassHasCorrectGetAwardRecipientMethod(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getFirstMethodName, "method does not correctly get the value of the", firstFieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getFirstMethodName, null), String.format(incorrectMethodDefinition, getFirstMethodName, className));
        assertTrue(testClass.hasModifier(getFirstMethodName, null, "public"), String.format(incorrectModifierMessage, getFirstMethodName, className));
        assertTrue(testClass.hasReturnType(getFirstMethodName, null, String.class), String.format(incorrectReturnType, getFirstMethodName, className));
        Object getMethodOutput = testClass.callMethod(getFirstMethodName, getMethodModifiers, classInstance);
        _assertEquals(value1, getMethodOutput, incorrectGetMethodMessage);
    }

    @Test
    public void setAwardCategoryIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setSecondMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setSecondMethodName, className));
        assertTrue(testClass.hasModifier(setSecondMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setSecondMethodName, className));
        assertTrue(testClass.hasReturnType(setSecondMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setSecondMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassHasCorrectSetAwardCategoryMethod(String initialValue, String updatedValue) throws Throwable {
        Object[][] arguments = {
                {"", String.class},
                {initialValue, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setSecondMethodName, "method does not correctly set the value of the", secondFieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setSecondMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setSecondMethodName, className));
        assertTrue(testClass.hasModifier(setSecondMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setSecondMethodName, className));
        assertTrue(testClass.hasReturnType(setSecondMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setSecondMethodName, className));
        testClass.callMethod(setSecondMethodName, setMethodArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue, testClass.getFieldValue(classInstance, secondFieldName), incorrectSetMethodMessage);
    }

    @Test
    public void getAwardCategoryIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getSecondMethodName, null), String.format(incorrectMethodDefinition, getSecondMethodName, className));
        assertTrue(testClass.hasModifier(getSecondMethodName, null, "public"), String.format(incorrectModifierMessage, getSecondMethodName, className));
        assertTrue(testClass.hasReturnType(getSecondMethodName, null, String.class), String.format(incorrectReturnType, getSecondMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassHasCorrectGetAwardCategoryMethod(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getSecondMethodName, "method does not correctly get the value of the", secondFieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getSecondMethodName, null), String.format(incorrectMethodDefinition, getSecondMethodName, className));
        assertTrue(testClass.hasModifier(getSecondMethodName, null, "public"), String.format(incorrectModifierMessage, getSecondMethodName, className));
        assertTrue(testClass.hasReturnType(getSecondMethodName, null, String.class), String.format(incorrectReturnType, getSecondMethodName, className));

        Object getMethodOutput = testClass.callMethod(getSecondMethodName, getMethodModifiers, classInstance);
        _assertEquals(value2, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassHasCorrectToStringMethod(String value, String b) throws Throwable {
        Object[][] arguments = {
                {value, String.class},
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
        String expected = "The award for " + b + " category goes to " + value;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassMethodsWorkTogether(String value, String b) throws Throwable {
        Object[][] arguments = {
                {"initialValue", String.class},
                {"secondValue", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals("initialValue", testClass.callMethod(getFirstMethodName, classInstance),
                "Your " + getFirstMethodName + " method does not return the correct value.");
        _assertEquals("secondValue", testClass.callMethod(getSecondMethodName, classInstance),
                "Your " + getSecondMethodName + " method does not return the correct value.");
        Object[][] setDoubleArguments = {
                {value, String.class}
        };
        testClass.callMethod(setFirstMethodName, setDoubleArguments, classInstance);
        _assertEquals(value, testClass.callMethod(getFirstMethodName, classInstance),
                "Your " + getFirstMethodName + " method does not return the correct value after calling the " + setFirstMethodName + " method.");
        Object[][] setBooleanArguments = {
                {b, String.class}
        };
        testClass.callMethod(setSecondMethodName, setBooleanArguments, classInstance);
        _assertEquals(b, testClass.callMethod(getSecondMethodName, classInstance),
                "Your " + getSecondMethodName + " method does not return the correct value after calling the " + setSecondMethodName + " method.");
        String expectedToString = "The award for " + b + " category goes to " + value;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }
}
