package oop.programs_with_multiple_classes.medium.q9;

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
    // Parsons with Distractors

    private final String classMonitor = "Monitor";
    private final String classDesk = "Desk";
    private final String varCount = "countSize";
    private final String varType = "typeScreen";
    private final String varRenewed = "isRenewed";
    private final String varMaterial = "materialType";
    private final String varOld = "yearsOld";
    private final String methodName = "recycled";
    public ObjectTest desk;
    public ObjectTest monitor;

    @BeforeEach
    public void setup() {
        String deskClassString = "oop.programs_with_multiple_classes.medium.q9." + classDesk;
        String monitorClassString = "oop.programs_with_multiple_classes.medium.q9." + classMonitor;
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
        String incorrectFieldMessage = "Your " + classDesk + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + classDesk + " class attributes does not have the correct modifier.";
        assertTrue(desk.hasField(varMaterial, String.class), incorrectFieldMessage);
        assertTrue(desk.hasModifier(varMaterial, "private"), incorrectModifierMessage);
        assertTrue(desk.hasField(varOld, int.class), incorrectFieldMessage);
        assertTrue(desk.hasModifier(varOld, "private"), incorrectModifierMessage);
    }

    @Test
    public void monitorClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + classMonitor + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + classMonitor + " class attributes does not have the correct modifier.";
        assertTrue(monitor.hasField(varCount, int.class), incorrectFieldMessage);
        assertTrue(monitor.hasModifier(varCount, "private"), incorrectModifierMessage);
        assertTrue(monitor.hasField(varType, String.class), incorrectFieldMessage);
        assertTrue(monitor.hasModifier(varType, "private"), incorrectModifierMessage);
        assertTrue(monitor.hasField(varRenewed, boolean.class), incorrectFieldMessage);
        assertTrue(monitor.hasModifier(varRenewed, "private"), incorrectModifierMessage);
    }

    @Test
    public void deskClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, int.class};
        assertTrue(desk.hasConstructor(classArguments),
                "Your " + classDesk + " constructor does not have the correct parameters.");
        assertTrue(desk.hasModifier(classArguments, "public"),
                "Your " + classDesk + " constructor does not have the correct modifier.");
    }

    @Test
    public void monitorCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class, boolean.class};
        assertTrue(monitor.hasConstructor(classArguments),
                "Your " + classMonitor + " constructor does not have the correct parameters.");
        assertTrue(monitor.hasModifier(classArguments, "public"),
                "Your " + classMonitor + " constructor does not have the correct modifier.");
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
        _assertEquals(materialType, desk.getFieldValue(chairInstance, varMaterial),
                "Your " + classDesk + " constructor does not correctly initialize the " + varMaterial + " field.");
        _assertEquals(yearsOld, desk.getFieldValue(chairInstance, varOld),
                "Your " + classDesk + " constructor does not correctly initialize the " + varOld + " field.");
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
        String ans = classDesk + "{" + varMaterial + " = " + materialType + ", " + varOld + " = " + yearsOld + "}";
        _assertEquals(ans, deskToStringOutput, "Your " + classDesk + " toString method does not return the correct string.");
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
        _assertEquals(countSize, monitor.getFieldValue(tableInstance, varCount),
                "Your " + classMonitor + " constructor does not correctly initialize the " + varCount + " field.");
        _assertEquals(typeScreen, monitor.getFieldValue(tableInstance, varType),
                "Your " + classMonitor + " constructor does not correctly initialize the " + varType + " field.");
        _assertEquals(isRenewed, monitor.getFieldValue(tableInstance, varRenewed),
                "Your " + classMonitor + " constructor does not correctly initialize the " + varRenewed + " field.");
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
        String ans = classMonitor + "{" + varCount + " = " + countSize + ", " + varType + " = " + typeScreen + ", " + varRenewed + " = " + isRenewed + "}";
        _assertEquals(ans, monitorToStringOutput, "Your " + classMonitor + " toString method does not return the correct string.");
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
        monitor.callMethod(methodName, monitorInstance);
        _assertEquals(true, monitor.getFieldValue(monitorInstance, varRenewed),
                "Your " + classMonitor + " " + methodName + " method does not change the " + varRenewed + " value to true.");
    }

}
