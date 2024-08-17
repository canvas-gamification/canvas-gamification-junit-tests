package oop.programs_with_interesting_classes.hard.q4;

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
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private ObjectTest ad;
    private ObjectTest craigsList;
    private final String adClassName = "Ad";
    private final String craigsListClassName = "CraigsList";
    private final String stringAttributeName = "street";
    private final String intAttributeName = "numberOfRooms";
    private final String doubleAttributeName = "monthlyRent";
    private final String getNumberOfRoomsMethodName = "getNumberOfRooms";
    private final String getMonthlyRentMethodName = "getMonthlyRent";
    private final String printAdListMethodName = "printAdList";
    private final String filteredByRoomsMethodName = "filteredByRooms";
    private final String filteredByMaxRentMethodName = "filteredByMaxRent";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q4.";
        ad = new ObjectTest(packageString + adClassName);
        craigsList = new ObjectTest(packageString + craigsListClassName);
    }

    @Test
    public void adClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        String incorrectTypeMessage = "Your %s attribute does not have the correct type.";
        assertTrue(ad.hasField(stringAttributeName), String.format(missingAttribute, adClassName, stringAttributeName));
        assertTrue(ad.hasField(stringAttributeName, String.class), String.format(incorrectTypeMessage, stringAttributeName));
        assertTrue(ad.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(ad.hasField(intAttributeName), String.format(missingAttribute, adClassName, intAttributeName));
        assertTrue(ad.hasField(intAttributeName, int.class), String.format(incorrectTypeMessage, intAttributeName));
        assertTrue(ad.hasModifier(intAttributeName, "private"), String.format(incorrectModifier, intAttributeName));
        assertTrue(ad.hasField(doubleAttributeName), String.format(missingAttribute, adClassName, doubleAttributeName));
        assertTrue(ad.hasField(doubleAttributeName, double.class), String.format(incorrectTypeMessage, doubleAttributeName));
        assertTrue(ad.hasModifier(doubleAttributeName, "private"), String.format(incorrectModifier, doubleAttributeName));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("123 central lane", 12, 1482.99),
                Arguments.of("", 0, 0.0),
                Arguments.of("66th street", 1, 23.2145),
                Arguments.of("-N67,24,53,21", 7, 842.3)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void adClassHasRequiredConstructor(String street, int rooms, double money) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, int.class, double.class};
        assertTrue(ad.hasConstructor(constructorParameters), String.format(missingConstructor, adClassName));
        assertTrue(ad.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, adClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{street, String.class}, {rooms, int.class}, {money, double.class}};
        Object adInstance = ad.createInstance(constructorArguments);

        /* Check if the initialization is correct */
        String errorMsg = "Your %s constructor does not correctly initialize the %s attribute.";
        assertEquals(street, ad.getFieldValue(adInstance, stringAttributeName), String.format(errorMsg, adClassName, stringAttributeName));
        assertEquals(rooms, ad.getFieldValue(adInstance, intAttributeName), String.format(errorMsg, adClassName, intAttributeName));
        assertEquals(money, ad.getFieldValue(adInstance, doubleAttributeName), String.format(errorMsg, adClassName, doubleAttributeName));
    }

    private static Stream<Double> getMonthlyRentInputProvider() {
        return Stream.of(
                0.0, 1.0, 1.1, 5.1, 32.75, 1246.43324
        );
    }

    @ParameterizedTest
    @MethodSource("getMonthlyRentInputProvider")
    public void correctGetMonthlyRentMethod(double money) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(ad.hasMethod(getMonthlyRentMethodName, null),
                String.format(incorrectDefinition, adClassName, getMonthlyRentMethodName));
        assertTrue(ad.hasModifier(getMonthlyRentMethodName, null, "public"),
                String.format(incorrectModifier, getMonthlyRentMethodName));
        assertTrue(ad.hasReturnType(getMonthlyRentMethodName, null, double.class),
                String.format(incorrectReturnType, adClassName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"street", String.class},
                {1, int.class},
                {money, double.class}
        };
        Object adInstance = ad.createInstance(constructorArguments);

        /* Call getMonthlyRent on ad */
        Object output = ad.callMethod(getMonthlyRentMethodName, adInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(money, output, String.format(incorrectUpdate, getMonthlyRentMethodName, doubleAttributeName));
    }

    private static Stream<Integer> getNumberOfRoomsInputProvider() {
        return Stream.of(
                0, 1, 2, 5, 64312
        );
    }

    @ParameterizedTest
    @MethodSource("getNumberOfRoomsInputProvider")
    public void correctGetNumberOfRoomsMethod(int rooms) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(ad.hasMethod(getNumberOfRoomsMethodName, null),
                String.format(incorrectDefinition, adClassName, getNumberOfRoomsMethodName));
        assertTrue(ad.hasModifier(getNumberOfRoomsMethodName, null, "public"),
                String.format(incorrectModifier, getNumberOfRoomsMethodName));
        assertTrue(ad.hasReturnType(getNumberOfRoomsMethodName, null, int.class),
                String.format(incorrectReturnType, adClassName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"street", String.class},
                {rooms, int.class},
                {1, double.class}
        };
        Object adInstance = ad.createInstance(constructorArguments);

        /* Call getNumberOfRooms on ad */
        Object output = ad.callMethod(getNumberOfRoomsMethodName, adInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(rooms, output, String.format(incorrectUpdate, getNumberOfRoomsMethodName, intAttributeName));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void adHasCorrectToStringMethod(String street, int rooms, double money) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(ad.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, adClassName, methodNameToString));
        assertTrue(ad.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(ad.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object[][] constructorArguments = {{street, String.class}, {rooms, int.class}, {money, double.class}};
        Object adInstance = ad.createInstance(constructorArguments);

        String msg = "Address: " + street + "\nNumber of rooms: " + rooms + "\nMonthly rent: " + money + "\n";
        String result = (String) ad.callMethod("toString", adInstance);
        assertEquals(msg, result, "Your " + adClassName + " class toString method does not return the correct String. Check that the formatting follows the question text.");
    }

    private static Stream<Arguments> printAdListInputProvider() {
        return Stream.of(
                Arguments.of(3, new Object[][][]{{{"12 James st", String.class}, {60, int.class}, {474.37, double.class}},
                                {{"Ken Ave.", String.class}, {4, int.class}, {13.3, double.class}}, {{"139-1 Central street", String.class}, {0, int.class}, {1.1, double.class}}},
                        new Clause[]{new StringLiteral("Ad 1:"), new Optional(new StringLiteral(" ")), new NewLine(), new StringLiteral("Address: 12 James st"),
                                new NewLine(), new StringLiteral("Number of rooms: 60"), new NewLine(), new StringLiteral("Monthly rent: 474.37"),
                                new NewLine(), new NewLine(), new StringLiteral("Ad 2:"), new Optional(new StringLiteral(" ")), new NewLine(), new StringLiteral("Address: Ken Ave."),
                                new NewLine(), new StringLiteral("Number of rooms: 4"), new NewLine(), new StringLiteral("Monthly rent: 13.3"),
                                new NewLine(), new NewLine(), new StringLiteral("Ad 3:"), new Optional(new StringLiteral(" ")), new NewLine(), new StringLiteral("Address: 139-1 Central street"),
                                new NewLine(), new StringLiteral("Number of rooms: 0"), new NewLine(), new StringLiteral("Monthly rent: 1.1"),
                                new NewLine(), new NewLine()}),
                Arguments.of(1, new Object[][][]{{{"1 street", String.class}, {45, int.class}, {12.4, double.class}}},
                        new Clause[]{new StringLiteral("Ad 1:"), new Optional(new StringLiteral(" ")), new NewLine(), new StringLiteral("Address: 1 street"),
                                new NewLine(), new StringLiteral("Number of rooms: 45"), new NewLine(), new StringLiteral("Monthly rent: 12.4"),
                                new NewLine(), new NewLine()}),
                Arguments.of(5, new Object[][][]{{{"66 Pes Street", String.class}, {9, int.class}, {123.4567, double.class}},
                                {{"", String.class}, {0, int.class}, {0.0, double.class}}, {{"Hope Lane", String.class}, {5, int.class}, {3.3, double.class}},
                                {{"Richmond Road", String.class}, {6, int.class}, {5.29, double.class}}, {{"Kinsty boulevard", String.class}, {4, int.class}, {4.4, double.class}}},
                        new Clause[]{new StringLiteral("Ad 1:"), new Optional(new StringLiteral(" ")), new NewLine(),
                                new StringLiteral("Address: 66 Pes Street"), new NewLine(), new StringLiteral("Number of rooms: 9"),
                                new NewLine(), new StringLiteral("Monthly rent: 123.4567"), new NewLine(), new NewLine(),
                                new StringLiteral("Ad 2:"), new Optional(new StringLiteral(" ")), new NewLine(),
                                new StringLiteral("Address: "), new NewLine(), new StringLiteral("Number of rooms: 0"),
                                new NewLine(), new StringLiteral("Monthly rent: 0.0"), new NewLine(), new NewLine(), new StringLiteral("Ad 3:"), new Optional(new StringLiteral(" ")), new NewLine(),
                                new StringLiteral("Address: Hope Lane"), new NewLine(), new StringLiteral("Number of rooms: 5"),
                                new NewLine(), new StringLiteral("Monthly rent: 3.3"), new NewLine(), new NewLine(),
                                new StringLiteral("Ad 4:"), new NewLine(), new Optional(new StringLiteral(" ")), new StringLiteral("Address: Richmond Road"),
                                new NewLine(), new StringLiteral("Number of rooms: 6"), new NewLine(), new StringLiteral("Monthly rent: 5.29"),
                                new NewLine(), new NewLine(), new StringLiteral("Ad 5:"), new Optional(new StringLiteral(" ")),
                                new NewLine(), new StringLiteral("Address: Kinsty boulevard"), new NewLine(), new StringLiteral("Number of rooms: 4"),
                                new NewLine(), new StringLiteral("Monthly rent: 4.4"), new NewLine(), new NewLine()})
        );
    }

    @ParameterizedTest
    @MethodSource("printAdListInputProvider")
    public void correctPrintAdListMethod(int size, Object[][][] arguments, Clause[] msg) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct %s modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{ad.getObjectArrayClass()};
        assertTrue(craigsList.hasMethod(printAdListMethodName, methodClassParameters),
                String.format(incorrectDefinition, craigsListClassName, printAdListMethodName));
        assertTrue(craigsList.hasModifier(printAdListMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, printAdListMethodName, "visibility"));
        assertTrue(craigsList.hasModifier(printAdListMethodName, methodClassParameters, "static"),
                String.format(incorrectModifier, printAdListMethodName, "static"));
        assertTrue(craigsList.hasReturnType(printAdListMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, printAdListMethodName));

        Object[][] methodArguments = {{ad.createArray(size, arguments), ad.getObjectArrayClass()}};
        craigsList.callMethod(printAdListMethodName, methodArguments, new String[]{"public", "static"}, null, msg,
                "Your " + printAdListMethodName + " method does not produce the correct output. Check that it follows the formatting described in the question text.");
    }

    private static Stream<Arguments> filteredByRoomsInputProvider() {
        return Stream.of(
                Arguments.of(0, new Object[][][]{{{}}}, 1, 0, new int[]{}),
                Arguments.of(1, new Object[][][]{{{"123 Lane", String.class}, {3, int.class}, {1946.99, double.class}}},
                        2, 0, new int[]{}),
                Arguments.of(1, new Object[][][]{{{"123 Lane", String.class}, {3, int.class}, {1946.99, double.class}}},
                        3, 1, new int[]{0}),
                Arguments.of(5, new Object[][][]{{{"123 Roade", String.class}, {1, int.class}, {893.11, double.class}},
                                {{"67 drysdale", String.class}, {2, int.class}, {14.12, double.class}}, {{"12 Academy Way", String.class}, {2, int.class}, {1234.32, double.class}},
                                {{"37 dshauid", String.class}, {12, int.class}, {3728948.33, double.class}}, {{"Just fine", String.class}, {2, int.class}, {4782.23, double.class}}},
                        2, 3, new int[]{1, 2, 4}),
                Arguments.of(5, new Object[][][]{{{"streetname", String.class}, {1, int.class}, {4783.32, double.class}},
                                {{"Crane street", String.class}, {1, int.class}, {12.12, double.class}}, {{"Vulture street", String.class}, {1, int.class}, {12.12, double.class}},
                                {{"Waverly Place", String.class}, {1, int.class}, {5.3, double.class}}, {{"Old Court House", String.class}, {1, int.class}, {56.5, double.class}}},
                        1, 5, new int[]{0, 1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("filteredByRoomsInputProvider")
    public void correctFilteredByRoomsMethod(int size, Object[][][] arguments, int rooms, int newSize, int[] indexes) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct %s modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class, ad.getObjectArrayClass()};
        assertTrue(craigsList.hasMethod(filteredByRoomsMethodName, methodClassParameters),
                String.format(incorrectDefinition, craigsListClassName, filteredByRoomsMethodName));
        assertTrue(craigsList.hasModifier(filteredByRoomsMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, filteredByRoomsMethodName, "visibility"));
        assertTrue(craigsList.hasModifier(filteredByRoomsMethodName, methodClassParameters, "static"),
                String.format(incorrectModifier, filteredByRoomsMethodName, "static"));
        assertTrue(craigsList.hasReturnType(filteredByRoomsMethodName, methodClassParameters, ad.getObjectArrayClass()),
                String.format(incorrectReturnType, filteredByRoomsMethodName));

        Object[] holdArray = (Object[]) ad.createArray(size, arguments);
        Object[] answerArray = new Object[newSize];
        for (int x = 0; x < newSize; x++) {
            answerArray[x] = holdArray[indexes[x]];
        }

        Object[][] methodArguments = {{rooms, int.class}, {holdArray, ad.getObjectArrayClass()}};
        Object[] output = (Object[]) craigsList.callMethod(filteredByRoomsMethodName, methodArguments);

        /* Check that only chars that should be changed were updated */
        String errorMessage = String.format("Your %s method did not correctly identify and return the objects that match the filter parameter.", filteredByRoomsMethodName);
        assertArrayEquals(answerArray, output, errorMessage);
    }

    private static Stream<Arguments> filteredByMaxRentInputProvider() {
        return Stream.of(
                Arguments.of(0, new Object[][][]{{{}}}, 1, 0, new int[]{}),
                Arguments.of(1, new Object[][][]{{{"123 Lane", String.class}, {3, int.class}, {1947.0, double.class}}},
                        1946.99, 0, new int[]{}),
                Arguments.of(1, new Object[][][]{{{"123 Lane", String.class}, {3, int.class}, {1946.99, double.class}}},
                        1946.99, 1, new int[]{0}),
                Arguments.of(5, new Object[][][]{{{"123 Roade", String.class}, {1, int.class}, {893.11, double.class}},
                                {{"67 drysdale", String.class}, {2, int.class}, {3728948.33, double.class}}, {{"12 Academy Way", String.class}, {2, int.class}, {1234.32, double.class}},
                                {{"37 dshauid", String.class}, {12, int.class}, {14.12, double.class}}, {{"Just fine", String.class}, {2, int.class}, {4782.23, double.class}}},
                        2000.0, 3, new int[]{0, 2, 3}),
                Arguments.of(5, new Object[][][]{{{"streetname", String.class}, {1, int.class}, {4783.32, double.class}},
                                {{"Crane street", String.class}, {1, int.class}, {12.12, double.class}}, {{"Vulture street", String.class}, {1, int.class}, {12.12, double.class}},
                                {{"Waverly Place", String.class}, {1, int.class}, {5.3, double.class}}, {{"Old Court House", String.class}, {1, int.class}, {56.5, double.class}}},
                        10000.01, 5, new int[]{0, 1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("filteredByMaxRentInputProvider")
    public void correctFilteredByMaxRentMethod(int size, Object[][][] arguments, double threshold, int newSize, int[] indexes) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct %s modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{double.class, ad.getObjectArrayClass()};
        assertTrue(craigsList.hasMethod(filteredByMaxRentMethodName, methodClassParameters),
                String.format(incorrectDefinition, craigsListClassName, filteredByMaxRentMethodName));
        assertTrue(craigsList.hasModifier(filteredByMaxRentMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, filteredByMaxRentMethodName, "visibility"));
        assertTrue(craigsList.hasModifier(filteredByMaxRentMethodName, methodClassParameters, "static"),
                String.format(incorrectModifier, filteredByMaxRentMethodName, "static"));
        assertTrue(craigsList.hasReturnType(filteredByMaxRentMethodName, methodClassParameters, ad.getObjectArrayClass()),
                String.format(incorrectReturnType, filteredByMaxRentMethodName));

        Object[] holdArray = (Object[]) ad.createArray(size, arguments);
        Object[] answerArray = new Object[newSize];
        for (int x = 0; x < newSize; x++) {
            answerArray[x] = holdArray[indexes[x]];
        }

        Object[][] methodArguments = {{threshold, double.class}, {holdArray, ad.getObjectArrayClass()}};
        Object[] output = (Object[]) craigsList.callMethod(filteredByMaxRentMethodName, methodArguments);

        /* Check that only chars that should be changed were updated */
        String errorMessage = String.format("Your %s method did not correctly identify and return the objects that match the filter parameter.", filteredByMaxRentMethodName);
        assertArrayEquals(answerArray, output, errorMessage);
    }
}
