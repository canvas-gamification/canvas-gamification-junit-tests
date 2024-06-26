package oop.object_interactions.medium.q2;

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

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
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
            assertTrue(testClass.hasMethod(getNameMethodName, null, String.class, new String[]{"public"}),
                    String.format("You have modified the provided %s method. Please revert it to the original state.", getNameMethodName));
            Object getMethodOutput = testClass.callMethod(getNameMethodName, new String[]{"public"}, classInstance);
            _assertEquals(name, getMethodOutput,
                    "You have modified the provided " + getNameMethodName + " method on the " + className + " class. Please revert it to the original state.");
            assertTrue(testClass.hasMethod(getSecretMethodName, null, String.class, new String[]{"public"}),
                    String.format("You have modified the provided %s method. Please revert it to the original state.", getSecretMethodName));
            getMethodOutput = testClass.callMethod(getSecretMethodName, new String[]{"public"}, classInstance);
            _assertEquals(secret, getMethodOutput,
                    "You have modified the provided " + getSecretMethodName + " method on the " + className + " class. Please revert it to the original state.");
        }

    }

    private static Stream<Arguments> hearSecretInputProvider() {
        return Stream.of(
                Arguments.of("Sam", "Sam always cheat on exams", new String[]{"Bob", "Ali"}, new String[]{"Bob"}, new String[]{"Bob has a candy"}),
                Arguments.of("John", "John is in love with Alice", new String[]{"Alice", "Bob"}, new String[]{"Alice", "Bob"}, new String[]{"Alice is in love with John", "Bob sleeps in class"}),
                Arguments.of("Kim", "Kim has broken her leg", new String[]{"Ali", "John"}, new String[]{"John"}, new String[]{"John broke Kim's leg"}),
                Arguments.of("Sam", "Sam always cheat on exams", new String[]{"Bob", "Ali"}, new String[]{"John"}, new String[]{"Bob has a candy"}),
                Arguments.of("John", "John is in love with Alice", new String[]{"Alice", "Bob", "Sam", "Tom", "Sara", "Jack", "Neil"}, new String[]{"Sam", "Tom", "Sara", "Jack", "Neil"}, new String[]{"Alice is in love with John", "Tom is Tom", "terrified of spiders", "designs bridges", "has no self-confidence"}),
                Arguments.of("Kim", "Kim has broken her leg", new String[]{"Ali", "John", "Alice", "Bob", "Sam", "Neil", "Jack", "Tom", "Sara"}, new String[]{"Ali"}, new String[]{"Ali broke Kim's leg"})

        );
    }

    @Test
    public void hearSecretIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(hearSecretMethodName, new Class<?>[]{String.class, String.class}), String.format(incorrectMethodDefinition, hearSecretMethodName, className));
        assertTrue(testClass.hasModifier(hearSecretMethodName, new Class<?>[]{String.class, String.class}, "public"), String.format(incorrectModifierMessage, hearSecretMethodName, className));
        assertTrue(testClass.hasReturnType(hearSecretMethodName, new Class<?>[]{String.class, String.class}, Void.TYPE), String.format(incorrectReturnType, hearSecretMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("hearSecretInputProvider")
    @Tag("dependent1")
    public void correctHearSecretMethod(String name, String secret, String[] allFriends, String[] friend, String[] friendSecret) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {secret, String.class},
                {allFriends, String[].class}
        };
        Object[][] methodArguments = {
                {friend[0], String.class},
                {friendSecret[0], String.class}
        };
        assertTrue(testClass.hasMethod(hearSecretMethodName, new Class<?>[]{String.class, String.class}),
                "Your " + hearSecretMethodName + " method does not have the correct name or arguments.");
        assertTrue(testClass.hasMethod(hearSecretMethodName, new Class<?>[]{String.class, String.class}, Void.TYPE),
                "Your " + hearSecretMethodName + " method does not have the correct return type.");
        assertTrue(testClass.hasMethod(hearSecretMethodName, new Class<?>[]{String.class, String.class}, Void.TYPE, new String[]{"public"}),
                "Your " + hearSecretMethodName + " method does not have the correct modifier.");
        String[] ans = new String[allFriends.length];
        for (int i = 0; i < allFriends.length; i++) {
            if (friend[0].equals(allFriends[i]))
                ans[i] = friendSecret[0];
        }
        Object classInstance = testClass.createInstance(arguments);
        testClass.callMethod(hearSecretMethodName, methodArguments, new String[]{"public"}, classInstance);
        _assertArrayEquals(ans, testClass.getFieldValue(classInstance, friendSecretsAttributeName),
                "Your " + hearSecretMethodName + " method does not change the " + friendSecretsAttributeName + " attribute correctly.");
    }

    @Test
    public void writeInDiaryIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(writeInDiaryMethodName, null), String.format(incorrectMethodDefinition, writeInDiaryMethodName, className));
        assertTrue(testClass.hasModifier(writeInDiaryMethodName, null, "public"), String.format(incorrectModifierMessage, writeInDiaryMethodName, className));
        assertTrue(testClass.hasReturnType(writeInDiaryMethodName, null, Void.TYPE), String.format(incorrectReturnType, writeInDiaryMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("hearSecretInputProvider")
    @Tag("dependent1")
    public void correctWriteInDiaryMethod(String name, String secret, String[] allFriends, String[] friend, String[] friendSecret) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {secret, String.class},
                {allFriends, String[].class}
        };
        assertTrue(testClass.hasMethod(writeInDiaryMethodName, null),
                "Your " + writeInDiaryMethodName + " method does not have the correct name of arguments.");
        assertTrue(testClass.hasMethod(writeInDiaryMethodName, null, Void.TYPE),
                "Your " + writeInDiaryMethodName + " method does not have the correct return type.");
        assertTrue(testClass.hasMethod(writeInDiaryMethodName, null, Void.TYPE, new String[]{"public"}),
                "Your " + writeInDiaryMethodName + " method does not have the correct modifier.");

        Object classInstance = testClass.createInstance(arguments);
        String[] friendNames = (String[]) testClass.getFieldValue(classInstance, "friendNames");
        String[] friendSecrets = (String[]) testClass.getFieldValue(classInstance, "friendSecrets");
        for (int j = 0; j < friend.length; j++) {
            for (int i = 0; i < friendNames.length; i++)
                if (friendNames[i].equals(friend[j])) {
                    friendSecrets[i] = friendSecret[j];
                    break;
                }
        }

        boolean flg = false;
        for (String s : friend) {
            for (String allFriend : allFriends) {
                if (s.equals(allFriend)) {
                    flg = true;
                    break;
                }
            }
        }

        testClass.setFieldValue(classInstance, friendSecrets, "friendSecrets");
        if (flg) {
            Clause[] c = new Clause[3 + (friendSecret.length) * 4];
            c[0] = new StringLiteral("I have the following secrets:");
            c[1] = new Optional(new StringLiteral(" "));
            c[2] = new NewLine();
            for (int x = 0; x < friendSecret.length; x++) {
                c[4 * x + 3] = new StringLiteral(friend[x] + " told me " + friendSecret[x]);
                c[4 * x + 4] = new Optional(new StringLiteral("."));
                c[4 * x + 5] = new Optional(new StringLiteral(" "));
                c[4 * x + 6] = new NewLine();
            }
            testClass.callMethod(writeInDiaryMethodName, null, new String[]{"public"}, classInstance, c, String.format("Your %s method does not print the correct output.", writeInDiaryMethodName));
        } else {
            testClass.callMethod(writeInDiaryMethodName, null, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("I have the following secrets:"),
                    new Optional(new StringLiteral(" "))
            }, String.format("Your %s method does not print the correct output.", writeInDiaryMethodName));
        }

    }

    @ParameterizedTest
    @MethodSource("hearSecretInputProvider")
    public void personMethodsWorkCorrectlyTogether(String name, String secret, String[] allFriends, String[] friend, String[] friendSecret) throws Throwable {
        assertTrue(testClass.hasMethod(hearSecretMethodName, new Class<?>[]{String.class, String.class}),
                "Your " + hearSecretMethodName + " method does not have the correct name or arguments.");
        assertTrue(testClass.hasMethod(hearSecretMethodName, new Class<?>[]{String.class, String.class}, Void.TYPE),
                "Your " + hearSecretMethodName + " method does not have the correct return type.");
        assertTrue(testClass.hasMethod(hearSecretMethodName, new Class<?>[]{String.class, String.class}, Void.TYPE, new String[]{"public"}),
                "Your " + hearSecretMethodName + " method does not have the correct modifier.");

        assertTrue(testClass.hasMethod(writeInDiaryMethodName, null),
                "Your " + writeInDiaryMethodName + " method does not have the correct name of arguments.");
        assertTrue(testClass.hasMethod(writeInDiaryMethodName, null, Void.TYPE),
                "Your " + writeInDiaryMethodName + " method does not have the correct return type.");
        assertTrue(testClass.hasMethod(writeInDiaryMethodName, null, Void.TYPE, new String[]{"public"}),
                "Your " + writeInDiaryMethodName + " method does not have the correct modifier.");

        Object[][] arguments = {
                {name, String.class},
                {secret, String.class},
                {allFriends, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] ans = new String[allFriends.length];

        for (int x = 0; x < friendSecret.length; x++) {
            Object[][] methodArguments = {
                    {friend[x], String.class},
                    {friendSecret[x], String.class}
            };

            for (int i = 0; i < allFriends.length; i++) {
                if (friend[x].equals(allFriends[i]))
                    ans[i] = friendSecret[x];
            }
            testClass.callMethod(hearSecretMethodName, methodArguments, new String[]{"public"}, classInstance);
            _assertArrayEquals(ans, testClass.getFieldValue(classInstance, friendSecretsAttributeName),
                    "Your " + hearSecretMethodName + " method does not change the " + friendSecretsAttributeName + " attribute correctly.");
        }

        boolean flg = false;
        for (String s : friend) {
            for (String allFriend : allFriends) {
                if (s.equals(allFriend)) {
                    flg = true;
                    break;
                }
            }
        }

        if (flg) {
            Clause[] c = new Clause[3 + (friendSecret.length) * 4];
            c[0] = new StringLiteral("I have the following secrets:");
            c[1] = new Optional(new StringLiteral(" "));
            c[2] = new NewLine();
            for (int x = 0; x < friendSecret.length; x++) {
                c[4 * x + 3] = new StringLiteral(friend[x] + " told me " + friendSecret[x]);
                c[4 * x + 4] = new Optional(new StringLiteral("."));
                c[4 * x + 5] = new Optional(new StringLiteral(" "));
                c[4 * x + 6] = new NewLine();
            }
            testClass.callMethod(writeInDiaryMethodName, null, new String[]{"public"}, classInstance, c, String.format("Your %s method does not print the correct output after calling the %s method.", writeInDiaryMethodName, hearSecretMethodName));
        } else {
            testClass.callMethod(writeInDiaryMethodName, null, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("I have the following secrets:"),
                    new Optional(new StringLiteral(" "))
            }, String.format("Your %s method does not print the correct output after calling the %s method.", writeInDiaryMethodName, hearSecretMethodName));
        }
    }

    @Test
    @Tag("dependency1")
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
                clauses,
                "Your main method in " + testClassName + " class does not print the correct output, make sure the objects are initialized, modified, and printed correctly.");
    }
}
