package oop.programs_with_multiple_classes.hard.q1;

import global.BaseTest;
import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    private ObjectTest circus;
    private ObjectTest member;

    @BeforeEach
    public void Setup() {
        String circusClassString = "oop.programs_with_multiple_classes.hard.q1.Circus";
        String memberClassString = "oop.programs_with_multiple_classes.hard.q1.Member";
        circus = new ObjectTest(circusClassString);
        member = new ObjectTest(memberClassString);
    }

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Circus: Circus\\{numMembers="),
                new IntegerLiteral(100),
                new StringLiteral("\\}"),
                new NewLine(),
                new StringLiteral("Member 1: Member\\{title='"),
                new StringLiteral("Juggler"),
                new StringLiteral("'\\}"),
                new NewLine(),
                new StringLiteral("Member 2: Member\\{title='"),
                new StringLiteral("Tightrope Walker"),
                new StringLiteral("'\\}"),
        };
    }

    public void runMain() {
        TestGroup.main(new String[0]);
    }

    @Test
    public void memberClassHasCorrectFields() {
        String missingFieldMessage = "Your member class is missing a required field.";
        String incorrectFieldModifierMessage = "A field in your member class has an incorrect modifier.";
        assertTrue(member.hasField("title", String.class), missingFieldMessage);
        assertTrue(member.hasModifier("title", "private"), incorrectFieldModifierMessage);
    }

    @Test
    public void memberClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your member class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your member class does not have the correct modifiers.";
        Class<?>[] constructorClasses = new Class[]{
                String.class
        };
        assertTrue(member.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(member.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<String> memberInputProvider() {
        return Stream.of(
                "Hello",
                "How are ya",
                "This is a title",
                "Janitor"
        );
    }

    @ParameterizedTest
    @MethodSource("memberInputProvider")
    public void memberConstructorInitializesValuesCorrectly(String title) throws Throwable {
        Object[][] arguments = new Object[][]{
                {title, String.class}
        };
        Object memberInstance = member.createInstance(arguments);
        _assertEquals(title, member.getFieldValue(memberInstance, "title"),
                "Your member constructor does not correctly initialize the title field.");
    }

    @ParameterizedTest
    @MethodSource("memberInputProvider")
    public void correctMemberToStringMethod(String title) throws Throwable {
        Object[][] arguments = new Object[][]{
                {title, String.class}
        };
        Object memberInstance = member.createInstance(arguments);
        Object toStringOutput = member.callMethod("toString", memberInstance);
        String toStringExpected = "Member{title='" + title + "'}";
        String incorrectToString = "Your member toString method does not return the correct String.";
        _assertEquals(toStringExpected, toStringOutput, incorrectToString);
    }

    @Test
    public void circusClassHasCorrectFields() {
        String missingFieldMessage = "Your circus class is missing a required field.";
        String incorrectFieldModifierMessage = "A field in your circus class has an incorrect modifier.";
        assertTrue(circus.hasField("numMembers", int.class), missingFieldMessage);
        assertTrue(circus.hasModifier("numMembers", "private"), incorrectFieldModifierMessage);
    }

    @Test
    public void circusClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your circus class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your circus class does not have the correct modifiers.";
        Class<?>[] constructorClasses = new Class[]{
                int.class
        };
        assertTrue(circus.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(circus.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<Integer> circusInputProvider() {
        return Stream.of(
                4, 5, 6, 11111, 2, 0
        );
    }

    @ParameterizedTest
    @MethodSource("circusInputProvider")
    public void circusConstructorInitializesValuesCorrectly(int numMembers) throws Throwable {
        Object[][] arguments = new Object[][]{
                {numMembers, int.class}
        };
        Object circusInstance = circus.createInstance(arguments);
        _assertEquals(numMembers, circus.getFieldValue(circusInstance, "numMembers"),
                "Your circus constructor does not correctly initialize the numMembers field.");
    }

    @ParameterizedTest
    @MethodSource("circusInputProvider")
    public void correctCircusToStringMethod(int numMembers) throws Throwable {
        Object[][] arguments = new Object[][]{
                {numMembers, int.class}
        };
        Object circusInstance = circus.createInstance(arguments);
        Object toStringOutput = circus.callMethod("toString", circusInstance);
        String toStringExpected = "Circus{numMembers=" + numMembers + "}";
        String incorrectToString = "Your circus toString method does not return the correct String.";
        _assertEquals(toStringExpected, toStringOutput, incorrectToString);
    }
}
