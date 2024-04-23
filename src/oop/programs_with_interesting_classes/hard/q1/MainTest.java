package oop.programs_with_interesting_classes.hard.q1;

import global.ObjectTest;
import global.variables.clauses.RandomChar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private ObjectTest wordSearch;
    private final String wordSearchClassName = "WordSearch";
    private final String arrayAttributeName = "grid";
    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";
    private final String insertMethodName = "insertHorizontally";
    private final String fillMethodName = "randomFill";

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

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(
                        new String[]{"VOLLEYBALL", "BASKETBALL", "SOCCER", "SWIMMING", "SKIING"},
                        10
                ),
                Arguments.of(
                        new String[]{},
                        0
                ),
                Arguments.of(
                        new String[]{"TESTING", "IF", "SUPERLUOUSLY"},
                        12
                ),
                Arguments.of(
                        new String[]{"CAT", "BATS", "RAT", "AT"}
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

    private static Stream<Arguments> insertInputProvider() {
        return Stream.of(
                Arguments.of("VOLLEYBALL", 0, 10, true),
                Arguments.of("COMPUTER", 8, 8, false),
                Arguments.of("COMPUTER", 7, 8, true),
                Arguments.of("LEAST", 1, 4, false),
                Arguments.of("TEST", 2, 5, true),
                Arguments.of("A", 8, 20, true)
        );
    }

    @ParameterizedTest
    @MethodSource("insertInputProvider")
    public void wordSearchHasCorrectInsertHorizontallyMethod(String wordToInsert, int rowToInsert, int gridSize, boolean shouldSucceed) throws Throwable {
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
        Object result = wordSearch.callMethod(insertMethodName, insertInput, wordSearchInstance);
        String gridMessage;
        if (shouldSucceed) {
            String invalidInsertInput = "Your %s method returned false when the insert should have been successful.";
            _assertEquals(true, result, String.format(invalidInsertInput, insertMethodName));
            gridMessage = "Your %s method does not correctly insert the input string into the %s. Make sure it is inserted into the correct location and no other values are modified.";
            String insertResult = wordToInsert + "A".repeat(gridSize - wordToInsert.length());
            expectedGrid[rowToInsert] = insertResult.toCharArray();
        } else {
            String invalidInsertInput = "Your %s method does not correctly detect invalid input.";
            _assertEquals(false, result, String.format(invalidInsertInput, insertMethodName));
            gridMessage = "Your %s method should not modify the %s when the method input is invalid.";
        }
        char[][] grid = (char[][]) wordSearch.getFieldValue(wordSearchInstance, arrayAttributeName);
        for (int i = 0; i < gridSize; i++) {
            assertArrayEquals(expectedGrid[i], grid[i], String.format(gridMessage, insertMethodName, arrayAttributeName));
        }
    }

    public void randomFillAsserts() {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(wordSearch.hasMethod(fillMethodName, null),
                String.format(incorrectDefinition, wordSearchClassName, fillMethodName));
        assertTrue(wordSearch.hasModifier(fillMethodName, null, "private"),
                String.format(incorrectModifier, fillMethodName));
        assertTrue(wordSearch.hasReturnType(fillMethodName, null, Void.TYPE),
                String.format(incorrectReturnType, fillMethodName));
    }

    @RepeatedTest(4)
    public void wordSearchRandomFillInsertsRandomLetters() throws Throwable {
        randomFillAsserts();
        Object[][] constructorArguments = {{new String[]{"ONE"}, String[].class}};
        Object wordSearchInstance = wordSearch.createInstance(constructorArguments);

        RandomChar randomChar = new RandomChar('A', 'Z', true);
        ArrayList<Character> randomChars = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            char[][] startingArray = new char[20][20];
            wordSearch.setFieldValue(wordSearchInstance, startingArray, arrayAttributeName);
            wordSearch.callMethod(fillMethodName, wordSearchInstance);
            char[][] grid = (char[][]) wordSearch.getFieldValue(wordSearchInstance, arrayAttributeName);
            List<Character> charList = Arrays.stream(grid)
                    // Convert each char[] to a Character stream
                    .flatMapToInt(row -> new String(row).chars())
                    // Convert int stream (char) to a stream of Character
                    .mapToObj(j -> (char) j)
                    // Collect the elements into a list
                    .collect(Collectors.toList());
            randomChars.addAll(charList);
        }
        boolean isRandom = randomChar.validateRandom(randomChars);
        String randomValuesMessage = "Your %s method does not fill the spaces in the %s array with random uppercase letters.";
        assertTrue(isRandom, String.format(randomValuesMessage, fillMethodName, arrayAttributeName));
    }

    private static Stream<char[][]> randomInsertionInputProvider() {
        char base = (char) 0;
        char[][] case1 = new char[][]{
                {'C', base, 'B', 'G', 'J'},
                {base, 'Y', 'P', 'Q', 'D'},
                {'T', 'F', 'V', base, base},
                {'N', 'M', base, 'W', 'X'},
                {'F', 'J', 'S', base, 'R'}
        };
        char[][] case2 = new char[12][12];
        for (int i = 0; i < 12; i++) {
            Arrays.fill(case2[i], base);
        }
        char edge1 = 'A' - 1;
        char edge2 = 'Z' + 1;
        char first = 'A';
        char last = 'Z';
        char[][] case3 = new char[][]{
                {edge1, edge1, first},
                {edge2, last, edge2},
                {edge2, edge1, first}
        };
        return Stream.of(case1, case2, case3);
    }

    @ParameterizedTest
    @MethodSource("randomInsertionInputProvider")
    public void wordSearchRandomFillOnlyReplacesCorrectCharacters(char[][] input) throws Throwable {
        /* Create instance of word search */
        Object[][] constructorArguments = {{new String[]{"ONE"}, String[].class}};
        Object wordSearchInstance = wordSearch.createInstance(constructorArguments);

        /* Copy the input array */
        char[][] expectedOutput = new char[input.length][input.length];
        for (int i = 0; i < expectedOutput.length; i++) {
            expectedOutput[i] = Arrays.copyOf(input[i], input[i].length);
        }

        /* Set the wordSearchInstance to have the input grid */
        wordSearch.setFieldValue(wordSearchInstance, input, arrayAttributeName);
        wordSearch.callMethod(fillMethodName, wordSearchInstance);
    }

    // TODO: Add test for toString
}
