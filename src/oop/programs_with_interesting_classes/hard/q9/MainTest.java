package oop.programs_with_interesting_classes.hard.q9;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    // Java question
    private ObjectTest borrower;
    private ObjectTest book;
    private final String borrowerClassName = "Borrower";
    private final String bookClassName = "Book";
    private final String stringAttributeName1 = "name";
    private final String stringAttributeName2 = "date";
    private final String borrowerArrayAttributeName = "borrowers";
    private final String intAttributeName = "usedSpaces";
    private final String stringAttributeName3 = "title";
    private final String expandMethodName = "expand";
    private final String signOutMethodName = "signOut";
    private final int baseSize = 10;

    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q9.";
        borrower = new ObjectTest(packageString + borrowerClassName);
        book = new ObjectTest(packageString + bookClassName);
    }

    @Test
    public void borrowerClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(borrower.hasField(stringAttributeName1), String.format(missingAttribute, borrowerClassName, stringAttributeName1));
        assertTrue(borrower.hasField(stringAttributeName1, String.class), String.format(incorrectTypeMessage, stringAttributeName1));
        assertTrue(borrower.hasModifier(stringAttributeName1, "private"), String.format(incorrectModifier, stringAttributeName1));
        assertTrue(borrower.hasField(stringAttributeName2), String.format(missingAttribute, borrowerClassName, stringAttributeName2));
        assertTrue(borrower.hasField(stringAttributeName2, String.class), String.format(incorrectTypeMessage, stringAttributeName2));
        assertTrue(borrower.hasModifier(stringAttributeName2, "private"), String.format(incorrectModifier, stringAttributeName2));
    }

    private static Stream<Arguments> borrowerConstructorInputProvider() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("Bob", "September 16, 2020"),
                Arguments.of("Mary no 3", "05/31/38")
        );
    }

    @ParameterizedTest
    @MethodSource("borrowerConstructorInputProvider")
    public void borrowerClassHasRequiredConstructor(String name, String date) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, String.class};
        assertTrue(borrower.hasConstructor(constructorParameters), String.format(missingConstructor, borrowerClassName));
        assertTrue(borrower.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, borrowerClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{name, String.class}, {date, String.class}};
        Object borrowerInstance = borrower.createInstance(constructorArguments);

        assertEquals(name, borrower.getFieldValue(borrowerInstance, stringAttributeName1));
    }

    private static Stream<Arguments> borrowerToStringInputProvider() {
        return Stream.of(
                Arguments.of("", "", " signed on "),
                Arguments.of("Bob", "September 16, 2020", "Bob signed on September 16, 2020"),
                Arguments.of("Mary no 3", "05/31/38", "Mary no 3 signed on 05/31/38")
        );
    }

    @ParameterizedTest
    @MethodSource("borrowerToStringInputProvider")
    public void borrowerHasCorrectToStringMethod(String name, String date, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(borrower.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, borrowerClassName, methodNameToString));
        assertTrue(borrower.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(borrower.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object[][] constructorArguments = {{name, String.class}, {date, String.class}};
        Object borrowerInstance = borrower.createInstance(constructorArguments);

        String result = (String) borrower.callMethod("toString", borrowerInstance);
        assertEquals(msg, result, "Your " + borrowerClassName + " toString method does not return the correct String. Ensure it follows the formatting given in the question text.");
    }

    @Test
    public void bookClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(book.hasField(borrowerArrayAttributeName), String.format(missingAttribute, bookClassName, borrowerArrayAttributeName));
        assertTrue(book.hasField(borrowerArrayAttributeName, borrower.getObjectArrayClass()), String.format(incorrectTypeMessage, borrowerArrayAttributeName));
        assertTrue(book.hasModifier(borrowerArrayAttributeName, "private"), String.format(incorrectModifier, borrowerArrayAttributeName));
        assertTrue(book.hasField(intAttributeName), String.format(missingAttribute, bookClassName, intAttributeName));
        assertTrue(book.hasField(intAttributeName, int.class), String.format(incorrectTypeMessage, intAttributeName));
        assertTrue(book.hasModifier(intAttributeName, "private"), String.format(incorrectModifier, intAttributeName));
        assertTrue(book.hasField(stringAttributeName3), String.format(missingAttribute, bookClassName, stringAttributeName3));
        assertTrue(book.hasField(stringAttributeName3, String.class), String.format(incorrectTypeMessage, stringAttributeName3));
        assertTrue(book.hasModifier(stringAttributeName3, "private"), String.format(incorrectModifier, stringAttributeName3));
    }

    private static Stream<String> bookConstructorInputProvider() {
        return Stream.of("", "Life of Pi", "Fahrenheit 451", "Encyclopedia 125 Vol. 6/29");
    }

    @ParameterizedTest
    @MethodSource("bookConstructorInputProvider")
    public void bookClassHasRequiredConstructor(String title) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class};
        assertTrue(book.hasConstructor(constructorParameters), String.format(missingConstructor, bookClassName));
        assertTrue(book.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, bookClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{title, String.class}};
        Object bookInstance = book.createInstance(constructorArguments);

        String msg = "Your %s constructor does not correctly initialize the %s attribute.";
        assertEquals(title, book.getFieldValue(bookInstance, stringAttributeName3), String.format(msg, bookClassName, stringAttributeName3));
        assertEquals(0, book.getFieldValue(bookInstance, intAttributeName), String.format(msg, bookClassName, intAttributeName));
        assertArrayEquals((Object[]) borrower.createArray(baseSize), (Object[]) book.getFieldValue(bookInstance, borrowerArrayAttributeName), String.format(msg, bookClassName, borrowerArrayAttributeName));
    }

    private static Stream<Arguments> expandInputProvider() {
        return Stream.of(
                Arguments.of(2, 0, new Object[][][]{{{}}}),
                Arguments.of(20, 0, new Object[][][]{{{}}}),
                Arguments.of(1, 1, new Object[][][]{{{"Chrissy", String.class}, {"April 1", String.class}}}),
                Arguments.of(5, 3, new Object[][][]{{{"Scoursesy", String.class}, {"'09", String.class}}, {{"Sunny", String.class}, {"January 1 2001", String.class}},
                        {{"Raine S", String.class}, {"Monday December 31 1945", String.class}}}),
                Arguments.of(5, 5, new Object[][][]{{{"Mary", String.class}, {"the day that fb released their 5th album", String.class}},
                        {{"Te", String.class}, {"October 1", String.class}}, {{"Liam", String.class}, {"October 15", String.class}}, {{"Seth", String.class}, {"October 18", String.class}},
                        {{"Robin", String.class}, {"February '24", String.class}}})
        );
    }

    @ParameterizedTest
    @MethodSource("expandInputProvider")
    public void correctExpandMethod(int size, int actualSize, Object[][][] arguments) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(book.hasMethod(expandMethodName, null),
                String.format(incorrectDefinition, bookClassName, expandMethodName));
        assertTrue(book.hasModifier(expandMethodName, null, "private"),
                String.format(incorrectModifier, expandMethodName));
        assertTrue(book.hasReturnType(expandMethodName, null, Void.TYPE),
                String.format(incorrectReturnType, expandMethodName));

        Object[][] constructorArguments = {{"name", String.class}};
        Object bookInstance = book.createInstance(constructorArguments);

        Object[] holdSmallArray = (Object[]) (actualSize == 0 ? borrower.createArray(size) : borrower.createArray(actualSize, arguments));
        Object[] properArray = (Object[]) borrower.createArray(size);
        System.arraycopy(holdSmallArray, 0, properArray, 0, actualSize);
        Object[] result = (Object[]) borrower.createArray(size * 2);
        System.arraycopy(holdSmallArray, 0, result, 0, actualSize);
        book.setFieldValue(bookInstance, properArray, borrowerArrayAttributeName);

        book.callMethod(expandMethodName, bookInstance);
        assertArrayEquals(result, (Object[]) book.getFieldValue(bookInstance, borrowerArrayAttributeName),
                "Your " + expandMethodName + " method does not correctly double the size of the " + borrowerArrayAttributeName + " array and retain the previous elements.");
    }

    private static Stream<Arguments> signOutInputProvider() {
        return Stream.of(
                Arguments.of(5, 0, new Object[][][]{{{}}}, new Object[][]{{"Clarissa", String.class}, {"2009", String.class}}), //empty array
                Arguments.of(5, 1, new Object[][][]{{{"Steven", String.class}, {"February 1989", String.class}}},
                        new Object[][]{{"Kitty", String.class}, {"March 2012", String.class}}), //one element in
                Arguments.of(5, 4, new Object[][][]{{{"Paige", String.class}, {"01/01/01", String.class}}, {{"Sky", String.class}, {"February 31", String.class}},
                        {{"Jet", String.class}, {"2nd", String.class}}, {{"Bill Nie", String.class}, {"science hour is every hour", String.class}}},
                        new Object[][]{{"Laura", String.class}, {"August 23, 2024", String.class}}), //one element from full
                Arguments.of(5, 5, new Object[][][]{{{"Sylvia Plath", String.class}, {"12", String.class}}, {{"Shane", String.class}, {"Winter 21", String.class}},
                        {{"Guy", String.class}, {"April", String.class}}, {{"Captain", String.class}, {"2012", String.class}},
                        {{"Theo Crane", String.class}, {"2067", String.class}}}, new Object[][]{{"Katie Overtime", String.class}, {"Jan.", String.class}}) // full
        );
    }

    @ParameterizedTest
    @MethodSource("signOutInputProvider")
    public void correctSignOutMethod(int size, int actualSize, Object[][][] arguments, Object[][] toAdd) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{borrower.getObjectClass()};
        assertTrue(book.hasMethod(signOutMethodName, methodClassParameters),
                String.format(incorrectDefinition, bookClassName, signOutMethodName));
        assertTrue(book.hasModifier(signOutMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, signOutMethodName));
        assertTrue(book.hasReturnType(signOutMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, signOutMethodName));

        /* Create instance of word search */
        Object[][] constructorArguments = {{"name", String.class}};
        Object bookInstance = book.createInstance(constructorArguments);

        Object[] holdSmallArray = (Object[]) (actualSize == 0 ? borrower.createArray(size) : borrower.createArray(actualSize, arguments));
        Object[] properArray = (Object[]) (size==actualSize ? borrower.createArray(size* 2) : borrower.createArray(size));
        System.arraycopy(holdSmallArray, 0, properArray, 0, actualSize);
        Object[] result = (Object[]) borrower.createArray(properArray.length);
        System.arraycopy(holdSmallArray, 0, result, 0, actualSize);
        Object holdBorrower = borrower.createInstance(toAdd);
        result[actualSize] = holdBorrower;
        book.setFieldValue(bookInstance, properArray, borrowerArrayAttributeName);
        book.setFieldValue(bookInstance, actualSize, intAttributeName);

        Object[][] insertInput = {{holdBorrower, borrower.getObjectClass()}};
        book.callMethod(signOutMethodName, insertInput, bookInstance);
        assertArrayEquals(result, (Object[]) book.getFieldValue(bookInstance, borrowerArrayAttributeName),
                "Your " + signOutMethodName + " method does not correctly add a " + borrowerClassName + " to the array.");
        assertEquals(actualSize + 1, book.getFieldValue(bookInstance, intAttributeName),
                "Your " + signOutMethodName + " method does not correctly update the value of " + intAttributeName + ".");
    }

    private static Stream<Arguments> bookToStringInputProvider() {
        return Stream.of(
                Arguments.of("Cooking 101", 5, 0, new Object[][][]{{{}}}, "Title: Cooking 101\n"),
                Arguments.of("", 5, 1, new Object[][][]{{{"Steven", String.class}, {"February 1989", String.class}}}, "Title: \nSteven signed on February 1989\n"),
                Arguments.of("The Fly Swatter", 5, 4, new Object[][][]{{{"Paige", String.class}, {"01/01/01", String.class}}, {{"Sky", String.class}, {"February 31", String.class}},
                                {{"Jet", String.class}, {"2nd", String.class}}, {{"Bill Nie", String.class}, {"science hour is every hour", String.class}}},
                            "Title: The Fly Swatter\nPaige signed on 01/01/01\nSky signed on February 31\nJet signed on 2nd\nBill Nie signed on science hour is every hour\n"),
                Arguments.of("Mirror", 5, 5, new Object[][][]{{{"Sylvia Plath", String.class}, {"12", String.class}}, {{"Shane", String.class}, {"Winter 21", String.class}},
                        {{"Guy", String.class}, {"April", String.class}}, {{"Captain", String.class}, {"2012", String.class}},
                        {{"Theo Crane", String.class}, {"2067", String.class}}},
                        "Title: Mirror\nSylvia Plath signed on 12\nShane signed on Winter 21\nGuy signed on April\nCaptain signed on 2012\nTheo Crane signed on 2067\n")
        );
    }

    @ParameterizedTest
    @MethodSource("bookToStringInputProvider")
    public void wordSearchHasCorrectToStringMethod(String title, int size, int actualSize, Object[][][] arguments, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(book.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, bookClassName, methodNameToString));
        assertTrue(book.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(book.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object[][] constructorArguments = {{title, String.class}};
        Object bookInstance = book.createInstance(constructorArguments);

        Object[] holdSmallArray = (Object[]) (actualSize == 0 ? borrower.createArray(size) : borrower.createArray(actualSize, arguments));
        Object[] properArray = (Object[]) borrower.createArray(size);
        System.arraycopy(holdSmallArray, 0, properArray, 0, actualSize);
        book.setFieldValue(bookInstance, properArray, borrowerArrayAttributeName);
        book.setFieldValue(bookInstance, actualSize, intAttributeName);

        String result = (String) book.callMethod("toString", bookInstance);

        assertEquals(msg, result, "Your " + bookClassName + " toString method does not return the correct String. Ensure it follows the formatting given in the question text.");
    }
}
