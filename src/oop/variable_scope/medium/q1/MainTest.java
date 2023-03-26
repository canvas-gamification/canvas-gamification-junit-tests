package oop.variable_scope.medium.q1;

import global.ObjectTest;
import global.tools.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    ObjectTest testClass;
    private final String testClassName = "Earth";
    private final String intFieldName = "population";
    private final String doubleFieldName = "landMass";
    private final String setIntMethodName = "setPopulation";
    private final String getIntMethodName = "getPopulation";
    private final String setDoubleMethodName = "setLandMass";
    private final String getDoubleMethodName = "getLandMass";

    @BeforeEach
    public void setup() {
        String classString = "oop.variable_scope.medium.q1." + testClassName;
        testClass = new ObjectTest(classString);
    }

    @Test
    public void earthClassHasRequiredFields() {
        String missingFieldMessage = "Your " + testClassName + " class is missing a required field.";
        String incorrectVisibilityModifier = "A field in your " + testClassName + " does not have the correct accessibility modifier.";
        assertTrue(testClass.hasField(intFieldName, int.class), missingFieldMessage);
        assertTrue(testClass.hasModifier(intFieldName, "private"), incorrectVisibilityModifier);
        assertTrue(testClass.hasField(doubleFieldName, double.class), missingFieldMessage);
        assertTrue(testClass.hasModifier(doubleFieldName, "private"), incorrectVisibilityModifier);
    }

    private static Stream<Arguments> doubleIntInputProvider() {
        return Stream.of(
                Arguments.of(Math.PI, 3),
                Arguments.of(0, 0),
                Arguments.of(34.66297, 492746254),
                Arguments.of(2, 2),
                Arguments.of(985.5546, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("doubleIntInputProvider")
    public void earthClassHasRequiredConstructor(double dValue, int iValue) throws Throwable {
        Class<?>[] constructorParams = {double.class, int.class};
        String missingConstructor = "Your " + testClassName + " class is missing a required constructor.";
        String incorrectConstructor = "Your " + testClassName + " class constructor does not correctly initialize its fields.";
        assertTrue(testClass.hasConstructor(constructorParams, new String[]{"public"}),
                missingConstructor);
        Object[][] arguments = {
                {dValue, double.class},
                {iValue, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(dValue, testClass.getFieldValue(classInstance, "landMass"), incorrectConstructor);
        _assertEquals(iValue, testClass.getFieldValue(classInstance, intFieldName), incorrectConstructor);
    }
}
