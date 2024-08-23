package oop.programs_with_interesting_classes.hard.q8;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
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
    // Java question
    private ObjectTest course;
    private ObjectTest testSemester;
    private final String courseClassName = "Course";
    private final String testSemesterClassName = "TestSemester";
    private final String finalIntAttributeName1 = "STUDY_HOURS";
    private final String finalIntAttributeName2 = "HOMEWORK_HOURS";
    private final String finalStringAttributeName = "COURSE_CODE";
    private final String intAttributeName1 = "numExams";
    private final String intAttributeName2 = "numHwk";
    private final String calcWeeklyLoadMethodName = "calcWeeklyLoad";
    private final String getCOURSE_CODEMethodName = "getCOURSE_CODE";
    private final String setNumExamsMethodName = "setNumExams";
    private final String setNumHwkMethodName = "setNumHwk";
    private final String calculateWorkloadMethodName = "calculateWorkload";
    private final String displaySpareTimeMethodName = "displaySpareTime";
    private static final int sleep = 8;

    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q8.";
        course = new ObjectTest(packageString + courseClassName);
        testSemester = new ObjectTest(packageString + testSemesterClassName);
    }

    @Test
    public void courseClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct %s modifier.";
        assertTrue(course.hasField(finalIntAttributeName1), String.format(missingAttribute, courseClassName, finalIntAttributeName1));
        assertTrue(course.hasField(finalIntAttributeName1, int.class), String.format(incorrectTypeMessage, finalIntAttributeName1));
        assertTrue(course.hasModifier(finalIntAttributeName1, "private"), String.format(incorrectModifier, finalIntAttributeName1, "visibility"));
        assertTrue(course.hasModifier(finalIntAttributeName1, "final"), String.format(incorrectModifier, finalIntAttributeName1, "final"));
        assertTrue(course.hasField(finalIntAttributeName2), String.format(missingAttribute, courseClassName, finalIntAttributeName2));
        assertTrue(course.hasField(finalIntAttributeName2, int.class), String.format(incorrectTypeMessage, finalIntAttributeName2));
        assertTrue(course.hasModifier(finalIntAttributeName2, "private"), String.format(incorrectModifier, finalIntAttributeName2, "visibility"));
        assertTrue(course.hasModifier(finalIntAttributeName2, "final"), String.format(incorrectModifier, finalIntAttributeName2, "final"));
        assertTrue(course.hasField(finalStringAttributeName), String.format(missingAttribute, courseClassName, finalStringAttributeName));
        assertTrue(course.hasField(finalStringAttributeName, String.class), String.format(incorrectTypeMessage, finalStringAttributeName));
        assertTrue(course.hasModifier(finalStringAttributeName, "private"), String.format(incorrectModifier, finalStringAttributeName, "visibility"));
        assertTrue(course.hasModifier(finalStringAttributeName, "final"), String.format(incorrectModifier, finalStringAttributeName, "final"));
        assertTrue(course.hasField(intAttributeName1), String.format(missingAttribute, courseClassName, intAttributeName1));
        assertTrue(course.hasField(intAttributeName1, int.class), String.format(incorrectTypeMessage, intAttributeName1));
        assertTrue(course.hasModifier(intAttributeName1, "private"), String.format(incorrectModifier, intAttributeName1, "visibility"));
        assertTrue(course.hasField(intAttributeName2), String.format(missingAttribute, courseClassName, intAttributeName2));
        assertTrue(course.hasField(intAttributeName2, int.class), String.format(incorrectTypeMessage, intAttributeName2));
        assertTrue(course.hasModifier(intAttributeName2, "private"), String.format(incorrectModifier, intAttributeName2, "visibility"));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("", 0, 0, 0, 0),
                Arguments.of("VISA 106", 0, 3, 0, 10),
                Arguments.of("ENGL 153", 2, 2, 2, 2),
                Arguments.of("CCIV30110", 10, 11, 12, 13),
                Arguments.of("life idk 123", 1023, 4372, 5329, 1239)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void courseClassHasRequiredConstructor(String code, int exams, int homework, int study, int work) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, int.class, int.class, int.class, int.class};
        assertTrue(course.hasConstructor(constructorParameters), String.format(missingConstructor, courseClassName));
        assertTrue(course.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, courseClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{code, String.class}, {exams, int.class}, {homework, int.class}, {study, int.class}, {work, int.class}};
        Object courseInstance = course.createInstance(constructorArguments);

        String error = "Your %s constructor does not correctly initialize the %s attribute.";
        assertEquals(code, course.getFieldValue(courseInstance, finalStringAttributeName), String.format(error, courseClassName, finalStringAttributeName));
        assertEquals(study, course.getFieldValue(courseInstance, finalIntAttributeName1), String.format(error, courseClassName, finalIntAttributeName1));
        assertEquals(work, course.getFieldValue(courseInstance, finalIntAttributeName2), String.format(error, courseClassName, finalIntAttributeName2));
        assertEquals(exams, course.getFieldValue(courseInstance, intAttributeName1), String.format(error, courseClassName, intAttributeName1));
        assertEquals(homework, course.getFieldValue(courseInstance, intAttributeName2), String.format(error, courseClassName, intAttributeName2));
    }

    private static Stream<String> getCourseCodeInputProvider() {
        return Stream.of(
                "", "COSC 101", "CIV", "Intro to advanced fiction"
        );
    }

    @ParameterizedTest
    @MethodSource("getCourseCodeInputProvider")
    public void correctGetCOURSE_CODEMethod(String name) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(course.hasMethod(getCOURSE_CODEMethodName, null),
                String.format(incorrectDefinition, courseClassName, getCOURSE_CODEMethodName));
        assertTrue(course.hasModifier(getCOURSE_CODEMethodName, null, "public"),
                String.format(incorrectModifier, getCOURSE_CODEMethodName));
        assertTrue(course.hasReturnType(getCOURSE_CODEMethodName, null, String.class),
                String.format(incorrectReturnType, getCOURSE_CODEMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {name, String.class},
                {0, int.class},
                {0, int.class},
                {0, int.class},
                {0, int.class}
        };
        Object courseInstance = course.createInstance(constructorArguments);

        /* Call getCOURSE_CODE on course */
        Object output = course.callMethod(getCOURSE_CODEMethodName, courseInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(name, output, String.format(incorrectUpdate, getCOURSE_CODEMethodName, finalStringAttributeName));
    }

    private static Stream<Integer> numInputProvider() {
        return Stream.of(
               0, 1, 3, 554, 42452
        );
    }

    @ParameterizedTest
    @MethodSource("numInputProvider")
    public void correctSetNumExamsMethod(int num) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(course.hasMethod(setNumExamsMethodName, methodClassParameters),
                String.format(incorrectDefinition, courseClassName, setNumExamsMethodName));
        assertTrue(course.hasModifier(setNumExamsMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setNumExamsMethodName));
        assertTrue(course.hasReturnType(setNumExamsMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setNumExamsMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {0, int.class},
                {0, int.class},
                {0, int.class},
                {0, int.class}
        };
        Object courseInstance = course.createInstance(constructorArguments);

        /* Call setNumExams on course */
        Object[][] methodArguments = {{num, int.class}};
        course.callMethod(setNumExamsMethodName, methodArguments, courseInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the value of the %s attribute.";
        _assertEquals(num, course.getFieldValue(courseInstance, intAttributeName1), String.format(incorrectUpdate, setNumExamsMethodName, intAttributeName1));
        _assertEquals(0, course.getFieldValue(courseInstance, intAttributeName2), "Your " + setNumExamsMethodName + " method should not change the " + intAttributeName2 + " attribute value.");
    }

    @ParameterizedTest
    @MethodSource("numInputProvider")
    public void correctSetNumHwkMethod(int num) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(course.hasMethod(setNumHwkMethodName, methodClassParameters),
                String.format(incorrectDefinition, courseClassName, setNumHwkMethodName));
        assertTrue(course.hasModifier(setNumHwkMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setNumHwkMethodName));
        assertTrue(course.hasReturnType(setNumHwkMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setNumHwkMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"name", String.class},
                {0, int.class},
                {0, int.class},
                {0, int.class},
                {0, int.class}
        };
        Object courseInstance = course.createInstance(constructorArguments);

        /* Call setNumExams on course */
        Object[][] methodArguments = {{num, int.class}};
        course.callMethod(setNumHwkMethodName, methodArguments, courseInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the value of the %s attribute.";
        _assertEquals(num, course.getFieldValue(courseInstance, intAttributeName2), String.format(incorrectUpdate, setNumHwkMethodName, intAttributeName2));
        _assertEquals(0, course.getFieldValue(courseInstance, intAttributeName1), "Your " + setNumHwkMethodName + " method should not change the " + intAttributeName1 + " attribute value.");
    }

    private static Stream<Arguments> calcWeeklyLoadInputProvider() {
        return Stream.of(
                Arguments.of(1, 1, 1, 1, 2),
                Arguments.of(6, 6, 6, 6, 72),
                Arguments.of(0, 0, 0, 0, 0),
                Arguments.of(3, 2, 8, 9, 42),
                Arguments.of(80, 0, 5, 12, 400)
        );
    }

    @ParameterizedTest
    @MethodSource("calcWeeklyLoadInputProvider")
    public void correctCalcWeeklyLoadMethod(int exams, int homework, int study, int work, int ans) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(course.hasMethod(calcWeeklyLoadMethodName, null),
                String.format(incorrectDefinition, courseClassName, calcWeeklyLoadMethodName));
        assertTrue(course.hasModifier(calcWeeklyLoadMethodName, null, "public"),
                String.format(incorrectModifier, calcWeeklyLoadMethodName));
        assertTrue(course.hasReturnType(calcWeeklyLoadMethodName, null, int.class),
                String.format(incorrectReturnType, calcWeeklyLoadMethodName));

        Object[][] constructorArguments = {
                {"name", String.class},
                {exams, int.class},
                {homework, int.class},
                {study, int.class},
                {work, int.class}
        };
        Object courseInstance = course.createInstance(constructorArguments);

        /* Check method */
        Object result = course.callMethod(calcWeeklyLoadMethodName, courseInstance);
        assertEquals(ans, result, "Your " + calcWeeklyLoadMethodName + " method does not return the correct value. Check the values are being summed and multiplied correctly.");
    }

    private static Stream<Arguments> toStringInputProvider() {
        return Stream.of(
                Arguments.of("", 0, 0, "Course  has 0 homework assignments and 0 exams"),
                Arguments.of("COSC 111", 12, 3, "Course COSC 111 has 3 homework assignments and 12 exams"),
                Arguments.of("calculus 2", 1, 1274, "Course calculus 2 has 1274 homework assignments and 1 exams")
        );
    }

    @ParameterizedTest
    @MethodSource("toStringInputProvider")
    public void courseHasCorrectToStringMethod(String code, int exams, int homework, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(course.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, courseClassName, methodNameToString));
        assertTrue(course.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(course.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object[][] constructorArguments = {{code, String.class}, {exams, int.class}, {homework, int.class}, {0, int.class}, {0, int.class}};
        Object courseInstance = course.createInstance(constructorArguments);

        String result = (String) course.callMethod("toString", courseInstance);
        assertEquals(msg, result, "Your " + courseClassName + " toString method does not return the correct String. Check the formatting follows the description in the question text.");
    }

    private static Stream<Arguments> calculateWorkloadInputProvider() {
        return Stream.of(
                Arguments.of(1, new Object[][][]{{{"name", String.class}, {1, int.class}, {2, int.class}, {5, int.class}, {2, int.class}}}, 12),
                Arguments.of(3, new Object[][][]{{{"name", String.class}, {0, int.class}, {0, int.class}, {0, int.class}, {0, int.class}},
                        {{"name", String.class}, {3, int.class}, {7, int.class}, {1, int.class}, {4, int.class}},
                        {{"name", String.class}, {1, int.class}, {2, int.class}, {3, int.class}, {4, int.class}}}, 51),
                Arguments.of(6, new Object[][][]{{{"name", String.class}, {6, int.class}, {0, int.class}, {3, int.class}, {1, int.class}},
                        {{"name", String.class}, {7, int.class}, {7, int.class}, {7, int.class}, {7, int.class}},
                        {{"name", String.class}, {4, int.class}, {9, int.class}, {1, int.class}, {1, int.class}},
                        {{"name", String.class}, {2, int.class}, {1, int.class}, {4, int.class}, {3, int.class}},
                        {{"name", String.class}, {6, int.class}, {2, int.class}, {2, int.class}, {2, int.class}},
                        {{"name", String.class}, {3, int.class}, {2, int.class}, {3, int.class}, {2, int.class}}},
                        187)
        );
    }

    @ParameterizedTest
    @MethodSource("calculateWorkloadInputProvider")
    public void correctCalculateWorkloadMethod(int size, Object[][][] arguments, int ans) throws Throwable {
        /* Check method exists */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{course.getObjectArrayClass()};
        assertTrue(testSemester.hasMethod(calculateWorkloadMethodName, methodClassParameters),
                String.format(incorrectDefinition, testSemesterClassName, calculateWorkloadMethodName));
        assertTrue(testSemester.hasModifier(calculateWorkloadMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, calculateWorkloadMethodName));
        assertTrue(testSemester.hasReturnType(calculateWorkloadMethodName, methodClassParameters, int.class),
                String.format(incorrectReturnType, calculateWorkloadMethodName));


        Object[][] methodArguments = {{course.createArray(size, arguments), course.getObjectArrayClass()}};
        int output = (int) testSemester.callMethod(calculateWorkloadMethodName, methodArguments);

        assertEquals(ans, output, "Your " + testSemesterClassName + " " + calculateWorkloadMethodName + " method does not return the correct value.");
    }

    private static Stream<Arguments> displaySpareTimeInputProvider() {
        return Stream.of(
                Arguments.of(0, 168 - (7 * sleep)),
                Arguments.of(1, 167 - (7*sleep)),
                Arguments.of(56, 112 - (7*sleep)),
                Arguments.of(112, 56 - (7*sleep)),
                Arguments.of(168 - (7*sleep), 0),
                Arguments.of(30, 138 - (7*sleep))
        );
    }

    @ParameterizedTest
    @MethodSource("displaySpareTimeInputProvider")
    public void correctDisplaySpareTimeMethod(int input, int ans) throws Throwable {
        /* Check method exists */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(testSemester.hasMethod(displaySpareTimeMethodName, methodClassParameters),
                String.format(incorrectDefinition, testSemesterClassName, displaySpareTimeMethodName));
        assertTrue(testSemester.hasModifier(displaySpareTimeMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, displaySpareTimeMethodName));
        assertTrue(testSemester.hasReturnType(displaySpareTimeMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, displaySpareTimeMethodName));


        Object[][] methodArguments = {{input, int.class}};
        testSemester.callMethod(displaySpareTimeMethodName, methodArguments, new Clause[]{
                new StringLiteral("This week you will have " + ans + " hours of spare time."), new NewLine()},
                "Your " + testSemesterClassName + " " + displaySpareTimeMethodName + " method does not print the correct output. Ensure the message follows the formatting provided in the question text.");
    }

}
