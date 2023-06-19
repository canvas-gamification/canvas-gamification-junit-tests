package oop.programs_with_multiple_classes.medium.q4;

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

    private final String wheelClass = "Wheel";
    private final String chassisClass = "Chassis";
    private final String varDurability = "durability";
    private final String varManufacturer = "manufacturer";
    private final String varMaterialType = "materialType";
    private final String varWheels = "wheels";
    public ObjectTest wheel;
    public ObjectTest chassis;

    @BeforeEach
    public void setup() throws Throwable {
        String wheelClassString = "oop.programs_with_multiple_classes.medium.q4." + wheelClass;
        String chassisClassString = "oop.programs_with_multiple_classes.medium.q4." + chassisClass;
        wheel = new ObjectTest(wheelClassString);
        chassis = new ObjectTest(chassisClassString);
        String modifiedWheelMessage =
                "You have modified the provided portions of the " + wheelClass + " class. Please revert it back to the original state.";
        assertTrue(wheel.hasField(varDurability, double.class), modifiedWheelMessage);
        assertTrue(wheel.hasField(varManufacturer, String.class), modifiedWheelMessage);
        assertTrue(wheel.hasModifier(varDurability, "private"), modifiedWheelMessage);
        assertTrue(wheel.hasModifier(varManufacturer, "private"), modifiedWheelMessage);
        String modifiedChassisMessage =
                "You have modified the provided portions of the " + chassisClass + " class. Please revert it back to the original state.";
        Class<?>[] classArguments = {String.class};
        assertTrue(chassis.hasConstructor(classArguments), modifiedChassisMessage);
        assertTrue(chassis.hasModifier(classArguments, "public"), modifiedChassisMessage);
        String[] tests = new String[]{"Steel", "Iron", "Carbon", "Titanium"};
        for (int i = 0; i < tests.length; i++) {
            Object[][] arguments = {
                    {tests[i], String.class}
            };
            Object chassisInstance = chassis.createInstance(arguments);
            _assertEquals(tests[i], chassis.getFieldValue(chassisInstance, varMaterialType),modifiedChassisMessage);
            _assertArrayEquals(new Wheel[4], chassis.getFieldValue(chassisInstance, varWheels),modifiedChassisMessage);
        }
    }

    @Test
    public void chassisClassHasCorrectAttributes() {
        assertTrue(chassis.hasField(varMaterialType, String.class),
                "Your " + chassisClass + " class is missing the " + varMaterialType + " attribute.");
        assertTrue(chassis.hasModifier(varMaterialType, "private"),
                "Your " + varMaterialType + " attribute does not have the correct visibility modifier.");
        assertTrue(chassis.hasField(varWheels, Wheel[].class),
                "Your " + chassisClass + " class is missing the " + varWheels + " attribute.");
        assertTrue(chassis.hasModifier(varWheels, "private"),
                "Your " + varWheels + " attribute does not have the correct visibility modifier.");
    }

    @Test
    public void wheelClassHasRequiredConstructor() {
        Class<?>[] classArguments = {double.class, String.class};
        assertTrue(wheel.hasConstructor(classArguments),
                "Your " + wheelClass + " constructor does not have the correct parameters.");
        assertTrue(wheel.hasModifier(classArguments, "public"),
                "Your " + wheelClass + " constructor does not have the correct visibility modifiers.");
    }

    private static Stream<Arguments> wheelInputProvider() {
        return Stream.of(
                Arguments.of(5.5, "Milani"),
                Arguments.of(2.3, "Ford"),
                Arguments.of(7.7, "Nissan"),
                Arguments.of(-3.5, "Milani"),
                Arguments.of(-2.6, "Martin"),
                Arguments.of(-5.4, "Harley")
        );
    }

    @ParameterizedTest
    @MethodSource("wheelInputProvider")
    public void wheelConstructorInitializesValuesCorrectly(double d, String m) throws Throwable {
        Object[][] arguments = {
                {d, double.class},
                {m, String.class}
        };
        Object wheelInstance = wheel.createInstance(arguments);
        _assertEquals((d >= 0) ? d : 0.0000, wheel.getFieldValue(wheelInstance, varDurability),
                "Your " + wheelClass + " constructor does not correctly initialize the " + varDurability + " attribute.");
        _assertEquals(m, wheel.getFieldValue(wheelInstance, varManufacturer),
                "Your " + wheelClass + " constructor does not correctly initialize the " + varManufacturer + " attribute.");

    }

}
