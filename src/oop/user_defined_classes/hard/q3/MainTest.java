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
    public void cupboardClassHasCorrectAttributes() {
        String missingAttributeMessage =
                "The %s attribute could not be found in your %s class. Please make sure you have added it, it is spelled correctly, and is of the correct type";
        String incorrectModifierMessage = "Your %s attribute in the %s class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(intAttributeName1, int.class),
                String.format(missingAttributeMessage, intAttributeName1, testClassName));
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                String.format(incorrectModifierMessage, intAttributeName1, testClassName));
        assertTrue(classInstance.hasField(booleanAttributeName1, boolean.class),
                String.format(missingAttributeMessage, booleanAttributeName1, testClassName));
        assertTrue(classInstance.hasModifier(booleanAttributeName1, "private"),
                String.format(incorrectModifierMessage, booleanAttributeName1, testClassName));
    }

    @Test
    public void cupboardClassHasRequiredConstructor() {
        assertTrue(classInstance.hasConstructor(null, new String[]{"public"}),
                String.format("Your %s class is missing a required constructor or has the incorrect visibility modifier.", testClassName));
    }

    @Test
    public void cupboardConstructorInitializesAttributesCorrectly() throws Throwable {
        Object instance = classInstance.createInstance();
        String incorrectAttributeInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize the object.";
        _assertEquals(0, classInstance.getFieldValue(instance, intAttributeName1),
                incorrectAttributeInstantiationMessage);
        _assertEquals(false, classInstance.getFieldValue(instance, booleanAttributeName1),
                incorrectAttributeInstantiationMessage);
    }

    private static Stream<Integer> methodInputProvider() {
        return Stream.of(1, 4, 5, 78, 16, 47839, 3213467, 0);
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctWashCompleteMethod(int attribute1) throws Throwable {
        Object instance = classInstance.createInstance();
        assertTrue(classInstance.hasMethod(methodName, new Class[]{int.class}, Void.TYPE, new String[]{"public"}),
                "Your " + testClassName + " class is missing the method " + methodName + " or it does not have the correct return type or visibility modifier."
        );
        classInstance.callMethod(methodName, new Object[][]{{attribute1, int.class}}, instance, null);
        _assertEquals(attribute1, classInstance.getFieldValue(instance, intAttributeName1),
                "Your " + methodName + " method does not produce the correct output.");
        int x = (int) classInstance.getFieldValue(instance, intAttributeName1);
        _assertEquals(x > 0, classInstance.getFieldValue(instance, booleanAttributeName1),
                "Your " + methodName + " method does not produce the correct output.");
    }
}
