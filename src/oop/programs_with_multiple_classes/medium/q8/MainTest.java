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

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Java

    private final String classLight = "Light";
    private final String classKitchen = "Kitchen";
    private final String varOn = "isOn";
    private final String varType = "type";
    private final String varSize = "size";
    private final String varCap = "personCapacity";
    private final String varLights = "lights";
    public ObjectTest light;
    public ObjectTest kitchen;

    public Clause[] testSentence() {
        return new Clause[0];
    }

    public void runMain() {
    }

    @BeforeEach
    public void setup() throws Throwable {
        String lightClassString = "oop.programs_with_multiple_classes.medium.q8." + classLight;
        String kitchenClassString = "oop.programs_with_multiple_classes.medium.q8." + classKitchen;
        light = new ObjectTest(lightClassString);
        kitchen = new ObjectTest(kitchenClassString);
        String modifiedLightMessage =
                "You have modified the provided portions of class " + classLight + ". Please revert them to the original state.";
        assertTrue(light.hasField(varOn, boolean.class), modifiedLightMessage);
        assertTrue(light.hasModifier(varOn, "private"), modifiedLightMessage);
        assertTrue(light.hasField(varType, String.class), modifiedLightMessage);
        assertTrue(light.hasModifier(varType, "private"), modifiedLightMessage);
        String modifiedKitchenMessage =
                "You have modified the provided portions of class " + classKitchen + ". Please revert them to the original state.";
        Class<?>[] classArguments = {int.class, int.class};
        assertTrue(kitchen.hasConstructor(classArguments), modifiedKitchenMessage);
        assertTrue(kitchen.hasModifier(classArguments, "public"), modifiedKitchenMessage);

        Object[][] test = new Object[][]{{10, 15}, {20, 30}, {150, 40}};
        for (int num = 0; num < test.length; num++) {
            int size = (int) test[num][0];
            int personCapacity = (int) test[num][1];
            Object[][] arguments = {
                    {size, int.class},
                    {personCapacity, int.class}
            };
            Object kitchenInstance = kitchen.createInstance(arguments);
            _assertEquals(size, kitchen.getFieldValue(kitchenInstance, varSize), modifiedKitchenMessage);
            _assertEquals(personCapacity, kitchen.getFieldValue(kitchenInstance, varCap), modifiedKitchenMessage);
            _assertArrayEquals(new Light[size], kitchen.getFieldValue(kitchenInstance, varLights), modifiedKitchenMessage);
        }
    }

    @Test
    public void kitchenClassHasCorrectAttributes() {
        assertTrue(kitchen.hasField(varSize, int.class),
                "Your " + classKitchen + " class is missing the " + varSize + " attribute.");
        assertTrue(kitchen.hasModifier(varSize, "private"),
                "Your " + classKitchen + " class attributes does not have the correct modifier for " + varSize + " attribute.");
        assertTrue(kitchen.hasField(varCap, int.class),
                "Your " + classKitchen + " class is missing the " + varCap + " attribute.");
        assertTrue(kitchen.hasModifier(varCap, "private"),
                "Your " + classKitchen + " class attributes does not have the correct modifier for " + varCap + " attribute.");
        assertTrue(kitchen.hasField(varLights, Light[].class),
                "Your " + classKitchen + " class is missing the " + varLights + " attribute.");
        assertTrue(kitchen.hasModifier(varLights, "private"),
                "Your " + classKitchen + " class attributes does not have the correct modifier for " + varLights + " attribute.");
    }

    @Test
    public void lightClassHasRequiredConstructor() {
        Class<?>[] classArguments = {boolean.class, String.class};
        assertTrue(light.hasConstructor(classArguments),
                "Your " + classLight + " constructor does not have the correct parameters.");
        assertTrue(light.hasModifier(classArguments, "public"),
                "Your " + classLight + " constructor does not have the correct visibility modifier.");
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
        _assertEquals(isOn, light.getFieldValue(lightInstance, varOn),
                "Your " + classLight + " constructor does not correctly initialize the " + varOn + " field.");
        _assertEquals(type, light.getFieldValue(lightInstance, varType),
                "Your " + classLight + " constructor does not correctly initialize the " + varType + " field.");
    }

    private static Stream<Arguments> kitchenInputProvider() {
        return Stream.of(
                Arguments.of(-10, 15),
                Arguments.of(-20, 30),
                Arguments.of(-150, 40)
        );
    }

    @ParameterizedTest
    @MethodSource("kitchenInputProvider")
    public void lightConstructorInitializesValuesCorrectly(int size, int personCapacity) throws Throwable {
        Object[][] arguments = {
                {size, int.class},
                {personCapacity, int.class}
        };
        Object kitchenInstance = kitchen.createInstance(arguments);
        _assertEquals(0, kitchen.getFieldValue(kitchenInstance, varSize),
                "Your " + classKitchen + " constructor does not correctly initialize the " + varSize + " field when given a negative value.");
        _assertEquals(personCapacity, kitchen.getFieldValue(kitchenInstance, varCap),
                "Your " + classKitchen + " constructor does not correctly initialize the " + varCap + " field when given a negative value.");
    }

}
