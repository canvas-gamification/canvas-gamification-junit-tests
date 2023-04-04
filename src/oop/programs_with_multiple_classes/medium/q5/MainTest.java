package oop.programs_with_multiple_classes.medium.q5;

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

    private final String deskClass = "Desk";
    private final String monitorClass = "Monitor";
    private final String varMaterial = "materialType";
    private final String varCount = "countSize";
    private final String fallenMethod = "fallen";
    private final int decreaseBy = 1;
    public ObjectTest desk;
    public ObjectTest monitor;

    @BeforeEach
    public void setup() {
        String deskClassString = "oop.programs_with_multiple_classes.medium.q5." + deskClass;
        String monitorClassString = "oop.programs_with_multiple_classes.medium.q5." + monitorClass;
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
        String incorrectFieldMessage = "Your " + deskClass + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + deskClass + " class attributes does not have the correct modifier.";
        assertTrue(desk.hasField(varMaterial, String.class), incorrectFieldMessage);
        assertTrue(desk.hasModifier(varMaterial, "private"), incorrectModifierMessage);
    }

    @Test
    public void monitorClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + monitorClass + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + monitorClass + " class attributes does not have the correct modifier.";
        assertTrue(monitor.hasField(varCount, int.class), incorrectFieldMessage);
        assertTrue(monitor.hasModifier(varCount, "private"), incorrectModifierMessage);
    }

    @Test
    public void deskClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class};
        assertTrue(desk.hasConstructor(classArguments),
                "Your " + deskClass + " constructor does not have the correct parameters.");
        assertTrue(desk.hasModifier(classArguments, "public"),
                "Your " + deskClass + " constructor does not have the correct modifier.");
    }

    @Test
    public void monitorCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class};
        assertTrue(monitor.hasConstructor(classArguments),
                "Your " + monitorClass + " constructor does not have the correct parameters.");
        assertTrue(monitor.hasModifier(classArguments, "public"),
                "Your " + monitorClass + " constructor does not have the correct modifier.");
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
        _assertEquals(material, desk.getFieldValue(chairInstance, varMaterial),
                "Your " + deskClass + " constructor does not correctly initialize the " + varMaterial + " field.");
    }

    @ParameterizedTest
    @MethodSource("deskInputProvider")
    public void correctDeskToStringMethod(String material) throws Throwable {
        Object[][] arguments = {
                {material, String.class}
        };
        Object deskInstance = desk.createInstance(arguments);
        Object deskToStringOutput = desk.callMethod("toString", deskInstance);
        String ans = deskClass + "{" + varMaterial + " = " + material + "}";
        _assertEquals(ans, deskToStringOutput, "Your " + deskClass + " toString method does not return the correct string.");
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
        _assertEquals(count, monitor.getFieldValue(tableInstance, varCount),
                "Your " + monitorClass + " constructor does not correctly initialize the " + varCount + " field.");
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void correctMonitorToStringMethod(int count) throws Throwable {
        Object[][] arguments = {
                {count, int.class}
        };
        Object monitorInstance = monitor.createInstance(arguments);
        Object monitorToStringOutput = monitor.callMethod("toString", monitorInstance);
        String ans = monitorClass + "{" + varCount + " = " + count + "}";
        _assertEquals(ans, monitorToStringOutput, "Your " + monitorClass + " toString method does not return the correct string.");
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void correctFallenMethod(int count) throws Throwable {
        Object[][] arguments = {
                {count, int.class}
        };
        Object monitorInstance = monitor.createInstance(arguments);
        monitor.callMethod(fallenMethod, monitorInstance);
        _assertEquals(count - decreaseBy, monitor.getFieldValue(monitorInstance, varCount),
                "Your " + monitorClass + " " + fallenMethod + " method does not decrease the " + varCount + " by " + decreaseBy + ".");
    }

}
