package oop.user_defined_classes.hard.q6;

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
    private final String testClassName = "UniversityStudent";
    private final String intAttributeName1 = "fatigueLevel";
    private final String intAttributeName2 = "workload";
    private final String methodName = "workAllDay";
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String testClassString = "oop.user_defined_classes.hard.q6." + testClassName;
        classInstance = new ObjectTest(testClassString);
    }

    @Test
    public void universityStudentClassHasCorrectFields() {
        String missingFieldMessage = "Your " + testClassName + " is missing a required field";
        String incorrectModifierMessage = "One of your fields in the " + testClassName +
                " class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(intAttributeName1, int.class),
                missingFieldMessage);
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                incorrectModifierMessage);
        assertTrue(classInstance.hasField(intAttributeName2, int.class),
                missingFieldMessage);
        assertTrue(classInstance.hasModifier(intAttributeName2, "private"),
                incorrectModifierMessage);
    }

    @Test
    public void universityStudentClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments = {
                int.class, int.class
        };
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(0, 2),
                Arguments.of(5, 1),
                Arguments.of(78, 190),
                Arguments.of(172, 172)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void universityStudentConstructorInitializesFieldsCorrectly(int attribute1, int attribute2) throws Throwable {
        Object[][] arguments = {
                {attribute1, int.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectFieldInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize the object.";
        _assertEquals(attribute1, classInstance.getFieldValue(instance, intAttributeName1),
                incorrectFieldInstantiationMessage);
        _assertEquals(attribute2, classInstance.getFieldValue(instance, intAttributeName2),
                incorrectFieldInstantiationMessage);
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(5, 0, 5),
                Arguments.of(0, 10, 10),
                Arguments.of(1, 7, 8),
                Arguments.of(578, 23, 601),
                Arguments.of(4783, 47382, 52165)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctWorkAllDayMethods(int attribute1, int attribute2, int stress) throws Throwable {
        Object[][] arguments = {
                {attribute1, int.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName, null),
                "Your " + testClassName + " class is missing the method " + methodName + ".");
        classInstance.callMethod(methodName, instance, new Clause[]{
                new StringLiteral("Fatigue level is " + stress)
        }, "Your " + methodName + " method does not produce the correct output.");
    }
}
