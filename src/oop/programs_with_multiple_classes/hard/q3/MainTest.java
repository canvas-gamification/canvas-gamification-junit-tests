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

import static global.tools.CustomAssertions._assertArrayEquals;
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
    private final String shelf = "shelf";
    private final String bookMethodName = "incrementBookCount";
    private final String bookcaseMethodName = "validate";
    private final String bookcaseMethodName2 = "addBook";
    private final String bookcaseMethodName3 = "removeBook";
    private final int incrementAmount = 1;
    private final String errorMessage = "Error\\! Size capacity cannot be negative\\.";
    private final String addBookError = "The Bookshelf is full\\.";
    private final String removeBookError = "There is nothing here\\.";

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
        String missingAttributeMessage = "Your " + bookClass + " class is missing the %s attribute.";
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

        //Checking if it works with multiple method calls
        output = book.callMethod(bookMethodName, new String[]{"public"}, bookInstance);
        assertEquals(count + incrementAmount + 1, output,
                String.format(incorrectIncrementBookCount, bookMethodName, this.count));
        assertEquals(count + incrementAmount + 1, book.getFieldValue(bookInstance, "count"),
                String.format(incorrectIncrementBookCount, bookMethodName, this.count));
    }

    /**
     * Bookcase tests
     **/
    @Test
    public void bookcaseClassHasCorrectAttributes() throws Throwable {
        String missingAttributeMessage = "Your " + bookcaseClass + " class is missing the %s attribute.";
        String incorrectAttributeTypeMessage = "The %s attribute in your " + bookClass + " class has the wrong type.";
        String incorrectAttributeModifierMessage = "The %s attribute in your " + bookcaseClass + " class has an incorrect modifier.";

        assertTrue(bookcase.hasField(sizeCapacity), String.format(missingAttributeMessage, sizeCapacity));
        assertTrue(bookcase.hasField(sizeCapacity, int.class), String.format(incorrectAttributeTypeMessage, sizeCapacity));
        assertTrue(bookcase.hasModifier(sizeCapacity, "private"), String.format(incorrectAttributeModifierMessage, sizeCapacity));

        assertTrue(bookcase.hasField(shelf), String.format(missingAttributeMessage, shelf));
        assertTrue(bookcase.hasField(shelf, book.getObjectArrayClass()), String.format(incorrectAttributeTypeMessage, shelf));
        assertTrue(bookcase.hasModifier(shelf, "private"), String.format(incorrectAttributeModifierMessage, shelf));
    }

    @Test
    public void bookcaseClassHasCorrectConstructors() throws Throwable {
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
                Arguments.of(1, 1),
                Arguments.of(0, 0),
                Arguments.of(-3, 0),
                Arguments.of(-1, 0),
                Arguments.of(-8274, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void bookcaseConstructorInitializesValuesCorrectly(int sizeCapacity, int result) throws Throwable {
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);
        _assertEquals(result, bookcase.getFieldValue(bookcaseInstance, this.sizeCapacity),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + this.sizeCapacity + " attribute.");

        _assertArrayEquals(book.createArray(result), bookcase.getFieldValue(bookcaseInstance, shelf),
                "Your " + bookcaseClass + " constructor does not correctly initialize the " + shelf + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("bookcaseInputProvider")
    public void bookcaseCorrectValidateMethod(int sizeCapacity, int result) throws Throwable {
        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);

        assertTrue(bookcase.hasMethod(bookcaseMethodName, new Class[]{int.class}),
                String.format("Your %s class is missing the method %s.", bookcaseClass, bookcaseMethodName));
        assertTrue(bookcase.hasMethod(bookcaseMethodName, new Class[]{int.class}, boolean.class),
                String.format("Your %s class %s method does not have the correct return type.", bookcaseClass, bookcaseMethodName));
        assertTrue(bookcase.hasMethod(bookcaseMethodName, new Class[]{int.class}, boolean.class, new String[]{"public"}),
                String.format("Your %s class %s method does not have the correct visibility modifier.", bookcaseClass, bookcaseMethodName));

        if (sizeCapacity != result) {
            Object b = bookcase.callMethod(bookcaseMethodName, arguments, new String[]{"public"}, bookcaseInstance, new Clause[]{
                    new StringLiteral(errorMessage),
                    new Optional(new StringLiteral(" "))
            }, "Your " + bookcaseClass + " class " + bookcaseMethodName + " method does not correctly print the error message and return a value.");
            assertFalse((boolean) b);
        } else {
            Object b = bookcase.callMethod(bookcaseMethodName, arguments, new String[]{"public"}, bookcaseInstance, new Clause[]{},
                    "Your " + bookcaseClass + " class " + bookcaseMethodName + " method does not correctly print the error message and return a value.");
            assertTrue((boolean) b);
        }
    }

    private static Stream<Arguments> addBooksInputProvider() {
        return Stream.of(
                Arguments.of(5, new int[]{0, 0, 0, 0, 0}),
                Arguments.of(3, new int[]{0, 1, 0, 0, 0}),
                Arguments.of(6, new int[]{1, 1, 1, 1, 1, 1}),
                Arguments.of(4, new int[]{1, 1, 1, 0}),
                Arguments.of(4, new int[]{1, 1, 0, 1}),
                Arguments.of(4, new int[]{1, 0, 0, 0}),
                Arguments.of(4, new int[]{0, 0, 0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("addBooksInputProvider")
    public void bookcaseCorrectAddBookMethod(int sizeCapacity, int[] bookPlacement) throws Throwable {
        assertTrue(bookcase.hasMethod(bookcaseMethodName2, new Class[]{book.getObjectClass()}),
                String.format("Your %s class is missing the method %s.", bookcaseClass, bookcaseMethodName2));
        assertTrue(bookcase.hasMethod(bookcaseMethodName2, new Class[]{book.getObjectClass()}, void.class),
                String.format("Your %s class %s method does not have the correct return type.", bookcaseClass, bookcaseMethodName2));
        assertTrue(bookcase.hasMethod(bookcaseMethodName2, new Class[]{book.getObjectClass()}, void.class, new String[]{"public"}),
                String.format("Your %s class %s method does not have the correct visibility modifier.", bookcaseClass, bookcaseMethodName2));

        Object[] startingConfig = (Object[]) book.createArray(sizeCapacity);
        Object[] endingConfig = (Object[]) book.createArray(sizeCapacity);
        Object insert = book.createInstance(new Object[][]{{5, int.class}, {"fiction", String.class}});

        boolean firstZero = true;
        for (int x = 0; x < sizeCapacity; x++) {
            if (bookPlacement[x] == 1) {
                Object b = book.createInstance(new Object[][]{{1, int.class}, {"", String.class}});
                startingConfig[x] = b;
                endingConfig[x] = b;
            } else if (firstZero) {
                endingConfig[x] = insert;
                firstZero = false;
            }
        }

        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);
        bookcase.setFieldValue(bookcaseInstance, startingConfig, shelf);

        if (firstZero) {
            bookcase.callMethod(bookcaseMethodName2, new Object[][]{{insert, book.getObjectClass()}}, new String[]{"public"}, bookcaseInstance, new Clause[]{
                    new StringLiteral(addBookError),
                    new Optional(new StringLiteral(" "))
            }, "Your " + bookcaseMethodName2 + " method does not produce the correct error message when the " + bookcaseClass + " is full.");
        } else {
            bookcase.callMethod(bookcaseMethodName2, new Object[][]{{insert, book.getObjectClass()}}, new String[]{"public"}, bookcaseInstance);
        }

        _assertArrayEquals(endingConfig, startingConfig, "Your " + bookcaseMethodName2 + " does not correctly handle inserting a new " + bookClass + ".");
    }

    private static Stream<Arguments> removeBooksInputProvider() {
        return Stream.of(
                Arguments.of(4, new int[]{1, 1, 0, 0}, 0),
                Arguments.of(5, new int[]{1, 1, 0, 1, 0}, 3),
                Arguments.of(5, new int[]{1, 1, 1, 0, 1}, 3),
                Arguments.of(5, new int[]{1, 1, 1, 0, 1}, 4),
                Arguments.of(5, new int[]{1, 1, 1, 1, 0}, 4),
                Arguments.of(11, new int[]{1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("removeBooksInputProvider")
    public void bookcaseCorrectRemoveBookMethod(int sizeCapacity, int[] bookPlacement, int index) throws Throwable {
        assertTrue(bookcase.hasMethod(bookcaseMethodName3, new Class[]{int.class}),
                String.format("Your %s class is missing the method %s.", bookcaseClass, bookcaseMethodName3));
        assertTrue(bookcase.hasMethod(bookcaseMethodName3, new Class[]{int.class}, void.class),
                String.format("Your %s class %s method does not have the correct return type.", bookcaseClass, bookcaseMethodName3));
        assertTrue(bookcase.hasMethod(bookcaseMethodName3, new Class[]{int.class}, void.class, new String[]{"public"}),
                String.format("Your %s class %s method does not have the correct visibility modifier.", bookcaseClass, bookcaseMethodName3));

        Object[] startingConfig = (Object[]) book.createArray(sizeCapacity);
        Object[] endingConfig = (Object[]) book.createArray(sizeCapacity);
        for (int x = 0; x < sizeCapacity; x++) {
            if (bookPlacement[x] == 1) {
                Object b = book.createInstance(new Object[][]{{1, int.class}, {"", String.class}});
                startingConfig[x] = b;
                endingConfig[x] = b;
            }
            if (x == index) {
                endingConfig[x] = null;
            }
        }

        Object[][] arguments = new Object[][]{
                {sizeCapacity, int.class}
        };
        Object bookcaseInstance = bookcase.createInstance(arguments);
        bookcase.setFieldValue(bookcaseInstance, startingConfig, shelf);

        if (startingConfig[index] == null) {
            bookcase.callMethod(bookcaseMethodName3, new Object[][]{{index, int.class}}, new String[]{"public"}, bookcaseInstance, new Clause[]{
                    new StringLiteral(removeBookError),
                    new Optional(new StringLiteral(" "))
            }, "Your " + bookcaseMethodName3 + " method does not produce the correct error message when the " + bookcaseClass + " index is already empty.");
        } else {
            bookcase.callMethod(bookcaseMethodName3, new Object[][]{{index, int.class}}, new String[]{"public"}, bookcaseInstance);
        }

        _assertArrayEquals(endingConfig, startingConfig, "Your " + bookcaseMethodName3 + " does not correctly handle removing a " + bookClass + ".");
    }
}
