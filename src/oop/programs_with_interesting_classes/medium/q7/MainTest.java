package oop.programs_with_interesting_classes.medium.q7;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    /* Parsons Question */
    private ObjectTest hotSoup;
    private ObjectTest vendingMachine;
    private ObjectTest lunchRush;
    private final String hotSoupClassName = "HotSoup";
    private final String vendingMachineClassName = "VendingMachine";
    private final String lunchRushClassName = "LunchRush";
    private final String doubleAttributeName = "price";
    private final String stringAttributeName = "flavour";
    private final String hotSoupArrayAttributeName = "items";
    private final String finalIntAttributeName = "CAPACITY";
    private final String intAttributeName = "numAvailable";
    private final String getPriceMethodName = "getPrice";
    private final String getFlavourMethodName = "getFlavour";
    private final String buyItemMethodName = "buyItem";
    private final String getChangeMethodName = "getChange";
    private final String defaultFlavour = "Chicken Noodle";
    private static final double defaultPrice = 2.5;
    private final int defaultCapacity = 50;
    private final String expectedString = "%s soup for $%s";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.medium.q7.";
        hotSoup = new ObjectTest(packageString + hotSoupClassName);
        vendingMachine = new ObjectTest(packageString + vendingMachineClassName);
        lunchRush = new ObjectTest(packageString + lunchRushClassName);
    }

    /* Test if the hot soup class has the required attributes */

    @Test
    public void hotSoupClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(hotSoup.hasField(stringAttributeName), String.format(missingAttribute, hotSoupClassName, stringAttributeName));
        assertTrue(hotSoup.hasField(stringAttributeName, String.class), String.format(incorrectType, stringAttributeName));
        assertTrue(hotSoup.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(hotSoup.hasField(doubleAttributeName), String.format(missingAttribute, hotSoupClassName, doubleAttributeName));
        assertTrue(hotSoup.hasField(doubleAttributeName, double.class), String.format(incorrectType, doubleAttributeName));
        assertTrue(hotSoup.hasModifier(doubleAttributeName, "private"), String.format(incorrectModifier, doubleAttributeName));
    }

    /* Test HotSoup Constructor */

    private static Stream<Arguments> hotSoupConstructorInputProvider() {
        return Stream.of(
                Arguments.of("Chicken Noodle", 15.234),
                Arguments.of("", 3412.23),
                Arguments.of("Tomato", 0.00)
        );
    }

    @ParameterizedTest
    @MethodSource("hotSoupConstructorInputProvider")
    public void hotSoupClassHasRequiredConstructor(String flavour, double price) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{double.class, String.class};
        assertTrue(hotSoup.hasConstructor(constructorParameters), String.format(missingConstructor, hotSoupClassName));
        assertTrue(hotSoup.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, hotSoupClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        Object[][] constructorArguments = {
                {price, double.class},
                {flavour, String.class}
        };
        Object hotSoupInstance = hotSoup.createInstance(constructorArguments);
        _assertEquals(flavour, hotSoup.getFieldValue(hotSoupInstance, stringAttributeName), String.format(incorrectValue, hotSoupClassName, stringAttributeName));
        _assertEquals(price, hotSoup.getFieldValue(hotSoupInstance, doubleAttributeName), String.format(incorrectValue, hotSoupClassName, doubleAttributeName));
    }

    /* Test Car Methods */

    private static Stream<String> getFlavourInputProvider() {
        return Stream.of("Tomato", "Italian Meatball", "SECRET FORMULA 12", "");
    }

    @ParameterizedTest
    @MethodSource("getFlavourInputProvider")
    public void correctGetFlavourMethod(String flavour) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(hotSoup.hasMethod(getFlavourMethodName, null),
                String.format(incorrectDefinition, hotSoupClassName, getFlavourMethodName));
        assertTrue(hotSoup.hasModifier(getFlavourMethodName, null, "public"),
                String.format(incorrectModifier, getFlavourMethodName));
        assertTrue(hotSoup.hasReturnType(getFlavourMethodName, null, String.class),
                String.format(incorrectReturnType, getFlavourMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {30.32, double.class},
                {flavour, String.class}
        };
        Object soupInstance = hotSoup.createInstance(constructorArguments);

        /* Call getFlavour on soup */
        Object getFlavourOutput = hotSoup.callMethod(getFlavourMethodName, soupInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(flavour, getFlavourOutput, String.format(incorrectUpdate, getFlavourMethodName, stringAttributeName));
    }

    private static Stream<Double> getPriceInputProvider() {
        return Stream.of(0.0, 10.234, 403.946, 111.111);
    }

    @ParameterizedTest
    @MethodSource("getPriceInputProvider")
    public void correctGetPriceMethod(double price) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(hotSoup.hasMethod(getPriceMethodName, null),
                String.format(incorrectDefinition, hotSoupClassName, getPriceMethodName));
        assertTrue(hotSoup.hasModifier(getPriceMethodName, null, "public"),
                String.format(incorrectModifier, getPriceMethodName));
        assertTrue(hotSoup.hasReturnType(getPriceMethodName, null, double.class),
                String.format(incorrectReturnType, getPriceMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {price, double.class},
                {"tomato", String.class}
        };
        Object soupInstance = hotSoup.createInstance(constructorArguments);

        /* Call getPrice on car */
        Object getPriceOutput = hotSoup.callMethod(getPriceMethodName, soupInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(price, getPriceOutput, 0.001,
                String.format(incorrectUpdate, getPriceMethodName, doubleAttributeName));
    }

    private static Stream<Arguments> toStringInputProvider() {
        return Stream.of(
                Arguments.of(0.0, "Chicken"),
                Arguments.of(1.457, "tomato and greens"),
                Arguments.of(847.32, "Beef and Broccoli"),
                Arguments.of(2, "")
        );
    }

    @ParameterizedTest
    @MethodSource("toStringInputProvider")
    public void correctToStringMethod(double price, String flavour) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(hotSoup.hasMethod("toString", null),
                String.format(incorrectDefinition, hotSoupClassName, "toString"));
        assertTrue(hotSoup.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(hotSoup.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {price, double.class},
                {flavour, String.class}
        };
        Object soupInstance = hotSoup.createInstance(constructorArguments);

        /* Test output */
        Object actualOutput = hotSoup.callMethod("toString", soupInstance);
        _assertEquals(String.format(expectedString, flavour, price), actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    /* Test if the vending machine class has the required attributes */

    @Test
    public void vendingMachineClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        String incorrectFinalModifier = "Your %s attribute does not have the correct final modifier.";
        assertTrue(vendingMachine.hasField(finalIntAttributeName), String.format(missingAttribute, vendingMachineClassName, finalIntAttributeName));
        assertTrue(vendingMachine.hasField(finalIntAttributeName, int.class), String.format(incorrectType, finalIntAttributeName));
        assertTrue(vendingMachine.hasModifier(finalIntAttributeName, "private"), String.format(incorrectModifier, finalIntAttributeName));
        assertTrue(vendingMachine.hasModifier(finalIntAttributeName, "final"), String.format(incorrectFinalModifier, finalIntAttributeName));
        assertTrue(vendingMachine.hasField(intAttributeName), String.format(missingAttribute, vendingMachineClassName, intAttributeName));
        assertTrue(vendingMachine.hasField(intAttributeName, int.class), String.format(incorrectType, intAttributeName));
        assertTrue(vendingMachine.hasModifier(intAttributeName, "private"), String.format(incorrectModifier, intAttributeName));
        assertTrue(vendingMachine.hasField(hotSoupArrayAttributeName), String.format(missingAttribute, vendingMachineClassName, hotSoupArrayAttributeName));
        assertTrue(vendingMachine.hasField(hotSoupArrayAttributeName, hotSoup.getObjectArrayClass()), String.format(incorrectType, hotSoupArrayAttributeName));
        assertTrue(vendingMachine.hasModifier(hotSoupArrayAttributeName, "private"), String.format(incorrectModifier, hotSoupArrayAttributeName));
    }

    /* Test VendingMachine Constructor */

    @Test
    public void vendingMachineClassHasRequiredConstructor() throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{};
        assertTrue(vendingMachine.hasConstructor(constructorParameters), String.format(missingConstructor, vendingMachineClassName));
        assertTrue(vendingMachine.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, vendingMachineClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        String incorrectArray = "Your %s constructor does not initialize the %s array to the correct value. Make sure each item is initialized to the default values.";
        Object vendingMachineInstance = vendingMachine.createInstance();
        String expectedArray = Arrays.deepToString((Object[]) hotSoup.createArray(defaultCapacity, new Object[][]{{defaultPrice, double.class}, {defaultFlavour, String.class}}));

        _assertEquals(defaultCapacity, vendingMachine.getFieldValue(vendingMachineInstance, finalIntAttributeName), String.format(incorrectValue, vendingMachineClassName, finalIntAttributeName));
        _assertEquals(defaultCapacity, vendingMachine.getFieldValue(vendingMachineInstance, intAttributeName), String.format(incorrectValue, vendingMachineClassName, intAttributeName));
        _assertEquals(expectedArray, Arrays.deepToString((Object[]) vendingMachine.getFieldValue(vendingMachineInstance, hotSoupArrayAttributeName)), String.format(incorrectArray, vendingMachineClassName, stringAttributeName));
    }

    /* Test Vending Machine Methods */

    private static Stream<Arguments> buyItemInputProvider() {
        return Stream.of(
                Arguments.of(3.5, 1.5, 0, new Clause[]{new StringLiteral("The machine is sold out\\!")}),
                Arguments.of(1.25, 1.75, 10, new Clause[]{new StringLiteral("Not enough money. Returning payment...\n")}),
                Arguments.of(2.5, 2.5, 10, new Clause[]{new StringLiteral("Your change is: "), new NewLine()}),
                Arguments.of(2.6, 2.5, 10, new Clause[]{new StringLiteral("Your change is: "), new NewLine(), new StringLiteral("Dimes: 1"), new NewLine()}),
                Arguments.of(3.46, 3.2, 10, new Clause[]{new StringLiteral("Your change is: "), new NewLine(), new StringLiteral("Quarters: 1"), new NewLine(), new StringLiteral("Pennies: 1"), new NewLine()}),
                Arguments.of(1.42, 1, 10, new Clause[]{new StringLiteral("Your change is: "), new NewLine(), new StringLiteral("Quarters: 1"), new NewLine(), new StringLiteral("Dimes: 1"), new NewLine(), new StringLiteral("Nickels: 1"), new NewLine(), new StringLiteral("Pennies: 2"), new NewLine()}),
                Arguments.of(10.85, 10, 10, new Clause[]{new StringLiteral("Your change is: "), new NewLine(), new StringLiteral("Quarters: 3"), new NewLine(), new StringLiteral("Dimes: 1"), new NewLine()})
        );
    }

    @ParameterizedTest
    @MethodSource("buyItemInputProvider")
    public void correctBuyItemMethod(double money, double price, int size, Clause[] msg) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(vendingMachine.hasMethod(buyItemMethodName, new Class[]{double.class}),
                String.format(incorrectDefinition, vendingMachineClassName, buyItemMethodName));
        assertTrue(vendingMachine.hasModifier(buyItemMethodName, new Class[]{double.class}, "public"),
                String.format(incorrectModifier, buyItemMethodName));
        assertTrue(vendingMachine.hasReturnType(buyItemMethodName, new Class[]{double.class}, Void.TYPE),
                String.format(incorrectReturnType, buyItemMethodName));

        /* Initialize object and set fields */
        Object vmInstance = vendingMachine.createInstance();
        vendingMachine.setFieldValue(vmInstance, hotSoup.createArray(defaultCapacity, new Object[][]{{price, double.class}, {"Chicken", String.class}}), hotSoupArrayAttributeName);
        vendingMachine.setFieldValue(vmInstance, size, intAttributeName);

        /* Test output */
        vendingMachine.callMethod(buyItemMethodName, new Object[][]{{money, double.class}}, new String[]{"public"}, vmInstance,
                msg, "Your " + buyItemMethodName + " does not print the correct message. Make sure the if statements are properly configured.");

        Object[] holdArray = (Object[]) vendingMachine.getFieldValue(vmInstance, hotSoupArrayAttributeName);

        if(msg.length > 1){
            assertEquals(size - 1, vendingMachine.getFieldValue(vmInstance, intAttributeName), "Your " + buyItemMethodName + " method does not correctly reduce the " + intAttributeName + " attribute.");
            assertNull(holdArray[size - 1], "Your " + buyItemMethodName + " method does not remove the " + hotSoupClassName + " that has been purchased from the " + hotSoupArrayAttributeName + " attribute.");
        }
        else {
            assertEquals(size, vendingMachine.getFieldValue(vmInstance, intAttributeName), "Your " + buyItemMethodName + " method incorrectly reduces the " + intAttributeName + " attribute.");
            if(size != 0)
                assertNotNull(holdArray[size - 1], "Your " + buyItemMethodName + " method incorrectly removes a " + hotSoupClassName + " from the " + hotSoupArrayAttributeName + " attribute.");
        }
    }

    private static String getChange(double money) {
        String msg;
        if(money - defaultPrice < 0){
            msg = "Not enough money. Returning payment...\n";
        }
        else {
            msg = "Your change is: \n";
            int amount = (int) (Math.round((money - defaultPrice) * 100));
            if (amount / 25 != 0) {
                msg += "Quarters: " + amount / 25 + "\n";
                amount = amount % 25;
            }
            if (amount / 10 != 0) {
                msg += "Dimes: " + amount / 10 + "\n";
                amount = amount % 10;
            }
            if (amount / 5 != 0) {
                msg += "Nickels: " + amount / 5 + "\n";
                amount = amount % 5;
            }
            if (amount != 0) {
                msg += "Pennies: " + amount + "\n";
            }
        }
        return msg;
    }

    @Test
    public void lunchRushHasCorrectMainMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the main method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "Your main method does not have the correct visibility modifier.";
        String incorrectReturnType = "Your main method does not have the correct return type.";
        String incorrectStatic = "Your main method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(lunchRush.hasMethod("main", methodClassParameters),
                String.format(incorrectDefinition, lunchRush));
        assertTrue(lunchRush.hasModifier("main", methodClassParameters, "public"),
                incorrectModifier);
        assertTrue(lunchRush.hasReturnType("main", methodClassParameters, Void.TYPE),
                incorrectReturnType);
        assertTrue(lunchRush.hasModifier("main", methodClassParameters, "static"),
                incorrectStatic);

        Clause[] output = {
                new StringLiteral(getChange(5.50)),
                new NewLine(),
                new StringLiteral(getChange(3.10)),
                new NewLine(),
                new StringLiteral(getChange(10.00)),
                new NewLine(),
                new StringLiteral(getChange(1.75)),
                new NewLine(),
                new StringLiteral(getChange(2.55)),
                new NewLine(),
                new StringLiteral(getChange(2.66)),
                new NewLine(),
                new StringLiteral("Lunch rush over")
        };
        String incorrectOutput = "Your main method in the %s class did not print the correct output. Make sure you call the %s method in the correct order";
        Object[][] mainArgs = {{new String[0], String[].class}};
        lunchRush.callMethod("main", mainArgs, output, String.format(incorrectOutput, lunchRushClassName, buyItemMethodName));
    }
}
