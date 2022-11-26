package test.object;

import global.ObjectTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectsTesting {
    private final String houseClass = "test.object.House";

    @Test
    public void houseClassHasRequiredFields() {
        ObjectTest objectTest = new ObjectTest(houseClass);
        assertTrue(objectTest.hasField("number", int.class), objectTest.missingFieldValueMessage("number"));
        assertTrue(objectTest.hasField("address", String.class), objectTest.missingFieldValueMessage("address"));
    }

    public static Stream<Arguments> inputProviderConstructor1() {
        return Stream.of(
                Arguments.of(5, "Kelowna"),
                Arguments.of(5, "testAddress")
        );
    }

    static Stream<Integer> inputProviderConstructor2() {
        return Stream.of(
                5, 1, 0, 178
        );
    }

    static Stream<String> inputProviderConstructor3() {
        return Stream.of(
                "Test", "Other address", "456 University Road"
        );
    }

    @RepeatedTest(3)
    public void correctDefaultConstructorForHouseClass() throws Throwable {
        ObjectTest objectTest = new ObjectTest(houseClass);
        Object object1 = objectTest.createInstance();
        _assertEquals(0, objectTest.getFieldValue(object1, "number", int.class),
                "Your House class does not correctly initialize the number field.");
        _assertEquals("nowhere", objectTest.getFieldValue(object1, "address", String.class),
                "Your House class does not correctly initialize the address field.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderConstructor1")
    public void correctNumberAddressConstructorForHouseClass(int number, String address) throws Throwable {
        ObjectTest objectTest = new ObjectTest(houseClass);
        // Constructor 1
        Object[][] arguments1 = {
                {number, int.class},
                {address, String.class}
        };
        Object object1 = objectTest.createInstance(arguments1);
        _assertEquals(number, objectTest.getFieldValue(object1, "number", int.class),
                "Your House class does not correctly initialize the number field.");
        _assertEquals(address, objectTest.getFieldValue(object1, "address", String.class),
                "Your House class does not correctly initialize the address field.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderConstructor2")
    public void correctNumberAddressConstructorForHouseClass(int number) throws Throwable {
        ObjectTest objectTest = new ObjectTest(houseClass);
        // Constructor 1
        Object[][] arguments1 = {
                {number, int.class}
        };
        Object object1 = objectTest.createInstance(arguments1);
        _assertEquals(number, objectTest.getFieldValue(object1, "number", int.class),
                "Your House class does not correctly initialize the number field.");
        _assertEquals("nowhere", objectTest.getFieldValue(object1, "address", String.class),
                "Your House class does not correctly initialize the address field.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderConstructor3")
    public void correctNumberConstructorForHouseClass(String address) throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.House");
        // Constructor 1
        Object[][] arguments1 = {
                {address, String.class}
        };
        Object object1 = objectTest.createInstance(arguments1);
        _assertEquals(0, objectTest.getFieldValue(object1, "number", int.class),
                "Your House class does not correctly initialize the number field.");
        _assertEquals(address, objectTest.getFieldValue(object1, "address", String.class),
                "Your House class does not correctly initialize the address field.");
    }

    static Stream<Integer> setNumberInputProvider() {
        return Stream.of(
                0, 1, 6, 1, 7453, 24
        );
    }

    static Stream<String> setStringInputProvider() {
        return Stream.of(
                "Test Address 1",
                "Another address",
                "One more"
        );
    }

    @ParameterizedTest
    @MethodSource("setNumberInputProvider")
    public void canSetNumber(int number) throws Throwable {
        ObjectTest objectTest = new ObjectTest(houseClass);
        Object object = objectTest.createInstance();
        objectTest.setFieldValue(object, number, "number");
        Object output = objectTest.getFieldValue(object, "number", int.class);
        _assertEquals(number, output, "Your ");
    }

    @ParameterizedTest
    @MethodSource("setStringInputProvider")
    public void canSetAddress(String address) throws Throwable {
        ObjectTest objectTest = new ObjectTest(houseClass);
        Object object = objectTest.createInstance();
        objectTest.setFieldValue(object, address, "address", String.class);
        Object output = objectTest.getFieldValue(object, "address", String.class);
        _assertEquals(address, output, "Your ");
    }

}
