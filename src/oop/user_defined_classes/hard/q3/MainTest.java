package oop.user_defined_classes.hard.q3;

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
    private final String testClassName = "Cupboard";
    private final String intAttributeName1 = "pots";
    private final String booleanAttributeName1 = "anyClean";
    private final String methodName = "washComplete";
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String testClassString = "oop.user_defined_classes.hard.q3." + testClassName;
        classInstance = new ObjectTest(testClassString);
    }

    @Test
    public void cupboardClassHasCorrectFields() {
        String missingFieldMessage = "Your " + testClassName + " is missing a required field";
        String incorrectModifierMessage = "One of your fields in the " + testClassName +
                " class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(intAttributeName1, int.class),
                missingFieldMessage);
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                incorrectModifierMessage);
        assertTrue(classInstance.hasField(booleanAttributeName1, boolean.class),
                missingFieldMessage);
        assertTrue(classInstance.hasModifier(booleanAttributeName1, "private"),
                incorrectModifierMessage);
    }

    @Test
    public void cupboardClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        assertTrue(classInstance.hasConstructor(null), missingConstructorMessage);
    }

    @Test
    public void cupboardConstructorInitializesFieldsCorrectly() throws Throwable {
        Object instance = classInstance.createInstance();
        String incorrectFieldInstantiationMessage =
                "Your " + testClassName + " default constructor does not correctly initialize the object.";
        _assertEquals(0, classInstance.getFieldValue(instance, intAttributeName1),
                incorrectFieldInstantiationMessage);
        _assertEquals(false, classInstance.getFieldValue(instance, booleanAttributeName1),
                incorrectFieldInstantiationMessage);
    }

    private static Stream<Integer> methodInputProvider() {
        return Stream.of(1, 4, 5, 78, 16, 47839, 3213467, 0);
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctWashCompleteMethod(int attribute1) throws Throwable {
        Object instance = classInstance.createInstance();
        assertTrue(classInstance.hasMethod(methodName, new Class[]{int.class}),
                "Your " + testClassName + " class is missing the method " + methodName + "."
        );
        classInstance.callMethod(methodName, new Object[][]{{attribute1, int.class}}, instance, null);
        _assertEquals(attribute1, classInstance.getFieldValue(instance, intAttributeName1),
                "Your " + methodName + " method does not produce the correct output.");
        _assertEquals(attribute1 != 0, classInstance.getFieldValue(instance, booleanAttributeName1),
                "Your " + methodName + " method does not produce the correct output.");
    }
}
