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

    private final String classVegtable = "Vegetable";
    private final String classCupboard = "Cupboard";
    private final String varSpoiled = "isSpoiled";
    private final String varWeight = "weight";
    private final String varOrigin = "countryOfOrigin";
    private final String varSize = "size";
    private final String varColour = "colour";
    private final String methodName = "eating";
    public ObjectTest vegetable;
    public ObjectTest cupboard;

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @BeforeEach
    public void setup() {
        String vegetableClassString = "oop.programs_with_multiple_classes.medium.q10." + classVegtable;
        String cupboardClassString = "oop.programs_with_multiple_classes.medium.q10." + classCupboard;
        vegetable = new ObjectTest(vegetableClassString);
        cupboard = new ObjectTest(cupboardClassString);
    }

    @Test
    public void vegetableClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + classVegtable + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + classVegtable + " class attributes does not have the correct modifier.";
        assertTrue(vegetable.hasField(varSpoiled, boolean.class), incorrectFieldMessage);
        assertTrue(vegetable.hasModifier(varSpoiled, "private"), incorrectModifierMessage);
        assertTrue(vegetable.hasField(varWeight, double.class), incorrectFieldMessage);
        assertTrue(vegetable.hasModifier(varWeight, "private"), incorrectModifierMessage);
        assertTrue(vegetable.hasField(varOrigin, String.class), incorrectFieldMessage);
        assertTrue(vegetable.hasModifier(varOrigin, "private"), incorrectModifierMessage);
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + classCupboard + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + classCupboard + " class attributes does not have the correct modifier.";
        assertTrue(cupboard.hasField(varSize, int.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier(varSize, "private"), incorrectModifierMessage);
        assertTrue(cupboard.hasField(varColour, String.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier(varColour, "private"), incorrectModifierMessage);
    }

    @Test
    public void vegetableClassHasRequiredConstructor() {
        Class<?>[] classArguments = {boolean.class, double.class, String.class};
        assertTrue(vegetable.hasConstructor(classArguments),
                "Your " + classVegtable + " constructor does not have the correct parameters.");
        assertTrue(vegetable.hasModifier(classArguments, "public"),
                "Your " + classVegtable + " constructor does not have the correct modifier.");
    }

    @Test
    public void cupboardCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(cupboard.hasConstructor(classArguments),
                "Your " + classCupboard + " constructor does not have the correct parameters.");
        assertTrue(cupboard.hasModifier(classArguments, "public"),
                "Your " + classCupboard + " constructor does not have the correct modifier.");
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
        _assertEquals(isSpoiled, vegetable.getFieldValue(vegetableInstance, varSpoiled),
                "Your " + classVegtable + " constructor does not correctly initialize the " + varSpoiled + " field.");
        _assertEquals(weight, vegetable.getFieldValue(vegetableInstance, varWeight),
                "Your " + classVegtable + " constructor does not correctly initialize the " + varWeight + " field.");
        _assertEquals(countryOfOrigin, vegetable.getFieldValue(vegetableInstance, varOrigin),
                "Your " + classVegtable + " constructor does not correctly initialize the " + varOrigin + " field.");
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
        String ans = classVegtable + "{" + varSpoiled + " = " + isSpoiled + ", " + varWeight + " = " + weight + ", " + varOrigin + " = " + countryOfOrigin + "}";
        _assertEquals(ans, vegetableToStringOutput, "Your " + classVegtable + " toString method does not return the correct string.");
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
        _assertEquals(weight - 0.5, vegetable.getFieldValue(vegetableInstance, varWeight),
                "Your " + classVegtable + " eating method does not decrement the " + varWeight + " by 0.5.");
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
        _assertEquals(size, cupboard.getFieldValue(tableInstance, varSize),
                "Your " + classCupboard + " constructor does not correctly initialize the " + varSize + " field.");
        _assertEquals(colour, cupboard.getFieldValue(tableInstance, varColour),
                "Your " + classCupboard + " constructor does not correctly initialize the " + varColour + " field.");
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
        String ans = classCupboard + "{" + varSize + " = " + size + ", " + varColour + " = " + colour + "}";
        _assertEquals(ans, cupboardToStringOutput, "Your " + classCupboard + " toString method does not return the correct string.");
    }

}
