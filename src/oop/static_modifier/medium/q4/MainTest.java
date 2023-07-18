package oop.static_modifier.medium.q4;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
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
    static double initialValue = 10.5;
    int typeValue1 = 0; // Must be less than 5
    int typeValue2 = 1; // Must be less than 5

    @BeforeEach
    public void setup() throws Throwable {
        String circleString = "oop.static_modifier.medium.q4." + className;
        testClass = new ObjectTest(circleString);
        String modificationErrorMessage = "You have modified the provided portions of %s class. Please revert them to the original state.";
        assertTrue(testClass.hasField(firstDoubleName, double.class),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasField(secondDoubleName, double.class),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasField(firstIntName, int.class),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasField(secondIntName, int.class),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasField(arrayName, double[].class),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(firstDoubleName, "private"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(firstDoubleName, "static"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(secondDoubleName, "private"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(secondDoubleName, "static"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(firstIntName, "private"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(firstIntName, "static"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(firstIntName, "final"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(secondIntName, "private"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(secondIntName, "static"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(secondIntName, "final"),
                String.format(modificationErrorMessage, className));
        assertTrue(testClass.hasModifier(arrayName, "private"),
                String.format(modificationErrorMessage, className));
        for (int i = 0; i < 10; i++) {
            double[] test = generateRandomArray(0.5, 20.0, ((int) (Math.random() * 20)));
            Object[][] arguments = {{test, double[].class}};
            Object classInstance = testClass.createInstance(arguments);
            _assertArrayEquals(test, testClass.getFieldValue(classInstance, arrayName),
                    String.format(modificationErrorMessage, className));
            _assertEquals(initialValue, testClass.getFieldValue(null, firstDoubleName),
                    String.format(modificationErrorMessage, className));
            _assertEquals(initialValue, testClass.getFieldValue(null, secondDoubleName),
                    String.format(modificationErrorMessage, className));
            _assertEquals(typeValue1, testClass.getFieldValue(null, firstIntName),
                    String.format(modificationErrorMessage, className));
            _assertEquals(typeValue2, testClass.getFieldValue(null, secondIntName),
                    String.format(modificationErrorMessage, className));

        }
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new double[]{initialValue, initialValue, initialValue, initialValue, initialValue}),
                Arguments.of(new double[]{initialValue + 1, initialValue + 1, initialValue + 1, initialValue + 1, initialValue + 1}),
                Arguments.of(new double[]{initialValue - 1, initialValue - 1, initialValue - 1, initialValue - 1, initialValue - 1}),
                Arguments.of(generateRandomArray(0.5, 20.0, 10)),
                Arguments.of(generateRandomArray(0.5, 20.0, 10)),
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
        double value1 = (double) testClass.getFieldValue(null, firstDoubleName);
        double value2 = (double) testClass.getFieldValue(null, secondDoubleName);
        if (guide[typeValue1] <= value1 && guide[typeValue2] <= value2) {
            testClass.callMethod(methodName, classInstance, new Clause[]{
                    new StringLiteral("Mixing … "),
                    new Optional(new StringLiteral(" ")),
                    new NewLine(),
                    new StringLiteral("Mixing Successful"),
                    new Optional(new StringLiteral(" "))
            });
            _assertEquals(value1 - guide[typeValue1], testClass.getFieldValue(null, firstDoubleName),
                    "Your " + methodName + " method does not decrease the value of " + firstDoubleName + " correctly.");
            _assertEquals(value2 - guide[typeValue2], testClass.getFieldValue(null, secondDoubleName),
                    "Your " + methodName + " method does not decrease the value of " + secondDoubleName + " correctly.");
        } else {
            testClass.callMethod(methodName, classInstance, new Clause[]{
                    new StringLiteral("There's not enough ingredients to create mixture"),
                    new Optional(new StringLiteral(" ")),
            });
            _assertEquals(value1, testClass.getFieldValue(null, firstDoubleName),
                    "Your " + methodName + " method decrease the value of " + firstDoubleName + " when it should not.");
            _assertEquals(value2, testClass.getFieldValue(null, secondDoubleName),
                    "Your " + methodName + " method decrease the value of " + secondDoubleName + " when it should not.");
        }
        testClass.setFieldValue(null, initialValue, firstDoubleName);
        testClass.setFieldValue(null, initialValue, secondDoubleName);
    }


}
