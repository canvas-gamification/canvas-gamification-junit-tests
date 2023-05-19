package oop.user_defined_classes.hard.q4;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String testClassName = "Laundromat";
    private final String intAttributeName1 = "gymClothes";
    private final String methodName = "doLaundry";
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String testClassString = "oop.user_defined_classes.hard.q4." + testClassName;
        classInstance = new ObjectTest(testClassString);
    }

    @Test
    public void laundromatClassHasCorrectAttributes() {
        String missingAttributeMessage =
                "The %s attribute could not be found in your %s class. Please make sure you have added it, it is spelled correctly, and is of the correct type";
        String incorrectModifierMessage = "Your %s attribute in the %s class does not have the correct visibility modifier.";
        assertTrue(classInstance.hasField(intAttributeName1, int.class),
                String.format(missingAttributeMessage, intAttributeName1, testClassName));
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                String.format(incorrectModifierMessage, intAttributeName1, testClassName));
    }

    @Test
    public void laundromatClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments = {
                int.class
        };
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Integer> constructorInputProvider() {
        return Stream.of(0, 2, 15, 42, 532789, 473, 123);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void laundromatConstructorInitializesAttributesCorrectly(int attribute1) throws Throwable {
        Object[][] arguments = {
                {attribute1, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeInstantiationMessage =
                "Your " + testClassName + " constructor does not correctly initialize the object.";
        _assertEquals(attribute1, classInstance.getFieldValue(instance, intAttributeName1),
                incorrectAttributeInstantiationMessage);
    }

    private static Stream<Integer> methodInputProvider() {
        return Stream.of(0, 1, 2, 10, 16, 32, 489, 1092);
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctDoLaundryMethod(int attribute1) throws Throwable {
        Object[][] arguments = {
                {attribute1, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName, null),
                "Your " + testClassName + " class is missing the method " + methodName + ".");
        Clause[] c = new Clause[attribute1 * 3 + 2];
        int count = 0;
        for (int x = 0; x < c.length - 2; x += 3) {
            int num = (x + 2) / 3;
            c[count++] = new StringLiteral("Cleaning item " + (num + 1));
            c[count++] = new Optional(new StringLiteral(" "));
            c[count++] = new NewLine();
        }
        c[count++] = new StringLiteral("Your laundry is done!");
        c[count] = new Optional(new StringLiteral(" "));
        classInstance.callMethod(methodName, instance, c,
                "Your " + methodName + " method does not correctly print the items being cleaned.");
        _assertEquals(0, classInstance.getFieldValue(instance, intAttributeName1),
                "Your " + methodName + " method does not set " + intAttributeName1 + " to zero.");
    }
}
