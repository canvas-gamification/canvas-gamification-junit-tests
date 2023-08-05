package oop.user_defined_classes.hard.q3;

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
    private final String testClassName = "Cupboard";
    private final String intAttributeName1 = "pots";
    private final String booleanAttributeName1 = "anyClean";
    private final String methodName = "washComplete";
    private final int startPotsValue = 0;
    private final boolean startCleanValue = false;
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String testClassString = "oop.user_defined_classes.hard.q3." + testClassName;
        classInstance = new ObjectTest(testClassString);
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        String missingAttributeMessage =
                "The %s attribute could not be found in your %s class. Please make sure you have added it and that it is spelled correctly.";
        String wrongTypeMessage = "The %s attribute does not have the correct type.";
        String incorrectModifierMessage = "Your %s attribute in the %s class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(intAttributeName1), String.format(missingAttributeMessage, intAttributeName1, testClassName));
        assertTrue(classInstance.hasField(intAttributeName1, int.class),
                String.format(wrongTypeMessage, intAttributeName1));
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                String.format(incorrectModifierMessage, intAttributeName1, testClassName));
        assertTrue(classInstance.hasField(booleanAttributeName1), String.format(missingAttributeMessage, booleanAttributeName1, testClassName));
        assertTrue(classInstance.hasField(booleanAttributeName1, boolean.class),
                String.format(wrongTypeMessage, booleanAttributeName1));
        assertTrue(classInstance.hasModifier(booleanAttributeName1, "private"),
                String.format(incorrectModifierMessage, booleanAttributeName1, testClassName));
    }

    @Test
    public void cupboardClassHasFirstRequiredConstructor() {
        assertTrue(classInstance.hasConstructor(null),
                String.format("Your %s class is missing the parameterless required constructor.", testClassName));
        assertTrue(classInstance.hasConstructor(null, new String[]{"public"}),
                String.format("Your parameterless %s class constructor has the incorrect visibility modifier.", testClassName));
    }

    @Test
    public void cupboardClassHasSecondRequiredConstructor() {
        assertTrue(classInstance.hasConstructor(new Class[]{int.class, boolean.class}),
                String.format("Your %s class is missing the required constructor with parameters.", testClassName));
        assertTrue(classInstance.hasConstructor(null, new String[]{"public"}),
                String.format("Your %s class constructor with parameters has the incorrect visibility modifier.", testClassName));
    }

    @Test
    public void cupboardFirstConstructorInitializesAttributesCorrectly() throws Throwable {
        Object instance = classInstance.createInstance();
        String incorrectAttributeInstantiationMessage =
                "Your " + testClassName + " parameterless constructor does not correctly initialize the %s attribute.";
        _assertEquals(startPotsValue, classInstance.getFieldValue(instance, intAttributeName1),
                String.format(incorrectAttributeInstantiationMessage, intAttributeName1));
        _assertEquals(startCleanValue, classInstance.getFieldValue(instance, booleanAttributeName1),
                String.format(incorrectAttributeInstantiationMessage, booleanAttributeName1));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(1, false),
                Arguments.of(100, true),
                Arguments.of(-5, true)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void cupboardSecondConstructorInitializesAttributesCorrectly(int a, boolean b) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, boolean.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeInstantiationMessage =
                "Your " + testClassName + " constructor with parameters does not correctly initialize the %s attribute.";
        _assertEquals(a, classInstance.getFieldValue(instance, intAttributeName1),
                String.format(incorrectAttributeInstantiationMessage, intAttributeName1));
        _assertEquals(b, classInstance.getFieldValue(instance, booleanAttributeName1),
                String.format(incorrectAttributeInstantiationMessage, booleanAttributeName1));
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(1, 0, false, true),
                Arguments.of(4, 12, true, true),
                Arguments.of(5, 16, true, true),
                Arguments.of(78, 1, false, true),
                Arguments.of(16, 137820, false, true),
                Arguments.of(47839, 72, true, true),
                Arguments.of(3213467, 0, true, true),
                Arguments.of(0, 3, false, true),
                Arguments.of(0, 0, false, false)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctWashCompleteMethod(int attribute1, int pots, boolean clean, boolean result) throws Throwable {
        Object[][] arguments = {
                {pots, int.class},
                {clean, boolean.class}
        };
        Object instance = classInstance.createInstance();
        Object instance2 = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName, new Class[]{int.class}),
                "Your " + testClassName + " class is missing the method " + methodName + ".");
        assertTrue(classInstance.hasMethod(methodName, new Class[]{int.class}, Void.TYPE),
                "Your " + testClassName + " class method " + methodName + " does not have the correct return type.");
        assertTrue(classInstance.hasMethod(methodName, new Class[]{int.class}, Void.TYPE, new String[]{"public"}),
                "Your " + testClassName + " class method " + methodName + " does not have the correct visibility modifier.");

        classInstance.callMethod(methodName, new Object[][]{{attribute1, int.class}}, instance, null);
        _assertEquals(attribute1, classInstance.getFieldValue(instance, intAttributeName1),
                "Your " + methodName + " method does not correctly update the " + intAttributeName1 + " attribute.");
        int x = (int) classInstance.getFieldValue(instance, intAttributeName1);
        _assertEquals(x > 0, classInstance.getFieldValue(instance, booleanAttributeName1),
                "Your " + methodName + " method does not correctly update the " + booleanAttributeName1 + " attribute.");

        classInstance.callMethod(methodName, new Object[][]{{attribute1, int.class}}, instance2, null);
        _assertEquals(attribute1 + pots, classInstance.getFieldValue(instance2, intAttributeName1),
                "Your " + methodName + " method does not correctly update the " + intAttributeName1 + " attribute.");
        _assertEquals(result, classInstance.getFieldValue(instance2, booleanAttributeName1),
                "Your " + methodName + " method does not correctly update the " + booleanAttributeName1 + " attribute.");
    }
}
