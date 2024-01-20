package oop.creating_objects_from_classes.hard.q6;

import global.ObjectTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private ObjectTest testMartini;
    private final String testMartiniName = "OrderDrink";
    private final String mixMethodName = "mix";
    private final String detectFlavourMethodName = "detectFlavour";
    private final String objectName = "Martini";
    private final String[] expectedIngredients = {"vodka", "lemon juice", "syrup", "triple sec"};
    private final double expectedPercentAlcohol = 15;
    private final String ingredients = "ingredients";
    private final String percentAlcohol = "percentAlcohol";

    @BeforeEach
    public void setUp() {
        String testMartiniString = "oop.creating_objects_from_classes.hard.q6." + testMartiniName;
        testMartini = new ObjectTest(testMartiniString);
    }

    @Test
    public void correctMartiniTestClass() throws Throwable {
        String missingMain = "Your %s class is missing the %s method. Make sure it has been declared, it is spelt correctly, and has the correct parameters.";
        String incorrectVisibility = "Your main method does not have the correct visibility modifier.";
        String missingStatic = "Your main method is missing the static modifier.";
        String wrongReturnType = "Your main method does not have the correct return type.";
        Class<?>[] mainArgs = new Class[]{String[].class};
        /* Check Method Definitions */
        assertTrue(testMartini.hasMethod("main", mainArgs), String.format(missingMain, testMartiniName, "main"));
        assertTrue(testMartini.hasModifier("main", mainArgs, "public"), incorrectVisibility);
        assertTrue(testMartini.hasModifier("main", mainArgs, "static"), missingStatic);
        assertTrue(testMartini.hasReturnType("main", mainArgs, Void.TYPE), wrongReturnType);

        String incorrectOutput = "Your main method in the %s class does not print the correct output. Make sure that you call the %s method.";
        Clause[] clauses = new Clause[]{
                new StringLiteral("vodka|lemon juice|syrup|triple sec"),
                new Optional(new NewLine())
        };
        Object[][] mainParameters = {{new String[0], String[].class}};
        /* Call method and check printed output */
        testMartini.callMethod("main", mainParameters, clauses, String.format(incorrectOutput, testMartiniName, detectFlavourMethodName));

        /* Check that the constructor was called and with the correct values */
        String noConstructorCall = "Your main method did not initialize a %s object.";
        String incorrectValue = "Your main method did not initialize a %s with the correct %s value.";
        assertTrue(Martini.isConstructorCalled(), String.format(noConstructorCall, objectName));
        CustomAssertions._assertArrayEquals(expectedIngredients, Martini.getConstructorIngredients(), String.format(incorrectValue, objectName, ingredients));
        assertEquals(expectedPercentAlcohol, Martini.getConstructorPercentAlcohol(), String.format(incorrectValue, objectName, percentAlcohol));

        /* Check that methods were called */
        String methodNotCalled = "Your main method did not call the %s method.";
        assertTrue(Martini.isMixCalled(), String.format(methodNotCalled, mixMethodName));
        assertTrue(Martini.isDetectFlavourCalled(), String.format(methodNotCalled, detectFlavourMethodName));
    }
}

// On website place Martini class here
