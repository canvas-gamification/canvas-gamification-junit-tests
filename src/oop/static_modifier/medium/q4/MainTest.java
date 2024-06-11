package oop.static_modifier.medium.q4;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static global.utils.ArrayUtil.generateRandomArray;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    ObjectTest testClass;
    String className = "ChemistryLab";
    String firstDoubleName = "liquid1";
    String secondDoubleName = "liquid2";
    String firstIntName = "MIX_1";
    String secondIntName = "MIX_2";
    String arrayName = "guide";
    String methodName = "mixFun";
    static double liquidInitialValue1 = 10.5;
    static double liquidInitialValue2 = 10.5;
    int typeValue1 = 0; // Must be less than 5
    int typeValue2 = 1; // Must be less than 5

    @BeforeEach
    public void setup() throws Throwable {
        String circleString = "oop.static_modifier.medium.q4." + className;
        testClass = new ObjectTest(circleString);
        String modificationErrorMessage = "You have modified the provided portions of " + className + " class for the %s attribute. Please revert them to the original state.";
        assertTrue(testClass.hasField(firstDoubleName, double.class, new String[]{"private", "static"}),
                String.format(modificationErrorMessage,firstDoubleName));
        assertTrue(testClass.hasField(secondDoubleName, double.class, new String[]{"private", "static"}),
                String.format(modificationErrorMessage, secondDoubleName));
        assertTrue(testClass.hasField(firstIntName, int.class, new String[]{"private", "final", "static"}),
                String.format(modificationErrorMessage, firstIntName));
        assertTrue(testClass.hasField(secondIntName, int.class, new String[]{"private", "final", "static"}),
                String.format(modificationErrorMessage, secondIntName));
        assertTrue(testClass.hasField(arrayName, double[].class, new String[]{"private"}),
                String.format(modificationErrorMessage, arrayName));
        modificationErrorMessage = "You have modified the provided portions of " + className + " class for the %s constructor. Please revert them to the original state.";
        for (int i = 0; i < 10; i++) {
            double[] test = generateRandomArray(0.5, 20.0, ((int) (Math.random() * 20)));
            Object[][] arguments = {{test, double[].class}};
            Object classInstance = testClass.createInstance(arguments);
            _assertArrayEquals(test, testClass.getFieldValue(classInstance, arrayName),
                    String.format(modificationErrorMessage, className));
            _assertEquals(liquidInitialValue1, testClass.getFieldValue(null, firstDoubleName),
                    String.format(modificationErrorMessage, className));
            _assertEquals(liquidInitialValue2, testClass.getFieldValue(null, secondDoubleName),
                    String.format(modificationErrorMessage, className));
            _assertEquals(typeValue1, testClass.getFieldValue(null, firstIntName),
                    String.format(modificationErrorMessage, className));
            _assertEquals(typeValue2, testClass.getFieldValue(null, secondIntName),
                    String.format(modificationErrorMessage, className));

        }
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new double[]{liquidInitialValue1, liquidInitialValue2, liquidInitialValue1, liquidInitialValue2, liquidInitialValue1}),
                Arguments.of(new double[]{liquidInitialValue1 + 0.001, liquidInitialValue2 + 0.001, liquidInitialValue1 + 0.001, liquidInitialValue2 + 0.001, liquidInitialValue1 + 0.001}),
                Arguments.of(new double[]{liquidInitialValue1 - 0.001, liquidInitialValue2 - 0.001, liquidInitialValue1 - 0.001, liquidInitialValue2 - 0.001, liquidInitialValue1 - 0.001}),
                Arguments.of(new double[]{liquidInitialValue1 + 0.001, liquidInitialValue2 - 0.001, liquidInitialValue1 + 0.001, liquidInitialValue2 - 0.001, liquidInitialValue1 + 0.001}),
                Arguments.of(new double[]{liquidInitialValue1 - 0.001, liquidInitialValue2 + 0.001, liquidInitialValue1 - 0.001, liquidInitialValue2 + 0.001, liquidInitialValue1 - 0.001}),
                Arguments.of(generateRandomArray(0.5, 20.0, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctMixFunMethod(double[] guide) throws Throwable {
        Object[][] arguments = {
                {guide, double[].class}
        };
        assertTrue(testClass.hasMethod(methodName, null),
                "Your " + className + " class does not have a " + methodName + " method");
        assertTrue(testClass.hasMethod(methodName, null, Void.TYPE),
                "Your " + methodName + " method should not return anything.");
        assertTrue(testClass.hasMethod(methodName, null, Void.TYPE, new String[]{"public"}),
                "Your " + methodName + " method does not have the correct visibility modifier.");
        Object classInstance = testClass.createInstance(arguments);
        if (guide[typeValue1] <= liquidInitialValue1 && guide[typeValue2] <= liquidInitialValue2) {
            testClass.callMethod(methodName, classInstance, new Clause[]{
                    new StringLiteral("Mixing …"),
                    new Optional(new StringLiteral(" ")),
                    new NewLine(),
                    new StringLiteral("Mixing Successful"),
                    new Optional(new StringLiteral(" "))
            });
            _assertEquals(liquidInitialValue1 - guide[typeValue1], testClass.getFieldValue(null, firstDoubleName), 0.001,
                    "Your " + methodName + " method does not decrease the value of " + firstDoubleName + " correctly when it mixes the liquids successfully.");
            _assertEquals(liquidInitialValue2 - guide[typeValue2], testClass.getFieldValue(null, secondDoubleName), 0.001,
                    "Your " + methodName + " method does not decrease the value of " + secondDoubleName + " correctly when it mixes the liquids successfully.");
        } else {
            testClass.callMethod(methodName, classInstance, new Clause[]{
                    new StringLiteral("There's not enough ingredients to create the mixture"),
                    new Optional(new StringLiteral(" ")),
            });
            _assertEquals(liquidInitialValue1, testClass.getFieldValue(null, firstDoubleName), 0.001,
                    "Your " + methodName + " method decreases the value of " + firstDoubleName + " when it should not.");
            _assertEquals(liquidInitialValue2, testClass.getFieldValue(null, secondDoubleName), 0.001,
                    "Your " + methodName + " method decreases the value of " + secondDoubleName + " when it should not.");
        }
        testClass.setFieldValue(null, liquidInitialValue1, firstDoubleName);
        testClass.setFieldValue(null, liquidInitialValue2, secondDoubleName);
    }


}
