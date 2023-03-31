package oop.programs_with_multiple_classes.medium.q5;

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
    public ObjectTest desk;
    public ObjectTest monitor;

    @BeforeEach
    public void setup() {
        String deskClassString = "oop.programs_with_multiple_classes.medium.q5.Desk";
        String monitorClassString = "oop.programs_with_multiple_classes.medium.q5.Monitor";
        desk = new ObjectTest(deskClassString);
        monitor = new ObjectTest(monitorClassString);
    }

    public Clause[] testSentence() {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly print out the toString for each initialized object in the TestWorkSetUp class.";
        return new Clause[]{
                new StringLiteral("Monitor\\{countSize = 21}"),
                new NewLine(),
                new StringLiteral("Monitor\\{countSize = 27}"),
                new NewLine(),
                new StringLiteral("Bed\\{materialType = Milani}"),
                new NewLine()
        };
    }

    public void runMain() {
        TestWorkSetUp.main(new String[0]);
    }

    @Test
    public void deskClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Desk class is missing a required field.";
        String incorrectModifierMessage = "One of your Desk class attributes does not have the correct modifier.";
        assertTrue(desk.hasField("materialType", String.class), incorrectFieldMessage);
        assertTrue(desk.hasModifier("materialType", "private"), incorrectModifierMessage);
    }

    @Test
    public void monitorClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Monitor class is missing a required field.";
        String incorrectModifierMessage = "One of your Monitor class attributes does not have the correct modifier.";
        assertTrue(monitor.hasField("countSize", int.class), incorrectFieldMessage);
        assertTrue(monitor.hasModifier("countSize", "private"), incorrectModifierMessage);
    }

    @Test
    public void deskClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class};
        assertTrue(desk.hasConstructor(classArguments),
                "Your Desk constructor does not have the correct parameters.");
        assertTrue(desk.hasModifier(classArguments, "public"),
                "Your Desk constructor does not have the correct modifier.");
    }

    @Test
    public void monitorCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class};
        assertTrue(monitor.hasConstructor(classArguments),
                "Your Monitor constructor does not have the correct parameters.");
        assertTrue(monitor.hasModifier(classArguments, "public"),
                "Your Monitor constructor does not have the correct modifier.");
    }

    private static Stream<Arguments> deskInputProvider() {
        return Stream.of(
                Arguments.of("Mialani"),
                Arguments.of("Oak"),
                Arguments.of("Steel")
        );
    }

    @ParameterizedTest
    @MethodSource("deskInputProvider")
    public void deskConstructorInitializesValuesCorrectly(String material) throws Throwable {
        Object[][] arguments = {
                {material, String.class}
        };
        Object chairInstance = desk.createInstance(arguments);
        _assertEquals(material, desk.getFieldValue(chairInstance, "materialType"),
                "Your Desk constructor does not correctly initialize the materialType field.");
    }

    @ParameterizedTest
    @MethodSource("deskInputProvider")
    public void correctDeskToStringMethod(String material) throws Throwable {
        Object[][] arguments = {
                {material, String.class}
        };
        Object deskInstance = desk.createInstance(arguments);
        Object deskToStringOutput = desk.callMethod("toString", deskInstance);
        String ans = "Bed{materialType = " + material + "}";
        _assertEquals(ans, deskToStringOutput, "Your desk toString method does not return the correct string.");
    }

    private static Stream<Arguments> monitorInputProvider() {
        return Stream.of(
                Arguments.of(11),
                Arguments.of(20),
                Arguments.of(43)
        );
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void monitorConstructorInitializesValuesCorrectly(int count) throws Throwable {
        Object[][] arguments = {
                {count, int.class}
        };
        Object tableInstance = monitor.createInstance(arguments);
        _assertEquals(count, monitor.getFieldValue(tableInstance, "countSize"),
                "Your monitor constructor does not correctly initialize the countSize field.");
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void correctMonitorToStringMethod(int count) throws Throwable {
        Object[][] arguments = {
                {count, int.class}
        };
        Object monitorInstance = monitor.createInstance(arguments);
        Object monitorToStringOutput = monitor.callMethod("toString", monitorInstance);
        String ans = "Monitor{countSize = " + count + "}";
        _assertEquals(ans, monitorToStringOutput, "Your Monitor toString method does not return the correct string.");
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void correctFallenMethod(int count) throws Throwable {
        Object[][] arguments = {
                {count, int.class}
        };
        Object monitorInstance = monitor.createInstance(arguments);
        monitor.callMethod("fallen", monitorInstance);
        _assertEquals(count - 1, monitor.getFieldValue(monitorInstance, "countSize"),
                "Your Monitor fallen method does not decrease the countSize by 1.");
    }

}
