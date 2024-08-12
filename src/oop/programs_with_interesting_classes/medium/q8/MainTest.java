package oop.programs_with_interesting_classes.medium.q8;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    /* Parsons Question */
    private ObjectTest food;
    private ObjectTest fridge;
    private ObjectTest testSmartFoodManagement;
    private final String foodClassName = "Food";
    private final String fridgeClassName = "Fridge";
    private final String testSmartFoodManagementClassName = "TestSmartFoodManagement";
    private final String stringAttributeName = "name";
    private final String intAttributeName = "daysToExpiration";
    private final String foodArrayAttributeName = "items";
    private final String doubleAttributeName = "currTemperature";
    private final String getNameMethodName = "getName";
    private final String getDaysToExpirationMethodName = "getDaysToExpiration";
    private final String increaseExpirationLengthMethodName = "increaseExpirationLength";
    private final String decreaseExpirationLengthMethodName = "decreaseExpirationLength";
    private final String getItemsMethodName = "getItems";
    private final String decreaseTemperatureMethodName = "decreaseTemperature";
    private final String increaseTemperatureMethodName = "increaseTemperature";
    private final String getNextToExpireMethodName = "getNextToExpire";
    private final double temperatureChange = 10;
    private final int expirationChange = 1;
    private final String expectedToString = "%s will expire in %s days";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.medium.q8.";
        food = new ObjectTest(packageString + foodClassName);
        fridge = new ObjectTest(packageString + fridgeClassName);
        testSmartFoodManagement = new ObjectTest(packageString + testSmartFoodManagementClassName);
    }

    /* Test if the food class has the required attributes */

    @Test
    public void foodClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(food.hasField(stringAttributeName), String.format(missingAttribute, foodClassName, stringAttributeName));
        assertTrue(food.hasField(stringAttributeName, String.class), String.format(incorrectType, stringAttributeName));
        assertTrue(food.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(food.hasField(intAttributeName), String.format(missingAttribute, foodClassName, intAttributeName));
        assertTrue(food.hasField(intAttributeName, int.class), String.format(incorrectType, intAttributeName));
        assertTrue(food.hasModifier(intAttributeName, "private"), String.format(incorrectModifier, intAttributeName));
    }

    /* Test Food Constructor */

    private static Stream<Arguments> foodConstructorInputProvider() {
        return Stream.of(
                Arguments.of("pizza", 15),
                Arguments.of("", 3412),
                Arguments.of("mushrooms", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("foodConstructorInputProvider")
    public void foodClassHasRequiredConstructor(String name, int expiration) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, int.class};
        assertTrue(food.hasConstructor(constructorParameters), String.format(missingConstructor, foodClassName));
        assertTrue(food.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, foodClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        Object[][] constructorArguments = {
                {name, String.class},
                {expiration, int.class}
        };
        Object foodInstance = food.createInstance(constructorArguments);
        _assertEquals(name, food.getFieldValue(foodInstance, stringAttributeName), String.format(incorrectValue, foodClassName, stringAttributeName));
        _assertEquals(expiration, food.getFieldValue(foodInstance, intAttributeName), String.format(incorrectValue, foodClassName, intAttributeName));
    }

    /* Test Food Methods */

    private static Stream<String> getNameInputProvider() {
        return Stream.of("Whey", "Maple Syrup", "123 Sauce", "");
    }

    @ParameterizedTest
    @MethodSource("getNameInputProvider")
    public void correctGetNameMethod(String name) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(food.hasMethod(getNameMethodName, null),
                String.format(incorrectDefinition, foodClassName, getNameMethodName));
        assertTrue(food.hasModifier(getNameMethodName, null, "public"),
                String.format(incorrectModifier, getNameMethodName));
        assertTrue(food.hasReturnType(getNameMethodName, null, String.class),
                String.format(incorrectReturnType, getNameMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {name, String.class},
                {30, int.class}
        };
        Object foodInstance = food.createInstance(constructorArguments);

        /* Call getName on food */
        Object getNameOutput = food.callMethod(getNameMethodName, foodInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(name, getNameOutput, String.format(incorrectUpdate, getNameMethodName, stringAttributeName));
    }

    private static Stream<Integer> getDaysToExpirationInputProvider() {
        return Stream.of(0, 1, 2, 5, 10, 44325);
    }

    @ParameterizedTest
    @MethodSource("getDaysToExpirationInputProvider")
    public void correctGetDaysToExpirationMethod(int days) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(food.hasMethod(getDaysToExpirationMethodName, null),
                String.format(incorrectDefinition, foodClassName, getDaysToExpirationMethodName));
        assertTrue(food.hasModifier(getDaysToExpirationMethodName, null, "public"),
                String.format(incorrectModifier, getDaysToExpirationMethodName));
        assertTrue(food.hasReturnType(getDaysToExpirationMethodName, null, int.class),
                String.format(incorrectReturnType, getDaysToExpirationMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {days, int.class}
        };
        Object foodInstance = food.createInstance(constructorArguments);

        /* Call getDaysToExpiration on food */
        Object getDaysToExpirationOutput = food.callMethod(getDaysToExpirationMethodName, foodInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(days, getDaysToExpirationOutput, String.format(incorrectUpdate, getDaysToExpirationMethodName, intAttributeName));
    }

    @Test
    public void correctIncreaseExpirationLengthMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(food.hasMethod(increaseExpirationLengthMethodName, null),
                String.format(incorrectDefinition, foodClassName, increaseExpirationLengthMethodName));
        assertTrue(food.hasModifier(increaseExpirationLengthMethodName, null, "public"),
                String.format(incorrectModifier, increaseExpirationLengthMethodName));
        assertTrue(food.hasReturnType(increaseExpirationLengthMethodName, null, Void.TYPE),
                String.format(incorrectReturnType, increaseExpirationLengthMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {20, int.class}
        };
        Object foodInstance = food.createInstance(constructorArguments);

        /* Call increaseExpirationLength on food */
        food.callMethod(increaseExpirationLengthMethodName, foodInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly increase the value of the %s attribute.";
        _assertEquals(20 + expirationChange, food.getFieldValue(foodInstance, intAttributeName), String.format(incorrectUpdate, increaseExpirationLengthMethodName, intAttributeName));
    }

    @Test
    public void correctDecreaseExpirationLengthMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(food.hasMethod(decreaseExpirationLengthMethodName, null),
                String.format(incorrectDefinition, foodClassName, decreaseExpirationLengthMethodName));
        assertTrue(food.hasModifier(decreaseExpirationLengthMethodName, null, "public"),
                String.format(incorrectModifier, decreaseExpirationLengthMethodName));
        assertTrue(food.hasReturnType(decreaseExpirationLengthMethodName, null, Void.TYPE),
                String.format(incorrectReturnType, decreaseExpirationLengthMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {20, int.class}
        };
        Object foodInstance = food.createInstance(constructorArguments);

        /* Call increaseExpirationLength on food */
        food.callMethod(decreaseExpirationLengthMethodName, foodInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly increase the value of the %s attribute.";
        _assertEquals(20 - expirationChange, food.getFieldValue(foodInstance, intAttributeName), String.format(incorrectUpdate, decreaseExpirationLengthMethodName, intAttributeName));
    }

    private static Stream<Arguments> toStringInputProvider() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("Orange", 1),
                Arguments.of("Black Licorice", 60),
                Arguments.of("Twinkies", 38921)
        );
    }

    @ParameterizedTest
    @MethodSource("toStringInputProvider")
    public void correctToStringMethod(String name, int days) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(food.hasMethod("toString", null),
                String.format(incorrectDefinition, foodClassName, "toString"));
        assertTrue(food.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(food.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {name, String.class},
                {days, int.class}
        };
        Object foodInstance = food.createInstance(constructorArguments);

        /* Test output */
        String expectedOutput = String.format(expectedToString, name, days);
        Object actualOutput = food.callMethod("toString", foodInstance);
        _assertEquals(expectedOutput, actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    /* Test if the fridge class has the required attributes */

    @Test
    public void fridgeClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(fridge.hasField(foodArrayAttributeName), String.format(missingAttribute, fridgeClassName, foodArrayAttributeName));
        assertTrue(fridge.hasField(foodArrayAttributeName, food.getObjectArrayClass()), String.format(incorrectType, foodArrayAttributeName));
        assertTrue(fridge.hasModifier(foodArrayAttributeName, "private"), String.format(incorrectModifier, foodArrayAttributeName));
        assertTrue(fridge.hasField(doubleAttributeName), String.format(missingAttribute, fridgeClassName, doubleAttributeName));
        assertTrue(fridge.hasField(doubleAttributeName, double.class), String.format(incorrectType, doubleAttributeName));
        assertTrue(fridge.hasModifier(doubleAttributeName, "private"), String.format(incorrectModifier, doubleAttributeName));
    }

    /* Test Fridge Constructor */

    private static Stream<Arguments> fridgeConstructorInputProvider() {
        return Stream.of(
                Arguments.of(1, new Object[][][]{{{"Apples", String.class}, {10, int.class}}}, 15.234),
                Arguments.of(0, new Object[][][]{{{}}}, 3412.23),
                Arguments.of(4, new Object[][][]{{{"Yogurt", String.class}, {5, int.class}}, {{"Cheese", String.class}, {372, int.class}},
                        {{"Strawberries", String.class}, {23, int.class}}, {{"Dragonfruit", String.class}, {0, int.class}}}, 0.00)
        );
    }

    @ParameterizedTest
    @MethodSource("fridgeConstructorInputProvider")
    public void fridgeClassHasRequiredConstructor(int size, Object[][][] arguments, double temp) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{food.getObjectArrayClass(), double.class};
        assertTrue(fridge.hasConstructor(constructorParameters), String.format(missingConstructor, fridgeClassName));
        assertTrue(fridge.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, fridgeClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        String incorrectArray = "Your %s constructor does not initialize the %s array to the correct value.";

        Object[] foodHold = (Object[]) food.createArray(size, arguments);

        Object[][] constructorArguments = {
                {foodHold, food.getObjectArrayClass()},
                {temp, double.class}
        };
        Object fridgeInstance = fridge.createInstance(constructorArguments);
        _assertEquals(temp, fridge.getFieldValue(fridgeInstance, doubleAttributeName), String.format(incorrectValue, fridgeClassName, doubleAttributeName));
        _assertArrayEquals(foodHold, fridge.getFieldValue(fridgeInstance, foodArrayAttributeName), String.format(incorrectArray, fridgeClassName, foodArrayAttributeName));
    }

    /* Test Fridge Methods */

    private static Stream<Arguments> getItemsInputProvider() {
        return Stream.of(
                Arguments.of(0, new Object[][][]{{{}}}),
                Arguments.of(1, new Object[][][]{{{"Apple", String.class}, {1, int.class}}}),
                Arguments.of(2, new Object[][][]{{{"Cheese", String.class}, {15, int.class}}, {{"Beef", String.class}, {5, int.class}}}),
                Arguments.of(5, new Object[][][]{{{"Leek", String.class}, {3749, int.class}}, {{"Pho", String.class}, {3, int.class}},
                        {{"Clementine", String.class}, {37, int.class}}, {{"Hollandaise", String.class}, {1, int.class}},
                        {{"Perch", String.class}, {1389247, int.class}}})
        );
    }

    @ParameterizedTest
    @MethodSource("getItemsInputProvider")
    public void correctGetItemsMethod(int size, Object[][][] arguments) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(fridge.hasMethod(getItemsMethodName, null),
                String.format(incorrectDefinition, fridgeClassName, getItemsMethodName));
        assertTrue(fridge.hasModifier(getItemsMethodName, null, "public"),
                String.format(incorrectModifier, getItemsMethodName));
        assertTrue(fridge.hasReturnType(getItemsMethodName, null, food.getObjectArrayClass()),
                String.format(incorrectReturnType, getItemsMethodName));

        Object[] holdFood = (Object[]) food.createArray(size, arguments);

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {holdFood, food.getObjectArrayClass()},
                {15.5, double.class}
        };
        Object fridgeInstance = fridge.createInstance(constructorArguments);

        /* Call getItems on fridge */
        Object getItemsOutput = fridge.callMethod(getItemsMethodName, fridgeInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertArrayEquals(holdFood, getItemsOutput,
                String.format(incorrectUpdate, getItemsMethodName, foodArrayAttributeName));
    }

    @Test
    public void correctDecreaseTemperatureMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(fridge.hasMethod(decreaseTemperatureMethodName, null),
                String.format(incorrectDefinition, fridgeClassName, decreaseTemperatureMethodName));
        assertTrue(fridge.hasModifier(decreaseTemperatureMethodName, null, "public"),
                String.format(incorrectModifier, decreaseTemperatureMethodName));
        assertTrue(fridge.hasReturnType(decreaseTemperatureMethodName, null, Void.TYPE),
                String.format(incorrectReturnType, decreaseTemperatureMethodName));

        Object[] holdFood = (Object[]) food.createArray(5, new Object[][]{{"Apple", String.class}, {3, int.class}});

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {holdFood, food.getObjectArrayClass()},
                {15.5, double.class}
        };
        Object fridgeInstance = fridge.createInstance(constructorArguments);

        /* Call getItems on fridge */
        fridge.callMethod(decreaseTemperatureMethodName, fridgeInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not cause the increase of the value of the %s attributes in the %s array.";
        for (Object o : holdFood) {
            assertEquals("Apple will expire in 4 days", o.toString(), String.format(incorrectUpdate, decreaseTemperatureMethodName, intAttributeName, foodArrayAttributeName));
        }
        assertEquals(15.5 - temperatureChange, fridge.getFieldValue(fridgeInstance, doubleAttributeName),
                "Your " + decreaseExpirationLengthMethodName + " method does not decrease the " + doubleAttributeName + " attribute.");
    }

    @Test
    public void correctIncreaseTemperatureMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(fridge.hasMethod(increaseTemperatureMethodName, null),
                String.format(incorrectDefinition, fridgeClassName, increaseTemperatureMethodName));
        assertTrue(fridge.hasModifier(increaseTemperatureMethodName, null, "public"),
                String.format(incorrectModifier, increaseTemperatureMethodName));
        assertTrue(fridge.hasReturnType(increaseTemperatureMethodName, null, Void.TYPE),
                String.format(incorrectReturnType, increaseTemperatureMethodName));

        Object[] holdFood = (Object[]) food.createArray(5, new Object[][]{{"Apple", String.class}, {3, int.class}});

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {holdFood, food.getObjectArrayClass()},
                {15.5, double.class}
        };
        Object fridgeInstance = fridge.createInstance(constructorArguments);

        /* Call getItems on fridge */
        fridge.callMethod(increaseTemperatureMethodName, fridgeInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not cause the increase of the value of the %s attributes in the %s array.";
        for (Object o : holdFood) {
            assertEquals("Apple will expire in 2 days", o.toString(), String.format(incorrectUpdate, increaseTemperatureMethodName, intAttributeName, foodArrayAttributeName));
        }
        assertEquals(15.5 + temperatureChange, fridge.getFieldValue(fridgeInstance, doubleAttributeName),
                "Your " + increaseTemperatureMethodName + " method does not decrease the " + doubleAttributeName + " attribute.");
    }

    private static Stream<Arguments> getNextToExpireInputProvider() {
        return Stream.of(
                Arguments.of(0, new Object[][][]{{{}}}, -1),
                Arguments.of(1, new Object[][][]{{{"Apple", String.class}, {1, int.class}}}, 0),
                Arguments.of(2, new Object[][][]{{{"Cheese", String.class}, {15, int.class}}, {{"Beef", String.class}, {5, int.class}}}, 1),
                Arguments.of(5, new Object[][][]{{{"Leek", String.class}, {3749, int.class}}, {{"Pho", String.class}, {3, int.class}},
                        {{"Clementine", String.class}, {37, int.class}}, {{"Hollandaise", String.class}, {1, int.class}},
                        {{"Perch", String.class}, {89247, int.class}}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getNextToExpireInputProvider")
    public void correctGetNextToExpireMethod(int size, Object[][][] arguments, int index) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(fridge.hasMethod(getNextToExpireMethodName, null),
                String.format(incorrectDefinition, fridgeClassName, getNextToExpireMethodName));
        assertTrue(fridge.hasModifier(getNextToExpireMethodName, null, "public"),
                String.format(incorrectModifier, getNextToExpireMethodName));
        assertTrue(fridge.hasReturnType(getNextToExpireMethodName, null, food.getObjectClass()),
                String.format(incorrectReturnType, getNextToExpireMethodName));

        Object[] holdFood = (Object[]) food.createArray(size, arguments);

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {holdFood, food.getObjectArrayClass()},
                {15.5, double.class}
        };
        Object fridgeInstance = fridge.createInstance(constructorArguments);

        /* Call getNextToExpire on fridge */
        Object getNextToExpireOutput = fridge.callMethod(getNextToExpireMethodName, fridgeInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s next to expire.";
        if (index != -1)
            _assertEquals(holdFood[index], getNextToExpireOutput,
                    String.format(incorrectUpdate, getNextToExpireMethodName, foodClassName));
        else
            assertNull(getNextToExpireOutput,
                    "Your " + getNextToExpireMethodName + " method does not return the correct output for an empty " + fridgeClassName + ".");
    }

    @Test
    public void collisionHasCorrectMainMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the main method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "Your main method does not have the correct visibility modifier.";
        String incorrectReturnType = "Your main method does not have the correct return type.";
        String incorrectStatic = "Your main method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(testSmartFoodManagement.hasMethod("main", methodClassParameters),
                String.format(incorrectDefinition, testSmartFoodManagementClassName));
        assertTrue(testSmartFoodManagement.hasModifier("main", methodClassParameters, "public"),
                incorrectModifier);
        assertTrue(testSmartFoodManagement.hasReturnType("main", methodClassParameters, Void.TYPE),
                incorrectReturnType);
        assertTrue(testSmartFoodManagement.hasModifier("main", methodClassParameters, "static"),
                incorrectStatic);

        Clause[] output = {
                new StringLiteral(Pattern.quote("[Apples will expire in 20 days, Bananas will expire in 10 days, Tomatoes will expire in 7 days, Ketchup will expire in 180 days, Chicken will expire in 4 days]")),
                new NewLine(),
                new StringLiteral(Pattern.quote("Quickly! The Chicken will go bad in 4 days!")),
                new NewLine(),
                new StringLiteral(Pattern.quote("Now the Chicken will go bad in 5 days instead!"))
        };
        String incorrectOutput = "Your main method in the %s class did not print the correct output. Make sure you print the toString output and call the %s and %s methods";
        Object[][] mainArgs = {{new String[0], String[].class}};
        testSmartFoodManagement.callMethod("main", mainArgs, output, String.format(incorrectOutput, testSmartFoodManagementClassName, getNextToExpireMethodName, decreaseTemperatureMethodName));
    }
}
