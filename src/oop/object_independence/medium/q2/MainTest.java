package oop.object_independence.medium.q2;

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
    // Parsons
    private final String className = "PhoneWaitList";
    private final String outputClassName = "TestWaitList";
    private ObjectTest testClass;
    private ObjectTest outputClass;
    private final String firstFieldName = "numAhead";
    private final String getFirstField = "getNumAhead";
    private final String setFirstField = "setNumAhead";
    private final int outputNum1 = 5;
    private final int outputNum2 = 2;

    @Test
    @Tag("dependency1")
    public void correctTestClass() throws Throwable {
        Clause[] c = new Clause[]{
                new StringLiteral("There are " + outputNum1 + " people ahead of you"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("There are " + outputNum2 + " people ahead of you"),
                new Optional(new StringLiteral(" "))
        };
        Object[][] arguments = {
                {new String[0], String[].class}
        };
        String incorrectMethodOutputMessage = "Your main method in the " + outputClassName + " class does not print the correct output, make sure you initialize, modify, and print the object correctly using the toString method.";
        outputClass.callMethod("main", arguments, c, incorrectMethodOutputMessage);
    }

    @BeforeEach
    public void setUp() {
        String bankString = "oop.object_independence.medium.q2." + className;
        String testClassString = "oop.object_independence.medium.q2." + outputClassName;
        testClass = new ObjectTest(bankString);
        outputClass = new ObjectTest(testClassString);
    }

    // Field Tests
    @Test
    public void phoneWaitListClassHasRequiredAttributes() {
        assertTrue(testClass.hasField(firstFieldName),
                "Your " + className + " class is missing the " + firstFieldName + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(firstFieldName, int.class),
                "Your " + firstFieldName + " does not have the correct type.");
        assertTrue(testClass.hasModifier(firstFieldName, "private"),
                "Your " + firstFieldName + " does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(2),
                Arguments.of(5),
                Arguments.of(10),
                Arguments.of(43)
        );
    }

    @Test
    public void phoneWaitListClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void phoneWaitListClassHasCorrectConstructor(int value) throws Throwable {
        Object[][] arguments = {
                {value, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(value, testClass.getFieldValue(classInstance, firstFieldName),
                "Your " + className + " constructor does not correctly initialize the " + firstFieldName + " attribute.");
    }

    @Test
    public void getNumAheadIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getFirstField, null), String.format(incorrectMethodDefinition, getFirstField, className));
        assertTrue(testClass.hasModifier(getFirstField, null, "public"), String.format(incorrectModifierMessage, getFirstField, className));
        assertTrue(testClass.hasReturnType(getFirstField, null, int.class), String.format(incorrectReturnType, getFirstField, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void phoneWaitListClassHasCorrectGetNumAheadMethod(int value) throws Throwable {
        Object[][] arguments = {
                {value, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getFirstField, "method does not correctly get the value of the", firstFieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getFirstField, null), String.format(incorrectMethodDefinition, getFirstField, className));
        assertTrue(testClass.hasModifier(getFirstField, null, "public"), String.format(incorrectModifierMessage, getFirstField, className));
        assertTrue(testClass.hasReturnType(getFirstField, null, int.class), String.format(incorrectReturnType, getFirstField, className));

        Object getMethodOutput = testClass.callMethod(getFirstField, getMethodModifiers, classInstance);
        _assertEquals(value, getMethodOutput, incorrectGetMethodMessage);
    }

    private static Stream<Arguments> set1InputProvider() {
        return Stream.of(
                Arguments.of(2, 3),
                Arguments.of(5, 7),
                Arguments.of(10, 3),
                Arguments.of(43, 150)
        );
    }

    @Test
    public void setNumAheadIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setFirstField, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setFirstField, className));
        assertTrue(testClass.hasModifier(setFirstField, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setFirstField, className));
        assertTrue(testClass.hasReturnType(setFirstField, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setFirstField, className));
    }

    @ParameterizedTest
    @MethodSource("set1InputProvider")
    public void phoneWaitListClassHasCorrectSetNumAheadMethod(int value, int update) throws Throwable {
        Object[][] arguments = {
                {value, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setArguments = {
                {update, int.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setFirstField, "method does not correctly set the value of the", firstFieldName, "attribute.");
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setFirstField, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setFirstField, className));
        assertTrue(testClass.hasModifier(setFirstField, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setFirstField, className));
        assertTrue(testClass.hasReturnType(setFirstField, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setFirstField, className));
        testClass.callMethod(setFirstField, setArguments, setMethodModifiers, classInstance);
        _assertEquals(update, testClass.getFieldValue(classInstance, firstFieldName), incorrectSetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void phoneWaitListClassHasCorrectToStringMethod(int value) throws Throwable {
        Object[][] arguments = {
                {value, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        String[] methodModifiers = {"public"};
        String expected = "There are " + value + " people ahead of you";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void phoneWaitListClassMethodsWorkTogether(int value) throws Throwable {
        int initialValue = (int) (Math.random() * 100);
        Object[][] arguments = {
                {initialValue, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(initialValue, testClass.callMethod(getFirstField, classInstance),
                "Your " + getFirstField + " method does not return the correct value.");
        Object[][] setArguments = {
                {value, int.class}
        };
        testClass.callMethod(setFirstField, setArguments, classInstance);
        _assertEquals(value, testClass.callMethod(getFirstField, classInstance),
                "Your " + getFirstField + " method does not return the correct value after calling the " + setFirstField + " method.");
        String expectedToString = "There are " + value + " people ahead of you";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String after updating the value of its attribute using its setter method.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expectedToString, output, incorrectToStringMessage);
    }

}
