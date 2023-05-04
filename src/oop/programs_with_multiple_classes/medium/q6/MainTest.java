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

public class MainTest {
    // Java

    private final String vegetableClass = "Vegetable";
    private final String cupboardClass = "Cupboard";
    private final String varSize = "size";
    private final String varSpoiled = "isSpoiled";
    private final String methodName = "timePassed";
    public ObjectTest vegetable;
    public ObjectTest cupboard;

    @BeforeEach
    public void setup() {
        String vegetableClassString = "oop.programs_with_multiple_classes.medium.q6." + vegetableClass;
        String cupboardClassString = "oop.programs_with_multiple_classes.medium.q6." + cupboardClass;
        vegetable = new ObjectTest(vegetableClassString);
        cupboard = new ObjectTest(cupboardClassString);
        String modifiedVegMessage =
                "You have modified the class fields in the " + vegetableClass + " class. Please revert them back to the original state they were provided in.";
        assertTrue(vegetable.hasField(varSpoiled, boolean.class), modifiedVegMessage);
        assertTrue(vegetable.hasModifier(varSpoiled, "private"), modifiedVegMessage);
        Class<?>[] classArguments = {boolean.class};
        assertTrue(vegetable.hasConstructor(classArguments), modifiedVegMessage);
        assertTrue(vegetable.hasModifier(classArguments, "public"), modifiedVegMessage);
        String modifiedCupMessage =
                "You have modified the class fields in the " + cupboardClass + " class. Please revert them back to the original state they were provided in.";
        assertTrue(cupboard.hasField(varSize, int.class), modifiedCupMessage);
        assertTrue(cupboard.hasModifier(varSize, "private"), modifiedCupMessage);
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
                Arguments.of(150),
                Arguments.of(-10),
                Arguments.of(-20),
                Arguments.of(-150)
        );
    }

    @ParameterizedTest
    @MethodSource("cupboardInputProvider")
    public void cupboardConstructorInitializesValuesCorrectly(int size) throws Throwable {
        Object[][] arguments = {
                {size, int.class}
        };
        Object tableInstance = cupboard.createInstance(arguments);
        if (size > 0) {
            _assertEquals(size, cupboard.getFieldValue(tableInstance, varSize),
                    "Your " + cupboardClass + " constructor does not correctly initialize the " + varSize + " field.");
        }
        else{
            _assertEquals(0, cupboard.getFieldValue(tableInstance, varSize),
                    "Your " + cupboardClass + " constructor does not correctly initialize the " + varSize + " field.");
        }
    }

}
