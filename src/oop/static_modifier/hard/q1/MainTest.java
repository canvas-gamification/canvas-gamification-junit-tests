package oop.static_modifier.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private final String fenceName = "Fence";
    private final String testFenceName = "TestPainting";
    private ObjectTest fence;
    private ObjectTest testFence;
    private final String colourArrayAttributeName = "colours";
    private final String amountLeftAttributeName = "leftoverAmount";
    private final String colourAttributeName = "colour";

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

    }
}
