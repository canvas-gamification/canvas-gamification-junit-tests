package oop.programs_with_multiple_classes.hard.q3;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    private final String count = "count";
    private final String type = "type";
    private final String sizeCapacity = "sizeCapacity";

    @BeforeEach
    public void Setup() {
        String bookClassString = "oop.programs_with_multiple_classes.hard.q3." + bookUc;
        String bookcaseClassString = "oop.programs_with_multiple_classes.hard.q3." + bookcaseUc;
        book = new ObjectTest(bookClassString);
        bookcase = new ObjectTest(bookcaseClassString);
    }

    /**
     * Book tests
     **/
    @Test
    public void bookClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your " + bookLc + " class is missing the following required attribute: %s.";
        String incorrectAttributeTypeMessage = "The %s attribute in your " + bookLc + " class has the wrong type.";
        String incorrectAttributeModifierMessage = "The %s attribute in your " + bookLc + " class has an incorrect modifier.";

        assertTrue(book.hasField(count), missingAttributeMessage);
        assertTrue(book.hasField(count, int.class), incorrectAttributeTypeMessage);
        assertTrue(book.hasModifier(count, "private"), incorrectAttributeModifierMessage);

        assertTrue(book.hasField(type), missingAttributeMessage);
        assertTrue(book.hasField(type, String.class), incorrectAttributeTypeMessage);
        assertTrue(book.hasModifier(type, "private"), incorrectAttributeModifierMessage);
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
    public void bookConstructorInitializesValuesCorrectly(int count, String type) throws Throwable {
        Object[][] arguments = new Object[][]{
                {count, int.class},
                {type, String.class}
        };
        Object bookInstance = book.createInstance(arguments);
        _assertEquals(count, book.getFieldValue(bookInstance, this.count),
                "Your " + book + " constructor does not correctly initialize the " + this.count + " attribute.");
        _assertEquals(type, book.getFieldValue(bookInstance, this.type),
                "Your " + book + " constructor does not correctly initialize the " + this.type + " attribute.");
    }

    /**
     * Bookcase tests
     **/
    @Test
    public void bookcaseClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your " + bookcaseLc + " class is missing the following required attribute: " + sizeCapacity + ".";
        String incorrectAttributeTypeMessage = "The %s attribute in your " + bookLc + " class has the wrong type.";
        String incorrectAttributeModifierMessage = "An attribute in your " + bookcaseLc + " class has an incorrect modifier.";

        assertTrue(bookcase.hasField(sizeCapacity), missingAttributeMessage);
        assertTrue(bookcase.hasField(sizeCapacity, int.class), incorrectAttributeTypeMessage);
        assertTrue(bookcase.hasModifier(sizeCapacity, "private"), incorrectAttributeModifierMessage);
    }

    @Test
    public void bookcaseClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + bookcaseLc + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + bookcaseLc + " class does not have the correct modifiers.";
        Class<?>[] constructorClasses = new Class[]{
                int.class
        };
        assertTrue(bookcase.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(bookcase.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<Integer> bookcaseInputProvider() {
        return Stream.of(
                4, 5, 6, 11111, 2, 0
        );
    }

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void bookcaseConstructorInitializesValuesCorrectly(int sizeCapacity) throws Throwable {
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);
        _assertEquals(sizeCapacity, bookcase.getFieldValue(bookcaseInstance, this.sizeCapacity),
                "Your " + bookcaseLc + " constructor does not correctly initialize the " + this.sizeCapacity + " attribute.");
    }
}
