package oop.programs_with_interesting_classes.hard.q10;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    // Java question
    private ObjectTest employee;
    private ObjectTest workSchedule;
    private final String employeeClassName = "Employee";
    private final String workScheduleClassName = "WorkSchedule";
    private final String stringAttributeName1 = "name";
    private final String booleanArrayAttributeName = "availability";
    private final String intAttributeName1 = "NUM_DAYS";
    private final String intAttributeName2= "NUM_SLOTS";
    private final String stringAttributeName2 = "week";
    private final String intArrayAttributeName = "timetable";
    private final String getAvailabilityMethodName = "getAvailability";
    private final String addTimeMethodName = "addTime";
    private final String howManyAvailableMethodName = "howManyAvailable";

    private final static int NUM_DAYS = 5;
    private final static int NUM_SLOTS = 4;

    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q10.";
        employee = new ObjectTest(packageString + employeeClassName);
        workSchedule = new ObjectTest(packageString + workScheduleClassName);
    }

    @Test
    public void employeeClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(employee.hasField(stringAttributeName1), String.format(missingAttribute, employeeClassName, stringAttributeName1));
        assertTrue(employee.hasField(stringAttributeName1, String.class), String.format(incorrectTypeMessage, stringAttributeName1));
        assertTrue(employee.hasModifier(stringAttributeName1, "private"), String.format(incorrectModifier, stringAttributeName1));
        assertTrue(employee.hasField(booleanArrayAttributeName), String.format(missingAttribute, employeeClassName, booleanArrayAttributeName));
        assertTrue(employee.hasField(booleanArrayAttributeName, boolean[][].class), String.format(incorrectTypeMessage, booleanArrayAttributeName));
        assertTrue(employee.hasModifier(booleanArrayAttributeName, "private"), String.format(incorrectModifier, booleanArrayAttributeName));
    }

    private static Stream<String> employeeConstructorInputProvider() {
        return Stream.of("", "Caroline", "Jack Daniel", "Name 123 321");
    }

    @ParameterizedTest
    @MethodSource("employeeConstructorInputProvider")
    public void employeeClassHasRequiredConstructor(String name) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class};
        assertTrue(employee.hasConstructor(constructorParameters), String.format(missingConstructor, employeeClassName));
        assertTrue(employee.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, employeeClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{name, String.class}};
        Object employeeInstance = employee.createInstance(constructorArguments);

        /* Check if the size of the array is correct */
        assertEquals(name, employee.getFieldValue(employeeInstance, stringAttributeName1),
                "Your " + employeeClassName + " constructor does not correctly initialize the " + stringAttributeName1 + " attribute.");
        boolean[][] grid = (boolean[][]) employee.getFieldValue(employeeInstance, booleanArrayAttributeName);
        assertEquals(NUM_DAYS, grid.length, String.format("Your %s array does not have the correct number of rows", booleanArrayAttributeName));
        for (int i = 0; i < NUM_DAYS; i++) {
            assertEquals(NUM_SLOTS, grid[i].length, String.format("Your %s array does not have the correct number of columns in each row.", booleanArrayAttributeName));
            for(int j = 0; j < NUM_SLOTS; j++){
                assertFalse(grid[i][j], "Your " + booleanArrayAttributeName + " array incorrectly contains a true value after initialization.");
            }
        }
    }

    private static Stream<boolean[][]> getAvailabilityInputProvider() {
        return Stream.of(
                new boolean[][]{{true, false, true}, {false, true, false}, {true, false, true}},
                new boolean[][]{{false, false}, {false, false}},
                new boolean[][]{{}},
                new boolean[][]{{true, true, true, true, false}, {true, true, true, false, true}, {true, true, false, true, true},
                        {true, false, true, true, true}, {false, true, true, true, true}}
        );
    }

    @ParameterizedTest
    @MethodSource("getAvailabilityInputProvider")
    public void correctGetAvailabilityMethod(boolean[][] in) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(employee.hasMethod(getAvailabilityMethodName, null),
                String.format(incorrectDefinition, employeeClassName, getAvailabilityMethodName));
        assertTrue(employee.hasModifier(getAvailabilityMethodName, null, "public"),
                String.format(incorrectModifier, getAvailabilityMethodName));
        assertTrue(employee.hasReturnType(getAvailabilityMethodName, null, boolean[][].class),
                String.format(incorrectReturnType, getAvailabilityMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class}
        };
        Object employeeInstance = employee.createInstance(constructorArguments);
        employee.setFieldValue(employeeInstance, in, booleanArrayAttributeName);

        /* Call getAvailability on employee */
        Object output = employee.callMethod(getAvailabilityMethodName, employeeInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertArrayEquals(in, output, String.format(incorrectUpdate, getAvailabilityMethodName, booleanArrayAttributeName));
    }

    private static Stream<Arguments> addTimeInputProvider() {
        return Stream.of(
                Arguments.of(0, 0, true),
                Arguments.of(3, 2, true),
                Arguments.of(4, 3, true),
                Arguments.of(5, 2, false),
                Arguments.of(2, 4, false),
                Arguments.of(5, 4, false)
        );
    }

    @ParameterizedTest
    @MethodSource("addTimeInputProvider")
    public void correctAddTimeMethod(int idx1, int idx2, boolean valid) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class, int.class};
        assertTrue(employee.hasMethod(addTimeMethodName, methodClassParameters),
                String.format(incorrectDefinition, employeeClassName, addTimeMethodName));
        assertTrue(employee.hasModifier(addTimeMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, addTimeMethodName));
        assertTrue(employee.hasReturnType(addTimeMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, addTimeMethodName));

        Object[][] constructorArguments = {{"name", String.class}};
        Object employeeInstance = employee.createInstance(constructorArguments);

        Object[][] insertInput = {{1, int.class}, {1, int.class}};
        employee.callMethod(addTimeMethodName, insertInput, employeeInstance);
        insertInput = new Object[][]{{idx1, int.class}, {idx2, int.class}};
        employee.callMethod(addTimeMethodName, insertInput, employeeInstance);
        boolean[][] grid = (boolean[][]) employee.getFieldValue(employeeInstance, booleanArrayAttributeName);

            for (int i = 0; i < NUM_DAYS; i++) {
                assertEquals(NUM_SLOTS, grid[i].length, String.format("Your %s array does not have the correct number of columns in each row.", booleanArrayAttributeName));
                for(int j = 0; j < NUM_SLOTS; j++){
                    if(i == idx1 && j == idx2)
                        assertTrue(grid[i][j], "Your " + addTimeMethodName + " method does not correctly alter the values of the " + booleanArrayAttributeName + " array.");
                    else if (i == 1 && j == 1){
                        assertTrue(grid[i][j], "Your " + addTimeMethodName + " method does not correctly alter the values of the " + booleanArrayAttributeName + " array.");
                    }
                    else
                        assertFalse(grid[i][j], "Your " + booleanArrayAttributeName + " array incorrectly contains a true value after initialization.");
                }
            }
    }

    private static Stream<Arguments> employeeToStringInputProvider() {
        return Stream.of(
                Arguments.of("Clarissa Reese", new boolean[][]{{false, false, false, false}, {false, false, false, false},
                        {false, false, false, false}, {false, false, false, false}, {false, false, false, false}},
                        "Availability for Clarissa Reese:\nMon: \nTue: \nWed: \nThu: \nFri: \n"),
                Arguments.of("Kate", new boolean[][]{{true, true, true, true}, {true, true, true, true}, {true, true, true, true},
                        {true, true, true, true}, {true, true, true, true}}, "Availability for Kate:\n" +
                        "Mon: 9am-noon, noon-3pm, 3-6pm, 6-9pm\nTue: 9am-noon, noon-3pm, 3-6pm, 6-9pm\nWed: 9am-noon, noon-3pm, 3-6pm, 6-9pm\n" +
                        "Thu: 9am-noon, noon-3pm, 3-6pm, 6-9pm\nFri: 9am-noon, noon-3pm, 3-6pm, 6-9pm\n"),
                Arguments.of("RKS 2024 OR", new boolean[][]{{false, false, true, false}, {false, false, true, false}, {false, true, false, true},
                        {false, false, false, true}, {false, false, false, false}}, "Availability for RKS 2024 OR:\nMon: 3-6pm\n" +
                        "Tue: 3-6pm\nWed: noon-3pm, 6-9pm\nThu: 6-9pm\nFri: \n")
        );
    }

    @ParameterizedTest
    @MethodSource("employeeToStringInputProvider")
    public void employeeHasCorrectToStringMethod(String name, boolean[][] in, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(employee.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, employeeClassName, methodNameToString));
        assertTrue(employee.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(employee.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object[][] constructorArguments = {{name, String.class}};
        Object employeeInstance = employee.createInstance(constructorArguments);

        employee.setFieldValue(employeeInstance, in, booleanArrayAttributeName);
        String result = (String) employee.callMethod("toString", employeeInstance);

        assertEquals(msg, result, "Your " + employeeClassName + " toString method does not return the correct String. Ensure the formatting specified in the question text has been followed.");
    }

    @Test
    public void workScheduleClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct %s modifier.";
        assertTrue(workSchedule.hasField(intAttributeName1), String.format(missingAttribute, workScheduleClassName, intAttributeName1));
        assertTrue(workSchedule.hasField(intAttributeName1, int.class), String.format(incorrectTypeMessage, intAttributeName1));
        assertTrue(workSchedule.hasModifier(intAttributeName1, "public"), String.format(incorrectModifier, intAttributeName1, "visibility"));
        assertTrue(workSchedule.hasModifier(intAttributeName1, "final"), String.format(incorrectModifier, intAttributeName1, "final"));
        assertTrue(workSchedule.hasModifier(intAttributeName1, "static"), String.format(incorrectModifier, intAttributeName1, "static"));
        assertTrue(workSchedule.hasField(intAttributeName2), String.format(missingAttribute, workScheduleClassName, intAttributeName2));
        assertTrue(workSchedule.hasField(intAttributeName2, int.class), String.format(incorrectTypeMessage, intAttributeName2));
        assertTrue(workSchedule.hasModifier(intAttributeName2, "public"), String.format(incorrectModifier, intAttributeName2, "visibility"));
        assertTrue(workSchedule.hasModifier(intAttributeName2, "final"), String.format(incorrectModifier, intAttributeName2, "final"));
        assertTrue(workSchedule.hasModifier(intAttributeName2, "static"), String.format(incorrectModifier, intAttributeName2, "static"));
        assertTrue(workSchedule.hasField(stringAttributeName2), String.format(missingAttribute, workScheduleClassName, stringAttributeName2));
        assertTrue(workSchedule.hasField(stringAttributeName2, String.class), String.format(incorrectTypeMessage, stringAttributeName2));
        assertTrue(workSchedule.hasModifier(stringAttributeName2, "private"), String.format(incorrectModifier, stringAttributeName2, "visibility"));
        assertTrue(workSchedule.hasField(intArrayAttributeName), String.format(missingAttribute, workScheduleClassName, intArrayAttributeName));
        assertTrue(workSchedule.hasField(intArrayAttributeName, int[][].class), String.format(incorrectTypeMessage, intArrayAttributeName));
        assertTrue(workSchedule.hasModifier(intArrayAttributeName, "private"), String.format(incorrectModifier, intArrayAttributeName, "visibility"));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("2nd of June", 0, new boolean[][][]{{{}}}, new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                        {0, 0, 0, 0}, {0, 0, 0, 0}}),//no people
                Arguments.of("Next week", 1, new boolean[][][]{{{true, true, false, false}, {true, false, true, false},
                        {false, false, false, false}, {false, false, true, true}, {false, false, true, false}}},
                        new int[][]{{1, 1, 0, 0}, {1, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 0}}), //one person
                Arguments.of("08-14", 5, new boolean[][][]{{{false, false, false, false}, {false, false, false, false},
                        {false, false, false, false}, {false, false, false, false}, {false, false, false, false}},
                        {{true, false, false, false}, {false, true, true, true}, {true, true, true, true}, {false,
                        true, true, false}, {false, false, false, true}}, {{true, true, true, true}, {true, true, true, true},
                        {true, true, true, true}, {true, true, true, false}, {true, true, true, true}}, {{true, false,
                        false, false}, {false, true, false, true}, {true, false, false, true}, {true, true, true, false},
                        {true, true, false, false}}, {{false, false, false, false}, {false, false, false, false},
                        {true, true, true, true}, {true, true, true, false}, {true, true, true, true}}},
                        new int[][]{{3, 1, 1, 1}, {1, 3, 2, 3}, {4, 3, 3, 4}, {3, 4, 4, 0}, {3, 3, 2, 3}}) // multiple people
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void workScheduleClassHasRequiredConstructor(String week, int length, boolean[][][] in, int[][] res) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, employee.getObjectArrayClass()};
        assertTrue(workSchedule.hasConstructor(constructorParameters), String.format(missingConstructor, workScheduleClassName));
        assertTrue(workSchedule.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, workScheduleClassName));

        /* Check constructor functionality */
        Object[] holdEmployees = (Object[]) employee.createArray(length, new Object[][]{{"name", String.class}});
        for(int x = 0; x < length; x++){
            employee.setFieldValue(holdEmployees[x], in[x], booleanArrayAttributeName);
        }
        Object[][] constructorArguments = {{week, String.class}, {holdEmployees, employee.getObjectArrayClass()}};
        Object workScheduleInstance = workSchedule.createInstance(constructorArguments);

        /* Check if the size of the array is correct */
        int[][] grid = (int[][]) workSchedule.getFieldValue(workScheduleInstance, intArrayAttributeName);
        assertEquals(NUM_DAYS, grid.length, String.format("Your %s array does not have the correct number of rows", intArrayAttributeName));
        for (int i = 0; i < NUM_DAYS; i++) {
            assertEquals(NUM_SLOTS, grid[i].length, String.format("Your %s array does not have the correct number of columns in each row.", intArrayAttributeName));
            for(int j = 0; j < NUM_SLOTS; j++){
                assertEquals(res[i][j], grid[i][j], "Your " + workScheduleClassName + " constructor does not properly process the " + employeeClassName + " array and compile the results into the " + intArrayAttributeName + " array.");
            }
        }

    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctHowManyAvailableMethod(String week, int length, boolean[][][] in, int[][] res) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{employee.getObjectArrayClass()};
        assertTrue(workSchedule.hasMethod(howManyAvailableMethodName, methodClassParameters),
                String.format(incorrectDefinition, employeeClassName, howManyAvailableMethodName));
        assertTrue(workSchedule.hasModifier(howManyAvailableMethodName, methodClassParameters, "private"),
                String.format(incorrectModifier, howManyAvailableMethodName));
        assertTrue(workSchedule.hasReturnType(howManyAvailableMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, howManyAvailableMethodName));

        /* Create instance of work schedule */
        Object[] holdEmptyArray = (Object[]) employee.createArray(1, new Object[][]{{"name", String.class}});
        employee.setFieldValue(holdEmptyArray[0], new boolean[NUM_DAYS][NUM_SLOTS], booleanArrayAttributeName);
        Object[][] constructorArguments = {{week, String.class}, {holdEmptyArray, employee.getObjectArrayClass()}};
        Object workScheduleInstance = workSchedule.createInstance(constructorArguments);

        Object[] holdEmployees = (Object[]) employee.createArray(length, new Object[][]{{"name", String.class}});
        for(int x = 0; x < length; x++){
            employee.setFieldValue(holdEmployees[x], in[x], booleanArrayAttributeName);
        }
        workSchedule.callMethod(howManyAvailableMethodName, new Object[][]{{holdEmployees, employee.getObjectArrayClass()}}, workScheduleInstance);

        /* Check if the size of the array is correct */
        int[][] grid = (int[][]) workSchedule.getFieldValue(workScheduleInstance, intArrayAttributeName);
        assertEquals(NUM_DAYS, grid.length, String.format("Your %s array does not have the correct number of rows", intArrayAttributeName));
        for (int i = 0; i < NUM_DAYS; i++) {
            assertEquals(NUM_SLOTS, grid[i].length, String.format("Your %s array does not have the correct number of columns in each row.", intArrayAttributeName));
            for(int j = 0; j < NUM_SLOTS; j++){
                assertEquals(res[i][j], grid[i][j], "Your " + howManyAvailableMethodName + " method does not properly process the " + employeeClassName + " array and compile the results into the " + intArrayAttributeName + " array.");
            }
        }
    }

    private static Stream<Arguments> workScheduleToStringInputProvider() {
        return Stream.of(
                Arguments.of("next week", new int[][]{{1, 2, 3, 4}, {2, 2, 2, 2}, {1, 3, 1, 1}, {7, 1, 1, 1}, {3, 4, 2, 2}},
                        "Number of employees available to work for each time slot: \nMon:  1  2  3  4\nTue:  2  2  2  2\n" +
                                "Wed:  1  3  1  1\nThu:  7  1  1  1\nFri:  3  4  2  2\n"),
                Arguments.of("08-14", new int[][]{{0, 1, 0, 0}, {2, 2, 1, 2}, {0, 0, 2, 0}, {3, 2, 0, 2}, {0, 3, 1, 0}},
                        "Number of employees available to work for each time slot: \nMon:  0  1  0  0\n" +
                                "Tue:  2  2  1  2\nWed:  0  0  2  0\nThu:  3  2  0  2\nFri:  0  3  1  0\n"),
                Arguments.of("2nd of June", new int[][]{{7, 11, 43, 1}, {27, 55, 12, 4}, {101, 4, 23, 11}, {5, 12, 87, 3},
                        {77, 33, 33, 7}}, "Number of employees available to work for each time slot: \nMon:  7  11  43  1\n" +
                        "Tue:  27  55  12  4\nWed:  101  4  23  11\nThu:  5  12  87  3\nFri:  77  33  33  7\n")
        );
    }

    @ParameterizedTest
    @MethodSource("workScheduleToStringInputProvider")
    public void workScheduleHasCorrectToStringMethod(String name, int[][] in, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(workSchedule.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, workScheduleClassName, methodNameToString));
        assertTrue(workSchedule.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(workSchedule.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object[] holdEmptyArray = (Object[]) employee.createArray(1, new Object[][]{{"name", String.class}});
        employee.setFieldValue(holdEmptyArray[0], new boolean[NUM_DAYS][NUM_SLOTS], booleanArrayAttributeName);
        Object[][] constructorArguments = {{name, String.class}, {holdEmptyArray, employee.getObjectArrayClass()}};
        Object workScheduleInstance = workSchedule.createInstance(constructorArguments);

        workSchedule.setFieldValue(workScheduleInstance, in, intArrayAttributeName);
        String result = (String) workSchedule.callMethod("toString", workScheduleInstance);

        assertEquals(msg, result, "Your " + workScheduleClassName + " toString method does not return the correct String. Ensure the formatting specified in the question text has been followed.");
    }
}
