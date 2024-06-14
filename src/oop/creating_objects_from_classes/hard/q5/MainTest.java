package oop.creating_objects_from_classes.hard.q5;

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
    private ObjectTest testBall;
    private final String testBallName = "SportsRoom";
    private final String inflateMethodName = "inflate";
    private final String playGameMethodName = "playGame";
    private final String orderMoreMethodName = "orderMore";
    private final String objectName = "Basketball";
    private final double expectedSize = 28.5;
    private final String expectedCondition = "poor";
    private final String size = "size";
    private final String condition = "condition";
    private final int newBallsOrdered = 5;

    @BeforeEach
    public void setUp() {
        String sportsRoomString = "oop.creating_objects_from_classes.hard.q5." + testBallName;
        testBall = new ObjectTest(sportsRoomString);
    }

    @Test
    public void correctSportsRoomClass() throws Throwable {
        String missingMain = "Your %s class is missing the %s method. Make sure it has been declared, it is spelt correctly, and has the correct parameters.";
        String incorrectVisibility = "Your main method does not have the correct visibility modifier.";
        String missingStatic = "Your main method is missing the static modifier.";
        String wrongReturnType = "Your main method does not have the correct return type.";
        Class<?>[] mainArgs = new Class[]{String[].class};
        /* Check Method Definitions */
        assertTrue(testBall.hasMethod("main", mainArgs), String.format(missingMain, testBallName, "main"));
        assertTrue(testBall.hasModifier("main", mainArgs, "public"), incorrectVisibility);
        assertTrue(testBall.hasModifier("main", mainArgs, "static"), missingStatic);
        assertTrue(testBall.hasReturnType("main", mainArgs, Void.TYPE), wrongReturnType);

        String incorrectOutput = "Your main method in the %s class does not print the correct output. Make sure that you call the %s method.";
        Clause[] clauses = new Clause[]{
                new StringLiteral("Cheers\\!"),
                new Optional(new NewLine())
        };
        Object[][] mainParameters = {{new String[0], String[].class}};
        /* Call method and check printed output */
        testBall.callMethod("main", mainParameters, clauses, String.format(incorrectOutput, testBallName, playGameMethodName));

        /* Check that the constructor was called and with the correct values */
        String noConstructorCall = "Your main method did not initialize a %s object.";
        String incorrectValue = "Your main method did not initialize a %s with the correct %s value.";
        assertTrue(Basketball.isConstructorCalled(), String.format(noConstructorCall, objectName));
        assertEquals(expectedSize, Basketball.getConstructorSize(), String.format(incorrectValue, objectName, size));
        assertEquals(expectedCondition, Basketball.getConstructorCondition(), String.format(incorrectValue, objectName, condition));

        /* Check that methods were called */
        String methodNotCalled = "Your main method did not call the %s method.";
        assertTrue(Basketball.isInflateCalled(), String.format(methodNotCalled, inflateMethodName));
        assertTrue(Basketball.isOrderMoreCalled(), String.format(methodNotCalled, orderMoreMethodName));
        assertEquals(newBallsOrdered, Basketball.getNumber(), "Your main method did not request the correct number of new balls.");
        assertTrue(Basketball.isPlayGameCalled(), String.format(methodNotCalled, playGameMethodName));
        assertEquals(Basketball.getOtherBalls()[0], Basketball.getBallInPlay(), String.format("Your main method did not call the %s method on the correct ball.", playGameMethodName));
    }
}

// On website place Basketball class here

