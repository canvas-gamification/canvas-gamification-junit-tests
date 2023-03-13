package oop.user_defined_classes.medium.q1;

import global.ObjectTest;
import global.variables.clauses.RandomInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {
    // Parsons with distractors

    // Constants for Variation
    private final String className = "Circle";
    private final String intFieldName = "position";
    private final String stringFieldName = "colour";
    private final String methodName = "moveLocation";
    private final int lowerRandomBound = 0;
    private final int upperRandomBound = 100;
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String classString = "oop.user_defined_classes.medium.q1." + className;
        classInstance = new ObjectTest(classString);
    }

    @Test
    public void circleClassHasCorrectFields() {
        assertTrue(classInstance.hasField(intFieldName, int.class),
                "Your " + className + " class does not have the correct " + intFieldName + " field."
        );
        assertTrue(classInstance.hasModifier(intFieldName, "private"),
                "Your " + intFieldName + " field does not have the correct visibility modifier.");
        assertTrue(classInstance.hasField(stringFieldName, String.class),
                "Your " + className + " class does not have the correct " + stringFieldName + " field.");
        assertTrue(classInstance.hasModifier(stringFieldName, "private"),
                "Your " + stringFieldName + " field does not have the correct visibility modifier.");
    }

    @Test
    public void circleClassHasCorrectConstructor() {
        Class<?>[] arguments = {
                int.class, String.class
        };
        assertTrue(classInstance.hasConstructor(arguments),
                "Your " + className + " class is missing a required constructor.");
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(5, "Red"),
                Arguments.of(-1, "Mario time!"),
                Arguments.of(93828, "One stringy boi is what this is.    :)"),
                Arguments.of(223333222, "344124124")
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void circleConstructorInitializesObjectCorrectly(int number, String string) throws Throwable {
        Object[][] arguments = {
                {number, int.class},
                {string, String.class}
        };
        Object instance = classInstance.createInstance(arguments);
        _assertEquals(number, classInstance.getFieldValue(instance, intFieldName),
                "Your " + className + " constructor does not correctly initialize the " + intFieldName + " field.");
        _assertEquals(string, classInstance.getFieldValue(instance, stringFieldName),
                "Your " + className + " constructor does not correctly initialize the " + stringFieldName + " field.");
    }

    @Test
    public void correctMoveLocationMethod() throws Throwable {
        Object[][] arguments = {
                {0, int.class},
                {"string", String.class}
        };
        Object instance = classInstance.createInstance(arguments);
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < 1000; i ++) {
            classInstance.callMethod(methodName, instance);
            Object fieldValue = classInstance.getFieldValue(instance, intFieldName);
            if (fieldValue instanceof Integer)
                values.add((Integer) fieldValue);
            else
                fail("Your " + intFieldName + " field is not the correct type.");
        }
        RandomInteger randomInteger = new RandomInteger(lowerRandomBound, upperRandomBound);
        assertTrue(randomInteger.validateRandom(values),
                "Your " + methodName + " method does randomly set the " + intFieldName + " field.");
    }
}
