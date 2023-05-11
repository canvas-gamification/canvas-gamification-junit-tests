package oop.programs_with_multiple_classes.medium.q7;

import global.ObjectTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String knifeClass = "Knife";
    private final String cupboardClass = "Cupboard";
    private final String varSize = "size";
    private final String varMaterial = "materialType";
    private final String varCapacity = "capacity";
    private final String varFull = "isFull";
    private final String varKnifes = "knifes";
    public ObjectTest knife;
    public ObjectTest cupboard;

    @BeforeEach
    public void setup() throws Throwable {
        String knifeClassString = "oop.programs_with_multiple_classes.medium.q7." + knifeClass;
        String cupboardClassString = "oop.programs_with_multiple_classes.medium.q7." + cupboardClass;
        knife = new ObjectTest(knifeClassString);
        cupboard = new ObjectTest(cupboardClassString);
        String modifiedKnifeMessage =
                "You have modified the provided portions of class " + knifeClass + ". Please revert them to the original state.";
        assertTrue(knife.hasField(varSize, int.class), modifiedKnifeMessage);
        assertTrue(knife.hasModifier(varSize, "private"), modifiedKnifeMessage);
        assertTrue(knife.hasField(varMaterial, String.class), modifiedKnifeMessage);
        assertTrue(knife.hasModifier(varMaterial, "private"), modifiedKnifeMessage);
        String modifiedCupMessage =
                "You have modified the provided portions of class " + cupboardClass + ". Please revert them to the original state.";
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(cupboard.hasConstructor(classArguments), modifiedCupMessage);
        assertTrue(cupboard.hasModifier(classArguments, "public"), modifiedCupMessage);

        Object[][] test = {{10, true}, {20, false}, {50, true}};
        for (int testNum = 0; testNum < test.length; testNum++) {
            int capacity = (int) test[testNum][0];
            boolean isFull = (boolean) test[testNum][1];
            Object[][] arguments = {
                    {capacity, int.class},
                    {isFull, boolean.class}
            };
            Object cupboardInstance = cupboard.createInstance(arguments);
            _assertEquals(capacity, cupboard.getFieldValue(cupboardInstance, varCapacity),
                    "Your " + cupboardClass + " constructor does not correctly initialize the " + varCapacity + " field.");
            _assertEquals(isFull, cupboard.getFieldValue(cupboardInstance, varFull),
                    "Your " + cupboardClass + " constructor does not correctly initialize the " + varFull + " field.");
            assertEquals(null, cupboard.getFieldValue(cupboardInstance, varKnifes),
                    "Your " + cupboardClass + " constructor does not correctly initialize the " + varKnifes + " field.");
        }
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + cupboardClass + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + cupboardClass + " class attributes does not have the correct modifier.";
        assertTrue(cupboard.hasField(varCapacity, int.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier(varCapacity, "private"), incorrectModifierMessage);
        assertTrue(cupboard.hasField(varFull, boolean.class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier(varFull, "private"), incorrectModifierMessage);
        assertTrue(cupboard.hasField(varKnifes, Knife[].class), incorrectFieldMessage);
        assertTrue(cupboard.hasModifier(varKnifes, "private"), incorrectModifierMessage);
    }

    @Test
    public void knifeClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(knife.hasConstructor(classArguments),
                "Your " + knifeClass + " constructor does not have the correct parameters.");
        assertTrue(knife.hasModifier(classArguments, "public"),
                "Your " + knifeClass + " constructor does not have the correct modifier.");
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

}
