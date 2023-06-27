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
        assertTrue(testClass.hasField(firstFieldName, String.class),
                "Your " + className + " class is missing the " + firstFieldName + " attributes.");
        assertTrue(testClass.hasModifier(firstFieldName, "private"),
                "Your " + firstFieldName + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(secondFieldName, String.class),
                "Your " + className + " class is missing the " + secondFieldName + " attributes.");
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

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassHasCorrectConstructor(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Class<?>[] constructorClasses = {String.class, String.class};
        Object classInstance = testClass.createInstance(arguments);
        String incorrectDoubleValueMessage =
                "Your " + className + " constructor does not initialize the " + firstFieldName + " attribute to the correct value.";
        String incorrectStringValueMessage =
                "Your " + className + " constructor does not initialize the " + secondFieldName + " attribute to the correct value.";
        String incorrectConstructorVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        _assertEquals(value1, testClass.getFieldValue(classInstance, firstFieldName),
                incorrectDoubleValueMessage);
        _assertEquals(value2, testClass.getFieldValue(classInstance, secondFieldName),
                incorrectStringValueMessage);
        assertTrue(testClass.hasModifier(constructorClasses, "public"), incorrectConstructorVisibilityModifier);
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
                "Your", setFirstMethodName, "does not correctly set the value of the", firstFieldName, "attribute.");
        Object setMethodOutput = testClass.callMethod(setFirstMethodName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(setValue, testClass.getFieldValue(classInstance, firstFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setFirstMethodName, "should not return any output"));
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
                "Your", getFirstMethodName, "does not correctly get the value of the", firstFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getFirstMethodName, getMethodModifiers, classInstance);
        _assertEquals(value1, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassHasCorrectSetAwardCategoryMethod(String initialValue, String updatedValue) throws Throwable {
        Object[][] arguments = {
                {"", String.class},
                {initialValue, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, initialValue, secondFieldName);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setSecondMethodName, "does not correctly set the value of the", secondFieldName, "attribute.");
        Object setMethodOutput = testClass.callMethod(setSecondMethodName, setMethodArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue, testClass.getFieldValue(classInstance, secondFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setSecondMethodName, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void awardClassHasCorrectGetAwardCategoryMethod(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(classInstance, value2, secondFieldName);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getSecondMethodName, "does not correctly get the value of the", secondFieldName, "attribute.");
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
        String[] methodModifiers = {"public"};
        String expected = "The award for " + b + " category goes to " + value;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
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
                "Your " + getSecondMethodName + " method does not return the correct value calling the " + setSecondMethodName + " method.");
        String expectedToString = "The award for " + b + " category goes to " + value;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String after updating the values of its attributes using its setter methods.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }
}
