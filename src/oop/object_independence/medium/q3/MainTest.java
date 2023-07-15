package oop.object_independence.medium.q3;

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

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    // Java
    private final String className = "Cocktail";
    private final String outputClassName = "TestRecipe";
    private ObjectTest testClass;
    private ObjectTest outputClass;
    private final String firstFieldName = "ingredients";
    private final String getFirstField = "getIngredients";
    private final String setFirstField = "setIngredients";
    private final String[] outputNum1 = new String[]{"Pineapple Juice", "Coconut Milk"};
    private final String[] outputNum2 = new String[]{"Apple Juice", "Almond Milk"};

    @Test
    public void correctTestClass() throws Throwable {
        Clause[] c = new Clause[outputNum1.length + outputNum2.length + 3];
        int t = 0;
        c[t++] = new StringLiteral("My ingredients are: ");
        for (int i = 0; i < outputNum1.length; i++)
            c[t++] = new StringLiteral(outputNum1[i] + " ");
        c[t++] = new NewLine();
        c[t++] = new StringLiteral("My ingredients are: ");
        for (int i = 0; i < outputNum2.length; i++)
            c[t++] = new StringLiteral(outputNum2[i] + " ");
        Object[][] arguments = {
                {new String[0], String[].class}
        };
        String incorrectMethodOutputMessage = "Your main method in the " + outputClassName + " class does not print the correct output.";
        outputClass.callMethod("main", arguments, c, incorrectMethodOutputMessage);
    }

    @BeforeEach
    public void setUp() {
        String classString = "oop.object_independence.medium.q3." + className;
        String testClassString = "oop.object_independence.medium.q3." + outputClassName;
        testClass = new ObjectTest(classString);
        outputClass = new ObjectTest(testClassString);
    }

    @Test
    public void cocktailClassHasRequiredFields() {
        assertTrue(testClass.hasField(firstFieldName, String[].class),
                "Your " + className + " class is missing the " + firstFieldName + " attribute.");
        assertTrue(testClass.hasModifier(firstFieldName, "private"),
                "Your " + firstFieldName + " does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"Pineapple Juice", "Coconut Milk"}),
                Arguments.of((Object) new String[]{"Apple Juice", "Almond Milk"}),
                Arguments.of((Object) new String[]{"Ginger Beer", "Lime", "Vodka"}),
                Arguments.of((Object) new String[]{"Rum", "StrawBerry", "Syrup"}),
                Arguments.of((Object) new String[]{"Rum", "Coke"}),
                Arguments.of((Object) new String[]{"Gin", "Tonic"})
        );
    }

    @Test
    public void cocktailClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String[].class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void cocktailClassHasCorrectConstructor(String[] value) throws Throwable {
        Object[][] arguments = {
                {value, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertArrayEquals(value, testClass.getFieldValue(classInstance, firstFieldName),
                "Your " + className + " constructor does not correctly initialize the " + firstFieldName + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void cocktailClassHasCorrectGetIngredientsMethod(String[] value) throws Throwable {
        Object[][] arguments = {
                {value, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getFirstField, "method does not correctly get the value of the", firstFieldName, "attribute.");
        Object getMethodOutput = testClass.callMethod(getFirstField, getMethodModifiers, classInstance);
        _assertArrayEquals(value, getMethodOutput, incorrectGetMethodMessage);
    }

    private static Stream<Arguments> set1InputProvider() {
        return Stream.of(
                Arguments.of(new String[]{"Pineapple Juice", "Coconut Milk"}, new String[]{"Apple Juice", "Almond Milk"}),
                Arguments.of(new String[]{"Gin", "Tonic"}, new String[]{"Ginger Beer", "Lime", "Vodka"}),
                Arguments.of(new String[]{"Rum", "StrawBerry", "Syrup"}, new String[]{"Rum", "Coke"})
        );
    }


    @ParameterizedTest
    @MethodSource("set1InputProvider")
    public void cocktailClassHasCorrectSetIngrediantsMethod(String[] value, String[] update) throws Throwable {
        Object[][] arguments = {
                {value, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setArguments = {
                {update, String[].class}
        };
        String[] setMethodModifiers = {"public"};
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setFirstField, "method does not correctly set the value of the", firstFieldName, "attribute.");
        Object setMethodOutput = testClass.callMethod(setFirstField, setArguments, setMethodModifiers, classInstance);
        _assertArrayEquals(update, testClass.getFieldValue(classInstance, firstFieldName), incorrectSetMethodMessage);
        assertNull(setMethodOutput, String.join(" ", "Your", setFirstField, "method should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void cocktailClassHasCorrectToStringMethod(String[] value) throws Throwable {
        Object[][] arguments = {
                {value, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "My ingredients are: ";
        for (int i = 0; i < value.length; i++)
            expected += value[i] + " ";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void cocktailClassMethodsWorkTogether(String[] value) throws Throwable {
        String[] initialValue = new String[]{"Ginger Beer", "Lime", "Vodka"};
        Object[][] arguments = {
                {initialValue, String[].class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertArrayEquals(initialValue, testClass.callMethod(getFirstField, classInstance),
                "Your " + getFirstField + " method does not return the correct value.");
        Object[][] setArguments = {
                {value, String[].class}
        };
        testClass.callMethod(setFirstField, setArguments, classInstance);
        _assertArrayEquals(value, testClass.callMethod(getFirstField, classInstance),
                "Your " + getFirstField + " method does not return the correct value calling the " + setFirstField + " method.");
        String expected = "My ingredients are: ";
        for (int i = 0; i < value.length; i++)
            expected += value[i] + " ";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String after updating the values of its attribute using its setter method.");
        Object output = testClass.callMethod("toString", classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

}
