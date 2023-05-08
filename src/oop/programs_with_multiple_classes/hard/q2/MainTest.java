package oop.programs_with_multiple_classes.hard.q2;

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

    private ObjectTest person;
    private ObjectTest blanket;

    private final String height = "height";
    private final String size = "size";
    private final String threadCount = "threadCount";

    private final String personLc = "person";
    private final String personUc = "Person";
    private final String blanketLc = "blanket";
    private final String blanketUc = "Blanket";

    @BeforeEach
    public void Setup() {
        String personClassString = "oop.programs_with_multiple_classes.hard.q2." + personUc;
        String blanketClassString = "oop.programs_with_multiple_classes.hard.q2." + blanketUc;
        person = new ObjectTest(personClassString);
        blanket = new ObjectTest(blanketClassString);
    }

    /**
     * Person Tests
     **/
    @Test
    public void personClassHasCorrectFields() {
        String missingFieldMessage = "Your " + personLc + " class is missing a required field.";
        String incorrectFieldModifierMessage = "A field in your " + personLc + " class has the wrong visibility modifier.";
        assertTrue(person.hasField(height, double.class), missingFieldMessage);
        assertTrue(person.hasModifier(height, "private"), incorrectFieldModifierMessage);
    }

    @Test
    public void personClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + personLc + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + personLc + " class does not have the correct visibility modifier.";
        Class<?>[] constructorClasses = new Class[]{
                double.class
        };
        assertTrue(person.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(person.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<Double> personInputProvider() {
        return Stream.of(
                75.0,
                63.0,
                55.0,
                80.0
        );
    }

    @ParameterizedTest
    @MethodSource("personInputProvider")
    public void personConstructorInitializesValuesCorrectly(Double height) throws Throwable {
        Object[][] arguments = new Object[][]{
                {height, double.class}
        };
        Object personInstance = person.createInstance(arguments);
        _assertEquals(height, person.getFieldValue(personInstance, this.height),
                "Your " + personLc + " constructor does not correctly initialize the " + this.height + " field.");
    }

    /**
     * Blanket Tests
     **/
    @Test
    public void blanketClassHasCorrectFields() {
        String missingFieldMessage = "Your " + blanketLc + " class is missing a required field.";
        String incorrectFieldModifierMessage = "A field in your " + blanketLc + " class has the wrong visibility modifier.";
        assertTrue(blanket.hasField(size, String.class), missingFieldMessage);
        assertTrue(blanket.hasModifier(size, "private"), incorrectFieldModifierMessage);
        assertTrue(blanket.hasField(threadCount, int.class), missingFieldMessage);
        assertTrue(blanket.hasModifier(threadCount, "private"), incorrectFieldModifierMessage);
    }

    @Test
    public void blanketClassHasCorrectConstructors() {
        String missingConstructorMessage = "Your " + blanketLc + " class does not have a required constructor.";
        String incorrectConstructorModifierMessage =
                "One of the constructors in your " + blanketLc + " class does not have the correct visibility modifier.";
        Class<?>[] constructorClasses = new Class[]{
                String.class,
                int.class
        };
        assertTrue(blanket.hasConstructor(constructorClasses), missingConstructorMessage);
        assertTrue(blanket.hasModifier(constructorClasses, "public"), incorrectConstructorModifierMessage);
    }

    private static Stream<Arguments> blanketInputProvider() {
        return Stream.of(
                Arguments.of("Large", 1500),
                Arguments.of("Teensy", 500),
                Arguments.of("Very small", 700),
                Arguments.of("The right size", 2000),
                Arguments.of("Too big", 1750)
        );
    }

    @ParameterizedTest
    @MethodSource("blanketInputProvider")
    public void blanketConstructorInitializesValuesCorrectly(String size, int threadCount) throws Throwable {
        Object[][] arguments = new Object[][]{
                {size, String.class},
                {threadCount, int.class}
        };
        Object blanketInstance = blanket.createInstance(arguments);
        _assertEquals(size, blanket.getFieldValue(blanketInstance, this.size),
                "Your " + blanketLc + " constructor does not correctly initialize the " + this.size + " field.");
        _assertEquals(threadCount, blanket.getFieldValue(blanketInstance, this.threadCount),
                "Your " + blanketLc + " constructor does not correctly initialize the " + this.threadCount + " field.");
    }
}
