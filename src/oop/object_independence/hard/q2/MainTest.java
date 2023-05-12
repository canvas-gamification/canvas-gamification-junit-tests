package oop.object_independence.hard.q2;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
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
    private final String objectClassName = "Fish";
    private final String testClassName = "TestAquarium";
    private final String stringAttributeName1 = "colour";
    private final String stringAttributeName2 = "gender";
    private final String intAttributeName1 = "age";
    private final String getStringAttributeName1 = "getColour";
    private final String getStringAttributeName2 = "getGender";
    private final String getIntAttributeName1 = "getAge";
    private final String setStringAttributeName1 = "setColour";
    private final String setStringAttributeName2 = "setGender";
    private final String setIntAttributeName1 = "setAge";
    private final String testStringAttributeName1a = "Blue";
    private final String testStringAttributeName2a = "White";
    private final String testStringAttributeName3a = "Red";
    private final String testStringAttributeName1b = "Male";
    private final String testStringAttributeName2b = "Female";
    private final String testStringAttributeName3b = "Female";
    private final int testIntAttributeName1 = 2;
    private final int testIntAttributeName2 = 4;
    private final int testIntAttributeName3 = 3;
    private final int testIntAttributeNameUpdate = 10;
    private ObjectTest classInstance;
    private ObjectTest testInstance;

    @BeforeEach
    public void setup() {
        String objectClassString = "oop.object_independence.hard.q2." + objectClassName;
        String testClassString = "oop.object_independence.hard.q2." + testClassName;
        classInstance = new ObjectTest(objectClassString);
        testInstance = new ObjectTest(testClassString);
    }

    @Test
    public void fishClassHasCorrectFields() {
        String missingFieldMessage = "Your %s class is missing the %s field.";
        assertTrue(classInstance.hasField(stringAttributeName1, String.class),
                String.format(missingFieldMessage, objectClassName, stringAttributeName1));
        assertTrue(classInstance.hasField(stringAttributeName2, String.class),
                String.format(missingFieldMessage, objectClassName, stringAttributeName2));
        assertTrue(classInstance.hasField(intAttributeName1, int.class),
                String.format(missingFieldMessage, objectClassName, intAttributeName1));
        String incorrectVisibilityModifier = "Your %s class %s field has the wrong visibility modifier.";
        assertTrue(classInstance.hasModifier(stringAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, stringAttributeName1));
        assertTrue(classInstance.hasModifier(stringAttributeName2, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, stringAttributeName2));
        assertTrue(classInstance.hasModifier(intAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, intAttributeName1));
    }

    @Test
    public void fishClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments = {String.class, String.class, int.class};
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Red", "Nb", 50),
                Arguments.of("Magenta", "NA", 1738274),
                Arguments.of("Neon Blue", "Female", 1),
                Arguments.of("Pinkest Pink", "Male", 164)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void fishConstructorInitializesFieldsCorrectly(String c, String g, int a) throws Throwable {
        Object[][] arguments = {
                {c, String.class},
                {g, String.class},
                {a, int.class}
        };
        String incorrectVisibilityModifier = "Your %s constructor has the incorrect visibility modifier.";
        assertTrue(classInstance.hasModifier(new Class[]{String.class, String.class, int.class}, "public"),
                String.format(incorrectVisibilityModifier, objectClassName));
        Object instance = classInstance.createInstance(arguments);
        String incorrectFieldValue =
                "Your %s constructor does not correctly initialize the %s field based on the passed parameters.";
        _assertEquals(c, classInstance.getFieldValue(instance, stringAttributeName1),
                String.format(incorrectFieldValue, objectClassName, stringAttributeName1));
        _assertEquals(g, classInstance.getFieldValue(instance, stringAttributeName2),
                String.format(incorrectFieldValue, objectClassName, stringAttributeName2));
        _assertEquals(a, classInstance.getFieldValue(instance, intAttributeName1),
                String.format(incorrectFieldValue, objectClassName, intAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void fishHasCorrectGetMethods(String colour, String gender, int age) throws Throwable {
        Object[][] arguments = {
                {colour, String.class},
                {gender, String.class},
                {age, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s field.";

        Object output = classInstance.callMethod(getStringAttributeName1, new String[]{"public"}, instance);
        _assertEquals(colour, output, String.format(incorrectGetMethods, getStringAttributeName1, stringAttributeName1));
        output = classInstance.callMethod(getStringAttributeName2, new String[]{"public"}, instance);
        _assertEquals(gender, output, String.format(incorrectGetMethods, getStringAttributeName2, stringAttributeName2));
        output = classInstance.callMethod(getIntAttributeName1, new String[]{"public"}, instance);
        _assertEquals(age, output, String.format(incorrectGetMethods, getIntAttributeName1, intAttributeName1));
    }

    private static Stream<Arguments> setMethodsInputProvider() {
        return Stream.of(
                Arguments.of("Red", "Female", 18, "Pansy", "NA", 28),
                Arguments.of("Pink", "Xeno", 2, "Brown", "Male", 198),
                Arguments.of("Cosmic Latte", "Male", 0, "Scarlet", "Female", 32),
                Arguments.of("Amethyst", "NA", 16, "Purple", "Male", 2),
                Arguments.of("Orange", "Male", 678, "Yellow", "NA", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void fishHasCorrectSetMethods(String colour, String gender, int age, String newColour, String newGender, int newAge) throws Throwable {
        Object[][] arguments = {
                {colour, String.class},
                {gender, String.class},
                {age, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        classInstance.callMethod(setStringAttributeName1, new Object[][]{{newColour, String.class}}, instance);
        classInstance.callMethod(setStringAttributeName2, new Object[][]{{newGender, String.class}}, instance);
        classInstance.callMethod(setIntAttributeName1, new Object[][]{{newAge, int.class}}, instance);

        String incorrectSetMethods = "Your %s method does not update the %s field to the passed parameter.";

        _assertEquals(newColour, classInstance.getFieldValue(instance, stringAttributeName1),
                String.format(incorrectSetMethods, setStringAttributeName1, stringAttributeName1));
        _assertEquals(newGender, classInstance.getFieldValue(instance, stringAttributeName2),
                String.format(incorrectSetMethods, setStringAttributeName2, stringAttributeName2));
        _assertEquals(newAge, classInstance.getFieldValue(instance, intAttributeName1),
                String.format(incorrectSetMethods, setIntAttributeName1, intAttributeName1));

        assertTrue(classInstance.hasReturnType(setStringAttributeName1, new Class[]{String.class}, void.class));
        assertTrue(classInstance.hasReturnType(setStringAttributeName2, new Class[]{String.class}, void.class));
        assertTrue(classInstance.hasReturnType(setIntAttributeName1, new Class[]{int.class}, void.class));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void fishClassHasCorrectToStringMethod(String colour, String gender, int age) throws Throwable {
        Object[][] arguments = {
                {colour, String.class},
                {gender, String.class},
                {age, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String expectedOutput = "This fish is " + colour + ", and is " + gender + ", and is " + age + " years old";
        Object output = classInstance.callMethod("toString", new String[]{"public"}, instance);
        String incorrectToString = String.format("Your toString method for the %s class does return the correct String.", objectClassName);
        _assertEquals(expectedOutput, output, incorrectToString);
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void fishMethodsWorkCorrectlyWorkTogether(String colour, String gender, int age, String newColour, String newGender, int newAge) throws Throwable {
        Object[][] constructorArguments = {
                {colour, String.class},
                {gender, String.class},
                {age, int.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        classInstance.callMethod(setStringAttributeName1, new Object[][]{{newColour, String.class}}, instance);
        classInstance.callMethod(setStringAttributeName2, new Object[][]{{newGender, String.class}}, instance);
        classInstance.callMethod(setIntAttributeName1, new Object[][]{{newAge, int.class}}, instance);
        Object output1 = classInstance.callMethod(getStringAttributeName1, instance);
        Object output2 = classInstance.callMethod(getStringAttributeName2, instance);
        Object output3 = classInstance.callMethod(getIntAttributeName1, instance);
        Object toStringOutput = classInstance.callMethod("toString", instance);
        String expectedToStringOutput = "This fish is " + newColour + ", and is " + newGender + ", and is " + newAge + " years old";
        String incorrectSetGet =
                "Your %s method does not return the correct value after updating the %s field using the %s method.";
        String incorrectToString = "Your toString method does not return the correct String after updating the %s, %s, and %s fields using the %s, %s, and %s methods.";
        _assertEquals(newColour, output1,
                String.format(incorrectSetGet, getStringAttributeName1, stringAttributeName1, setStringAttributeName1));
        _assertEquals(newGender, output2,
                String.format(incorrectSetGet, getStringAttributeName2, stringAttributeName2, setStringAttributeName2));
        _assertEquals(newAge, output3,
                String.format(incorrectSetGet, getIntAttributeName1, intAttributeName1, setIntAttributeName1));
        _assertEquals(expectedToStringOutput, toStringOutput,
                String.format(incorrectToString, stringAttributeName1, stringAttributeName2, intAttributeName1,
                        setStringAttributeName1, setStringAttributeName2, setIntAttributeName1));
    }

    @Test
    public void testPlatformGameMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testStringAttributeName1a, testStringAttributeName1b, testIntAttributeName1)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testStringAttributeName2a, testStringAttributeName2b, testIntAttributeName2)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testStringAttributeName3a, testStringAttributeName3b, testIntAttributeName3)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testStringAttributeName1a, testStringAttributeName1b, testIntAttributeName1 + testIntAttributeNameUpdate)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testStringAttributeName2a, testStringAttributeName2b, testIntAttributeName2 + testIntAttributeNameUpdate)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testStringAttributeName3a, testStringAttributeName3b, testIntAttributeName3 + testIntAttributeNameUpdate)),
        };
        String incorrectOutput =
                String.format("Your %s class main method does correctly initialize, update, and print the values of the two %s objects.",
                        testClassName, objectClassName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
