package oop.programs_with_interesting_classes.medium.q6;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    /* Parsons Question */
    private ObjectTest horse;
    private ObjectTest raceTrack;
    private final String horseClassName = "Horse";
    private final String raceTrackClassName = "RaceTrack";
    private final String stringAttributeName = "name";
    private final String doubleAttributeName1 = "gateSpeed";
    private final String doubleAttributeName2 = "acceleration";
    private final String doubleAttributeName3 = "topSpeed";
    private final String getNameMethodName = "getName";
    private final String getGateSpeedMethodName = "getGateSpeed";
    private final String getAccelerationMethodName = "getAcceleration";
    private final String getTopSpeedMethodName = "getTopSpeed";
    private final String completionTimeMethodName = "completionTime";
    private final String expectedString = "Racer: %s, starting speed of %s acceleration of %s and top speed of %s";
    private final String winner = "Betsy";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.medium.q6.";
        horse = new ObjectTest(packageString + horseClassName);
        raceTrack = new ObjectTest(packageString + raceTrackClassName);
    }

    /* Test if the car class has the required attributes */

    @Test
    public void horseClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(horse.hasField(stringAttributeName), String.format(missingAttribute, horseClassName, stringAttributeName));
        assertTrue(horse.hasField(stringAttributeName, String.class), String.format(incorrectType, stringAttributeName));
        assertTrue(horse.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(horse.hasField(doubleAttributeName1), String.format(missingAttribute, horseClassName, doubleAttributeName1));
        assertTrue(horse.hasField(doubleAttributeName1, double.class), String.format(incorrectType, doubleAttributeName1));
        assertTrue(horse.hasModifier(doubleAttributeName1, "private"), String.format(incorrectModifier, doubleAttributeName1));
        assertTrue(horse.hasField(doubleAttributeName2), String.format(missingAttribute, horseClassName, doubleAttributeName2));
        assertTrue(horse.hasField(doubleAttributeName2, double.class), String.format(incorrectType, doubleAttributeName2));
        assertTrue(horse.hasModifier(doubleAttributeName2, "private"), String.format(incorrectModifier, doubleAttributeName2));
        assertTrue(horse.hasField(doubleAttributeName3), String.format(missingAttribute, horseClassName, doubleAttributeName3));
        assertTrue(horse.hasField(doubleAttributeName3, double.class), String.format(incorrectType, doubleAttributeName3));
        assertTrue(horse.hasModifier(doubleAttributeName3, "private"), String.format(incorrectModifier, doubleAttributeName3));
    }

    /* Test Horse Constructor */

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("George", 15.234, 2.2, 61),
                Arguments.of("Nosey Neil", 45, 1.1, 59),
                Arguments.of("Ressure", 0, 8.3, 110.1)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void horseClassHasRequiredConstructor(String name, double start, double increase, double top) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, double.class, double.class, double.class};
        assertTrue(horse.hasConstructor(constructorParameters), String.format(missingConstructor, horseClassName));
        assertTrue(horse.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, horseClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        Object[][] constructorArguments = {
                {name, String.class},
                {start, double.class},
                {increase, double.class},
                {top, double.class}
        };
        Object horseInstance = horse.createInstance(constructorArguments);
        _assertEquals(name, horse.getFieldValue(horseInstance, stringAttributeName), String.format(incorrectValue, horseClassName, stringAttributeName));
        _assertEquals(start, horse.getFieldValue(horseInstance, doubleAttributeName1), String.format(incorrectValue, horseClassName, doubleAttributeName1));
        _assertEquals(increase, horse.getFieldValue(horseInstance, doubleAttributeName2), String.format(incorrectValue, horseClassName, doubleAttributeName2));
        _assertEquals(top, horse.getFieldValue(horseInstance, doubleAttributeName3), String.format(incorrectValue, horseClassName, doubleAttributeName3));
    }

    /* Test Horse Methods */

    private static Stream<String> getNameInputProvider() {
        return Stream.of("Toyota Corolla", "George W. Bush", "123 ABC", "");
    }

    @ParameterizedTest
    @MethodSource("getNameInputProvider")
    public void correctGetNameMethod(String name) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(horse.hasMethod(getNameMethodName, null),
                String.format(incorrectDefinition, horseClassName, getNameMethodName));
        assertTrue(horse.hasModifier(getNameMethodName, null, "public"),
                String.format(incorrectModifier, getNameMethodName));
        assertTrue(horse.hasReturnType(getNameMethodName, null, String.class),
                String.format(incorrectReturnType, getNameMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {name, String.class},
                {30.32, double.class},
                {3.3, double.class},
                {66.7, double.class}
        };
        Object horseInstance = horse.createInstance(constructorArguments);

        /* Call getName on car */
        Object getNameOutput = horse.callMethod(getNameMethodName, horseInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(name, getNameOutput, String.format(incorrectUpdate, getNameMethodName, stringAttributeName));
    }

    private static Stream<Double> getDoubleInputProvider() {
        return Stream.of(0.00, 1.1, 37.3, 32794.432);
    }

    @ParameterizedTest
    @MethodSource("getDoubleInputProvider")
    public void correctGetGateSpeedMethod(double start) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(horse.hasMethod(getGateSpeedMethodName, null),
                String.format(incorrectDefinition, horseClassName, getGateSpeedMethodName));
        assertTrue(horse.hasModifier(getGateSpeedMethodName, null, "public"),
                String.format(incorrectModifier, getGateSpeedMethodName));
        assertTrue(horse.hasReturnType(getGateSpeedMethodName, null, double.class),
                String.format(incorrectReturnType, getGateSpeedMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {start, double.class},
                {2.2, double.class},
                {33.8, double.class}
        };
        Object horseInstance = horse.createInstance(constructorArguments);

        /* Call getGateSpeed on car */
        Object getGateSpeedOutput = horse.callMethod(getGateSpeedMethodName, horseInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(start, getGateSpeedOutput, String.format(incorrectUpdate, getGateSpeedMethodName, doubleAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("getDoubleInputProvider")
    public void correctGetAccelerationMethod(double accelerate) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(horse.hasMethod(getAccelerationMethodName, null),
                String.format(incorrectDefinition, horseClassName, getAccelerationMethodName));
        assertTrue(horse.hasModifier(getAccelerationMethodName, null, "public"),
                String.format(incorrectModifier, getAccelerationMethodName));
        assertTrue(horse.hasReturnType(getAccelerationMethodName, null, double.class),
                String.format(incorrectReturnType, getAccelerationMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {12.5, double.class},
                {accelerate, double.class},
                {33.8, double.class}
        };
        Object horseInstance = horse.createInstance(constructorArguments);

        /* Call getAcceleration on car */
        Object getAccelerationOutput = horse.callMethod(getAccelerationMethodName, horseInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(accelerate, getAccelerationOutput, String.format(incorrectUpdate, getAccelerationMethodName, doubleAttributeName2));
    }

    @ParameterizedTest
    @MethodSource("getDoubleInputProvider")
    public void correctGetTopSpeedMethod(double top) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(horse.hasMethod(getTopSpeedMethodName, null),
                String.format(incorrectDefinition, horseClassName, getTopSpeedMethodName));
        assertTrue(horse.hasModifier(getTopSpeedMethodName, null, "public"),
                String.format(incorrectModifier, getTopSpeedMethodName));
        assertTrue(horse.hasReturnType(getTopSpeedMethodName, null, double.class),
                String.format(incorrectReturnType, getTopSpeedMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {34.1, double.class},
                {2.2, double.class},
                {top, double.class}
        };
        Object horseInstance = horse.createInstance(constructorArguments);

        /* Call getTopSpeed on car */
        Object getTopSpeedOutput = horse.callMethod(getTopSpeedMethodName, horseInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(top, getTopSpeedOutput, String.format(incorrectUpdate, getTopSpeedMethodName, doubleAttributeName3));
    }

    private static Stream<Arguments> toStringInputProvider() {
        return Stream.of(
                Arguments.of("Earl", 0, 0.51, 23.5),
                Arguments.of("Rett", 1.0, 1.0, 77.2),
                Arguments.of("Teddy", 32.56, 4.674, 392.49)
        );
    }

    @ParameterizedTest
    @MethodSource("toStringInputProvider")
    public void correctToStringMethod(String name, double gate, double accelerate, double top) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(horse.hasMethod("toString", null),
                String.format(incorrectDefinition, horseClassName, "toString"));
        assertTrue(horse.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(horse.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {name, String.class},
                {gate, double.class},
                {accelerate, double.class},
                {top, double.class}
        };
        Object horseInstance = horse.createInstance(constructorArguments);

        /* Test output */
        Object actualOutput = horse.callMethod("toString", horseInstance);
        _assertEquals(String.format(expectedString, name, gate, accelerate, top), actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    private static Stream<Arguments> completionTimeInputProvider() {
        return Stream.of(
                Arguments.of(12.5, 1.1, 45, 3.5, 11.489878542510121),
                Arguments.of(42.5, 6.5, 79, 16.4, 13.99367088607595),
                Arguments.of(38.5, 3.5, 45, 0.5, 0.7926829268292682),
                Arguments.of(30, 12, 60, 1.2, 2.0)
        );
    }

    @ParameterizedTest
    @MethodSource("completionTimeInputProvider")
    public void correctCompletionTimeMethod(double gate, double accelerate, double top, double distance, double result) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(horse.hasMethod(completionTimeMethodName, new Class[]{double.class}),
                String.format(incorrectDefinition, horseClassName, completionTimeMethodName));
        assertTrue(horse.hasModifier(completionTimeMethodName, new Class[]{double.class}, "public"),
                String.format(incorrectModifier, completionTimeMethodName));
        assertTrue(horse.hasReturnType(completionTimeMethodName, new Class[]{double.class}, double.class),
                String.format(incorrectReturnType, completionTimeMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {gate, double.class},
                {accelerate, double.class},
                {top, double.class}
        };
        Object horseInstance = horse.createInstance(constructorArguments);

        /* Call completionTime on horse */
        Object completionTimeOutput = horse.callMethod(completionTimeMethodName, new Object[][]{{distance, double.class}}, horseInstance);

        /* Check result */
        String incorrectReturn = "Your %s method does correctly calculate and return the time.";
        _assertEquals(result, completionTimeOutput, 0.0001, String.format(incorrectReturn, completionTimeMethodName));
    }

    @Test
    public void raceTrackHasCorrectMainMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the main method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "Your main method does not have the correct visibility modifier.";
        String incorrectReturnType = "Your main method does not have the correct return type.";
        String incorrectStatic = "Your main method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(raceTrack.hasMethod("main", methodClassParameters),
                String.format(incorrectDefinition, raceTrackClassName));
        assertTrue(raceTrack.hasModifier("main", methodClassParameters, "public"),
                incorrectModifier);
        assertTrue(raceTrack.hasReturnType("main", methodClassParameters, Void.TYPE),
                incorrectReturnType);
        assertTrue(raceTrack.hasModifier("main", methodClassParameters, "static"),
                incorrectStatic);

        Clause[] output = {
                new StringLiteral("Race start\\!"),
                new NewLine(),
                new StringLiteral(winner + " is the WINNER\\!")
        };
        String incorrectOutput = "Your main method in the %s class did not print the correct output.";
        Object[][] mainArgs = {{new String[0], String[].class}};
        raceTrack.callMethod("main", mainArgs, output, String.format(incorrectOutput, raceTrackClassName));
    }
}
