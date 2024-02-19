package oop.programs_with_multiple_classes.hard.q3;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    // Java

    private ObjectTest book;
    private ObjectTest bookcase;

    private final String bookClass = "Book";
    private final String bookcaseClass = "Bookcase";
    private final String count = "count";
    private final String type = "type";
    private final String sizeCapacity = "sizeCapacity";
    private final String bookMethodName = "incrementBookCount";
    private final String bookcaseMethodName = "validate";
    private final int incrementAmount = 1;
    private final String errorMessage = "Error\\! Size capacity cannot be negative\\.";

    @BeforeEach
    public void Setup() {
        String bookClassString = "oop.programs_with_multiple_classes.hard.q3." + bookClass;
        String bookcaseClassString = "oop.programs_with_multiple_classes.hard.q3." + bookcaseClass;
        book = new ObjectTest(bookClassString);
        bookcase = new ObjectTest(bookcaseClassString);
    }

    /**
     * Book tests
     **/
    @Test
    public void bookClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your " + bookClass + " class is missing the following required attribute: %s.";
        String incorrectAttributeTypeMessage = "The %s attribute in your " + bookClass + " class has the wrong type.";
        String incorrectAttributeModifierMessage = "The %s attribute in your " + bookClass + " class has an incorrect modifier.";

        assertTrue(book.hasField(count), missingAttributeMessage);
        assertTrue(book.hasField(count, int.class), incorrectAttributeTypeMessage);
        assertTrue(book.hasModifier(count, "private"), incorrectAttributeModifierMessage);

        assertTrue(book.hasField(type), missingAttributeMessage);
        assertTrue(book.hasField(type, String.class), incorrectAttributeTypeMessage);
        assertTrue(book.hasModifier(type, "private"), incorrectAttributeModifierMessage);
    }

    @Test
    public void bookClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + bookClass + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + bookClass + " class does not have the correct modifiers.";
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

    @Tag("dependent1")
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

    @Tag("dependency1")
    @ParameterizedTest
    @MethodSource("bookInputProvider")
    public void bookHasCorrectIncrementBookCountMethod(int count, String type) throws Throwable {
        Object[][] arguments = new Object[][]{
                {count, int.class},
                {type, String.class}
        };
        Object bookInstance = book.createInstance(arguments);
        String incorrectIncrementBookCount = "Your %s method does not correctly increment and return the value of the %s attribute.";

        assertTrue(book.hasMethod(bookMethodName, new Class[]{}),
                String.format("Your %s class is missing the method %s.", bookClass, bookMethodName));
        assertTrue(book.hasMethod(bookMethodName, new Class[]{}, int.class),
                String.format("Your %s class %s method does not have the correct return type.", bookClass, bookMethodName));
        assertTrue(book.hasMethod(bookMethodName, new Class[]{}, int.class, new String[]{"public"}),
                String.format("Your %s class %s method does not have the correct visibility modifier.", bookClass, bookMethodName));

        Object output = book.callMethod(bookMethodName, new String[]{"public"}, bookInstance);
        assertEquals(count + incrementAmount, output,
                String.format(incorrectIncrementBookCount, bookMethodName, this.count));
        assertEquals(count + incrementAmount, book.getFieldValue(bookInstance, "count"),
                String.format(incorrectIncrementBookCount, bookMethodName, this.count));
    }

    /**
     * Bookcase tests
     **/
    @Test
    public void bookcaseClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your " + bookcaseClass + " class is missing the following required attribute: " + sizeCapacity + ".";
        String incorrectAttributeTypeMessage = "The %s attribute in your " + bookClass + " class has the wrong type.";
        String incorrectAttributeModifierMessage = "An attribute in your " + bookcaseClass + " class has an incorrect modifier.";

        assertTrue(bookcase.hasField(sizeCapacity), missingAttributeMessage);
        assertTrue(bookcase.hasField(sizeCapacity, int.class), incorrectAttributeTypeMessage);
        assertTrue(bookcase.hasModifier(sizeCapacity, "private"), incorrectAttributeModifierMessage);
    }

    @Test
    public void bookcaseClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + bookcaseClass + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + bookcaseClass + " class does not have the correct modifiers.";
        Class<?>[] constructorClasses = new Class[]{
                int.class
        };
        assertTrue(bookcase.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(bookcase.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<Arguments> bookcaseInputProvider() {
        return Stream.of(
                Arguments.of(4, 4),
                Arguments.of(5, 5),
                Arguments.of(11111, 11111),
                Arguments.of(2, 2),
                Arguments.of(0, 0),
                Arguments.of(-3, 0),
                Arguments.of(-1, 0),
                Arguments.of(-8274, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void bookcaseConstructorInitializesPositiveValuesCorrectly(int sizeCapacity, int result) throws Throwable {
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);
        _assertEquals(result, bookcase.getFieldValue(bookcaseInstance, this.sizeCapacity),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + this.sizeCapacity + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void bookcaseCorrectCheckValidityMethod(int sizeCapacity, int result) throws Throwable {
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);

        if (sizeCapacity != result) {
            Object b = bookcase.callMethod(bookcaseMethodName, arguments, new String[]{"public"}, bookcaseInstance, new Clause[]{
                    new StringLiteral(errorMessage),
                    new Optional(new StringLiteral(" "))
            }, "Your " + bookcaseClass + " class " + bookcaseMethodName + " method does not correctly print the error message and return a value.");
            assertFalse((boolean)b);
        }
        else {
            Object b = bookcase.callMethod(bookcaseMethodName, arguments, new String[]{"public"}, bookcaseInstance, new Clause[]{},
                    "Your " + bookcaseClass + " class " + bookcaseMethodName + " method does not correctly print the error message and return a value.");
            assertTrue((boolean)b);
        }
    }
}
