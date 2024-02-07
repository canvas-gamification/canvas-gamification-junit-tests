package oop.creating_objects_from_classes.hard.q2;

import global.ObjectTest;
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
    private ObjectTest summerFunTest;
    private final String testName = "SummerFun";
    private final String inflateName = "Inflate";
    private final String throwInPoolName = "throwInPool";
    private final String objectName = "WaterToy";
    private final String expectedToyColour = "yellow";
    private final double expectedToySize = 5.2;
    private final boolean expectedToyInflated = false;
    private final String stringFieldName = "colour";
    private final String doubleFieldName = "size";
    private final String booleanFieldName = "inflated";

    @BeforeEach
    public void setUp() {
        String testClassString = "oop.creating_objects_from_classes.hard.q2." + testName;
        summerFunTest = new ObjectTest(testClassString);
    }

    @Test
    public void correctSummerFunClass() throws Throwable {
        String missingMain = "Your %s class is missing the %s method. Make sure it has been declared, it is spelt correctly, and has the correct parameters.";
        String incorrectVisibility = "Your main method does not have the correct visibility modifier.";
        String missingStatic = "Your main method is missing the static modifier.";
        String wrongReturnType = "Your main method does not have the correct return type.";
        Class<?>[] mainArgs = new Class[]{String[].class};
        /* Check Method Definitions */
        assertTrue(summerFunTest.hasMethod("main", mainArgs), String.format(missingMain, testName, "main"));
        assertTrue(summerFunTest.hasModifier("main", mainArgs, "public"), incorrectVisibility);
        assertTrue(summerFunTest.hasModifier("main", mainArgs, "static"), missingStatic);
        assertTrue(summerFunTest.hasReturnType("main", mainArgs, Void.TYPE), wrongReturnType);

        String incorrectOutput = "Your main method in the %s class does not print the correct output. Make sure that you call the %s method.";
        Clause[] clauses = new Clause[]{
                new StringLiteral("Splash\\!"),
                new Optional(new NewLine())
        };
        Object[][] mainParameters = {{new String[0], String[].class}};
        /* Call method and check printed output */
        summerFunTest.callMethod("main", mainParameters, clauses, String.format(incorrectOutput, testName, throwInPoolName));

        /* Check that the constructor was called and with the correct values */
        String noConstructorCall = "Your main method did not initialize a %s object.";
        String incorrectValue = "Your main method did not initialize a %s with the correct %s value.";
        assertTrue(WaterToy.isConstructorCalled(), String.format(noConstructorCall, objectName));
        assertEquals(expectedToyColour, WaterToy.getConstructedColour(), String.format(incorrectValue, objectName, stringFieldName));
        assertEquals(expectedToySize, WaterToy.getConstructedSize(), String.format(incorrectValue, objectName, doubleFieldName));
        assertEquals(expectedToyInflated, WaterToy.isConstructedInflated(), String.format(incorrectValue, objectName, booleanFieldName));

        /* Check that methods were called */
        String methodNotCalled = "Your main method did not call the %s method.";
        assertTrue(WaterToy.isThrowInPoolCalled(), String.format(methodNotCalled, throwInPoolName));
        assertTrue(WaterToy.isInflateCalled(), String.format(methodNotCalled, inflateName));
    }

}

// On website place WaterToy class here
