package oop.object_independence.hard.q4;

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

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String objectClassName = "Painting";
    private final String testClassName = "TestMuseum";
    private final String stringAttributeName1 = "name";
    private final String stringAttributeName2 = "quality";
    private final String getStringAttributeName1 = "getName";
    private final String getStringAttributeName2 = "getQuality";
    private final String setStringAttributeName1 = "setName";
    private final String setStringAttributeName2 = "setQuality";
    private final String testStringAttributeName1a = "The Starry Night";
    private final String testStringAttributeName2a = "The Scream";
    private final String testStringAttributeName1b = "good";
    private final String testStringAttributeName2b = "poor";
    private final String testStringAttributeNameUpdate = "fair";
    private ObjectTest classInstance;
    private ObjectTest testInstance;

    @BeforeEach
    public void setup() {
        String objectClassString = "oop.object_independence.hard.q4." + objectClassName;
        String testClassString = "oop.object_independence.hard.q4." + testClassName;
        classInstance = new ObjectTest(objectClassString);
        testInstance = new ObjectTest(testClassString);
    }

    @Test
    public void paintingClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your %s class is missing the %s attribute. Please make sure you have added it, it is spelled correctly, and it is of the correct type.";
        assertTrue(classInstance.hasField(stringAttributeName1, String.class),
                String.format(missingAttributeMessage, objectClassName, stringAttributeName1));
        assertTrue(classInstance.hasField(stringAttributeName2, String.class),
                String.format(missingAttributeMessage, objectClassName, stringAttributeName2));
        String incorrectVisibilityModifier = "Your %s class %s attribute has the wrong visibility modifier.";
        assertTrue(classInstance.hasModifier(stringAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, stringAttributeName1));
        assertTrue(classInstance.hasModifier(stringAttributeName2, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, stringAttributeName2));
    }

    @Test
    public void paintingClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments = {String.class, String.class};
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Mona Lisa", "faded"),
                Arguments.of("Sunflowers", "tomatoed"),
                Arguments.of("Girl with a Pearl Earring", "good"),
                Arguments.of("The Kiss", "poor")
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void paintingConstructorInitializesAttributesCorrectly(String n, String q) throws Throwable {
        Object[][] arguments = {
                {n, String.class},
                {q, String.class}
        };
        String incorrectVisibilityModifier = "Your %s constructor has the incorrect visibility modifier.";
        assertTrue(classInstance.hasModifier(new Class[]{String.class, String.class}, "public"),
                String.format(incorrectVisibilityModifier, objectClassName));
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeValue =
                "Your %s constructor does not correctly initialize the %s attribute based on the passed parameters.";
        _assertEquals(n, classInstance.getFieldValue(instance, stringAttributeName1),
                String.format(incorrectAttributeValue, objectClassName, stringAttributeName1));
        _assertEquals(q, classInstance.getFieldValue(instance, stringAttributeName2),
                String.format(incorrectAttributeValue, objectClassName, stringAttributeName2));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void paintingHasCorrectGetMethods(String name, String quality) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {quality, String.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        Object output = classInstance.callMethod(getStringAttributeName1, new String[]{"public"}, instance);
        _assertEquals(name, output, String.format(incorrectGetMethods, getStringAttributeName1, stringAttributeName1));
        output = classInstance.callMethod(getStringAttributeName2, new String[]{"public"}, instance);
        _assertEquals(quality, output, String.format(incorrectGetMethods, getStringAttributeName2, stringAttributeName2));
    }

    private static Stream<Arguments> setMethodsInputProvider() {
        return Stream.of(
                Arguments.of("The Birth of Venus", "great", "The Last Supper", "poor"),
                Arguments.of("Café Terrace at Night", "decent", "Cafe Terrace at Night", "fair"),
                Arguments.of("The Night Watch", "bad", "A sunday Afternoon on the Island of La Grande Jatte", "destroyed"),
                Arguments.of("Liberty Leading the People", "French", "Impression, Sunrise", "fine")
        );
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void paintingHasCorrectSetMethods(String name, String quality, String newName, String newQuality) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {quality, String.class}
        };
        Object instance = classInstance.createInstance(arguments);
        classInstance.callMethod(setStringAttributeName1, new Object[][]{{newName, String.class}}, instance);
        classInstance.callMethod(setStringAttributeName2, new Object[][]{{newQuality, String.class}}, instance);

        String incorrectSetMethods = "Your %s method does not update the %s attribute to the passed parameter.";

        _assertEquals(newName, classInstance.getFieldValue(instance, stringAttributeName1),
                String.format(incorrectSetMethods, setStringAttributeName1, stringAttributeName1));
        _assertEquals(newQuality, classInstance.getFieldValue(instance, stringAttributeName2),
                String.format(incorrectSetMethods, setStringAttributeName2, stringAttributeName2));

        assertTrue(classInstance.hasReturnType(setStringAttributeName1, new Class[]{String.class}, void.class));
        assertTrue(classInstance.hasReturnType(setStringAttributeName2, new Class[]{String.class}, void.class));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void paintingClassHasCorrectToStringMethod(String name, String quality) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {quality, String.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String expectedOutput = "The item " + name + " is of " + quality + " quality";
        Object output = classInstance.callMethod("toString", new String[]{"public"}, instance);
        String incorrectToString = String.format("Your toString method for the %s class does return the correct String.", objectClassName);
        _assertEquals(expectedOutput, output, incorrectToString);
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void paintingMethodsWorkCorrectlyWorkTogether(String name, String quality, String newName, String newQuality) throws Throwable {
        Object[][] constructorArguments = {
                {name, String.class},
                {quality, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        classInstance.callMethod(setStringAttributeName1, new Object[][]{{newName, String.class}}, instance);
        classInstance.callMethod(setStringAttributeName2, new Object[][]{{newQuality, String.class}}, instance);
        Object output1 = classInstance.callMethod(getStringAttributeName1, instance);
        Object output2 = classInstance.callMethod(getStringAttributeName2, instance);
        Object toStringOutput = classInstance.callMethod("toString", instance);
        String expectedToStringOutput = "The item " + newName + " is of " + newQuality + " quality";
        String incorrectSetGet =
                "Your %s method does not return the correct value after updating the %s attribute using the %s method.";
        String incorrectToString =
                "Your toString method does not return the correct String after updating the %s and %s attributes using the %s and %s methods.";
        _assertEquals(newName, output1,
                String.format(incorrectSetGet, getStringAttributeName1, stringAttributeName1, setStringAttributeName1));
        _assertEquals(newQuality, output2,
                String.format(incorrectSetGet, getStringAttributeName2, stringAttributeName2, setStringAttributeName2));
        _assertEquals(expectedToStringOutput, toStringOutput,
                String.format(incorrectToString, stringAttributeName1, stringAttributeName2,
                        setStringAttributeName1, setStringAttributeName2));
    }

    @Test
    public void testMuseumMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};

        Clause[] clauses = new Clause[]{
                new StringLiteral("The item " + testStringAttributeName1a + " is of " + testStringAttributeName1b + " quality"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The item " + testStringAttributeName2a + " is of " + testStringAttributeName2b + " quality"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Some time passed\\.\\.\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The item " + testStringAttributeName1a + " is of " + testStringAttributeNameUpdate + " quality"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The item " + testStringAttributeName2a + " is of " + testStringAttributeName2b + " quality"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("This needs cleaning\\."),
                new Optional(new StringLiteral(" "))
        };
        String incorrectOutput =
                String.format("Your %s class main method does not correctly initialize, update, and print the values of the two %s objects.",
                        testClassName, objectClassName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
