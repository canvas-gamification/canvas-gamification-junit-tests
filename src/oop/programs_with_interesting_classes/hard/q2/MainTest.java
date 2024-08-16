package oop.programs_with_interesting_classes.hard.q2;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private ObjectTest player;
    // Java
    private ObjectTest leaderBoard;
    private final String playerClassName = "Player";
    private final String leaderBoardClassName = "LeaderBoard";
    private final String stringAttributeName = "name";
    private final String intAttributeName = "score";
    private final String playerAttributeName = "players";
    private final String intAttributeName2 = "numPlayers";
    private final String getNameMethodName = "getName";
    private final String getScoreMethodName = "getScore";
    private final String setScoreMethodName = "setScore";
    private final String addPlayerMethodName = "addPlayer";
    private final String getTop2MethodName = "getTop2";
    private static final int arrayLength = 100;

    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q2.";
        player = new ObjectTest(packageString + playerClassName);
        leaderBoard = new ObjectTest(packageString + leaderBoardClassName);
    }

    @Test
    public void playerClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(player.hasField(stringAttributeName), String.format(missingAttribute, playerClassName, stringAttributeName));
        assertTrue(player.hasField(stringAttributeName, String.class), String.format(incorrectTypeMessage, stringAttributeName));
        assertTrue(player.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(player.hasField(intAttributeName), String.format(missingAttribute, leaderBoardClassName, stringAttributeName));
        assertTrue(player.hasField(intAttributeName, int.class), String.format(incorrectTypeMessage, stringAttributeName));
        assertTrue(player.hasModifier(intAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
    }

    private static Stream<String> constructorInputProvider() {
        return Stream.of("Helia", "", "Beans 123");
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void playerClassHasRequiredConstructor(String name) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        String incorrectValue = "The constructor in your %s class does not correctly set the value of the %s attribute.";
        Class<?>[] constructorParameters = new Class[]{String.class};
        assertTrue(player.hasConstructor(constructorParameters), String.format(missingConstructor, playerClassName));
        assertTrue(player.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, playerClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{name, String.class}};
        Object playerInstance = player.createInstance(constructorArguments);

        /* Check if the attributes exist */
        assertTrue(player.hasField(stringAttributeName), String.format(incorrectTypeMessage, stringAttributeName));
        assertEquals(name, player.getFieldValue(playerInstance, stringAttributeName), String.format(incorrectValue, playerClassName, stringAttributeName));

        assertTrue(player.hasField(intAttributeName), String.format(incorrectTypeMessage, intAttributeName));
        assertEquals(0, player.getFieldValue(playerInstance, intAttributeName), String.format(incorrectValue, playerClassName, intAttributeName));
    }

    private static Stream<String> getNameInputProvider() {
        return Stream.of("Delilah", "James S", "", "Iza 123");
    }

    @ParameterizedTest
    @MethodSource("getNameInputProvider")
    public void playerHasCorrectGetNameMethod(String name) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String incorrectValue = "The %s method does not correctly set the value of the %s attribute.";

        Class<?>[] methodClassParameters = new Class[]{};
        assertTrue(player.hasMethod(getNameMethodName, methodClassParameters),
                String.format(incorrectDefinition, playerClassName, getNameMethodName));
        assertTrue(player.hasModifier(getNameMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, getNameMethodName));
        assertTrue(player.hasReturnType(getNameMethodName, methodClassParameters, String.class),
                String.format(incorrectReturnType, getNameMethodName));

        Object[][] constructorArguments = {{name, String.class}};
        Object playerInstance = player.createInstance(constructorArguments);

        Object output = player.callMethod(getNameMethodName, playerInstance);

        assertEquals(name, output,
                String.format(incorrectValue, getNameMethodName, stringAttributeName));
    }

    private static Stream<Integer> scoreInputProvider() {
        return Stream.of(0, 1, 2, 3, 13, 4124, 473825);
    }

    @ParameterizedTest
    @MethodSource("scoreInputProvider")
    public void playerHasCorrectGetScoreMethod(int score) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String incorrectValue = "The %s method does not correctly set the value of the %s attribute.";

        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(player.hasMethod(setScoreMethodName, methodClassParameters),
                String.format(incorrectDefinition, playerClassName, setScoreMethodName));
        assertTrue(player.hasModifier(setScoreMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setScoreMethodName));
        assertTrue(player.hasReturnType(setScoreMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setScoreMethodName));

        Object[][] constructorArguments = {{"name", String.class}};
        Object playerInstance = player.createInstance(constructorArguments);

        assertTrue(player.hasField(intAttributeName), String.format(incorrectTypeMessage, intAttributeName));
        player.setFieldValue(playerInstance, score, intAttributeName);

        Object output = player.callMethod(getScoreMethodName, playerInstance);

        assertEquals(score, output,
                String.format(incorrectValue, setScoreMethodName, intAttributeName));
    }

    @ParameterizedTest
    @MethodSource("scoreInputProvider")
    public void playerHasCorrectSetScoreMethod(int score) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String incorrectValue = "The %s method does not correctly set the value of the %s attribute.";

        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(player.hasMethod(setScoreMethodName, methodClassParameters),
                String.format(incorrectDefinition, playerClassName, setScoreMethodName));
        assertTrue(player.hasModifier(setScoreMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setScoreMethodName));
        assertTrue(player.hasReturnType(setScoreMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setScoreMethodName));

        Object[][] constructorArguments = {{"name", String.class}};
        Object playerInstance = player.createInstance(constructorArguments);

        Object[][] setMethodArguments = {
                {score, int.class}
        };
        player.callMethod(setScoreMethodName, setMethodArguments, playerInstance);

        assertTrue(player.hasField(intAttributeName), String.format(incorrectTypeMessage, intAttributeName));
        assertEquals(score, player.getFieldValue(playerInstance, intAttributeName),
                String.format(incorrectValue, setScoreMethodName, intAttributeName));
    }

    private static Stream<Arguments> playerToStringInputProvider() {
        return Stream.of(
                Arguments.of("Deliah", 4385, "Deliah: 4385 points"),
                Arguments.of("Kassie 12", 547, "Kassie 12: 547 points"),
                Arguments.of("", 0, ": 0 points"),
                Arguments.of("a little after midnight", -1, "a little after midnight: -1 points")
        );
    }

    @ParameterizedTest
    @MethodSource("playerToStringInputProvider")
    public void playerHasCorrectToStringMethod(String name, int score, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(player.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, playerClassName, methodNameToString));
        assertTrue(player.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(player.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object[][] constructorArguments = {{name, String.class}};
        Object playerInstance = player.createInstance(constructorArguments);

        assertTrue(player.hasField(intAttributeName), String.format(incorrectTypeMessage, intAttributeName));
        player.setFieldValue(playerInstance, score, intAttributeName);

        Object result = player.callMethod("toString", playerInstance);

        assertEquals(msg, result, "Your toString method does not return the correct string. Check the question description to ensure it is formatted properly.");
    }

    @Test
    public void leaderBoardClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(leaderBoard.hasField(playerAttributeName), String.format(missingAttribute, leaderBoardClassName, playerAttributeName));
        assertTrue(leaderBoard.hasField(playerAttributeName, player.getObjectArrayClass()), String.format(incorrectTypeMessage, playerAttributeName));
        assertTrue(leaderBoard.hasModifier(playerAttributeName, "private"), String.format(incorrectModifier, playerAttributeName));
    }

    private static Stream<Arguments> leaderboardConstructorInputProvider() {
        return Stream.of(
                Arguments.of(null, new Object[][]{{"Cass", String.class}}, true, true, arrayLength),
                Arguments.of(new Object[][][]{{{"Callie", String.class}}, {{"Carmen", String.class}}, {{"Ruon", String.class}}, {{"Allie", String.class}},
                        {{"Nico", String.class}}, {{"Tim", String.class}}, {{"Tigre", String.class}}, {{"Millie", String.class}}, {{"Hope", String.class}},
                        {{"Rathie", String.class}}, {{"Amena", String.class}}, {{"Gran", String.class}}, {{"Nau", String.class}}, {{"El", String.class}},
                        {{"Andrew", String.class}}, {{"Marcus", String.class}}, {{"Paul", String.class}}, {{"Peter", String.class}}, {{"Cody", String.class}},
                        {{"Edward", String.class}}, {{"Kia", String.class}}}, null, false, true, 21),
                Arguments.of(new Object[][][]{{{"AJ", String.class}}}, null, false, true, 1),
                Arguments.of(new Object[][][]{{{}}}, null, false, true, 0),
                Arguments.of(new Object[][][]{{{"Tiffany", String.class}}, {{"Frog", String.class}}}, null, false, true, 2),
                Arguments.of(null, new Object[][]{{"Testerfer Jones", String.class}}, true, false, arrayLength + 20)
        );
    }

    @ParameterizedTest
    @MethodSource("leaderboardConstructorInputProvider")
    public void leaderBoardClassHasRequiredConstructor(Object[][][] arguments, Object[][] argument, boolean fillArray, boolean valid, int length) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{player.getObjectArrayClass()};
        assertTrue(leaderBoard.hasConstructor(constructorParameters), String.format(missingConstructor, leaderBoardClassName));
        assertTrue(leaderBoard.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, leaderBoardClassName));

        /* Create instance */
        Object[][] constructorArguments =
                fillArray ? new Object[][]{{player.createArray(valid ? arrayLength : arrayLength + 20, argument), player.getObjectArrayClass()}} :
                        length == 0 ? new Object[][]{{player.createArray(0), player.getObjectArrayClass()}} :
                                new Object[][]{{player.createArray(length, arguments), player.getObjectArrayClass()}};
        Object leaderBoardInstance = leaderBoard.createInstance(constructorArguments);

        /* Check if the size of the array is correct */
        assertTrue(leaderBoard.hasField(playerAttributeName, player.getObjectArrayClass()), String.format(incorrectTypeMessage, playerAttributeName));
        Object[] holdArray = (Object[]) leaderBoard.getFieldValue(leaderBoardInstance, playerAttributeName);
        assertEquals(arrayLength, holdArray.length, "Your " + leaderBoardClassName + " class constructor does not initialize the " + playerAttributeName + " array to the correct length.");

        int firstNullIndex = fillArray ? -1 : length;
        if (firstNullIndex != -1) {
            for (int x = firstNullIndex; x < arrayLength; x++) {
                assertNull(holdArray[x], "Your " + leaderBoardClassName + " class constructor does not retain all the null values after the passed " + playerClassName + " array has been processed in the constructor.");
            }
            Object[] shorterArray = new Object[length];
            System.arraycopy(holdArray, 0, shorterArray, 0, length);
            assertArrayEquals((Object[]) constructorArguments[0][0], shorterArray, "Your " + leaderBoardClassName + " class constructor does not correctly transfer the given " + playerClassName + " objects into the " + playerAttributeName + " array.");
            assertEquals(length, leaderBoard.getFieldValue(leaderBoardInstance, intAttributeName2), "Your " + leaderBoardClassName + " class constructor does not correctly update the " + intAttributeName2 + " value.");
        } else {
            if (valid) {
                assertArrayEquals((Object[]) constructorArguments[0][0], holdArray, "Your " + leaderBoardClassName + " class constructor does not correctly transfer the given " + playerClassName + " objects into the " + playerAttributeName + " array.");
                assertEquals(arrayLength, leaderBoard.getFieldValue(leaderBoardInstance, intAttributeName2), "Your " + leaderBoardClassName + " class constructor does not correctly update the " + intAttributeName2 + " value.");
            } else {
                assertArrayEquals(new Object[arrayLength], holdArray, "Your " + leaderBoardClassName + " class constructor does not correctly handle invalid input.");
                assertEquals(0, leaderBoard.getFieldValue(leaderBoardInstance, intAttributeName2), "Your " + leaderBoardClassName + " class constructor does not correctly initialize the " + intAttributeName2 + " value.");
            }
        }
    }

    private static Stream<Arguments> addPlayerInputProvider() {
        return Stream.of(
                Arguments.of(new Object[][][]{{{}}}, new Object[][]{{"Sabrina", String.class}}, 0),
                Arguments.of(new Object[][][]{{{"Raine", String.class}}}, new Object[][]{{"Wong", String.class}}, 1),
                Arguments.of(new Object[][][]{{{"Gupta", String.class}}, {{"Kal", String.class}}}, new Object[][]{{"Goemon", String.class}}, 2),
                Arguments.of(new Object[][][]{{{"Sill", String.class}}}, new Object[][]{{"Mumford", String.class}}, arrayLength - 2),
                Arguments.of(new Object[][][]{{{"Kitty", String.class}}}, new Object[][]{{"Bridget", String.class}}, arrayLength - 1),
                Arguments.of(new Object[][][]{{{"Holly", String.class}}}, new Object[][]{{"Sung", String.class}}, arrayLength),
                Arguments.of(new Object[][][]{{{"Yusuf", String.class}}}, new Object[][]{{"Harry", String.class}}, 40)
        );
    }

    @ParameterizedTest
    @MethodSource("addPlayerInputProvider")
    public void leaderBoardHasCorrectAddPlayerMethod(Object[][][] arguments, Object[][] newPlayer, int length) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{player.getObjectClass()};
        assertTrue(leaderBoard.hasMethod(addPlayerMethodName, methodClassParameters),
                String.format(incorrectDefinition, leaderBoardClassName, addPlayerMethodName));
        assertTrue(leaderBoard.hasModifier(addPlayerMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, addPlayerMethodName));
        assertTrue(leaderBoard.hasReturnType(addPlayerMethodName, methodClassParameters, boolean.class),
                String.format(incorrectReturnType, addPlayerMethodName));

        Object[][] constructorArguments = {{player.createArray(0), player.getObjectArrayClass()}};
        Object leaderBoardInstance = leaderBoard.createInstance(constructorArguments);

        /* Set attributes */
        Object[] studentArray = (Object[]) leaderBoard.getFieldValue(leaderBoardInstance, playerAttributeName);
        assertEquals(arrayLength, studentArray.length,
                "Your " + playerAttributeName + " attribute is not initialized to the correct length.");
        Object[] holdArray = (Object[]) (length == arguments.length ? player.createArray(length, arguments) : player.createArray(length, arguments[0]));
        System.arraycopy(holdArray, 0, studentArray, 0, length);
        leaderBoard.setFieldValue(leaderBoardInstance, length, intAttributeName2);

        Object playerInstance = player.createInstance(newPlayer);

        /* Check if player is added correctly or false returned if the leader board is too full */
        Object[][] addPlayerInput = {{playerInstance, player.getObjectClass()}};
        Object result = leaderBoard.callMethod(addPlayerMethodName, addPlayerInput, leaderBoardInstance);
        if (length < arrayLength) {
            String invalidInsertInput = "Your %s method returned false when the insert should have been successful.";
            _assertEquals(true, result, String.format(invalidInsertInput, addPlayerMethodName));
            String errorMessage = "Your %s method does not correctly add the input %s object into the %s array. Make sure it is inserted into the correct location and no other values are modified.";
            assertEquals(playerInstance, studentArray[length],
                    String.format(errorMessage, addPlayerMethodName, playerClassName, playerAttributeName));
            for (int x = 0; x < length; x++) {
                assertEquals(holdArray[x], studentArray[x],
                        String.format(errorMessage, addPlayerMethodName, playerClassName, playerAttributeName));
            }
            for (int x = length + 1; x < arrayLength; x++) {
                assertNull(studentArray[x], String.format(errorMessage, addPlayerMethodName, playerClassName, playerAttributeName));
            }
        } else {
            String invalidInsertInput = "Your %s method does not correctly detect invalid input.";
            _assertEquals(false, result, String.format(invalidInsertInput, addPlayerMethodName));
            String errorMessage = "Your %s method should not modify the %s array when the method input is invalid.";
            for (int x = 0; x < length; x++) {
                assertEquals(holdArray[x], studentArray[x],
                        String.format(errorMessage, addPlayerMethodName, playerAttributeName));
            }
        }
    }

    private static Stream<Arguments> getTop2InputProvider() {
        return Stream.of(
                Arguments.of(new Object[][][]{{{}}}, new int[]{}, "Winner: empty with -1 points\nRunner-up: empty with -1 points\n"),
                Arguments.of(new Object[][][]{{{"RockStar", String.class}}}, new int[]{4}, "Winner: RockStar with 4 points\nRunner-up: empty with -1 points\n"),
                Arguments.of(new Object[][][]{{{"Pop Step", String.class}}, {{"Speedrunner", String.class}}}, new int[]{15, 532},
                        "Winner: Speedrunner with 532 points\nRunner-up: Pop Step with 15 points\n"),
                Arguments.of(new Object[][][]{{{"Latee", String.class}}, {{"L", String.class}}, {{"Fading", String.class}}}, new int[]{27, 0, 21},
                        "Winner: Latee with 27 points\nRunner-up: Fading with 21 points\n"),
                Arguments.of(new Object[][][]{{{"Carol", String.class}}, {{"Count Rekt", String.class}}, {{"DK", String.class}},
                                {{"sonny", String.class}}, {{"Guy Fieriiii", String.class}}, {{"V", String.class}}, {{"Beat Drop", String.class}},
                                {{"Hello :)", String.class}}, {{"Lala", String.class}}, {{"Tem", String.class}}, {{"Doodoo", String.class}},
                                {{"Meow", String.class}}, {{"Riviere", String.class}}, {{"Pluie", String.class}}, {{"Friends Destroyer", String.class}},
                                {{"Dada sucks", String.class}}, {{"DragonFly", String.class}}, {{"Dragon without the fly", String.class}},
                                {{"Hiccups", String.class}}, {{"Blue", String.class}}},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 4217, 75, 52, 693, 68, 1, 6, 573, 692, 1234, 8, 29022, 89},
                        "Winner: Hiccups with 29022 points\nRunner-up: Hello :) with 4217 points\n")
        );
    }

    @ParameterizedTest
    @MethodSource("getTop2InputProvider")
    public void leaderBoardHasCorrectGetTop2Method(Object[][][] arguments, int[] points, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(leaderBoard.hasMethod(getTop2MethodName, null),
                String.format(incorrectDefinition, getTop2MethodName, getTop2MethodName));
        assertTrue(leaderBoard.hasModifier(getTop2MethodName, null, "public"),
                String.format(incorrectModifier, getTop2MethodName));
        assertTrue(leaderBoard.hasReturnType(getTop2MethodName, null, String.class),
                String.format(incorrectReturnType, getTop2MethodName));

        Object[][] constructorArguments = {{player.createArray(0), player.getObjectArrayClass()}};
        Object leaderBoardInstance = leaderBoard.createInstance(constructorArguments);

        /* Set attributes */
        Object[] holdArray = (Object[]) player.createArray(points.length, arguments);
        for (int x = 0; x < points.length; x++) {
            player.callMethod(setScoreMethodName, new Object[][]{{points[x], int.class}}, holdArray[x]);
        }
        Object[] studentArray = (Object[]) leaderBoard.getFieldValue(leaderBoardInstance, playerAttributeName);
        System.arraycopy(holdArray, 0, studentArray, 0, points.length);
        leaderBoard.setFieldValue(leaderBoardInstance, points.length, intAttributeName2);

        String errorMessage = "Your " + getTop2MethodName + " method does not correctly return a String containing the " + playerClassName + "s with the highest and second highest " + intAttributeName + ". Ensure all the formatting follows the example given in the question text.";
        String result = (String) leaderBoard.callMethod(getTop2MethodName, leaderBoardInstance);
        assertEquals(msg, result, errorMessage);
    }
}
