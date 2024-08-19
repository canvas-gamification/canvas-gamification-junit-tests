package oop.programs_with_interesting_classes.hard.q5;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private ObjectTest jobAd;
    private ObjectTest exploreJobs;
    private final String jobAdClassName = "JobAd";
    private final String exploreJobsClassName = "ExploreJobs";
    private final String stringAttributeName = "title";
    private final String intAttributeName1 = "salary";
    private final String stringArrayAttributeName = "skills";
    private final String intAttributeName2 = "numSkills";
    private final String addSkillMethodName = "addSkill";
    private final String getTitleMethodName = "getTitle";
    private final String getSalaryMethodName = "getSalary";
    private final String getSkillsMethodName = "getSkills";
    private final String displaySearchResultsMethodName = "displaySearchResults";
    private final String searchMinSalaryMethodName = "searchMinSalary";
    private final String whichJobsRequireMethodName = "whichJobsRequire";

    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";

    // Java question

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q5.";
        jobAd = new ObjectTest(packageString + jobAdClassName);
        exploreJobs = new ObjectTest(packageString + exploreJobsClassName);
    }

    @Test
    public void jobAdClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(jobAd.hasField(stringAttributeName), String.format(missingAttribute, jobAdClassName, stringAttributeName));
        assertTrue(jobAd.hasField(stringAttributeName, String.class), String.format(incorrectTypeMessage, stringAttributeName));
        assertTrue(jobAd.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(jobAd.hasField(intAttributeName1), String.format(missingAttribute, jobAdClassName, intAttributeName1));
        assertTrue(jobAd.hasField(intAttributeName1, int.class), String.format(incorrectTypeMessage, intAttributeName1));
        assertTrue(jobAd.hasModifier(intAttributeName1, "private"), String.format(incorrectModifier, intAttributeName1));
        assertTrue(jobAd.hasField(stringArrayAttributeName), String.format(missingAttribute, jobAdClassName, stringArrayAttributeName));
        assertTrue(jobAd.hasField(stringArrayAttributeName, String[].class), String.format(incorrectTypeMessage, stringArrayAttributeName));
        assertTrue(jobAd.hasModifier(stringArrayAttributeName, "private"), String.format(incorrectModifier, stringArrayAttributeName));
        assertTrue(jobAd.hasField(intAttributeName2), String.format(missingAttribute, jobAdClassName, intAttributeName2));
        assertTrue(jobAd.hasField(intAttributeName2, int.class), String.format(incorrectTypeMessage, intAttributeName2));
        assertTrue(jobAd.hasModifier(intAttributeName2, "private"), String.format(incorrectModifier, intAttributeName2));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Doctor", 160000),
                Arguments.of("Dr Dr Dr", 350),
                Arguments.of("", 0),
                Arguments.of("Physicist 123", 12321)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void jobAdClassHasRequiredConstructor(String title, int salary) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        String incorrectValue = "Your %s constructor does not correctly initialize the value of the %s attribute.";
        Class<?>[] constructorParameters = new Class[]{String.class, int.class};
        assertTrue(jobAd.hasConstructor(constructorParameters), String.format(missingConstructor, jobAdClassName));
        assertTrue(jobAd.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, jobAdClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{title, String.class}, {salary, int.class}};
        Object adInstance = jobAd.createInstance(constructorArguments);

        assertEquals(title, jobAd.getFieldValue(adInstance, stringAttributeName), String.format(incorrectValue, jobAdClassName, stringAttributeName));
        assertEquals(salary, jobAd.getFieldValue(adInstance, intAttributeName1), String.format(incorrectValue, jobAdClassName, intAttributeName1));
        assertArrayEquals(new String[2], (Object[]) jobAd.getFieldValue(adInstance, stringArrayAttributeName), String.format(incorrectValue, jobAdClassName, stringArrayAttributeName));
        assertEquals(0, jobAd.getFieldValue(adInstance, intAttributeName2), String.format(incorrectValue, jobAdClassName, intAttributeName2));
    }

    private static Stream<String> getTitleInputProvider() {
        return Stream.of("", "Doctor", "Le Medicin", "Tightrope walker no. 4");
    }

    @ParameterizedTest
    @MethodSource("getTitleInputProvider")
    public void correctGetTitleMethod(String title) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(jobAd.hasMethod(getTitleMethodName, null),
                String.format(incorrectDefinition, jobAdClassName, getTitleMethodName));
        assertTrue(jobAd.hasModifier(getTitleMethodName, null, "public"),
                String.format(incorrectModifier, getTitleMethodName));
        assertTrue(jobAd.hasReturnType(getTitleMethodName, null, String.class),
                String.format(incorrectReturnType, getTitleMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {title, String.class},
                {0, int.class}
        };
        Object adInstance = jobAd.createInstance(constructorArguments);

        /* Call getTitle on ad */
        Object output = jobAd.callMethod(getTitleMethodName, adInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(title, output, String.format(incorrectUpdate, getTitleMethodName, stringAttributeName));
    }

    private static Stream<Integer> getSalaryInputProvider() {
        return Stream.of(0, 1, 2, 32, 478, 3271847);
    }

    @ParameterizedTest
    @MethodSource("getSalaryInputProvider")
    public void correctGetSalaryMethod(int salary) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(jobAd.hasMethod(getSalaryMethodName, null),
                String.format(incorrectDefinition, jobAdClassName, getSalaryMethodName));
        assertTrue(jobAd.hasModifier(getSalaryMethodName, null, "public"),
                String.format(incorrectModifier, getSalaryMethodName));
        assertTrue(jobAd.hasReturnType(getSalaryMethodName, null, int.class),
                String.format(incorrectReturnType, getSalaryMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"title", String.class},
                {salary, int.class}
        };
        Object adInstance = jobAd.createInstance(constructorArguments);

        /* Call getSalary on ad */
        Object output = jobAd.callMethod(getSalaryMethodName, adInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(salary, output, String.format(incorrectUpdate, getSalaryMethodName, intAttributeName1));
    }

    private static Stream<Arguments> getSkillsInputProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{}),
                Arguments.of((Object) new String[]{"communication"}),
                Arguments.of((Object) new String[]{"programming", "patience"}),
                Arguments.of((Object) new String[]{"literary analysis", "grammar", "eyesight", "Typing", "Creativity"}));
    }

    @ParameterizedTest
    @MethodSource("getSkillsInputProvider")
    public void correctGetSkillsMethod(String[] skills) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(jobAd.hasMethod(getSkillsMethodName, null),
                String.format(incorrectDefinition, jobAdClassName, getSkillsMethodName));
        assertTrue(jobAd.hasModifier(getSkillsMethodName, null, "public"),
                String.format(incorrectModifier, getSkillsMethodName));
        assertTrue(jobAd.hasReturnType(getSkillsMethodName, null, String[].class),
                String.format(incorrectReturnType, getSkillsMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"title", String.class},
                {0, int.class}
        };
        Object adInstance = jobAd.createInstance(constructorArguments);
        String[] arrayHold = new String[skills.length];
        System.arraycopy(skills, 0, arrayHold, 0, skills.length);
        jobAd.setFieldValue(adInstance, skills, stringArrayAttributeName);

        /* Call getSkills on ad */
        Object output = jobAd.callMethod(getSkillsMethodName, adInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertArrayEquals(arrayHold, output, String.format(incorrectUpdate, getSkillsMethodName, stringArrayAttributeName));
    }

    public static Stream<Arguments> addSkillInputProvider() {
        return Stream.of(
                Arguments.of(new String[]{null, null}, "communication", 0, new String[]{"communication", null}),
                Arguments.of(new String[]{"resilience", "patience"}, "creativity", 2, new String[]{"resilience", "patience", "creativity", null}),
                Arguments.of(new String[]{"Sketching", "text editors", "orator", null}, "empathy", 3, new String[]{"Sketching",
                "text editors", "orator", "empathy"}),
                Arguments.of(new String[]{"degree", "literary analysis", "instruction", "communication", "grace", "patience of a saint",
                "proposal writing", "commitmment", "willing to crunch"}, "does not need to sleep", 9, new String[]{"degree",
                        "literary analysis", "instruction", "communication", "grace", "patience of a saint", "proposal writing",
                        "commitmment", "willing to crunch", "does not need to sleep", null, null, null, null, null, null, null, null})
        );
    }

    @ParameterizedTest
    @MethodSource("addSkillInputProvider")
    public void correctAddSkillMethod(String[] initialSkills, String newSkill, int numSkills, String[] answer) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{String.class};
        assertTrue(jobAd.hasMethod(addSkillMethodName, methodClassParameters),
                String.format(incorrectDefinition, jobAdClassName, addSkillMethodName));
        assertTrue(jobAd.hasModifier(addSkillMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, addSkillMethodName));
        assertTrue(jobAd.hasReturnType(addSkillMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, addSkillMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"title", String.class},
                {0, int.class}
        };
        Object adInstance = jobAd.createInstance(constructorArguments);
        jobAd.setFieldValue(adInstance, initialSkills, stringArrayAttributeName);
        jobAd.setFieldValue(adInstance, numSkills, intAttributeName2);

        /* Call addSkill on ad */
        Object[][] methodArguments = {{newSkill, String.class}};
        jobAd.callMethod(addSkillMethodName, methodArguments, adInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly manage adding a new element to the %s attribute.";
        _assertArrayEquals(answer, jobAd.getFieldValue(adInstance, stringArrayAttributeName), String.format(incorrectUpdate, addSkillMethodName, stringArrayAttributeName));
    }

    private static Stream<Arguments> toStringInputProvider() {
        return Stream.of(
                Arguments.of("Doctor", 56000, new String[]{"Medicine", "Calm under pressure", null, null}, 2,
                        "Title:  Doctor\nSalary: 56000\nSkills: Medicine, Calm under pressure\n"),
                Arguments.of("Vigilante", 100, new String[]{"Communication", "Patience", "Detail oriented", "creative", "Saviour complex", "not squeemish", "martial arts", "determination"},
                        8, "Title:  Vigilante\nSalary: 100\nSkills: Communication, Patience, Detail oriented, creative, Saviour complex, not squeemish, martial arts, determination\n"),
                Arguments.of("", 0, new String[]{}, 0, "Title:  \nSalary: 0\nSkills: \n"),
                Arguments.of("job title", 1000, new String[]{null, null, null, null}, 0, "Title:  job title\nSalary: 1000\nSkills: \n")
        );
    }

    @ParameterizedTest
    @MethodSource("toStringInputProvider")
    public void jobAdHasCorrectToStringMethod(String title, int salary, String[] skills, int num, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(jobAd.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, jobAdClassName, methodNameToString));
        assertTrue(jobAd.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(jobAd.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object[][] constructorArguments = {{title, String.class}, {salary, int.class}};
        Object adInstance = jobAd.createInstance(constructorArguments);

        jobAd.setFieldValue(adInstance, skills, stringArrayAttributeName);
        jobAd.setFieldValue(adInstance, num, intAttributeName2);

        String result = (String) jobAd.callMethod("toString", adInstance);
        assertEquals(msg, result, "Your toString method does not return the correct String. Check that your formatting is as described in the question text.");
    }

    private static Stream<Arguments> displaySearchResultsInputProvider() {
        return Stream.of(
                Arguments.of(1, new Object[][][]{{{"Platformer", String.class}, {100, int.class}}}, new String[][]{{"Fast reflexes", "Jumping height", null}}, new int[]{2},
                        new Clause[]{new StringLiteral("Job Ad 1:"), new Optional(new StringLiteral(" ")), new NewLine(),
                        new StringLiteral("Title:  Platformer"), new NewLine(), new StringLiteral("Salary: 100"), new NewLine(),
                        new StringLiteral("Skills: Fast reflexes, Jumping height"),
                        new NewLine()}),
                Arguments.of(3, new Object[][][]{{{"Forensic Scientist", String.class}, {0, int.class}}, {{"", String.class}, {23780, int.class}},
                        {{"Sleep therapist", String.class}, {10050, int.class}}}, new String[][]{{"eye for Detail", "no squeemishness", "medicine"},
                        {null, null}, {"soft voice", null}}, new int[]{3, 0, 1}, new Clause[]{new StringLiteral("Job Ad 1:"), new Optional(new StringLiteral(" ")),
                        new NewLine(), new StringLiteral("Title:  Forensic Scientist"), new NewLine(), new StringLiteral("Salary: 0"),
                        new NewLine(), new StringLiteral("Skills: eye for Detail, no squeemishness, medicine"),
                        new NewLine(), new NewLine(), new StringLiteral("Job Ad 2:"), new Optional(new StringLiteral(" ")), new NewLine(),
                        new StringLiteral("Title:  "), new NewLine(), new StringLiteral("Salary: 23780"), new NewLine(),
                        new StringLiteral("Skills: "), new NewLine(), new NewLine(), new StringLiteral("Job Ad 3:"), new Optional(new StringLiteral(" ")),
                        new NewLine(), new StringLiteral("Title:  Sleep therapist"), new NewLine(), new StringLiteral("Salary: 10050"), new NewLine(),
                        new StringLiteral("Skills: soft voice"), new NewLine(), new NewLine()}),
                Arguments.of(5, new Object[][][]{{{"Musician", String.class}, {10, int.class}}, {{"Teacher", String.class}, {60000, int.class}},
                        {{"Photographer", String.class}, {55555, int.class}}, {{"Opera Singer", String.class}, {150150, int.class}},
                        {{"Line worker", String.class}, {7000, int.class}}}, new String[][]{{"guitar", "charisma"}, {"patience", "instruction", "communication", null},
                        {"composition", null}, {"vocal training", "professionalism", "musicality", "confidence", "preparation"}, {null, null}},
                        new int[]{2, 3, 1, 5, 0}, new Clause[]{new StringLiteral("Job Ad 1:"), new Optional(new StringLiteral(" ")), new NewLine(),
                        new StringLiteral("Title:  Musician"), new NewLine(), new StringLiteral("Salary: 10"), new NewLine(),
                        new StringLiteral("Skills: guitar, charisma"), new NewLine(), new NewLine(), new StringLiteral("Job Ad 2:"),
                        new Optional(new StringLiteral(" ")), new NewLine(), new StringLiteral("Title:  Teacher"),
                        new NewLine(), new StringLiteral("Salary: 60000"), new NewLine(), new StringLiteral("Skills: patience, instruction, communication"),
                        new NewLine(), new NewLine(), new StringLiteral("Job Ad 3:"), new Optional(new StringLiteral(" ")), new NewLine(),
                        new StringLiteral("Title:  Photographer"), new NewLine(), new StringLiteral("Salary: 55555"), new NewLine(),
                        new StringLiteral("Skills: composition"), new NewLine(), new NewLine(), new StringLiteral("Job Ad 4:"), new Optional(new StringLiteral(" ")),
                        new NewLine(), new StringLiteral("Title:  Opera Singer"), new NewLine(), new StringLiteral("Salary: 150150"), new NewLine(),
                        new StringLiteral("Skills: vocal training, professionalism, musicality, confidence, preparation"), new NewLine(), new NewLine(),
                        new StringLiteral("Job Ad 5:"), new Optional(new StringLiteral(" ")), new NewLine(), new StringLiteral("Title:  Line worker"),
                        new NewLine(), new StringLiteral("Salary: 7000"), new NewLine(), new StringLiteral("Skills: "), new NewLine(), new NewLine()})
        );
    }

    @ParameterizedTest
    @MethodSource("displaySearchResultsInputProvider")
    public void correctDisplaySearchResultsMethod(int size, Object[][][] arguments, String[][] skills, int[] numSkills, Clause[] msg) throws Throwable {
        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct %s modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{jobAd.getObjectArrayClass()};
        assertTrue(exploreJobs.hasMethod(displaySearchResultsMethodName, methodClassParameters),
                String.format(incorrectDefinition, exploreJobsClassName, displaySearchResultsMethodName));
        assertTrue(exploreJobs.hasModifier(displaySearchResultsMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, displaySearchResultsMethodName, "visibility"));
        assertTrue(exploreJobs.hasModifier(displaySearchResultsMethodName, methodClassParameters, "static"),
                String.format(incorrectModifier, displaySearchResultsMethodName, "static"));
        assertTrue(exploreJobs.hasReturnType(displaySearchResultsMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, displaySearchResultsMethodName));

        Object[] holdArray = (Object[]) jobAd.createArray(size, arguments);
        for(int x = 0; x < size; x++){
            jobAd.setFieldValue(holdArray[x], skills[x], stringArrayAttributeName);
            jobAd.setFieldValue(holdArray[x], numSkills[x], intAttributeName2);
        }

        Object[][] methodArguments = {{holdArray, jobAd.getObjectArrayClass()}};
        exploreJobs.callMethod(displaySearchResultsMethodName, methodArguments, new String[]{"public", "static"}, null, msg,
                "Your " + displaySearchResultsMethodName + " method does not produce the correct output. Check that it follows the formatting described in the question text.");
    }

    private static Stream<Arguments> searchMinSalaryInputProvider() {
        return Stream.of(
                Arguments.of(1, new Object[][][]{{{"Podcaster", String.class}, {1500, int.class}}}, 1501, new int[]{}),
                Arguments.of(1, new Object[][][]{{{"Podcaster", String.class}, {1500, int.class}}}, 1500, new int[]{0}),
                Arguments.of(5, new Object[][][]{{{"Farmer", String.class}, {160000, int.class}}, {{"Fisherman", String.class}, {10000, int.class}},
                        {{"Adventurer", String.class}, {25000, int.class}}, {{"Beta tester", String.class}, {71000, int.class}},
                        {{"Security Guard", String.class}, {100, int.class}}}, 30000, new int[]{0, 3}),
                Arguments.of(5, new Object[][][]{{{"Magician", String.class}, {60000, int.class}}, {{"Councillor", String.class}, {50000, int.class}},
                        {{"Politician", String.class}, {75000, int.class}}, {{"Programmer", String.class}, {100000, int.class}},
                        {{"Architect", String.class}, {70000, int.class}}}, 40000, new int[]{0, 1, 2, 3, 4}),
                Arguments.of(5, new Object[][][]{{{"Magician", String.class}, {60000, int.class}}, {{"Councillor", String.class}, {50000, int.class}},
                        {{"Politician", String.class}, {75000, int.class}}, {{"Programmer", String.class}, {100000, int.class}},
                        {{"Architect", String.class}, {70000, int.class}}}, 400000, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("searchMinSalaryInputProvider")
    public void correctSearchMinSalaryMethod(int size, Object[][][] arguments, int min, int[] indexes) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct %s modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class, jobAd.getObjectArrayClass()};

        assertTrue(exploreJobs.hasMethod(searchMinSalaryMethodName, methodClassParameters),
                String.format(incorrectDefinition, exploreJobsClassName, searchMinSalaryMethodName));
        assertTrue(exploreJobs.hasModifier(searchMinSalaryMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, searchMinSalaryMethodName, "visibility"));
        assertTrue(exploreJobs.hasModifier(searchMinSalaryMethodName, methodClassParameters, "static"),
                String.format(incorrectModifier, displaySearchResultsMethodName, "static"));
        assertTrue(exploreJobs.hasReturnType(searchMinSalaryMethodName, methodClassParameters, jobAd.getObjectArrayClass()),
                String.format(incorrectReturnType, searchMinSalaryMethodName));

        Object[] holdArray = (Object[]) jobAd.createArray(size, arguments);
        Object[] ansArray = (Object[]) jobAd.createArray(indexes.length);
        for(int x = 0; x < indexes.length; x++){
            ansArray[x] = holdArray[indexes[x]];
        }

        Object[][] methodArguments = {{min, int.class}, {holdArray, jobAd.getObjectArrayClass()}};
        Object[] output = (Object[]) exploreJobs.callMethod(searchMinSalaryMethodName, methodArguments);

        assertArrayEquals(ansArray, output, "Your " + searchMinSalaryMethodName + " method does not return the correct array of " + jobAdClassName + " objects.");
    }

    private static Stream<Arguments> whichJobsRequireInputProvider() {
        return Stream.of(
                Arguments.of(1, new Object[][][]{{{"Podcaster", String.class}, {1500, int.class}}}, new String[][]{{"audio editing", "charisma", null}},
                        new int[]{2}, "communication", new int[]{}),
                Arguments.of(3, new Object[][][]{{{"Podcaster", String.class}, {1500, int.class}}, {{"Artist", String.class}, {200, int.class}},
                                {{"Designer", String.class}, {70000, int.class}}}, new String[][]{{"audio editing", "charisma"},
                                {"Sketching", "painting", "composition", "charisma", null}, {"composition", "communication"}}, new int[]{2, 4, 2},
                        "charisma", new int[]{0, 1}),
                Arguments.of(5, new Object[][][]{{{"Miner", String.class}, {70000, int.class}}, {{"", String.class}, {0, int.class}},
                        {{"Postal Worker", String.class}, {30000, int.class}}, {{"Airplane Pilot", String.class}, {250000, int.class}},
                        {{"Grocery clerk", String.class}, {40000, int.class}}}, new String[][]{{"Strength", "mechanics", "punctuality", "carefulness"},
                        {"carefulness"}, {"Memory", "carefulness"}, {"Resilience", "piloting", "carefulness", "air traffic communication", null, null, null},
                        {"speed", "carefulness"}}, new int[]{4, 1, 2, 4, 2}, "carefulness", new int[]{0, 1, 2, 3, 4}),
                Arguments.of(5, new Object[][][]{{{"Miner", String.class}, {70000, int.class}}, {{"", String.class}, {0, int.class}},
                        {{"Postal Worker", String.class}, {30000, int.class}}, {{"Airplane Pilot", String.class}, {250000, int.class}},
                        {{"Grocery clerk", String.class}, {40000, int.class}}}, new String[][]{{"Strength", "mechanics", "punctuality", "carefulness"},
                        {"carefulness"}, {"Memory", "carefulness"}, {"Resilience", "piloting", "carefulness", "air traffic communication", null, null, null},
                        {"speed", "carefulness"}}, new int[]{4, 1, 2, 4, 2}, "linguistics", new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("whichJobsRequireInputProvider")
    public void correctWhichJobsRequireMethod(int size, Object[][][] arguments, String[][] skills, int[] skillNum, String skill, int[] indexes) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct %s modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{String.class, jobAd.getObjectArrayClass()};

        assertTrue(exploreJobs.hasMethod(whichJobsRequireMethodName, methodClassParameters),
                String.format(incorrectDefinition, exploreJobsClassName, whichJobsRequireMethodName));
        assertTrue(exploreJobs.hasModifier(whichJobsRequireMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, whichJobsRequireMethodName, "visibility"));
        assertTrue(exploreJobs.hasModifier(whichJobsRequireMethodName, methodClassParameters, "static"),
                String.format(incorrectModifier, whichJobsRequireMethodName, "static"));
        assertTrue(exploreJobs.hasReturnType(whichJobsRequireMethodName, methodClassParameters, jobAd.getObjectArrayClass()),
                String.format(incorrectReturnType, whichJobsRequireMethodName));

        Object[] holdArray = (Object[]) jobAd.createArray(size, arguments);
        for(int x = 0; x < size; x++){
            jobAd.setFieldValue(holdArray[x], skills[x], stringArrayAttributeName);
            jobAd.setFieldValue(holdArray[x], skillNum[x], intAttributeName2);
        }
        Object[] ansArray = (Object[]) jobAd.createArray(indexes.length);
        for(int x = 0; x < indexes.length; x++){
            ansArray[x] = holdArray[indexes[x]];
        }

        Object[][] methodArguments = {{skill, String.class}, {holdArray, jobAd.getObjectArrayClass()}};
        Object[] output = (Object[]) exploreJobs.callMethod(whichJobsRequireMethodName, methodArguments);

        assertArrayEquals(ansArray, output, "Your " + searchMinSalaryMethodName + " method does not return the correct array of " + jobAdClassName + " objects.");
    }
}
