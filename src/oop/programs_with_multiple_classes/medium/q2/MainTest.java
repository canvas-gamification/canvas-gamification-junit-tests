package oop.programs_with_multiple_classes.medium.q2;

import global.BaseTest;
import global.ObjectTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
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
    public ObjectTest bed;
    public ObjectTest pillow;
    public ObjectTest testRoom;

    @BeforeEach
    public void setup() {
        String bedClassString = "oop.programs_with_multiple_classes.medium.q2.Bed";
        String pillowClassString = "oop.programs_with_multiple_classes.medium.q2.Pillow";
        String testRoomClassString = "oop.programs_with_multiple_classes.medium.q2.TestRoom";
        bed = new ObjectTest(bedClassString);
        pillow = new ObjectTest(pillowClassString);
        testRoom = new ObjectTest(testRoomClassString);
    }

    public Clause[] testSentence() {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly print out the toString for each initialized object in the TestRoom class.";
        return new Clause[]{
                new StringLiteral("Pillow1: Pillow\\{filling = Cotton, yearMade = 2010}"),
                new NewLine(),
                new StringLiteral("Pillow2: Pillow\\{filling = Air, yearMade = 1995}"),
                new NewLine(),
                new StringLiteral("Bed: Bed\\{isComfy = true, weightCapacity = 400}"),
                new NewLine()
        };
    }

    public void runMain() {
        TestRoom.main(new String[0]);
    }

    @Test
    public void bedClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Bed class is missing a required field.";
        String incorrectModifierMessage = "One of your Bed class attributes does not have the correct modifier.";
        assertTrue(bed.hasField("weightCapacity", int.class), incorrectFieldMessage);
        assertTrue(bed.hasField("isComfy", boolean.class), incorrectModifierMessage);
        assertTrue(bed.hasModifier("weightCapacity", "private"), incorrectModifierMessage);
        assertTrue(bed.hasModifier("isComfy", "private"), incorrectModifierMessage);
    }

    @Test
    public void pillowClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Pillow class is missing a required field.";
        String incorrectModifierMessage = "One of your Pillow class attributes does not have the correct modifier.";
        assertTrue(pillow.hasField("filling", String.class), incorrectFieldMessage);
        assertTrue(pillow.hasField("yearMade", int.class), incorrectFieldMessage);
        assertTrue(pillow.hasModifier("filling", "private"), incorrectModifierMessage);
        assertTrue(pillow.hasModifier("yearMade", "private"), incorrectModifierMessage);
    }

    @Test
    public void bedClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(bed.hasConstructor(classArguments),
                "Your Bed constructor does not have the correct parameters.");
        assertTrue(bed.hasModifier(classArguments, "public"),
                "Your Bed constructor does not have the correct modifier.");
    }

    @Test
    public void pillowCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, int.class};
        assertTrue(pillow.hasConstructor(classArguments),
                "Your Pillow constructor does not have the correct parameters.");
        assertTrue(pillow.hasModifier(classArguments, "public"),
                "Your Pillow constructor does not have the correct modifiers.");
    }

    private static Stream<Arguments> bedInputProvider() {
        return Stream.of(
                Arguments.of(1250, true),
                Arguments.of(5000, false),
                Arguments.of(400, true)
        );
    }

    @ParameterizedTest
    @MethodSource("bedInputProvider")
    public void bedConstructorInitializesValuesCorrectly(int weight, boolean comfy) throws Throwable {
        Object[][] arguments = {
                {weight, int.class},
                {comfy, boolean.class}
        };
        Object chairInstance = bed.createInstance(arguments);
        _assertEquals(weight, bed.getFieldValue(chairInstance, "weightCapacity"),
                "Your Bed constructor does not correctly initialize the weightCapacity field.");
        _assertEquals(comfy, bed.getFieldValue(chairInstance, "isComfy"),
                "Your Bed constructor does not correctly initialize the isComfy field.");
    }

    @ParameterizedTest
    @MethodSource("bedInputProvider")
    public void correctBedToStringMethod(int weight, boolean comfy) throws Throwable {
        Object[][] arguments = {
                {weight, int.class},
                {comfy, boolean.class},
        };
        Object tableInstance = bed.createInstance(arguments);
        Object tableToStringOutput = bed.callMethod("toString", tableInstance);
        String ans = "Bed{isComfy = " + comfy + ", weightCapacity = " + weight + "}";
        _assertEquals(ans, tableToStringOutput, "Your table toString method does not return the correct string.");
    }

    private static Stream<Arguments> pillowInputProvider() {
        return Stream.of(
                Arguments.of("Oak", 11),
                Arguments.of("Leaf", 2020),
                Arguments.of("Something comfy", 2015)
        );
    }

    @ParameterizedTest
    @MethodSource("pillowInputProvider")
    public void pillowConstructorInitializesValuesCorrectly(String fill, int made) throws Throwable {
        Object[][] arguments = {
                {fill, String.class},
                {made, int.class},
        };
        Object tableInstance = pillow.createInstance(arguments);
        _assertEquals(fill, pillow.getFieldValue(tableInstance, "filling"),
                "Your pillow constructor does not correctly initialize the filling field.");
        _assertEquals(made, pillow.getFieldValue(tableInstance, "yearMade"),
                "Your pillow constructor does not correctly initialize the yearMade field.");
    }

    @ParameterizedTest
    @MethodSource("pillowInputProvider")
    public void correctPillowToStringMethod(String fill, int made) throws Throwable {
        Object[][] arguments = {
                {fill, String.class},
                {made, int.class},
        };
        Object tableInstance = pillow.createInstance(arguments);
        Object tableToStringOutput = pillow.callMethod("toString", tableInstance);
        String ans = "Pillow{filling = " + fill + ", yearMade = " + made + "}";
        _assertEquals(ans, tableToStringOutput, "Your table toString method does not return the correct string.");
    }

}
