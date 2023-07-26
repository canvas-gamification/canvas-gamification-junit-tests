package oop.programs_with_multiple_classes.medium.q5;

import global.ObjectTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String deskClass = "Desk";
    private final String monitorClass = "Monitor";
    private final String varMaterial = "materialType";
    private final String varMonitors = "monitors";
    private final String varCount = "size";
    private final String varOn = "isOn";
    private final String methodName = "change";
    public ObjectTest desk;
    public ObjectTest monitor;

    @BeforeEach
    public void setup() throws Throwable {
        String deskClassString = "oop.programs_with_multiple_classes.medium.q5." + deskClass;
        String monitorClassString = "oop.programs_with_multiple_classes.medium.q5." + monitorClass;
        desk = new ObjectTest(deskClassString);
        monitor = new ObjectTest(monitorClassString);
        String modifiedDeskMessage =
                "You have modified the provided portions of class " + deskClass + ". Please revert them to the original state.";
        assertTrue(desk.hasField(varMaterial, String.class), modifiedDeskMessage);
        assertTrue(desk.hasModifier(varMaterial, "private"), modifiedDeskMessage);
        assertTrue(desk.hasField(varMonitors, Monitor[].class), modifiedDeskMessage);
        assertTrue(desk.hasModifier(varMonitors, "private"), modifiedDeskMessage);

        String modifiedMonitorMessage =
                "You have modified the provided portions of class " + monitorClass + ". Please revert them to the original state.";
        assertTrue(monitor.hasField(varCount, int.class), modifiedMonitorMessage);
        assertTrue(monitor.hasModifier(varCount, "private"), modifiedMonitorMessage);
        assertTrue(monitor.hasField(varOn, boolean.class), modifiedMonitorMessage);
        assertTrue(monitor.hasModifier(varOn, "private"), modifiedMonitorMessage);
        Object[][] tests = new Object[][]{
                {343, true},
                {3434, false},
                {7653, true}
        };
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(monitor.hasConstructor(classArguments), modifiedMonitorMessage);
        assertTrue(monitor.hasModifier(classArguments, "public"), modifiedMonitorMessage);
        for (int i = 0; i < tests.length; i++) {
            Object[][] arguments = {
                    {tests[i][0], int.class},
                    {tests[i][1], boolean.class}
            };
            Object chairInstance = monitor.createInstance(arguments);
            _assertEquals(tests[i][0], monitor.getFieldValue(chairInstance, varCount), modifiedMonitorMessage);
            _assertEquals(tests[i][1], monitor.getFieldValue(chairInstance, varOn), modifiedMonitorMessage);
        }
    }

    @Test
    public void monitorClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(monitor.hasConstructor(classArguments),
                "Your " + monitorClass + " constructor does not have the correct parameters.");
        assertTrue(monitor.hasModifier(classArguments, "public"),
                "Your " + monitorClass + " constructor does not have the correct visibility modifier.");
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void monitorConstructorInitializesValuesCorrectly(int value1, boolean value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, boolean.class}
        };
        Object chairInstance = monitor.createInstance(arguments);
        _assertEquals(value1, monitor.getFieldValue(chairInstance, varCount),
                "Your " + monitorClass + " constructor does not correctly initialize the " + varCount + " attribute.");
        _assertEquals(value2, monitor.getFieldValue(chairInstance, varOn),
                "Your " + monitorClass + " constructor does not correctly initialize the " + varOn + " attribute.");
    }

    @Test
    public void deskClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class};
        assertTrue(desk.hasConstructor(classArguments),
                "Your " + deskClass + " constructor does not have the correct parameters.");
        assertTrue(desk.hasModifier(classArguments, "public"),
                "Your " + deskClass + " constructor does not have the correct visibility modifier.");
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
                {material, String.class},
        };
        Object chairInstance = desk.createInstance(arguments);
        _assertEquals(material, desk.getFieldValue(chairInstance, varMaterial),
                "Your " + deskClass + " constructor does not correctly initialize the " + varMaterial + " attribute.");
        _assertArrayEquals(new Monitor[2], desk.getFieldValue(chairInstance, varMonitors),
                "Your " + deskClass + " constructor does not correctly initialize the " + varMonitors + " attribute.");
    }

    private static Stream<Arguments> monitorInputProvider() {
        return Stream.of(
                Arguments.of(11, true),
                Arguments.of(20, false),
                Arguments.of(43, true)
        );
    }

    @ParameterizedTest
    @MethodSource("monitorInputProvider")
    public void correctChangeMethod(int count, boolean on) throws Throwable {
        Object[][] arguments = {
                {count, int.class},
                {on, boolean.class}
        };
        Object monitorInstance = monitor.createInstance(arguments);
        assertTrue(monitor.hasMethod(methodName, null),
                "Your " + monitorClass + " " + methodName + " method does not have the correct header.");
        assertTrue(monitor.hasMethod(methodName, null, Void.TYPE),
                "Your " + monitorClass + " " + methodName + " method does not have the correct return type.");
        assertTrue(monitor.hasMethod(methodName, null, Void.TYPE, new String[]{"public"}),
                "Your " + monitorClass + " " + methodName + " method does not have the correct visibility modifier.");
        monitor.callMethod(methodName, monitorInstance);
        _assertEquals((on == false) ? true : false, monitor.getFieldValue(monitorInstance, varOn),
                "Your " + monitorClass + " " + methodName + " method does not changes the " + varOn + " truth value.");
    }

}
