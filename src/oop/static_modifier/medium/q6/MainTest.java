package oop.static_modifier.medium.q6;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    ObjectTest testClass;
    String className = "TextProcessing";
    String methodName1 = "localize";
    String methodName2 = "extractLocalizations";
    String attributeName = "text";
    String staticAttributeName = "indicator";
    String initial = ", eh";

    @BeforeEach
    public void setup() throws Throwable {
        String classString = "oop.static_modifier.medium.q6." + className;
        testClass = new ObjectTest(classString);

        String modificationErrorMessage = "You have modified the provided portions of " + className + " class for %s attribute. Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName, String.class),
                String.format(modificationErrorMessage, attributeName));
        assertTrue(testClass.hasModifier(attributeName, "private"),
                String.format(modificationErrorMessage, attributeName));
        String[] test = new String[]{
                "You're a master of matchbox guitar sessions",
                "You're a master of passive aggressive magic tricks",
                "like that's not the card that i would have picked",
                "but it's you're life to live like how you'd like to live"
        };
        for (int i = 0; i < test.length; i++) {
            Object[][] arguments = {
                    {test[i], String.class}
            };
            Object classInstance = testClass.createInstance(arguments);
            _assertEquals(test[i], testClass.getFieldValue(classInstance, attributeName),
                    String.format(modificationErrorMessage, attributeName));
        }
    }

    private static Stream<Arguments> inputProvider1() {
        return Stream.of(
                Arguments.of("Black", "Black, eh"),
                Arguments.of("Blue", "Blue, eh"),
                Arguments.of("Red","Red, eh"),
                Arguments.of("Brown", "Brown, eh"),
                Arguments.of("Hello there", "Hello there, eh"),
                Arguments.of("It is hot", "It is hot, eh"),
                Arguments.of("How is the weather", "How is the weather, eh"),
                Arguments.of("How's your day?", "How's your day?, eh")
        );
    }

    private static Stream<Arguments> inputProvider2() {
        return Stream.of(
                Arguments.of("Sure, eh Black", "Sure Black"),
                Arguments.of(", eh", ""),
                Arguments.of("hello there", "hello there"),
                Arguments.of("eh macarena, eh", "eh macarena"),
                Arguments.of("do I, eh Make you wanna, eh", "do I Make you wanna")
        );
    }

    @Test
    public void textProcessingClassHasCorrectAttributes() {
        String incorrectNameError = "Your %s class does not include the %s attribute.";
        String incorrectVisibilityError = "Your %s attribute does not have the correct visibility modifier.";
        String incorrectStaticError = "Your %s attribute does not have the static modifier.";
        String incorrectStaticInitialization = "Your %s attribute does not have the correct value";
        assertTrue(testClass.hasField(staticAttributeName, String.class),
                String.format(incorrectNameError, className, staticAttributeName));
        assertTrue(testClass.hasModifier(staticAttributeName, "private"),
                String.format(incorrectVisibilityError, staticAttributeName));
        assertTrue(testClass.hasModifier(staticAttributeName, "static"),
                String.format(incorrectStaticError, staticAttributeName));

        assertEquals(initial, testClass.getFieldValue(null, staticAttributeName),
                String.format(incorrectStaticInitialization, staticAttributeName));
    }

    @Test
    public void localizeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName1, null), String.format(incorrectMethodDefinition, methodName1, className));
        assertTrue(testClass.hasModifier(methodName1, null, "public"), String.format(incorrectModifierMessage, methodName1, className));
        assertTrue(testClass.hasReturnType(methodName1, null, String.class), String.format(incorrectReturnType, methodName1, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider1")
    public void correctLocalizeMethod(String text, String ans) throws Throwable {
        Object[][] arguments = {
                {text, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName1, null), String.format(incorrectMethodDefinition, methodName1, className));
        assertTrue(testClass.hasModifier(methodName1, null, "public"), String.format(incorrectModifierMessage, methodName1, className));
        assertTrue(testClass.hasReturnType(methodName1, null, String.class), String.format(incorrectReturnType, methodName1, className));
        String incorrectToStringMessage = String.join(" ",
                "Your", className, methodName1, "method does not correctly modify the end of the text.");
        Object output = testClass.callMethod(methodName1, null, methodModifiers, classInstance);
        _assertEquals(ans, output, incorrectToStringMessage);
    }

    @Test
    public void extractLocalizationsIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName2, null), String.format(incorrectMethodDefinition, methodName2, className));
        assertTrue(testClass.hasModifier(methodName2, null, "public"), String.format(incorrectModifierMessage, methodName2, className));
        assertTrue(testClass.hasReturnType(methodName2, null, String.class), String.format(incorrectReturnType, methodName2, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider2")
    public void correctExtractLocalizationsMethod(String text, String ans) throws Throwable {
        Object[][] arguments = {
                {text, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName2, null), String.format(incorrectMethodDefinition, methodName2, className));
        assertTrue(testClass.hasModifier(methodName2, null, "public"), String.format(incorrectModifierMessage, methodName2, className));
        assertTrue(testClass.hasReturnType(methodName2, null, String.class), String.format(incorrectReturnType, methodName2, className));
        String incorrectToStringMessage = String.join(" ",
                "Your", className, methodName2, "method does not return the text with localizations extracted.");
        Object output = testClass.callMethod(methodName2, null, methodModifiers, classInstance);
        _assertEquals(ans, output, incorrectToStringMessage);
    }

}
