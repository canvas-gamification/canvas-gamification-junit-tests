package test.object;

import global.ObjectTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;

public class ObjectsTesting {
    public static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(5, "Kelowna"),
                Arguments.of(5, "testAddress")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void houseClassHasCorrectConstructors(int number, String address) throws Throwable {
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

        // Constructor 2
        Object object2 = objectTest.createInstance();
        _assertEquals(0, objectTest.getFieldValue(object2, "number", int.class),
                "Your House class does not correctly initialize the number field.");
        _assertEquals("nowhere", objectTest.getFieldValue(object2, "address", String.class),
                "Your House class does not correctly initialize the address field.");

    }
}
