package oop.static_modifier.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private final String fenceName = "Fence";
    private final String testFenceName = "TestPainting";
    private ObjectTest fence;
    private ObjectTest testFence;
    private final String colourArrayAttributeName = "colours";
    private final String amountLeftAttributeName = "leftoverAmount";
    private final String colourAttributeName = "colour";
    private static final String defaultColour = "Blue";
    private final String[] coloursArray = new String[]{"Red", "Blue", "Green", "Yellow", "Black", "White", "Purple", "Brown"};
    private final double[] amountLeftArray = new double[]{100, 100, 100, 100, 100, 100, 100, 100};

    @BeforeEach
    public void setup() {
        String fenceClass = "oop.static_modifier.hard.q1." + fenceName;
        String testFenceClass = "oop.static_modifier.hard.q1." + testFenceName;
        fence = new ObjectTest(fenceClass);
        testFence = new ObjectTest(testFenceClass);
    }

    @Test
    public void fenceClassHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute or it is spelt incorrectly.";
        String wrongAttributeTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongVisibilityModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        String shouldBeStaticMessage = "The %s attribute in the %s class should be static.";
        /* Colour Attribute */
        assertTrue(fence.hasField(colourAttributeName), String.format(missingAttributeMessage, fenceName, colourAttributeName));
        assertTrue(fence.hasField(colourAttributeName, String.class), String.format(wrongAttributeTypeMessage, colourAttributeName, fenceName));
        assertTrue(fence.hasModifier(colourAttributeName, "private"), String.format(wrongVisibilityModifierMessage, colourAttributeName, fenceName));
        assertFalse(fence.hasModifier(colourAttributeName, "static"), String.format("The %s attribute in the %s class should not be static.", colourAttributeName, fenceName));

        /* Colours Attribute */
        assertTrue(fence.hasField(colourArrayAttributeName), String.format(missingAttributeMessage, fenceName, colourArrayAttributeName));
        assertTrue(fence.hasField(colourArrayAttributeName, String[].class), String.format(wrongAttributeTypeMessage, colourArrayAttributeName, fenceName));
        assertTrue(fence.hasModifier(colourArrayAttributeName, "private"), String.format(wrongVisibilityModifierMessage, colourArrayAttributeName, fenceName));
        assertTrue(fence.hasModifier(colourArrayAttributeName, "static"), String.format(shouldBeStaticMessage, colourArrayAttributeName, fenceName));

        /* Amount Left Attribute */
        assertTrue(fence.hasField(amountLeftAttributeName), String.format(missingAttributeMessage, fenceName, amountLeftAttributeName));
        assertTrue(fence.hasField(amountLeftAttributeName, double[].class), String.format(wrongAttributeTypeMessage, amountLeftAttributeName, fenceName));
        assertTrue(fence.hasModifier(amountLeftAttributeName, "private"), String.format(wrongVisibilityModifierMessage, amountLeftAttributeName, fenceName));
        assertTrue(fence.hasModifier(amountLeftAttributeName, "static"), String.format(shouldBeStaticMessage, amountLeftAttributeName, fenceName));
    }

    @Test
    public void fenceClassHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor.";
        String incorrectVisibilityModifierMessage = "The constructor for the %s class has the wrong visibility modifier";
        Class<?>[] classes = new Class[]{String.class};
        assertTrue(fence.hasConstructor(classes), String.format(missingConstructorMessage, fenceName));
        assertTrue(fence.hasModifier(classes, "public"), String.format(incorrectVisibilityModifierMessage, fenceName));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("blue", defaultColour),
                Arguments.of("Blue", "Blue"),
                Arguments.of("green", defaultColour),
                Arguments.of("Purpl", defaultColour),
                Arguments.of("White", "White"),
                Arguments.of("Red", "Red"),
                Arguments.of("Blacks", defaultColour),
                Arguments.of("Black", "Black"),
                Arguments.of("Brwon", defaultColour),
                Arguments.of("Brown", "Brown")
        );
    }

    @Test
    public void fenceClassInitializesStaticAttributesCorrectly() {
        String notNullArrayMessage = "The %s array in the %s class was not initialized. Make sure it is not initialized in the constructor.";
        assertNotNull(fence.getFieldValue(null, colourArrayAttributeName), String.format(notNullArrayMessage, colourArrayAttributeName, fenceName));
        String incorrectArrayMessage = "The %s array in the %s class was not initialized correctly. Make sure that all the required values are present.";
        _assertArrayEquals(coloursArray, fence.getFieldValue(null, colourArrayAttributeName),
                String.format(incorrectArrayMessage, colourArrayAttributeName, fenceName));
        assertNotNull(fence.getFieldValue(null, amountLeftAttributeName), String.format(notNullArrayMessage, amountLeftAttributeName, fenceName));
        String incorrectColourArrayMessage = "The %s array in the %s class was not initialized correctly. Make sure that all the required values are present.";
        _assertArrayEquals(amountLeftArray, fence.getFieldValue(null, amountLeftAttributeName),
                String.format(incorrectArrayMessage, amountLeftAttributeName, fenceName));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void fenceConstructorInitializesAttributesCorrectly(String input, String value) throws Throwable {
        Object[][] constructorInput = {{input, String.class}};
        Object fenceInstance = fence.createInstance(constructorInput);
        _assertEquals(value, fence.getFieldValue(fenceInstance, colourAttributeName), String.format("The %s constructor does not initialize the %s field to the correct value.", fenceName, colourAttributeName));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void fenceClassHasCorrectToStringMethod(String input, String value) throws Throwable {
        assertTrue(fence.hasMethod("toString", null, String.class, new String[]{"public"}),
                String.format("The %s class is missing the toString method.", fenceName));
        Object[][] constructorInput = {{input, String.class}};
        Object fenceInstance = fence.createInstance(constructorInput);
        String expectedToStringOutput = String.format("My paint colour is %s.", value);
        Object actualToStringOutput = fence.callMethod("toString", fenceInstance);
        String incorrectToString = "The toString method for the %s class does not return the correct value.";
        _assertEquals(expectedToStringOutput, actualToStringOutput, String.format(incorrectToString, fenceName));
    }

}
