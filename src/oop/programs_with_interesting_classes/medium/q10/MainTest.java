package oop.programs_with_interesting_classes.medium.q10;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    /* Parsons Question */
    private ObjectTest cashier;
    private ObjectTest testShopping;
    private final String cashierClassName = "Cashier";
    private final String testShoppingClassName = "TestShopping";
    private final String intAttributeName1 = "RAMEN_INDEX";
    private final String intAttributeName2 = "CHOCO_INDEX";
    private final String intAttributeName3 = "COKE_INDEX";
    private final String intArrayAttributeName = "stock";
    private final String stringArrayAttributeName = "items";
    private final String scanItemMethodName = "scanItem";
    private final String checkInventoryMethodName = "checkInventory";
    private final String restockMethodName = "restock";
    private static final int restockIncrease = 20;
    private static final int restockAlertLimit = 5;
    private final int index1 = 0;
    private final int index2 = 1;
    private final int index3 = 2;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.medium.q10.";
        cashier = new ObjectTest(packageString + cashierClassName);
        testShopping = new ObjectTest(packageString + testShoppingClassName);
    }

    /* Test if the cashier class has the required attributes */

    @Test
    public void cashierClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct %s modifier.";
        assertTrue(cashier.hasField(intAttributeName1), String.format(missingAttribute, cashierClassName, intAttributeName1));
        assertTrue(cashier.hasField(intAttributeName1, int.class), String.format(incorrectType, intAttributeName1));
        assertTrue(cashier.hasModifier(intAttributeName1, "private"), String.format(incorrectModifier, intAttributeName1, "visibility"));
        assertTrue(cashier.hasModifier(intAttributeName1, "final"), String.format(incorrectModifier, intAttributeName1, "final"));
        assertTrue(cashier.hasField(intAttributeName2), String.format(missingAttribute, cashierClassName, intAttributeName2));
        assertTrue(cashier.hasField(intAttributeName2, int.class), String.format(incorrectType, intAttributeName2));
        assertTrue(cashier.hasModifier(intAttributeName2, "private"), String.format(incorrectModifier, intAttributeName2, "visibility"));
        assertTrue(cashier.hasModifier(intAttributeName2, "final"), String.format(incorrectModifier, intAttributeName2, "final"));
        assertTrue(cashier.hasField(intAttributeName3), String.format(missingAttribute, cashierClassName, intAttributeName3));
        assertTrue(cashier.hasField(intAttributeName3, int.class), String.format(incorrectType, intAttributeName3));
        assertTrue(cashier.hasModifier(intAttributeName3, "private"), String.format(incorrectModifier, intAttributeName3, "visibility"));
        assertTrue(cashier.hasModifier(intAttributeName3, "final"), String.format(incorrectModifier, intAttributeName3, "final"));
        assertTrue(cashier.hasField(intArrayAttributeName), String.format(missingAttribute, cashierClassName, intArrayAttributeName));
        assertTrue(cashier.hasField(intArrayAttributeName, int[].class), String.format(incorrectType, intArrayAttributeName));
        assertTrue(cashier.hasModifier(intArrayAttributeName, "private"), String.format(incorrectModifier, intArrayAttributeName, "visibility"));
        assertTrue(cashier.hasModifier(intArrayAttributeName, "static"), String.format(incorrectModifier, intArrayAttributeName, "static"));
        assertTrue(cashier.hasField(stringArrayAttributeName), String.format(missingAttribute, cashierClassName, stringArrayAttributeName));
        assertTrue(cashier.hasField(stringArrayAttributeName, String[].class), String.format(incorrectType, stringArrayAttributeName));
        assertTrue(cashier.hasModifier(stringArrayAttributeName, "private"), String.format(incorrectModifier, stringArrayAttributeName, "visibility"));
        assertTrue(cashier.hasModifier(stringArrayAttributeName, "static"), String.format(incorrectModifier, stringArrayAttributeName, "static"));
    }

    /* Test Car Constructor */

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(10, 15, 30),
                Arguments.of(74, 58, 123),
                Arguments.of(0, 0, 0),
                Arguments.of(1, 5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void cashierClassHasRequiredParameterConstructor(int n1, int n2, int n3) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{int.class, int.class, int.class};
        assertTrue(cashier.hasConstructor(constructorParameters), String.format(missingConstructor, cashierClassName));
        assertTrue(cashier.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, cashierClassName));

        /* Check constructor functionality */
        String incorrectArray = "Your %s constructor does not initialize the %s array to the correct value.";
        Object[][] constructorArguments = {
                {n1, int.class},
                {n2, int.class},
                {n3, int.class}
        };
        Object cashierInstance = cashier.createInstance(constructorArguments);

        int[] hold = new int[3];
        hold[index1] = n1;
        hold[index2] = n2;
        hold[index3] = n3;

        String[] hold2 = new String[3];
        hold2[index1] = "Ramen";
        hold2[index2] = "Chocolate";
        hold2[index3] = "Coke";

        _assertArrayEquals(hold, cashier.getFieldValue(cashierInstance, intArrayAttributeName), String.format(incorrectArray, cashierClassName, intArrayAttributeName));
        _assertArrayEquals(hold2, cashier.getFieldValue(cashierInstance, stringArrayAttributeName), String.format(incorrectArray, cashierClassName, stringArrayAttributeName));
    }

    @Test
    public void cashierClassHasRequiredDefaultConstructor() throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{};
        assertTrue(cashier.hasConstructor(constructorParameters), String.format(missingConstructor, cashierClassName));
        assertTrue(cashier.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, cashierClassName));

        cashier.setFieldValue(null, new String[]{}, stringArrayAttributeName);
        cashier.setFieldValue(null, new int[]{}, intArrayAttributeName);

        /* Check constructor functionality */
        String incorrectArray = "Your %s constructor does not initialize the %s array to the correct value.";
        Object[][] constructorArguments = {};
        Object cashierInstance = cashier.createInstance(constructorArguments);

        _assertArrayEquals(new int[]{}, cashier.getFieldValue(cashierInstance, intArrayAttributeName), "Your default constructor should not alter the " + intArrayAttributeName + " attribute.");
        _assertArrayEquals(new String[]{"Ramen", "Chocolate", "Coke"}, cashier.getFieldValue(cashierInstance, stringArrayAttributeName), String.format(incorrectArray, cashierClassName, stringArrayAttributeName));
    }

    /* Test Cashier Methods */

    private static Stream<Arguments> scanItemInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{50, 50, 50}, "Ramen", restockAlertLimit + 1, new int[]{50 - (restockAlertLimit + 1), 50, 50}, ""),
                Arguments.of(new int[]{60, restockAlertLimit - 1, 80}, "Coke", 40, new int[]{60, restockAlertLimit - 1, 40}, "ALERT! Item: Chocolate only has " + (restockAlertLimit - 1) + " left in stock"),
                Arguments.of(new int[]{restockAlertLimit, restockAlertLimit, restockAlertLimit}, "Gibberish", 10, new int[]{restockAlertLimit, restockAlertLimit, restockAlertLimit},
                        "ALERT! Item: Ramen only has " + restockAlertLimit + " left in stock\nALERT! Item: Chocolate only has " + restockAlertLimit + " left in stock\nALERT! Item: Coke only has " + restockAlertLimit + " left in stock")
        );
    }

    @ParameterizedTest
    @MethodSource("scanItemInputProvider")
    public void correctScanItemMethod(int[] startValues, String item, int amount, int[] result, String msg) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{String.class, int.class};
        assertTrue(cashier.hasMethod(scanItemMethodName, methodClassParameters),
                String.format(incorrectDefinition, cashierClassName, scanItemMethodName));
        assertTrue(cashier.hasModifier(scanItemMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, scanItemMethodName));
        assertTrue(cashier.hasReturnType(scanItemMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, scanItemMethodName));

        /* Create instance to call method on */
        Object cashierInstance = cashier.createInstance();

        /* Set attributes */
        cashier.setFieldValue(cashierInstance, 0, intAttributeName1);
        cashier.setFieldValue(cashierInstance, 1, intAttributeName2);
        cashier.setFieldValue(cashierInstance, 2, intAttributeName3);
        cashier.setFieldValue(null, startValues, intArrayAttributeName);
        cashier.setFieldValue(null, new String[]{"Ramen", "Chocolate", "Coke"}, stringArrayAttributeName);

        /* Call scanItem on cashier */
        Object[][] methodArgs = {{item, String.class}, {amount, int.class}};
        if (msg.length() == 0)
            cashier.callMethod(scanItemMethodName, methodArgs, cashierInstance);
        else {
            String[] hold = msg.split("\n");
            Clause[] c = new Clause[(hold.length * 2) - 1];
            for (int x = 0; x < hold.length - 1; x++) {
                c[x * 2] = new StringLiteral(hold[x]);
                c[(x * 2) + 1] = new NewLine();
            }
            c[c.length - 1] = new StringLiteral(hold[hold.length - 1]);
            cashier.callMethod(scanItemMethodName, methodArgs, new String[]{"public"}, cashierInstance, c,
                    "Your " + scanItemMethodName + " method does not result in the correct output from calling the " + checkInventoryMethodName + " method.");
        }

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        _assertArrayEquals(result, cashier.getFieldValue(cashierInstance, intArrayAttributeName),
                String.format(incorrectUpdate, scanItemMethodName, intArrayAttributeName));
    }

    private static Stream<Arguments> checkInventoryInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{50, 50, 50}, ""),
                Arguments.of(new int[]{60, restockAlertLimit - 1, 40}, "ALERT! Item: Chocolate only has " + (restockAlertLimit - 1) + " left in stock"),
                Arguments.of(new int[]{restockAlertLimit, restockAlertLimit, restockAlertLimit},
                        "ALERT! Item: Ramen only has " + restockAlertLimit + " left in stock\nALERT! Item: Chocolate only has " + restockAlertLimit + " left in stock\nALERT! Item: Coke only has " + restockAlertLimit + " left in stock"),
                Arguments.of(new int[]{100, 1, 1}, "ALERT! Item: Chocolate only has 1 left in stock\nALERT! Item: Coke only has 1 left in stock")
        );
    }

    @ParameterizedTest
    @MethodSource("checkInventoryInputProvider")
    public void correctCheckInventoryMethod(int[] startValues, String msg) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{};
        assertTrue(cashier.hasMethod(checkInventoryMethodName, methodClassParameters),
                String.format(incorrectDefinition, cashierClassName, checkInventoryMethodName));
        assertTrue(cashier.hasModifier(checkInventoryMethodName, methodClassParameters, "private"),
                String.format(incorrectModifier, checkInventoryMethodName));
        assertTrue(cashier.hasReturnType(checkInventoryMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, checkInventoryMethodName));

        /* Create instance to call method on */
        Object cashierInstance = cashier.createInstance();

        /* Set attributes */
        cashier.setFieldValue(cashierInstance, 0, intAttributeName1);
        cashier.setFieldValue(cashierInstance, 1, intAttributeName2);
        cashier.setFieldValue(cashierInstance, 2, intAttributeName3);
        cashier.setFieldValue(null, startValues, intArrayAttributeName);
        cashier.setFieldValue(null, new String[]{"Ramen", "Chocolate", "Coke"}, stringArrayAttributeName);

        /* Call checkInventory on cashier */
        if (msg.length() == 0)
            cashier.callMethod(checkInventoryMethodName, cashierInstance);
        else {
            String[] hold = msg.split("\n");
            Clause[] c = new Clause[(hold.length * 2) - 1];
            for (int x = 0; x < hold.length - 1; x++) {
                c[x * 2] = new StringLiteral(hold[x]);
                c[(x * 2) + 1] = new NewLine();
            }
            c[c.length - 1] = new StringLiteral(hold[hold.length - 1]);
            cashier.callMethod(checkInventoryMethodName, cashierInstance, c,
                    "Your " + checkInventoryMethodName + " method does not print the correct output.");
        }
    }

    /* Test Car Methods */

    private static Stream<Arguments> restockInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{restockAlertLimit, restockAlertLimit, restockAlertLimit},
                        "Ramen has been restocked!\nChocolate has been restocked!\nCoke has been restocked!",
                        new int[]{restockAlertLimit + restockIncrease, restockAlertLimit + restockIncrease, restockAlertLimit + restockIncrease}),
                Arguments.of(new int[]{100, 100, 100}, "", new int[]{100, 100, 100}),
                Arguments.of(new int[]{restockAlertLimit + 1, restockAlertLimit, restockAlertLimit - 1},
                        "Chocolate has been restocked!\nCoke has been restocked!",
                        new int[]{restockAlertLimit + 1, restockAlertLimit + restockIncrease, restockAlertLimit - 1 + restockIncrease}),
                Arguments.of(new int[]{0, 1000, 1000}, "Ramen has been restocked!", new int[]{restockIncrease, 1000, 1000})
        );
    }

    @ParameterizedTest
    @MethodSource("restockInputProvider")
    public void correctRestockMethod(int[] startValues, String msg, int[] result) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{};
        assertTrue(cashier.hasMethod(restockMethodName, methodClassParameters),
                String.format(incorrectDefinition, cashierClassName, restockMethodName));
        assertTrue(cashier.hasModifier(restockMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, restockMethodName));
        assertTrue(cashier.hasReturnType(restockMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, restockMethodName));

        /* Create instance to call method on */
        Object cashierInstance = cashier.createInstance();

        /* Set attributes */
        cashier.setFieldValue(cashierInstance, 0, intAttributeName1);
        cashier.setFieldValue(cashierInstance, 1, intAttributeName2);
        cashier.setFieldValue(cashierInstance, 2, intAttributeName3);
        cashier.setFieldValue(null, startValues, intArrayAttributeName);
        cashier.setFieldValue(null, new String[]{"Ramen", "Chocolate", "Coke"}, stringArrayAttributeName);

        /* Call checkInventory on cashier */
        if (msg.length() == 0)
            cashier.callMethod(restockMethodName, cashierInstance);
        else {
            String[] hold = msg.split("\n");
            Clause[] c = new Clause[(hold.length * 2) - 1];
            for (int x = 0; x < hold.length - 1; x++) {
                c[x * 2] = new StringLiteral(hold[x]);
                c[(x * 2) + 1] = new NewLine();
            }
            c[c.length - 1] = new StringLiteral(hold[hold.length - 1]);
            cashier.callMethod(restockMethodName, cashierInstance, c,
                    "Your " + restockMethodName + " method does not print the correct output.");
        }

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        _assertArrayEquals(result, cashier.getFieldValue(cashierInstance, intArrayAttributeName),
                String.format(incorrectUpdate, restockMethodName, intArrayAttributeName));
    }

    @Test
    public void testShoppingHasCorrectMainMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the main method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "Your main method does not have the correct visibility modifier.";
        String incorrectReturnType = "Your main method does not have the correct return type.";
        String incorrectStatic = "Your main method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(testShopping.hasMethod("main", methodClassParameters),
                String.format(incorrectDefinition, testShoppingClassName));
        assertTrue(testShopping.hasModifier("main", methodClassParameters, "public"),
                incorrectModifier);
        assertTrue(testShopping.hasReturnType("main", methodClassParameters, Void.TYPE),
                incorrectReturnType);
        assertTrue(testShopping.hasModifier("main", methodClassParameters, "static"),
                incorrectStatic);

        int end = 60 - 36 - 21;

        Clause[] output = {
                new StringLiteral("ALERT! Item: Coke only has "),
                new IntegerLiteral(end),
                new StringLiteral(" left in stock"),
                new NewLine(),
                new StringLiteral("Coke has been restocked!")
        };
        String incorrectOutput = "Your main method in the %s class did not print the correct output. Make sure you scan and " + restockMethodName + " all the items";
        Object[][] mainArgs = {{new String[0], String[].class}};
        testShopping.callMethod("main", mainArgs, output, String.format(incorrectOutput, testShoppingClassName));
    }
}
