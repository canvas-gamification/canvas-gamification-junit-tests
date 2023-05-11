package oop.user_defined_classes.hard.q7;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
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
    private final String testClassName = "Course";
    private final String stringAttributeName1 = "topic";
    private final String intAttributeName1 = "difficulty";
    private final String methodName = "determineDifficulty";
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String testClassString = "oop.user_defined_classes.hard.q7." + testClassName;
        classInstance = new ObjectTest(testClassString);
    }

    @Test
    public void courseClassHasCorrectFields() {
        String missingFieldMessage = "Your " + testClassName + " is missing a required field";
        String incorrectModifierMessage = "One of your fields in the " + testClassName +
                " class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(stringAttributeName1, String.class),
                missingFieldMessage);
        assertTrue(classInstance.hasModifier(stringAttributeName1, "private"),
                incorrectModifierMessage);
        assertTrue(classInstance.hasField(intAttributeName1, int.class),
                missingFieldMessage);
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                incorrectModifierMessage);
    }

    @Test
    public void courseClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments = {
                String.class, int.class
        };
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Intro to Computer Science", 1),
                Arguments.of("Editing and Publishing", 4),
                Arguments.of("Advanced Theoretics of Quantum Mechanics and Their Application to Fish Cultivation", 9001),
                Arguments.of("Master's Thesis", 50),
                Arguments.of("Basic Life Skillz", 0),
                Arguments.of("Still Life Painting", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void courseConstructorInitializesFieldsCorrectly(String attribute1, int attribute2) throws Throwable {
        Object[][] arguments = {
                {attribute1, String.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectFieldInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize the object.";
        _assertEquals(attribute1, classInstance.getFieldValue(instance, stringAttributeName1),
                incorrectFieldInstantiationMessage);
        _assertEquals(attribute2, classInstance.getFieldValue(instance, intAttributeName1),
                incorrectFieldInstantiationMessage);
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of("Artificial Intelligence 3", 4, 3, "Artificial Intelligence 3 is a difficult course"),
                Arguments.of("Matrix Algebra", 2, 10, "Matrix Algebra is not a difficult course"),
                Arguments.of("Renaissance History", 1, 1, "Renaissance History is a difficult course"),
                Arguments.of("Recreating Jurassic Park for Fun and Profit", 800, 3, "Recreating Jurassic Park for Fun and Profit is a difficult course"),
                Arguments.of("Clown Studies", 5, 1000, "Clown Studies is not a difficult course"),
                Arguments.of("Nepotism", -1, 0, "Nepotism is not a difficult course"),
                Arguments.of("Learn to Blink", -50, -25, "Learn to Blink is not a difficult course")
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctDetermineDifficultyMethod(String attribute1, int attribute2, int dif, String mssg) throws Throwable {
        Object[][] arguments = {
                {attribute1, String.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName, new Class[]{int.class}),
                "Your " + testClassName + " class is missing the method " + methodName + ".");
        classInstance.callMethod(methodName, new Object[][]{{dif, int.class}}, null, instance, new Clause[]{
                new StringLiteral(mssg)
        }, "Your " + methodName + " method does not produce the correct output.");
    }
}
