package oop.user_defined_classes.hard.q7;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
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
    public void courseClassHasCorrectAttributes() {
        String missingAttributeMessage =
                "The %s attribute could not be found in your %s class. Please make sure you have added it, it is spelled correctly, and it is of the correct type";
        String incorrectModifierMessage = "Your %s attribute in the %s class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(stringAttributeName1, String.class),
                String.format(missingAttributeMessage, stringAttributeName1, testClassName));
        assertTrue(classInstance.hasModifier(stringAttributeName1, "private"),
                String.format(incorrectModifierMessage, stringAttributeName1, testClassName));
        assertTrue(classInstance.hasField(intAttributeName1, int.class),
                String.format(missingAttributeMessage, intAttributeName1, testClassName));
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                String.format(incorrectModifierMessage, intAttributeName1, testClassName));
    }

    @Test
    public void courseClassHasRequiredConstructor() {
        Class<?>[] arguments = {
                String.class, int.class
        };
        assertTrue(classInstance.hasConstructor(arguments),
                String.format("Your %s class is missing a required constructor.", testClassName));
        assertTrue(classInstance.hasConstructor(arguments, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", testClassName));
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
    public void courseConstructorInitializesAttributesCorrectly(String attribute1, int attribute2) throws Throwable {
        Object[][] arguments = {
                {attribute1, String.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize the object.";
        _assertEquals(attribute1, classInstance.getFieldValue(instance, stringAttributeName1),
                incorrectAttributeInstantiationMessage);
        _assertEquals(attribute2, classInstance.getFieldValue(instance, intAttributeName1),
                incorrectAttributeInstantiationMessage);
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
        assertTrue(classInstance.hasMethod(methodName, new Class[]{int.class}, Void.TYPE, new String[]{"public"}),
                "Your " + testClassName + " class is missing the method " + methodName + " or it does not have the correct return type or visibility modifier.");
        classInstance.callMethod(methodName, new Object[][]{{dif, int.class}}, null, instance, new Clause[]{
                new StringLiteral(mssg),
                new Optional(new StringLiteral(" "))
        }, "Your " + methodName + " method does not produce the correct output.");
    }
}
