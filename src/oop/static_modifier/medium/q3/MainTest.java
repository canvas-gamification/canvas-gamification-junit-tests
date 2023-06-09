package oop.static_modifier.medium.q3;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest classInstance;
    private ObjectTest testInstance;
    private final String objectName = "Horse";
    private final String testName = "TestAnimal";
    private final String stringAttribute1 = "noise";
    private final String stringAttribute2 = "name";
    private final String methodName1 = "lengthenSound";
    private final String methodName2 = "shortenSound";
    private final String startNoise = "Neigh!";
    private final int repetitionAmount = 4;
    private final String testName1 = "Marly";
    private final String testName2 = "Darling";

    @BeforeEach
    public void setup() {
        String classPath = "oop.static_modifier.medium.q3." + objectName;
        classInstance = new ObjectTest(classPath);
        String testPath = "oop.static_modifier.medium.q3." + testName;
        testInstance = new ObjectTest(testPath);
    }

    @Test
    public void horseClassHasRequiredAttributes() {
        assertTrue(classInstance.hasField(stringAttribute1, String.class),
                String.format("Your %s class is missing the %s field. Please make sure that is is spelt correctly and has the correct type.", objectName, stringAttribute1));
        assertTrue(classInstance.hasField(stringAttribute2, String.class),
                String.format("Your %s class is missing the %s field. Please make sure that is is spelt correctly, has the correct type, and has the correct visibility modifier.", objectName, stringAttribute2));
        assertTrue(classInstance.hasModifier(stringAttribute1, "private"),
                String.format("Your %s field does not have the correct visibility modifier.", stringAttribute1));
        assertTrue(classInstance.hasModifier(stringAttribute1, "static"),
                String.format("Your %s field is missing the static modifier.", stringAttribute1));
        assertTrue(classInstance.hasModifier(stringAttribute2, "private"),
                String.format("Your %s field does not have the correct visibility modifier.", stringAttribute2));
    }

    private static Stream<String> constructorInputProvider() {
        return Stream.of("Mary", "Jane", "Jeremy");
    }
    
    @Test
    public void horseClassHasCorrectConstructor() throws Throwable {
        Class<?>[] arguments = {String.class};
        assertTrue(classInstance.hasConstructor(arguments),
                String.format("Your %s class is missing a required constructor.", objectName));
        assertTrue(classInstance.hasConstructor(arguments, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", objectName));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void horseConstructorInitializesAttributesCorrectly(String n) throws Throwable {
        Object[][] arguments = {
                {n, String.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeValue =
                "Your %s constructor does not correctly initialize the %s attribute based on the passed parameters.";
        _assertEquals(n, classInstance.getFieldValue(instance, stringAttribute2),
                String.format(incorrectAttributeValue, objectName, stringAttribute2));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void horseClassHasCorrectToStringMethod(String name) throws Throwable {
        classInstance.setFieldValue(null, startNoise, stringAttribute1);
        Object[][] arguments = {
                {name, String.class},
        };
        Object instance = classInstance.createInstance(arguments);
        String expectedOutput = name + " calls out " + startNoise;
        Object output = classInstance.callMethod("toString", new String[]{"public"}, instance);
        String incorrectToString = String.format("Your toString method for the %s class does return the correct String.", objectName);
        _assertEquals(expectedOutput, output, incorrectToString);
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(1, 0, "Neigh!", "e"),
                Arguments.of(0, 1, "Mooo!", "o"),
                Arguments.of(1, 1, "Honk!!!", "o"),
                Arguments.of(2, 1, "Squack", "u"),
                Arguments.of(1, 2, "cheep cheep", "e"),
                Arguments.of(10, 4, "maah", "a"),
                Arguments.of(6, 19, "blip", "i")
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void horseClassHasCorrectLengthenSoundMethod(int one, int two, String noise, String vowel) throws Throwable {
        classInstance.setFieldValue(null, noise, stringAttribute1);
        StringBuilder series = new StringBuilder();
        series.append(vowel.repeat(repetitionAmount));

        for(int x = 0; x < one; x ++){
            series.append(vowel.repeat(repetitionAmount));
            classInstance.callMethod(methodName1);
        }

        String newNoise = noise.substring(0, noise.indexOf(vowel)) + series + noise.substring(noise.indexOf(vowel));
        _assertEquals(newNoise, classInstance.getFieldValue(null, stringAttribute1),
                String.format("Your %s method does not properly alter the %s attribute.", methodName1, stringAttribute1));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void horseClassHasCorrectShortenSoundMethod(int one, int two, String noise, String vowel) throws Throwable {
        StringBuilder series = new StringBuilder();
        for(int x = 0; x < Math.random()*50 + repetitionAmount; x++) {
            series.append(vowel);
        }
        String substring = noise.substring(0, noise.indexOf(vowel));
        String longNoise = substring + series + noise.substring(noise.indexOf(vowel));
        classInstance.setFieldValue(null, longNoise, stringAttribute1);

        series.delete(0, series.length());
        series.append(vowel.repeat(repetitionAmount+1));

        for(int x = 0; x < two; x ++) {
            classInstance.callMethod(methodName2);
            if (longNoise.contains(series)) {
                longNoise = substring + longNoise.substring(longNoise.indexOf(vowel) + repetitionAmount);
            }
        }

        _assertEquals(longNoise, classInstance.getFieldValue(null, stringAttribute1),
                String.format("Your %s method does not properly alter the %s attribute.", methodName2, stringAttribute1));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void horseMethodsWorkCorrectlyWorkTogether(int one, int two, String noise, String vowel){

    }

//    @ParameterizedTest
//    @MethodSource("countInputProvider")
//    public void laptopClassHasCorrectIncrementerMethod(int n) throws Throwable {
//        Object instance = classInstance.createInstance();
//        classInstance.setFieldValue(null, n, stringAttribute2);
//        Object output = classInstance.callMethod(methodName, instance);
//        _assertEquals(n + repetitionAmount, classInstance.getFieldValue(null, stringAttribute2),
//                String.format("Your %s method does not correctly increment the value of the %s attribute.", methodName, stringAttribute2));
//        _assertEquals(n + repetitionAmount, output,
//                String.format("Your %s method does not return the correct value of the %s attribute.", methodName, stringAttribute2));
//    }

    @Test
    public void testPlatformGameMainMethodProducesCorrectOutput() throws Throwable {
        classInstance.setFieldValue(null, startNoise, stringAttribute2);
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral("The first laptop id is "),
                new IntegerLiteral(startNoise + repetitionAmount),
                new NewLine(),
                new StringLiteral("The second laptop id is "),
                new IntegerLiteral(startNoise + (repetitionAmount * 2))
        };
        String incorrectOutput =
                String.format("Your %s class main method does correctly initialize and print the values of the two %s objects.", testName, objectName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
