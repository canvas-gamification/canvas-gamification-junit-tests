package oop.programs_with_multiple_classes.medium.q4;

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

    private final String wheelClass = "Wheel";
    private final String chassisClass = "Chassis";
    private final String varDurability = "durability";
    private final String varManufacturer = "manufacturer";
    private final String varMaterialType = "materialType";
    public ObjectTest wheel;
    public ObjectTest chassis;

    @BeforeEach
    public void setup() {
        String wheelClassString = "oop.programs_with_multiple_classes.medium.q4." + wheelClass;
        String chassisClassString = "oop.programs_with_multiple_classes.medium.q4." + chassisClass;
        wheel = new ObjectTest(wheelClassString);
        chassis = new ObjectTest(chassisClassString);
    }

    public Clause[] testSentence() {return new Clause[0];}

    public void runMain() {}

    @Test
    public void wheelClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your "+ wheelClass + " class is missing a required field";
        String incorrectModifierMessage = "One of your " + wheelClass + " class attributes does not have the correct modifier.";
        assertTrue(wheel.hasField(varDurability, double.class), incorrectFieldMessage);
        assertTrue(wheel.hasField(varManufacturer, String.class), incorrectModifierMessage);
        assertTrue(wheel.hasModifier(varDurability, "private"), incorrectModifierMessage);
        assertTrue(wheel.hasModifier(varManufacturer, "private"), incorrectModifierMessage);
    }

    @Test
    public void chassisClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + chassisClass + " class is missing a required field";
        String incorrectModifierMessage = "One of your " + chassisClass + " class attributes does not have the correct modifier.";
        assertTrue(chassis.hasField(varMaterialType, String.class), incorrectFieldMessage);
        assertTrue(chassis.hasModifier(varMaterialType, "private"), incorrectModifierMessage);
    }

    @Test
    public void wheelClassHasRequiredConstructor() {
        Class<?>[] classArguments = {double.class, String.class};
        assertTrue(wheel.hasConstructor(classArguments),
                "Your " + wheelClass + " constructor does not have the correct parameters.");
        assertTrue(wheel.hasModifier(classArguments, "public"),
                "Your " + wheelClass + " constructor does not have the correct modifiers.");
    }

    @Test
    public void chassisCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class};
        assertTrue(chassis.hasConstructor(classArguments),
                "Your " + chassisClass + " constructor does not have the correct parameters.");
        assertTrue(chassis.hasModifier(classArguments, "public"),
                "Your " + chassisClass + " constructor does not have the correct modifiers.");
    }

    private static Stream<Arguments> wheelInputProvider() {
        return Stream.of(
                Arguments.of(5.5, "Milani"),
                Arguments.of(2.3, "Ford"),
                Arguments.of(7.7, "Nissan")
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
        _assertEquals(d, wheel.getFieldValue(wheelInstance, varDurability),
                "Your " + wheelClass + " constructor does not correctly initialize the " + varDurability + " field.");
        _assertEquals(m, wheel.getFieldValue(wheelInstance, varManufacturer),
                "Your " + wheelClass + " constructor does not correctly initialize the " + varManufacturer + " field.");
    }

    @ParameterizedTest
    @MethodSource("wheelInputProvider")
    public void correctWheelToStringMethod(double d, String m) throws Throwable {
        Object[][] arguments = {
                {d, double.class},
                {m, String.class}
        };
        Object wheelInstance = wheel.createInstance(arguments);
        Object wheelToStringOutput = wheel.callMethod("toString", wheelInstance);
        String ans = wheelClass + "{" + varDurability + " = " + d + ", " + varManufacturer + " = " + m + "}";
        _assertEquals(ans, wheelToStringOutput, "Your " + wheelClass + " toString method does not return the correct string.");
    }

    private static Stream<Arguments> chassisInputProvider() {
        return Stream.of(
                Arguments.of("Steel"),
                Arguments.of("Wood"),
                Arguments.of("Titanium")
        );
    }

    @ParameterizedTest
    @MethodSource("chassisInputProvider")
    public void chassisConstructorInitializesValuesCorrectly(String material) throws Throwable {
        Object[][] arguments = {
                {material, String.class}
        };
        Object chassisInstance = chassis.createInstance(arguments);
        _assertEquals(material, chassis.getFieldValue(chassisInstance, varMaterialType),
                "Your " + chassisClass + " constructor does not correctly initialize the " + varMaterialType + " field.");
    }

    @ParameterizedTest
    @MethodSource("chassisInputProvider")
    public void chassisToStringMethod(String material) throws Throwable {
        Object[][] arguments = {
                {material, String.class}
        };
        Object chassisInstance = chassis.createInstance(arguments);
        Object chassisToStringOutput = chassis.callMethod("toString", chassisInstance);
        String ans = chassisClass + "{" + varMaterialType + " = " + material + "}";
        _assertEquals(ans, chassisToStringOutput, "Your " + chassisClass + " toString method does not return the correct string.");
    }

}
