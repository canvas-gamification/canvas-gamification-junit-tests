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
import static org.junit.jupiter.api.Assertions.*;

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
    public void universityStudentClassHasCorrectAttributes() {
        String missingAttributeMessage =
                "The %s attribute could not be found in your %s class. Please make sure you have added it and that it is spelled correctly.";
        String wrongTypeMessage = "The %s attribute does not have the correct type.";
        String incorrectModifierMessage = "Your %s attribute in the %s class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(intAttributeName1),
                String.format(missingAttributeMessage, intAttributeName1, testClassName));
        assertTrue(classInstance.hasField(intAttributeName1, int.class), String.format(wrongTypeMessage, intAttributeName1));
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                String.format(incorrectModifierMessage, intAttributeName1, testClassName));
        assertTrue(classInstance.hasField(intAttributeName2),
                String.format(missingAttributeMessage, intAttributeName2, testClassName));
        assertTrue(classInstance.hasField(intAttributeName2, int.class), String.format(wrongTypeMessage, intAttributeName2));
        assertTrue(classInstance.hasModifier(intAttributeName2, "private"),
                String.format(incorrectModifierMessage, intAttributeName2, testClassName));
    }

    @Test
    public void universityStudentClassHasRequiredConstructor() {
        Class<?>[] arguments = {
                int.class, int.class
        };
        assertTrue(classInstance.hasConstructor(arguments),
                String.format("Your %s class is missing a required constructor.", testClassName));
        assertTrue(classInstance.hasConstructor(arguments, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", testClassName));
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
    public void universityStudentConstructorInitializesAttributesCorrectly(int attribute1, int attribute2) throws Throwable {
        Object[][] arguments = {
                {attribute1, int.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize the %s attribute.";
        _assertEquals(attribute1, classInstance.getFieldValue(instance, intAttributeName1),
                String.format(incorrectAttributeInstantiationMessage, intAttributeName1));
        _assertEquals(attribute2, classInstance.getFieldValue(instance, intAttributeName2),
                String.format(incorrectAttributeInstantiationMessage, intAttributeName2));
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
    public void correctWorkAllDayMethod(int attribute1, int attribute2, int stress) throws Throwable {
        Object[][] arguments = {
                {attribute1, int.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName, null),
                "Your " + testClassName + " class is missing the method " + methodName + ". Check that it is spelled correctly and has the correct parameters.");
        assertTrue(classInstance.hasMethod(methodName, null, Void.TYPE),
                "Your " + testClassName + " " + methodName + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(methodName, null, Void.TYPE, new String[]{"public"}),
                "Your " + testClassName + " " + methodName + " method does not have the correct visibility modifier.");
        classInstance.callMethod(methodName, instance, new Clause[]{
                new StringLiteral("Fatigue level is " + stress)
        }, "Your " + methodName + " method does not print the correct fatigue level.");
        assertEquals(0, (int) classInstance.getFieldValue(instance, intAttributeName2),
                intAttributeName2 + " should be zero after " + methodName + " is called.");
    }
}
