package oop.programs_with_interesting_classes.medium.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    /* Parsons Question */
    private ObjectTest car;
    private ObjectTest collision;
    private final String carClassName = "Car";
    private final String collisionClassName = "Collision";
    private final String stringAttributeName = "name";
    private final String doubleAttributeName = "speed";
    private final String stringArrayAttributeName = "parts";
    private final String getNameMethodName = "getName";
    private final String setNameMethodName = "setName";
    private final String getPartsMethodName = "getParts";
    private final String setPartsMethodName = "setParts";
    private final String getSpeedMethodName = "getSpeed";
    private final String setSpeedMethodName = "setSpeed";
    private final String collideMethodName = "collide";
    private final String[] expectedPartsArray =
            new String[]{"Wheels", "Chassis", "Steering", "BodyKit", "Windows", "Doors", "Seats"};
    private final int collisionPartsDifference = 2;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.medium.q1.";
        car = new ObjectTest(packageString + carClassName);
        collision = new ObjectTest(packageString + collisionClassName);
    }

    /* Test if the car class has the required attributes */

    @Test
    public void carClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(car.hasField(stringAttributeName), String.format(missingAttribute, carClassName, stringAttributeName));
        assertTrue(car.hasField(stringAttributeName, String.class), String.format(incorrectType, stringAttributeName));
        assertTrue(car.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(car.hasField(doubleAttributeName), String.format(missingAttribute, carClassName, doubleAttributeName));
        assertTrue(car.hasField(doubleAttributeName, double.class), String.format(incorrectType, doubleAttributeName));
        assertTrue(car.hasModifier(doubleAttributeName, "private"), String.format(incorrectModifier, doubleAttributeName));
        assertTrue(car.hasField(stringArrayAttributeName), String.format(missingAttribute, carClassName, stringArrayAttributeName));
        assertTrue(car.hasField(stringArrayAttributeName, String[].class), String.format(incorrectType, stringArrayAttributeName));
        assertTrue(car.hasModifier(stringArrayAttributeName, "private"), String.format(incorrectModifier, stringArrayAttributeName));
    }

    /* Test Car Constructor */

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("George", 15.234),
                Arguments.of("Mazda zooooom", 3412.23),
                Arguments.of("Fiat 500", 0.00)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void carClassHasRequiredConstructor(String name, double speed) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, double.class};
        assertTrue(car.hasConstructor(constructorParameters), String.format(missingConstructor, carClassName));
        assertTrue(car.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, carClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        String incorrectArray = "Your %s constructor does not initialize the %s array to the correct value. Make sure each item is spelt correctly and it is in the order as listed in the question text.";
        Object[][] constructorArguments = {
                {name, String.class},
                {speed, double.class}
        };
        Object carInstance = car.createInstance(constructorArguments);
        _assertEquals(name, car.getFieldValue(carInstance, stringAttributeName), String.format(incorrectValue, carClassName, stringAttributeName));
        _assertEquals(speed, car.getFieldValue(carInstance, doubleAttributeName), String.format(incorrectValue, carClassName, doubleAttributeName));
        _assertArrayEquals(expectedPartsArray, car.getFieldValue(carInstance, stringArrayAttributeName), String.format(incorrectArray, carClassName, stringAttributeName));
    }

    /* Test Car Methods */

    private static Stream<Arguments> setNameInputProvider() {
        return Stream.of(
                Arguments.of("My car name", "Your car name"),
                Arguments.of("Ford F-150", "Volkswagen Beetle"),
                Arguments.of("", "Zoomies")
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
        assertTrue(car.hasMethod(setNameMethodName, methodClassParameters),
                String.format(incorrectDefinition, carClassName, setNameMethodName));
        assertTrue(car.hasModifier(setNameMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setNameMethodName));
        assertTrue(car.hasReturnType(setNameMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setNameMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {initialName, String.class},
                {60.0, double.class}
        };
        Object carInstance = car.createInstance(constructorArguments);

        /* Call setName on car */
        Object[][] methodArgs = {{updatedName, String.class}};
        car.callMethod(setNameMethodName, methodArgs, carInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        _assertEquals(updatedName, car.getFieldValue(carInstance, stringAttributeName),
                String.format(incorrectUpdate, setNameMethodName, stringAttributeName));
    }

    private static Stream<String> getNameInputProvider() {
        return Stream.of("Toyota Corolla", "George W. Bush", "123 ABC", "");
    }

    @ParameterizedTest
    @MethodSource("getNameInputProvider")
    public void correctGetNameMethod(String name) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(car.hasMethod(getNameMethodName, null),
                String.format(incorrectDefinition, carClassName, getNameMethodName));
        assertTrue(car.hasModifier(getNameMethodName, null, "public"),
                String.format(incorrectModifier, getNameMethodName));
        assertTrue(car.hasReturnType(getNameMethodName, null, String.class),
                String.format(incorrectReturnType, getNameMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {name, String.class},
                {30.32, double.class}
        };
        Object carInstance = car.createInstance(constructorArguments);

        /* Call getName on car */
        Object getNameOutput = car.callMethod(getNameMethodName, carInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(name, getNameOutput, String.format(incorrectUpdate, getNameMethodName, stringAttributeName));
    }

    private static Stream<Arguments> setSpeedInputProvider() {
        return Stream.of(
                Arguments.of(0.00, 60.342),
                Arguments.of(113.12, 0.00),
                Arguments.of(10.02, 10.02)
        );
    }

    @ParameterizedTest
    @MethodSource("setSpeedInputProvider")
    public void correctSetSpeedMethod(double initialSpeed, double updatedSpeed) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{double.class};
        assertTrue(car.hasMethod(setSpeedMethodName, methodClassParameters),
                String.format(incorrectDefinition, carClassName, setSpeedMethodName));
        assertTrue(car.hasModifier(setSpeedMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setSpeedMethodName));
        assertTrue(car.hasReturnType(setSpeedMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setSpeedMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Just another car", String.class},
                {initialSpeed, double.class}
        };
        Object carInstance = car.createInstance(constructorArguments);

        /* Call setName on car */
        Object[][] methodArgs = {{updatedSpeed, double.class}};
        car.callMethod(setSpeedMethodName, methodArgs, carInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        _assertEquals(updatedSpeed, car.getFieldValue(carInstance, doubleAttributeName), 0.001,
                String.format(incorrectUpdate, setSpeedMethodName, doubleAttributeName));
    }

    private static Stream<Double> getSpeedInputProvider() {
        return Stream.of(0.0, 10.234, 403.946, 111.111);
    }

    @ParameterizedTest
    @MethodSource("getSpeedInputProvider")
    public void correctGetSpeedMethod(double speed) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(car.hasMethod(getSpeedMethodName, null),
                String.format(incorrectDefinition, carClassName, getSpeedMethodName));
        assertTrue(car.hasModifier(getSpeedMethodName, null, "public"),
                String.format(incorrectModifier, getSpeedMethodName));
        assertTrue(car.hasReturnType(getSpeedMethodName, null, double.class),
                String.format(incorrectReturnType, getSpeedMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Katie", String.class},
                {speed, double.class}
        };
        Object carInstance = car.createInstance(constructorArguments);

        /* Call getName on car */
        Object getNameOutput = car.callMethod(getSpeedMethodName, carInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(speed, getNameOutput, 0.001,
                String.format(incorrectUpdate, getSpeedMethodName, doubleAttributeName));
    }

    private static Stream<Arguments> partsInputProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{}),
                Arguments.of((Object) new String[]{"some", "other", "parts"}),
                Arguments.of((Object) new String[]{"Car"}),
                Arguments.of((Object) new String[]{"Wheels", "Chassis", "Steering", "BodyKit", "Windows", "Doors", "Seats"})
        );
    }

    @ParameterizedTest
    @MethodSource("partsInputProvider")
    public void correctSetPartsMethod(String[] parts) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(car.hasMethod(setPartsMethodName, methodClassParameters),
                String.format(incorrectDefinition, carClassName, setPartsMethodName));
        assertTrue(car.hasModifier(setPartsMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setPartsMethodName));
        assertTrue(car.hasReturnType(setPartsMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setPartsMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Just another car", String.class},
                {51.34, double.class}
        };
        Object carInstance = car.createInstance(constructorArguments);

        /* Call setParts on car */
        String[] partsCopy = new String[parts.length];
        System.arraycopy(parts, 0, partsCopy, 0, parts.length);
        Object[][] methodArgs = {{partsCopy, String[].class}};
        car.callMethod(setPartsMethodName, methodArgs, carInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        _assertArrayEquals(parts, car.getFieldValue(carInstance, stringArrayAttributeName),
                String.format(incorrectUpdate, setPartsMethodName, stringArrayAttributeName));
    }

    @ParameterizedTest
    @MethodSource("partsInputProvider")
    public void correctGetPartsMethod(String[] parts) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(car.hasMethod(getPartsMethodName, null),
                String.format(incorrectDefinition, carClassName, getPartsMethodName));
        assertTrue(car.hasModifier(getPartsMethodName, null, "public"),
                String.format(incorrectModifier, getPartsMethodName));
        assertTrue(car.hasReturnType(getPartsMethodName, null, String[].class),
                String.format(incorrectReturnType, getPartsMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Katie", String.class},
                {34.2223, double.class}
        };
        Object carInstance = car.createInstance(constructorArguments);

        /* Set parts field to passed value */
        String[] partsCopy = new String[parts.length];
        System.arraycopy(parts, 0, partsCopy, 0, parts.length);
        car.setFieldValue(carInstance, partsCopy, stringArrayAttributeName);

        /* Call getParts on car */
        Object getNameOutput = car.callMethod(getPartsMethodName, carInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertArrayEquals(parts, getNameOutput,
                String.format(incorrectUpdate, getPartsMethodName, stringArrayAttributeName));
    }

    private static Stream<Arguments> toStringInputProvider() {
        return Stream.of(
                Arguments.of("Another Random Car", 0.51, new String[]{"Wheel", "Motor", "Das Auto"}),
                Arguments.of("Volkswagen Golf", 345.12, new String[]{""}),
                Arguments.of("Fiat 500", 0.01, new String[]{}),
                Arguments.of("Dodge Grand Caravan", 187.66,
                        new String[]{"Wheels", "Chassis", "Steering", "BodyKit", "Windows", "Doors", "Seats"})
        );
    }

    private String expectedToString(String name, double speed, String[] parts) {
        return String.format("Car{name='%s', speed=%.2f, parts=%s}", name, speed, Arrays.toString(parts));
    }

    @ParameterizedTest
    @MethodSource("toStringInputProvider")
    public void correctToStringMethod(String name, double speed, String[] parts) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(car.hasMethod("toString", null),
                String.format(incorrectDefinition, carClassName, "toString"));
        assertTrue(car.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(car.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {"Kia Soul", String.class},
                {11.43, double.class}
        };
        Object carInstance = car.createInstance(constructorArguments);

        /* Set fields to values for test */
        car.setFieldValue(carInstance, name, stringAttributeName);
        car.setFieldValue(carInstance, speed, doubleAttributeName);
        String[] partsCopy = new String[parts.length];
        System.arraycopy(parts, 0, partsCopy, 0, parts.length);
        car.setFieldValue(carInstance, partsCopy, stringArrayAttributeName);

        /* Test output */
        String expectedOutput = expectedToString(name, speed, parts);
        Object actualOutput = car.callMethod("toString", carInstance);
        _assertEquals(expectedOutput, actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    private static Stream<Arguments> collideInputProvider() {
        return Stream.of(
                Arguments.of("Dodge Ram", 30.31, new String[]{"Chasis", "Body", "Headphones", "Windows"},
                        "Fiat 500", 30.32, new String[]{"Go cart"}),
                Arguments.of("Volkswagen Tiguan", 145.67, new String[]{"Teresa", "Cargo Bay", "Arduino Board", "Shotgun", "Yeti mug"},
                        "MAC TRUCK", 145.68, new String[]{"Nuclear Codes", "Justin", "Trump", "TI-89"}),
                Arguments.of("Ramonmobile", 404.304, new String[]{"MySQl Database", "Kevin's Cheat Codes"},
                        "Popemobile", 404.304, new String[]{"Pope", "Hat", "Holy Water"})
        );
    }

    @ParameterizedTest
    @MethodSource("collideInputProvider")
    public void collisionHasCorrectCollideMethod(String name1, double speed1, String[] parts1, String name2, double speed2, String[] parts2) throws Throwable {
        /* Check method parameters */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String incorrectStatic = "The %s method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{car.getObjectClass(), car.getObjectClass()};
        assertTrue(collision.hasMethod(collideMethodName, methodClassParameters),
                String.format(incorrectDefinition, collisionClassName, collideMethodName));
        assertTrue(collision.hasModifier(collideMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, collideMethodName));
        assertTrue(collision.hasReturnType(collideMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, collideMethodName));
        assertTrue(collision.hasModifier(collideMethodName, methodClassParameters, "static"),
                String.format(incorrectStatic, collideMethodName));

        /* Initialize objects for toString test */
        Object[][] constructorArguments = {
                {"", String.class},
                {0.00, double.class}
        };
        Object car1 = car.createInstance(constructorArguments);
        Object car2 = car.createInstance(constructorArguments);

        /* Make array copies */
        String[] partsCopy1 = new String[parts1.length];
        System.arraycopy(parts1, 0, partsCopy1, 0, parts1.length);
        String[] partsCopy2 = new String[parts2.length];
        System.arraycopy(parts2, 0, partsCopy2, 0, parts2.length);

        /* Set fields to values for test */
        car.setFieldValue(car1, name1, stringAttributeName);
        car.setFieldValue(car1, speed1, doubleAttributeName);
        car.setFieldValue(car1, partsCopy1, stringArrayAttributeName);
        car.setFieldValue(car2, name2, stringAttributeName);
        car.setFieldValue(car2, speed2, doubleAttributeName);
        car.setFieldValue(car2, partsCopy2, stringArrayAttributeName);

        /* Call collision */
        Object[][] collisionInput = {{car1, car.getObjectClass()}, {car2, car.getObjectClass()}};
        collision.callMethod(collideMethodName, collisionInput);

        /* Test output */
        if (speed1 == speed2) {
            String incorrectArray = String.format(
                    "Your %s method did not correctly modify the %s array when the %s of both %s objects were equal.",
                    collideMethodName,
                    stringArrayAttributeName,
                    doubleAttributeName,
                    carClassName
            );
            _assertArrayEquals(collisionArray(parts1), car.getFieldValue(car1, stringArrayAttributeName), incorrectArray);
            _assertArrayEquals(collisionArray(parts2), car.getFieldValue(car2, stringArrayAttributeName), incorrectArray);
        } else {
            String slowerCar = String.format(
                    "Your %s method did not correctly modify the %s array of the %s object that had a lower %s.",
                    collideMethodName,
                    stringArrayAttributeName,
                    carClassName,
                    doubleAttributeName
            );
            String fasterCar = String.format(
                    "Your %s method should not modify the %s array of the %s object that had a higher %s.",
                    collideMethodName,
                    stringArrayAttributeName,
                    carClassName,
                    doubleAttributeName
            );
            if (speed1 > speed2) {
                _assertArrayEquals(parts1, car.getFieldValue(car1, stringArrayAttributeName), fasterCar);
                _assertArrayEquals(collisionArray(parts2), car.getFieldValue(car2, stringArrayAttributeName), slowerCar);
            } else {
                _assertArrayEquals(collisionArray(parts1), car.getFieldValue(car1, stringArrayAttributeName), slowerCar);
                _assertArrayEquals(parts2, car.getFieldValue(car2, stringArrayAttributeName), fasterCar);
            }
        }
    }

    private String[] collisionArray(String[] array) {
        int length = array.length - collisionPartsDifference;
        String[] result = new String[length];
        System.arraycopy(array, 0, result, 0, length);
        return result;
    }
}
