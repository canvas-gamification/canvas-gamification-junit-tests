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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Parsons

    private final String className = "Discord";
    private final String attributeName1 = "content";
    private final String attributeName2 = "user";
    private final String methodName = "deleteMessage";
    private final String getAttributeName1 = "getContent";
    private final String setAttributeName1 = "setContent";
    private final String getAttributeName2 = "getUser";
    private final String setAttributeName2 = "setUser";
    private final String testClassName = "TestSocialMedia";
    private final String expectedString = "%s From: %s";
    private final String msg1 = "Hello there From: Jeremy";
    private final String msg2 = "The sky is blue From: Jane";

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
        String wrongValueMessage = "The %s constructor did not correctly initialize the %s attribute given the passed parameter value.";
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, String.class}
        };
        Object checkupInstance = testClass.createInstance(constructorArgs);
        _assertEquals(value1, testClass.getFieldValue(checkupInstance, attributeName1), String.format(wrongValueMessage, className, attributeName1));
        _assertEquals(value2, testClass.getFieldValue(checkupInstance, attributeName2), String.format(wrongValueMessage, className, attributeName2));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectDeleteMessageMethod(String value1, String value2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(testClass.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(testClass.hasReturnType(methodName, null, Void.TYPE), String.format(incorrectReturnType, methodName, className));
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        String incorrectNumDays = "The %s method in the %s class does not correctly delete the contents of the %s attribute.";
        testClass.callMethod(methodName, classInstance);
        _assertEquals("", testClass.getFieldValue(classInstance, attributeName1),
                String.format(incorrectNumDays, methodName, className, attributeName1));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectGetContentMethod(String value1, String value2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeName1, null), String.format(incorrectMethodDefinition, getAttributeName1, className));
        assertTrue(testClass.hasModifier(getAttributeName1, null, "public"), String.format(incorrectModifierMessage, getAttributeName1, className));
        assertTrue(testClass.hasReturnType(getAttributeName1, null, String.class), String.format(incorrectReturnType, getAttributeName1, className));
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName1, "method does not correctly get the value of the", attributeName1, "attribute.");
        Object getMethodOutput = testClass.callMethod(getAttributeName1, getMethodModifiers, classInstance);
        _assertEquals(value1, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectGetUserMethod(String value1, String value2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeName2, null), String.format(incorrectMethodDefinition, getAttributeName2, className));
        assertTrue(testClass.hasModifier(getAttributeName2, null, "public"), String.format(incorrectModifierMessage, getAttributeName2, className));
        assertTrue(testClass.hasReturnType(getAttributeName2, null, String.class), String.format(incorrectReturnType, getAttributeName2, className));
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName2, "method does not correctly get the value of the", attributeName2, "attribute.");
        Object getMethodOutput = testClass.callMethod(getAttributeName2, getMethodModifiers, classInstance);
        _assertEquals(value2, getMethodOutput, incorrectGetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectSetContentMethod(String value1, String value2, String updatedValue1) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeName1, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeName1, className));
        assertTrue(testClass.hasModifier(setAttributeName1, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeName1, className));
        assertTrue(testClass.hasReturnType(setAttributeName1, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeName1, className));
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
                "Your", setAttributeName1, "method does not correctly set the value of the", attributeName1, "attribute.");
        testClass.callMethod(setAttributeName1, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue1, testClass.getFieldValue(classInstance, attributeName1), incorrectSetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void discordClassHasCorrectSetUserMethod(String value1, String value2, String updatedValue1, String updatedValue2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeName2, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeName2, className));
        assertTrue(testClass.hasModifier(setAttributeName2, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeName2, className));
        assertTrue(testClass.hasReturnType(setAttributeName2, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeName2, className));
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
                "Your", setAttributeName2, "method does not correctly set the value of the", attributeName2, "attribute.");
        testClass.callMethod(setAttributeName2, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(updatedValue2, testClass.getFieldValue(classInstance, attributeName2), incorrectSetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void discordClassHasCorrectToStringMethod(String value1, String value2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        Object[][] arguments = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = String.format(expectedString, value1, value2);
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodsWorkTogether(String value1, String value2, String updatedValue1, String updatedValue2) throws Throwable {
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        String incorrectNumDays = "The %s method in the %s class does not correctly delete the contents of the %s attribute.";
        testClass.callMethod(methodName, classInstance);
        _assertEquals("", testClass.getFieldValue(classInstance, attributeName1),
                String.format(incorrectNumDays, methodName, className, attributeName1));

        String[] methodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName1, "method does not correctly get the value of the", attributeName1, "attribute after calling the", methodName, "method.");
        Object getMethodOutput = testClass.callMethod(getAttributeName1, methodModifiers, classInstance);
        _assertEquals("", getMethodOutput, incorrectGetMethodMessage);

        Object[][] setSizeArguments = {
                {updatedValue2, String.class}
        };
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setAttributeName2, "method does not correctly set the value of the", attributeName2, "attribute.");
        testClass.callMethod(setAttributeName2, setSizeArguments, methodModifiers, classInstance);
        _assertEquals(updatedValue2, testClass.getFieldValue(classInstance, attributeName2), incorrectSetMethodMessage);

        setSizeArguments = new Object[][]{
                {updatedValue1, String.class}
        };
        incorrectSetMethodMessage = String.join(" ",
                "Your", setAttributeName1, "method does not correctly set the value of the", attributeName1, "attribute.");
        testClass.callMethod(setAttributeName1, setSizeArguments, methodModifiers, classInstance);
        _assertEquals(updatedValue1, testClass.getFieldValue(classInstance, attributeName1), incorrectSetMethodMessage);

        incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName2, "method does not correctly get the value of the", attributeName2, "attribute after calling the set methods.");
        getMethodOutput = testClass.callMethod(getAttributeName2, methodModifiers, classInstance);
        _assertEquals(updatedValue2, getMethodOutput, incorrectGetMethodMessage);

        incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName1, "method does not correctly get the value of the", attributeName1, "attribute after calling the set methods.");
        getMethodOutput = testClass.callMethod(getAttributeName1, methodModifiers, classInstance);
        _assertEquals(updatedValue1, getMethodOutput, incorrectGetMethodMessage);

        String expected = String.format(expectedString, updatedValue1, updatedValue2);
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String after calling the set and get methods.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
    @Tag("dependency1")
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral(msg1),
                new NewLine(),
                new StringLiteral(msg2)
        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses, "Your TestSocialMedia class does not print the correct output.");
    }
}
