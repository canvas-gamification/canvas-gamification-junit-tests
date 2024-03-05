package oop.creating_objects_from_classes.hard.q1;

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
    private ObjectTest testDog;
    private final String testDogName = "TestDog";
    private final String noiseMethodName = "bark";
    private final String consumeMethodName = "eat";
    private final String objectName = "Dog";
    private final String expectedDogName = "Piper";
    private final int expectedDogAge = 8;
    private final double expectedDogWeight = 12.5;
    private final double dogEatIncrease = 2.5;
    private final String name = "name";
    private final String age = "age";
    private final String weight = "weight";

    @BeforeEach
    public void setUp() {
        String testDogString = "oop.creating_objects_from_classes.hard.q1." + testDogName;
        testDog = new ObjectTest(testDogString);
    }

    @Test
    public void correctDogTestClass() throws Throwable {
        String missingMain = "Your %s class is missing the %s method. Make sure it has been declared, it is spelt correctly, and has the correct parameters.";
        String incorrectVisibility = "Your main method does not have the correct visibility modifier.";
        String missingStatic = "Your main method is missing the static modifier.";
        String wrongReturnType = "Your main method does not have the correct return type.";
        Class<?>[] mainArgs = new Class[]{String[].class};
        /* Check Method Definitions */
        assertTrue(testDog.hasMethod("main", mainArgs), String.format(missingMain, testDogName, "main"));
        assertTrue(testDog.hasModifier("main", mainArgs, "public"), incorrectVisibility);
        assertTrue(testDog.hasModifier("main", mainArgs, "static"), missingStatic);
        assertTrue(testDog.hasReturnType("main", mainArgs, Void.TYPE), wrongReturnType);

        String incorrectOutput = "Your main method in the %s class does not print the correct output. Make sure that you call the %s method.";
        Clause[] clauses = new Clause[]{
                new StringLiteral("Bark\\!"),
                new Optional(new NewLine())
        };
        Object[][] mainParameters = {{new String[0], String[].class}};
        /* Call method and check printed output */
        testDog.callMethod("main", mainParameters, clauses, String.format(incorrectOutput, testDogName, noiseMethodName));

        /* Check that the constructor was called and with the correct values */
        String noConstructorCall = "Your main method did not initialize a %s object.";
        String incorrectValue = "Your main method did not initialize a %s with the correct %s value.";
        assertTrue(Dog.getConstructorCalled(), String.format(noConstructorCall, objectName));
        assertEquals(expectedDogName, Dog.getConstructorName(), String.format(incorrectValue, objectName, name));
        assertEquals(expectedDogAge, Dog.getConstructorAge(), String.format(incorrectValue, objectName, age));
        assertEquals(expectedDogWeight, Dog.getConstructorWeight(), 0.001, String.format(incorrectValue, objectName, weight));

        /* Check that methods were called */
        String methodNotCalled = "Your main method did not call the %s method.";
        assertTrue(Dog.getBarkCalled(), String.format(methodNotCalled, noiseMethodName));
        assertTrue(Dog.getEatCalled(), String.format(methodNotCalled, consumeMethodName));
    }
}

// On website place Dog class here
