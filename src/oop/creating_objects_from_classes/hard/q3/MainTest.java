package oop.creating_objects_from_classes.hard.q3;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String tomato = "Tomato";
    private final String methodName = "plantSeed";
    private ObjectTest tomatoClass;

    private final String usedFor = "usedFor";
    private final String flavour = "flavour";
    private final String name = "name";

    @BeforeEach
    public void setUp() {
        String tomatoClassString = "oop.creating_objects_from_classes.hard.q3." + tomato;
        tomatoClass = new ObjectTest(tomatoClassString);
    }

    @Test
    public void tomatoClassHasPlantSeedMethod() {
        Class<?>[] classes = {String[].class};
        assertTrue(tomatoClass.hasMethod(methodName, classes),
                "Your " + tomato + " class is missing the method " + methodName + ".");
        assertTrue(tomatoClass.hasReturnType(methodName, classes, Tomato.class),
                "Your " + methodName + " method does not return the correct type.");
        assertTrue(tomatoClass.hasModifier(methodName, classes, "public"),
                "Your " + methodName + " method does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> tomatoNamesArrayInputProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"Grape Tomato"}),
                Arguments.of((Object) new String[]{"Red Beefsteak Tomato", "juicy", "salsa"}),
                Arguments.of((Object) new String[]{"Green Beefsteak Tomato"}),
                Arguments.of((Object) new String[]{"Cherry Tomatoes", "sweet", "salads"}),
                Arguments.of((Object) new String[]{"Cocktail Tomatoes"}),
                Arguments.of((Object) new String[]{}),
                Arguments.of((Object) new String[]{"Heirloom Tomatoes", "meaty", "roasting", "deep, rich colour"})
        );
    }

    @ParameterizedTest
    @MethodSource("tomatoNamesArrayInputProvider")
    public void plantSeedClassReturnsCorrectValue(String[] names) throws Throwable {
        Object tomatoInstance = tomatoClass.createInstance();
        Object[][] arguments = {
                {names, String[].class}
        };
        Object plantSeedOutput = tomatoClass.callMethod(methodName, arguments, tomatoInstance);
        assertTrue(plantSeedOutput instanceof Tomato, "Your " + methodName + " method does not return the correct type.");

        if (names.length == 1) {
            // check that only name was initialized (correct constructor was called)
            _assertEquals(names[0], tomatoClass.getFieldValue(plantSeedOutput, this.name),
                    "Your " + methodName + " method does not return the correct output. " +
                            "Check that you are calling the correct constructor for the input given.");
            assertNull(tomatoClass.getFieldValue(plantSeedOutput, this.flavour),
                    "Your " + methodName + " method does not return the correct output. " +
                            "Check that you are calling the correct constructor for the input given.");
            assertNull(tomatoClass.getFieldValue(plantSeedOutput, this.usedFor),
                    "Your " + methodName + " method does not return the correct output. " +
                            "Check that you are calling the correct constructor for the input given.");
        } else if (names.length == 3) {
            // check that all fields were initialized
            _assertEquals(names[0], tomatoClass.getFieldValue(plantSeedOutput, this.name),
                    "Your " + methodName + " method does not return the correct output. " +
                            "Check that you are calling the correct constructor for the input given.");
            _assertEquals(names[1], tomatoClass.getFieldValue(plantSeedOutput, this.flavour),
                    "Your " + methodName + " method does not return the correct output. " +
                            "Check that you are calling the correct constructor for the input given.");
            _assertEquals(names[2], tomatoClass.getFieldValue(plantSeedOutput, this.usedFor),
                    "Your " + methodName + " method does not return the correct output. " +
                            "Check that you are calling the correct constructor for the input given.");
        } else {
            // check that no fields were initialized (default constructor)
            assertNull(tomatoClass.getFieldValue(plantSeedOutput, this.name),
                    "Your " + methodName + " method does not return the correct output. " +
                            "Check that you are calling the correct constructor for the input given.");
            assertNull(tomatoClass.getFieldValue(plantSeedOutput, this.flavour),
                    "Your " + methodName + " method does not return the correct output. " +
                            "Check that you are calling the correct constructor for the input given.");
            assertNull(tomatoClass.getFieldValue(plantSeedOutput, this.usedFor),
                    "Your " + methodName + " method does not return the correct output. " +
                            "Check that you are calling the correct constructor for the input given.");
        }

    }
}
