package oop.user_defined_classes.hard.q1;

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
    private final String testClassName = "Luggage";
    private final String intAttributeName1 = "numShirts";
    private final String intAttributeName2 = "numPants";
    private final String methodName = "sumItems";
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String testClassString = "oop.user_defined_classes.hard.q1." + testClassName;
        classInstance = new ObjectTest(testClassString);
    }

    @Test
    public void luggageClassHasCorrectFields() {
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
    public void luggageClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments= {
                int.class, int.class
        };
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(0, 2),
                Arguments.of(3838, 323984),
                Arguments.of(-343432, 222222222)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void luggageConstructorInitializesFieldsCorrectly(int attribute1, int attribute2) throws Throwable{
        Object[][] arguments = {
                {attribute1, int.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectFieldInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize one of the fields.";
        _assertEquals(attribute1, classInstance.getFieldValue(instance, intAttributeName1),
                incorrectFieldInstantiationMessage);
        _assertEquals(attribute2, classInstance.getFieldValue(instance, intAttributeName2),
                incorrectFieldInstantiationMessage);
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(4, 5, 9),
                Arguments.of(11, -11, 0),
                Arguments.of(2828, 121, 2949),
                Arguments.of(0, 0, 0),
                Arguments.of(39393939, 0, 39393939)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctSumItemsMethods(int attribute1, int attribute2, int sum) throws Throwable{
        Object[][] arguments = {
                {attribute1, int.class},
                {attribute2, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName, null),
                "Your " + testClassName + " class is missing the method " + methodName + ".");
        Object methodOutput = classInstance.callMethod(methodName, instance, null);
        _assertEquals(sum, methodOutput,
                "Your " + methodName + " method does not produce the correct output.");
    }
}
