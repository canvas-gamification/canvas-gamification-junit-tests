package oop.programs_with_multiple_classes.medium.q10;

import global.ObjectTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String classVegtable = "Vegetable";
    private final String classCupboard = "Cupboard";
    private final String varSpoiled = "isSpoiled";
    private final String varWeight = "weight";
    private final String varOrigin = "countryOfOrigin";
    private final String varSize = "size";
    private final String varColour = "colour";
    private final String varVegtables = "vegetables";
    private final String methodName = "eating";
    public ObjectTest vegetable;
    public ObjectTest cupboard;

    @BeforeEach
    public void setup() throws Throwable {
        String vegetableClassString = "oop.programs_with_multiple_classes.medium.q10." + classVegtable;
        String cupboardClassString = "oop.programs_with_multiple_classes.medium.q10." + classCupboard;
        vegetable = new ObjectTest(vegetableClassString);
        cupboard = new ObjectTest(cupboardClassString);
        String modifiedVegtableMessage =
                "You have modified the provided portions of class " + classVegtable + ". Please revert them to the original state.";
        assertTrue(vegetable.hasField(varSpoiled, boolean.class), modifiedVegtableMessage);
        assertTrue(vegetable.hasModifier(varSpoiled, "private"), modifiedVegtableMessage);
        assertTrue(vegetable.hasField(varWeight, double.class), modifiedVegtableMessage);
        assertTrue(vegetable.hasModifier(varWeight, "private"), modifiedVegtableMessage);
        assertTrue(vegetable.hasField(varOrigin, String.class), modifiedVegtableMessage);
        assertTrue(vegetable.hasModifier(varOrigin, "private"), modifiedVegtableMessage);
        String modifiedCupMessage =
                "You have modified the provided portions of class " + classCupboard + ". Please revert them to the original state.";
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(cupboard.hasConstructor(classArguments), modifiedCupMessage);
        assertTrue(cupboard.hasModifier(classArguments, "public"), modifiedCupMessage);

        Object[][] test = new Object[][]{{2, "Red"}, {10, "Black"}, {30, "Green"}};
        for (int num = 0; num < test.length; num++) {
            int size = (int) test[num][0];
            String colour = (String) test[num][1];
            Object[][] arguments = {
                    {size, int.class},
                    {colour, String.class}
            };
            Object tableInstance = cupboard.createInstance(arguments);
            _assertEquals(size, cupboard.getFieldValue(tableInstance, varSize), modifiedCupMessage);
            _assertEquals(colour, cupboard.getFieldValue(tableInstance, varColour), modifiedCupMessage);
            _assertArrayEquals(new Vegetable[size], cupboard.getFieldValue(tableInstance, varVegtables), modifiedCupMessage);
        }
    }

    @Test
    public void discordHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(cupboard.hasField(varSize), String.format(missingAttributeMessage, classCupboard, varSize));
        assertTrue(cupboard.hasField(varSize, int.class), String.format(wrongTypeMessage, varSize, classCupboard));
        assertTrue(cupboard.hasModifier(varSize, "private"), String.format(wrongModifierMessage, varSize, classCupboard));
        assertTrue(cupboard.hasField(varColour), String.format(missingAttributeMessage, classCupboard, varColour));
        assertTrue(cupboard.hasField(varColour, String.class), String.format(wrongTypeMessage, varColour, classCupboard));
        assertTrue(cupboard.hasModifier(varColour, "private"), String.format(wrongModifierMessage, varColour, classCupboard));
        assertTrue(cupboard.hasField(varVegtables), String.format(missingAttributeMessage, classCupboard, varVegtables));
        assertTrue(cupboard.hasField(varVegtables, Vegetable[].class), String.format(wrongTypeMessage, varVegtables, classCupboard));
        assertTrue(cupboard.hasModifier(varVegtables, "private"), String.format(wrongModifierMessage, varVegtables, classCupboard));
    }

    @Test
    public void vegetableClassHasRequiredConstructor() {
        Class<?>[] classArguments = {boolean.class, double.class, String.class};
        assertTrue(vegetable.hasConstructor(classArguments),
                "Your " + classVegtable + " constructor does not have the correct parameters.");
        assertTrue(vegetable.hasModifier(classArguments, "public"),
                "Your " + classVegtable + " constructor does not have the correct visibility modifier.");
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
                "Your " + classVegtable + " constructor does not correctly initialize the " + varSpoiled + " attribute.");
        _assertEquals(weight, vegetable.getFieldValue(vegetableInstance, varWeight),
                "Your " + classVegtable + " constructor does not correctly initialize the " + varWeight + " attribute.");
        _assertEquals(countryOfOrigin, vegetable.getFieldValue(vegetableInstance, varOrigin),
                "Your " + classVegtable + " constructor does not correctly initialize the " + varOrigin + " attribute.");
    }

    @Test
    public void vegetableEatingIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(vegetable.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, classVegtable));
        assertTrue(vegetable.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, classVegtable));
        assertTrue(vegetable.hasReturnType(methodName, null, Void.TYPE), String.format(incorrectReturnType, methodName, classVegtable));
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
        Object output = vegetable.callMethod(methodName, vegetableInstance);
        _assertEquals(weight - 0.5, vegetable.getFieldValue(vegetableInstance, varWeight),
                "Your " + classVegtable + " " + methodName + " method does not decrement the " + varWeight + " by 0.5.");
    }

}
