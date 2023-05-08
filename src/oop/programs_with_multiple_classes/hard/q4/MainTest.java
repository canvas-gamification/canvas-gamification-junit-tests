package oop.programs_with_multiple_classes.hard.q4;

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

    private final String bookLc = "book";
    private final String bookUc = "Book";
    private final String bookcaseLc = "bookcase";
    private final String bookcaseUc = "Bookcase";
    private final String year = "year";
    private final String type = "type";
    private final String sizeCapacity = "sizeCapacity";
    private final String b1 = "b1";

    private final String howManyYears = "howManyYears";


    @BeforeEach
    public void Setup() {
        String bookClassString = "oop.programs_with_multiple_classes.hard.q4." + bookUc;
        String bookcaseClassString = "oop.programs_with_multiple_classes.hard.q4." + bookcaseUc;
        book = new ObjectTest(bookClassString);
        bookcase = new ObjectTest(bookcaseClassString);
    }

    /**
     * Book tests
     **/
    @Test
    public void bookClassHasCorrectFields() {
        String missingFieldMessage = "Your " + bookLc + " class is missing a required field.";
        String incorrectFieldModifierMessage = "A field in your " + bookLc + " class has an the wrong visibility modifier.";
        assertTrue(book.hasField(year, int.class), missingFieldMessage);
        assertTrue(book.hasField(type, String.class), missingFieldMessage);
        assertTrue(book.hasModifier(year, "private"), incorrectFieldModifierMessage);
        assertTrue(book.hasModifier(type, "private"), incorrectFieldModifierMessage);
    }

    @Test
    public void bookClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + bookLc + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + bookLc + " class does not have the correct visibility modifier.";
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
                "Your " + book + " constructor does not correctly initialize the " + this.year + " field.");
        _assertEquals(type, book.getFieldValue(bookInstance, this.type),
                "Your " + book + " constructor does not correctly initialize the " + this.type + " field.");
    }

    @ParameterizedTest
    @MethodSource("bookInputProvider")
    public void correctHowManyYearsMethod(int year, String type) throws Throwable {
        Object[][] arguments = new Object[][]{
                {year, int.class},
                {type, String.class}
        };
        Object bookInstance = book.createInstance(arguments);
        Object howManyYearsOutput = book.callMethod(howManyYears, bookInstance);
        int howManyYearsExpected = Year.now().getValue() - year;
        String incorrectHowManyYearsExpected = "Your " + bookLc + " " + howManyYears + " method does not return the correct time.";
        _assertEquals(howManyYearsExpected, howManyYearsOutput, incorrectHowManyYearsExpected);
    }

    /**
     * Bookcase tests
     **/
    @Test
    public void bookcaseClassHasCorrectFields() {
        String missingFieldMessage = "Your " + bookcaseLc + " class is missing a required field.";
        String incorrectFieldModifierMessage = "A field in your " + bookcaseLc + " class has the wrong visibility modifier.";
        assertTrue(bookcase.hasField(sizeCapacity, int.class), missingFieldMessage);
        assertTrue(bookcase.hasModifier(sizeCapacity, "private"), incorrectFieldModifierMessage);
    }

    @Test
    public void bookcaseClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + bookcaseLc + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + bookcaseLc + " class does not have the correct visibility modifier.";
        Class<?>[] constructorClasses = new Class[]{
                int.class,
                Book.class
        };
        assertTrue(bookcase.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(bookcase.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<Arguments> bookcaseInputProvider() {
        return Stream.of(Arguments.of(1, new Book(2004, "Novella")),
                Arguments.of(20, new Book(2005, "Comic")),
                Arguments.of(230, new Book(2010, "Hardcover")),
                Arguments.of(1000, new Book(1999, "Historic Fiction")),
                Arguments.of(500, new Book(1981, "Bromance")));
    }

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void bookcaseConstructorInitializesValuesCorrectly(int sizeCapacity, Book b1) throws Throwable {
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class},
                {b1, Book.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);
        _assertEquals(sizeCapacity, bookcase.getFieldValue(bookcaseInstance, this.sizeCapacity),
                "Your " + bookcaseLc + " constructor does not correctly initialize the " + this.sizeCapacity + " field.");
        _assertEquals(b1, bookcase.getFieldValue(bookcaseInstance, this.b1),
                "Your " + bookcaseLc + " constructor does not correctly initialize the " + this.b1 + " field.");
    }
}
