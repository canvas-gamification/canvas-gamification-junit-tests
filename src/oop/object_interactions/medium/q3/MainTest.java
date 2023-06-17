package oop.object_interactions.medium.q3;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest testClass;
    private ObjectTest classObject;
    private final String className = "Newspaper";
    private final String testClassName = "TestNewspaper";
    private final String myYearAttributeName = "myYear";
    private final String myMonthAttributeName = "myMonth";
    private final String myDayAttributeName = "myDay";
    private final String myStoryAttributeName = "myStory";
    private final String getMyYearMethodName = "getMyYear";
    private final String getMyMonthMethodName = "getMyMonth";
    private final String getMyDayMethodName = "getMyDay";
    private final String getMyStoryMethodName = "getMyStory";
    private final String makeCopyMethodName = "makeCopy";

    @BeforeEach
    public void setup() throws Throwable {
        String classString = "oop.object_interactions.medium.q3." + className;
        String testClassString = "oop.object_interactions.medium.q3." + testClassName;
        testClass = new ObjectTest(classString);
        classObject = new ObjectTest(testClassString);
        assertTrue(testClass.hasModifier("public"),
                "You have changed the visibility modifier on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasField(myYearAttributeName, int.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", myYearAttributeName));
        assertTrue(testClass.hasField(myMonthAttributeName, int.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", myMonthAttributeName));
        assertTrue(testClass.hasField(myDayAttributeName, int.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", myDayAttributeName));
        assertTrue(testClass.hasField(myStoryAttributeName, String.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", myStoryAttributeName));
        assertTrue(testClass.hasConstructor(null, new String[]{"public"}),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        Object classInstance = testClass.createInstance();
        _assertEquals(-1, testClass.getFieldValue(classInstance, myYearAttributeName),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        _assertEquals(-1, testClass.getFieldValue(classInstance, myMonthAttributeName),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        _assertEquals(-1, testClass.getFieldValue(classInstance, myDayAttributeName),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        _assertEquals("", testClass.getFieldValue(classInstance, myStoryAttributeName),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");

        assertTrue(testClass.hasMethod(getMyYearMethodName, null, int.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getMyYearMethodName));
        assertTrue(testClass.hasMethod(getMyMonthMethodName, null, int.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getMyMonthMethodName));
        assertTrue(testClass.hasMethod(getMyDayMethodName, null, int.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getMyDayMethodName));
        assertTrue(testClass.hasMethod(getMyStoryMethodName, null, String.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getMyStoryMethodName));

    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(2020, 5, 17, "It's a new day!"),
                Arguments.of(2017, 4, 3, "A new brand of car is out!"),
                Arguments.of(2023, 4, 5, "The classes are cancelled!")
        );
    }

    @Test
    public void newspaperClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, int.class, int.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void newspaperClassHasCorrectConstructor(int year, int month, int day, String story) throws Throwable {
        Object[][] arguments = {
                {year, int.class},
                {month, int.class},
                {day, int.class},
                {story, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(year, testClass.getFieldValue(classInstance, myYearAttributeName),
                "Your " + className + " constructor does not correctly initialize the " + myYearAttributeName + " attribute.");
        _assertEquals(month, testClass.getFieldValue(classInstance, myMonthAttributeName),
                "Your " + className + " constructor does not correctly initialize the " + myMonthAttributeName + " attribute.");
        _assertEquals(day, testClass.getFieldValue(classInstance, myDayAttributeName),
                "Your " + className + " constructor does not correctly initialize the " + myDayAttributeName + " attribute.");
        _assertEquals(story, testClass.getFieldValue(classInstance, myStoryAttributeName),
                "Your " + className + " constructor does not correctly initialize the " + myStoryAttributeName + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctHearSecretMethod(int year, int month, int day, String story) throws Throwable {
        Object classInstance = testClass.createInstance();
        Object[][] methodArguments = {
                {new Newspaper(year, month, day, story), Newspaper.class}
        };
        Object output = testClass.callMethod(makeCopyMethodName, methodArguments, new String[]{"public"}, classInstance);
        _assertEquals(year, testClass.getFieldValue(classInstance, myYearAttributeName),
                "Your " + makeCopyMethodName + " method does not make a copy of the " + myYearAttributeName + " attribute correctly.");
        _assertEquals(month, testClass.getFieldValue(classInstance, myMonthAttributeName),
                "Your " + makeCopyMethodName + " method does not make a copy of the " + myMonthAttributeName + " attribute correctly.");
        _assertEquals(day, testClass.getFieldValue(classInstance, myDayAttributeName),
                "Your " + makeCopyMethodName + " method does not make a copy of the " + myDayAttributeName + " attribute correctly.");
        _assertEquals(story, testClass.getFieldValue(classInstance, myStoryAttributeName),
                "Your " + makeCopyMethodName + " method does not make a copy of the " + myStoryAttributeName + " attribute correctly.");
        assertNull(output, String.join(" ", "Your", makeCopyMethodName, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void newspaperClassHasCorrectToStringMethod(int year, int month, int day, String story) throws Throwable {
        Object[][] arguments = {
                {year, int.class},
                {month, int.class},
                {day, int.class},
                {story, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = year + "/" + month + "/" + day + ":The story is: " + story;
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("2021/12/5:The story is: The votes are in!"),
                new Optional(new StringLiteral(" "))
        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses);
    }
}
