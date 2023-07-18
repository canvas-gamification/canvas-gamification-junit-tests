package oop.static_modifier.medium.q6;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    ObjectTest testClass;
    String className = "TextProcessing";
    String methodName1 = "canadianize";
    String methodName2 = "extractVowels";

    public String f1(String s) {
        return s + ", eh?";
    }

    public String f2(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
                str += ch;
        }
        return str;
    }

    @BeforeEach
    public void setup() throws Throwable {
        String classString = "oop.static_modifier.medium.q6." + className;
        testClass = new ObjectTest(classString);
    }

    private static Stream<String> inputProvider() {
        return Stream.of(
                "Black", "Blue", "Red", "Brown", "Hello there", "It is hot", "How is the weather", "How's your day?"
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctCanadianizeMethod(String text) throws Throwable {
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
        _assertEquals(f1(text), output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctExtractVowelsMethod(String text) throws Throwable {
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
        _assertEquals(f2(text), output, incorrectToStringMessage);
    }

}
