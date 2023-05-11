package oop.user_defined_classes.hard.q5;

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
    private final String testClassName = "Phone";
    private final String doubleAttributeName1 = "width";
    private final String doubleAttributeName2 = "height";
    private final String methodName = "calcScreenSize";
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String testClassString = "oop.user_defined_classes.hard.q5." + testClassName;
        classInstance = new ObjectTest(testClassString);
    }

    @Test
    public void phoneClassHasCorrectFields() {
        String missingFieldMessage = "Your " + testClassName + " is missing a required field";
        String incorrectModifierMessage = "One of your fields in the " + testClassName +
                " class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(doubleAttributeName1, double.class),
                missingFieldMessage);
        assertTrue(classInstance.hasModifier(doubleAttributeName1, "private"),
                incorrectModifierMessage);
        assertTrue(classInstance.hasField(doubleAttributeName2, double.class),
                missingFieldMessage);
        assertTrue(classInstance.hasModifier(doubleAttributeName2, "private"),
                incorrectModifierMessage);
    }

    @Test
    public void luggageClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments = {
                double.class, double.class
        };
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(0.0, 1.2),
                Arguments.of(5.42, 11.11),
                Arguments.of(589.6, 432.9)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void luggageConstructorInitializesFieldsCorrectly(double attribute1, double attribute2) throws Throwable {
        Object[][] arguments = {
                {attribute1, double.class},
                {attribute2, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectFieldInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize the object.";
        _assertEquals(attribute1, classInstance.getFieldValue(instance, doubleAttributeName1),
                incorrectFieldInstantiationMessage);
        _assertEquals(attribute2, classInstance.getFieldValue(instance, doubleAttributeName2),
                incorrectFieldInstantiationMessage);
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 0, Math.sqrt(1)),
                Arguments.of(0, 2, Math.sqrt(4)),
                Arguments.of(23.6, 8.1, Math.sqrt(Math.pow(23.6, 2) + Math.pow(8.1, 2))),
                Arguments.of(174.429, 482.4893, Math.sqrt(Math.pow(174.429, 2) + Math.pow(482.4893, 2)))
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctSumItemsMethods(double attribute1, double attribute2, double diag) throws Throwable {
        Object[][] arguments = {
                {attribute1, double.class},
                {attribute2, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName, null, double.class),
                "Your " + testClassName + " class is missing the method " + methodName + ".");
        Object methodOutput = classInstance.callMethod(methodName, instance, null);
        _assertEquals(diag, methodOutput,
                "Your " + methodName + " method does not produce the correct output.");
    }
}
