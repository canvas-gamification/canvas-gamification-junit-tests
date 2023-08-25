package oop.static_modifier.medium.q2;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest classInstance;
    private ObjectTest testInstance;
    private final String objectName = "Laptop";
    private final String testName = "TestObject";
    private final String intAttribute1 = "identification";
    private final String intAttribute2 = "initial";
    private final String getMethodName = "getIdentification";
    private final String setMethodName = "setIdentification";
    private final String methodName = "incrementer";
    private final int initialStart = 0;
    private final int incrementAmount = 5;


    @BeforeEach
    public void setup() {
        String classPath = "oop.static_modifier.medium.q2." + objectName;
        classInstance = new ObjectTest(classPath);
        String testPath = "oop.static_modifier.medium.q2." + testName;
        testInstance = new ObjectTest(testPath);
    }

    @Order(2)
    @Test
    public void laptopClassHasRequiredAttributes() {
        assertTrue(classInstance.hasField(intAttribute1),
                String.format("Your %s class is missing the %s attribute. Please make sure that is is spelt correctly.", objectName, intAttribute1));
        assertTrue(classInstance.hasField(intAttribute2),
                String.format("Your %s class is missing the %s attribute. Please make sure that is is spelt correctly.", objectName, intAttribute2));
        assertTrue(classInstance.hasField(intAttribute1, int.class),
                String.format("Your %s attribute does not have the correct type.", intAttribute1));
        assertTrue(classInstance.hasField(intAttribute2, int.class),
                String.format("Your %s attribute does not have the correct type.", intAttribute2));
        assertTrue(classInstance.hasModifier(intAttribute1, "private"),
                String.format("Your %s attribute does not have the correct visibility modifier.", intAttribute1));
        assertTrue(classInstance.hasModifier(intAttribute2, "private"),
                String.format("Your %s attribute does not have the correct visibility modifier.", intAttribute2));
        assertTrue(classInstance.hasModifier(intAttribute2, "static"),
                String.format("Your %s attribute is missing the static modifier.", intAttribute2));
    }

    @Order(1)
    @RepeatedTest(3)
    public void laptopClassHasCorrectConstructor(RepetitionInfo repetitionInfo) throws Throwable {
        Object instance = classInstance.createInstance();
        _assertEquals(initialStart + (incrementAmount * repetitionInfo.getCurrentRepetition()), classInstance.getFieldValue(instance, intAttribute1),
                String.format("Your %s constructor does not initialize the %s attribute to the correct value.", objectName, intAttribute1));
        _assertEquals(initialStart + (incrementAmount * repetitionInfo.getCurrentRepetition()), classInstance.getFieldValue(instance, intAttribute2),
                String.format("Your %s constructor does not update the %s attribute by the increment amount.", objectName, intAttribute2));
    }

    private static Stream<Integer> countInputProvider() {
        return Stream.of(0, 1, 3, 5, 10, 59, 61032);
    }

    @Order(3)
    @Tag("dependent1")
    @ParameterizedTest
    @MethodSource("countInputProvider")
    public void laptopClassHasCorrectGetIdentificationMethod(int n) throws Throwable {
        Object instance = classInstance.createInstance();
        classInstance.setFieldValue(instance, n, intAttribute1);
        assertTrue(classInstance.hasMethod(getMethodName, new Class[]{}),
                "Your " + objectName + " class is missing the method " + getMethodName + ".");
        assertTrue(classInstance.hasMethod(getMethodName, new Class[]{}, int.class),
                "Your " + objectName + " class " + getMethodName + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(getMethodName, new Class[]{}, int.class, new String[]{"public"}),
                "Your " + objectName + " class " + getMethodName + " method does not have the correct visibility modifier.");
        _assertEquals(n, classInstance.callMethod(getMethodName, instance),
                String.format("Your %s method does not return the correct value of the %s attribute.", getMethodName, intAttribute1));
    }

    @Order(4)
    @ParameterizedTest
    @MethodSource("countInputProvider")
    public void laptopClassHasCorrectSetIdentificationMethod(int n) throws Throwable {
        Object instance = classInstance.createInstance();
        assertTrue(classInstance.hasMethod(setMethodName, new Class[]{int.class}),
                "Your " + objectName + " class is missing the method " + setMethodName + ".");
        assertTrue(classInstance.hasMethod(setMethodName, new Class[]{int.class}, Void.TYPE),
                "Your " + objectName + " class " + setMethodName + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(setMethodName, new Class[]{int.class}, Void.TYPE, new String[]{"public"}),
                "Your " + objectName + " class " + setMethodName + " method does not have the correct visibility modifier.");
        classInstance.callMethod(setMethodName, new Object[][]{{n, int.class}}, instance);
        _assertEquals(n, classInstance.getFieldValue(instance, intAttribute1),
                String.format("Your %s method does not return the correct value of the %s attribute.", setMethodName, intAttribute1));
    }

    @Order(5)
    @ParameterizedTest
    @MethodSource("countInputProvider")
    public void laptopClassHasCorrectIncrementerMethod(int n) throws Throwable {
        Object instance = classInstance.createInstance();
        classInstance.setFieldValue(null, n, intAttribute2);
        assertTrue(classInstance.hasMethod(methodName, new Class[]{}),
                "Your " + objectName + " class is missing the method " + methodName + ".");
        assertTrue(classInstance.hasMethod(methodName, new Class[]{}, int.class),
                "Your " + objectName + " class " + methodName + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(methodName, new Class[]{}, int.class, new String[]{"private"}),
                "Your " + objectName + " class " + methodName + " method does not have the correct visibility modifier.");
        Object output = classInstance.callMethod(methodName, instance);
        _assertEquals(n + incrementAmount, classInstance.getFieldValue(null, intAttribute2),
                String.format("Your %s method does not correctly increment the value of the %s attribute.", methodName, intAttribute2));
        _assertEquals(n + incrementAmount, output,
                String.format("Your %s method does not return the correct value of the %s attribute.", methodName, intAttribute2));
    }

    @Order(6)
    @Tag("dependency1")
    @Test
    public void testPlatformGameMainMethodProducesCorrectOutput() throws Throwable {
        classInstance.setFieldValue(null, initialStart, intAttribute2);
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral("The first laptop id is "),
                new IntegerLiteral(initialStart + incrementAmount),
                new NewLine(),
                new StringLiteral("The second laptop id is "),
                new IntegerLiteral(initialStart + (incrementAmount * 2))
        };
        String incorrectOutput =
                String.format("Your %s class main method does correctly initialize and print the values of the two %s objects.", testName, objectName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
