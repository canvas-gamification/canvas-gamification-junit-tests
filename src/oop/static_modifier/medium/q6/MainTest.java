package oop.static_modifier.medium.q6;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
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

    @ParameterizedTest
    @MethodSource("inputProvider1")
    public void correctCanadianizeMethod(String text, String ans) throws Throwable {
        Object classInstance = testClass.createInstance();
        String[] methodModifiers = {"public", "static"};
        assertTrue(testClass.hasMethod(methodName1, new Class<?>[]{String.class}),
                "Your " + className + " class does not have a " + methodName1 + " method.");
        assertTrue(testClass.hasMethod(methodName1, new Class<?>[]{String.class}, String.class),
                "Your " + methodName1 + " method does not have the correct return type.");
        assertTrue(testClass.hasMethod(methodName1, new Class<?>[]{String.class}, String.class, new String[]{"public"}),
                "Your " + methodName1 + " method does not have the correct visibility modifier.");
        assertTrue(testClass.hasMethod(methodName1, new Class<?>[]{String.class}, String.class, new String[]{"public", "static"}),
                "Your " + methodName1 + " method does not have a static modifier.");
        String incorrectToStringMessage = String.join(" ",
                "Your", className, methodName1, "method does not return the correct String.");
        Object output = testClass.callMethod(methodName1, new Object[][]{{text, String.class}}, methodModifiers, classInstance);
        _assertEquals(ans, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider2")
    public void correctExtractVowelsMethod(String text, String ans) throws Throwable {
        Object classInstance = testClass.createInstance();
        String[] methodModifiers = {"public", "static"};
        assertTrue(testClass.hasMethod(methodName2, new Class<?>[]{String.class}),
                "Your " + className + " class does not have a " + methodName2 + " method.");
        assertTrue(testClass.hasMethod(methodName2, new Class<?>[]{String.class}, String.class),
                "Your " + methodName2 + " method does not have the correct return type.");
        assertTrue(testClass.hasMethod(methodName2, new Class<?>[]{String.class}, String.class, new String[]{"public"}),
                "Your " + methodName2 + " method does not have the correct visibility modifier.");
        assertTrue(testClass.hasMethod(methodName2, new Class<?>[]{String.class}, String.class, new String[]{"public", "static"}),
                "Your " + methodName2 + " method does not have a static modifier.");
        String incorrectToStringMessage = String.join(" ",
                "Your", className, methodName2, "method does not return the correct String.");
        Object output = testClass.callMethod(methodName2, new Object[][]{{text, String.class}}, methodModifiers, classInstance);
        _assertEquals(ans, output, incorrectToStringMessage);
    }

}
