package oop.object_interactions.hard.q4;

import global.ObjectTest;
import global.variables.Clause;
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
    private ObjectTest classInstance;
    private ObjectTest testInstance;
    private final String objectClassName = "CryptBox";
    private final String testClassName = "TestEncryption";
    private final String stringAttribute1 = "lockedData";
    private final String intAttribute1 = "cryptKey";
    private final String getIntAttribute1 = "getCryptKey";
    private final String methodName1 = "crossEncrypt";
    private final String testStringRegexMessage = "Olssv'\\{olyl";

    @BeforeEach
    public void setup() {
        String objectString = "oop.object_interactions.hard.q4." + objectClassName;
        classInstance = new ObjectTest(objectString);
        String testString = "oop.object_interactions.hard.q4." + testClassName;
        testInstance = new ObjectTest(testString);
    }

    @Test
    public void cryptBoxClassHasRequiredAttributes() {
        assertTrue(classInstance.hasField(stringAttribute1, String.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", stringAttribute1));
        assertTrue(classInstance.hasField(intAttribute1, int.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", intAttribute1));
        assertTrue(classInstance.hasModifier(stringAttribute1, "private"),
                String.format("The %s field does not have the correct visibility modifier.", stringAttribute1));
        assertTrue(classInstance.hasModifier(intAttribute1, "private"),
                String.format("The %s field does not have the correct visibility modifier.", intAttribute1));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("how is the weather", 1),
                Arguments.of("secret information", 34),
                Arguments.of("ip address", 5),
                Arguments.of("aliens are real the government told me so", 17)
        );
    }

    @Test
    public void cryptBoxClassHasConstructor() {
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, int.class}),
                String.format("Your %s class is missing a required constructor.", objectClassName));
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, int.class}, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", objectClassName));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void cryptBoxClassHasCorrectConstructor(String data, int key) throws Throwable {
        Object[][] arguments = {
                {data, String.class},
                {key, int.class}
        };
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, int.class}),
                String.format("Your %s class is missing a required constructor.", objectClassName));
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, int.class}, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", objectClassName));
        Object instance = classInstance.createInstance(arguments);
        _assertEquals(data, classInstance.getFieldValue(instance, stringAttribute1),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", objectClassName, stringAttribute1));
        _assertEquals(key, classInstance.getFieldValue(instance, intAttribute1),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", objectClassName, intAttribute1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctGetCryptKeyMethod(String data, int key) throws Throwable {
        Object[][] constructorArguments = {
                {data, String.class},
                {key, int.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";
        assertTrue(classInstance.hasMethod(getIntAttribute1, null, int.class, new String[]{"public"}),
                String.format("Your %s class is missing the %s method, or the %s method has the wrong return type.", objectClassName, getIntAttribute1, getIntAttribute1));

        Object output = classInstance.callMethod(getIntAttribute1, new String[]{"public"}, instance);
        _assertEquals(key, output, String.format(incorrectGetMethods, getIntAttribute1, stringAttribute1));
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of("secret information", 11, "pointless", 5, "xjhwjy%nsktwrfynts"),
                Arguments.of("testing testing 123", 1, "unused", 67, "·¨¶·¬±ªc·¨¶·¬±ªctuv"),
                Arguments.of("lets encrypt this", 7, "forlorn and lonely", 0, "lets encrypt this"),
                Arguments.of("garage sale goods", 1, "green sign", 13, "tn\u007Fntr-\u0080nyr-t||q\u0080")
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctCrossEncryptMethod(String data1, int key1, String data2, int key2, String mssg) throws Throwable {
        Object[][] box1Arguments = {
                {data1, String.class},
                {key1, int.class}
        };
        Object[][] box2Arguments = {
                {data2, String.class},
                {key2, int.class}
        };
        Object instance1 = classInstance.createInstance(box1Arguments);
        Object instance2 = classInstance.createInstance(box2Arguments);
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{classInstance.getObjectClass()}, String.class, new String[]{"public"}),
                String.format(
                        "Your %s class is missing the %s method. Please check that the name is spelled correctly, the parameters and return type are correct, and it has the correct visibility modifier.",
                        objectClassName, methodName1
                ));
        Object[][] methodArguments = {{instance2, classInstance.getObjectClass()}};
        Object output = classInstance.callMethod(methodName1, methodArguments, instance1);
        _assertEquals(mssg, output, "Your " + methodName1 + " method does not correctly encrypt the " + stringAttribute1);
    }

    @Test
    public void testEncryptionMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral("Encrypted message is\\: " + testStringRegexMessage)
        };
        String incorrectOutput =
                String.format("Your %s class main method does not correctly initialize the values of the two %s objects and encrypt the data of the first.",
                        testClassName, objectClassName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
