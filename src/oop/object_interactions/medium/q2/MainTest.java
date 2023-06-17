package oop.object_interactions.medium.q2;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest testClass;
    private ObjectTest classObject;
    private final String className = "Person";
    private final String testClassName = "TestFriendship";
    private final String myNameAttributeName = "myName";
    private final String mySecretAttributeName = "mySecret";
    private final String friendNamesAttributeName = "friendNames";
    private final String friendSecretsAttributeName = "friendSecrets";
    private final String getNameMethodName = "getName";
    private final String getSecretMethodName = "getSecret";
    private final String hearSecretMethodName = "hearSecret";
    private final String writeInDiaryMethodName = "writeInDiary";

    @BeforeEach
    public void setup() throws Throwable {
        String truckString = "oop.object_interactions.medium.q2." + className;
        String testTruckString = "oop.object_interactions.medium.q2." + testClassName;
        testClass = new ObjectTest(truckString);
        classObject = new ObjectTest(testTruckString);
        assertTrue(testClass.hasModifier("public"),
                "You have changed the visibility modifier on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasField(myNameAttributeName, String.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", myNameAttributeName));
        assertTrue(testClass.hasField(mySecretAttributeName, String.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", mySecretAttributeName));
        assertTrue(testClass.hasField(friendNamesAttributeName, String[].class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", friendNamesAttributeName));
        assertTrue(testClass.hasField(friendSecretsAttributeName, String[].class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", friendSecretsAttributeName));
        Class<?>[] constructorClasses = {String.class, String.class, String[].class};
        assertTrue(testClass.hasConstructor(constructorClasses, new String[]{"public"}),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");

        Object[][] test = new Object[][]{
                {"Sam", "Sam always cheat on exams", new String[]{"Bob", "Ali"}},
                {"John", "John is in love with Alice", new String[]{"Alice", "Bob"}},
                {"Kim", "Kim has broken her leg", new String[]{"Ali", "John"}},
        };
        for (int num = 0; num < test.length; num++) {
            String name = (String) test[num][0];
            String secret = (String) test[num][1];
            String[] friends = (String[]) test[num][2];
            Object[][] arguments = {
                    {name, String.class},
                    {secret, String.class},
                    {friends, String[].class}
            };
            Object classInstance = testClass.createInstance(arguments);
            _assertEquals(name, testClass.getFieldValue(classInstance, myNameAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            _assertEquals(secret, testClass.getFieldValue(classInstance, mySecretAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            _assertArrayEquals(friends, testClass.getFieldValue(classInstance, friendNamesAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            _assertArrayEquals(new String[friends.length], testClass.getFieldValue(classInstance, friendSecretsAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        }

        assertTrue(testClass.hasMethod(getNameMethodName, null, String.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getNameMethodName));
        assertTrue(testClass.hasMethod(getSecretMethodName, null, String.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getSecretMethodName));

    }

    private static Stream<Arguments> hearSecretInputProvider() {
        return Stream.of(
                Arguments.of("Sam", "Sam always cheat on exams", new String[]{"Bob", "Ali"}, "Bob", "Bob has a candy"),
                Arguments.of("John", "John is in love with Alice", new String[]{"Alice", "Bob"}, "Alice", "Alice is in love with John"),
                Arguments.of("Kim", "Kim has broken her leg", new String[]{"Ali", "John"}, "Ali", "Ali broke Kim's leg")
        );
    }

    @ParameterizedTest
    @MethodSource("hearSecretInputProvider")
    public void correctHearSecretMethod(String name, String secret, String[] allFriends, String friend, String friendSecret) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {secret, String.class},
                {allFriends, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] methodArguments = {
                {friend, String.class},
                {friendSecret, String.class}
        };
        Object output = testClass.callMethod(hearSecretMethodName, methodArguments, new String[]{"public"}, classInstance);
        String[] ans = new String[allFriends.length];
        for (int i = 0; i < allFriends.length; i++) {
            if (friend.equals(allFriends[i]))
                ans[i] = friendSecret;
        }
        _assertArrayEquals(ans, testClass.getFieldValue(classInstance, friendSecretsAttributeName),
                "Your " + hearSecretMethodName + " method does not change the " + friendSecretsAttributeName + " attribute correctly.");
        assertNull(output, String.join(" ", "Your", hearSecretMethodName, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("hearSecretInputProvider")
    public void correctWriteInDiaryMethod(String name, String secret, String[] allFriends, String friend, String friendSecret) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {secret, String.class},
                {allFriends, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] methodArguments = {
                {friend, String.class},
                {friendSecret, String.class}
        };
        testClass.callMethod(hearSecretMethodName, methodArguments, new String[]{"public"}, classInstance);
        String[] ans = new String[allFriends.length];
        for (int i = 0; i < allFriends.length; i++) {
            if (friend.equals(allFriends[i]))
                ans[i] = friendSecret;
        }
        Object output = testClass.callMethod(writeInDiaryMethodName, null, new String[]{"public"}, classInstance, new Clause[]{
                new StringLiteral("I have the following secrets:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral(friend + " told me " + friendSecret),
                new Optional(new StringLiteral(".")),
                new Optional(new StringLiteral(" "))
        });
        assertNull(output, String.join(" ", "Your", hearSecretMethodName, "should not return any output"));
    }

    @Test
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("I have the following secrets:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Ann told me she is scared of heights"),
                new Optional(new StringLiteral(".")),
                new Optional(new StringLiteral(" "))
        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses);
    }
}
