package oop.programs_with_multiple_classes.medium.q7;

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
    public ObjectTest knife;
    public ObjectTest cupboard;

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @BeforeEach
    public void setup() {
        String knifeClassString = "oop.programs_with_multiple_classes.medium.q7.Knife";
        String cupboardClassString = "oop.programs_with_multiple_classes.medium.q7.Cupboard";
        knife = new ObjectTest(knifeClassString);
        cupboard = new ObjectTest(cupboardClassString);
    }

    @Test
    public void knifeClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Knife class is missing a required field.";
        String incorrectModifierMessage = "One of your Knife class attributes does not have the correct modifier.";
        assertTrue(knife.hasField("size", int.class), incorrectFieldMessage);
        assertTrue(knife.hasModifier("size", "private"), incorrectModifierMessage);
        assertTrue(knife.hasField("materialType", String.class), incorrectFieldMessage);
        assertTrue(knife.hasModifier("materialType", "private"), incorrectModifierMessage);
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Cupboard class is missing a required field.";
        String incorrectModifierMessage = "One of your Cupboard class attributes does not have the correct modifier.";
        assertTrue(cupboard.hasField("capacity", int.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier("capacity", "private"), incorrectModifierMessage);
        assertTrue(cupboard.hasField("isFull", boolean.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier("isFull", "private"), incorrectModifierMessage);
    }

    @Test
    public void knifeClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(knife.hasConstructor(classArguments),
                "Your Knife constructor does not have the correct parameters.");
        assertTrue(knife.hasModifier(classArguments, "public"),
                "Your Knife constructor does not have the correct modifier.");
    }

    @Test
    public void cupboardCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(cupboard.hasConstructor(classArguments),
                "Your Cupboard constructor does not have the correct parameters.");
        assertTrue(cupboard.hasModifier(classArguments, "public"),
                "Your Cupboard constructor does not have the correct modifier.");
    }

    private static Stream<Arguments> knifeInputProvider() {
        return Stream.of(
                Arguments.of(2, "Plastic"),
                Arguments.of(10, "Wood"),
                Arguments.of(7, "Steel"),
                Arguments.of(15, "Titanium")
        );
    }

    @ParameterizedTest
    @MethodSource("knifeInputProvider")
    public void knifeConstructorInitializesValuesCorrectly(int size, String materialType) throws Throwable {
        Object[][] arguments = {
                {size, int.class},
                {materialType, String.class}
        };
        Object knifeInstance = knife.createInstance(arguments);
        _assertEquals(size, knife.getFieldValue(knifeInstance, "size"),
                "Your Knife constructor does not correctly initialize the size field.");
        _assertEquals(materialType, knife.getFieldValue(knifeInstance, "materialType"),
                "Your Knife constructor does not correctly initialize the materialType field.");
    }

    @ParameterizedTest
    @MethodSource("knifeInputProvider")
    public void correctKnifeToStringMethod(int size, String materialType) throws Throwable {
        Object[][] arguments = {
                {size, int.class},
                {materialType, String.class}
        };
        Object knifeInstance = knife.createInstance(arguments);
        Object knifeToStringOutput = knife.callMethod("toString", knifeInstance);
        String ans = "Knife{size = " + size + ", materialType = " + materialType + "}";
        _assertEquals(ans, knifeToStringOutput, "Your Knife toString method does not return the correct string.");
    }

    private static Stream<Arguments> cupboardInputProvider() {
        return Stream.of(
                Arguments.of(10, true),
                Arguments.of(20, true),
                Arguments.of(150, false)
        );
    }

    @ParameterizedTest
    @MethodSource("cupboardInputProvider")
    public void cupboardConstructorInitializesValuesCorrectly(int capacity, boolean isFull) throws Throwable {
        Object[][] arguments = {
                {capacity, int.class},
                {isFull, boolean.class}
        };
        Object cupboardInstance = cupboard.createInstance(arguments);
        _assertEquals(capacity, cupboard.getFieldValue(cupboardInstance, "capacity"),
                "Your Cupboard constructor does not correctly initialize the capacity field.");
        _assertEquals(isFull, cupboard.getFieldValue(cupboardInstance, "isFull"),
                "Your Cupboard constructor does not correctly initialize the isFull field.");
    }

    @ParameterizedTest
    @MethodSource("cupboardInputProvider")
    public void correctCupboardToStringMethod(int capacity, boolean isFull) throws Throwable {
        Object[][] arguments = {
                {capacity, int.class},
                {isFull, boolean.class}
        };
        Object cupboardInstance = cupboard.createInstance(arguments);
        Object cupboardToStringOutput = cupboard.callMethod("toString", cupboardInstance);
        String ans = "Cupboard{capacity = " + capacity + ", isFull = " + isFull + "}";
        _assertEquals(ans, cupboardToStringOutput, "Your Cupboard toString method does not return the correct string.");
    }

}
