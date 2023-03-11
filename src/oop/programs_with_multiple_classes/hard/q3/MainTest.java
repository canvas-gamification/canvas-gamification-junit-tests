package oop.programs_with_multiple_classes.hard.q3;

import global.BaseTest;
import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    private ObjectTest book;
    private ObjectTest bookcase;

    private final String bookLc = "book";
    private final String bookUc = "Book";
    private final String bookcaseLc = "bookcase";
    private final String bookcaseUc = "Bookcase";
    private final String count = "count";
    private final String type = "type";
    private String sizeCapacity = "sizeCapacity";

    @BeforeEach
    public void Setup() {
        String bookClassString = "oop.programs_with_multiple_classes.hard.q3." + bookUc;
        String bookcaseClassString = "oop.programs_with_multiple_classes.hard.q3." + bookcaseUc;
        book = new ObjectTest(bookClassString);
        bookcase = new ObjectTest(bookcaseClassString);
    }

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral(bookUc + "1: " + bookUc + "\\{" + count + "="),
                new IntegerLiteral(1),
                new StringLiteral(", " + type + "="),
                new StringLiteral("'HardCover'"),
                new StringLiteral("\\}"),
                new NewLine(),
                new StringLiteral(bookUc + "2: " + bookUc + "\\{" + count + "="),
                new IntegerLiteral(1),
                new StringLiteral(", " + type + "="),
                new StringLiteral("'SoftCover'"),
                new StringLiteral("\\}"),
                new NewLine(),
                new StringLiteral(bookcaseUc + ": " + bookcaseUc + "\\{" + sizeCapacity + "='"),
                new IntegerLiteral(20),
                new StringLiteral("'\\}"),
        };
    }

    public void runMain() {
        TestFurniture.main(new String[0]);
    }

    /*
    Book 1: Book{count=1, type='HardCover'}
    Book 2: Book{count=1, type='SoftCover'}
    Bookcase: Bookcase{sizeCapacity=20}
    */
    @Test
    public void bookClassHasCorrectFields() {
        String missingFieldMessage = "Your " + bookLc + " class is missing a required field.";
        String incorrectFieldModifierMessage = "A field in your " + bookLc + " class has an incorrect modifier.";
        assertTrue(book.hasField(count, int.class), missingFieldMessage);
        assertTrue(book.hasField(type, String.class), missingFieldMessage);
        assertTrue(book.hasModifier(count, "private"), incorrectFieldModifierMessage);
        assertTrue(book.hasModifier(type, "private"), incorrectFieldModifierMessage);
    }

}
