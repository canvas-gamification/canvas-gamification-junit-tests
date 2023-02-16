package test.object.sample_question;

import global.ObjectTest;
import global.tools.Logger;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private final String personClassString = "Person";
    private final String houseClassString = "House";
    private final String defaultName = "Bob";
    private final int defaultAge = 21;
    private final boolean defaultEmployed = false;

    @Test
    public void programContainsPersonClass() {
        Logger.logMessage(getClass().getPackageName());
        new ObjectTest(personClassString);
    }

    @Test
    public void personClassHasRequiredFields() {
        ObjectTest personClass = new ObjectTest(personClassString);
        assertTrue(personClass.hasField("name", String.class),
                "Your Person class is missing the string name field.");
        assertTrue(personClass.hasModifier("name", "private"),
                "Your Person class name field does not have the correct modifiers.");
        assertTrue(personClass.hasField("age", int.class),
                "Your Person class is missing the int age field.");
        assertTrue(personClass.hasModifier("age", "private"),
                "Your Person class age field does not have the correct modifiers.");
        assertTrue(personClass.hasField("employed", boolean.class),
                "Your Person class is missing the boolean employed field.");
        assertTrue(personClass.hasModifier("employed", "private"),
                "Your Person class employed field does not have the correct modifiers.");
    }

    @Test
    public void personClassHasRequiredConstructors() {
        /*
            This test checks that the Person class has the required constructors, and that the constructors all have
            the public modifier.
         */
        ObjectTest personClass = new ObjectTest(personClassString);
        assertTrue(personClass.hasConstructor(null),
                "Your Person class does not have a default constructor.");
        assertTrue(personClass.hasModifier(new Class[]{}, "public"),
                "Your Person class default constructor does not have the correct modifiers.");
        assertTrue(personClass.hasConstructor(new Class[]{int.class}),
                "Your Person class does not have a constructor for only initializing the Person's age");
        assertTrue(personClass.hasModifier(new Class[]{int.class}, "public"),
                "Your Person class int constructor does not have the correct modifiers.");
        assertTrue(personClass.hasConstructor(new Class[]{String.class}),
                "Your Person class does not have a constructor with the String parameter.");
        assertTrue(personClass.hasModifier(new Class[]{String.class}, "public"),
                "Your Person class String constructor does not have the correct modifiers.");
        assertTrue(personClass.hasConstructor(new Class[]{String.class, int.class}),
                "Your Person class does not have a constructor with the String and int parameters.");
        assertTrue(personClass.hasModifier(new Class[]{String.class, int.class}, "public"),
                "Your Person class String, int constructor does not have the correct modifiers.");
        assertTrue(personClass.hasConstructor(new Class[]{String.class, boolean.class}),
                "Your Person class does not have a constructor with the parameters of String and boolean.");
        assertTrue(personClass.hasModifier(new Class[]{String.class, boolean.class}, "public"),
                "Your Person class String, boolean constructor does not have the correct modifiers.");
        assertTrue(personClass.hasConstructor(new Class[]{int.class, boolean.class}),
                "Your Person class does not have a constructor with the parameters of int and boolean.");
        assertTrue(personClass.hasModifier(new Class[]{int.class, boolean.class}, "public"),
                "Your Person class int, boolean constructor does not have the correct modifiers.");
        assertTrue(personClass.hasConstructor(new Class[]{String.class, int.class, boolean.class}),
                "Your Person class does not have a constructor with the parameters of String, int, and boolean.");
    }

    private static Stream<Arguments> stringIntBooleanInputProvider() {
        return Stream.of(
                Arguments.of("Caroline", 35, true),
                Arguments.of("George", 20, false),
                Arguments.of("Elvin Elvis", 238, true),
                Arguments.of("Madalyn", 98, false),
                Arguments.of("Peterolomew", 1, true)
        );
    }

    private static Stream<String> stringInputProvider() {
        return Stream.of("Caroline", "George", "Elvin Elvis", "Madalyn", "Peterolomew");
    }

    private static Stream<Integer> intInputProvider() {
        return Stream.of(4, 11, 91, 0, 2, 12993, 452);
    }

    private static Stream<Boolean> booleanInputProvider() {
        return Stream.of(true, false);
    }

    private static Stream<Arguments> stringIntInputProvider() {
        return Stream.of(
                Arguments.of("five", 5),
                Arguments.of("A very original name", 2877728),
                Arguments.of("Madalyn", 2),
                Arguments.of("Emma", 29910)
        );
    }

    private static Stream<Arguments> booleanBooleanInputProvider() {
        return Stream.of(
                Arguments.of(true, true),
                Arguments.of(true, false),
                Arguments.of(false, true),
                Arguments.of(false, false)
        );
    }

    private static Stream<Arguments> stringBooleanInputProvider() {
        return Stream.of(
                Arguments.of("Another cool name", false),
                Arguments.of("George the George", true),
                Arguments.of("Emilia", true),
                Arguments.of("Voldemort", false)
        );
    }

    private static Stream<Arguments> intBooleanInputProvider() {
        return Stream.of(
                Arguments.of(4, true),
                Arguments.of(26, false),
                Arguments.of(23978, true),
                Arguments.of(37, false)
        );
    }

    @RepeatedTest(3)
    public void correctPersonDefaultConstructor() throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object person = personClass.createInstance();
        assertEquals(defaultName, personClass.getFieldValue(person, "name"),
                "Your Person default constructor does not initialize the name field to the correct value.");
        assertEquals(defaultAge, personClass.getFieldValue(person, "age"),
                "Your Person default constructor does not initialize the age field to the correct value.");
        assertEquals(defaultEmployed, personClass.getFieldValue(person, "employed"),
                "Your Person default constructor does not initialize the employed field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void correctPersonStringConstructor(String name) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = {{name, String.class}};
        Object person = personClass.createInstance(arguments);
        assertEquals(name, personClass.getFieldValue(person, "name"),
                "Your Person String name constructor does not initialize the name field to the correct value.");
        assertEquals(defaultAge, personClass.getFieldValue(person, "age"),
                "Your default Person constructor does not initialize the age field to the correct value.");
        assertEquals(defaultEmployed, personClass.getFieldValue(person, "employed"),
                "Your default Person constructor does not initialize the employed field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctPersonIntConstructor(int age) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = new Object[][]{
                {age, int.class}
        };
        Object person = personClass.createInstance(arguments);
        assertEquals(defaultName, personClass.getFieldValue(person, "name"),
                "Your Person String name constructor does not initialize the name field to the correct value.");
        assertEquals(age, personClass.getFieldValue(person, "age"),
                "Your Person String name constructor does not initialize the age field to the correct value.");
        assertEquals(defaultEmployed, personClass.getFieldValue(person, "employed"),
                "Your Person String name constructor does not initialize the employed field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("booleanInputProvider")
    public void correctPersonBooleanConstructor(boolean employed) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = new Object[][]{
                {employed, boolean.class}
        };
        Object person = personClass.createInstance(arguments);
        assertEquals(defaultName, personClass.getFieldValue(person, "name"),
                "Your Person boolean employed constructor does not initialize the name field to the correct value.");
        assertEquals(defaultAge, personClass.getFieldValue(person, "age"),
                "Your Person boolean employed constructor does not initialize the age field to the correct value.");
        assertEquals(employed, personClass.getFieldValue(person, "employed"),
                "Your Person boolean employed constructor does not initialize the employed field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("stringIntInputProvider")
    public void correctPersonStringIntConstructor(String name, int age) throws Throwable {
        ObjectTest objectTest = new ObjectTest(personClassString);
        Object[][] arguments = new Object[][]{
                {name, String.class},
                {age, int.class}
        };
        Object person = objectTest.createInstance(arguments);
        assertEquals(name, objectTest.getFieldValue(person, "name"),
                "Your Person String name, int age constructor does not initialize the name field to the correct value.");
        assertEquals(age, objectTest.getFieldValue(person, "age"),
                "Your Person String name, int age constructor does not initialize the age field to the correct value.");
        assertEquals(defaultEmployed, objectTest.getFieldValue(person, "employed"),
                "Your Person String name, int age constructor does not initialize the employed field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("stringBooleanInputProvider")
    public void correctPersonStringBooleanConstructor(String name, boolean employed) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = new Object[][]{
                {name, String.class},
                {employed, boolean.class}
        };
        Object person = personClass.createInstance(arguments);
        assertEquals(name, personClass.getFieldValue(person, "name"),
                "Your Person String name, int age constructor does not initialize the name field to the correct value.");
        assertEquals(defaultAge, personClass.getFieldValue(person, "age"),
                "Your Person String name, int age constructor does not initialize the age field to the correct value.");
        assertEquals(employed, personClass.getFieldValue(person, "employed"),
                "Your Person String name, int age constructor does not initialize the employed field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("intBooleanInputProvider")
    public void correctPersonIntBooleanInputProvider(int age, boolean employed) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = new Object[][]{
                {age, int.class},
                {employed, boolean.class}
        };
        Object person = personClass.createInstance(arguments);
        assertEquals(defaultName, personClass.getFieldValue(person, "name"),
                "Your Person int age, boolean employed constructor does not initialize the name field to the correct value.");
        assertEquals(age, personClass.getFieldValue(person, "age"),
                "Your Person int age, boolean employed constructor does not initialize the age field to the correct value.");
        assertEquals(employed, personClass.getFieldValue(person, "employed"),
                "Your Person int age, boolean employed constructor does not initialize the employed field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("stringIntBooleanInputProvider")
    public void correctPersonStringIntBooleanConstructor(String name, int age, boolean employed) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = new Object[][]{
                {name, String.class},
                {age, int.class},
                {employed, boolean.class}
        };
        Object person = personClass.createInstance(arguments);
        assertEquals(name, personClass.getFieldValue(person, "name"),
                "Your Person String name, int age, boolean employed constructor does not initialize the name field to the correct value.");
        assertEquals(age, personClass.getFieldValue(person, "age"),
                "Your Person String name, int age, boolean employed constructor does not initialize the age field to the correct value.");
        assertEquals(employed, personClass.getFieldValue(person, "employed"),
                "Your Person String name, int age, boolean employed constructor does not initialize the employed field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void correctGetNameMethod(String name) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = {{name, String.class}};
        Object person = personClass.createInstance(arguments);
        String[] modifiers = {"public"};
        Object output = personClass.callMethod("getName", modifiers, person);
        assertEquals(name, output, "Your getName method does not return the value of the name field.");
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void correctSetNameMethod(String name) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object person = personClass.createInstance();
        Object[][] arguments = {{name, String.class}};
        String[] modifiers = {"public"};
        personClass.callMethod("setName", arguments, modifiers, person);
        Object updatedName = personClass.getFieldValue(person, "name");
        assertEquals(name, updatedName, "Your setName method does not update the value of the name field.");
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctGetAgeMethod(int age) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = {{age, int.class}};
        Object person = personClass.createInstance(arguments);
        String[] modifiers = {"public"};
        Object output = personClass.callMethod("getAge", modifiers, person);
        assertEquals(age, output, "Your getAge method does not return the value of the age field.");
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctSetAgeMethod(int age) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object person = personClass.createInstance();
        Object[][] arguments = {{age, int.class}};
        String[] modifiers = {"public"};
        personClass.callMethod("setAge", arguments, modifiers, person);
        Object updatedAge = personClass.getFieldValue(person, "age");
        assertEquals(age, updatedAge, "Your setAge method does not update the value of the age field.");
    }

    @ParameterizedTest
    @MethodSource("booleanInputProvider")
    public void correctIsEmployedMethod(boolean employed) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = {{employed, boolean.class}};
        String[] modifiers = {"public"};
        Object person = personClass.createInstance(arguments);
        Object output = personClass.callMethod("isEmployed", modifiers, person);
        assertEquals(employed, output, "Your isEmployed method does not return the value of the employed field.");
    }

    @ParameterizedTest
    @MethodSource("booleanBooleanInputProvider")
    public void correctSetEmployedMethod(boolean initialEmployed, boolean updateEmployed) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] constructionArguments = {{initialEmployed, boolean.class}};
        Object person = personClass.createInstance(constructionArguments);
        Object[][] arguments = {{updateEmployed, boolean.class}};
        String[] modifiers = {"public"};
        personClass.callMethod("setEmployed", arguments, modifiers, person);
        Object updatedAge = personClass.getFieldValue(person, "employed");
        assertEquals(updateEmployed, updatedAge, "Your setEmployed method does not update the value of the employed field.");
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void correctPrintNameMethod(String name) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        Object[][] arguments = {{name, String.class}};
        Object person = personClass.createInstance(arguments);
        String[] modifiers = {"public"};
        Clause[] methodSentence = {
                new StringLiteral(name)
        };
        personClass.callMethod("printName", modifiers, person, methodSentence,
                "Your printName method in the Person class does not correctly print the name field.");
    }

    @Test
    public void programContainsHouseClass() {
        new ObjectTest(houseClassString);
    }

    @Test
    public void houseClassHasRequiredFields() {
        ObjectTest objectTest = new ObjectTest(houseClassString);
        ObjectTest person = new ObjectTest(personClassString);
        assertTrue(objectTest.hasField("residents", person.getObjectClass().arrayType()),
                "Your House class is missing the Person[] residents field.");
        assertTrue(objectTest.hasModifier("residents", "private"),
                "Your House class residents field does not have the correct modifiers.");
        assertTrue(objectTest.hasField("number", int.class),
                "Your House class is missing the int number field.");
        assertTrue(objectTest.hasModifier("number", "private"),
                "Your House class number field does not have the correct modifiers.");
        assertTrue(objectTest.hasField("address", String.class),
                "Your House class is missing the String address field.");
        assertTrue(objectTest.hasModifier("address", "private"),
                "Your House class address filed does not have the correct modifiers.");
    }

    private static Stream<Arguments> intStringInputProvider() {
        return Stream.of(
                Arguments.of(2421, "Medicine Hat"),
                Arguments.of(69, "Kelowna Ave, Toronto"),
                Arguments.of(223412521, "Another Road Name Here")
        );
    }

    private static Stream<Arguments> intStringPersonArrayInputProvider() {
        return Stream.of(
                Arguments.of(12, "Grimmauld Place", new Object[][][]{
                        {}, {{4, int.class}}, {{"John", String.class}, {4, int.class}, {true, boolean.class}}}),
                Arguments.of(35512, "Not an adddress really", new Object[][][]{
                        {
                                {"My name", String.class},
                                {349234, int.class},
                        },
                        {
                                {true, boolean.class}
                        },
                        {},
                        {
                                {"Joe", String.class},
                                {true, boolean.class}
                        },
                        {},
                        {}
                })
        );
    }

    @RepeatedTest(3)
    public void houseClassHasCorrectDefaultConstructor() throws Throwable {
        ObjectTest houseClass = new ObjectTest(this.houseClassString);
        ObjectTest personClass = new ObjectTest(this.personClassString);
        int defaultNumber = 0;
        String defaultAddress = "nowhere";
        Object defaultResidents = personClass.createArray(0);
        Object house = houseClass.createInstance();
        assertEquals(defaultAddress, houseClass.getFieldValue(house, "address"),
                "Your House default constructor does not initialize the address field to the correct value.");
        assertEquals(defaultNumber, houseClass.getFieldValue(house, "number"),
                "Your House default constructor does not initialize the address field to the correct value.");
        _assertArrayEquals(defaultResidents, houseClass.getFieldValue(house, "residents"),
                "Your House default constructor does not initialize the residents field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("intStringInputProvider")
    public void houseClassHasCorrectIntStringConstructor(int number, String address) throws Throwable {
        ObjectTest houseClass = new ObjectTest(this.houseClassString);
        ObjectTest personClass = new ObjectTest(this.personClassString);
        Object defaultResidents = personClass.createArray(0);
        Object[][] arguments = {
                {number, int.class},
                {address, String.class}
        };
        Object house = houseClass.createInstance(arguments);
        assertEquals(address, houseClass.getFieldValue(house, "address"),
                "Your House(int, String) constructor does not initialize the address field to the correct value.");
        assertEquals(number, houseClass.getFieldValue(house, "number"),
                "Your House(int, String) constructor does not initialize the number field to the correct value.");
        _assertArrayEquals(defaultResidents, houseClass.getFieldValue(house, "residents"),
                "Your House(int, String) constructor does not initialize the residents field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("intStringPersonArrayInputProvider")
    public void houseClassHasCorrectIntStringPersonConstructor(int number, String address, Object[][][] residents) throws Throwable {
        ObjectTest houseClass = new ObjectTest(this.houseClassString);
        ObjectTest personClass = new ObjectTest(this.personClassString);
        Object o = personClass.createArray(residents.length, residents);
        Object[][] arguments = {
                {number, int.class},
                {address, String.class},
                {o, personClass.getObjectClass().arrayType()}
        };
        Object house = houseClass.createInstance(arguments);
        assertEquals(address, houseClass.getFieldValue(house, "address"),
                "Your House(int, String, Person[]) constructor does not initialize the address field to the correct value.");
        assertEquals(number, houseClass.getFieldValue(house, "number"),
                "Your House(int, String, Person[]) constructor does not initialize the number field to the correct value.");
        _assertArrayEquals(o, houseClass.getFieldValue(house, "residents"),
                "Your House(int, String, Person[]) constructor does not initialize the residents field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("intStringPersonArrayInputProvider")
    public void correctHouseGetResidentsMethod(int number, String address, Object[][][] residents) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        ObjectTest houseClass = new ObjectTest(houseClassString);
        Object residentsArray = personClass.createArray(residents.length, residents);
        Object[][] arguments = {
                {number, int.class},
                {address, String.class},
                {residentsArray, personClass.getObjectClass().arrayType()}
        };
        Object house = houseClass.createInstance(arguments);
        String[] modifiers = {"public"};
        Object output = houseClass.callMethod("getResidents", modifiers, house);
        _assertArrayEquals(residentsArray, output,
                "The getResidents method in your House class does not return the correct value for the residents field.");
    }

    @ParameterizedTest
    @MethodSource("intStringPersonArrayInputProvider")
    public void correctHouseSetResidentsMethod(int number, String address, Object[][][] residents) throws Throwable {
        ObjectTest personClass = new ObjectTest(personClassString);
        ObjectTest houseClass = new ObjectTest(houseClassString);
        Object residentsArray = personClass.createArray(residents.length, residents);
        Object[][] arguments = {
                {number, int.class},
                {address, String.class}
        };
        Object house = houseClass.createInstance(arguments);
        String[] modifiers = {"public"};
        Object[][] methodArguments = {
                {residentsArray, personClass.getObjectArrayClass()}
        };
        houseClass.callMethod("setResidents", methodArguments, modifiers, house);
        Object updatedResidents = houseClass.getFieldValue(house, "residents");
        _assertArrayEquals(residentsArray, updatedResidents,
                "The setResidents method in your House class does not correctly update the residents field.");
    }

    @ParameterizedTest
    @MethodSource("intStringInputProvider")
    public void correctHouseGetNumberMethod(int number, String address) throws Throwable {
        ObjectTest houseClass = new ObjectTest(houseClassString);
        Object[][] arguments = {
                {number, int.class},
                {address, String.class}
        };
        Object house = houseClass.createInstance(arguments);
        String[] modifiers = {"public"};
        Object methodOutput = houseClass.callMethod("getNumber", modifiers, house);
        assertEquals(number, methodOutput,
                "Your House class getNumber method does not return the correct value for the number field.");
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctHouseSetNumberMethod(int number) throws Throwable {
        ObjectTest houseClass = new ObjectTest(houseClassString);
        Object house = houseClass.createInstance();
        String[] modifiers = {"public"};
        Object[][] methodArguments = {
                {number, int.class}
        };
        houseClass.callMethod("setNumber", methodArguments, modifiers, house);
        Object updatedNumber = houseClass.getFieldValue(house, "number");
        assertEquals(number, updatedNumber,
                "Your House class getNumber method does not return the correct value for the number field.");
    }

    @ParameterizedTest
    @MethodSource("intStringInputProvider")
    public void correctHouseGetAddressMethod(int number, String address) throws Throwable {
        ObjectTest houseClass = new ObjectTest(houseClassString);
        Object[][] arguments = {
                {number, int.class},
                {address, String.class}
        };
        Object house = houseClass.createInstance(arguments);
        String[] modifiers = {"public"};
        Object methodOutput = houseClass.callMethod("getAddress", modifiers, house);
        assertEquals(address, methodOutput,
                "Your House class getAddress method does not return the correct value for the address field.");
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void correctHouseSetAddressMethod(String address) throws Throwable {
        ObjectTest houseClass = new ObjectTest(houseClassString);
        Object house = houseClass.createInstance();
        String[] modifiers = {"public"};
        Object[][] methodArguments = {
                {address, String.class}
        };
        houseClass.callMethod("setAddress", methodArguments, modifiers, house);
        Object updatedNumber = houseClass.getFieldValue(house, "address");
        assertEquals(address, updatedNumber,
                "Your House class getNumber method does not return the correct value for the number field.");
    }

    @RepeatedTest(3)
    public void correctHouseMessageMethod() throws Throwable {
        ObjectTest houseClass = new ObjectTest(houseClassString);
        Clause[] methodOutput = {
                new StringLiteral("This is a house")
        };
        String[] modifiers = {"public", "static"};
        houseClass.callMethod("houseMessage", methodOutput,
                "Your House class houseMessage method does not print the correct message.");
    }
}
