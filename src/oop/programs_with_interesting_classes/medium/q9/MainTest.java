package oop.programs_with_interesting_classes.medium.q9;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    /* Parsons Question */
    private ObjectTest review;
    private ObjectTest movie;
    private ObjectTest testExpertReviews;
    private final String reviewClassName = "Review";
    private final String movieClassName = "Movie";
    private final String testExpertReviewsClassName = "TestExpertReviews";
    private final String stringAttributeName = "user";
    private final String intAttributeName = "rating";
    private final String stringAttributeName2 = "name";
    private final String reviewArrayAttributeName = "reviews";
    private final String getUserMethodName = "getUser";
    private final String getRatingMethodName = "getRating";
    private final String setReviewsMethodName = "setReviews";
    private final String addReviewMethodName = "addReview";
    private final String calcAvgRatingMethodName = "calcAvgRating";
    private final String getHighestRatingMethodName = "getHighestRating";
    private final String expectedString = "%s rates this %s stars.";
    private static final int min = 1;
    private static final int max = 5;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.medium.q9.";
        review = new ObjectTest(packageString + reviewClassName);
        movie = new ObjectTest(packageString + movieClassName);
        testExpertReviews = new ObjectTest(packageString + testExpertReviewsClassName);
    }

    /* Test if the review class has the required attributes */

    @Test
    public void reviewClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(review.hasField(stringAttributeName), String.format(missingAttribute, reviewClassName, stringAttributeName));
        assertTrue(review.hasField(stringAttributeName, String.class), String.format(incorrectType, stringAttributeName));
        assertTrue(review.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(review.hasField(intAttributeName), String.format(missingAttribute, reviewClassName, intAttributeName));
        assertTrue(review.hasField(intAttributeName, int.class), String.format(incorrectType, intAttributeName));
        assertTrue(review.hasModifier(intAttributeName, "private"), String.format(incorrectModifier, intAttributeName));
    }

    /* Test Review Constructor */

    private static Stream<Arguments> constructorInputProvider1() {
        return Stream.of(
                Arguments.of("HaHa Moviez Bad", min - 1, -1),
                Arguments.of("Mazda zooooom", min + 2, min + 2),
                Arguments.of("Kassie", min, min),
                Arguments.of("", max, max),
                Arguments.of("Omni Metal McGuffin", max + 1, -1),
                Arguments.of("Critic", min - 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider1")
    public void reviewClassHasRequiredConstructor(String name, int stars, int validated) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class, int.class};
        assertTrue(review.hasConstructor(constructorParameters), String.format(missingConstructor, reviewClassName));
        assertTrue(review.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, reviewClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        Object[][] constructorArguments = {
                {name, String.class},
                {stars, int.class}
        };
        Object reviewInstance = review.createInstance(constructorArguments);
        _assertEquals(name, review.getFieldValue(reviewInstance, stringAttributeName), String.format(incorrectValue, reviewClassName, stringAttributeName));
        _assertEquals(validated, review.getFieldValue(reviewInstance, intAttributeName), String.format(incorrectValue, reviewClassName, intAttributeName));
    }

    /* Test Review Methods */

    private static Stream<String> getUserInputProvider() {
        return Stream.of("Toyota Corolla", "George W. Bush", "123 ABC", "");
    }

    @ParameterizedTest
    @MethodSource("getUserInputProvider")
    public void correctGetUserMethod(String name) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(review.hasMethod(getUserMethodName, null),
                String.format(incorrectDefinition, reviewClassName, getUserMethodName));
        assertTrue(review.hasModifier(getUserMethodName, null, "public"),
                String.format(incorrectModifier, getUserMethodName));
        assertTrue(review.hasReturnType(getUserMethodName, null, String.class),
                String.format(incorrectReturnType, getUserMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {name, String.class},
                {2, int.class}
        };
        Object reviewInstance = review.createInstance(constructorArguments);

        /* Call getUser on car */
        Object getUserOutput = review.callMethod(getUserMethodName, reviewInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(name, getUserOutput, String.format(incorrectUpdate, getUserMethodName, stringAttributeName));
    }

    private static Stream<Integer> getRatingInputProvider() {
        return Stream.of(min, min + 1, min + 2, max - 1, max);
    }

    @ParameterizedTest
    @MethodSource("getRatingInputProvider")
    public void correctGetRatingMethod(int stars) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(review.hasMethod(getRatingMethodName, null),
                String.format(incorrectDefinition, reviewClassName, getRatingMethodName));
        assertTrue(review.hasModifier(getRatingMethodName, null, "public"),
                String.format(incorrectModifier, getRatingMethodName));
        assertTrue(review.hasReturnType(getRatingMethodName, null, int.class),
                String.format(incorrectReturnType, getRatingMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Katie", String.class},
                {stars, int.class}
        };
        Object reviewInstance = review.createInstance(constructorArguments);

        /* Call getRating on car */
        Object getRatingOutput = review.callMethod(getRatingMethodName, reviewInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(stars, getRatingOutput, String.format(incorrectUpdate, getRatingOutput, intAttributeName));
    }

    private static Stream<Arguments> toStringInputProvider() {
        return Stream.of(
                Arguments.of("Another Random Car", 0),
                Arguments.of("", 1),
                Arguments.of("Chancer", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("toStringInputProvider")
    public void correctToStringMethod(String name, int stars) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(review.hasMethod("toString", null),
                String.format(incorrectDefinition, reviewClassName, "toString"));
        assertTrue(review.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(review.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {name, String.class},
                {stars, int.class}
        };
        Object reviewInstance = review.createInstance(constructorArguments);

        /* Set fields to values for test */
        review.setFieldValue(reviewInstance, stars, intAttributeName);

        /* Test output */
        String expectedOutput = String.format(expectedString, name, stars);
        Object actualOutput = review.callMethod("toString", reviewInstance);
        _assertEquals(expectedOutput, actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    /* Test if the movie class has the required attributes */

    @Test
    public void movieClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(movie.hasField(stringAttributeName2), String.format(missingAttribute, movieClassName, stringAttributeName2));
        assertTrue(movie.hasField(stringAttributeName2, String.class), String.format(incorrectType, stringAttributeName2));
        assertTrue(movie.hasModifier(stringAttributeName2, "private"), String.format(incorrectModifier, stringAttributeName2));
        assertTrue(movie.hasField(reviewArrayAttributeName), String.format(missingAttribute, movieClassName, reviewArrayAttributeName));
        assertTrue(movie.hasField(reviewArrayAttributeName, review.getObjectArrayClass()), String.format(incorrectType, reviewArrayAttributeName));
        assertTrue(movie.hasModifier(reviewArrayAttributeName, "private"), String.format(incorrectModifier, reviewArrayAttributeName));
    }

    /* Test Movie Constructor */

    private static Stream<String> constructorInputProvider2() {
        return Stream.of("", "zombie mania", "footloose");
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider2")
    public void movieClassHasRequiredConstructor(String name) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{String.class};
        assertTrue(movie.hasConstructor(constructorParameters), String.format(missingConstructor, movieClassName));
        assertTrue(movie.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, movieClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value.";
        String incorrectArray = "Your %s constructor does not initialize the %s array to a length of 0.";
        Object[][] constructorArguments = {
                {name, String.class}
        };
        Object movieInstance = movie.createInstance(constructorArguments);
        _assertEquals(name, movie.getFieldValue(movieInstance, stringAttributeName2), String.format(incorrectValue, movieClassName, stringAttributeName2));
        _assertArrayEquals(review.createArray(0), movie.getFieldValue(movieInstance, reviewArrayAttributeName), String.format(incorrectArray, movieClassName, reviewArrayAttributeName));
    }

    /* Test Movie Methods */

    private static Stream<Arguments> setReviewsInputProvider() {
        return Stream.of(
                Arguments.of(1, new Object[][][]{{{"Henry", String.class}, {3, int.class}}}),
                Arguments.of(2, new Object[][][]{{{"Tanya", String.class}, {2, int.class}}, {{"Reyna123", String.class}, {max, int.class}}}),
                Arguments.of(4, new Object[][][]{{{"SixStringXO", String.class}, {4, int.class}}, {{"Lee", String.class}, {2, int.class}},
                        {{"ReviewerNo3", String.class}, {3, int.class}}, {{"TerranceMcGuinness", String.class}, {3, int.class}}})
        );
    }

    @ParameterizedTest
    @MethodSource("setReviewsInputProvider")
    public void correctSetReviewsMethod(int size, Object[][][] arguments) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{review.getObjectArrayClass()};
        assertTrue(movie.hasMethod(setReviewsMethodName, methodClassParameters),
                String.format(incorrectDefinition, movieClassName, setReviewsMethodName));
        assertTrue(movie.hasModifier(setReviewsMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setReviewsMethodName));
        assertTrue(movie.hasReturnType(setReviewsMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setReviewsMethodName));

        Object[] hold = (Object[]) review.createArray(size, arguments);

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Just another movie", String.class}
        };
        Object movieInstance = movie.createInstance(constructorArguments);

        /* Call setReviews on movie */
        Object[][] methodArgs = {{hold, review.getObjectArrayClass()}};
        movie.callMethod(setReviewsMethodName, methodArgs, movieInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        _assertArrayEquals(hold, movie.getFieldValue(movieInstance, reviewArrayAttributeName),
                String.format(incorrectUpdate, setReviewsMethodName, reviewArrayAttributeName));
    }

    private static Stream<Arguments> addReviewInputProvider() {
        return Stream.of(
                Arguments.of(0, new Object[][][]{{{}}}, new Object[][]{{"Name", String.class}, {4, int.class}}),
                Arguments.of(1, new Object[][][]{{{"Username", String.class}, {2, int.class}}},
                        new Object[][]{{"other user", String.class}, {3, int.class}}),
                Arguments.of(3, new Object[][][]{{{"kiki 123", String.class}, {2, int.class}}, {{"", String.class}, {2, int.class}},
                        {{"Critic", String.class}, {max, int.class}}}, new Object[][]{{"new user", String.class}, {4, int.class}})
        );
    }

    @ParameterizedTest
    @MethodSource("addReviewInputProvider")
    public void correctAddReviewMethod(int size, Object[][][] arguments, Object[][] instanceArgs) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{review.getObjectClass()};
        assertTrue(movie.hasMethod(addReviewMethodName, methodClassParameters),
                String.format(incorrectDefinition, movieClassName, addReviewMethodName));
        assertTrue(movie.hasModifier(addReviewMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, addReviewMethodName));
        assertTrue(movie.hasReturnType(addReviewMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, addReviewMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Just another movie", String.class}
        };
        Object movieInstance = movie.createInstance(constructorArguments);

        Object[] hold = (Object[]) review.createArray(size, arguments);

        /* set reviews field */
        movie.setFieldValue(movieInstance, hold, reviewArrayAttributeName);

        /* create review to be added */
        Object holdReview = review.createInstance(instanceArgs);

        /* Call addReview on movie */
        Object[][] methodArgs = {{holdReview, review.getObjectClass()}};
        movie.callMethod(addReviewMethodName, methodArgs, movieInstance);

        Object[] result = new Object[size + 1];
        System.arraycopy(hold, 0, result, 0, size);
        result[size] = holdReview;

        hold = (Object[]) movie.getFieldValue(movieInstance, reviewArrayAttributeName);
        Object[] actual = new Object[size + 1];
        if (hold.length == size + 1)
            System.arraycopy(hold, 0, actual, 0, size + 1);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly update the %s attribute.";
        _assertArrayEquals(result, actual,
                String.format(incorrectUpdate, addReviewMethodName, reviewArrayAttributeName));
    }

    private static Stream<Arguments> calcAvgRatingInputProvider() {
        return Stream.of(
                Arguments.of(0, new Object[][][]{{{}}}, 0.0),
                Arguments.of(1, new Object[][][]{{{"name", String.class}, {4, int.class}}}, 4.0),
                Arguments.of(4, new Object[][][]{{{"name", String.class}, {4, int.class}}, {{"Name", String.class}, {1, int.class}},
                        {{"name", String.class}, {2, int.class}}, {{"Name", String.class}, {3, int.class}}}, 2.5),
                Arguments.of(5, new Object[][][]{{{"name", String.class}, {4, int.class}}, {{"name", String.class}, {3, int.class}},
                        {{"name", String.class}, {4, int.class}}, {{"name", String.class}, {2, int.class}},
                        {{"name", String.class}, {3, int.class}}}, 3.2)
        );
    }

    @ParameterizedTest
    @MethodSource("calcAvgRatingInputProvider")
    public void correctCalcAvgRatingMethod(int size, Object[][][] arguments, double result) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{};
        assertTrue(movie.hasMethod(calcAvgRatingMethodName, methodClassParameters),
                String.format(incorrectDefinition, movieClassName, calcAvgRatingMethodName));
        assertTrue(movie.hasModifier(calcAvgRatingMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, calcAvgRatingMethodName));
        assertTrue(movie.hasReturnType(calcAvgRatingMethodName, methodClassParameters, double.class),
                String.format(incorrectReturnType, calcAvgRatingMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Just another movie", String.class}
        };
        Object movieInstance = movie.createInstance(constructorArguments);

        /* set reviews field */
        movie.setFieldValue(movieInstance, review.createArray(size, arguments), reviewArrayAttributeName);

        /* Call calcAvgRating on car */
        Object actual = movie.callMethod(calcAvgRatingMethodName, movieInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly calculate the average %s.";
        _assertEquals(result, actual, 0.00001,
                String.format(incorrectUpdate, calcAvgRatingMethodName, intAttributeName));
    }

    private static Stream<Arguments> getHighestRatingInputProvider() {
        return Stream.of(
                Arguments.of(0, new Object[][][]{{{}}}, -1),
                Arguments.of(1, new Object[][][]{{{"name", String.class}, {min, int.class}}}, min),
                Arguments.of(4, new Object[][][]{{{"name", String.class}, {4, int.class}}, {{"Name", String.class}, {1, int.class}},
                        {{"name", String.class}, {2, int.class}}, {{"Name", String.class}, {3, int.class}}}, 4),
                Arguments.of(5, new Object[][][]{{{"name", String.class}, {4, int.class}}, {{"name", String.class}, {3, int.class}},
                        {{"name", String.class}, {max, int.class}}, {{"name", String.class}, {2, int.class}},
                        {{"name", String.class}, {3, int.class}}}, max)
        );
    }

    @ParameterizedTest
    @MethodSource("getHighestRatingInputProvider")
    public void correctGetHighestRatingMethod(int size, Object[][][] arguments, int result) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{};
        assertTrue(movie.hasMethod(getHighestRatingMethodName, methodClassParameters),
                String.format(incorrectDefinition, movieClassName, getHighestRatingMethodName));
        assertTrue(movie.hasModifier(getHighestRatingMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, getHighestRatingMethodName));
        assertTrue(movie.hasReturnType(getHighestRatingMethodName, methodClassParameters, int.class),
                String.format(incorrectReturnType, getHighestRatingMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {"Just another movie", String.class}
        };
        Object movieInstance = movie.createInstance(constructorArguments);

        /* set reviews field */
        movie.setFieldValue(movieInstance, review.createArray(size, arguments), reviewArrayAttributeName);

        /* Call getHighestRating on car */
        Object actual = movie.callMethod(getHighestRatingMethodName, movieInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not correctly calculate the highest %s.";
        _assertEquals(result, actual, String.format(incorrectUpdate, getHighestRatingMethodName, intAttributeName));
    }

    @Test
    public void correctMainMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the main method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "Your main method does not have the correct visibility modifier.";
        String incorrectReturnType = "Your main method does not have the correct return type.";
        String incorrectStatic = "Your main method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(testExpertReviews.hasMethod("main", methodClassParameters),
                String.format(incorrectDefinition, testExpertReviews));
        assertTrue(testExpertReviews.hasModifier("main", methodClassParameters, "public"),
                incorrectModifier);
        assertTrue(testExpertReviews.hasReturnType("main", methodClassParameters, Void.TYPE),
                incorrectReturnType);
        assertTrue(testExpertReviews.hasModifier("main", methodClassParameters, "static"),
                incorrectStatic);

        Clause[] output = {
                new StringLiteral("The average rating is "),
                new DoubleLiteral(3.5, 3.7),
                new NewLine(),
                new StringLiteral("The highest rating is "),
                new IntegerLiteral(5),
                new StringLiteral(" stars")
        };
        String incorrectOutput = "Your main method in the %s class did not print the correct output. Make sure you call the %s and %s methods";
        Object[][] mainArgs = {{new String[0], String[].class}};
        testExpertReviews.callMethod("main", mainArgs, output, String.format(incorrectOutput, testExpertReviewsClassName, calcAvgRatingMethodName, getHighestRatingMethodName));
    }
}
