package oop.programs_with_multiple_classes.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private ObjectTest circus;
    private ObjectTest member;

    private final String numMembers = "numMembers";
    private final String title = "title";

    private final String memberLc = "member";
    private final String memberUc = "Member";
    private final String circusLc = "circus";
    private final String circusUc = "Circus";

    @BeforeEach
    public void Setup() {
        String circusClassString = "oop.programs_with_multiple_classes.hard.q1." + circusUc;
        String memberClassString = "oop.programs_with_multiple_classes.hard.q1." + memberUc;
        circus = new ObjectTest(circusClassString);
        member = new ObjectTest(memberClassString);
    }

    @Test
    public void memberClassHasCorrectAttribute() {
        String missingAttributeMessage = "Your " + memberLc + " is missing the following required attribute: " + title + ".";
        String incorrectAttributeModifierMessage = "The " + title + " attribute in your " + memberLc + "  has an incorrect modifier.";
        String incorrectAttributeTypeMessage = "The " + title + " attribute in your " + memberLc + " class has the wrong type.";

        assertTrue(member.hasField(title), missingAttributeMessage);
        assertTrue(member.hasField(title, String.class), incorrectAttributeTypeMessage);
        assertTrue(member.hasModifier(title, "private"), incorrectAttributeModifierMessage);
    }

    @Test
    public void memberClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + memberLc + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + memberLc + " class does not have the correct modifiers.";
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
        _assertEquals(title, member.getFieldValue(memberInstance, this.title),
                "Your member constructor does not correctly initialize the " + this.title + " attribute.");
    }

    @Test
    public void circusClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your " + circusLc + " class is missing the following required attribute: " + numMembers + ".";
        String incorrectAttributeModifierMessage = "The " + numMembers + " attribute in your " + circusLc + " class has an incorrect modifier.";
        String incorrectAttributeTypeMessage = "The " + numMembers + " attribute in your " + circusLc + " class has the wrong type.";

        assertTrue(circus.hasField(numMembers), missingAttributeMessage);
        assertTrue(circus.hasField(numMembers, int.class), incorrectAttributeTypeMessage);
        assertTrue(circus.hasModifier(numMembers, "private"), incorrectAttributeModifierMessage);
    }

    @Test
    public void circusClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + circusLc + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + circusLc + "  class does not have the correct modifiers.";
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
        _assertEquals(numMembers, circus.getFieldValue(circusInstance, this.numMembers),
                "Your " + circusLc + " constructor does not correctly initialize the " + this.numMembers + " attribute.");
    }
}
