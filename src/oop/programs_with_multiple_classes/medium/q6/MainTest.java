package oop.programs_with_multiple_classes.medium.q6;

import global.BaseTest;
import global.ObjectTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import oop.programs_with_multiple_classes.medium.q2.TestRoom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons
    public ObjectTest vegetable;
    public ObjectTest cupboard;

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @BeforeEach
    public void setup() {
        String vegetableClassString = "oop.programs_with_multiple_classes.medium.q6.Vegetable";
        String cupboardClassString = "oop.programs_with_multiple_classes.medium.q6.Cupboard";
        vegetable = new ObjectTest(vegetableClassString);
        cupboard = new ObjectTest(cupboardClassString);
    }

    @Test
    public void vegetableClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Vegetable class is missing a required field.";
        String incorrectModifierMessage = "One of your Vegetable class attributes does not have the correct modifier.";
        assertTrue(vegetable.hasField("isSpoiled", boolean.class), incorrectFieldMessage);
        assertTrue(vegetable.hasModifier("isSpoiled", "private"), incorrectModifierMessage);
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Cupboard class is missing a required field.";
        String incorrectModifierMessage = "One of your Cupboard class attributes does not have the correct modifier.";
        assertTrue(cupboard.hasField("size", int.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier("size", "private"), incorrectModifierMessage);
    }

    @Test
    public void vegetableClassHasRequiredConstructor() {
        Class<?>[] classArguments = {boolean.class};
        assertTrue(vegetable.hasConstructor(classArguments),
                "Your Vegetable constructor does not have the correct parameters.");
        assertTrue(vegetable.hasModifier(classArguments, "public"),
                "Your Vegetable constructor does not have the correct modifier.");
    }

    @Test
    public void cupboardCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class};
        assertTrue(cupboard.hasConstructor(classArguments),
                "Your Cupboard constructor does not have the correct parameters.");
        assertTrue(cupboard.hasModifier(classArguments, "public"),
                "Your Cupboard constructor does not have the correct modifier.");
    }

    private static Stream<Arguments> vegetableInputProvider() {
        return Stream.of(
                Arguments.of(true),
                Arguments.of(false),
                Arguments.of(true),
                Arguments.of(false)
        );
    }

    @ParameterizedTest
    @MethodSource("vegetableInputProvider")
    public void vegetableConstructorInitializesValuesCorrectly(boolean isSpoiled) throws Throwable {
        Object[][] arguments = {
                {isSpoiled, boolean.class}
        };
        Object vegetableInstance = vegetable.createInstance(arguments);
        _assertEquals(isSpoiled, vegetable.getFieldValue(vegetableInstance, "isSpoiled"),
                "Your Vegetable constructor does not correctly initialize the isSpoiled field.");
    }

    @ParameterizedTest
    @MethodSource("vegetableInputProvider")
    public void correctVegetableToStringMethod(boolean isSpoiled) throws Throwable {
        Object[][] arguments = {
                {isSpoiled, boolean.class}
        };
        Object vegetableInstance = vegetable.createInstance(arguments);
        Object vegetableToStringOutput = vegetable.callMethod("toString", vegetableInstance);
        String ans = "Vegetable{isSpoiled = " + isSpoiled + "}";
        _assertEquals(ans, vegetableToStringOutput, "Your Vegetable toString method does not return the correct string.");
    }

    @ParameterizedTest
    @MethodSource("vegetableInputProvider")
    public void correctVegetableTimePassedMethod(boolean isSpoiled) throws Throwable {
        Object[][] arguments = {
                {isSpoiled, boolean.class}
        };
        Object vegetableInstance = vegetable.createInstance(arguments);
        vegetable.callMethod("timePassed", vegetableInstance);
        _assertEquals(true, vegetable.getFieldValue(vegetableInstance, "isSpoiled"),
                "Your Vegetable timePassed method does not change the isSpoiled value to true.");
    }


    private static Stream<Arguments> cupboardInputProvider() {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(20),
                Arguments.of(150)
        );
    }

    @ParameterizedTest
    @MethodSource("cupboardInputProvider")
    public void cupboardConstructorInitializesValuesCorrectly(int size) throws Throwable {
        Object[][] arguments = {
                {size, int.class}
        };
        Object tableInstance = cupboard.createInstance(arguments);
        _assertEquals(size, cupboard.getFieldValue(tableInstance, "size"),
                "Your Cupboard constructor does not correctly initialize the size field.");
    }

    @ParameterizedTest
    @MethodSource("cupboardInputProvider")
    public void correctPillowToStringMethod(int size) throws Throwable {
        Object[][] arguments = {
                {size, int.class}
        };
        Object cupboardInstance = cupboard.createInstance(arguments);
        Object cupboardToStringOutput = cupboard.callMethod("toString", cupboardInstance);
        String ans = "Cupboard{size = " + size + "}";
        _assertEquals(ans, cupboardToStringOutput, "Your Cupboard toString method does not return the correct string.");
    }

}