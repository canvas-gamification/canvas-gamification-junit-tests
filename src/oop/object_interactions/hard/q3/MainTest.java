package oop.object_interactions.hard.q3;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest classInstance;
    private ObjectTest testInstance;
    private final String objectClassName = "BloodDonor";
    private final String testClassName = "TestBlood";
    private final String stringAttribute1 = "name";
    private final String stringAttribute2 = "bloodType";
    private final String getStringAttribute1 = "getName";
    private final String getStringAttribute2 = "getBloodType";
    private final String methodName1 = "canReceiveBloodFrom";
    private final String testString1 = "Jill";
    private final String testString2 = "A";
    private final String testString3 = "Jane";
    private final String testString4 = "B";
    private final String testStringMessage = "They are incompatible";

    @BeforeEach
    public void setup() {
        String objectString = "oop.object_interactions.hard.q3." + objectClassName;
        classInstance = new ObjectTest(objectString);
        String testString = "oop.object_interactions.hard.q3." + testClassName;
        testInstance = new ObjectTest(testString);
    }

    @Test
    public void bloodDonorClassHasRequiredAttributes() {
        assertTrue(classInstance.hasField(stringAttribute1),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", stringAttribute1));
        assertTrue(classInstance.hasField(stringAttribute2),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", stringAttribute2));
        assertTrue(classInstance.hasField(stringAttribute1, String.class),
                String.format("The %s attribute does not have the correct type.", stringAttribute1));
        assertTrue(classInstance.hasField(stringAttribute2, String.class),
                String.format("The %s attribute does not have the correct type.", stringAttribute2));
        assertTrue(classInstance.hasModifier(stringAttribute1, "private"),
                String.format("The %s attribute does not have the correct visibility modifier.", stringAttribute1));
        assertTrue(classInstance.hasModifier(stringAttribute2, "private"),
                String.format("The %s attribute does not have the correct visibility modifier.", stringAttribute2));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Cindy", "A"),
                Arguments.of("Dale", "B"),
                Arguments.of("Iris", "AB"),
                Arguments.of("Dave", "O")
        );
    }

    @Test
    public void bloodDonorClassHasConstructor() {
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, String.class}),
                String.format("Your %s class is missing a required constructor.", objectClassName));
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, String.class}, new String[]{"public"}),
                String.format("Your %s class does not have the correct visibility modifier.", objectClassName));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void bloodDonorClassHasCorrectConstructor(String name, String blood) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {blood, String.class}
        };
        Object instance = classInstance.createInstance(arguments);
        _assertEquals(name, classInstance.getFieldValue(instance, stringAttribute1),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", objectClassName, stringAttribute1));
        _assertEquals(blood, classInstance.getFieldValue(instance, stringAttribute2),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", objectClassName, stringAttribute2));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctGetNameMethod(String name, String blood) throws Throwable {
        Object[][] constructorArguments = {
                {name, String.class},
                {blood, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        assertTrue(classInstance.hasMethod(getStringAttribute1, new Class[]{}),
                "Your " + objectClassName + " class is missing the method " + getStringAttribute1 + ".");
        assertTrue(classInstance.hasMethod(getStringAttribute1, new Class[]{}, String.class),
                "Your " + objectClassName + " class " + getStringAttribute1 + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(getStringAttribute1, new Class[]{}, String.class, new String[]{"public"}),
                "Your " + objectClassName + " class " + getStringAttribute1 + " method does not have the correct visibility modifier.");

        Object output = classInstance.callMethod(getStringAttribute1, new String[]{"public"}, instance);
        _assertEquals(name, output, String.format(incorrectGetMethods, getStringAttribute1, stringAttribute1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctGetBloodTypeMethod(String name, String blood) throws Throwable {
        Object[][] constructorArguments = {
                {name, String.class},
                {blood, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        assertTrue(classInstance.hasMethod(getStringAttribute2, new Class[]{}),
                "Your " + objectClassName + " class is missing the method " + getStringAttribute2 + ".");
        assertTrue(classInstance.hasMethod(getStringAttribute2, new Class[]{}, String.class),
                "Your " + objectClassName + " class " + getStringAttribute2 + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(getStringAttribute2, new Class[]{}, String.class, new String[]{"public"}),
                "Your " + objectClassName + " class " + getStringAttribute2 + " method does not have the correct visibility modifier.");

        Object output = classInstance.callMethod(getStringAttribute2, new String[]{"public"}, instance);
        _assertEquals(blood, output, String.format(incorrectGetMethods, getStringAttribute2, stringAttribute2));
    }

    @Tag("dependent1")
    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctToStringMethod(String name, String blood) throws Throwable {
        Object[][] constructorArguments = {
                {name, String.class},
                {blood, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        assertTrue(classInstance.hasMethod("toString", new Class[]{}),
                "Your " + objectClassName + " class is missing the toString method.");
        assertTrue(classInstance.hasMethod("toString", new Class[]{}, String.class),
                "Your " + objectClassName + " class toString method does not have the correct return type.");
        assertTrue(classInstance.hasMethod("toString", new Class[]{}, String.class, new String[]{"public"}),
                "Your " + objectClassName + " class toString method does not have the correct visibility modifier.");
        Object output = classInstance.callMethod("toString", instance);
        String expected = String.format("%s's blood type is %s", name, blood);
        _assertEquals(expected, output,
                String.format("Your toString method for the %s class does not return the correct output. Please ensure you match the sample exactly and have not misspelled anything.", objectClassName));
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of("Carry", "A", "Megan", "A", true),
                Arguments.of("Melissa", "AB", "Belinda", "A", true),
                Arguments.of("Caroline", "B", "Neil", "A", false),
                Arguments.of("Brandon", "O", "Tessa", "A", false),

                Arguments.of("Scott", "A", "Peter", "AB", false),
                Arguments.of("Missy", "AB", "David", "AB", true),
                Arguments.of("Edmund", "B", "Terry", "AB", false),
                Arguments.of("Max", "O", "Orson", "AB", false),

                Arguments.of("Lisa", "A", "Jolene", "B", false),
                Arguments.of("Ally", "AB", "Skye", "B", true),
                Arguments.of("Amy", "B", "Daniel", "B", true),
                Arguments.of("Sig", "O", "Sid", "B", false),

                Arguments.of("Lin", "A", "Mary", "O", true),
                Arguments.of("Dave", "AB", "Kevin", "O", true),
                Arguments.of("Sean", "B", "Shane", "O", true),
                Arguments.of("Austen", "O", "Matt", "O", true)
        );
    }

    @Tag("dependent1")
    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctCanReceiveBloodFromMethod(String name1, String blood1, String name2, String blood2, boolean donate) throws Throwable {
        Object[][] donor1Arguments = {
                {name1, String.class},
                {blood1, String.class}
        };
        Object[][] donor2Arguments = {
                {name2, String.class},
                {blood2, String.class}
        };
        Object instance1 = classInstance.createInstance(donor1Arguments);
        Object instance2 = classInstance.createInstance(donor2Arguments);
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{classInstance.getObjectClass()}),
                "Your " + objectClassName + " class is missing the method " + methodName1 + ". Please check that the name is spelled correctly.");
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{classInstance.getObjectClass()}, boolean.class),
                "Your " + objectClassName + " class " + methodName1 + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{classInstance.getObjectClass()}, boolean.class, new String[]{"public"}),
                "Your " + objectClassName + " class " + methodName1 + " method does not have the correct visibility modifier.");
        Object[][] methodArguments = {{instance2, classInstance.getObjectClass()}};
        Object output = classInstance.callMethod(methodName1, methodArguments, instance1);
        _assertEquals(donate, output, "Your " + methodName1 + " method does not correctly identify if a " + objectClassName +
                " can receive blood from another " + objectClassName);
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void bloodDonorMethodsWorkCorrectlyWorkTogether(String name1, String blood1, String name2, String blood2, boolean donate) throws Throwable {
        Object[][] donor1Arguments = {
                {"fName1", String.class},
                {"bType1", String.class}
        };
        Object[][] donor2Arguments = {
                {"fName2", String.class},
                {"bType2", String.class}
        };
        Object instance1 = classInstance.createInstance(donor1Arguments);
        Object instance2 = classInstance.createInstance(donor2Arguments);

        classInstance.setFieldValue(instance1, name1, stringAttribute1);
        classInstance.setFieldValue(instance1, blood1, stringAttribute2);
        classInstance.setFieldValue(instance2, name2, stringAttribute1);
        classInstance.setFieldValue(instance2, blood2, stringAttribute2);

        Object output1 = classInstance.callMethod(getStringAttribute1, instance1);
        Object output2 = classInstance.callMethod(getStringAttribute2, instance1);
        Object output3 = classInstance.callMethod(methodName1, new Object[][]{{instance2, classInstance.getObjectClass()}}, instance1);
        Object toStringOutput = classInstance.callMethod("toString", instance1);
        String expectedToStringOutput = name1 + "'s blood type is " + blood1;
        String incorrectGet = "Your %s method does not return the correct value after updating the %s attribute.";
        String incorrectDonateCheck = "Your %s method does not return the correct value after updating the %s and %s attributes.";
        String incorrectToString = "Your toString method does not return the correct String after updating the %s and %s attributes and calling the %s, %s and %s methods.";
        _assertEquals(name1, output1,
                String.format(incorrectGet, getStringAttribute1, stringAttribute1));
        _assertEquals(blood1, output2,
                String.format(incorrectGet, getStringAttribute2, stringAttribute2));
        _assertEquals(donate, output3,
                String.format(incorrectDonateCheck, methodName1, stringAttribute1, stringAttribute2));
        _assertEquals(expectedToStringOutput, toStringOutput,
                String.format(incorrectToString, stringAttribute1, stringAttribute2, getStringAttribute1,
                        getStringAttribute2, methodName1));
    }

    @Tag("dependency1")
    @Test
    public void testBloodMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral(testString1 + "'s blood type is " + testString2),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral(testString3 + "'s blood type is " + testString4),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral(testStringMessage),
                new Optional(new StringLiteral(" "))
        };
        String incorrectOutput =
                String.format("Your %s class main method does not correctly initialize and print the values of the two %s objects and check if they are compatible.",
                        testClassName, objectClassName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
