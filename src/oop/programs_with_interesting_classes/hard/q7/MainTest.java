package oop.programs_with_interesting_classes.hard.q7;

import global.ObjectTest;
import global.variables.clauses.RandomInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    /* Java Question */
    private ObjectTest animal;
    private ObjectTest country;
    private final String animalClassName = "Animal";
    private final String countryClassName = "Country";
    private final String stringAttributeName1 = "name";
    private final String stringAttributeName2 = "sound";
    private final String stringAttributeName3 = "name";
    private final String animalArrayAttributeName = "localAnimals";
    private final String getNameMethodName1 = "getName";
    private final String getSoundMethodName = "getSound";
    private final String setLocalAnimalsMethodName = "setLocalAnimals";
    private final String getRandomAnimalMethodName = "getRandomAnimal";
    private final String getNameMethodName2 = "getName";
    private final String expectedString2 = "%s has: %s";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q7.";
        animal = new ObjectTest(packageString + animalClassName);
        country = new ObjectTest(packageString + countryClassName);
    }

    /* Test if the Animal class has the required attributes */

    @Test
    public void animalClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(animal.hasField(stringAttributeName1), String.format(missingAttribute, animalClassName, stringAttributeName1));
        assertTrue(animal.hasField(stringAttributeName1, String.class), String.format(incorrectType, stringAttributeName1));
        assertTrue(animal.hasModifier(stringAttributeName1, "private"), String.format(incorrectModifier, stringAttributeName1));
        assertTrue(animal.hasField(stringAttributeName2), String.format(missingAttribute, animalClassName, stringAttributeName2));
        assertTrue(animal.hasField(stringAttributeName2, String.class), String.format(incorrectType, stringAttributeName2));
        assertTrue(animal.hasModifier(stringAttributeName2, "private"), String.format(incorrectModifier, stringAttributeName2));
    }

    /* Test Animal Constructor */

    private static Stream<Arguments> animalConstructorInputProvider() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("cow", "moo"),
                Arguments.of("12 pi bird", "3.1415926...")
        );
    }

    @ParameterizedTest
    @MethodSource("animalConstructorInputProvider")
    public void animalClassHasRequiredConstructor(String name, String sound) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, String.class};
        assertTrue(animal.hasConstructor(constructorParameters), String.format(missingConstructor, animalClassName));
        assertTrue(animal.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, animalClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        Object[][] constructorArguments = {
                {name, String.class},
                {sound, String.class}
        };
        Object animalInstance = animal.createInstance(constructorArguments);
        _assertEquals(name, animal.getFieldValue(animalInstance, stringAttributeName1), String.format(incorrectValue, animalClassName, stringAttributeName1));
        _assertEquals(sound, animal.getFieldValue(animalInstance, stringAttributeName2), String.format(incorrectValue, animalClassName, stringAttributeName2));
    }

    /* Test Animal Methods */

    private static Stream<String> getStringInputProvider() {
        return Stream.of(
                "", "lemurbat", "123 moo 23", "cow goes mooo"
        );
    }

    @ParameterizedTest
    @MethodSource("getStringInputProvider")
    public void correctAnimalGetNameMethod(String name) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(animal.hasMethod(getNameMethodName1, null),
                String.format(incorrectDefinition, animalClassName, getNameMethodName1));
        assertTrue(animal.hasModifier(getNameMethodName1, null, "public"),
                String.format(incorrectModifier, getNameMethodName1));
        assertTrue(animal.hasReturnType(getNameMethodName1, null, String.class),
                String.format(incorrectReturnType, getNameMethodName1));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {name, String.class},
                {"sound", String.class}
        };
        Object animalInstance = animal.createInstance(constructorArguments);

        /* Call getName on animal */
        Object output = animal.callMethod(getNameMethodName1, animalInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(name, output, String.format(incorrectUpdate, getNameMethodName1, stringAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("getStringInputProvider")
    public void correctAnimalGetSoundMethod(String sound) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(animal.hasMethod(getSoundMethodName, null),
                String.format(incorrectDefinition, animalClassName, getSoundMethodName));
        assertTrue(animal.hasModifier(getSoundMethodName, null, "public"),
                String.format(incorrectModifier, getSoundMethodName));
        assertTrue(animal.hasReturnType(getSoundMethodName, null, String.class),
                String.format(incorrectReturnType, getSoundMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {sound, String.class}
        };
        Object animalInstance = animal.createInstance(constructorArguments);

        /* Call getSound on animal */
        Object output = animal.callMethod(getSoundMethodName, animalInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(sound, output, String.format(incorrectUpdate, getSoundMethodName, stringAttributeName1));
    }

    private static Stream<Arguments> animalToStringInputProvider() {
        return Stream.of(
                Arguments.of("", "", " makes the noise "),
                Arguments.of("cow", "moo", "cow makes the noise moo"),
                Arguments.of("12 pi bird", "3.1415926...", "12 pi bird makes the noise 3.1415926...")
        );
    }

    @ParameterizedTest
    @MethodSource("animalToStringInputProvider")
    public void correctAnimalToStringMethod(String name, String sound, String msg) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(animal.hasMethod("toString", null),
                String.format(incorrectDefinition, animalClassName, "toString"));
        assertTrue(animal.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(animal.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {name, String.class},
                {sound, String.class}
        };
        Object animalInstance = animal.createInstance(constructorArguments);

        /* Test output */
        Object actualOutput = animal.callMethod("toString", animalInstance);
        _assertEquals(msg, actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    /* Test if the country class has the required attributes */

    @Test
    public void countryClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(country.hasField(stringAttributeName3), String.format(missingAttribute, countryClassName, stringAttributeName3));
        assertTrue(country.hasField(stringAttributeName3, String.class), String.format(incorrectType, stringAttributeName3));
        assertTrue(country.hasModifier(stringAttributeName3, "private"), String.format(incorrectModifier, stringAttributeName3));
        assertTrue(country.hasField(animalArrayAttributeName), String.format(missingAttribute, countryClassName, animalArrayAttributeName));
        assertTrue(country.hasField(animalArrayAttributeName, animal.getObjectArrayClass()), String.format(incorrectType, animalArrayAttributeName));
        assertTrue(country.hasModifier(animalArrayAttributeName, "private"), String.format(incorrectModifier, animalArrayAttributeName));
    }

    /* Test Country Constructor */

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("greenland", new Object[][][]{{{"volcano", String.class}, {"boom", String.class}}, {{"seagull", String.class}, {"Caw", String.class}},
                        {{"cat", String.class}, {"meow", String.class}}}, 3),
                Arguments.of("", new Object[][][]{{{"", String.class}, {"", String.class}}}, 1),
                Arguments.of("Canada", new Object[][][]{{{"meese", String.class}, {"grunt", String.class}}, {{"beaver", String.class}, {"chitter", String.class}}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void countryClassHasRequiredConstructor(String name, Object[][][] arguments, int size) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, animal.getObjectArrayClass()};
        assertTrue(country.hasConstructor(constructorParameters), String.format(missingConstructor, countryClassName));
        assertTrue(country.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, countryClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        Object[] holdArray = (Object[]) animal.createArray(size, arguments);
        Object[] holdAns = holdArray.clone();
        Object[][] constructorArguments = {
                {name, String.class},
                {holdArray, animal.getObjectArrayClass()}
        };
        Object countryInstance = country.createInstance(constructorArguments);
        _assertEquals(name, country.getFieldValue(countryInstance, stringAttributeName3), String.format(incorrectValue, countryClassName, stringAttributeName3));
        _assertArrayEquals(holdAns, country.getFieldValue(countryInstance, animalArrayAttributeName), String.format(incorrectValue, countryClassName, animalArrayAttributeName));
    }

    private static Stream<Arguments> setLocalAnimalsInputProvider() {
        return Stream.of(
                Arguments.of(new Object[][][]{{{"volcano", String.class}, {"boom", String.class}}, {{"seagull", String.class}, {"Caw", String.class}},
                        {{"cat", String.class}, {"meow", String.class}}}, 3),
                Arguments.of(new Object[][][]{{{"", String.class}, {"", String.class}}}, 1),
                Arguments.of(new Object[][][]{{{"meese", String.class}, {"grunt", String.class}}, {{"beaver", String.class}, {"chitter", String.class}}}, 2),
                Arguments.of(new Object[][][]{{{"fox", String.class}, {"ringdingding", String.class}}, {{"sheep", String.class}, {"bahhh", String.class}},
                        {{"mouse", String.class}, {"squeak", String.class}}, {{"deer", String.class}, {"snuffle", String.class}},
                        {{"Bear", String.class}, {"growl", String.class}}}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("setLocalAnimalsInputProvider")
    public void correctSetLocalAnimalsMethod(Object[][][] arguments, int size) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{animal.getObjectArrayClass()};
        assertTrue(country.hasMethod(setLocalAnimalsMethodName, methodClassParameters),
                String.format(incorrectDefinition, countryClassName, setLocalAnimalsMethodName));
        assertTrue(country.hasModifier(setLocalAnimalsMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setLocalAnimalsMethodName));
        assertTrue(country.hasReturnType(setLocalAnimalsMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setLocalAnimalsMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {animal.createArray(2), animal.getObjectArrayClass()}
        };
        Object countryInstance = country.createInstance(constructorArguments);

        /* call set method */
        Object[] holdArray = (Object[]) animal.createArray(size, arguments);
        country.callMethod(setLocalAnimalsMethodName, new Object[][]{{holdArray, animal.getObjectArrayClass()}}, countryInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the value of the %s attribute.";
        _assertEquals(holdArray, country.getFieldValue(countryInstance, animalArrayAttributeName), String.format(incorrectUpdate, setLocalAnimalsMethodName, animalArrayAttributeName));
    }

    private static Stream<String> getNameInputProvider() {
        return Stream.of(
                "", "lemurbat", "123 Republic 23", "theo cracy no"
        );
    }

    @ParameterizedTest
    @MethodSource("getNameInputProvider")
    public void correctCountryGetNameMethod(String name) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(country.hasMethod(getNameMethodName2, null),
                String.format(incorrectDefinition, countryClassName, getNameMethodName2));
        assertTrue(country.hasModifier(getNameMethodName2, null, "public"),
                String.format(incorrectModifier, getNameMethodName2));
        assertTrue(country.hasReturnType(getNameMethodName2, null, String.class),
                String.format(incorrectReturnType, getNameMethodName2));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {name, String.class},
                {animal.createArray(2), animal.getObjectArrayClass()}
        };
        Object countryInstance = country.createInstance(constructorArguments);

        /* Call getName on country */
        Object output = country.callMethod(getNameMethodName2, countryInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(name, output, String.format(incorrectUpdate, getNameMethodName2, stringAttributeName3));
    }

    private static Stream<Arguments> getRandomAnimalInputProvider() {
        return Stream.of(
                Arguments.of(new Object[][][]{{{"volcano", String.class}, {"boom", String.class}}, {{"seagull", String.class}, {"Caw", String.class}},
                        {{"cat", String.class}, {"meow", String.class}}}, 3),
                Arguments.of(new Object[][][]{{{"", String.class}, {"", String.class}}}, 1),
                Arguments.of(new Object[][][]{{{"meese", String.class}, {"grunt", String.class}}, {{"beaver", String.class}, {"chitter", String.class}}}, 2),
                Arguments.of(new Object[][][]{{{"fox", String.class}, {"ringdingding", String.class}}, {{"sheep", String.class}, {"bahhh", String.class}},
                        {{"mouse", String.class}, {"squeak", String.class}}, {{"deer", String.class}, {"snuffle", String.class}},
                        {{"Bear", String.class}, {"growl", String.class}}, {{"rabbit", String.class}, {"snuffle", String.class}},
                        {{"Bird", String.class}, {"chirp", String.class}}, {{"bee", String.class}, {"buzz", String.class}},
                        {{"Lion", String.class}, {"rawr", String.class}}, {{"skunk", String.class}, {"hiss", String.class}}}, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("getRandomAnimalInputProvider")
    public void correctGetRandomAnimalMethod(Object[][][] arguments, int size) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(country.hasMethod(getRandomAnimalMethodName, null),
                String.format(incorrectDefinition, countryClassName, getRandomAnimalMethodName));
        assertTrue(country.hasModifier(getRandomAnimalMethodName, null, "public"),
                String.format(incorrectModifier, getRandomAnimalMethodName));
        assertTrue(country.hasReturnType(getRandomAnimalMethodName, null, animal.getObjectClass()),
                String.format(incorrectReturnType, getRandomAnimalMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {animal.createArray(size, arguments), animal.getObjectArrayClass()}
        };
        Object countryInstance = country.createInstance(constructorArguments);

        /* Call getRandomAnimal on country */
        Object output = country.callMethod(getRandomAnimalMethodName, countryInstance);

        /* Check result */
        String name = (String) animal.getFieldValue(output, stringAttributeName1);
        String sound = (String) animal.getFieldValue(output, stringAttributeName2);
        boolean exists = false;
        for (Object[][] argumentSet : arguments) {
            if (argumentSet[0][0].equals(name) && argumentSet[1][0].equals(sound)) {
                exists = true;
                break;
            }
        }
        assertTrue(exists, "Your " + getRandomAnimalMethodName + " method does not return an " + animalClassName + " from within the " + animalArrayAttributeName + " attribute.");

        if (size > 1) { //only check for randomness if the array is greater than size 1
            ArrayList<Integer> randomValues = new ArrayList<>();
            // collect remaining values necessary for the randomization check
            for (int x = 0; x < 1000; x++) {
                country.callMethod(getRandomAnimalMethodName, countryInstance);
                name = (String) animal.getFieldValue(output, stringAttributeName1);
                sound = (String) animal.getFieldValue(output, stringAttributeName2);
                int count = 0;
                for (Object[][] argumentSet : arguments) {
                    if (argumentSet[0][0].equals(name) && argumentSet[1][0].equals(sound)) {
                        randomValues.add(count);
                        break;
                    }
                    count++;
                }
            }

            // test randomness
            RandomInteger randomInteger = new RandomInteger(0, size); // Checking for values in range from 0 to array size
            randomInteger.validateRandom(randomValues);
        }
    }

    private static Stream<Arguments> countryToStringInputProvider() {
        return Stream.of(
                Arguments.of("Greenland", new Object[][][]{{{"volcano", String.class}, {"boom", String.class}}, {{"seagull", String.class}, {"Caw", String.class}},
                        {{"cat", String.class}, {"meow", String.class}}}, 3, "Greenland has: [volcano makes the noise boom, seagull makes the noise Caw, cat makes the noise meow]"),
                Arguments.of("", new Object[][][]{{{"", String.class}, {"", String.class}}}, 1, " has: [ makes the noise ]"),
                Arguments.of("Canada", new Object[][][]{{{"meese", String.class}, {"grunt", String.class}}, {{"beaver", String.class}, {"chitter", String.class}}}, 2,
                        "Canada has: [meese makes the noise grunt, beaver makes the noise chitter]"),
                Arguments.of("planet", new Object[][][]{{{"fox", String.class}, {"ringdingding", String.class}}, {{"sheep", String.class}, {"bahhh", String.class}},
                                {{"mouse", String.class}, {"squeak", String.class}}, {{"deer", String.class}, {"snuffle", String.class}},
                                {{"Bear", String.class}, {"growl", String.class}}, {{"rabbit", String.class}, {"snuffle", String.class}},
                                {{"Bird", String.class}, {"chirp", String.class}}, {{"bee", String.class}, {"buzz", String.class}},
                                {{"Lion", String.class}, {"rawr", String.class}}, {{"skunk", String.class}, {"hiss", String.class}}}, 10,
                        "planet has: [fox makes the noise ringdingding, sheep makes the noise bahhh, mouse makes the noise squeak, deer makes the noise snuffle, Bear makes the noise growl," +
                                " rabbit makes the noise snuffle, Bird makes the noise chirp, bee makes the noise buzz, Lion makes the noise rawr, skunk makes the noise hiss]")
        );
    }

    @ParameterizedTest
    @MethodSource("countryToStringInputProvider")
    public void correctCountryToStringMethod(String countryName, Object[][][] arguments, int size, String msg) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(country.hasMethod("toString", null),
                String.format(incorrectDefinition, countryClassName, "toString"));
        assertTrue(country.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(country.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {countryName, String.class},
                {animal.createArray(size, arguments), animal.getObjectArrayClass()}
        };
        Object countryInstance = country.createInstance(constructorArguments);

        /* Test output */
        Object actualOutput = country.callMethod("toString", countryInstance);
        _assertEquals(msg, actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }
}
