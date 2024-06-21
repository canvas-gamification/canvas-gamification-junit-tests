package oop.object_independence.hard.q1;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
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
    private ObjectTest platformGame;
    private ObjectTest testPlatformGame;
    private final String platformGameName = "PlatformGame";
    private final String testPlatformGameName = "TestPlatformGame";
    private final String difficultyFieldName = "difficulty";
    private final String numLevelsFieldName = "numLevels";
    private final String getNumLevelsMethodName = "getNumLevels";
    private final String getDifficultyMethodName = "getDifficulty";
    private final String setNumLevelsMethodName = "setNumLevels";
    private final String setDifficultyMethodName = "setDifficulty";
    private final int testPlatformNumLevels1 = 3;
    private final int testPlatformNumLevels2 = 10;
    private final String testPlatformGameDifficulty1 = "easy";
    private final String testPlatformGameDifficulty2 = "hard";
    private final int testPlatformNumLevelsUpdate = 5;

    @BeforeEach
    public void setup() {
        String platformGameString = "oop.object_independence.hard.q1." + platformGameName;
        String testPlatformGameString = "oop.object_independence.hard.q1." + testPlatformGameName;
        platformGame = new ObjectTest(platformGameString);
        testPlatformGame = new ObjectTest(testPlatformGameString);
    }

    @Test
    public void platformGameClassHasCorrectFields() {
        String missingDifficultyField =
                String.format("Your %s class is missing the %s field.", platformGameName, difficultyFieldName);
        String missingNumLevelsField =
                String.format("Your %s class is missing the %s field.", platformGameName, numLevelsFieldName);
        assertTrue(platformGame.hasField(difficultyFieldName, String.class), missingDifficultyField);
        assertTrue(platformGame.hasField(numLevelsFieldName, int.class), missingNumLevelsField);
        String incorrectVisibilityModifier = "Your %s field has the wrong visibility modifier.";
        assertTrue(platformGame.hasModifier(difficultyFieldName, "private"),
                String.format(incorrectVisibilityModifier, difficultyFieldName));
        assertTrue(platformGame.hasModifier(numLevelsFieldName, "private"),
                String.format(incorrectVisibilityModifier, numLevelsFieldName));
    }

    private static Stream<Arguments> platformGameInputProvider() {
        return Stream.of(
                Arguments.of(4, "easy"),
                Arguments.of(2613, "HAHAHAHAHAHAHAHA"),
                Arguments.of(12, "Not very challenging, easy $$")
        );
    }

    @ParameterizedTest
    @MethodSource("platformGameInputProvider")
    public void platformGameClassHasCorrectConstructor(int numLevels, String difficulty) throws Throwable {
        Object[][] arguments = {
                {numLevels, int.class},
                {difficulty, String.class}
        };
        Class<?>[] classes = {int.class, String.class};
        String incorrectVisibilityModifier =
                String.format("Your %s constructor has the incorrect visibility modifier.", platformGameName);
        assertTrue(platformGame.hasModifier(classes, "public"), incorrectVisibilityModifier);
        Object platformGameInstance = platformGame.createInstance(arguments);
        String incorrectFieldValue =
                "Your %s constructor does not correctly initialize the %s field based on the passed parameters.";
        _assertEquals(difficulty, platformGame.getFieldValue(platformGameInstance, difficultyFieldName),
                String.format(incorrectFieldValue, platformGameName, difficultyFieldName));
        _assertEquals(numLevels, platformGame.getFieldValue(platformGameInstance, numLevelsFieldName),
                String.format(incorrectFieldValue, platformGameName, numLevelsFieldName));
    }

    @ParameterizedTest
    @MethodSource("platformGameInputProvider")
    public void platformGameClassHasCorrectGetNumLevelsMethod(int numLevels, String difficulty) throws Throwable {
        Object[][] arguments = {
                {numLevels, int.class},
                {difficulty, String.class}
        };
        Object platformGameInstance = platformGame.createInstance(arguments);
        Object output = platformGame.callMethod(getNumLevelsMethodName, new String[]{"public"}, platformGameInstance);
        String incorrectGetNumLevelsMethod =
                String.format("Your %s method does not return the value of the %s field.", getNumLevelsMethodName, numLevelsFieldName);
        _assertEquals(numLevels, output, incorrectGetNumLevelsMethod);
    }

    @ParameterizedTest
    @MethodSource("platformGameInputProvider")
    public void platformGameClassHasCorrectGetDifficultyMethod(int numLevels, String difficulty) throws Throwable {
        Object[][] arguments = {
                {numLevels, int.class},
                {difficulty, String.class}
        };
        Object platformGameInstance = platformGame.createInstance(arguments);
        Object output = platformGame.callMethod(getDifficultyMethodName, new String[]{"public"}, platformGameInstance);
        String incorrectGetNumLevelsMethod =
                String.format("Your %s method does not return the value of the %s field.", getDifficultyMethodName, difficultyFieldName);
        _assertEquals(difficulty, output, incorrectGetNumLevelsMethod);
    }

    private static Stream<Arguments> setNumLevelsInputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(4, 1231328),
                Arguments.of(4242, 0),
                Arguments.of(123, 456)
        );
    }

    @ParameterizedTest
    @MethodSource("setNumLevelsInputProvider")
    public void platformGameClassHasCorrectSetNumLevelsMethod(int numLevelsInitial, int numLevelsFinal) throws Throwable {
        Object[][] arguments = {
                {numLevelsInitial, int.class},
                {"Standard", String.class}
        };
        Object platformGameInstance = platformGame.createInstance(arguments);
        Object[][] methodArguments = {{numLevelsFinal, int.class}};
        platformGame.callMethod(setNumLevelsMethodName, methodArguments, platformGameInstance);
        Object updatedValue = platformGame.getFieldValue(platformGameInstance, numLevelsFieldName);
        String incorrectSetNumLevelsMethod =
                String.format("Your %s method does not update the %s field to the passed parameter.", setNumLevelsMethodName, numLevelsFieldName);
        _assertEquals(numLevelsFinal, updatedValue, incorrectSetNumLevelsMethod);
        assertTrue(platformGame.hasReturnType(setNumLevelsMethodName, new Class[]{int.class}, void.class));
    }

    private static Stream<Arguments> setDifficultyInputProvider() {
        return Stream.of(
                Arguments.of("Easy", "Not so Easy :("),
                Arguments.of("1234", "123"),
                Arguments.of("Cash $$###$", "George")
        );
    }

    @ParameterizedTest
    @MethodSource("setDifficultyInputProvider")
    public void platformGameClassHasCorrectSetDifficultyMethod(String difficultyInitial, String difficultyFinal) throws Throwable {
        Object[][] arguments = {
                {100, int.class},
                {difficultyInitial, String.class}
        };
        Object platformGameInstance = platformGame.createInstance(arguments);
        Object[][] methodArguments = {{difficultyFinal, String.class}};
        platformGame.callMethod(setDifficultyMethodName, methodArguments, platformGameInstance);
        Object updatedValue = platformGame.getFieldValue(platformGameInstance, difficultyFieldName);
        String incorrectSetDifficultyMethod =
                String.format("Your %s method does not update the %s field to the passed parameter.", setDifficultyMethodName, difficultyFieldName);
        _assertEquals(difficultyFinal, updatedValue, incorrectSetDifficultyMethod);
        assertTrue(platformGame.hasReturnType(setDifficultyMethodName, new Class[]{String.class}, void.class));
    }

    @ParameterizedTest
    @MethodSource("platformGameInputProvider")
    public void platformGameClassHasCorrectToStringMethod(int numLevels, String difficulty) throws Throwable {
        Object[][] arguments = {
                {numLevels, int.class},
                {difficulty, String.class}
        };
        Object platformGameInstance = platformGame.createInstance(arguments);
        String expectedOutput = String.format("This game has %d levels and is rated to be %s difficulty.", numLevels, difficulty);
        Object output = platformGame.callMethod("toString", new String[]{"public"}, platformGameInstance);
        String incorrectToString = String.format("Your toString method for the %s class does return the correct String.", platformGameName);
        _assertEquals(expectedOutput, output, incorrectToString);
    }

    private static Stream<Arguments> platformGameAllMethodsInputProvider() {
        return Stream.of(
                Arguments.of(3, "jewajhd", 24323, "On another level"),
                Arguments.of(412, "Immensely difficult, almost impossible", 0, "Easy peasy")
        );
    }

    @ParameterizedTest
    @MethodSource("platformGameAllMethodsInputProvider")
    public void platformGameMethodsWorkCorrectlyWorkTogether(int numLevelsInitial, String difficultyInitial, int numLevelsFinal, String difficultyFinal) throws Throwable {
        Object[][] constructorArguments = {
                {numLevelsInitial, int.class},
                {difficultyInitial, String.class}
        };
        Object platformGameInstance = platformGame.createInstance(constructorArguments);
        Object[][] setDifficultyArguments = { {difficultyFinal, String.class} };
        platformGame.callMethod(setDifficultyMethodName, setDifficultyArguments, platformGameInstance);
        Object[][] setNumLevelsArguments = { {numLevelsFinal, int.class} };
        platformGame.callMethod(setNumLevelsMethodName, setNumLevelsArguments, platformGameInstance);
        Object getDifficultyOutput = platformGame.callMethod(getDifficultyMethodName, platformGameInstance);
        Object getNumLevelsOutput = platformGame.callMethod(getNumLevelsMethodName, platformGameInstance);
        Object toStringOutput = platformGame.callMethod("toString", platformGameInstance);
        String expectedToStringOutput = String.format("This game has %d levels and is rated to be %s difficulty.", numLevelsFinal, difficultyFinal);
        String incorrectSetGet =
                "Your %s method does not return the correct value after updating the %s field using the %s method.";
        String incorrectToString =
                String.format(
                        "Your toString method does not return the correct String after updating the %s and %s fields using the %s and %s methods.",
                        numLevelsFieldName,
                        difficultyFieldName,
                        setNumLevelsMethodName,
                        setDifficultyMethodName
                );
        _assertEquals(difficultyFinal, getDifficultyOutput,
                String.format(incorrectSetGet, getDifficultyMethodName, difficultyFieldName, setDifficultyMethodName));
        _assertEquals(numLevelsFinal, getNumLevelsOutput,
                String.format(incorrectSetGet, getNumLevelsMethodName, numLevelsFieldName, setNumLevelsMethodName));
        _assertEquals(expectedToStringOutput, toStringOutput, incorrectToString);
    }

    @Test
    public void testPlatformGameMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral("This game has "),
                new IntegerLiteral(testPlatformNumLevels1),
                new StringLiteral(" levels and is rated to be "),
                new StringLiteral(testPlatformGameDifficulty1),
                new StringLiteral(" difficulty\\."),
                new NewLine(),
                new StringLiteral("This game has "),
                new IntegerLiteral(testPlatformNumLevels2),
                new StringLiteral(" levels and is rated to be "),
                new StringLiteral(testPlatformGameDifficulty2),
                new StringLiteral(" difficulty\\."),
                new NewLine(),
                new StringLiteral("This game has "),
                new IntegerLiteral(testPlatformNumLevelsUpdate),
                new StringLiteral(" levels and is rated to be "),
                new StringLiteral(testPlatformGameDifficulty1),
                new StringLiteral(" difficulty\\."),
                new NewLine(),
                new StringLiteral("This game has "),
                new IntegerLiteral(testPlatformNumLevels2),
                new StringLiteral(" levels and is rated to be "),
                new StringLiteral(testPlatformGameDifficulty2),
                new StringLiteral(" difficulty\\.")
        };
        String incorrectOutput =
                String.format("Your %s class main method does correctly initialize, update, and print the values of the two %s objects.", platformGameName, testPlatformGameName);
        testPlatformGame.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
