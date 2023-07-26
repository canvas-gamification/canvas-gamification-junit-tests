package oop.object_independence.medium.q5;

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
    // Java
    private final String className = "Team";
    private ObjectTest testClass;
    private final String firstFieldName = "name";
    private final String secondFieldName = "totalWins";
    private final String getSecondField = "getTotalWins";
    private final String setSecondField = "setTotalWins";

    @BeforeEach
    public void setUp() {
        String classString = "oop.object_independence.medium.q5." + className;
        testClass = new ObjectTest(classString);
    }

    @Test
    public void teamClassHasRequiredAttributes() {
        assertTrue(testClass.hasField(firstFieldName),
                "Your " + className + " class is missing the " + firstFieldName + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(firstFieldName, String.class),
                "Your " + firstFieldName + " attribute does not have the correct type.");
        assertTrue(testClass.hasModifier(firstFieldName, "private"),
                "Your " + firstFieldName + " attribute does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(secondFieldName),
                "Your " + className + " class is missing the " + secondFieldName + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(secondFieldName, int.class),
                "Your " + secondFieldName + " attribute does not have the correct type.");
        assertTrue(testClass.hasModifier(secondFieldName, "private"),
                "Your " + secondFieldName + " attribute does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Alpha", 3),
                Arguments.of("Best", 5),
                Arguments.of("Warriots", 7),
                Arguments.of("Lakers", 9)
        );
    }

    @Test
    public void teamClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, int.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void teamClassHasCorrectConstructor(String value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(value1, testClass.getFieldValue(classInstance, firstFieldName),
                "Your " + className + " constructor does not correctly initialize the " + firstFieldName + " attribute.");
        _assertEquals(value2, testClass.getFieldValue(classInstance, secondFieldName),
                "Your " + className + " constructor does not correctly initialize the " + secondFieldName + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void teamClassHasCorrectGetTotalWinsMethod(String value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getSecondField, "method does not correctly get the value of the", secondFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getSecondField, getMethodModifiers, classInstance);
        _assertEquals(value2, getMethodOutput, incorrectGetMethodMessage);
    }

    private static Stream<Arguments> set1InputProvider() {
        return Stream.of(
                Arguments.of(5, 6),
                Arguments.of(10, 20),
                Arguments.of(7, 5)
        );
    }


    @ParameterizedTest
    @MethodSource("set1InputProvider")
    public void teamClassHasCorrectSetNumAheadMethod(int value, int update) throws Throwable {
        Object[][] arguments = {
                {"Name", String.class},
                {value, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setArguments = {
                {update, int.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setSecondField, "method does not correctly set the value of the", secondFieldName, "attribute.");
        Object setMethodOutput = testClass.callMethod(setSecondField, setArguments, setMethodModifiers, classInstance);
        _assertEquals(update, testClass.getFieldValue(classInstance, secondFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setSecondField, "method should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void teamClassHasCorrectToStringMethod(String value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "Team " + value1 + " has won " + value2 + " games";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void teamClassMethodsWorkTogether(String value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {0, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(0, testClass.callMethod(getSecondField, classInstance),
                "Your " + getSecondField + " method does not return the correct value.");
        Object[][] setArguments = {
                {value2, int.class}
        };
        testClass.callMethod(setSecondField, setArguments, classInstance);
        _assertEquals(value2, testClass.callMethod(getSecondField, classInstance),
                "Your " + getSecondField + " method does not return the correct value after calling the " + setSecondField + " method.");
        String expected = "Team " + value1 + " has won " + value2 + " games";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String after updating the values of its attributes using its setter method.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

}
