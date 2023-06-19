package oop.programs_with_multiple_classes.medium.q6;

import global.ObjectTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String meatClass = "Meat";
    private final String fridgeClass = "Fridge";
    private final String varSize = "size";
    private final String varSpoiled = "isSpoiled";
    private final String varMeat = "meats";
    private final String methodName = "timePassed";
    public ObjectTest meat;
    public ObjectTest fridge;

    @BeforeEach
    public void setup() {
        String meatClassString = "oop.programs_with_multiple_classes.medium.q6." + meatClass;
        String fridgeClassString = "oop.programs_with_multiple_classes.medium.q6." + fridgeClass;
        meat = new ObjectTest(meatClassString);
        fridge = new ObjectTest(fridgeClassString);
        String modifiedVegMessage =
                "You have modified the class fields in the " + meatClass + " class. Please revert them back to the original state they were provided in.";
        assertTrue(meat.hasField(varSpoiled, boolean.class), modifiedVegMessage);
        assertTrue(meat.hasModifier(varSpoiled, "private"), modifiedVegMessage);
        Class<?>[] classArguments = {boolean.class};
        assertTrue(meat.hasConstructor(classArguments), modifiedVegMessage);
        assertTrue(meat.hasModifier(classArguments, "public"), modifiedVegMessage);
        String modifiedCupMessage =
                "You have modified the class fields in the " + fridgeClass + " class. Please revert them back to the original state they were provided in.";
        assertTrue(fridge.hasField(varSize, int.class), modifiedCupMessage);
        assertTrue(fridge.hasModifier(varSize, "private"), modifiedCupMessage);
        assertTrue(fridge.hasField(varMeat, Meat[].class), modifiedCupMessage);
        assertTrue(fridge.hasModifier(varMeat, "private"), modifiedCupMessage);
    }

    @Test
    public void fridgeClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class};
        assertTrue(fridge.hasConstructor(classArguments),
                "Your " + fridgeClass + " constructor does not have the correct parameters.");
        assertTrue(fridge.hasModifier(classArguments, "public"),
                "Your " + fridgeClass + " constructor does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> meatInputProvider() {
        return Stream.of(
                Arguments.of(true),
                Arguments.of(false),
                Arguments.of(true),
                Arguments.of(false)
        );
    }

    @ParameterizedTest
    @MethodSource("meatInputProvider")
    public void correctMeatTimePassedMethod(boolean isSpoiled) throws Throwable {
        Object[][] arguments = {
                {isSpoiled, boolean.class}
        };
        Object vegetableInstance = meat.createInstance(arguments);
        meat.callMethod(methodName, vegetableInstance);
        assertTrue(meat.hasMethod(methodName, new Class<?>[]{}, Void.TYPE, new String[]{"public"}),
                "Your " + meatClass + " does not have a correct " + methodName + " method");
        _assertEquals(true, meat.getFieldValue(vegetableInstance, varSpoiled),
                "Your " + meatClass + " " + methodName + " method does not change the " + varSpoiled + " value to true.");
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
    public void fridgeConstructorInitializesValuesCorrectly(int size) throws Throwable {
        Object[][] arguments = {
                {size, int.class}
        };
        Object tableInstance = fridge.createInstance(arguments);
        _assertEquals((size > 0) ? size : 0, fridge.getFieldValue(tableInstance, varSize),
                "Your " + fridgeClass + " constructor does not correctly initialize the " + varSize + " field.");
        _assertArrayEquals(new Meat[(size > 0) ? size : 0], fridge.getFieldValue(tableInstance, varMeat),
                "Your " + fridgeClass + " constructor does not correctly initialize the " + varMeat + " field.");
    }

}
