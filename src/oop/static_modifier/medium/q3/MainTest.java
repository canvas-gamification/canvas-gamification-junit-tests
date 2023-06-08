package oop.static_modifier.medium.q3;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest classInstance;
    private ObjectTest testInstance;
    private final String objectName = "Horse";
    private final String testName = "TestAnimal";
    private final String stringAttribute1 = "noise";
    private final String stringAttribute2 = "name";
    private final String methodName1 = "lengthenSound";
    private final String methodName2 = "shortenSound";
    private final String startNoise = "Neigh!";
    private final int repetitionAmount = 5;
    private final String testName1 = "Marly";
    private final String testName2 = "Darling";

    @BeforeEach
    public void setup() {
        String classPath = "oop.static_modifier.medium.q2." + objectName;
        classInstance = new ObjectTest(classPath);
        String testPath = "oop.static_modifier.medium.q2." + testName;
        testInstance = new ObjectTest(testPath);
    }

    @Test
    public void laptopClassHasRequiredAttributes() {
        assertTrue(classInstance.hasField(stringAttribute1, int.class),
                String.format("Your %s class is missing the %s field. Please make sure that is is spelt correctly and has the correct type.", objectName, stringAttribute1));
        assertTrue(classInstance.hasField(stringAttribute2, int.class),
                String.format("Your %s class is missing the %s field. Please make sure that is is spelt correctly, has the correct type, and has the correct visibility modifier.", objectName, stringAttribute2));
        assertTrue(classInstance.hasModifier(stringAttribute1, "private"),
                String.format("Your %s field does not have the correct visibility modifier.", stringAttribute1));
        assertTrue(classInstance.hasModifier(stringAttribute2, "private"),
                String.format("Your %s field does not have the correct visibility modifier.", stringAttribute2));
        assertTrue(classInstance.hasModifier(stringAttribute2, "static"),
                String.format("Your %s field is missing the static modifier.", stringAttribute2));
    }

    @RepeatedTest(3)
    public void laptopClassHasCorrectConstructor(RepetitionInfo repetitionInfo) throws Throwable {
        if (repetitionInfo.getCurrentRepetition() == 1) {
            classInstance.setFieldValue(null, startNoise, stringAttribute2);
        }
        Object instance = classInstance.createInstance();
        _assertEquals(startNoise + (repetitionAmount * repetitionInfo.getCurrentRepetition()), classInstance.getFieldValue(instance, stringAttribute1),
                String.format("Your %s constructor does not initialize the %s attribute to the correct value.", objectName, stringAttribute1));
        _assertEquals(startNoise + (repetitionAmount * repetitionInfo.getCurrentRepetition()), classInstance.getFieldValue(instance, stringAttribute2),
                String.format("Your %s constructor does not update the %s attribute by the increment amount.", objectName, stringAttribute2));
    }

    private static Stream<Integer> countInputProvider() {
        return Stream.of(0, 1, 3, 5, 10, 59, 61032);
    }

    @ParameterizedTest
    @MethodSource("countInputProvider")
    public void laptopClassHasCorrectGetIdentificationMethod(int n) throws Throwable {
        Object instance = classInstance.createInstance();
        classInstance.setFieldValue(instance, n, stringAttribute1);
        String missingMethodMessage =
                "Your %s class is missing the %s method. Make sure that the method name is spelt correctly, has the " +
                        "correct parameters, returns the correct type, and has the correct visibility modifier.";
        assertTrue(classInstance.hasMethod(methodName1, null, int.class, new String[]{"public"}),
                String.format(missingMethodMessage, objectName, methodName1));
        _assertEquals(n, classInstance.callMethod(methodName1, instance),
                String.format("Your %s method does not return the correct value of the %s attribute.", methodName1, stringAttribute1));
    }

    @ParameterizedTest
    @MethodSource("countInputProvider")
    public void laptopClassHasCorrectSetIdentificationMethod(int n) throws Throwable {
        Object instance = classInstance.createInstance();
        String missingMethodMessage =
                "Your %s class is missing the %s method. Make sure that the method name is spelt correctly, has the " +
                        "correct parameters, returns the correct type, and has the correct visibility modifier.";
        assertTrue(classInstance.hasMethod(methodName2, new Class[]{int.class}, Void.TYPE, new String[]{"public"}),
                String.format(missingMethodMessage, objectName, methodName1));
        classInstance.callMethod(methodName2, new Object[][]{{n, int.class}}, instance);
        _assertEquals(n, classInstance.getFieldValue(instance, stringAttribute1),
                String.format("Your %s method does not return the correct value of the %s attribute.", methodName2, stringAttribute1));
    }

    @ParameterizedTest
    @MethodSource("countInputProvider")
    public void laptopClassHasCorrectIncrementerMethod(int n) throws Throwable {
        Object instance = classInstance.createInstance();
        classInstance.setFieldValue(null, n, stringAttribute2);
        Object output = classInstance.callMethod(methodName, instance);
        _assertEquals(n + repetitionAmount, classInstance.getFieldValue(null, stringAttribute2),
                String.format("Your %s method does not correctly increment the value of the %s attribute.", methodName, stringAttribute2));
        _assertEquals(n + repetitionAmount, output,
                String.format("Your %s method does not return the correct value of the %s attribute.", methodName, stringAttribute2));
    }

    @Test
    public void testPlatformGameMainMethodProducesCorrectOutput() throws Throwable {
        classInstance.setFieldValue(null, startNoise, stringAttribute2);
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral("The first laptop id is "),
                new IntegerLiteral(startNoise + repetitionAmount),
                new NewLine(),
                new StringLiteral("The second laptop id is "),
                new IntegerLiteral(startNoise + (repetitionAmount * 2))
        };
        String incorrectOutput =
                String.format("Your %s class main method does correctly initialize and print the values of the two %s objects.", testName, objectName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
