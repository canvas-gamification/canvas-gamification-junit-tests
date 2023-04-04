package oop.programs_with_multiple_classes.medium.q3;

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

    private final String classPencil = "Pencil";
    private final String classEraser = "Eraser";
    private final String varSize = "size";
    private final String varHardness = "hardness";
    private final String varSchool = "isForSchool";
    public ObjectTest pencil;
    public ObjectTest eraser;

    @BeforeEach
    public void setup() {
        String pencilClassString = "oop.programs_with_multiple_classes.medium.q3." + classPencil;
        String eraserClassString = "oop.programs_with_multiple_classes.medium.q3." + classEraser;
        pencil = new ObjectTest(pencilClassString);
        eraser = new ObjectTest(eraserClassString);
    }

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @Test
    public void pencilClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + classPencil + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + classPencil + " class attributes does not have the correct modifier.";
        assertTrue(pencil.hasField(varHardness, int.class), incorrectFieldMessage);
        assertTrue(pencil.hasField(varSchool, boolean.class), incorrectModifierMessage);
        assertTrue(pencil.hasModifier(varHardness, "private"), incorrectModifierMessage);
        assertTrue(pencil.hasModifier(varSchool, "private"), incorrectModifierMessage);
    }

    @Test
    public void eraserClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + classEraser + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + classEraser + " class attributes does not have the correct modifier.";
        assertTrue(eraser.hasField(varSize, double.class), incorrectFieldMessage);
        assertTrue(eraser.hasModifier(varSize, "private"), incorrectModifierMessage);
    }

    @Test
    public void pencilClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(pencil.hasConstructor(classArguments),
                "Your " + classPencil + " constructor does not have the correct parameters.");
        assertTrue(pencil.hasModifier(classArguments, "public"),
                "Your " + classPencil + " constructor does not have the correct modifiers.");
    }

    @Test
    public void eraserClassHasRequiredConstructor() {
        Class<?>[] classArguments = {double.class};
        assertTrue(eraser.hasConstructor(classArguments),
                "Your " + classEraser + " constructor does not have the correct parameters.");
        assertTrue(eraser.hasModifier(classArguments, "public"),
                "Your " + classEraser + " constructor does not have the correct modifiers.");
    }

    private static Stream<Arguments> pencilInputProvider() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(5, false),
                Arguments.of(10, true)
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

    @ParameterizedTest
    @MethodSource("pencilInputProvider")
    public void correctPencilToStringMethod(int hard, boolean school) throws Throwable {
        Object[][] arguments = {
                {hard, int.class},
                {school, boolean.class},
        };
        Object pencilInstance = pencil.createInstance(arguments);
        Object pencilToStringOutput = pencil.callMethod("toString", pencilInstance);
        String ans = classPencil + "{" + varHardness + " = " + hard + ", " + varSchool + " = " + school + "}";
        _assertEquals(ans, pencilToStringOutput, "Your " + classPencil + " toString method does not return the correct string.");
    }

    private static Stream<Arguments> eraserInputProvider() {
        return Stream.of(
                Arguments.of(5.5),
                Arguments.of(110.0),
                Arguments.of(0.01)
        );
    }

    @ParameterizedTest
    @MethodSource("eraserInputProvider")
    public void eraserConstructorInitializesValuesCorrectly(double size) throws Throwable {
        Object[][] arguments = {
                {size, double.class}
        };
        Object eraserInstance = eraser.createInstance(arguments);
        _assertEquals(size, eraser.getFieldValue(eraserInstance, varSize),
                "Your " + classEraser + " constructor does not correctly initialize the " + varSize + " field.");
    }

    @ParameterizedTest
    @MethodSource("eraserInputProvider")
    public void correctEraserToStringMethod(double size) throws Throwable {
        Object[][] arguments = {
                {size, double.class}
        };
        Object eraserInstance = eraser.createInstance(arguments);
        Object eraserToStringOutput = eraser.callMethod("toString", eraserInstance);
        String ans = classEraser + "{" + varSize + " = " + size + "}";
        _assertEquals(ans, eraserToStringOutput, "Your " + classEraser + " toString method does not return the correct string.");
    }

}
