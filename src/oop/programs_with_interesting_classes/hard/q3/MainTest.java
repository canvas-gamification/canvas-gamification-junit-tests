package oop.programs_with_interesting_classes.hard.q3;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private ObjectTest person;
    private ObjectTest team;
    private final String personClassName = "Person";
    private final String teamClassName = "Team";
    private final String stringAttributeName = "name";
    private final String intAttributeName1 = "programming";
    private final String intAttributeName2 = "communication";
    private final String personAttributeName = "members";
    private final String intAttributeName3 = "index";
    private final String getNameMethodName = "getName";
    private final String getProgrammingMethodName = "getProgramming";
    private final String getCommunicationMethodName = "getCommunication";
    private final String addMemberMethodName = "addMember";
    private final String getIndexMethodName = "getIndex";
    private final String getAverageSkillsMethodName = "getAverageSkills";

    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q3.";
        person = new ObjectTest(packageString + personClassName);
        team = new ObjectTest(packageString + teamClassName);
    }

    @Test
    public void personClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(person.hasField(stringAttributeName), String.format(missingAttribute, personClassName, stringAttributeName));
        assertTrue(person.hasField(stringAttributeName, String.class), String.format(incorrectTypeMessage, stringAttributeName));
        assertTrue(person.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(person.hasField(intAttributeName1), String.format(missingAttribute, personClassName, intAttributeName1));
        assertTrue(person.hasField(intAttributeName1, int.class), String.format(incorrectTypeMessage, intAttributeName1));
        assertTrue(person.hasModifier(intAttributeName1, "private"), String.format(incorrectModifier, intAttributeName1));
        assertTrue(person.hasField(intAttributeName2), String.format(missingAttribute, personClassName, intAttributeName2));
        assertTrue(person.hasField(intAttributeName2, int.class), String.format(incorrectTypeMessage, intAttributeName2));
        assertTrue(person.hasModifier(intAttributeName2, "private"), String.format(incorrectModifier, intAttributeName2));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Clary", 3, 1),
                Arguments.of("Jace Person", 4, 1),
                Arguments.of("Katie", 0, 0),
                Arguments.of("", 0, 0),
                Arguments.of("Terry 123", 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void personClassHasRequiredConstructor(String name, int programming, int communication) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, int.class, int.class};
        assertTrue(person.hasConstructor(constructorParameters), String.format(missingConstructor, personClassName));
        assertTrue(person.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, personClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{name, String.class}, {programming, int.class}, {communication, int.class}};
        Object personInstance = person.createInstance(constructorArguments);

        assertEquals(name, person.getFieldValue(personInstance, stringAttributeName),
                "Your " + personClassName + " constructor does not correctly initialize the " + stringAttributeName + " attribute.");
        assertEquals(programming, person.getFieldValue(personInstance, intAttributeName1),
                "Your " + personClassName + " constructor does not correctly initialize the " + intAttributeName1 + " attribute.");
        assertEquals(communication, person.getFieldValue(personInstance, intAttributeName2),
                "Your " + personClassName + " constructor does not correctly initialize the " + intAttributeName2 + " attribute.");
    }

    private static Stream<String> getNameInputProvider() {
        return Stream.of("Leiah", "Jason 123", "");
    }

    @ParameterizedTest
    @MethodSource("getNameInputProvider")
    public void correctGetNameMethod(String name) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(person.hasMethod(getNameMethodName, null),
                String.format(incorrectDefinition, personClassName, getNameMethodName));
        assertTrue(person.hasModifier(getNameMethodName, null, "public"),
                String.format(incorrectModifier, getNameMethodName));
        assertTrue(person.hasReturnType(getNameMethodName, null, String.class),
                String.format(incorrectReturnType, getNameMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {name, String.class},
                {0, int.class},
                {0, int.class}
        };
        Object personInstance = person.createInstance(constructorArguments);

        /* Call getName */
        Object output = person.callMethod(getNameMethodName, personInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(name, output, String.format(incorrectUpdate, getNameMethodName, stringAttributeName));
    }

    private static Stream<Integer> getIntInputProvider() {
        return Stream.of(0, 1, 2, 13, 4356);
    }

    @ParameterizedTest
    @MethodSource("getIntInputProvider")
    public void correctGetProgrammingMethod(int programming) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(person.hasMethod(getProgrammingMethodName, null),
                String.format(incorrectDefinition, personClassName, getProgrammingMethodName));
        assertTrue(person.hasModifier(getProgrammingMethodName, null, "public"),
                String.format(incorrectModifier, getProgrammingMethodName));
        assertTrue(person.hasReturnType(getProgrammingMethodName, null, int.class),
                String.format(incorrectReturnType, getProgrammingMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {programming, int.class},
                {0, int.class}
        };
        Object personInstance = person.createInstance(constructorArguments);

        /* Call getName */
        Object output = person.callMethod(getProgrammingMethodName, personInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(programming, output, String.format(incorrectUpdate, getProgrammingMethodName, intAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("getIntInputProvider")
    public void correctGetCommunicationMethod(int communication) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(person.hasMethod(getCommunicationMethodName, null),
                String.format(incorrectDefinition, personClassName, getCommunicationMethodName));
        assertTrue(person.hasModifier(getCommunicationMethodName, null, "public"),
                String.format(incorrectModifier, getCommunicationMethodName));
        assertTrue(person.hasReturnType(getCommunicationMethodName, null, int.class),
                String.format(incorrectReturnType, getCommunicationMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {0, int.class},
                {communication, int.class}
        };
        Object personInstance = person.createInstance(constructorArguments);

        /* Call getName */
        Object output = person.callMethod(getCommunicationMethodName, personInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(communication, output, String.format(incorrectUpdate, getCommunicationMethodName, intAttributeName2));
    }

    private static Stream<Arguments> personToStringInputProvider() {
        return Stream.of(
                Arguments.of("Saul", 3, 6, "Saul: 3, 6\n"),
                Arguments.of("Dela Madol", 1, 1, "Dela Madol: 1, 1\n"),
                Arguments.of("Nan", 0, 0, "Nan: 0, 0\n"),
                Arguments.of("", 3, 3, ": 3, 3\n")
        );
    }

    @ParameterizedTest
    @MethodSource("personToStringInputProvider")
    public void correctPersonToStringMethod(String name, int programming, int communication, String msg) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(person.hasMethod("toString", null),
                String.format(incorrectDefinition, personClassName, "toString"));
        assertTrue(person.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(person.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {name, String.class},
                {programming, int.class},
                {communication, int.class}
        };
        Object personInstance = person.createInstance(constructorArguments);

        /* Test output */
        Object actualOutput = person.callMethod("toString", personInstance);
        _assertEquals(msg, actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    @Test
    public void teamClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(team.hasField(personAttributeName), String.format(missingAttribute, teamClassName, personAttributeName));
        assertTrue(team.hasField(personAttributeName, person.getObjectArrayClass()), String.format(incorrectTypeMessage, personAttributeName));
        assertTrue(team.hasModifier(personAttributeName, "private"), String.format(incorrectModifier, personAttributeName));
    }

    private static Stream<Integer> teamConstructorInputProvider() {
        return Stream.of(0, 1, 2, 5, 67, 329);
    }

    @ParameterizedTest
    @MethodSource("teamConstructorInputProvider")
    public void teamClassHasRequiredConstructor(int size) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{int.class};
        assertTrue(team.hasConstructor(constructorParameters), String.format(missingConstructor, teamClassName));
        assertTrue(team.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, teamClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{size, int.class}};
        Object teamInstance = team.createInstance(constructorArguments);

        /* Check if the size of the grid is correct */
        assertArrayEquals((Object[]) person.createArray(size), (Object[]) team.getFieldValue(teamInstance, personAttributeName),
                String.format("Your %s constructor does not correctly initialize the %s name", teamClassName, personAttributeName));

    }

    private static Stream<Arguments> addMemberInputProvider() {
        return Stream.of(
                Arguments.of(0, new Object[][][]{{{}}}, 0, new Object[][]{{"Al", String.class}, {3, int.class}, {1, int.class}}, false),
                Arguments.of(1, new Object[][][]{{{"Jane", String.class}, {4, int.class}, {1, int.class}}}, 1,
                        new Object[][]{{"Naomi", String.class}, {5, int.class}, {3, int.class}}, false),
                Arguments.of(1, new Object[][][]{{{}}}, 0,
                        new Object[][]{{"Naomi", String.class}, {5, int.class}, {3, int.class}}, true),
                Arguments.of(5, new Object[][][]{{{"Isabelle", String.class}, {17, int.class}, {24, int.class}}, {{"Ahbi", String.class}, {45, int.class}, {12, int.class}}},
                        2, new Object[][]{{"Red3", String.class}, {3, int.class}, {1, int.class}}, true),
                Arguments.of(15, new Object[][][]{{{"Dorthy", String.class}, {2, int.class}, {2, int.class}}, {{"Farren", String.class}, {4, int.class}, {2, int.class}},
                                {{"Willow 123", String.class}, {7, int.class}, {13, int.class}}, {{"Darth", String.class}, {1, int.class}, {0, int.class}},
                                {{"Jason", String.class}, {4, int.class}, {153, int.class}}, {{"Karly", String.class}, {23, int.class}, {78, int.class}},
                                {{"Selene", String.class}, {3, int.class}, {14, int.class}}, {{"Percy", String.class}, {39, int.class}, {1, int.class}},
                                {{"Cari", String.class}, {832, int.class}, {47, int.class}}, {{"Nico", String.class}, {9, int.class}, {11, int.class}}},
                        10, new Object[][]{{"El", String.class}, {0, int.class}, {0, int.class}}, true),
                Arguments.of(10, new Object[][][]{{{"Dorthy", String.class}, {2, int.class}, {2, int.class}}, {{"Farren", String.class}, {4, int.class}, {2, int.class}},
                                {{"Willow 123", String.class}, {7, int.class}, {13, int.class}}, {{"Darth", String.class}, {1, int.class}, {0, int.class}},
                                {{"Jason", String.class}, {4, int.class}, {153, int.class}}, {{"Karly", String.class}, {23, int.class}, {78, int.class}},
                                {{"Selene", String.class}, {3, int.class}, {14, int.class}}, {{"Percy", String.class}, {39, int.class}, {1, int.class}},
                                {{"Cari", String.class}, {832, int.class}, {47, int.class}}, {{"Nico", String.class}, {9, int.class}, {11, int.class}}},
                        10, new Object[][]{{"Cassie", String.class}, {3, int.class}, {13, int.class}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("addMemberInputProvider")
    public void teamHasCorrectAddMemberMethod(int size, Object[][][] arguments, int index, Object[][] personArgument, boolean valid) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{person.getObjectClass()};
        assertTrue(team.hasMethod(addMemberMethodName, methodClassParameters),
                String.format(incorrectDefinition, teamClassName, addMemberMethodName));
        assertTrue(team.hasModifier(addMemberMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, addMemberMethodName));
        assertTrue(team.hasReturnType(addMemberMethodName, methodClassParameters, boolean.class),
                String.format(incorrectReturnType, addMemberMethodName));

        Object[][] constructorArguments = {{size, int.class}};
        Object teamInstance = team.createInstance(constructorArguments);

        Object[] studentArray = (Object[]) team.getFieldValue(teamInstance, personAttributeName);
        Object[] holdArray;
        /* Set attributes */
        if (arguments[0][0].length != 0) {
            holdArray = (Object[]) person.createArray(index, arguments);
            System.arraycopy(holdArray, 0, studentArray, 0, index);
        } else {
            holdArray = (Object[]) person.createArray(index);
            System.arraycopy(holdArray, 0, studentArray, 0, index);
        }
        team.setFieldValue(teamInstance, index, intAttributeName3);

        Object personInstance = person.createInstance(personArgument);
        boolean output = (boolean) team.callMethod(addMemberMethodName, new Object[][]{{personInstance, person.getObjectClass()}}, teamInstance);
        if (valid) {
            assertTrue(output, "Your " + addMemberMethodName + " method returned false on a valid operation.");
            assertEquals(studentArray[index], personInstance, "Your " + addMemberMethodName + " method does not correctly insert the " + personClassName + ".");
            String errorMsg = "Your " + addMemberMethodName + " method modifies the rest of the " + personAttributeName + " array.";
            for (int x = 0; x < index; x++) {
                assertEquals(holdArray[x], studentArray[x], errorMsg);
            }
            for (int x = index + 1; x < size; x++) {
                assertNull(studentArray[x], errorMsg);
            }
        } else {
            assertFalse(output, "Your " + addMemberMethodName + " method does not correctly identify invalid operations.");
            String errorMsg = "Your " + addMemberMethodName + " method modifies the " + personAttributeName + " array after invalid input.";
            for (int x = 0; x < index; x++) {
                assertEquals(holdArray[x], studentArray[x], errorMsg);
            }
            for (int x = index; x < size; x++) {
                assertNull(studentArray[x], errorMsg);
            }
        }
    }

    private static Stream<Integer> getIndexInputProvider() {
        return Stream.of(0, 1, 5, 6238);
    }

    @ParameterizedTest
    @MethodSource("getIndexInputProvider")
    public void correctGetIndexMethod(int index) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(team.hasMethod(getIndexMethodName, null),
                String.format(incorrectDefinition, teamClassName, getIndexMethodName));
        assertTrue(team.hasModifier(getIndexMethodName, null, "public"),
                String.format(incorrectModifier, getIndexMethodName));
        assertTrue(team.hasReturnType(getIndexMethodName, null, int.class),
                String.format(incorrectReturnType, getIndexMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {10, int.class}
        };
        Object teamInstance = team.createInstance(constructorArguments);
        team.setFieldValue(teamInstance, index, intAttributeName3);

        /* Call getIndex on team */
        Object output = team.callMethod(getIndexMethodName, teamInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(index, output, String.format(incorrectUpdate, getIndexMethodName, intAttributeName3));
    }

    private static Stream<Arguments> getAverageSkillsInputProvider() {
        return Stream.of(Arguments.of(
                        10, new Object[][][]{{{"namer", String.class}, {4, int.class}, {5, int.class}}, {{"Kris", String.class}, {0, int.class}, {1, int.class}},
                                {{"Carrie", String.class}, {5, int.class}, {5, int.class}}}, "Team's average skill level is:\n\t Programming:   3.0\n\t Communication: 3.6666666666666665\n",
                        3
                ),
                Arguments.of(
                        6, new Object[][][]{{{"Mary", String.class}, {3, int.class}, {13, int.class}}, {{"Rick Astley", String.class}, {4, int.class}, {0, int.class}},
                                {{"Wayweird", String.class}, {18, int.class}, {4, int.class}}, {{"Anne", String.class}, {4, int.class}, {4, int.class}},
                                {{"Agatha", String.class}, {37, int.class}, {73, int.class}}, {{"Sophie", String.class}, {7, int.class}, {-1, int.class}}},
                        "Team's average skill level is:\n\t Programming:   12.166666666666666\n\t Communication: 15.5\n",
                        6
                ),
                Arguments.of(
                        10, new Object[][][]{{{"Ally", String.class}, {0, int.class}, {0, int.class}}, {{"Page", String.class}, {0, int.class}, {0, int.class}},
                                {{"Katie", String.class}, {0, int.class}, {0, int.class}}}, "Team's average skill level is:\n\t Programming:   0.0\n\t Communication: 0.0\n",
                        3
                ),
                Arguments.of(
                        5, new Object[][][]{{{"Hippo", String.class}, {6, int.class}, {12, int.class}}},
                        "Team's average skill level is:\n\t Programming:   6.0\n\t Communication: 12.0\n",
                        1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getAverageSkillsInputProvider")
    public void correctGetAverageSkillsMethod(int size, Object[][][] arguments, String msg, int length) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(team.hasMethod(getAverageSkillsMethodName, null),
                String.format(incorrectDefinition, teamClassName, getAverageSkillsMethodName));
        assertTrue(team.hasModifier(getAverageSkillsMethodName, null, "public"),
                String.format(incorrectModifier, getAverageSkillsMethodName));
        assertTrue(team.hasReturnType(getAverageSkillsMethodName, null, String.class),
                String.format(incorrectReturnType, getAverageSkillsMethodName));

        /* Create instance of team */
        Object[][] constructorArguments = {{size, int.class}};
        Object teamInstance = team.createInstance(constructorArguments);

        Object[] studentArray = (Object[]) team.getFieldValue(teamInstance, personAttributeName);
        Object[] holdArray;
        if (length == 0) {
            holdArray = (Object[]) person.createArray(0);
        } else {
            holdArray = (Object[]) person.createArray(length, arguments);
        }
        System.arraycopy(holdArray, 0, studentArray, 0, length);
        team.setFieldValue(teamInstance, length, intAttributeName3);

        String output = (String) team.callMethod(getAverageSkillsMethodName, teamInstance);
        assertEquals(msg, output, "Your " + getAverageSkillsMethodName + " method does not return the correct output. Check that all the formatting matches the description in the question text.");
    }

    private static Stream<Arguments> teamToStringInputProvider() {
        return Stream.of(
                Arguments.of(0, new Object[][][]{{{}}}, 0, " "),
                Arguments.of(10, new Object[][][]{{{"Hop", String.class}, {3, int.class}, {4, int.class}}}, 1,
                        " Hop: 3, 4\n "),
                Arguments.of(10, new Object[][][]{{{"Lucas", String.class}, {8, int.class}, {0, int.class}},
                        {{"Murrey", String.class}, {4, int.class}, {748, int.class}}}, 2, " Lucas: 8, 0\n Murrey: 4, 748\n "),
                Arguments.of(5, new Object[][][]{{{"Bob", String.class}, {7, int.class}, {1, int.class}},
                                {{"Billy", String.class}, {2, int.class}, {78, int.class}}, {{"Kneil", String.class}, {3, int.class}, {19, int.class}},
                                {{"Flat Sharp", String.class}, {45, int.class}, {3718, int.class}}, {{"V", String.class}, {1, int.class}, {9, int.class}}},
                        5, " Bob: 7, 1\n Billy: 2, 78\n Kneil: 3, 19\n Flat Sharp: 45, 3718\n V: 1, 9\n ")
        );
    }

    @ParameterizedTest
    @MethodSource("teamToStringInputProvider")
    public void wordSearchHasCorrectToStringMethod(int size, Object[][][] arguments, int index, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(team.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, teamClassName, methodNameToString));
        assertTrue(team.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(team.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object teamInstance = team.createInstance(new Object[][]{{size, int.class}});


        team.setFieldValue(teamInstance, size == 0 ? person.createArray(0) : person.createArray(index, arguments), personAttributeName);
        team.setFieldValue(teamInstance, index, intAttributeName3);

        String result = (String) team.callMethod("toString", teamInstance);
        assertEquals(msg, result, "Your " + teamClassName + " toString method does not return the correct String. Check that it follows all the formatting specified in the question text.");
    }
}
