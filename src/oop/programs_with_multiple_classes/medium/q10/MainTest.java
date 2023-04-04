package oop.programs_with_multiple_classes.medium.q10;

import global.BaseTest;
import global.ObjectTest;
import global.variables.Clause;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons with Distractors
    public ObjectTest vegetable;
    public ObjectTest cupboard;

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @BeforeEach
    public void setup() {
        String vegetableClassString = "oop.programs_with_multiple_classes.medium.q10.Vegetable";
        String cupboardClassString = "oop.programs_with_multiple_classes.medium.q10.Cupboard";
        vegetable = new ObjectTest(vegetableClassString);
        cupboard = new ObjectTest(cupboardClassString);
    }

    @Test
    public void vegetableClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Vegetable class is missing a required field.";
        String incorrectModifierMessage = "One of your Vegetable class attributes does not have the correct modifier.";
        assertTrue(vegetable.hasField("isSpoiled", boolean.class), incorrectFieldMessage);
        assertTrue(vegetable.hasModifier("isSpoiled", "private"), incorrectModifierMessage);
        assertTrue(vegetable.hasField("weight", double.class), incorrectFieldMessage);
        assertTrue(vegetable.hasModifier("weight", "private"), incorrectModifierMessage);
        assertTrue(vegetable.hasField("countryOfOrigin", String.class), incorrectFieldMessage);
        assertTrue(vegetable.hasModifier("countryOfOrigin", "private"), incorrectModifierMessage);
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Cupboard class is missing a required field.";
        String incorrectModifierMessage = "One of your Cupboard class attributes does not have the correct modifier.";
        assertTrue(cupboard.hasField("size", int.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier("size", "private"), incorrectModifierMessage);
        assertTrue(cupboard.hasField("colour", String.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier("colour", "private"), incorrectModifierMessage);
    }

    @Test
    public void vegetableClassHasRequiredConstructor() {
        Class<?>[] classArguments = {boolean.class, double.class, String.class};
        assertTrue(vegetable.hasConstructor(classArguments),
                "Your Vegetable constructor does not have the correct parameters.");
        assertTrue(vegetable.hasModifier(classArguments, "public"),
                "Your Vegetable constructor does not have the correct modifier.");
    }

    @Test
    public void cupboardCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(cupboard.hasConstructor(classArguments),
                "Your Cupboard constructor does not have the correct parameters.");
        assertTrue(cupboard.hasModifier(classArguments, "public"),
                "Your Cupboard constructor does not have the correct modifier.");
    }

    private static Stream<Arguments> vegetableInputProvider() {
        return Stream.of(
                Arguments.of(true, 20.0, "Canada"),
                Arguments.of(false, 2.0, "USA"),
                Arguments.of(true, 3.5, "Russia"),
                Arguments.of(false, 5.5, "China")
        );
    }

    @ParameterizedTest
    @MethodSource("vegetableInputProvider")
    public void vegetableConstructorInitializesValuesCorrectly(boolean isSpoiled, double weight, String countryOfOrigin) throws Throwable {
        Object[][] arguments = {
                {isSpoiled, boolean.class},
                {weight, double.class},
                {countryOfOrigin, String.class}
        };
        Object vegetableInstance = vegetable.createInstance(arguments);
        _assertEquals(isSpoiled, vegetable.getFieldValue(vegetableInstance, "isSpoiled"),
                "Your Vegetable constructor does not correctly initialize the isSpoiled field.");
        _assertEquals(weight, vegetable.getFieldValue(vegetableInstance, "weight"),
                "Your Vegetable constructor does not correctly initialize the weight field.");
        _assertEquals(countryOfOrigin, vegetable.getFieldValue(vegetableInstance, "countryOfOrigin"),
                "Your Vegetable constructor does not correctly initialize the countryOfOrigin field.");
    }

    @ParameterizedTest
    @MethodSource("vegetableInputProvider")
    public void correctVegetableToStringMethod(boolean isSpoiled, double weight, String countryOfOrigin) throws Throwable {
        Object[][] arguments = {
                {isSpoiled, boolean.class},
                {weight, double.class},
                {countryOfOrigin, String.class}
        };
        Object vegetableInstance = vegetable.createInstance(arguments);
        Object vegetableToStringOutput = vegetable.callMethod("toString", vegetableInstance);
        String ans = "Vegetable{isSpoiled = " + isSpoiled + ", weight = " + weight + ", countryOfOrigin = " + countryOfOrigin + "}";
        _assertEquals(ans, vegetableToStringOutput, "Your Vegetable toString method does not return the correct string.");
    }

    @ParameterizedTest
    @MethodSource("vegetableInputProvider")
    public void correctVegetableEatingMethod(boolean isSpoiled, double weight, String countryOfOrigin) throws Throwable {
        Object[][] arguments = {
                {isSpoiled, boolean.class},
                {weight, double.class},
                {countryOfOrigin, String.class}
        };
        Object vegetableInstance = vegetable.createInstance(arguments);
        vegetable.callMethod("eating", vegetableInstance);
        _assertEquals(weight - 0.5, vegetable.getFieldValue(vegetableInstance, "weight"),
                "Your Vegetable eating method does not decrement the weight by 0.5.");
    }


    private static Stream<Arguments> cupboardInputProvider() {
        return Stream.of(
                Arguments.of(10, "Red"),
                Arguments.of(20, "Black"),
                Arguments.of(150, "Green")
        );
    }

    @ParameterizedTest
    @MethodSource("cupboardInputProvider")
    public void cupboardConstructorInitializesValuesCorrectly(int size, String colour) throws Throwable {
        Object[][] arguments = {
                {size, int.class},
                {colour, String.class}
        };
        Object tableInstance = cupboard.createInstance(arguments);
        _assertEquals(size, cupboard.getFieldValue(tableInstance, "size"),
                "Your Cupboard constructor does not correctly initialize the size field.");
        _assertEquals(colour, cupboard.getFieldValue(tableInstance, "colour"),
                "Your Cupboard constructor does not correctly initialize the colour field.");
    }

    @ParameterizedTest
    @MethodSource("cupboardInputProvider")
    public void correctPillowToStringMethod(int size, String colour) throws Throwable {
        Object[][] arguments = {
                {size, int.class},
                {colour, String.class}
        };
        Object cupboardInstance = cupboard.createInstance(arguments);
        Object cupboardToStringOutput = cupboard.callMethod("toString", cupboardInstance);
        String ans = "Cupboard{size = " + size + ", colour = " + colour + "}";
        _assertEquals(ans, cupboardToStringOutput, "Your Cupboard toString method does not return the correct string.");
    }

}
