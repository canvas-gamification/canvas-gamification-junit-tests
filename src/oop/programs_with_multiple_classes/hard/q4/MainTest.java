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
    private final String b1 = "b1";
    private final String howManyYears = "howManyYears";


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
        assertTrue(book.hasModifier(howManyYears,  new Class[]{}, "public"),
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
    public void bookcaseClassHasCorrectAttributes() {
        String missingFieldMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and that it is spelled correctly.";
        String incorrectFieldTypeMessage = "The %s class's %s attribute does not have the correct type.";
        String incorrectFieldModifierMessage = "The %s class's %s attribute does not have the correct visibility modifier.";
        assertTrue(bookcase.hasField(sizeCapacity), String.format(missingFieldMessage, bookcaseClass, sizeCapacity));
        assertTrue(bookcase.hasField(sizeCapacity, int.class), String.format(incorrectFieldTypeMessage, bookcaseClass, sizeCapacity));
        assertTrue(bookcase.hasModifier(sizeCapacity, "private"), String.format(incorrectFieldModifierMessage, bookcaseClass, sizeCapacity));
    }

    @Test
    public void bookcaseClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + bookcaseClass + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "Your " + bookcaseClass + " class constructor does not have the correct visibility modifier.";
        Class<?>[] constructorClasses = new Class[]{
                int.class,
                Book.class
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
        Object bookInstance = null;

        try {
            Object[][] arguments = new Object[][]{
                    {year, int.class},
                    {type, String.class}
            };
            bookInstance = book.createInstance(arguments);
        }
        catch (Error e){
            fail(bookClass + " object could not be created to be passed to " + bookcaseClass + ". Ensure your " +
                    bookClass + " class's constructor exists and has the correct parameters.");
        }

        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class},
                {bookInstance, Book.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);
        _assertEquals(sizeCapacity, bookcase.getFieldValue(bookcaseInstance, this.sizeCapacity),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + this.sizeCapacity + " attribute.");
        _assertEquals(bookInstance, bookcase.getFieldValue(bookcaseInstance, this.b1),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + this.b1 + " attribute.");
    }
}
