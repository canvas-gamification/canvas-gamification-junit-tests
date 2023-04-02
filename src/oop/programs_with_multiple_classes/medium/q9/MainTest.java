package oop.programs_with_multiple_classes.medium.q9;

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
        String deskClassString = "oop.programs_with_multiple_classes.medium.q9.Desk";
        String monitorClassString = "oop.programs_with_multiple_classes.medium.q9.Monitor";
        desk = new ObjectTest(deskClassString);
        monitor = new ObjectTest(monitorClassString);
    }

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @Test
    public void deskClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Desk class is missing a required field.";
        String incorrectModifierMessage = "One of your Desk class attributes does not have the correct modifier.";
        assertTrue(desk.hasField("materialType", String.class), incorrectFieldMessage);
        assertTrue(desk.hasModifier("materialType", "private"), incorrectModifierMessage);
        assertTrue(desk.hasField("yearsOld", int.class), incorrectFieldMessage);
        assertTrue(desk.hasModifier("yearsOld", "private"), incorrectModifierMessage);
    }

    @Test
    public void monitorClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Monitor class is missing a required field.";
        String incorrectModifierMessage = "One of your Monitor class attributes does not have the correct modifier.";
        assertTrue(monitor.hasField("countSize", int.class), incorrectFieldMessage);
        assertTrue(monitor.hasModifier("countSize", "private"), incorrectModifierMessage);
        assertTrue(monitor.hasField("typeScreen", String.class), incorrectFieldMessage);
        assertTrue(monitor.hasModifier("typeScreen", "private"), incorrectModifierMessage);
        assertTrue(monitor.hasField("isRenewed", boolean.class), incorrectFieldMessage);
        assertTrue(monitor.hasModifier("isRenewed", "private"), incorrectModifierMessage);
    }

    @Test
    public void deskClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, int.class};
        assertTrue(desk.hasConstructor(classArguments),
                "Your Desk constructor does not have the correct parameters.");
        assertTrue(desk.hasModifier(classArguments, "public"),
                "Your Desk constructor does not have the correct modifier.");
    }

    @Test
    public void monitorCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class, boolean.class};
        assertTrue(monitor.hasConstructor(classArguments),
                "Your Monitor constructor does not have the correct parameters.");
        assertTrue(monitor.hasModifier(classArguments, "public"),
                "Your Monitor constructor does not have the correct modifier.");
    }

    private static Stream<Arguments> deskInputProvider() {
        return Stream.of(
                Arguments.of("Mialani", 3),
                Arguments.of("Oak", 20),
                Arguments.of("Steel", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("deskInputProvider")
    public void deskConstructorInitializesValuesCorrectly(String materialType, int yearsOld) throws Throwable {
        Object[][] arguments = {
                {materialType, String.class},
                {yearsOld, int.class}
        };
        Object chairInstance = desk.createInstance(arguments);
        _assertEquals(materialType, desk.getFieldValue(chairInstance, "materialType"),
                "Your Desk constructor does not correctly initialize the materialType field.");
        _assertEquals(yearsOld, desk.getFieldValue(chairInstance, "yearsOld"),
                "Your Desk constructor does not correctly initialize the yearsOld field.");
    }

    @ParameterizedTest
    @MethodSource("deskInputProvider")
    public void correctDeskToStringMethod(String materialType, int yearsOld) throws Throwable {
        Object[][] arguments = {
                {materialType, String.class},
                {yearsOld, int.class}
        };
        Object deskInstance = desk.createInstance(arguments);
        Object deskToStringOutput = desk.callMethod("toString", deskInstance);
        String ans = "Desk{materialType = " + materialType + ", yearsOld = " + yearsOld + "}";
        _assertEquals(ans, deskToStringOutput, "Your desk toString method does not return the correct string.");
    }

    private static Stream<Arguments> monitorInputProvider() {
        return Stream.of(
                Arguments.of(11, "Small Screen", true),
                Arguments.of(20, "Normal Screen", false),
                Arguments.of(43, "Big Screen", true)
        );
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void monitorConstructorInitializesValuesCorrectly(int countSize, String typeScreen, boolean isRenewed) throws Throwable {
        Object[][] arguments = {
                {countSize, int.class},
                {typeScreen, String.class},
                {isRenewed, boolean.class}
        };
        Object tableInstance = monitor.createInstance(arguments);
        _assertEquals(countSize, monitor.getFieldValue(tableInstance, "countSize"),
                "Your monitor constructor does not correctly initialize the countSize field.");
        _assertEquals(typeScreen, monitor.getFieldValue(tableInstance, "typeScreen"),
                "Your monitor constructor does not correctly initialize the typeScreen field.");
        _assertEquals(isRenewed, monitor.getFieldValue(tableInstance, "isRenewed"),
                "Your monitor constructor does not correctly initialize the isRenewed field.");
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void correctMonitorToStringMethod(int countSize, String typeScreen, boolean isRenewed) throws Throwable {
        Object[][] arguments = {
                {countSize, int.class},
                {typeScreen, String.class},
                {isRenewed, boolean.class}
        };
        Object monitorInstance = monitor.createInstance(arguments);
        Object monitorToStringOutput = monitor.callMethod("toString", monitorInstance);
        String ans = "Monitor{countSize = " + countSize + ", typeScreen = " + typeScreen + ", isRenewed = " + isRenewed + "}";
        _assertEquals(ans, monitorToStringOutput, "Your Monitor toString method does not return the correct string.");
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void correctRecycledMethod(int countSize, String typeScreen, boolean isRenewed) throws Throwable {
        Object[][] arguments = {
                {countSize, int.class},
                {typeScreen, String.class},
                {isRenewed, boolean.class}
        };
        Object monitorInstance = monitor.createInstance(arguments);
        monitor.callMethod("recycled", monitorInstance);
        _assertEquals(true, monitor.getFieldValue(monitorInstance, "isRenewed"),
                "Your Monitor recycled method does not change the isRenewed value to true.");
    }

}
