package oop.programs_with_interesting_classes.medium.q3;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest pokemon;
    private ObjectTest testPokemon;
    private final String pokemonClassName = "Pokemon";
    private final String testPokemonClassName = "TestPokemon";
    private final String stringAttributeName1 = "name";
    private final String stringAttributeName2 = "type";
    private final String intAttributeName1 = "health";
    private final String intAttributeName2 = "experienceLevel";
    private final String intAttributeName3 = "evolveLevel";
    private final String finalIntAttributeName1 = "BASE";
    private final static int finalIntAttribute1 = 1;
    private final String finalIntAttributeName2 = "INTERMEDIATE";
    private final static int finalIntAttribute2 = 2;
    private final String finalIntAttributeName3 = "ADVANCED";
    private final static int finalIntAttribute3 = 3;
    private final String getStringAttributeMethodName = "getName";
    private final String setStringAttributeMethodName = "setName";
    private final String getIntAttributeMethodName = "getHealth";
    private final String setIntAttributeMethodName = "setHealth";
    private final String attackMethodName = "attack";
    private final String battleExpMethodName = "battleExp";
    private final String checkEvolutionMethodName = "checkEvolution";
    private final String expectedString = "%s is a %s type creature with %s experience and has evolved to %s";
    private final int initialHealth = 100;
    private final int initialEvolveLevel = finalIntAttribute1;
    private final static int tippingPoint1 = 16;
    private final static int tippingPoint2 = 32;
    private final static int powerReducer = 10;
    private final static int xpReducer = 2;
    private final static int effective = 10;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.medium.q3.";
        pokemon = new ObjectTest(packageString + pokemonClassName);
        testPokemon = new ObjectTest(packageString + testPokemonClassName);
    }

    /* Test if the pokemon class has the required attributes */

    @Test
    public void pokemonClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        String incorrectFinalModifier = "Your %s attribute does not have the correct final modifier.";
        assertTrue(pokemon.hasField(stringAttributeName1), String.format(missingAttribute, pokemonClassName, stringAttributeName1));
        assertTrue(pokemon.hasField(stringAttributeName1, String.class), String.format(incorrectType, stringAttributeName1));
        assertTrue(pokemon.hasModifier(stringAttributeName1, "private"), String.format(incorrectModifier, stringAttributeName1));
        assertTrue(pokemon.hasField(stringAttributeName2), String.format(missingAttribute, pokemonClassName, stringAttributeName2));
        assertTrue(pokemon.hasField(stringAttributeName2, String.class), String.format(incorrectType, stringAttributeName2));
        assertTrue(pokemon.hasModifier(stringAttributeName2, "private"), String.format(incorrectModifier, stringAttributeName2));
        assertTrue(pokemon.hasField(intAttributeName1), String.format(missingAttribute, pokemonClassName, intAttributeName1));
        assertTrue(pokemon.hasField(intAttributeName1, int.class), String.format(incorrectType, intAttributeName1));
        assertTrue(pokemon.hasModifier(intAttributeName1, "private"), String.format(incorrectModifier, intAttributeName1));
        assertTrue(pokemon.hasField(intAttributeName2), String.format(missingAttribute, pokemonClassName, intAttributeName2));
        assertTrue(pokemon.hasField(intAttributeName2, int.class), String.format(incorrectType, intAttributeName2));
        assertTrue(pokemon.hasModifier(intAttributeName2, "private"), String.format(incorrectModifier, intAttributeName2));
        assertTrue(pokemon.hasField(intAttributeName3), String.format(missingAttribute, pokemonClassName, intAttributeName3));
        assertTrue(pokemon.hasField(intAttributeName3, int.class), String.format(incorrectType, intAttributeName3));
        assertTrue(pokemon.hasModifier(intAttributeName3, "private"), String.format(incorrectModifier, intAttributeName3));
        assertTrue(pokemon.hasField(finalIntAttributeName1), String.format(missingAttribute, pokemonClassName, finalIntAttributeName1));
        assertTrue(pokemon.hasField(finalIntAttributeName1, int.class), String.format(incorrectType, finalIntAttributeName1));
        assertTrue(pokemon.hasModifier(finalIntAttributeName1, "private"), String.format(incorrectModifier, finalIntAttributeName1));
        assertTrue(pokemon.hasModifier(finalIntAttributeName1, "final"), String.format(incorrectFinalModifier, finalIntAttributeName1));
        assertTrue(pokemon.hasField(finalIntAttributeName2), String.format(missingAttribute, pokemonClassName, finalIntAttributeName2));
        assertTrue(pokemon.hasField(finalIntAttributeName2, int.class), String.format(incorrectType, finalIntAttributeName2));
        assertTrue(pokemon.hasModifier(finalIntAttributeName2, "private"), String.format(incorrectModifier, finalIntAttributeName2));
        assertTrue(pokemon.hasModifier(finalIntAttributeName2, "final"), String.format(incorrectFinalModifier, finalIntAttributeName2));
        assertTrue(pokemon.hasField(finalIntAttributeName3), String.format(missingAttribute, pokemonClassName, finalIntAttributeName3));
        assertTrue(pokemon.hasField(finalIntAttributeName3, int.class), String.format(incorrectType, finalIntAttributeName3));
        assertTrue(pokemon.hasModifier(finalIntAttributeName3, "private"), String.format(incorrectModifier, finalIntAttributeName3));
        assertTrue(pokemon.hasModifier(finalIntAttributeName3, "final"), String.format(incorrectFinalModifier, finalIntAttributeName3));
    }

    /* Test Pokemon Constructor */

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Lim", "Psychic", 5),
                Arguments.of("Robot Physicist", "electric", 0),
                Arguments.of("Rainstorm", "usual", 15)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void pokemonClassHasRequiredConstructor(String name, String type, int experience) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, String.class, int.class};
        assertTrue(pokemon.hasConstructor(constructorParameters), String.format(missingConstructor, pokemonClassName));
        assertTrue(pokemon.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, pokemonClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        Object[][] constructorArguments = {
                {name, String.class},
                {type, String.class},
                {experience, int.class}
        };
        Object pokemonInstance = pokemon.createInstance(constructorArguments);
        _assertEquals(name, pokemon.getFieldValue(pokemonInstance, stringAttributeName1), String.format(incorrectValue, pokemonClassName, stringAttributeName1));
        _assertEquals(type, pokemon.getFieldValue(pokemonInstance, stringAttributeName2), String.format(incorrectValue, pokemonClassName, stringAttributeName2));
        _assertEquals(experience, pokemon.getFieldValue(pokemonInstance, intAttributeName2), String.format(incorrectValue, pokemonClassName, intAttributeName2));
        _assertEquals(initialHealth, pokemon.getFieldValue(pokemonInstance, intAttributeName1), String.format(incorrectValue, pokemonClassName, intAttributeName1));
        _assertEquals(initialEvolveLevel, pokemon.getFieldValue(pokemonInstance, intAttributeName3), String.format(incorrectValue, pokemonClassName, intAttributeName3));
    }

    /* Test Car Methods */

    private static Stream<Arguments> setNameInputProvider() {
        return Stream.of(
                Arguments.of("", "new name"),
                Arguments.of("water otter", "water otter 2 electric boogaloo"),
                Arguments.of("Zoomies", "")
        );
    }

    @ParameterizedTest
    @MethodSource("setNameInputProvider")
    public void correctSetNameMethod(String initialName, String updatedName) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{String.class};
        assertTrue(pokemon.hasMethod(setStringAttributeMethodName, methodClassParameters),
                String.format(incorrectDefinition, pokemonClassName, setStringAttributeMethodName));
        assertTrue(pokemon.hasModifier(setStringAttributeMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setStringAttributeMethodName));
        assertTrue(pokemon.hasReturnType(setStringAttributeMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setStringAttributeMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {initialName, String.class},
                {"Fire", String.class},
                {2, int.class}
        };
        Object pokemonInstance = pokemon.createInstance(constructorArguments);

        /* Call setName on car */
        Object[][] methodArgs = {{updatedName, String.class}};
        pokemon.callMethod(setStringAttributeMethodName, methodArgs, pokemonInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        _assertEquals(updatedName, pokemon.getFieldValue(pokemonInstance, stringAttributeName1),
                String.format(incorrectUpdate, setStringAttributeMethodName, stringAttributeName1));
    }

    private static Stream<String> getNameInputProvider() {
        return Stream.of("Shimmer", "George W. Bush", "123 ABC", "");
    }

    @ParameterizedTest
    @MethodSource("getNameInputProvider")
    public void correctGetNameMethod(String name) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(pokemon.hasMethod(getStringAttributeMethodName, null),
                String.format(incorrectDefinition, pokemonClassName, getStringAttributeMethodName));
        assertTrue(pokemon.hasModifier(getStringAttributeMethodName, null, "public"),
                String.format(incorrectModifier, getStringAttributeMethodName));
        assertTrue(pokemon.hasReturnType(getStringAttributeMethodName, null, String.class),
                String.format(incorrectReturnType, getStringAttributeMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {name, String.class},
                {"Fire", String.class},
                {5, int.class}
        };
        Object pokemonInstance = pokemon.createInstance(constructorArguments);

        /* Call getName on car */
        Object getNameOutput = pokemon.callMethod(getStringAttributeMethodName, pokemonInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(name, getNameOutput, String.format(incorrectUpdate, getStringAttributeMethodName, stringAttributeName1));
    }

    private static Stream<Integer> setHealthInputProvider() {
        return Stream.of(101, 40, 0);
    }

    @ParameterizedTest
    @MethodSource("setHealthInputProvider")
    public void correctSetHealthMethod(int health) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(pokemon.hasMethod(setIntAttributeMethodName, methodClassParameters),
                String.format(incorrectDefinition, pokemonClassName, setIntAttributeMethodName));
        assertTrue(pokemon.hasModifier(setIntAttributeMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setIntAttributeMethodName));
        assertTrue(pokemon.hasReturnType(setIntAttributeMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setIntAttributeMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Lamp", String.class},
                {"Fire", String.class},
                {2, int.class}
        };
        Object pokemonInstance = pokemon.createInstance(constructorArguments);

        /* Call setName on car */
        Object[][] methodArgs = {{health, int.class}};
        pokemon.callMethod(setIntAttributeMethodName, methodArgs, pokemonInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        _assertEquals(health, pokemon.getFieldValue(pokemonInstance, intAttributeName1),
                String.format(incorrectUpdate, setIntAttributeMethodName, intAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("setHealthInputProvider")
    public void correctGetHealthMethod(int health) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(pokemon.hasMethod(getIntAttributeMethodName, null),
                String.format(incorrectDefinition, pokemonClassName, getIntAttributeMethodName));
        assertTrue(pokemon.hasModifier(getIntAttributeMethodName, null, "public"),
                String.format(incorrectModifier, getIntAttributeMethodName));
        assertTrue(pokemon.hasReturnType(getIntAttributeMethodName, null, int.class),
                String.format(incorrectReturnType, getIntAttributeMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"UwU", String.class},
                {"Fire", String.class},
                {5, int.class}
        };
        Object pokemonInstance = pokemon.createInstance(constructorArguments);

        /* Call getHealth on car */
        pokemon.setFieldValue(pokemonInstance, health, intAttributeName1);
        Object getHealthOutput = pokemon.callMethod(getIntAttributeMethodName, pokemonInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(health, getHealthOutput, String.format(incorrectUpdate, getIntAttributeMethodName, intAttributeName1));
    }

    private static Stream<Arguments> toStringInputProvider() {
        return Stream.of(
                Arguments.of("Sam", "Wind", 15, 2),
                Arguments.of("Seth", "", 170, 3),
                Arguments.of("Hiss", "Rye", 0, 0),
                Arguments.of("Teeth", "Wisdom", 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("toStringInputProvider")
    public void correctToStringMethod(String name, String type, int experience, int level) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(pokemon.hasMethod("toString", null),
                String.format(incorrectDefinition, pokemonClassName, "toString"));
        assertTrue(pokemon.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(pokemon.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {name, String.class},
                {type, String.class},
                {experience, int.class}
        };
        Object pokemonInstance = pokemon.createInstance(constructorArguments);

        /* Set fields to values for test */
        pokemon.setFieldValue(pokemonInstance, level, intAttributeName3);

        /* Test output */
        String expectedOutput = String.format(expectedString, name, type, experience, level);
        Object actualOutput = pokemon.callMethod("toString", pokemonInstance);
        _assertEquals(expectedOutput, actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(5 * (xpReducer * powerReducer), tippingPoint1 - 5, 1, 100, 5, 1, finalIntAttribute2),
                Arguments.of(4 * (xpReducer * powerReducer), tippingPoint1 - 5, 1, 100, 5, 1, finalIntAttribute1),
                Arguments.of(6 * (xpReducer * powerReducer), tippingPoint1 - 5, 1, 100, 5, 1, finalIntAttribute2),
                Arguments.of(5 * (xpReducer * powerReducer), tippingPoint2 - 5, 1, 100, 5, 1, finalIntAttribute2),
                Arguments.of(4 * (xpReducer * powerReducer), tippingPoint2 - 5, 1, 100, 5, 1, finalIntAttribute2),
                Arguments.of(6 * (xpReducer * powerReducer), tippingPoint2 - 5, 2, 100, 5, 1, finalIntAttribute3),
                Arguments.of(7 * powerReducer, 0, 1, 7, 5, 1, finalIntAttribute1),
                Arguments.of(7000, 0, 1, 12000, 600, 3, finalIntAttribute3)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctAttackMethod(int hp1, int experience1, int level1, int hp2, int experience2, int level2) throws Throwable {
        /* Check method parameters */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{pokemon.getObjectClass()};
        assertTrue(pokemon.hasMethod(attackMethodName, methodClassParameters),
                String.format(incorrectDefinition, pokemonClassName, attackMethodName));
        assertTrue(pokemon.hasModifier(attackMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, attackMethodName));
        assertTrue(pokemon.hasReturnType(attackMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, attackMethodName));

        /* Initialize objects for attack test */
        Object[][] constructorArguments = {
                {"name", String.class},
                {"type", String.class},
                {experience1, int.class}
        };
        Object pokemon1 = pokemon.createInstance(constructorArguments);
        pokemon.setFieldValue(pokemon1, hp1, intAttributeName1);
        pokemon.setFieldValue(pokemon1, level1, intAttributeName3);
        constructorArguments = new Object[][]{
                {"name", String.class},
                {"type", String.class},
                {experience2, int.class}
        };
        Object pokemon2 = pokemon.createInstance(constructorArguments);
        pokemon.setFieldValue(pokemon2, hp2, intAttributeName1);
        pokemon.setFieldValue(pokemon2, level2, intAttributeName3);

        /* Call attack */
        Clause[] c;
        if ((hp1 / powerReducer) > effective) {
            c = new Clause[]{
                    new StringLiteral("That attack was very effective\\!"),
                    new NewLine()
            };
        } else {
            c = new Clause[]{
                    new StringLiteral("That attack wasn't very effective\\!"),
                    new NewLine()
            };
        }
        Object[][] attackInput = {{pokemon2, pokemon.getObjectClass()}};
        pokemon.callMethod(attackMethodName, attackInput, new String[]{"public"}, pokemon1, c,
                "Your " + attackMethodName + " does not print the correct output.");

        /* Test Result */
        assertEquals(hp1 - 1, pokemon.getFieldValue(pokemon1, intAttributeName1),
                "Your " + attackMethodName + " does not correctly update the " + intAttributeName1 + " of the attacking creature.");
        assertEquals(hp2 - (hp1 / powerReducer), pokemon.getFieldValue(pokemon2, intAttributeName1),
                "Your " + attackMethodName + " does not correctly update the " + intAttributeName1 + " of the attacked creature.");
        assertEquals(experience1 + (hp1 / (powerReducer * xpReducer)), pokemon.getFieldValue(pokemon1, intAttributeName2),
                "Your " + attackMethodName + " does not prompt the update of the " + intAttributeName2 + " of the attacking creature.");
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctBattleExpMethod(int hp1, int experience1, int level1, int hp2, int experience2, int level2, int newLevel) throws Throwable {
        /* Check method parameters */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(pokemon.hasMethod(battleExpMethodName, methodClassParameters),
                String.format(incorrectDefinition, pokemonClassName, battleExpMethodName));
        assertTrue(pokemon.hasModifier(battleExpMethodName, methodClassParameters, "private"),
                String.format(incorrectModifier, battleExpMethodName));
        assertTrue(pokemon.hasReturnType(battleExpMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, battleExpMethodName));

        /* Initialize objects for attack test */
        Object[][] constructorArguments = {
                {"name", String.class},
                {"type", String.class},
                {experience1, int.class}
        };
        Object pokemon1 = pokemon.createInstance(constructorArguments);
        pokemon.setFieldValue(pokemon1, hp1, intAttributeName1);
        pokemon.setFieldValue(pokemon1, level1, intAttributeName3);
        constructorArguments = new Object[][]{
                {"name", String.class},
                {"type", String.class},
                {experience2, int.class}
        };
        Object pokemon2 = pokemon.createInstance(constructorArguments);
        pokemon.setFieldValue(pokemon2, hp2, intAttributeName1);
        pokemon.setFieldValue(pokemon2, level2, intAttributeName3);

        /* Call battleExp */
        Object[][] battleInput = {{hp1 / (powerReducer * xpReducer), int.class}};
        pokemon.callMethod(battleExpMethodName, battleInput, pokemon1);

        /* Test Result */
        assertEquals(experience1 + hp1 / (powerReducer * xpReducer), pokemon.getFieldValue(pokemon1, intAttributeName2),
                "Your " + battleExpMethodName + " does not correctly update the " + intAttributeName2 + " of the creature.");
        assertEquals(newLevel, pokemon.getFieldValue(pokemon1, intAttributeName3),
                "Your " + battleExpMethodName + " does not prompt the update of the " + intAttributeName3 + " of the creature.");
    }

    private static Stream<Arguments> checkEvolutionInputProvider() {
        return Stream.of(
                Arguments.of(0, tippingPoint1, finalIntAttribute2),
                Arguments.of(1, tippingPoint1 - 1, finalIntAttribute1),
                Arguments.of(1, tippingPoint2, finalIntAttribute2),
                Arguments.of(1, tippingPoint2 + 1, finalIntAttribute3),
                Arguments.of(1, 0, finalIntAttribute1),
                Arguments.of(2, 10000, finalIntAttribute3)
        );
    }

    @ParameterizedTest
    @MethodSource("checkEvolutionInputProvider")
    public void correctCheckEvolutionMethod(int startLevel, int exp, int newLevel) throws Throwable {
        /* Check method parameters */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{};
        assertTrue(pokemon.hasMethod(checkEvolutionMethodName, methodClassParameters),
                String.format(incorrectDefinition, pokemonClassName, checkEvolutionMethodName));
        assertTrue(pokemon.hasModifier(checkEvolutionMethodName, methodClassParameters, "private"),
                String.format(incorrectModifier, checkEvolutionMethodName));
        assertTrue(pokemon.hasReturnType(checkEvolutionMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, checkEvolutionMethodName));

        /* Initialize objects for attack test */
        Object[][] constructorArguments = {
                {"name", String.class},
                {"type", String.class},
                {exp, int.class}
        };
        Object pokemon1 = pokemon.createInstance(constructorArguments);
        pokemon.setFieldValue(pokemon1, startLevel, intAttributeName3);

        /* Call checkEvolution */
        pokemon.callMethod(checkEvolutionMethodName, pokemon1);

        /* Test Result */
        assertEquals(newLevel, pokemon.getFieldValue(pokemon1, intAttributeName3),
                "Your " + checkEvolutionMethodName + " does not correctly update the " + intAttributeName3 + " of the creature.");
    }

    @Test
    public void testPokemonHasCorrectMainMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the main method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "Your main method does not have the correct visibility modifier.";
        String incorrectReturnType = "Your main method does not have the correct return type.";
        String incorrectStatic = "Your main method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(testPokemon.hasMethod("main", methodClassParameters),
                String.format(incorrectDefinition, testPokemonClassName));
        assertTrue(testPokemon.hasModifier("main", methodClassParameters, "public"),
                incorrectModifier);
        assertTrue(testPokemon.hasReturnType("main", methodClassParameters, Void.TYPE),
                incorrectReturnType);
        assertTrue(testPokemon.hasModifier("main", methodClassParameters, "static"),
                incorrectStatic);

        int newXp1 = 5 + (initialHealth / (powerReducer * xpReducer));
        int newXp2 = 6 + ((initialHealth - (initialHealth / powerReducer)) / (powerReducer * xpReducer));
        String str1 = (newXp1 - 5) * xpReducer <= 10 ? "That attack wasn't very effective\\!" : "That attack was very effective\\!";
        String str2 = (newXp2 - 6) * xpReducer <= 10 ? "That attack wasn't very effective\\!" : "That attack was very effective\\!";
        int newLvl1 = newXp1 > tippingPoint1 ? 2 : 1;
        int newLvl2 = newXp2 > tippingPoint1 ? 2 : 1;

        Clause[] output = {
                new StringLiteral("The battle begins!"),
                new NewLine(),
                new StringLiteral(str1),
                new NewLine(),
                new StringLiteral(str2),
                new NewLine(),
                new StringLiteral("The battle has ended\\!"),
                new NewLine(),
                new StringLiteral(Pattern.quote("Squirtle is a Water type creature with " + newXp1 + " experience and has evolved to " + newLvl1)),
                new NewLine(),
                new StringLiteral(Pattern.quote("Charmander is a Fire type creature with " + newXp2 + " experience and has evolved to " + newLvl2))
        };
        String incorrectOutput = "Your main method in the %s class did not print the correct output. Make sure you print the battle announcements, toString outputs, and call the %s method twice.";
        Object[][] mainArgs = {{new String[0], String[].class}};
        testPokemon.callMethod("main", mainArgs, output, String.format(incorrectOutput, testPokemonClassName, attackMethodName));
    }
}
