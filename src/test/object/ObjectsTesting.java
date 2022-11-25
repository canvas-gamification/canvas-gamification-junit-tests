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

    @Test
    public void houseClassHasRequiredFields() throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.House");
        assertTrue(objectTest.hasField("number", int.class));
        assertTrue(objectTest.hasField("address", String.class));
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
        ObjectTest objectTest = new ObjectTest("test.object.House");
        Object object1 = objectTest.createInstance();
        _assertEquals(0, objectTest.getFieldValue(object1, "number", int.class),
                "Your House class does not correctly initialize the number field.");
        _assertEquals("nowhere", objectTest.getFieldValue(object1, "address", String.class),
                "Your House class does not correctly initialize the address field.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderConstructor1")
    public void correctNumberAddressConstructorForHouseClass(int number, String address) throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.House");
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
        ObjectTest objectTest = new ObjectTest("test.object.House");
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

}
