package oop.object_interactions.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest passport;
    private final String passportName = "Passport";
    private final String nameAttribute = "name";
    private final String dobAttribute = "dob";


    @BeforeEach
    public void setup() {
        String passportString = "oop.object_interactions.hard.q1." + passportName;
        passport = new ObjectTest(passportString);
    }

    @Test
    public void passportClassHasRequiredAttributes() {
        assertTrue(passport.hasField(nameAttribute, String.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", nameAttribute));
        assertTrue(passport.hasField(dobAttribute, String.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", dobAttribute));
        assertTrue(passport.hasModifier(nameAttribute, "private"),
                String.format("The %s field does not have the correct visibility modifier.", nameAttribute));
        assertTrue(passport.hasModifier(dobAttribute, "private"),
                String.format("The %s field does not have the correct visibility modifier.", dobAttribute));
    }

    private static Stream<Arguments> passportConstructorInputProvider() {
        return Stream.of(
                Arguments.of("John Cena", "April 23, 1977"),
                Arguments.of("null", "null"),
                Arguments.of("One longer name with other sumbols&&@$#$", "mnsaidawkd2@#")
        );
    }

    @ParameterizedTest
    @MethodSource("passportConstructorInputProvider")
    public void passportClassHasCorrectConstructor(String name, String birthday) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {birthday, String.class}
        };
        assertTrue(passport.hasConstructor(new Class[]{String.class, String.class}, new String[]{"public"}),
                String.format("Your %s class is missing a required constructor or has the incorrect visibility modifier.", passportName));
        Object passportInstance = passport.createInstance(arguments);

    }

}
