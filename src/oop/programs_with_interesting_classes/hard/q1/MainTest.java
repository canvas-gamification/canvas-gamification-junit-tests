package oop.programs_with_interesting_classes.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest wordSearch;
    private final String wordSearchClassName = "WordSearch";
    private final String arrayAttributeName = "grid";
    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q1.";
        wordSearch = new ObjectTest(packageString + wordSearchClassName);
    }

    @Test
    public void carClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(wordSearch.hasField(arrayAttributeName), String.format(missingAttribute, wordSearchClassName, arrayAttributeName));
        assertTrue(wordSearch.hasField(arrayAttributeName, char[][].class), String.format(incorrectTypeMessage, arrayAttributeName));
        assertTrue(wordSearch.hasModifier(arrayAttributeName, "private"), String.format(incorrectModifier, arrayAttributeName));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(Arguments.of(new String[]{"AWD", "AWD"}, new char[][]{{'A', 'W', 'D'}, {'A', 'W', 'D'}}));
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
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        String incorrectArray = "Your %s constructor does not initialize the %s array to the correct value. Make sure each item is spelt correctly and it is in the order as listed in the question text.";
        Object[][] constructorArguments = {{words, String[][].class}};
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
        for(int i = 0; i < expectedGridLength; i++) {
            for (int j = words[i].length(); j < expectedGridLength; j++) {
                char c = grid[i][j];
                assertTrue(Character.isAlphabetic(c) && Character.isUpperCase(c));
            }
        }
    }
}
