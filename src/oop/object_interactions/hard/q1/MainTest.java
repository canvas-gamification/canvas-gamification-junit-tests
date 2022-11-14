package oop.object_interactions.hard.q1;
/*
Identity theft is a serious crime. You are given the following class called Passport, which has attributes called name
and dob (date of birth). The attributes are defined in a constructor that takes input parameters for initializing these
attributes. Currently, the class has accessor, mutator, and toString() methods. Your job is to write a method in this
class called steal() that takes another Passport object as input and copies the values of the attributes.
 */

import global.MethodTest;
import global.utils.ClassUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static global.tools.CustomAssertions._fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    static Stream<Arguments> stealInputProvider() {
        return Stream.of(
                Arguments.of("Steve", "11/06/1997"),
                Arguments.of("Jasmine Gregson", "04/04/1934"),
                Arguments.of("No Name", "No Birthdate")
        );
    }

    @ParameterizedTest
    @MethodSource("stealInputProvider")
    public void correctStealMethod(String name, String birthdate) throws Throwable {
        // The problem for this test is that we need to call a method in a class the changes the values of the methods,
        // and we might not know if that method is defined.
        // Should probably create a ClassTest object for this that will only attempt to call methods if they exist.

        // Should also be able to use forName to make sure that the class actually exists
        // Class.forName can also be used to initialize objects
        // https://www.geeksforgeeks.org/different-ways-create-objects-java/?ref=lbp
        // https://www.baeldung.com/java-check-class-exists
        // Maybe we can define a comparator for easier comparison?
        Passport stolen = new Passport("Test Name", "Test DOB");
        Passport victim = new Passport(name, birthdate);
        Passport expected = new Passport(name, birthdate);
        if (ClassUtil.classHasMethod(Passport.class, "public void Passport)"))
            stolen.steal(victim);
        else
            _fail("Your Passport class does not have a steal method.", "No steal method found.");
        _assertEquals(expected.getDob(), victim.getDob(), "Your program does not correctly steal the values from the input passport.");
        _assertEquals(expected.getName(), victim.getName(), "Your program does not correctly steal the values from the input passport.");

    }
}
