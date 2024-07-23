package oop.programs_with_interesting_classes.medium.q5;

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

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    /* Parsons Question */
    private static ObjectTest card;
    private ObjectTest hand;
    private ObjectTest playGame;
    private final String cardClassName = "Card";
    private final String handClassName = "Hand";
    private final String playGameClassName = "PlayGame";
    private final String charAttributeName = "suit";
    private final String intAttributeName = "rank";
    private final String getSuitMethodName = "getSuit";
    private final String getRankMethodName = "getRank";
    private final String expectedToString = "%s of %s";
    private final String cardAttributeName = "myCards";
    private final String getMyCardsMethodName = "getMyCards";
    private final String compareHandMethodName = "compareHand";
    private final String dealHandMethodName = "dealHand";
    private final int handSize = 5;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.medium.q5.";
        card = new ObjectTest(packageString + cardClassName);
        hand = new ObjectTest(packageString + handClassName);
        playGame = new ObjectTest(packageString + playGameClassName);
    }

    /* Test if the card class has the required attributes */

    @Test
    public void cardClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(card.hasField(charAttributeName), String.format(missingAttribute, cardClassName, charAttributeName));
        assertTrue(card.hasField(charAttributeName, char.class), String.format(incorrectType, charAttributeName));
        assertTrue(card.hasModifier(charAttributeName, "private"), String.format(incorrectModifier, charAttributeName));
        assertTrue(card.hasField(intAttributeName), String.format(missingAttribute, cardClassName, intAttributeName));
        assertTrue(card.hasField(intAttributeName, int.class), String.format(incorrectType, intAttributeName));
        assertTrue(card.hasModifier(intAttributeName, "private"), String.format(incorrectModifier, intAttributeName));
    }

    /* Test Card Constructor */

    private static Stream<Arguments> cardConstructorInputProvider() {
        return Stream.of(
                Arguments.of('H', 1, 'H', 1),
                Arguments.of('Z', 15, 'S', 1),
                Arguments.of('K', 5, 'S', 5),
                Arguments.of('D', 0, 'D', 1),
                Arguments.of('C', 13, 'C', 13)
        );
    }

    @ParameterizedTest
    @MethodSource("cardConstructorInputProvider")
    public void cardClassHasRequiredConstructor(char initSuit, int initRank, char finSuit, int finRank) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{char.class, int.class};
        assertTrue(card.hasConstructor(constructorParameters), String.format(missingConstructor, cardClassName));
        assertTrue(card.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, cardClassName));

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value. Ensure any invalid input is replaced with default values.";
        Object[][] constructorArguments = {
                {initSuit, char.class},
                {initRank, int.class}
        };
        Object cardInstance = card.createInstance(constructorArguments);
        _assertEquals(finSuit, card.getFieldValue(cardInstance, charAttributeName), String.format(incorrectValue, cardClassName, charAttributeName));
        _assertEquals(finRank, card.getFieldValue(cardInstance, intAttributeName), String.format(incorrectValue, cardClassName, intAttributeName));
    }

    /* Test Card Methods */

    private static Stream<Character> getSuitInputProvider() {
        return Stream.of('S', 'D', 'H', 'C');
    }

    @ParameterizedTest
    @MethodSource("getSuitInputProvider")
    public void correctGetSuitMethod(char suit) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(card.hasMethod(getSuitMethodName, null),
                String.format(incorrectDefinition, cardClassName, getSuitMethodName));
        assertTrue(card.hasModifier(getSuitMethodName, null, "public"),
                String.format(incorrectModifier, getSuitMethodName));
        assertTrue(card.hasReturnType(getSuitMethodName, null, char.class),
                String.format(incorrectReturnType, getSuitMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {suit, char.class},
                {2, int.class}
        };
        Object cardInstance = card.createInstance(constructorArguments);

        /* Call getSuit on car */
        Object getSuitOutput = card.callMethod(getSuitMethodName, cardInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(suit, getSuitOutput, String.format(incorrectUpdate, getSuitMethodName, charAttributeName));
    }

    private static Stream<Integer> getRankInputProvider() {
        return Stream.of(1, 2, 3, 10, 11, 12, 13);
    }

    @ParameterizedTest
    @MethodSource("getRankInputProvider")
    public void correctGetRankMethod(int rank) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(card.hasMethod(getRankMethodName, null),
                String.format(incorrectDefinition, cardClassName, getRankMethodName));
        assertTrue(card.hasModifier(getRankMethodName, null, "public"),
                String.format(incorrectModifier, getRankMethodName));
        assertTrue(card.hasReturnType(getRankMethodName, null, int.class),
                String.format(incorrectReturnType, getRankMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {'S', char.class},
                {rank, int.class}
        };
        Object cardInstance = card.createInstance(constructorArguments);

        /* Call getRank on car */
        Object getRankOutput = card.callMethod(getRankMethodName, cardInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(rank, getRankOutput, String.format(incorrectUpdate, getRankMethodName, intAttributeName));
    }

    @ParameterizedTest
    @MethodSource("cardConstructorInputProvider")
    public void correctToStringMethod(char initSuit, int initRank, char finSuit, int finRank) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(card.hasMethod("toString", null),
                String.format(incorrectDefinition, cardClassName, "toString"));
        assertTrue(card.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(card.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {initSuit, char.class},
                {initRank, int.class}
        };
        Object cardInstance = card.createInstance(constructorArguments);

        /* Test output */
        Object actualOutput = card.callMethod("toString", cardInstance);
        _assertEquals(String.format(expectedToString, finRank, finSuit), actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }


    /* Test if the hand class has the required attribute */

    @Test
    public void handClassHasRequiredAttribute() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectType = "Your %s attribute does not have the correct type.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(hand.hasField(cardAttributeName), String.format(missingAttribute, handClassName, cardAttributeName));
        assertTrue(hand.hasField(cardAttributeName, card.getObjectArrayClass()), String.format(incorrectType, cardAttributeName));
        assertTrue(hand.hasModifier(cardAttributeName, "private"), String.format(incorrectModifier, cardAttributeName));
    }

    /* Test Hand Constructor */

    private static Stream<Arguments> handConstructorInputProvider() {
        return Stream.of(
                Arguments.of(3, new Object[][][]{{{'S', char.class}, {7, int.class}}, {{'C', char.class}, {12, int.class}}, {{'D', char.class}, {2, int.class}}}),
                Arguments.of(1, new Object[][][]{{{'S', char.class}, {7, int.class}}}),
                Arguments.of(6, new Object[][][]{{{'S', char.class}, {7, int.class}}, {{'C', char.class}, {12, int.class}}, {{'D', char.class}, {2, int.class}},
                        {{'H', char.class}, {8, int.class}}, {{'S', char.class}, {1, int.class}}, {{'D', char.class}, {11, int.class}}})
        );
    }

    @ParameterizedTest
    @MethodSource("handConstructorInputProvider")
    public void handClassHasRequiredConstructor(int length, Object[][][] arguments) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{card.getObjectArrayClass()};
        assertTrue(hand.hasConstructor(constructorParameters), String.format(missingConstructor, handClassName));
        assertTrue(hand.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, handClassName));

        Object[] inputCards = (Object[]) card.createArray(length);
        Object[] holdCards = (Object[]) card.createArray(length);

        for (int x = 0; x < length; x++) {
            Object c = card.createInstance(arguments[x]);
            inputCards[x] = c;
            holdCards[x] = c;
        }

        /* Check constructor functionality */
        String incorrectValue = "Your %s constructor does not initialize the %s attribute to the correct value. Ensure any invalid input is replaced with default values.";
        Object[][] constructorArguments = {
                {inputCards, card.getObjectArrayClass()}
        };
        Object handInstance = hand.createInstance(constructorArguments);
        _assertArrayEquals(holdCards, hand.getFieldValue(handInstance, cardAttributeName), String.format(incorrectValue, handClassName, cardAttributeName));
    }

    /* Test Hand Methods */

    @ParameterizedTest
    @MethodSource("handConstructorInputProvider")
    public void correctGetMyCardsMethod(int length, Object[][][] arguments) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(hand.hasMethod(getMyCardsMethodName, null),
                String.format(incorrectDefinition, handClassName, getMyCardsMethodName));
        assertTrue(hand.hasModifier(getMyCardsMethodName, null, "public"),
                String.format(incorrectModifier, getMyCardsMethodName));
        assertTrue(hand.hasReturnType(getMyCardsMethodName, null, card.getObjectArrayClass()),
                String.format(incorrectReturnType, getMyCardsMethodName));

        /* Create instance to call method on */
        Object[] inputCards = (Object[]) card.createArray(length);
        Object[] holdCards = (Object[]) card.createArray(length);

        for (int x = 0; x < length; x++) {
            Object c = card.createInstance(arguments[x]);
            inputCards[x] = c;
            holdCards[x] = c;
        }

        Object[][] constructorArguments = {
                {inputCards, card.getObjectArrayClass()}
        };
        Object handInstance = hand.createInstance(constructorArguments);

        /* Call getMyCards on hand */
        Object getMyCardsOutput = hand.callMethod(getMyCardsMethodName, handInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertArrayEquals(holdCards, getMyCardsOutput, String.format(incorrectUpdate, getMyCardsMethodName, cardAttributeName));
    }

    private static Stream<Arguments> handToStringInputProvider() {
        return Stream.of(
                Arguments.of(3, new Object[][][]{{{'S', char.class}, {7, int.class}}, {{'C', char.class}, {12, int.class}}, {{'D', char.class}, {2, int.class}}},
                        "7 of S, 12 of C, 2 of D"),
                Arguments.of(1, new Object[][][]{{{'S', char.class}, {7, int.class}}}, "7 of S"),
                Arguments.of(6, new Object[][][]{{{'S', char.class}, {7, int.class}}, {{'C', char.class}, {12, int.class}}, {{'D', char.class}, {2, int.class}},
                                {{'H', char.class}, {8, int.class}}, {{'S', char.class}, {1, int.class}}, {{'D', char.class}, {11, int.class}}},
                        "7 of S, 12 of C, 2 of D, 8 of H, 1 of S, 11 of D"),
                Arguments.of(0, new Object[][][]{{{}}}, ""),
                Arguments.of(2, new Object[][][]{{{'D', char.class}, {5, int.class}}, {{'H', char.class}, {10, int.class}}},
                        "5 of D, 10 of H")
        );
    }

    @ParameterizedTest
    @MethodSource("handToStringInputProvider")
    public void correctHandToStringMethod(int length, Object[][][] arguments, String result) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(hand.hasMethod("toString", null),
                String.format(incorrectDefinition, handClassName, "toString"));
        assertTrue(hand.hasModifier("toString", null, "public"),
                String.format(incorrectModifier, "toString"));
        assertTrue(hand.hasReturnType("toString", null, String.class),
                String.format(incorrectReturnType, "toString"));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {card.createArray(length, arguments), card.getObjectArrayClass()}
        };
        Object handInstance = hand.createInstance(constructorArguments);

        /* Test output */
        Object actualOutput = hand.callMethod("toString", handInstance);
        _assertEquals(result, actualOutput,
                "The String output from your toString method is not correct. Please check the formatting of the String.");
    }

    private static Stream<Arguments> compareHandInputProvider() {
        return Stream.of(
                Arguments.of(3, new Object[][][]{{{'S', char.class}, {7, int.class}}, {{'C', char.class}, {12, int.class}}, {{'D', char.class}, {2, int.class}}},
                        new Object[][][]{{{'H', char.class}, {12, int.class}}, {{'H', char.class}, {2, int.class}}, {{'H', char.class}, {5, int.class}}},
                        "It's a tie\\!"),
                Arguments.of(2, new Object[][][]{{{'D', char.class}, {1, int.class}}, {{'D', char.class}, {12, int.class}}},
                        new Object[][][]{{{'H', char.class}, {13, int.class}}, {{'H', char.class}, {6, int.class}}},
                        "Winner\\: 13 of H, 6 of H"),
                Arguments.of(5, new Object[][][]{{{'C', char.class}, {8, int.class}}, {{'D', char.class}, {7, int.class}}, {{'C', char.class}, {7, int.class}},
                                {{'H', char.class}, {3, int.class}}, {{'C', char.class}, {10, int.class}}},
                        new Object[][][]{{{'H', char.class}, {4, int.class}}, {{'D', char.class}, {4, int.class}}, {{'C', char.class}, {7, int.class}},
                                {{'D', char.class}, {9, int.class}}, {{'D', char.class}, {6, int.class}}},
                        "Winner\\: 8 of C, 7 of D, 7 of C, 3 of H, 10 of C")
        );
    }

    @ParameterizedTest
    @MethodSource("compareHandInputProvider")
    public void correctCompareHandMethod(int length, Object[][][] arguments1, Object[][][] arguments2, String result) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(hand.hasMethod(compareHandMethodName, new Class[]{hand.getObjectClass()}),
                String.format(incorrectDefinition, handClassName, compareHandMethodName));
        assertTrue(hand.hasModifier(compareHandMethodName, new Class[]{hand.getObjectClass()}, "public"),
                String.format(incorrectModifier, compareHandMethodName));
        assertTrue(hand.hasReturnType(compareHandMethodName, new Class[]{hand.getObjectClass()}, Void.TYPE),
                String.format(incorrectReturnType, compareHandMethodName));

        /* Initialize object for toString test */
        Object[][] constructorArguments = {
                {card.createArray(length, arguments1), card.getObjectArrayClass()}
        };
        Object handInstance1 = hand.createInstance(constructorArguments);
        constructorArguments = new Object[][]{
                {card.createArray(length, arguments2), card.getObjectArrayClass()}
        };
        Object handInstance2 = hand.createInstance(constructorArguments);

        /* Test output */
        hand.callMethod(compareHandMethodName, new Object[][]{{handInstance2, hand.getObjectClass()}}, new String[]{"public"}, handInstance1,
                new Clause[]{new StringLiteral(result)},
                "The output from your " + compareHandMethodName + " method is not correct. Please check you are printing the correct String.");
    }

    /* Test PlayGame Method */

    @Test
    public void correctDealHandMethod() throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectStaticModifier = "The %s method does not have the static modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(playGame.hasMethod(dealHandMethodName, null),
                String.format(incorrectDefinition, playGameClassName, dealHandMethodName));
        assertTrue(playGame.hasModifier(dealHandMethodName, null, "public"),
                String.format(incorrectModifier, dealHandMethodName));
        assertTrue(playGame.hasModifier(dealHandMethodName, null, "static"),
                String.format(incorrectStaticModifier, dealHandMethodName));
        assertTrue(playGame.hasReturnType(dealHandMethodName, null, card.getObjectArrayClass()),
                String.format(incorrectReturnType, dealHandMethodName));

        char[] suit = new char[15];
        int count = 0;
        for (int x = 0; x < 3; x++) {
            Object[] output = (Object[]) playGame.callMethod(dealHandMethodName);
            for (int y = 0; y < handSize; y++) {
                assertNotNull(output[y], "The " + dealHandMethodName + " method does not return an initialized array of " + cardClassName + " objects.");
                int index = output[y].toString().indexOf("f") + 2;
                suit[count++] = output[y].toString().charAt(index);
            }
        }
        char hold = suit[0];
        for (int x = 1; x < 15; x++) {
            if (hold != suit[x])
                return;
            else if (x == 14)
                fail("The " + dealHandMethodName + " method does not randomly generate each card's suit.");
        }
    }

    @Test
    public void playGameHasCorrectMainMethod() throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the main method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "Your main method does not have the correct visibility modifier.";
        String incorrectReturnType = "Your main method does not have the correct return type.";
        String incorrectStatic = "Your main method must have the static modifier.";
        Class<?>[] methodClassParameters = new Class[]{String[].class};
        assertTrue(playGame.hasMethod("main", methodClassParameters),
                String.format(incorrectDefinition, playGameClassName));
        assertTrue(playGame.hasModifier("main", methodClassParameters, "public"),
                incorrectModifier);
        assertTrue(playGame.hasReturnType("main", methodClassParameters, Void.TYPE),
                incorrectReturnType);
        assertTrue(playGame.hasModifier("main", methodClassParameters, "static"),
                incorrectStatic);

        Clause[] output = {
                new StringLiteral("First Game: "),
                new NewLine(),
                new StringLiteral("(Winner: [0-9]+ of [SCHD], [0-9]+ of [SCHD], [0-9]+ of [SCHD], [0-9]+ of [SCHD], [0-9]+ of [SCHD])|(It's a tie!)"),
                new NewLine(),
                new StringLiteral("Rematch: "),
                new NewLine(),
                new StringLiteral("(Winner: [0-9]+ of [SCHD], [0-9]+ of [SCHD], [0-9]+ of [SCHD], [0-9]+ of [SCHD], [0-9]+ of [SCHD])|(It's a tie!)")
        };
        String incorrectOutput = "Your main method in the %s class did not print the correct output. Make sure you print the accouncements and call the %s method twice.";
        Object[][] mainArgs = {{new String[0], String[].class}};
        playGame.callMethod("main", mainArgs, output, String.format(incorrectOutput, playGameClassName, compareHandMethodName));
    }
    //you'll need to write regex that accepts the toString foramt with any of the 4 card characters and a range of digits from 1-13
}
