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
    // Parsons with Distractors

    private final String knifeClass = "Knife";
    private final String cupboardClass = "Cupboard";
    private final String varSize = "size";
    private final String varMaterial = "materialType";
    private final String varCapacity = "capacity";
    private final String varFull = "isFull";
    public ObjectTest knife;
    public ObjectTest cupboard;

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @BeforeEach
    public void setup() {
        String knifeClassString = "oop.programs_with_multiple_classes.medium.q7." + knifeClass;
        String cupboardClassString = "oop.programs_with_multiple_classes.medium.q7." + cupboardClass;
        knife = new ObjectTest(knifeClassString);
        cupboard = new ObjectTest(cupboardClassString);
    }

    @Test
    public void knifeClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + knifeClass + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + knifeClass + " class attributes does not have the correct modifier.";
        assertTrue(knife.hasField(varSize, int.class), incorrectFieldMessage);
        assertTrue(knife.hasModifier(varSize, "private"), incorrectModifierMessage);
        assertTrue(knife.hasField(varMaterial, String.class), incorrectFieldMessage);
        assertTrue(knife.hasModifier(varMaterial, "private"), incorrectModifierMessage);
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + cupboardClass + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + cupboardClass + " class attributes does not have the correct modifier.";
        assertTrue(cupboard.hasField(varCapacity, int.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier(varCapacity, "private"), incorrectModifierMessage);
        assertTrue(cupboard.hasField(varFull, boolean.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier(varFull, "private"), incorrectModifierMessage);
    }

    @Test
    public void knifeClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(knife.hasConstructor(classArguments),
                "Your " + knifeClass + " constructor does not have the correct parameters.");
        assertTrue(knife.hasModifier(classArguments, "public"),
                "Your " + knifeClass + " constructor does not have the correct modifier.");
    }

    @Test
    public void cupboardCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(cupboard.hasConstructor(classArguments),
                "Your " + cupboardClass + " constructor does not have the correct parameters.");
        assertTrue(cupboard.hasModifier(classArguments, "public"),
                "Your " + cupboardClass + " constructor does not have the correct modifier.");
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
        _assertEquals(size, knife.getFieldValue(knifeInstance, varSize),
                "Your " + knifeClass + " constructor does not correctly initialize the " + varSize + " field.");
        _assertEquals(materialType, knife.getFieldValue(knifeInstance, varMaterial),
                "Your " + knifeClass + " constructor does not correctly initialize the " + varMaterial + " field.");
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
        String ans = knifeClass + "{" + varSize + " = " + size + ", " + varMaterial + " = " + materialType + "}";
        _assertEquals(ans, knifeToStringOutput, "Your " + knifeClass + " toString method does not return the correct string.");
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
        _assertEquals(capacity, cupboard.getFieldValue(cupboardInstance, varCapacity),
                "Your " + cupboardClass + " constructor does not correctly initialize the " + varCapacity + " field.");
        _assertEquals(isFull, cupboard.getFieldValue(cupboardInstance, varFull),
                "Your " + cupboardClass + " constructor does not correctly initialize the " + varFull + " field.");
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
        String ans = cupboardClass + "{" + varCapacity + " = " + capacity + ", " + varFull + " = " + isFull + "}";
        _assertEquals(ans, cupboardToStringOutput, "Your " + cupboardClass + " toString method does not return the correct string.");
    }

}
