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
                Arguments.of((Object) new String[]{})
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
            _assertEquals(names[0], tomatoClass.getFieldValue(plantSeedOutput, this.name),
                    "Your " + methodName + " method does not return the correct output.");
            assertNull(tomatoClass.getFieldValue(plantSeedOutput, this.flavour),
                    "Your " + methodName + " method does not return the correct output.");
            _assertEquals(null, tomatoClass.getFieldValue(plantSeedOutput, this.usedFor),
                    "Your " + methodName + " method does not return the correct output.");
        } else if (names.length == 3) {
            _assertEquals(names[0], tomatoClass.getFieldValue(plantSeedOutput, this.name),
                    "Your " + methodName + " method does not return the correct output.");
            _assertEquals(names[1], tomatoClass.getFieldValue(plantSeedOutput, this.flavour),
                    "Your " + methodName + " method does not return the correct output.");
            _assertEquals(names[2], tomatoClass.getFieldValue(plantSeedOutput, this.usedFor),
                    "Your " + methodName + " method does not return the correct output.");
        } else {
            _assertEquals(null, tomatoClass.getFieldValue(plantSeedOutput, this.name),
                    "Your " + methodName + " method does not return the correct output.");
            _assertEquals(null, tomatoClass.getFieldValue(plantSeedOutput, this.flavour),
                    "Your " + methodName + " method does not return the correct output.");
            _assertEquals(null, tomatoClass.getFieldValue(plantSeedOutput, this.usedFor),
                    "Your " + methodName + " method does not return the correct output.");
        }

    }
}
