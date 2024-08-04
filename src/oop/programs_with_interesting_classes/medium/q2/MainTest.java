package oop.programs_with_interesting_classes.medium.q2;

import global.BaseTest;
import global.ObjectTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Java question
    private ObjectTest map;
    private ObjectTest testMap;
    private final String mapClassName = "Map";
    private final String testMapClassName = "TestMap";
    private final String intArrayAttributeName = "connections";
    private final String calculateDistanceMethodName = "calculateDistance";
    private final String convertStringToIndexMethodName = "convertStringToIndex";
    private static final int[][] connectionsValues = {
            {0, 200, 300, 224, 312},
            {200, 0, -1, -1, 12},
            {300, -1, 0, 651, 167},
            {224, -1, 651, 0, -1},
            {312, 12, 167, -1, 0}
    };
    private final String city0 = "Milan";
    private final String city1 = "Venice";
    private final String city2 = "London";
    private final String city3 = "Stockholm";
    private final String city4 = "Berlin";

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = city0 + " " + city2;
        return new Clause[]{
                new StringLiteral("Enter two cities\\: "),
                new NewLine(),
                new StringLiteral("The travel distance is\\: "),
                new IntegerLiteral("distance")
        };
    }

    public void runMain() {
        TestMap.main(new String[0]);
    }

    /* Test if the map class has the required attributes */
    @Test
    public void mapClassHasRequiredAttribute() {
        String packageString = "oop.programs_with_interesting_classes.medium.q2.";
        map = new ObjectTest(packageString + mapClassName);

        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        String incorrectStaticModifier = "Your %s attribute does not have the correct modifier.";
        assertTrue(map.hasField(intArrayAttributeName), String.format(missingAttribute, mapClassName, intArrayAttributeName));
        assertTrue(map.hasField(intArrayAttributeName, int[][].class), String.format(incorrectType, intArrayAttributeName));
        assertTrue(map.hasModifier(intArrayAttributeName, "private"), String.format(incorrectModifier, intArrayAttributeName));
        assertTrue(map.hasModifier(intArrayAttributeName, "static"), String.format(incorrectStaticModifier, intArrayAttributeName));
    }

    /* Test Map Method */
    private static Stream<Arguments> calculateDistanceInputProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 4, connectionsValues[0][4]),
                Arguments.of(1, 3, connectionsValues[1][0] + connectionsValues[0][3]),
                Arguments.of(3, 2, connectionsValues[3][2])
        );
    }

    @ParameterizedTest
    @MethodSource("calculateDistanceInputProvider")
    public void correctCalculateDistanceMethod(int index1, int index2, int answer) throws Throwable {
        /* Check method definition */
        String packageString = "oop.programs_with_interesting_classes.medium.q2.";
        map = new ObjectTest(packageString + mapClassName);

        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectStaticModifier = "The %s method does not have the static modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class, int.class};
        assertTrue(map.hasMethod(calculateDistanceMethodName, methodClassParameters),
                String.format(incorrectDefinition, mapClassName, calculateDistanceMethodName));
        assertTrue(map.hasModifier(calculateDistanceMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, calculateDistanceMethodName));
        assertTrue(map.hasModifier(calculateDistanceMethodName, methodClassParameters, "static"),
                String.format(incorrectStaticModifier, calculateDistanceMethodName));
        assertTrue(map.hasReturnType(calculateDistanceMethodName, methodClassParameters, int.class),
                String.format(incorrectReturnType, calculateDistanceMethodName));

        /* Call calculateDistance */
        Object[][] methodArgs = {{index1, int.class}, {index2, int.class}};
        Object output = map.callMethod(calculateDistanceMethodName, methodArgs);

        /* Check result */
        String incorrectOutput = "Your %s method does not return the correct value.";
        _assertEquals(answer, output, String.format(incorrectOutput, calculateDistanceMethodName));
    }

    /* Test TestMap Method */
    private static Stream<Arguments> convertStringToIndexInputProvider() {
        return Stream.of(
                Arguments.of("Milan", 0),
                Arguments.of("Venice", 1),
                Arguments.of("London", 2),
                Arguments.of("Stockholm", 3),
                Arguments.of("Berlin", 4),
                Arguments.of("Quebec City", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("convertStringToIndexInputProvider")
    public void correctConvertStringToIndexMethod(String input, int expectedOutput) throws Throwable {
        /* Check method definition */
        String packageString = "oop.programs_with_interesting_classes.medium.q2.";
        testMap = new ObjectTest(packageString + testMapClassName);

        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectStaticModifier = "The %s method does not have the static modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{String.class};
        assertTrue(testMap.hasMethod(convertStringToIndexMethodName, methodClassParameters),
                String.format(incorrectDefinition, mapClassName, convertStringToIndexMethodName));
        assertTrue(testMap.hasModifier(convertStringToIndexMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, convertStringToIndexMethodName));
        assertTrue(testMap.hasModifier(convertStringToIndexMethodName, methodClassParameters, "static"),
                String.format(incorrectStaticModifier, convertStringToIndexMethodName));
        assertTrue(testMap.hasReturnType(convertStringToIndexMethodName, methodClassParameters, int.class),
                String.format(incorrectReturnType, convertStringToIndexMethodName));

        /* Call calculateDistance */
        Object[][] methodArgs = {{input, String.class}};
        Object output = testMap.callMethod(convertStringToIndexMethodName, methodArgs);

        /* Check result */
        String incorrectOutput = "Your %s method does not return the correct value.";
        _assertEquals(expectedOutput, output, String.format(incorrectOutput, convertStringToIndexMethodName));
    }

    @Test
    public void collisionHasCorrectMainMethod() {
        /* Check method definition */
        String packageString = "oop.programs_with_interesting_classes.medium.q2.";
        testMap = new ObjectTest(packageString + testMapClassName);

        String incorrectDefinition = "Your %s class is missing the main method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "Your main method does not have the correct visibility modifier.";
        String incorrectReturnType = "Your main method does not have the correct return type.";
        String incorrectStatic = "Your main method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(testMap.hasMethod("main", methodClassParameters),
                String.format(incorrectDefinition, testMapClassName));
        assertTrue(testMap.hasModifier("main", methodClassParameters, "public"),
                incorrectModifier);
        assertTrue(testMap.hasReturnType("main", methodClassParameters, Void.TYPE),
                incorrectReturnType);
        assertTrue(testMap.hasModifier("main", methodClassParameters, "static"),
                incorrectStatic);

        runWithInput(city3 + " " + city0);
        assertEquals(Integer.parseInt(getItemByName("distance")), connectionsValues[3][0], "Your program does not correctly calculate the distance corresponding to the given input.");
    }
}
