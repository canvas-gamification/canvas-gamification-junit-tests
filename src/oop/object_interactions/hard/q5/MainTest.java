package oop.object_interactions.hard.q5;

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
    private ObjectTest classInstance;
    private ObjectTest testInstance;
    private final String objectClassName = "Animal";
    private final String testClassName = "TestExperiment";
    private final String stringAttribute1 = "DNASequence";
    private final String stringAttribute2 = "name";
    private final String getStringAttribute1 = "getDNASequence";
    private final String getStringAttribute2 = "getName";
    private final String methodName1 = "clone";
    private final String methodName2 = "mutate";
    private final String testString1 = "Zebra";
    private final String testString2 = "ACGT ACGT TAGC";
    private final String testString3 = "Lion";
    private final String testString4 = "TCGA ACGT AACT";
    private final String testString5 = "Zebrion";
    private final String testString6 = "ATCCGGTA  AACCGGTT  TAAAGCCT";

    @BeforeEach
    public void setup() {
        String objectString = "oop.object_interactions.hard.q5." + objectClassName;
        classInstance = new ObjectTest(objectString);
        String testString = "oop.object_interactions.hard.q5." + testClassName;
        testInstance = new ObjectTest(testString);
    }

    @Test
    public void animalClassHasRequiredAttributes() {
        assertTrue(classInstance.hasField(stringAttribute1, String.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", stringAttribute1));
        assertTrue(classInstance.hasField(stringAttribute2, String.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", stringAttribute2));
        assertTrue(classInstance.hasModifier(stringAttribute1, "private"),
                String.format("The %s field does not have the correct visibility modifier.", stringAttribute1));
        assertTrue(classInstance.hasModifier(stringAttribute2, "private"),
                String.format("The %s field does not have the correct visibility modifier.", stringAttribute2));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Bear", "HFU FEUI FEWIFHSJ"),
                Arguments.of("Elephant", "HUIERHGUI"),
                Arguments.of("Starfish", "AM MXNDWOZUXWKZMCXZMVZNCVMSD FSMZ"),
                Arguments.of("Magpie", "O")
        );
    }

    @Test
    public void animalClassHasConstructor() {
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, String.class}),
                String.format("Your %s class is missing a required constructor.", objectClassName));
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, String.class}, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", objectClassName));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void animalClassHasCorrectConstructor(String name, String dna) throws Throwable {
        Object[][] arguments = {
                {dna, String.class},
                {name, String.class}
        };
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, String.class}),
                String.format("Your %s class is missing a required constructor.", objectClassName));
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, String.class}, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", objectClassName));
        Object instance = classInstance.createInstance(arguments);
        _assertEquals(dna, classInstance.getFieldValue(instance, stringAttribute1),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", objectClassName, stringAttribute1));
        _assertEquals(name, classInstance.getFieldValue(instance, stringAttribute2),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", objectClassName, stringAttribute2));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctGetDNASequenceMethod(String name, String dna) throws Throwable {
        Object[][] constructorArguments = {
                {dna, String.class},
                {name, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";
        assertTrue(classInstance.hasMethod(getStringAttribute1, null, String.class, new String[]{"public"}),
                String.format("Your %s class is missing the %s method, or the %s method has the wrong return type.", objectClassName, getStringAttribute1, getStringAttribute1));

        Object output = classInstance.callMethod(getStringAttribute1, new String[]{"public"}, instance);
        _assertEquals(dna, output, String.format(incorrectGetMethods, getStringAttribute1, stringAttribute1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctGetNameMethod(String name, String dna) throws Throwable {
        Object[][] constructorArguments = {
                {dna, String.class},
                {name, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";
        assertTrue(classInstance.hasMethod(getStringAttribute2, null, String.class, new String[]{"public"}),
                String.format("Your %s class is missing the %s method, or the %s method has the wrong return type.", objectClassName, getStringAttribute2, getStringAttribute2));

        Object output = classInstance.callMethod(getStringAttribute2, new String[]{"public"}, instance);
        _assertEquals(name, output, String.format(incorrectGetMethods, getStringAttribute2, stringAttribute2));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctToStringMethod(String name, String dna) throws Throwable {
        Object[][] constructorArguments = {
                {dna, String.class},
                {name, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        Object output = classInstance.callMethod("toString", instance);
        String expected = String.format("%s has DNA %s", name, dna);
        _assertEquals(expected, output,
                String.format("Your toString method for the %s class does not return the correct output. Please ensure you match the sample exactly and have not misspelled anything.", objectClassName));
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of("Dragonfly", "HJFEUD", "Polar Bear", "KDYAHE", "HKJDFYEAUHDE"), //Polagonfly
                Arguments.of("Lily", "LELY", "Tiger", "FHSAUIF FEI", "LFEHLSYAUIF FEI"), //Tiger Lily
                Arguments.of("Eagle", "HFIOESFH", "Snake", "FH", "HFFHIOESFH"), //Snagle
                Arguments.of("Plasma", "", "Snail", "HFUIEWFH", "HFUIEWFH"), //ash
                Arguments.of("Frog", "GI FEUOS FEIW", "Statue", "", "GI FEUOS FEIW") //disappointment
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctCloneMethod(String name1, String dna1, String name2, String dna2, String dna3) throws Throwable {
        Object[][] donor1Arguments = {
                {dna1, String.class},
                {name1, String.class}
        };
        Object[][] donor2Arguments = {
                {dna2, String.class},
                {name2, String.class}
        };
        Object instance1 = classInstance.createInstance(donor1Arguments);
        Object instance2 = classInstance.createInstance(donor2Arguments);
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{classInstance.getObjectClass()}, Void.TYPE, new String[]{"public"}),
                String.format(
                        "Your %s class is missing the %s method. Please check that the name is spelled correctly, the parameters and return type are correct, and it has the correct visibility modifier.",
                        objectClassName, methodName1
                ));
        Object[][] methodArguments = {{instance2, classInstance.getObjectClass()}};
        classInstance.callMethod(methodName1, methodArguments, instance1);
        _assertEquals(dna2, classInstance.getFieldValue(instance1, stringAttribute1), "Your " + methodName1 +
                " method does not correctly change the DNA sequence to that of the given " + objectClassName);
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctMutateMethod(String name1, String dna1, String name2, String dna2, String dna3) throws Throwable {
        Object[][] animal1Arguments = {
                {dna1, String.class},
                {name1, String.class}
        };
        Object[][] animal2Arguments = {
                {dna2, String.class},
                {name2, String.class}
        };
        Object instance1 = classInstance.createInstance(animal1Arguments);
        Object instance2 = classInstance.createInstance(animal2Arguments);
        assertTrue(classInstance.hasMethod(methodName2, new Class[]{classInstance.getObjectClass()}, Void.TYPE, new String[]{"public"}),
                String.format(
                        "Your %s class is missing the %s method. Please check that the name is spelled correctly, the parameters and return type are correct, and it has the correct visibility modifier.",
                        objectClassName, methodName1
                ));
        Object[][] methodArguments = {{instance2, classInstance.getObjectClass()}};
        classInstance.callMethod(methodName2, methodArguments, instance1);
        _assertEquals(dna3, classInstance.getFieldValue(instance1, stringAttribute1), "Your " + methodName2 +
                " method does not interleave the DNA of the two " + objectClassName + "s.");
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void animalMethodsWorkCorrectlyWorkTogether(String name1, String dna1, String name2, String dna2, String dna3) throws Throwable {
        Object[][] animal1Arguments = {
                {"dna1", String.class},
                {"name1", String.class}
        };
        Object[][] animal2Arguments = {
                {"dna2", String.class},
                {"name2", String.class}
        };
        Object[][] animal3Arguments = {
                {"", String.class},
                {"mixture", String.class}
        };
        Object instance1 = classInstance.createInstance(animal1Arguments);
        Object instance2 = classInstance.createInstance(animal2Arguments);
        Object instance3 = classInstance.createInstance(animal3Arguments);

        classInstance.setFieldValue(instance1, dna1, stringAttribute1);
        classInstance.setFieldValue(instance1, name1, stringAttribute2);
        classInstance.setFieldValue(instance2, dna2, stringAttribute1);
        classInstance.setFieldValue(instance2, name2, stringAttribute2);

        Object output1 = classInstance.callMethod(getStringAttribute1, instance1);
        Object output2 = classInstance.callMethod(getStringAttribute2, instance1);

        String expectedToStringOutput = "%s has DNA %s";
        String incorrectGet = "Your %s method does not return the correct value after updating the %s attribute.";
        String incorrectToString = "Your toString method does not return the correct String after updating the %s and %s attributes and calling the %s and %s methods.";
        _assertEquals(dna1, output1,
                String.format(incorrectGet, getStringAttribute1, stringAttribute1));
        _assertEquals(name1, output2,
                String.format(incorrectGet, getStringAttribute2, stringAttribute2));

        classInstance.callMethod(methodName1, new Object[][]{{instance1, classInstance.getObjectClass()}}, instance3);
        _assertEquals(dna1, classInstance.getFieldValue(instance3, stringAttribute1),
                String.format("Your %s method does not correctly modify the %s value of the object.", methodName1, stringAttribute1));

        classInstance.callMethod(methodName2, new Object[][]{{instance2, classInstance.getObjectClass()}}, instance3);
        _assertEquals(dna3, classInstance.getFieldValue(instance3, stringAttribute1),
                String.format("Your %s method does not correctly modify the %s value of the object.", methodName2, stringAttribute1));

        Object toStringOutput = classInstance.callMethod("toString", instance1);
        String format = String.format(incorrectToString, stringAttribute1, stringAttribute2, methodName1, methodName2);
        _assertEquals(String.format(expectedToStringOutput, name1, dna1), toStringOutput, format);
        toStringOutput = classInstance.callMethod("toString", instance2);
        _assertEquals(String.format(expectedToStringOutput, name2, dna2), toStringOutput, format);
        toStringOutput = classInstance.callMethod("toString", instance3);
        _assertEquals(String.format(expectedToStringOutput, "mixture", dna3), toStringOutput, format);
    }

    @Test
    public void testExperimentMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral(testString1 + " has DNA " + testString2),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral(testString3 + " has DNA " + testString4),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral(testString5 + " has DNA " + testString6),
                new Optional(new StringLiteral(" "))
        };
        String incorrectOutput =
                String.format("Your %s class main method does not correctly initialize, modify, and print the values of the three %s objects.",
                        testClassName, objectClassName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
