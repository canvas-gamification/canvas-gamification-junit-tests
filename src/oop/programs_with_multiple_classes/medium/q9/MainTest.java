package oop.programs_with_multiple_classes.medium.q9;

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
    public void setup() throws Throwable {
        String deskClassString = "oop.programs_with_multiple_classes.medium.q9." + classDesk;
        String monitorClassString = "oop.programs_with_multiple_classes.medium.q9." + classMonitor;
        desk = new ObjectTest(deskClassString);
        monitor = new ObjectTest(monitorClassString);
        String modifiedMonitorMessage =
                "You have modified the provided portions of class " + classMonitor + ". Please revert them to the original state.";
        assertTrue(monitor.hasField(varCount, int.class), modifiedMonitorMessage);
        assertTrue(monitor.hasModifier(varCount, "private"), modifiedMonitorMessage);
        assertTrue(monitor.hasField(varType, String.class), modifiedMonitorMessage);
        assertTrue(monitor.hasModifier(varType, "private"), modifiedMonitorMessage);
        assertTrue(monitor.hasField(varRenewed, boolean.class), modifiedMonitorMessage);
        assertTrue(monitor.hasModifier(varRenewed, "private"), modifiedMonitorMessage);
        String modifiedDeskMessage =
                "You have modified the provided portions of class " + classDesk + ". Please revert them to the original state.";
        Class<?>[] classArguments = {String.class, int.class};
        assertTrue(desk.hasConstructor(classArguments), modifiedDeskMessage);
        assertTrue(desk.hasModifier(classArguments, "public"), modifiedDeskMessage);

        Object[][] test = new Object[][]{{"Mialani", 3}, {"Oak", 20}, {"Steel", 0}};
        for (int num = 0; num < test.length; num++) {
            String materialType = (String) test[num][0];
            int yearsOld = (int) test[num][1];
            Object[][] arguments = {
                    {materialType, String.class},
                    {yearsOld, int.class}
            };
            Object chairInstance = desk.createInstance(arguments);
            _assertEquals(materialType, desk.getFieldValue(chairInstance, varMaterial), modifiedDeskMessage);
            _assertEquals(yearsOld, desk.getFieldValue(chairInstance, varOld), modifiedDeskMessage);
        }
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
    public void monitorCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class, boolean.class};
        assertTrue(monitor.hasConstructor(classArguments),
                "Your " + classMonitor + " constructor does not have the correct parameters.");
        assertTrue(monitor.hasModifier(classArguments, "public"),
                "Your " + classMonitor + " constructor does not have the correct modifier.");
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
