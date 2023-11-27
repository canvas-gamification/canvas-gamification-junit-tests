package oop.static_modifier.medium.q6;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    ObjectTest testClass;
    String className = "TextProcessing";
    String methodName1 = "canadianize";
    String methodName2 = "extractVowels";

    @BeforeEach
    public void setup() throws Throwable {
        String classString = "oop.static_modifier.medium.q6." + className;
        testClass = new ObjectTest(classString);
    }

    private static Stream<Arguments> inputProvider1() {
        return Stream.of(
                Arguments.of("Black", "Black, eh?"),
                Arguments.of("Blue", "Blue, eh?"),
                Arguments.of("Red","Red, eh?"),
                Arguments.of("Brown", "Brown, eh?"),
                Arguments.of("Hello there", "Hello there, eh?"),
                Arguments.of("It is hot", "It is hot, eh?"),
                Arguments.of("How is the weather", "How is the weather, eh?"),
                Arguments.of("How's your day?", "How's your day?, eh?")
        );
    }

    private static Stream<Arguments> inputProvider2() {
        return Stream.of(
                Arguments.of("Black", "Blck"),
                Arguments.of("Blue", "Bl"),
                Arguments.of("Red","Rd"),
                Arguments.of("Brown", "Brwn"),
                Arguments.of("Hello there", "Hll thr"),
                Arguments.of("It is hot", "It s ht"),
                Arguments.of("How is the weather", "Hw s th wthr"),
                Arguments.of("How's your day?", "Hw's yr dy?")
        );
    }

    @Test
    public void canadianizeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName1, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, methodName1, className));
        assertTrue(testClass.hasModifier(methodName1, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, methodName1, className));
        assertTrue(testClass.hasReturnType(methodName1, new Class<?>[]{String.class}, String.class), String.format(incorrectReturnType, methodName1, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider1")
    public void correctCanadianizeMethod(String text, String ans) throws Throwable {
        Object classInstance = testClass.createInstance();
        String[] methodModifiers = {"public", "static"};
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName1, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, methodName1, className));
        assertTrue(testClass.hasModifier(methodName1, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, methodName1, className));
        assertTrue(testClass.hasReturnType(methodName1, new Class<?>[]{String.class}, String.class), String.format(incorrectReturnType, methodName1, className));
        String incorrectToStringMessage = String.join(" ",
                "Your", className, methodName1, "method does not return the original String with the modified ending.");
        Object output = testClass.callMethod(methodName1, new Object[][]{{text, String.class}}, methodModifiers, classInstance);
        _assertEquals(ans, output, incorrectToStringMessage);
    }

    @Test
    public void extractVowelsIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName2, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, methodName2, className));
        assertTrue(testClass.hasModifier(methodName2, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, methodName2, className));
        assertTrue(testClass.hasReturnType(methodName2, new Class<?>[]{String.class}, String.class), String.format(incorrectReturnType, methodName2, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider2")
    public void correctExtractVowelsMethod(String text, String ans) throws Throwable {
        Object classInstance = testClass.createInstance();
        String[] methodModifiers = {"public", "static"};
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName2, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, methodName2, className));
        assertTrue(testClass.hasModifier(methodName2, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, methodName2, className));
        assertTrue(testClass.hasReturnType(methodName2, new Class<?>[]{String.class}, String.class), String.format(incorrectReturnType, methodName2, className));
        String incorrectToStringMessage = String.join(" ",
                "Your", className, methodName2, "method does not return the original String with the vowels extracted.");
        Object output = testClass.callMethod(methodName2, new Object[][]{{text, String.class}}, methodModifiers, classInstance);
        _assertEquals(ans, output, incorrectToStringMessage);
    }

}
