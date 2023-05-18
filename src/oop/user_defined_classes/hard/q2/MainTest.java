package oop.user_defined_classes.hard.q2;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
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
    private final String testClassName = "DishWasher";
    private final String intAttributeName1 = "forks";
    private final String intAttributeName2 = "knives";
    private final String methodName = "loadDishWasher";
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String testClassString = "oop.user_defined_classes.hard.q2." + testClassName;
        classInstance = new ObjectTest(testClassString);
    }

    @Test
    public void dishWasherClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your " + testClassName + " is missing a required attribute";
        String incorrectModifierMessage = "One of your attributes in the " + testClassName +
                " class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(intAttributeName1, int.class),
                missingAttributeMessage);
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                incorrectModifierMessage);
        assertTrue(classInstance.hasField(intAttributeName2, int.class),
                missingAttributeMessage);
        assertTrue(classInstance.hasModifier(intAttributeName2, "private"),
                incorrectModifierMessage);
    }

    @Test
    public void dishWasherClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments= {
                int.class, int.class
        };
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(35, 12),
                Arguments.of(478273, 723662367)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void dishWasherConstructorInitializesAttributesCorrectly(int attribute1, int attribute2) throws Throwable{
        Object[][] arguments = {
                {attribute1, int.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize the object." ;
        _assertEquals(attribute1, classInstance.getFieldValue(instance, intAttributeName1),
                incorrectAttributeInstantiationMessage);
        _assertEquals(attribute2, classInstance.getFieldValue(instance, intAttributeName2),
                incorrectAttributeInstantiationMessage);
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(2, 3, 1, 1, 1, 2),
                Arguments.of(15, 33, 14, 15, 1, 18),
                Arguments.of(378, 32891, 378, 32891, 0, 0),
                Arguments.of(0, 0, 0, 0, 0, 0),
                Arguments.of(5, 10, 0, 1, 5, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctLoadDishWasherMethod(int attribute1, int attribute2, int remove1, int remove2, int remainder1, int remainder2) throws Throwable{
        Object[][] arguments = {
                {attribute1, int.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName, new Class[]{int.class, int.class}),
                "Your " + testClassName + " class is missing the method " + methodName + ".");
        classInstance.callMethod(
                methodName, new Object[][]{{remove1, int.class}, {remove2, int.class}}, null, instance, new Clause[]{
                        new IntegerLiteral(remainder1),
                        new StringLiteral(" " + intAttributeName1 + " are still clean"),
                        new NewLine(),
                        new IntegerLiteral(remainder2),
                        new StringLiteral(" " + intAttributeName2 + " are still clean")
                }, "Your " + methodName + " method does not print the correct messages."
                );
        _assertEquals(remainder1, classInstance.getFieldValue(instance, intAttributeName1),
                "Your " + methodName + " method does not correctly modify the " + intAttributeName1 + " attribute.");
        _assertEquals(remainder2, classInstance.getFieldValue(instance, intAttributeName2),
                "Your " + methodName + " method does not correctly modify the " + intAttributeName2 + " attribute.");
    }
}
