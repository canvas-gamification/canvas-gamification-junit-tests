package oop.programs_with_interesting_classes.medium.q4;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    /* Parsons Question */
    private ObjectTest mario;
    private ObjectTest testPlatformer;
    private final String marioClassName = "Mario";
    private final String testPlatformerClassName = "TestPlatformer";
    private final String intAttributeName = "jumpHeight";
    private final String booleanAttributeName1 = "activePowerUp";
    private final String booleanAttributeName2 = "isDead";
    private final String jumpMethodName = "jump";
    private final String eatPowerUpMethodName = "eatPowerUp";
    private final String takeDamageMethodName = "takeDamage";
    private final int defaultJumpHeight = 1;
    private final String expectedString = "I can jump %s units high, my power up state is %s, and I am %s.";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.medium.q4.";
        mario = new ObjectTest(packageString + marioClassName);
        testPlatformer = new ObjectTest(packageString + testPlatformerClassName);
    }

    /* Test if the mario class has the required attributes */

    @Test
    public void marioClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(mario.hasField(intAttributeName), String.format(missingAttribute, marioClassName, intAttributeName));
        assertTrue(mario.hasField(intAttributeName, int.class), String.format(incorrectType, intAttributeName));
        assertTrue(mario.hasModifier(intAttributeName, "private"), String.format(incorrectModifier, intAttributeName));
        assertTrue(mario.hasField(booleanAttributeName1), String.format(missingAttribute, marioClassName, booleanAttributeName1));
        assertTrue(mario.hasField(booleanAttributeName1, boolean.class), String.format(incorrectType, booleanAttributeName1));
        assertTrue(mario.hasModifier(booleanAttributeName1, "private"), String.format(incorrectModifier, booleanAttributeName1));
        assertTrue(mario.hasField(booleanAttributeName2), String.format(missingAttribute, marioClassName, booleanAttributeName2));
        assertTrue(mario.hasField(booleanAttributeName2, boolean.class), String.format(incorrectType, booleanAttributeName2));
        assertTrue(mario.hasModifier(booleanAttributeName2, "private"), String.format(incorrectModifier, booleanAttributeName2));
    }

    /* Test Car Constructors */

    @Test
    public void marioClassHasRequiredDefaultConstructor() throws Throwable {
        String incorrectValue = "Your %s default constructor does not initialize the %s attribute to the correct value.";
        Object marioInstance = mario.createInstance(null);
        _assertEquals(defaultJumpHeight, mario.getFieldValue(marioInstance, intAttributeName), String.format(incorrectValue, marioClassName, intAttributeName));
        assertFalse((Boolean) mario.getFieldValue(marioInstance, booleanAttributeName1), String.format(incorrectValue, marioClassName, booleanAttributeName1));
        assertFalse((Boolean) mario.getFieldValue(marioInstance, booleanAttributeName2), String.format(incorrectValue, marioClassName, booleanAttributeName2));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(7, false, false),
                Arguments.of(0, true, true),
                Arguments.of(3, true, false),
                Arguments.of(238, false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void carClassHasRequiredConstructorWithParameters(int jump, boolean powerUp, boolean dead) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{int.class, boolean.class, boolean.class};
        assertTrue(mario.hasConstructor(constructorParameters), String.format(missingConstructor, marioClassName));
        assertTrue(mario.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, marioClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        Object[][] constructorArguments = {
                {jump, int.class},
                {powerUp, boolean.class},
                {dead, boolean.class}
        };
        Object marioInstance = mario.createInstance(constructorArguments);
        _assertEquals(jump, mario.getFieldValue(marioInstance, intAttributeName), String.format(incorrectValue, marioClassName, intAttributeName));
        _assertEquals(powerUp, mario.getFieldValue(marioInstance, booleanAttributeName1), String.format(incorrectValue, marioClassName, booleanAttributeName1));
        _assertEquals(dead, mario.getFieldValue(marioInstance, booleanAttributeName2), String.format(incorrectValue, marioClassName, booleanAttributeName2));
    }

    /* Test Car Methods */

    private static Stream<Integer> jumpInputProvider() {
        return Stream.of(0, 1, 5, 6238);
    }

    @ParameterizedTest
    @MethodSource("jumpInputProvider")
    public void correctJumpMethod(int jump) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(mario.hasMethod(jumpMethodName, null),
                String.format(incorrectDefinition, marioClassName, jumpMethodName));
        assertTrue(mario.hasModifier(jumpMethodName, null, "public"),
                String.format(incorrectModifier, jumpMethodName));
        assertTrue(mario.hasReturnType(jumpMethodName, null, int.class),
                String.format(incorrectReturnType, jumpMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {jump, int.class},
                {false, boolean.class},
                {false, boolean.class}
        };
        Object marioInstance = mario.createInstance(constructorArguments);

        /* Call jump on mario */
        Object jumpOutput = mario.callMethod(jumpMethodName, marioInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(jump, jumpOutput, String.format(incorrectUpdate, jumpMethodName, intAttributeName));
    }

    @Test
    public void correctEatPowerUpMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(mario.hasMethod(eatPowerUpMethodName, null),
                String.format(incorrectDefinition, marioClassName, eatPowerUpMethodName));
        assertTrue(mario.hasModifier(eatPowerUpMethodName, null, "public"),
                String.format(incorrectModifier, eatPowerUpMethodName));
        assertTrue(mario.hasReturnType(eatPowerUpMethodName, null, Void.TYPE),
                String.format(incorrectReturnType, eatPowerUpMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {1, int.class},
                {false, boolean.class},
                {false, boolean.class}
        };
        Object marioInstance = mario.createInstance(constructorArguments);

        int count = 1;

        for(int x = 0; x < 5; x++){
            /* call eatPowerUp method */
            mario.callMethod(eatPowerUpMethodName, marioInstance);
            count += 5;

            /* Check result */
            String incorrectUpdate = "Your %s method does not correctly update the value of the %s attribute.";
            _assertEquals(count, mario.getFieldValue(marioInstance, intAttributeName), String.format(incorrectUpdate, eatPowerUpMethodName, intAttributeName));
            assertTrue((Boolean) mario.getFieldValue(marioInstance, booleanAttributeName1), String.format(incorrectUpdate, eatPowerUpMethodName, booleanAttributeName1));
        }
    }

    private static Stream<Arguments> takeDamageInputProvider() {
        return Stream.of(
                Arguments.of(5, true),
                Arguments.of(113, true),
                Arguments.of(25, false),
                Arguments.of(1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("takeDamageInputProvider")
    public void correctSetSpeedMethod(int jump, boolean powerUp) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(mario.hasMethod(takeDamageMethodName, null),
                String.format(incorrectDefinition, marioClassName, takeDamageMethodName));
        assertTrue(mario.hasModifier(takeDamageMethodName, null, "public"),
                String.format(incorrectModifier, takeDamageMethodName));
        assertTrue(mario.hasReturnType(takeDamageMethodName, null, Void.TYPE),
                String.format(incorrectReturnType, takeDamageMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {jump, int.class},
                {powerUp, boolean.class},
                {false, boolean.class}
        };
        Object marioInstance = mario.createInstance(constructorArguments);

        /* Call takeDamage on mario */
        mario.callMethod(takeDamageMethodName, marioInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        if(!powerUp){
            _assertEquals(0, mario.getFieldValue(marioInstance, intAttributeName),
                    String.format(incorrectUpdate, takeDamageMethodName, intAttributeName));
            assertTrue((Boolean)mario.getFieldValue(marioInstance, booleanAttributeName2),
                    String.format(incorrectUpdate, takeDamageMethodName, booleanAttributeName2));
        }
        else {
            _assertEquals(jump - 5, mario.getFieldValue(marioInstance, intAttributeName),
                    String.format(incorrectUpdate, takeDamageMethodName, intAttributeName));
            assertFalse((Boolean)mario.getFieldValue(marioInstance, booleanAttributeName1),
                    String.format(incorrectUpdate, takeDamageMethodName, booleanAttributeName1));
            assertFalse((Boolean)mario.getFieldValue(marioInstance, booleanAttributeName2),
                    String.format(incorrectUpdate, takeDamageMethodName, booleanAttributeName2));
        }
    }

    private static Stream<Arguments> toStringInputProvider() {
        return Stream.of(
                Arguments.of(5, true, false),
                Arguments.of(0, false, true),
                Arguments.of(178, false, false),
                Arguments.of(1, true, true)
        );
    }

    @ParameterizedTest
    @MethodSource("toStringInputProvider")
    public void correctToStringMethod(int jump, boolean powerUp, boolean dead) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(mario.hasMethod("toString", null),
                String.format(incorrectDefinition, marioClassName, "toString"));
        assertTrue(mario.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(mario.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {jump, int.class},
                {powerUp, boolean.class},
                {dead, boolean.class}
        };
        Object marioInstance = mario.createInstance(constructorArguments);

        /* Test output */
        String expectedOutput;
        if(dead){
            expectedOutput = String.format(expectedString, jump, powerUp, "dead");
        }
        else {
            expectedOutput = String.format(expectedString, jump, powerUp, "still alive");
        }
        Object actualOutput = mario.callMethod("toString", marioInstance);
        _assertEquals(expectedOutput, actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    @Test
    public void collisionHasCorrectMainMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the main method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "Your main method does not have the correct visibility modifier.";
        String incorrectReturnType = "Your main method does not have the correct return type.";
        String incorrectStatic = "Your main method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(testPlatformer.hasMethod("main", methodClassParameters),
                String.format(incorrectDefinition, testPlatformerClassName));
        assertTrue(testPlatformer.hasModifier("main", methodClassParameters, "public"),
                incorrectModifier);
        assertTrue(testPlatformer.hasReturnType("main", methodClassParameters, Void.TYPE),
                incorrectReturnType);
        assertTrue(testPlatformer.hasModifier("main", methodClassParameters, "static"),
                incorrectStatic);

        Clause[] output = {
                new StringLiteral(Pattern.quote("I can jump " + defaultJumpHeight + " units high, my power up state is false, and I am still alive.")),
                new NewLine(),
                new StringLiteral(Pattern.quote("I can jump " + (defaultJumpHeight + 5) + " units high, my power up state is true, and I am still alive.")),
                new NewLine(),
                new StringLiteral(Pattern.quote("I can jump 0 units high, my power up state is false, and I am dead."))
        };
        String incorrectOutput = "Your main method in the %s class did not print the correct output. Make sure you print all the toString outputs and call the %s and %s methods";
        Object[][] mainArgs = {{new String[0], String[].class}};
        testPlatformer.callMethod("main", mainArgs, output, String.format(incorrectOutput, testPlatformerClassName, eatPowerUpMethodName, takeDamageMethodName));
    }
}
