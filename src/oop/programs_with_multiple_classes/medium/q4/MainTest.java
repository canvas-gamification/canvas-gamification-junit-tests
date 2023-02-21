package oop.programs_with_multiple_classes.medium.q4;

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
    public ObjectTest wheel;
    public ObjectTest chassis;
    public ObjectTest tv;

    @BeforeEach
    public void setup() {
        String wheelClassString = "oop.programs_with_multiple_classes.medium.q4.Wheel";
        String chassisClassString = "oop.programs_with_multiple_classes.medium.q4.Chassis";
        String tvClassString = "oop.programs_with_multiple_classes.medium.q4.TestVehicle";
        wheel = new ObjectTest(wheelClassString);
        chassis = new ObjectTest(chassisClassString);
        tv = new ObjectTest(tvClassString);
    }

    public Clause[] testSentence() {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly print out the toString for each initialized object in the TestRoom class";
        return new Clause[]{
                new StringLiteral("Chassis: Chassis\\{materialType = Steel}"),
                new NewLine(),
                new StringLiteral("Wheel 1: Wheel\\{durability = 5.5, manufacturer = Milani}"),
                new NewLine(),
                new StringLiteral("Wheel 2: Wheel\\{durability = 5.5, manufacturer = Milani}"),
                new NewLine(),
                new StringLiteral("Wheel 3: Wheel\\{durability = 6.9, manufacturer = TRX}"),
                new NewLine(),
                new StringLiteral("Wheel 4: Wheel\\{durability = 6.8, manufacturer = RTX}"),
                new NewLine()
        };
    }

    public void runMain() {
        TestVehicle.main(new String[0]);
    }

    @Test
    public void wheelClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Wheel class is missing a required field";
        String incorrectModifierMessage = "One of your Wheel class attributes does not have the correct modifier.";
        assertTrue(wheel.hasField("durability", double.class), incorrectFieldMessage);
        assertTrue(wheel.hasField("manufacturer", String.class), incorrectModifierMessage);
        assertTrue(wheel.hasModifier("durability", "private"), incorrectModifierMessage);
        assertTrue(wheel.hasModifier("manufacturer", "private"), incorrectModifierMessage);
    }

    @Test
    public void chassisClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Chassis class is missing a required field";
        String incorrectModifierMessage = "One of your Chassis class attributes does not have the correct modifier.";
        assertTrue(chassis.hasField("materialType", String.class), incorrectFieldMessage);
        assertTrue(chassis.hasModifier("materialType", "private"), incorrectModifierMessage);
    }

    @Test
    public void wheelClassHasRequiredConstructor() {
        Class<?>[] classArguments = {double.class, String.class};
        assertTrue(wheel.hasConstructor(classArguments),
                "Your Wheel constructor does not have the correct parameters.");
        assertTrue(wheel.hasModifier(classArguments, "public"),
                "Your Wheel constructor does not have the correct modifiers.");
    }

    @Test
    public void chassisCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class};
        assertTrue(chassis.hasConstructor(classArguments),
                "Your Chassis constructor does not have the correct parameters.");
        assertTrue(chassis.hasModifier(classArguments, "public"),
                "Your Chassis constructor does not have the correct modifiers.");
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
        _assertEquals(d, wheel.getFieldValue(wheelInstance, "durability"),
                "Your Wheel constructor does not correctly initialize the durability field.");
        _assertEquals(m, wheel.getFieldValue(wheelInstance, "manufacturer"),
                "Your Wheel constructor does not correctly initialize the manufacturer field.");
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
        String ans = "Wheel{durability = " + d + ", manufacturer = " + m + "}";
        _assertEquals(ans, wheelToStringOutput, "Your Wheel toString method does not return the correct string.");
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
        _assertEquals(material, chassis.getFieldValue(chassisInstance, "materialType"),
                "Your Chassis constructor does not correctly initialize the materialType field.");
    }

    @ParameterizedTest
    @MethodSource("chassisInputProvider")
    public void chassisToStringMethod(String material) throws Throwable {
        Object[][] arguments = {
                {material, String.class}
        };
        Object chassisInstance = chassis.createInstance(arguments);
        Object chassisToStringOutput = chassis.callMethod("toString", chassisInstance);
        String ans = "Chassis{materialType = " + material + "}";
        _assertEquals(ans, chassisToStringOutput, "Your Chassis toString method does not return the correct string.");
    }

}
