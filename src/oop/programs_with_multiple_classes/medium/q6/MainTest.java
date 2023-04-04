package oop.programs_with_multiple_classes.medium.q6;

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
    // Parsons

    private final String vegetableClass = "Vegetable";
    private final String cupboardClass = "Cupboard";
    private final String varSize = "size";
    private final String varSpoiled = "isSpoiled";
    private final String methodName = "timePassed";
    public ObjectTest vegetable;
    public ObjectTest cupboard;

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @BeforeEach
    public void setup() {
        String vegetableClassString = "oop.programs_with_multiple_classes.medium.q6." + vegetableClass;
        String cupboardClassString = "oop.programs_with_multiple_classes.medium.q6." + cupboardClass;
        vegetable = new ObjectTest(vegetableClassString);
        cupboard = new ObjectTest(cupboardClassString);
    }

    @Test
    public void vegetableClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + vegetableClass + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + vegetableClass + " class attributes does not have the correct modifier.";
        assertTrue(vegetable.hasField(varSpoiled, boolean.class), incorrectFieldMessage);
        assertTrue(vegetable.hasModifier(varSpoiled, "private"), incorrectModifierMessage);
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + cupboardClass + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + cupboardClass + " class attributes does not have the correct modifier.";
        assertTrue(cupboard.hasField(varSize, int.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier(varSize, "private"), incorrectModifierMessage);
    }

    @Test
    public void vegetableClassHasRequiredConstructor() {
        Class<?>[] classArguments = {boolean.class};
        assertTrue(vegetable.hasConstructor(classArguments),
                "Your " + vegetableClass + " constructor does not have the correct parameters.");
        assertTrue(vegetable.hasModifier(classArguments, "public"),
                "Your " + vegetableClass + " constructor does not have the correct modifier.");
    }

    @Test
    public void cupboardCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class};
        assertTrue(cupboard.hasConstructor(classArguments),
                "Your " + cupboardClass + " constructor does not have the correct parameters.");
        assertTrue(cupboard.hasModifier(classArguments, "public"),
                "Your " + cupboardClass + " constructor does not have the correct modifier.");
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
        _assertEquals(isSpoiled, vegetable.getFieldValue(vegetableInstance, varSpoiled),
                "Your " + vegetableClass + " constructor does not correctly initialize the " + varSpoiled + " field.");
    }

    @ParameterizedTest
    @MethodSource("vegetableInputProvider")
    public void correctVegetableToStringMethod(boolean isSpoiled) throws Throwable {
        Object[][] arguments = {
                {isSpoiled, boolean.class}
        };
        Object vegetableInstance = vegetable.createInstance(arguments);
        Object vegetableToStringOutput = vegetable.callMethod("toString", vegetableInstance);
        String ans = vegetableClass + "{" + varSpoiled + " = " + isSpoiled + "}";
        _assertEquals(ans, vegetableToStringOutput, "Your " + vegetableClass + " toString method does not return the correct string.");
    }

    @ParameterizedTest
    @MethodSource("vegetableInputProvider")
    public void correctVegetableTimePassedMethod(boolean isSpoiled) throws Throwable {
        Object[][] arguments = {
                {isSpoiled, boolean.class}
        };
        Object vegetableInstance = vegetable.createInstance(arguments);
        vegetable.callMethod(methodName, vegetableInstance);
        _assertEquals(true, vegetable.getFieldValue(vegetableInstance, varSpoiled),
                "Your " + vegetableClass + " " + methodName + " method does not change the " + varSpoiled + " value to true.");
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
        _assertEquals(size, cupboard.getFieldValue(tableInstance, varSize),
                "Your " + cupboardClass + " constructor does not correctly initialize the " + varSize + " field.");
    }

    @ParameterizedTest
    @MethodSource("cupboardInputProvider")
    public void correctCupboardToStringMethod(int size) throws Throwable {
        Object[][] arguments = {
                {size, int.class}
        };
        Object cupboardInstance = cupboard.createInstance(arguments);
        Object cupboardToStringOutput = cupboard.callMethod("toString", cupboardInstance);
        String ans = cupboardClass + "{" + varSize + " = " + size + "}";
        _assertEquals(ans, cupboardToStringOutput, "Your " + cupboardClass + " toString method does not return the correct string.");
    }

}
