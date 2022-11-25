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
    public void createsHouse(int number, String address) throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.House");
        Object[][] arguments = {
                {number, int.class},
                {address, String.class}
        };
        Object object = objectTest.createInstance(arguments);
        _assertEquals(number, objectTest.getFieldValue(object, "number", int.class),
                "Your House class does not correctly initialize the number field.");
        _assertEquals(address, objectTest.getFieldValue(object, "address", String.class),
                "Your House class does not correctly initialize the address field.");
    }
}
