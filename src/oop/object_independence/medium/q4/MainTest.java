package oop.object_independence.medium.q4;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    // Java
    private final String className = "PortableMusicPlayer";
    private ObjectTest testClass;
    private final String firstFieldName = "playlist";
    private final String secondFieldName = "current";
    private final String firstMethod = "play";
    private final String secondMethod = "playNext";
    private final String thirdMethod = "playPrev";

    @BeforeEach
    public void setUp() {
        String bankString = "oop.object_independence.medium.q4." + className;
        testClass = new ObjectTest(bankString);
    }

    @Test
    public void portableMusicPlayerClassHasRequiredFields() {
        assertTrue(testClass.hasField(firstFieldName, String[].class),
                "Your " + className + " class is missing the " + firstFieldName + " attribute.");
        assertTrue(testClass.hasModifier(firstFieldName, "private"),
                "Your " + firstFieldName + " attribute does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(secondFieldName, int.class),
                "Your " + className + " class is missing the " + secondFieldName + " attribute.");
        assertTrue(testClass.hasModifier(secondFieldName, "private"),
                "Your " + secondFieldName + " attribute does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"Pineapple Juice", "Coconut Milk"}),
                Arguments.of((Object) new String[]{"Music1", "Music2"}),
                Arguments.of((Object) new String[]{"Ginger Beer", "Lime", "Vodka"}),
                Arguments.of((Object) new String[]{"Rum", "StrawBerry", "Syrup"}),
                Arguments.of((Object) new String[]{"Pink Floyd", "Metallica"}),
                Arguments.of((Object) new String[]{"Pop", "Rap"})
        );
    }

    @Test
    public void portableMusicPlayerClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String[].class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void portableMusicPlayerClassHasCorrectConstructor(String[] value) throws Throwable {
        Object[][] arguments = {
                {value, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertArrayEquals(value, testClass.getFieldValue(classInstance, firstFieldName),
                "Your " + className + " constructor does not correctly initialize the " + firstFieldName + " attribute.");
        _assertEquals(0, testClass.getFieldValue(classInstance, secondFieldName),
                "Your " + className + " constructor does not correctly initialize the " + secondFieldName + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void portableMusicPlayerClassHasCorrectPlayMethod(String[] value) throws Throwable {
        Object[][] arguments = {
                {value, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        int current = (int) testClass.getFieldValue(classInstance, secondFieldName);
        Object output = testClass.callMethod(firstMethod, methodModifiers, classInstance, new Clause[]{
                        new StringLiteral("Now Playing : " + value[current])
                },
                String.join(" ", "Your", firstMethod, "method does not print the correct output."));
        assertNull(output, String.join(" ", "Your", firstMethod, "method should not return any output"));
        _assertEquals(current, testClass.getFieldValue(classInstance, secondFieldName),
                String.join(" ", "Your", firstMethod, "method should not alter the", secondFieldName, "attribute"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void portableMusicPlayerClassHasCorrectPlayNextMethod(String[] value) throws Throwable {
        Object[][] arguments = {
                {value, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        int current = (int) testClass.getFieldValue(classInstance, secondFieldName);
        Object output = testClass.callMethod(secondMethod, methodModifiers, classInstance, new Clause[]{
                        new StringLiteral("Now Playing : " + value[(current + 1) % value.length])
                },
                String.join(" ", "Your", firstMethod, "method does not print the correct output."));
        assertNull(output, String.join(" ", "Your", firstMethod, "method should not return any output"));
        _assertEquals((current + 1) % value.length, testClass.getFieldValue(classInstance, secondFieldName),
                String.join(" ", "Your", firstMethod, "method does not increase the", secondFieldName, "attribute"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void portableMusicPlayerClassHasCorrectPlayPrevMethod(String[] value) throws Throwable {
        Object[][] arguments = {
                {value, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        int current = (int) testClass.getFieldValue(classInstance, secondFieldName);
        Object output = testClass.callMethod(thirdMethod, methodModifiers, classInstance, new Clause[]{
                        new StringLiteral("Now Playing : " + value[(current - 1 + value.length) % value.length])
                },
                String.join(" ", "Your", firstMethod, "method does not print the correct output."));
        assertNull(output, String.join(" ", "Your", firstMethod, "method should not return any output"));
        _assertEquals((current - 1 + value.length) % value.length, testClass.getFieldValue(classInstance, secondFieldName),
                String.join(" ", "Your", firstMethod, "method does not decrease the", secondFieldName, "attribute"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void carClassMethodsWorkTogether(String[] value) throws Throwable {
        Object[][] arguments = {
                {value, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        int current = (int) testClass.getFieldValue(classInstance, secondFieldName);
        Object output = testClass.callMethod(firstMethod, methodModifiers, classInstance, new Clause[]{
                        new StringLiteral("Now Playing : " + value[current])
                },
                String.join(" ", "Your", firstMethod, "method does not print the correct output."));
        assertNull(output, String.join(" ", "Your", firstMethod, "method should not return any output"));
        _assertEquals(current, testClass.getFieldValue(classInstance, secondFieldName),
                String.join(" ", "Your", firstMethod, "method should not alter the", secondFieldName, "attribute"));
        for (int i = 0; i < value.length; i++) {
            current = (int) testClass.getFieldValue(classInstance, secondFieldName);
            output = testClass.callMethod(secondMethod, methodModifiers, classInstance, new Clause[]{
                            new StringLiteral("Now Playing : " + value[(current + 1) % value.length])
                    },
                    String.join(" ", "Your", firstMethod, "method does not print the correct output."));
            assertNull(output, String.join(" ", "Your", firstMethod, "method should not return any output"));
            _assertEquals((current + 1) % value.length, testClass.getFieldValue(classInstance, secondFieldName),
                    String.join(" ", "Your", firstMethod, "method does not increase the", secondFieldName, "attribute"));
        }
        for (int i = 0; i < value.length / 2; i++) {
            current = (int) testClass.getFieldValue(classInstance, secondFieldName);
            output = testClass.callMethod(thirdMethod, methodModifiers, classInstance, new Clause[]{
                            new StringLiteral("Now Playing : " + value[(current - 1 + value.length) % value.length])
                    },
                    String.join(" ", "Your", firstMethod, "method does not print the correct output."));
            assertNull(output, String.join(" ", "Your", firstMethod, "method should not return any output"));
            _assertEquals((current - 1 + value.length) % value.length, testClass.getFieldValue(classInstance, secondFieldName),
                    String.join(" ", "Your", firstMethod, "method does not decrease the", secondFieldName, "attribute"));
        }
        current = (int) testClass.getFieldValue(classInstance, secondFieldName);
        output = testClass.callMethod(firstMethod, methodModifiers, classInstance, new Clause[]{
                        new StringLiteral("Now Playing : " + value[current])
                },
                String.join(" ", "Your", firstMethod, "method does not print the correct output."));
        assertNull(output, String.join(" ", "Your", firstMethod, "method should not return any output"));
        _assertEquals(current, testClass.getFieldValue(classInstance, secondFieldName),
                String.join(" ", "Your", firstMethod, "method should not alter the", secondFieldName, "attribute"));
    }

}
