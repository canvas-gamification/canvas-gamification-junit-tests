package oop.programs_with_multiple_classes.hard.q5;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Year;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    private final String determineTime = "determineTime";
    private final String determineReplaced = "determineReplacement";
    private final int replacedUnit = 5;
    private final String replaceResponse1 = "Time to buy a new book!";
    private final String replaceResponse2 = "You have enough new books!";


    @BeforeEach
    public void Setup() {
        String bookClassString = "oop.programs_with_multiple_classes.hard.q5." + bookClass;
        String bookcaseClassString = "oop.programs_with_multiple_classes.hard.q5." + bookcaseClass;
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
                "The " + bookClass + " class constructor does not have the correct visibility modifier.";
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
    public void correctDetermineTimeMethod(int year, String type) throws Throwable {
        Object[][] arguments = new Object[][]{
                {year, int.class},
                {type, String.class}
        };
        Object bookInstance = book.createInstance(arguments);
        assertTrue(book.hasMethod(determineTime, new Class[]{}),
                "Your " + bookClass + " class is missing the method" + determineTime + ".");
        assertTrue(book.hasReturnType(determineTime, new Class[]{}, int.class),
                "Your " + determineTime + " method does not return the correct type.");
        assertTrue(book.hasModifier(determineTime, new Class[]{}, "public"),
                "Your " + determineTime + " method does not have the correct visibility modifier.");
        Object determineTimeOutput = book.callMethod(determineTime, bookInstance);
        int determineTimeExpected = Year.now().getValue() - year;
        String incorrectDetermineTimeExpected = "Your " + bookClass + " " + determineTime + " method does not return the correct time.";
        _assertEquals(determineTimeExpected, determineTimeOutput, incorrectDetermineTimeExpected);
    }

    /**
     * Bookcase tests
     **/
    @Test
    public void bookcaseClassHasCorrectAttributes() {
        String missingFieldMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and that it is spelled correctly.";
        String incorrectFieldTypeMessage = "The %s class's %s attribute does not have the correct type.";
        String incorrectFieldModifierMessage = "The %s class's %s attribute does not have the correct visibility modifier.";
        assertTrue(bookcase.hasField(sizeCapacity), String.format(missingFieldMessage, bookcaseClass, sizeCapacity));
        assertTrue(bookcase.hasField(sizeCapacity, int.class), String.format(incorrectFieldTypeMessage, bookcaseClass, sizeCapacity));
        assertTrue(bookcase.hasModifier(sizeCapacity, "private"), String.format(incorrectFieldModifierMessage, bookcaseClass, sizeCapacity));

        assertTrue(bookcase.hasField(books), String.format(missingFieldMessage, bookcaseClass, books));
        assertTrue(bookcase.hasField(books, book.getObjectArrayClass()), String.format(incorrectFieldTypeMessage, bookcaseClass, books));
        assertTrue(bookcase.hasModifier(books, "private"), String.format(incorrectFieldModifierMessage, bookcaseClass, books));
    }

    @Test
    public void bookcaseClassHasCorrectConstructor() {
        String missingConstructorMessage = "Your " + bookcaseClass + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "The " + bookcaseClass + " class constructor does not have the correct visibility modifier.";

        Class<?>[] constructorClasses = new Class[]{
                int.class,
                book.getObjectArrayClass()
        };
        assertTrue(bookcase.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(bookcase.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<Arguments> bookcaseInputProvider() {
        return Stream.of(
                Arguments.of(1, new int[]{2004}, new String[]{"Novella"}),
                Arguments.of(20, new int[]{2005, Year.now().getValue()}, new String[]{"Comic", "Hardcover"}),
                Arguments.of(230, new int[]{2020}, new String[]{"Hardcover"}),
                Arguments.of(1000, new int[]{1999}, new String[]{"Historic Fiction"}),
                Arguments.of(500, new int[]{2023, 2010}, new String[]{"Bromance", "Hardcover"})
        );
    }

    private static Stream<Arguments> bookcaseLongInputProvider() {
        return Stream.of(
                Arguments.of(1, new int[]{2004, 2272}, new String[]{"Novella", "Historic Fiction"}),
                Arguments.of(5, new int[]{2005, 2012, 1956, 1738, 1989, 2001, 2023, 2019}, new String[]{"Comic", "Hardcover", "Sci-fi", "Horror", "Memoir", "Textbook", "Adventure", "Anthology"})
        );
    }

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void bookcaseConstructorInitializesValuesCorrectly(int sizeCapacity, int[] year, String[] type) throws Throwable {
        Object[] books = (Object[]) book.createArray(year.length);
        for (int x = 0; x < books.length; x++) {
            books[x] = book.createInstance(new Object[][]{{year[x], int.class}, {type[x], String.class}});
        }
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class},
                {books, book.getObjectArrayClass()}
        };

        Object bookcaseInstance = bookcase.createInstance(arguments);
        _assertEquals(sizeCapacity, bookcase.getFieldValue(bookcaseInstance, this.sizeCapacity),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + this.sizeCapacity + " attribute.");
        _assertEquals(arguments[1][0], bookcase.getFieldValue(bookcaseInstance, this.books),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + this.books + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("bookcaseLongInputProvider")
    public void bookcaseConstructorInitializesIncorrectValuesCorrectly(int sizeCapacity, int[] year, String[] type) throws Throwable {
        Object[] books = (Object[]) book.createArray(year.length);
        Object[] booksHold = (Object[]) book.createArray(year.length);
        for (int x = 0; x < books.length; x++) {
            Object b = book.createInstance(new Object[][]{{year[x], int.class}, {type[x], String.class}});
            books[x] = b;
            booksHold[x] = b;
        }
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class},
                {books, book.getObjectArrayClass()}
        };

        Object bookcaseInstance = bookcase.createInstance(arguments);

        Object[] actualBooks = (Object[]) bookcase.getFieldValue(bookcaseInstance, this.books);
        boolean shortenedCorrectly = actualBooks.length <= sizeCapacity;
        for (int x = 0; x < sizeCapacity; x++) {
            if (!booksHold[x].equals(actualBooks[x])) {
                shortenedCorrectly = false;
                break;
            }
        }

        _assertEquals(sizeCapacity, bookcase.getFieldValue(bookcaseInstance, this.sizeCapacity),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + this.sizeCapacity + " attribute.");
        assertTrue(shortenedCorrectly,
                "Your " + bookcaseClass + " constructor does not correctly initialize a shortened " + this.books + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void correctBookcaseDetermineReplacementMethod(int sizeCapacity, int[] year, String[] type) throws Throwable {
        Object[] books = (Object[]) book.createArray(year.length);
        for (int x = 0; x < books.length; x++) {
            books[x] = book.createInstance(new Object[][]{{year[x], int.class}, {type[x], String.class}});
        }
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class},
                {books, book.getObjectArrayClass()}
        };

        Object bookcaseInstance = bookcase.createInstance(arguments);
        assertTrue(bookcase.hasMethod(determineReplaced, new Class[]{}),
                "Your " + bookcaseClass + " class is missing the method" + determineReplaced + ".");
        assertTrue(bookcase.hasReturnType(determineReplaced, new Class[]{}, String.class),
                "Your " + determineReplaced + " method does not return the correct type.");
        assertTrue(bookcase.hasModifier(determineReplaced, new Class[]{}, "public"),
                "Your " + determineReplaced + " method does not have the correct visibility modifier.");
        Object determineReplacedOutput = bookcase.callMethod(determineReplaced, bookcaseInstance);

        String determineReplacedExpected = replaceResponse2;
        for(int x = 0; x < books.length; x++){
            if(Year.now().getValue() - year[x] > replacedUnit){
                determineReplacedExpected = replaceResponse1;
            }
        }
        String incorrectDetermineReplacedExpected = "Your " + bookClass + " " + determineReplaced + " method does not return the correct message.";

        _assertEquals(determineReplacedExpected, determineReplacedOutput, incorrectDetermineReplacedExpected);
    }

}
