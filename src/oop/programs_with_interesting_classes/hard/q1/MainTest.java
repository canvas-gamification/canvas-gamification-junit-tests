package oop.programs_with_interesting_classes.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private ObjectTest wordSearch;
    private final String wordSearchClassName = "WordSearch";
    private final String arrayAttributeName = "grid";
    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";
    private final String insertMethodName = "insertHorizontally";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q1.";
        wordSearch = new ObjectTest(packageString + wordSearchClassName);
    }

    @Test
    public void wordSearchClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(wordSearch.hasField(arrayAttributeName), String.format(missingAttribute, wordSearchClassName, arrayAttributeName));
        assertTrue(wordSearch.hasField(arrayAttributeName, char[][].class), String.format(incorrectTypeMessage, arrayAttributeName));
        assertTrue(wordSearch.hasModifier(arrayAttributeName, "private"), String.format(incorrectModifier, arrayAttributeName));
    }

    // TODO: Add more test cases to constructor
    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(
                        new String[]{"VOLLEYBALL", "BASKETBALL", "SOCCER", "SWIMMING", "SKIING"},
                        10
                ),
                Arguments.of(
                        new String[]{},
                        0
                )
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void wordSearchClassHasRequiredConstructor(String[] words, int expectedGridLength) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String[].class};
        assertTrue(wordSearch.hasConstructor(constructorParameters), String.format(missingConstructor, wordSearchClassName));
        assertTrue(wordSearch.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, wordSearchClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{words, String[].class}};
        Object wordSearchInstance = wordSearch.createInstance(constructorArguments);

        /* Check if the size of the grid is correct */
        assertTrue(wordSearch.hasField(arrayAttributeName, char[][].class), String.format(incorrectTypeMessage, arrayAttributeName));
        char[][] grid = (char[][]) wordSearch.getFieldValue(wordSearchInstance, arrayAttributeName);
        assertEquals(expectedGridLength, grid.length, String.format("Your %s array does not have the correct number of rows", arrayAttributeName));
        for (int i = 0; i < expectedGridLength; i++)
            assertEquals(expectedGridLength, grid[i].length, String.format("Your %s array does not have the correct number of columns in each row.", arrayAttributeName));

        /* Check that each word was inserted correctly */
        String incorrectWordInsertionMessage = String.format("Your %s constructor does not correctly insert the input String array into the %s.", wordSearchClassName, arrayAttributeName);
        for (int i = 0; i < words.length; i++) {
            String gridWord = new String(grid[i]).substring(0, words[i].length());
            assertEquals(words[i], gridWord, incorrectWordInsertionMessage);
        }

        /* Check that all remaining characters are uppercase letters */
        String incorrectLetterInsertion = "Your %s constructor does not correctly insert random uppercase letters into the %s.";
        for (int i = 0; i < expectedGridLength; i++) {
            int startingIndex = i < words.length ? words[i].length() : 0;
            for (int j = startingIndex; j < expectedGridLength; j++) {
                char c = grid[i][j];
                assertTrue(Character.isAlphabetic(c) && Character.isUpperCase(c), String.format(incorrectLetterInsertion, wordSearchClassName, arrayAttributeName));
            }
        }
    }

    // TODO: Add test cases for insert method
    private static Stream<Arguments> insertInputProvider() {
        return Stream.of(
                Arguments.of(
                        new String[]{"VOLLEYBALL", "BASKETBALL", "SOCCER", "SWIMMING", "SKIING"},
                        10
                ),
                Arguments.of(
                        new String[]{},
                        0
                )
        );
    }

    @ParameterizedTest
    @MethodSource("insertInputProvider")
    public void wordSearchHasCorrectInsertHorizontallyMethod(String wordToInsert, int rowToInsert, int gridSize) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{String.class, int.class};
        assertTrue(wordSearch.hasMethod(insertMethodName, methodClassParameters),
                String.format(incorrectDefinition, wordSearchClassName, insertMethodName));
        assertTrue(wordSearch.hasModifier(insertMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, insertMethodName));
        assertTrue(wordSearch.hasReturnType(insertMethodName, methodClassParameters, boolean.class),
                String.format(incorrectReturnType, insertMethodName));

        Object[][] constructorArguments = {{new String[]{"ONE"}, String[].class}};
        Object wordSearchInstance = wordSearch.createInstance(constructorArguments);

        /* Set grid to desired size for test */
        char[][] startingArray = new char[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            Arrays.fill(startingArray[i], 'A');
        }
        // Create a clone of the 2D array
        char[][] expectedGrid = new char[gridSize][];
        for (int i = 0; i < gridSize; i++) {
            expectedGrid[i] = startingArray[i].clone();
        }

        wordSearch.setFieldValue(wordSearchInstance, startingArray, arrayAttributeName);

        /* Check if word is inserted correctly or false returned if the word is too long */
        Object[][] insertInput = {{wordToInsert, String.class}, {rowToInsert, int.class}};
        Object result = wordSearch.callMethod(insertMethodName, insertInput);
        String gridMessage;
        if (rowToInsert > gridSize || wordToInsert.length() > gridSize) {
            String invalidInsertInput = "Your %s method does not correctly detect invalid input.";
            _assertEquals(false, result, String.format(invalidInsertInput, insertMethodName));
            gridMessage = "Your %s method should not modify the %s when the method input is invalid.";
        } else {
            String invalidInsertInput = "Your %s method returned false when the insert should have been successful.";
            _assertEquals(true, result, String.format(invalidInsertInput, insertMethodName));
            gridMessage = "Your %s method does not correctly insert the input string into the %s. Make sure it is inserted into the correct location and no other values are modified.";
            String insertResult = wordToInsert + "A".repeat(wordToInsert.length() - gridSize);
            expectedGrid[rowToInsert] = insertResult.toCharArray();
        }
        char[][] grid = (char[][]) wordSearch.getFieldValue(wordSearchInstance, arrayAttributeName);
        for (int i = 0; i < gridSize; i++) {
            assertArrayEquals(expectedGrid[i], grid[i], String.format(gridMessage, insertMethodName, arrayAttributeName));
        }
    }

    // TODO: Add test for random letter insertion

    // TODO: Add test for toString
}
