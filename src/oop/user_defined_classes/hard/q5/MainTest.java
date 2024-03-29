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
    public void phoneClassHasCorrectAttributes() {
        String missingAttributeMessage =
                "The %s attribute could not be found in the %s class. Please make sure you have added it and that it is spelled correctly.";
        String wrongTypeMessage = "The %s attribute does not have the correct type.";
        String incorrectModifierMessage = "Your %s attribute in the %s class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(doubleAttributeName1),
                String.format(missingAttributeMessage, doubleAttributeName1, testClassName));
        assertTrue(classInstance.hasField(doubleAttributeName1, double.class),
                String.format(wrongTypeMessage, doubleAttributeName1));
        assertTrue(classInstance.hasModifier(doubleAttributeName1, "private"),
                String.format(incorrectModifierMessage, doubleAttributeName1, testClassName));
        assertTrue(classInstance.hasField(doubleAttributeName2),
                String.format(missingAttributeMessage, doubleAttributeName2, testClassName));
        assertTrue(classInstance.hasField(doubleAttributeName2, double.class),
                String.format(wrongTypeMessage, doubleAttributeName2));
        assertTrue(classInstance.hasModifier(doubleAttributeName2, "private"),
                String.format(incorrectModifierMessage, doubleAttributeName2, testClassName));
    }

    @Test
    public void phoneClassHasRequiredConstructor() {
        Class<?>[] arguments = {
                double.class, double.class
        };
        assertTrue(classInstance.hasConstructor(arguments),
                String.format("Your %s class is missing a required constructor.", testClassName));
        assertTrue(classInstance.hasConstructor(arguments, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", testClassName));
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
    public void phoneConstructorInitializesAttributesCorrectly(double attribute1, double attribute2) throws Throwable {
        Object[][] arguments = {
                {attribute1, double.class},
                {attribute2, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize the %s attribute.";
        _assertEquals(attribute1, classInstance.getFieldValue(instance, doubleAttributeName1),
                String.format(incorrectAttributeInstantiationMessage, doubleAttributeName1));
        _assertEquals(attribute2, classInstance.getFieldValue(instance, doubleAttributeName2),
                String.format(incorrectAttributeInstantiationMessage, doubleAttributeName2));
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(0, 2),
                Arguments.of(23.6, 8.1),
                Arguments.of(174.429, 482.4893)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctCalcScreenSizeMethod(double attribute1, double attribute2) throws Throwable {
        Object[][] arguments = {
                {attribute1, double.class},
                {attribute2, double.class}
        };
        double diag = Math.sqrt(Math.pow(attribute1, 2) + Math.pow(attribute2, 2));
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName, null),
                "Your " + testClassName + " class is missing the method " + methodName + ".");
        assertTrue(classInstance.hasMethod(methodName, null, double.class),
                "Your " + testClassName + " class " + methodName + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(methodName, null, double.class, new String[]{"public"}),
                "Your " + testClassName + " class " + methodName + " method does not have the correct visibility modifier.");
        Object methodOutput = classInstance.callMethod(methodName, instance, null);
        _assertEquals(diag, methodOutput, 0.00001,
                "Your " + methodName + " method does not correctly calculate the diagonal of the screen.");
    }
}
