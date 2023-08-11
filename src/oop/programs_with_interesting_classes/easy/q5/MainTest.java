package oop.programs_with_interesting_classes.easy.q5;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static global.tools.CustomAssertions._assertEquals;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final String className = "Discord";
    private final String attributeName1 = "content";
    private final String attributeName2 = "user";
    private final String methodName = "deleteMessage";
    private final String getAttributeName1 = "getContent";
    private final String setAttributeName1 = "setContent";
    private final String getAttributeName2 = "getUser";
    private final String setAttributeName2 = "setUser";
    private final String testClassName = "TestSocialMedia";

    private ObjectTest testClass;
    private ObjectTest classObject;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.easy.q5." + className;
        testClass = new ObjectTest(packageString);
        String testClassString = "oop.programs_with_interesting_classes.easy.q5." + testClassName;
        classObject = new ObjectTest(testClassString);
    }

    @Test
    public void discordHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(testClass.hasField(attributeName1), String.format(missingAttributeMessage, className, attributeName1));
        assertTrue(testClass.hasField(attributeName1, String.class), String.format(wrongTypeMessage, attributeName1, className));
        assertTrue(testClass.hasModifier(attributeName1, "private"), String.format(wrongModifierMessage, attributeName1, className));
        assertTrue(testClass.hasField(attributeName2), String.format(missingAttributeMessage, className, attributeName2));
        assertTrue(testClass.hasField(attributeName2, String.class), String.format(wrongTypeMessage, attributeName2, className));
        assertTrue(testClass.hasModifier(attributeName2, "private"), String.format(wrongModifierMessage, attributeName2, className));
    }

    @Test
    public void discordHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{String.class, String.class};
        assertTrue(testClass.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("The sky is blue", "John", "The sky is black", "Mac"),
                Arguments.of("This apple is tasty", "Sam", "Pineapple is tastier", "Ahmad"),
                Arguments.of("We are getting married", "Alex", "Wedding is cancelled", "Joanna"),
                Arguments.of("Studying for exam", "Maurice", "Going to the club", "Maxine"),
                Arguments.of("Marvel is trash", "Ethan", "DC is not", "Anna"),
                Arguments.of("Marvel is great", "Kyle", "DC is also good", "Amanda"),
                Arguments.of("DC is trash", "Emma", "DC is great", "Fred"),
                Arguments.of("DC is great", "Jackson", "DC is trash", "Brad")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void discordConstructorInitializesValuesCorrectly(String value1, String value2) throws Throwable {
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, String.class}
        };
        Object checkupInstance = testClass.createInstance(constructorArgs);
        _assertEquals(value1, testClass.getFieldValue(checkupInstance, attributeName1), String.format(wrongValueMessage, className, attributeName1));
        _assertEquals(value2, testClass.getFieldValue(checkupInstance, attributeName2), String.format(wrongValueMessage, className, attributeName2));
    }

    @Test
    public void deleteMessageIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(testClass.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(testClass.hasReturnType(methodName, null, Void.TYPE), String.format(incorrectReturnType, methodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectDeleteMessageMethod(String value1, String value2) throws Throwable {
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        String incorrectNumDays = "The %s method in the %s class does not correctly delete the %s attribute.";
        testClass.callMethod(methodName, classInstance);
        _assertEquals("", testClass.getFieldValue(classInstance, attributeName1),
                String.format(incorrectNumDays, methodName, className, attributeName1));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectGetContentMethod(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName1, "does not correctly get the value of the", attributeName1, "attribute.");
        Object getMethodOutput = testClass.callMethod(getAttributeName1, getMethodModifiers, classInstance);
        _assertEquals(value1, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectGetUserMethod(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName2, "does not correctly get the value of the", attributeName2, "attribute.");
        Object getMethodOutput = testClass.callMethod(getAttributeName2, getMethodModifiers, classInstance);
        _assertEquals(value2, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectSetContentMethod(String value1, String value2, String updatedValue1) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {updatedValue1, String.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setAttributeName1, "does not correctly set the value of the", attributeName1, "attribute.");
        Object setMethodOutput = testClass.callMethod(setAttributeName1, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue1, testClass.getFieldValue(classInstance, attributeName1), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setAttributeName1, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectSetSizeMethod(String value1, String value2, String updatedValue1, String updatedValue2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {updatedValue2, String.class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setAttributeName2, "does not correctly set the value of the", attributeName2, "attribute.");
        Object setMethodOutput = testClass.callMethod(setAttributeName2, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue2, testClass.getFieldValue(classInstance, attributeName2), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setAttributeName2, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void discordClassHasCorrectToStringMethod(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = value1 + " From: " + value2;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
    @Tag("dependent1")
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("Hello there From: Jeremy"),
                new NewLine(),
                new StringLiteral("The sky is blue From: Jane")
        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses);
    }
}
