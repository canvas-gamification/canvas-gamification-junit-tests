package oop.programs_with_multiple_classes.hard.q4;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Year;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {
    // Java

    private ObjectTest book;
    private ObjectTest bookcase;

    private final String bookClass = "Book";
    private final String bookcaseClass = "Bookcase";
    private final String year = "year";
    private final String type = "type";
    private final String sizeCapacity = "sizeCapacity";
    private final String books = "books";
    private final String howManyYears = "howManyYears";
    private final String setBooks = "setBooks";
    private final String sellBook = "sellBook";
    private final String sellErrorMessage = "No, this book is precious to me\\.";
    private final static int pivot = 20;

    @BeforeEach
    public void Setup() {
        String bookClassString = "oop.programs_with_multiple_classes.hard.q4." + bookClass;
        String bookcaseClassString = "oop.programs_with_multiple_classes.hard.q4." + bookcaseClass;
        book = new ObjectTest(bookClassString);
        bookcase = new ObjectTest(bookcaseClassString);
    }

    /**
     * Book tests
     **/
    @Test
    public void bookClassHasCorrectAttributes() {
        String missingFieldMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and that it is spelled correctly.";
        String incorrectFieldTypeMessage = "The %s class's %s attribute does not have the correct type.";
        String incorrectFieldModifierMessage = "The %s class's %s attribute does not have the correct visibility modifier.";
        assertTrue(book.hasField(year), String.format(missingFieldMessage, bookClass, year));
        assertTrue(book.hasField(type), String.format(missingFieldMessage, bookClass, type));
        assertTrue(book.hasField(year, int.class), String.format(incorrectFieldTypeMessage, bookClass, year));
        assertTrue(book.hasField(type, String.class), String.format(incorrectFieldTypeMessage, bookClass, type));
        assertTrue(book.hasModifier(year, "private"), String.format(incorrectFieldModifierMessage, bookClass, year));
        assertTrue(book.hasModifier(type, "private"), String.format(incorrectFieldModifierMessage, bookClass, type));
    }

    @Test
    public void bookClassHasCorrectConstructor() {
        String missingConstructorMessage = "Your " + bookClass + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "Your " + bookClass + " class constructor does not have the correct visibility modifier.";
        Class<?>[] constructorClasses = new Class[]{
                int.class,
                String.class
        };
        assertTrue(book.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(book.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<Arguments> bookInputProvider() {
        return Stream.of(
                Arguments.of(1, "Hardcover"),
                Arguments.of(1, "Softcover"),
                Arguments.of(3, "Paperback"),
                Arguments.of(4, "Softback"),
                Arguments.of(0, "Hardcover"));
    }

    @ParameterizedTest
    @MethodSource("bookInputProvider")
    public void bookConstructorInitializesValuesCorrectly(int year, String type) throws Throwable {
        Object[][] arguments = new Object[][]{
                {year, int.class},
                {type, String.class}
        };
        Object bookInstance = book.createInstance(arguments);
        _assertEquals(year, book.getFieldValue(bookInstance, this.year),
                "Your " + book + " constructor does not correctly initialize the " + this.year + " attribute.");
        _assertEquals(type, book.getFieldValue(bookInstance, this.type),
                "Your " + book + " constructor does not correctly initialize the " + this.type + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("bookInputProvider")
    public void correctHowManyYearsMethod(int year, String type) throws Throwable {
        Object[][] arguments = new Object[][]{
                {year, int.class},
                {type, String.class}
        };
        Object bookInstance = book.createInstance(arguments);
        assertTrue(book.hasMethod(howManyYears, new Class[]{}),
                "Your " + bookcaseClass + " class is missing the method" + howManyYears + ".");
        assertTrue(book.hasReturnType(howManyYears, new Class[]{}, int.class),
                "Your " + howManyYears + " method does not return the correct type.");
        assertTrue(book.hasModifier(howManyYears, new Class[]{}, "public"),
                "Your " + howManyYears + " method does not have the correct visibility modifier.");
        Object howManyYearsOutput = book.callMethod(howManyYears, bookInstance);
        int howManyYearsExpected = Year.now().getValue() - year;
        String incorrectHowManyYearsExpected = "Your " + bookClass + " class's " + howManyYears + " method does not return the correct age of the " + bookClass + ".";
        _assertEquals(howManyYearsExpected, howManyYearsOutput, incorrectHowManyYearsExpected);
    }

    /**
     * Bookcase tests
     **/
    @Test
    public void bookcaseClassHasCorrectAttributes() throws Throwable {
        String missingFieldMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and that it is spelled correctly.";
        String incorrectFieldTypeMessage = "The %s class's %s attribute does not have the correct type.";
        String incorrectFieldModifierMessage = "The %s class's %s attribute does not have the correct visibility modifier.";
        assertTrue(bookcase.hasField(sizeCapacity), String.format(missingFieldMessage, bookcaseClass, sizeCapacity));
        assertTrue(bookcase.hasField(sizeCapacity, int.class), String.format(incorrectFieldTypeMessage, bookcaseClass, sizeCapacity));
        assertTrue(bookcase.hasModifier(sizeCapacity, "private"), String.format(incorrectFieldModifierMessage, bookcaseClass, sizeCapacity));

        try {
            Object[][] arguments = new Object[][]{
                    {0, int.class},
                    {"type", String.class}
            };
            book.createInstance(arguments);
        } catch (Error e) {
            fail("Your program does not contain the " + bookClass + " class.");
        }

        assertTrue(bookcase.hasField(books), String.format(missingFieldMessage, bookcaseClass, books));
        assertTrue(bookcase.hasField(books, Book[].class), String.format(incorrectFieldTypeMessage, bookcaseClass, books));
        assertTrue(bookcase.hasModifier(books, "private"), String.format(incorrectFieldModifierMessage, bookcaseClass, books));
    }

    @Test
    public void bookcaseClassHasCorrectConstructors() throws Throwable {
        String missingConstructorMessage = "Your " + bookcaseClass + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "Your " + bookcaseClass + " class constructor does not have the correct visibility modifier.";
        try {
            Object[][] arguments = new Object[][]{
                    {0, int.class},
                    {"type", String.class}
            };
            book.createInstance(arguments);
        } catch (Error e) {
            fail("Your program does not contain the " + bookClass + " class.");
        }

        Class<?>[] constructorClasses = new Class[]{
                int.class,
                Book[].class
        };
        assertTrue(bookcase.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(bookcase.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<Arguments> bookcaseInputProvider() {
        return Stream.of(Arguments.of(1, 2004, "Novella"),
                Arguments.of(20, 2005, "Comic"),
                Arguments.of(230, 2010, "Hardcover"),
                Arguments.of(1000, 1999, "Historic Fiction"),
                Arguments.of(500, 1981, "Bromance")
        );
    }

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void bookcaseConstructorInitializesValuesCorrectly(int sizeCapacity, int year, String type) throws Throwable {

        try {
            Object[][] arguments = new Object[][]{
                    {year, int.class},
                    {type, String.class}
            };
            book.createInstance(arguments);
        } catch (Error e) {
            fail(bookClass + " object could not be created to be passed to " + bookcaseClass + ". Ensure your " +
                    bookClass + " class's constructor exists and has the correct parameters.");
        }

        Book[] booksHold = new Book[]{new Book(year, type), new Book(year, type), new Book(year, type)};

        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class},
                {booksHold, Book[].class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);
        _assertEquals(sizeCapacity, bookcase.getFieldValue(bookcaseInstance, this.sizeCapacity),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + this.sizeCapacity + " attribute.");
        _assertEquals(booksHold, bookcase.getFieldValue(bookcaseInstance, this.books),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + this.books + " attribute.");
    }

    private static Stream<Arguments> setBooksInputProvider() {
        return Stream.of(
                Arguments.of(5, new int[]{1, 1, 1, 1, 1}),
                Arguments.of(3, new int[]{1, 0, 0}),
                Arguments.of(3, new int[]{0, 1, 1}),
                Arguments.of(1, new int[]{0}),
                Arguments.of(0, new int[]{}),
                Arguments.of(4, new int[]{0, 1, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("setBooksInputProvider")
    public void correctSetBooksMethod(int size, int[] bookPlacement) throws Throwable {
        try {
            Object[][] arguments = new Object[][]{
                    {6, int.class},
                    {"type", String.class}
            };
            book.createInstance(arguments);
        } catch (Error e) {
            fail(bookClass + " object could not be created to be passed to " + bookcaseClass + ". Ensure your " +
                    bookClass + " class's constructor exists and has the correct parameters.");
        }

        Book[] booksHold = new Book[size];
        for (int x = 0; x < size; x++) {
            booksHold[x] = new Book(0, "type");
        }

        Object[][] arguments = new Object[][]{
                {size, int.class},
                {booksHold, Book[].class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);

        Book[] givenBooks = new Book[size];
        Book[] endingBooks = new Book[size];
        for (int x = 0; x < size; x++) {
            Book b = new Book(5, "test");
            givenBooks[x] = b;
            endingBooks[x] = b;
        }

        assertTrue(bookcase.hasMethod(setBooks, new Class[]{Book[].class}),
                String.format("Your %s class is missing the method %s.", bookcaseClass, setBooks));
        assertTrue(bookcase.hasMethod(setBooks, new Class[]{Book[].class}, void.class),
                String.format("Your %s class %s method does not have the correct return type.", bookcaseClass, setBooks));
        assertTrue(bookcase.hasMethod(setBooks, new Class[]{Book[].class}, void.class, new String[]{"public"}),
                String.format("Your %s class %s method does not have the correct visibility modifier.", bookcaseClass, setBooks));

        bookcase.callMethod(setBooks, new Object[][]{{givenBooks, Book[].class}}, new String[]{"public"}, bookcaseInstance);

        _assertArrayEquals(endingBooks, bookcase.getFieldValue(bookcaseInstance, books),
                "Your " + setBooks + " method does not correctly set the " + books + " attribute.");
    }

    private static Stream<Arguments> sellBookInputProvider() {
        return Stream.of(
                Arguments.of(5, getCurrYear() - pivot, true, new int[]{1, 1, 1, 1, 1}, 0),
                Arguments.of(5, getCurrYear() - pivot - 1, true, new int[]{1, 1, 1, 1, 1}, 1),
                Arguments.of(5, getCurrYear() - pivot + 1, false, new int[]{1, 1, 1, 1, 1}, 2),
                Arguments.of(5, 200, true, new int[]{1, 1, 1, 1, 1}, 3),
                Arguments.of(5, getCurrYear() - 1, false, new int[]{1, 1, 1, 1, 1}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("sellBookInputProvider")
    public void correctSellBookMethod(int size, int year, boolean tooOldToSell, int[] bookPlacement, int index) throws Throwable {
        try {
            Object[][] arguments = new Object[][]{
                    {6, int.class},
                    {"type", String.class}
            };
            book.createInstance(arguments);
        } catch (Error e) {
            fail(bookClass + " object could not be created to be passed to " + bookcaseClass + ". Ensure your " +
                    bookClass + " class's constructor exists and has the correct parameters.");
        }

        Book[] booksGiven = new Book[size];
        Book[] result = new Book[size];
        for (int x = 0; x < size; x++) {
            if (bookPlacement[x] == 1) {
                Book b = new Book(year, "type");
                booksGiven[x] = b;
                result[x] = b;
                if (x == index & !tooOldToSell) {
                    result[x] = null;
                }
            }
        }

        Object[][] arguments = new Object[][]{
                {size, int.class},
                {booksGiven, Book[].class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);

        assertTrue(bookcase.hasMethod(sellBook, new Class[]{int.class}),
                String.format("Your %s class is missing the method %s.", bookcaseClass, sellBook));
        assertTrue(bookcase.hasMethod(sellBook, new Class[]{int.class}, void.class),
                String.format("Your %s class %s method does not have the correct return type.", bookcaseClass, sellBook));
        assertTrue(bookcase.hasMethod(sellBook, new Class[]{int.class}, void.class, new String[]{"public"}),
                String.format("Your %s class %s method does not have the correct visibility modifier.", bookcaseClass, sellBook));

        if (tooOldToSell) {
            bookcase.callMethod(sellBook, new Object[][]{{index, int.class}}, new String[]{"public"}, bookcaseInstance,
                    new Clause[]{
                            new StringLiteral(sellErrorMessage),
                            new Optional(new StringLiteral(" "))
                    }, "Your " + sellBook + " method does not print the correct response.");
        } else {
            bookcase.callMethod(sellBook, new Object[][]{{index, int.class}}, new String[]{"public"}, bookcaseInstance);
        }

        _assertArrayEquals(result, bookcase.getFieldValue(bookcaseInstance, books),
                "Your " + sellBook + " method does not correctly modify the " + books + " attribute.");
    }

    private static int getCurrYear() {
        return Year.now().getValue();
    }
}
