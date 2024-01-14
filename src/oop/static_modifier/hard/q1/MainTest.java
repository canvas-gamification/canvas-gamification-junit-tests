package oop.static_modifier.hard.q1;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    private final String paintMethodName = "paintColour";

    @BeforeEach
    public void setup() {
        String fenceClass = "oop.static_modifier.hard.q1." + fenceName;
        String testFenceClass = "oop.static_modifier.hard.q1." + testFenceName;
        fence = new ObjectTest(fenceClass);
        testFence = new ObjectTest(testFenceClass);
    }

    @Test
    @Order(1)
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
    @Order(2)
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
    @Order(3)
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
    @Order(4)
    public void fenceConstructorInitializesAttributesCorrectly(String input, String value) throws Throwable {
        Object[][] constructorInput = {{input, String.class}};
        Object fenceInstance = fence.createInstance(constructorInput);
        _assertEquals(value, fence.getFieldValue(fenceInstance, colourAttributeName), String.format("The %s constructor does not initialize the %s field to the correct value.", fenceName, colourAttributeName));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    @Order(5)
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

    private static Stream<Arguments> paintColourInputProvider() {
        return Stream.of(
                Arguments.of("Yellow", "Blue", 100.01, "Yellow", false, new double[]{100.00, 100.00, 100.00, 100.00, 100.00, 100.00, 100.00, 100.00}),
                Arguments.of("Green", "White", 25.00, "White", true, new double[]{100.00, 100.00, 100.00, 100.00, 100.00, 75.00, 100.00, 100.00}),
                Arguments.of("Purple", "Green", 0.0, "Green", true, new double[]{100.00, 100.00, 100.00, 100.00, 100.00, 75.00, 100.00, 100.00}),
                Arguments.of("Brown", "White", 48.21, "White", true, new double[]{100.00, 100.00, 100.00, 100.00, 100.00, 26.79, 100.00, 100.00}),
                Arguments.of("Black", "White", 26.92, "Black", false, new double[]{100.00, 100.00, 100.00, 100.00, 100.00, 26.79, 100.00, 100.00}),
                Arguments.of("Green", "Blue", 100.00, "Blue", true, new double[]{100.00, 0, 100.00, 100.00, 100.00, 26.79, 100.00, 100.00}),
                Arguments.of("White", "Brown", 43.12, "Brown", true, new double[]{100.00, 0, 100.00, 100.00, 100.00, 26.79, 100.00, 56.88}),
                Arguments.of("Purple", "Red", 68.312, "Red", true, new double[]{31.688, 0, 100.00, 100.00, 100.00, 26.79, 100.00, 56.88}),
                Arguments.of("Black", "Purple", 78.55468, "Purple", true, new double[]{31.688, 0, 100.00, 100.00, 100.00, 26.79, 21.44532, 56.88})
        );
    }

    private static Stream<Arguments> invalidPaintColourInputProvider() {
        return Stream.of(
                Arguments.of("Red", "blue", 35.64),
                Arguments.of("Brown", "Purples", 23.23),
                Arguments.of("Blue", "", 12.31),
                Arguments.of("White", "Blck", 23.24)
        );
    }

    @Test
    @Order(6)
    @Tag("dependent1")
    public void paintColourMethodIsCorrectlyDefined() {
        String missingMethod = "The %s class is missing the %s method. Make sure it is defined, spelt correctly, and accepts the required parameters.";
        Class<?>[] parameterClasses = new Class[]{String.class, double.class};
        assertTrue(fence.hasMethod(paintMethodName, parameterClasses),
                String.format(missingMethod, fenceName, paintMethodName));
        String wrongVisibilityModifier = "The %s method in the %s class has the wrong visibility modifier.";
        assertTrue(fence.hasModifier(paintMethodName, parameterClasses, "public"),
                String.format(wrongVisibilityModifier, paintMethodName, fenceName));
        String wrongReturnType = "The %s method in the %s method does not have the correct return type.";
        assertTrue(fence.hasReturnType(paintMethodName, parameterClasses, Void.TYPE),
                String.format(wrongReturnType, fenceName, paintMethodName));
    }

    @ParameterizedTest
    @MethodSource("invalidPaintColourInputProvider")
    @Order(8)
    @Tag("dependent1")
    public void paintCourMethodCorrectlyIdentifiesInvalidInput(String initialColour, String inputColour, double amountToUse) throws Throwable {
        resetLeftover();
        Object[][] constructorInput = {{initialColour, String.class}};
        Object fenceInstance = fence.createInstance(constructorInput);
        Object[][] paintArguments = {{inputColour, String.class}, {amountToUse, double.class}};
        Clause[] clauses = {
                new StringLiteral("The input colour does not match any of the paint colours\\."),
                new Optional(new NewLine())
        };
        String incorrectMessage = String.format("The %s method does not correctly identify and print that the input colour is not a valid option.", paintMethodName);
        fence.callMethod(paintMethodName, paintArguments, null, fenceInstance, clauses, incorrectMessage);
        _assertArrayEquals(amountLeftArray, fence.getFieldValue(null, amountLeftAttributeName),
                String.format("The %s method should not update the %s attribute if invalid input is detected.", paintMethodName, amountLeftAttributeName));
    }

    @ParameterizedTest
    @MethodSource("paintColourInputProvider")
    @Order(7)
    @Tag("dependent1")
    public void paintColourMethodPaintsFencesCorrectly(String initialColour, String inputColour, double amountToUse, String outputColour, boolean colourChange, double[] leftoverAmount) throws Throwable {
        Object[][] constructorInput = {{initialColour, String.class}};
        Object fenceInstance = fence.createInstance(constructorInput);
        Object[][] paintArguments = {{inputColour, String.class}, {amountToUse, double.class}};
        Clause[] clauses;
        String resultColour = outputColour;
        String incorrectLeftover;
        if (!colourChange) {
            clauses = new Clause[]{
                    new StringLiteral("There is not enough "),
                    new StringLiteral(inputColour),
                    new StringLiteral(" paint for this job\\."),
                    new Optional(new NewLine())
            };
            resultColour = initialColour;
            incorrectLeftover = String.format("The %s method should not modify the %s field if there is not enough paint for the job.", paintMethodName, amountLeftAttributeName);
        } else {
            clauses = null;
            incorrectLeftover = String.format("The %s method does not correctly update the %s field when a %s is painted.", paintMethodName, amountLeftAttributeName, fenceName);
        }
        String notEnoughPaintMessage = String.format("The %s method does not correctly detect and print that there is not enough paint to perform the paint job.", paintMethodName);
        fence.callMethod(paintMethodName, paintArguments, null, fenceInstance, clauses, notEnoughPaintMessage);
        String incorrectColour = "The %s method does not change the %s attribute to the correct value when there is enough paint for the fence";
        _assertEquals(resultColour, fence.getFieldValue(fenceInstance, colourAttributeName), String.format(incorrectColour, paintMethodName, colourAttributeName));
        _assertArrayEquals(leftoverAmount, fence.getFieldValue(null, amountLeftAttributeName), 0.001, incorrectLeftover);
    }

    @Test
    @Order(9)
    @Tag("dependency1")
    public void testPaintingMainMethodProducesCorrectOutput() throws Throwable{
        resetLeftover();
        Clause[] clauses = {
                new StringLiteral("My paint colour is Brown\\."),
                new NewLine(),
                new StringLiteral("My paint colour is Brown\\."),
                new NewLine(),
                new StringLiteral("There is not enough Brown paint for this job\\."),
                new NewLine(),
                new StringLiteral("My paint colour is Yellow\\.")
        };
        String incorrectMainOutput = "Your main method in the %s class does not print the correct output.";
        Object[][] mainArguments = {{new String[0], String[].class}};
        testFence.callMethod("main", mainArguments, clauses, String.format(incorrectMainOutput, testFenceName));
    }

    private void resetLeftover() {
        double[] resetArray = new double[]{100.00, 100.00, 100.00, 100.00, 100.00, 100.00, 100.00, 100.00};
        fence.setFieldValue(null, resetArray, amountLeftAttributeName);
    }
}
