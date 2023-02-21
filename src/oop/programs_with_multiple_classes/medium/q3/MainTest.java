package oop.programs_with_multiple_classes.medium.q3;

import global.BaseTest;
import global.ObjectTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
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
    public ObjectTest pencil;
    public ObjectTest eraser;
    public ObjectTest tpc;

    @BeforeEach
    public void setup() {
        String pencilClassString = "oop.programs_with_multiple_classes.medium.q3.Pencil";
        String eraserClassString = "oop.programs_with_multiple_classes.medium.q3.Eraser";
        String tpcClassString = "oop.programs_with_multiple_classes.medium.q3.TestPencilCase";
        pencil = new ObjectTest(pencilClassString);
        eraser = new ObjectTest(eraserClassString);
        tpc = new ObjectTest(tpcClassString);
    }

    public Clause[] testSentence() {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly print out the toString for each initialized object in the TestRoom class";
        return new Clause[]{
                new StringLiteral("Pencil 1: Pencil\\{hardness = 2, isForSchool = false}"),
                new NewLine(),
                new StringLiteral("Pencil 2: Pencil\\{hardness = 1, isForSchool = true}"),
                new NewLine(),
                new StringLiteral("Eraser 1: Eraser\\{size = 10.5}"),
                new NewLine(),
                new StringLiteral("Eraser 2: Eraser\\{size = 4.3}"),
                new NewLine()
        };
    }

    public void runMain() {
        TestPencilCase.main(new String[0]);
    }

    @Test
    public void pencilClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Pencil class is missing a required field";
        String incorrectModifierMessage = "One of your Pencil class attributes does not have the correct modifier.";
        assertTrue(pencil.hasField("hardness", int.class), incorrectFieldMessage);
        assertTrue(pencil.hasField("isForSchool", boolean.class), incorrectModifierMessage);
        assertTrue(pencil.hasModifier("hardness", "private"), incorrectModifierMessage);
        assertTrue(pencil.hasModifier("isForSchool", "private"), incorrectModifierMessage);
    }

    @Test
    public void EraserClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Eraser class is missing a required field";
        String incorrectModifierMessage = "One of your Eraser class attributes does not have the correct modifier.";
        assertTrue(eraser.hasField("size", double.class), incorrectFieldMessage);
        assertTrue(eraser.hasModifier("size", "private"), incorrectModifierMessage);
    }

    @Test
    public void pencilClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(pencil.hasConstructor(classArguments),
                "Your Pencil constructor does not have the correct parameters.");
        assertTrue(pencil.hasModifier(classArguments, "public"),
                "Your Pencil constructor does not have the correct modifiers.");
    }

    @Test
    public void eraserCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {double.class};
        assertTrue(eraser.hasConstructor(classArguments),
                "Your Eraser constructor does not have the correct parameters.");
        assertTrue(eraser.hasModifier(classArguments, "public"),
                "Your Eraser constructor does not have the correct modifiers.");
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
        _assertEquals(hard, pencil.getFieldValue(pencilInstance, "hardness"),
                "Your Pencil constructor does not correctly initialize the hardness field.");
        _assertEquals(school, pencil.getFieldValue(pencilInstance, "isForSchool"),
                "Your Pencil constructor does not correctly initialize the isForSchool field.");
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
        String ans = "Pencil{hardness = " + hard + ", isForSchool = " + school + "}";
        _assertEquals(ans, pencilToStringOutput, "Your Pencil toString method does not return the correct string.");
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
        _assertEquals(size, eraser.getFieldValue(eraserInstance, "size"),
                "Your Eraser constructor does not correctly initialize the size field.");
    }

    @ParameterizedTest
    @MethodSource("eraserInputProvider")
    public void correctPillowToStringMethod(double size) throws Throwable {
        Object[][] arguments = {
                {size, double.class}
        };
        Object eraserInstance = eraser.createInstance(arguments);
        Object eraserToStringOutput = eraser.callMethod("toString", eraserInstance);
        String ans = "Eraser{size = " + size + "}";
        _assertEquals(ans, eraserToStringOutput, "Your Eraser toString method does not return the correct string.");
    }

}