package oop.programs_with_multiple_classes.medium.q3;

import global.ObjectTest;
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

    private final String classPencil = "Pencil";
    private final String classEraser = "Eraser";
    private final String varSize = "size";
    private final String varHardness = "hardness";
    private final String varSchool = "isForSchool";
    private final String varMethod = "erase";
    public ObjectTest pencil;
    public ObjectTest eraser;

    @BeforeEach
    public void setup() {
        String pencilClassString = "oop.programs_with_multiple_classes.medium.q3." + classPencil;
        String eraserClassString = "oop.programs_with_multiple_classes.medium.q3." + classEraser;
        pencil = new ObjectTest(pencilClassString);
        eraser = new ObjectTest(eraserClassString);
        String modifiedPencilMessage =
                "You have modified the provided portions of the " + classPencil + " class. Please revert it back to the original state.";
        assertTrue(pencil.hasField(varHardness, int.class), modifiedPencilMessage);
        assertTrue(pencil.hasField(varSchool, boolean.class), modifiedPencilMessage);
        assertTrue(pencil.hasModifier(varHardness, "private"), modifiedPencilMessage);
        assertTrue(pencil.hasModifier(varSchool, "private"), modifiedPencilMessage);
        String modifiedEraserMessage =
                "You have modified the provided portions of the " + classEraser + " class. Please revert it back to the original state.";
        Class<?>[] classArguments = {double.class};
        assertTrue(eraser.hasConstructor(classArguments), modifiedEraserMessage);
        assertTrue(eraser.hasModifier(classArguments, "public"), modifiedEraserMessage);
    }

    @Test
    public void eraserClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + classEraser + " class is missing a required field.";
        String incorrectModifierMessage = "The " + varSize + " field in the " + classEraser + " class attributes does not have the correct visibility modifier.";
        assertTrue(eraser.hasField(varSize, double.class), incorrectFieldMessage);
        assertTrue(eraser.hasModifier(varSize, "private"), incorrectModifierMessage);
    }

    @Test
    public void pencilClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(pencil.hasConstructor(classArguments),
                "Your " + classPencil + " constructor does not have the correct parameters.");
        assertTrue(pencil.hasModifier(classArguments, "public"),
                "Your " + classPencil + " constructor does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> pencilInputProvider() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(5, false),
                Arguments.of(170254, true)
        );
    }

    @ParameterizedTest
    @MethodSource("pencilInputProvider")
    public void pencilConstructorInitializesValuesCorrectly(int hard, boolean school) throws Throwable {
        Object[][] arguments = {
                {hard, int.class},
                {school, boolean.class}
        };
        Object pencilInstance = pencil.createInstance(arguments);
        _assertEquals(hard, pencil.getFieldValue(pencilInstance, varHardness),
                "Your " + classPencil + " constructor does not correctly initialize the " + varHardness + " field.");
        _assertEquals(school, pencil.getFieldValue(pencilInstance, varSchool),
                "Your " + classPencil + " constructor does not correctly initialize the " + varSchool + " field.");
    }

    private static Stream<Arguments> eraserInputProvider() {
        return Stream.of(
                Arguments.of(2),
                Arguments.of(5),
                Arguments.of(10)
        );
    }

    @ParameterizedTest
    @MethodSource("eraserInputProvider")
    public void correctEraseMethod(double size) throws Throwable {
        Object[][] arguments = {
                {size, double.class}
        };
        Object eraerInstance = eraser.createInstance(arguments);
        eraser.callMethod(varMethod, eraerInstance);
        _assertEquals(size - 1, eraser.getFieldValue(eraerInstance, varSize),
                "Your " + classEraser + " " + varMethod + " method does not correctly decrease the value of " + varSize + " by 1");
    }

}
