package oop.programs_with_multiple_classes.hard.q5;

import global.BaseTest;
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

import java.time.Year;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
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


    @BeforeEach
    public void Setup() {
        String bookClassString = "oop.programs_with_multiple_classes.hard.q5." + bookUc;
        String bookcaseClassString = "oop.programs_with_multiple_classes.hard.q5." + bookcaseUc;
        book = new ObjectTest(bookClassString);
        bookcase = new ObjectTest(bookcaseClassString);
    }

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral(bookUc + " 1: " + bookUc + "\\{" + year + "="),
                new IntegerLiteral(2005),
                new StringLiteral(", " + type + "='"),
                new StringLiteral("LeatherBound"),
                new StringLiteral("'\\}"),
                new NewLine(),
                new StringLiteral(bookUc + " 2: " + bookUc + "\\{" + year + "="),
                new IntegerLiteral(2018),
                new StringLiteral(", " + type + "='"),
                new StringLiteral("EPub"),
                new StringLiteral("'\\}"),
                new NewLine(),
                new StringLiteral(bookcaseUc + ": " + bookcaseUc + "\\{" + sizeCapacity + "="),
                new IntegerLiteral(20),
                new StringLiteral(", b1=" + bookUc + "\\{" + year + "="),
                new IntegerLiteral(2005),
                new StringLiteral(", " + type + "='"),
                new StringLiteral("LeatherBound"),
                new StringLiteral("'\\}\\}"),
                new NewLine(),
                new StringLiteral("Years since Book 1 was published: "),
                new IntegerLiteral(Year.now().getValue() - 2005),
                new NewLine(),
                new StringLiteral("Years since Book 2 was published: "),
                new IntegerLiteral(Year.now().getValue() - 2018),
        };
    }

    public void runMain() {
        TestFurniture.main(new String[0]);
    }

    /**
     * Book tests
     **/
    @Test
    public void bookClassHasCorrectFields() {
        String missingFieldMessage = "Your " + bookLc + " class is missing a required field.";
        String incorrectFieldModifierMessage = "A field in your " + bookLc + " class has an incorrect modifier.";
        assertTrue(book.hasField(year, int.class), missingFieldMessage);
        assertTrue(book.hasField(type, String.class), missingFieldMessage);
        assertTrue(book.hasModifier(year, "private"), incorrectFieldModifierMessage);
        assertTrue(book.hasModifier(type, "private"), incorrectFieldModifierMessage);
    }

    @Test
    public void bookClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + bookLc + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + bookLc + " class does not have the correct modifiers.";
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
    public void correctBookToStringMethod(int year, String type) throws Throwable {
        Object[][] arguments = new Object[][]{
                {year, int.class},
                {type, String.class}
        };
        Object bookInstance = book.createInstance(arguments);
        Object toStringOutput = book.callMethod("toString", bookInstance);
        String toStringExpected = bookUc + "{" + this.year + "=" + year + ", " + this.type + "='" + type + "'}";
        String incorrectToString = "Your " + bookLc + " toString method does not return the correct String.";
        _assertEquals(toStringExpected, toStringOutput, incorrectToString);
    }

    /**
     * Bookcase tests
     **/
    @Test
    public void bookcaseClassHasCorrectFields() {
        String missingFieldMessage = "Your " + bookcaseLc + " class is missing a required field.";
        String incorrectFieldModifierMessage = "A field in your " + bookcaseLc + " class has an incorrect modifier.";
        assertTrue(bookcase.hasField(sizeCapacity, int.class), missingFieldMessage);
        assertTrue(bookcase.hasModifier(sizeCapacity, "private"), incorrectFieldModifierMessage);
    }

    @Test
    public void bookcaseClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + bookcaseLc + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + bookcaseLc + " class does not have the correct modifiers.";
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

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void correctBookcaseToStringMethod(int sizeCapacity, Book b1) throws Throwable {
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class},
                {b1, Book.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);
        Object toStringOutput = bookcase.callMethod("toString", bookcaseInstance);
        String toStringExpected = bookcaseUc + "{" + this.sizeCapacity + "=" + sizeCapacity + ", " + this.b1 + "=" + b1.toString() + "}";
        String incorrectToString = "Your " + bookcaseLc + " toString method does not return the correct String.";
        _assertEquals(toStringExpected, toStringOutput, incorrectToString);
    }

}


