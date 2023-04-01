package oop.programs_with_multiple_classes.medium.q8;

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
    public ObjectTest light;
    public ObjectTest kitchen;

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @BeforeEach
    public void setup() {
        String lightClassString = "oop.programs_with_multiple_classes.medium.q8.Light";
        String kitchenClassString = "oop.programs_with_multiple_classes.medium.q8.Kitchen";
        light = new ObjectTest(lightClassString);
        kitchen = new ObjectTest(kitchenClassString);
    }

    @Test
    public void lightClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Light class is missing a required field.";
        String incorrectModifierMessage = "One of your Light class attributes does not have the correct modifier.";
        assertTrue(light.hasField("isOn", boolean.class), incorrectFieldMessage);
        assertTrue(light.hasModifier("isOn", "private"), incorrectModifierMessage);
        assertTrue(light.hasField("type", String.class), incorrectFieldMessage);
        assertTrue(light.hasModifier("type", "private"), incorrectModifierMessage);
    }

    @Test
    public void kitchenClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Kitchen class is missing a required field.";
        String incorrectModifierMessage = "One of your Kitchen class attributes does not have the correct modifier.";
        assertTrue(kitchen.hasField("size", int.class), incorrectFieldMessage);
        assertTrue(kitchen.hasModifier("size", "private"), incorrectModifierMessage);
        assertTrue(kitchen.hasField("personCapacity", int.class), incorrectFieldMessage);
        assertTrue(kitchen.hasModifier("personCapacity", "private"), incorrectModifierMessage);
    }

    @Test
    public void lightClassHasRequiredConstructor() {
        Class<?>[] classArguments = {boolean.class, String.class};
        assertTrue(light.hasConstructor(classArguments),
                "Your Light constructor does not have the correct parameters.");
        assertTrue(light.hasModifier(classArguments, "public"),
                "Your Light constructor does not have the correct modifier.");
    }

    @Test
    public void kitchenCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, int.class};
        assertTrue(kitchen.hasConstructor(classArguments),
                "Your Kitchen constructor does not have the correct parameters.");
        assertTrue(kitchen.hasModifier(classArguments, "public"),
                "Your Kitchen constructor does not have the correct modifier.");
    }

    private static Stream<Arguments> lightInputProvider() {
        return Stream.of(
                Arguments.of(true, "Plastic"),
                Arguments.of(false, "Wood"),
                Arguments.of(false, "Steel"),
                Arguments.of(true, "Titanium")
        );
    }

    @ParameterizedTest
    @MethodSource("lightInputProvider")
    public void lightConstructorInitializesValuesCorrectly(boolean isOn, String type) throws Throwable {
        Object[][] arguments = {
                {isOn, boolean.class},
                {type, String.class}
        };
        Object lightInstance = light.createInstance(arguments);
        _assertEquals(isOn, light.getFieldValue(lightInstance, "isOn"),
                "Your Light constructor does not correctly initialize the isOn field.");
        _assertEquals(type, light.getFieldValue(lightInstance, "type"),
                "Your Light constructor does not correctly initialize the type field.");
    }

    @ParameterizedTest
    @MethodSource("lightInputProvider")
    public void correctLightToStringMethod(boolean isOn, String type) throws Throwable {
        Object[][] arguments = {
                {isOn, boolean.class},
                {type, String.class}
        };
        Object lightInstance = light.createInstance(arguments);
        Object lightToStringOutput = light.callMethod("toString", lightInstance);
        String ans = "Light{isOn = " + isOn + ", type = " + type + "}";
        _assertEquals(ans, lightToStringOutput, "Your Light toString method does not return the correct string.");
    }

    private static Stream<Arguments> kitchenInputProvider() {
        return Stream.of(
                Arguments.of(10, 15),
                Arguments.of(20, 30),
                Arguments.of(150, 40)
        );
    }

    @ParameterizedTest
    @MethodSource("kitchenInputProvider")
    public void kitchenConstructorInitializesValuesCorrectly(int size, int personCapacity) throws Throwable {
        Object[][] arguments = {
                {size, int.class},
                {personCapacity, int.class}
        };
        Object kitchenInstance = kitchen.createInstance(arguments);
        _assertEquals(size, kitchen.getFieldValue(kitchenInstance, "size"),
                "Your Kitchen constructor does not correctly initialize the size field.");
        _assertEquals(personCapacity, kitchen.getFieldValue(kitchenInstance, "personCapacity"),
                "Your Kitchen constructor does not correctly initialize the personCapacity field.");
    }

    @ParameterizedTest
    @MethodSource("kitchenInputProvider")
    public void correctKitchenToStringMethod(int size, int personCapacity) throws Throwable {
        Object[][] arguments = {
                {size, int.class},
                {personCapacity, int.class}
        };
        Object kitchenInstance = kitchen.createInstance(arguments);
        Object kitchenToStringOutput = kitchen.callMethod("toString", kitchenInstance);
        String ans = "Kitchen{size= " + size + ", personCapacity = " + personCapacity + "}";
        _assertEquals(ans, kitchenToStringOutput, "Your Kitchen toString method does not return the correct string.");
    }

}
