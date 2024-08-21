package oop.programs_with_interesting_classes.hard.q6;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private ObjectTest card;
    private ObjectTest deckOfCards;
    private final String cardClassName = "Card";
    private final String deckOfCardsClassName = "DeckOfCards";
    private final String stringAttributeName = "suit";
    private final String intAttributeName1 = "rank";
    private final String finalIntAttributeName1 = "maxRanks";
    private final String finalIntAttributeName2 = "maxSuits";
    private final String finalIntAttributeName3 = "maxCards";
    private final String cardArrayAttributeName = "deck";
    private final String intAttributeName2 = "pos";
    private final String getRankMethodName = "getRank";
    private final String getSuitMethodName = "getSuit";
    private final String isBiggerThanMethodName = "isBiggerThan";
    private final String setSuitsMethodName = "setMaxSuits";
    private final String setRanksMethodName = "setMaxRanks";
    private final String shuffleCardsMethodName = "shuffleCards";
    private final String mapSuitToStringMethodName = "mapSuitToString";
    private final String dealMethodName = "deal";
    private static final int suits = 4;
    private static final int ranks = 13;
    private static final int maxCards = suits * ranks;

    private final String incorrectTypeMessage = "Your %s attribute does not have the correct type.";

    // Java question

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.hard.q6.";
        card = new ObjectTest(packageString + cardClassName);
        deckOfCards = new ObjectTest(packageString + deckOfCardsClassName);
    }

    @Test
    public void cardClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct visibility modifier.";
        assertTrue(card.hasField(stringAttributeName), String.format(missingAttribute, cardClassName, stringAttributeName));
        assertTrue(card.hasField(stringAttributeName, String.class), String.format(incorrectTypeMessage, stringAttributeName));
        assertTrue(card.hasModifier(stringAttributeName, "private"), String.format(incorrectModifier, stringAttributeName));
        assertTrue(card.hasField(intAttributeName1), String.format(missingAttribute, deckOfCardsClassName, intAttributeName1));
        assertTrue(card.hasField(intAttributeName1, int.class), String.format(incorrectTypeMessage, intAttributeName1));
        assertTrue(card.hasModifier(intAttributeName1, "private"), String.format(incorrectModifier, intAttributeName1));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(1, "Hearts"),
                Arguments.of(2, "Spades"),
                Arguments.of(13, "Diamonds"),
                Arguments.of(7, "Clubs")
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void cardClassHasRequiredConstructor(int rank, String suit) throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{int.class, String.class};
        assertTrue(card.hasConstructor(constructorParameters), String.format(missingConstructor, cardClassName));
        assertTrue(card.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, cardClassName));

        /* Check constructor functionality */
        Object[][] constructorArguments = {{rank, int.class}, {suit, String.class}};
        Object cardInstance = card.createInstance(constructorArguments);

        String msg = "Your %s class constructor does not correctly initialize the %s value.";
        assertEquals(rank, card.getFieldValue(cardInstance, intAttributeName1), String.format(msg, cardClassName, intAttributeName1));
        assertEquals(suit, card.getFieldValue(cardInstance, stringAttributeName), String.format(msg, cardClassName, stringAttributeName));
    }

    private static Stream<Integer> getRankInputProvider() {
        return Stream.of(0, 1, 5, 13, 6238);
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
                {rank, int.class},
                {"suit", String.class}
        };
        Object cardInstance = card.createInstance(constructorArguments);
        card.setFieldValue(cardInstance, rank, intAttributeName1);

        /* Call getRank on card */
        Object output = card.callMethod(getRankMethodName, cardInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(rank, output, String.format(incorrectUpdate, getRankMethodName, intAttributeName1));
    }

    private static Stream<String> getSuitInputProvider() {
        return Stream.of("Spades", "Clubs", "Diamonds", "Hearts", "suits", "");
    }

    @ParameterizedTest
    @MethodSource("getSuitInputProvider")
    public void correctGetSuitMethod(String suit) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(card.hasMethod(getSuitMethodName, null),
                String.format(incorrectDefinition, cardClassName, getSuitMethodName));
        assertTrue(card.hasModifier(getSuitMethodName, null, "public"),
                String.format(incorrectModifier, getSuitMethodName));
        assertTrue(card.hasReturnType(getSuitMethodName, null, String.class),
                String.format(incorrectReturnType, getSuitMethodName));

        /* Create instance to call method on */
        Object[][] constructorArguments = {
                {3, int.class},
                {suit, String.class}
        };
        Object cardInstance = card.createInstance(constructorArguments);
        card.setFieldValue(cardInstance, suit, stringAttributeName);

        /* Call getSuit on card */
        Object output = card.callMethod(getSuitMethodName, cardInstance);

        /* Check result */
        String incorrectUpdate = "Your %s method does not return the value of the %s attribute.";
        _assertEquals(suit, output, String.format(incorrectUpdate, getSuitMethodName, stringAttributeName));
    }

    private static Stream<Arguments> isBiggerThanInputProvider() {
        return Stream.of(
                Arguments.of(new Object[][]{{11, int.class}, {"Hearts", String.class}}, new Object[][]{{5, int.class}, {"Clubs", String.class}}, true),
                Arguments.of(new Object[][]{{10, int.class}, {"Spades", String.class}}, new Object[][]{{9, int.class}, {"Spades", String.class}}, true),
                Arguments.of(new Object[][]{{8, int.class}, {"Hearts", String.class}}, new Object[][]{{8, int.class}, {"Clubs", String.class}}, false),
                Arguments.of(new Object[][]{{1, int.class}, {"Clubs", String.class}}, new Object[][]{{13, int.class}, {"Hearts", String.class}}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("isBiggerThanInputProvider")
    public void correctIsBiggerThanMethod(Object[][] cardArguments1, Object[][] cardArguments2, boolean ans) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{card.getObjectClass()};
        assertTrue(card.hasMethod(isBiggerThanMethodName, methodClassParameters),
                String.format(incorrectDefinition, cardClassName, isBiggerThanMethodName));
        assertTrue(card.hasModifier(isBiggerThanMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, isBiggerThanMethodName));
        assertTrue(card.hasReturnType(isBiggerThanMethodName, methodClassParameters, boolean.class),
                String.format(incorrectReturnType, isBiggerThanMethodName));

        /* Create instance to call method on */
        Object cardInstance1 = card.createInstance(cardArguments1);
        Object cardInstance2 = card.createInstance(cardArguments2);

        /* Call isBiggerThan on card */
        Object[][] input = {{cardInstance2, card.getObjectClass()}};
        Object output = card.callMethod(isBiggerThanMethodName, input, cardInstance1);

        /* Check result */
        String incorrectReturn = "Your %s method does not correctly identify is the given card is lower than the card instance.";
        _assertEquals(ans, output, String.format(incorrectReturn, isBiggerThanMethodName));
    }

    private static Stream<Arguments> cardToStringInputProvider() {
        return Stream.of(
                Arguments.of(new Object[][]{{1, int.class}, {"Hearts", String.class}}, "A of Hearts"),
                Arguments.of(new Object[][]{{2, int.class}, {"Diamonds", String.class}}, "2 of Diamonds"),
                Arguments.of(new Object[][]{{3, int.class}, {"Clubs", String.class}}, "3 of Clubs"),
                Arguments.of(new Object[][]{{4, int.class}, {"Spades", String.class}}, "4 of Spades"),
                Arguments.of(new Object[][]{{6, int.class}, {"Hearts", String.class}}, "6 of Hearts"),
                Arguments.of(new Object[][]{{9, int.class}, {"Diamonds", String.class}}, "9 of Diamonds"),
                Arguments.of(new Object[][]{{10, int.class}, {"Clubs", String.class}}, "10 of Clubs"),
                Arguments.of(new Object[][]{{11, int.class}, {"Spades", String.class}}, "J of Spades"),
                Arguments.of(new Object[][]{{12, int.class}, {"Hearts", String.class}}, "Q of Hearts"),
                Arguments.of(new Object[][]{{13, int.class}, {"Diamonds", String.class}}, "K of Diamonds")
        );
    }

    @ParameterizedTest
    @MethodSource("cardToStringInputProvider")
    public void cardHasCorrectToStringMethod(Object[][] arguments, String ans) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(card.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, cardClassName, methodNameToString));
        assertTrue(card.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(card.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object cardInstance = card.createInstance(arguments);

        String result = (String) card.callMethod("toString", cardInstance);
        assertEquals(ans, result, "Your " + cardClassName + " class toString method does not return the correct String. Ensure the formatting matches the description in the question text.");
    }

    @Test
    public void deckOfCardsClassHasRequiredAttributes() {
        String missingAttribute = "Your %s class is missing the %s attribute. Make sure the class contains the attribute and it is spelt correctly.";
        String incorrectModifier = "Your %s attribute does not have the correct %s modifier.";
        assertTrue(deckOfCards.hasField(finalIntAttributeName1), String.format(missingAttribute, deckOfCardsClassName, finalIntAttributeName1));
        assertTrue(deckOfCards.hasField(finalIntAttributeName1, int.class), String.format(incorrectTypeMessage, finalIntAttributeName1));
        assertTrue(deckOfCards.hasModifier(finalIntAttributeName1, "private"), String.format(incorrectModifier, finalIntAttributeName1, "visibility"));
        assertTrue(deckOfCards.hasField(finalIntAttributeName2), String.format(missingAttribute, deckOfCardsClassName, finalIntAttributeName2));
        assertTrue(deckOfCards.hasField(finalIntAttributeName2, int.class), String.format(incorrectTypeMessage, finalIntAttributeName2));
        assertTrue(deckOfCards.hasModifier(finalIntAttributeName2, "private"), String.format(incorrectModifier, finalIntAttributeName2, "visibility"));
        assertTrue(deckOfCards.hasField(finalIntAttributeName3), String.format(missingAttribute, deckOfCardsClassName, finalIntAttributeName3));
        assertTrue(deckOfCards.hasField(finalIntAttributeName3, int.class), String.format(incorrectTypeMessage, finalIntAttributeName3));
        assertTrue(deckOfCards.hasModifier(finalIntAttributeName3, "private"), String.format(incorrectModifier, finalIntAttributeName3, "visibility"));
        assertTrue(deckOfCards.hasField(cardArrayAttributeName), String.format(missingAttribute, deckOfCardsClassName, cardArrayAttributeName));
        assertTrue(deckOfCards.hasField(cardArrayAttributeName, card.getObjectArrayClass()), String.format(incorrectTypeMessage, cardArrayAttributeName));
        assertTrue(deckOfCards.hasModifier(cardArrayAttributeName, "private"), String.format(incorrectModifier, cardArrayAttributeName, "visibility"));
        assertTrue(deckOfCards.hasField(intAttributeName2), String.format(missingAttribute, deckOfCardsClassName, intAttributeName2));
        assertTrue(deckOfCards.hasField(intAttributeName2, int.class), String.format(incorrectTypeMessage, intAttributeName2));
        assertTrue(deckOfCards.hasModifier(intAttributeName2, "private"), String.format(incorrectModifier, intAttributeName2, "visibility"));
    }

    @Test
    public void deckOfCardsClassHasRequiredConstructor() throws Throwable {
        /* Check Constructor Definition */
        String missingConstructor = "Your %s class is missing a required constructor. Make sure it has the correct parameters in the specified order.";
        String incorrectModifier = "The constructor in your %s class does not have the correct visibility modifier.";
        Class<?>[] constructorParameters = new Class[]{};
        assertTrue(deckOfCards.hasConstructor(constructorParameters), String.format(missingConstructor, deckOfCardsClassName));
        assertTrue(deckOfCards.hasModifier(constructorParameters, "public"), String.format(incorrectModifier, deckOfCardsClassName));

        /* Check constructor functionality */
        Object deckInstance = deckOfCards.createInstance();

        String msg = "Your %s class constructor does not correctly initialize the %s value.";
        assertEquals(suits, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName2), String.format(msg, deckOfCardsClassName, finalIntAttributeName2));
        assertEquals(ranks, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName1), String.format(msg, deckOfCardsClassName, finalIntAttributeName1));
        assertEquals(maxCards, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName3), String.format(msg, deckOfCardsClassName, finalIntAttributeName3));
        assertEquals(0, deckOfCards.getFieldValue(deckInstance, intAttributeName2), String.format(msg, deckOfCardsClassName, intAttributeName2));
        Object[] holdArray = (Object[]) card.createArray(maxCards);
        assertArrayEquals(holdArray, (Object[]) deckOfCards.getFieldValue(deckInstance, cardArrayAttributeName), String.format(msg, deckOfCardsClassName, cardArrayAttributeName));
    }

    private static Stream<Integer> setInputProvider() {
        return Stream.of(1, 2, 3, 4, 5, 12, 13, 14, 20);
    }

    @ParameterizedTest
    @MethodSource("setInputProvider")
    public void correctSetSuitsMethod(int suit) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(deckOfCards.hasMethod(setSuitsMethodName, methodClassParameters),
                String.format(incorrectDefinition, deckOfCardsClassName, setSuitsMethodName));
        assertTrue(deckOfCards.hasModifier(setSuitsMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setSuitsMethodName));
        assertTrue(deckOfCards.hasReturnType(setSuitsMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setSuitsMethodName));

        /* Create instance to call method on */
        Object deckInstance = deckOfCards.createInstance();
        deckOfCards.setFieldValue(deckInstance, suit + 1, finalIntAttributeName2);

        /* Call setSuits on card */
        Object[][] methodArguments = new Object[][]{{suit, int.class}};
        if (suit <= 4) {
            deckOfCards.callMethod(setSuitsMethodName, methodArguments, deckInstance);
            assertEquals(suit, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName2),
                    "Your " + setSuitsMethodName + " method does not correctly change the value of the " + finalIntAttributeName2 + " attribute.");
            assertEquals(suit * ranks, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName3),
                    "Your " + setSuitsMethodName + " method does not correctly update the value of the " + finalIntAttributeName3 + " attribute.");
            assertArrayEquals((Object[]) card.createArray(suit * ranks), (Object[]) deckOfCards.getFieldValue(deckInstance, cardArrayAttributeName),
                    "Your " + setSuitsMethodName + " method does not correctly reinitialize the " + cardArrayAttributeName + " attribute.");
        } else {
            Object[] holdArray = ((Object[]) deckOfCards.getFieldValue(deckInstance, cardArrayAttributeName)).clone();
            deckOfCards.setFieldValue(deckInstance, (suit + 1) * ranks, finalIntAttributeName3);
            deckOfCards.callMethod(setSuitsMethodName, methodArguments, new String[]{"public"}, deckInstance, new Clause[]{new StringLiteral("Invalid value")},
                    "Your " + setSuitsMethodName + " method does not recognize invalid input and print the required response.");
            assertEquals(suit + 1, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName2),
                    "Your " + setSuitsMethodName + " method does not correctly maintain the value of the " + finalIntAttributeName2 + " attribute after invalid input.");
            assertEquals((suit + 1) * ranks, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName3),
                    "Your " + setSuitsMethodName + " method does not correctly maintain the value of the " + finalIntAttributeName3 + " attribute.");
            assertArrayEquals(holdArray, (Object[]) deckOfCards.getFieldValue(deckInstance, cardArrayAttributeName),
                    "Your " + setSuitsMethodName + " method does not correctly maintain the " + cardArrayAttributeName + " attribute.");
        }
    }

    @ParameterizedTest
    @MethodSource("setInputProvider")
    public void correctSetRanksMethod(int rank) throws Throwable {
        /* Check method definition */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(deckOfCards.hasMethod(setRanksMethodName, methodClassParameters),
                String.format(incorrectDefinition, deckOfCardsClassName, setRanksMethodName));
        assertTrue(deckOfCards.hasModifier(setRanksMethodName, methodClassParameters, "public"),
                String.format(incorrectModifier, setRanksMethodName));
        assertTrue(deckOfCards.hasReturnType(setRanksMethodName, methodClassParameters, Void.TYPE),
                String.format(incorrectReturnType, setRanksMethodName));

        /* Create instance to call method on */
        Object deckInstance = deckOfCards.createInstance();
        deckOfCards.setFieldValue(deckInstance, rank + 1, finalIntAttributeName1);

        /* Call setSuits on card */
        Object[][] methodArguments = new Object[][]{{rank, int.class}};
        if (rank <= 13) {
            deckOfCards.callMethod(setRanksMethodName, methodArguments, deckInstance);
            assertEquals(rank, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName1),
                    "Your " + setRanksMethodName + " method does not correctly change the value of the " + finalIntAttributeName1 + " attribute.");
            assertEquals(rank * suits, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName3),
                    "Your " + setSuitsMethodName + " method does not correctly update the value of the " + finalIntAttributeName3 + " attribute.");
            assertArrayEquals((Object[]) card.createArray(suits * rank), (Object[]) deckOfCards.getFieldValue(deckInstance, cardArrayAttributeName),
                    "Your " + setSuitsMethodName + " method does not correctly reinitialize the " + cardArrayAttributeName + " attribute.");
        } else {
            Object[] holdArray = ((Object[]) deckOfCards.getFieldValue(deckInstance, cardArrayAttributeName)).clone();
            deckOfCards.setFieldValue(deckInstance, (rank + 1) * suits, finalIntAttributeName3);
            deckOfCards.callMethod(setRanksMethodName, methodArguments, new String[]{"public"}, deckInstance, new Clause[]{new StringLiteral("Invalid value")},
                    "Your " + setRanksMethodName + " method does not recognize invalid input and print the required response.");
            assertEquals(rank + 1, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName1),
                    "Your " + setRanksMethodName + " method does not correctly maintain the value of the " + finalIntAttributeName1 + " attribute after invalid input.");
            assertEquals((rank + 1) * suits, deckOfCards.getFieldValue(deckInstance, finalIntAttributeName3),
                    "Your " + setSuitsMethodName + " method does not correctly maintain the value of the " + finalIntAttributeName3 + " attribute.");
            assertArrayEquals(holdArray, (Object[]) deckOfCards.getFieldValue(deckInstance, cardArrayAttributeName),
                    "Your " + setSuitsMethodName + " method does not correctly maintain the " + cardArrayAttributeName + " attribute.");
        }
    }

    private static Stream<Arguments> shuffleInputProvider() {
        return Stream.of(
                Arguments.of(ranks, suits, maxCards),
                Arguments.of(ranks - 1, suits, (ranks - 1) * suits),
                Arguments.of(ranks - 3, suits - 2, (ranks - 3) * (suits - 2)),
                Arguments.of(5, suits - 1, 5 * (suits - 1))
        );
    }

    @ParameterizedTest
    @MethodSource("shuffleInputProvider")
    public void correctShuffleCardsMethod(int ranks, int suits, int maxCards) throws Throwable {

        /* Check that the method exists and is declared correctly */
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(deckOfCards.hasMethod(shuffleCardsMethodName, null),
                String.format(incorrectDefinition, deckOfCardsClassName, shuffleCardsMethodName));
        assertTrue(deckOfCards.hasModifier(shuffleCardsMethodName, null, "public"),
                String.format(incorrectModifier, shuffleCardsMethodName));
        assertTrue(deckOfCards.hasReturnType(shuffleCardsMethodName, null, Void.TYPE),
                String.format(incorrectReturnType, shuffleCardsMethodName));

        Object deckInstance = deckOfCards.createInstance();
        deckOfCards.setFieldValue(deckInstance, card.createArray(maxCards), cardArrayAttributeName);
        deckOfCards.setFieldValue(deckInstance, ranks, finalIntAttributeName1);
        deckOfCards.setFieldValue(deckInstance, suits, finalIntAttributeName2);
        deckOfCards.setFieldValue(deckInstance, maxCards, finalIntAttributeName3);
        deckOfCards.setFieldValue(deckInstance, 0, intAttributeName2);

        int repetitions = (1000 / maxCards) - 2;
        ArrayList<Integer> randomRanksValues = new ArrayList<>();
        ArrayList<Integer> randomSuitsValues = new ArrayList<>();

        // Check for uniqueness property
        for (int x = 0; x < 3; x++) {
            deckOfCards.callMethod(shuffleCardsMethodName, deckInstance);
            int[] unique = new int[maxCards];
            Object[] holdCards = (Object[]) deckOfCards.getFieldValue(deckInstance, cardArrayAttributeName);
            for (Object holdCard : holdCards) {
                String holdSuit = (String) card.getFieldValue(holdCard, stringAttributeName);
                int rank = (int) card.getFieldValue(holdCard, intAttributeName1);
                if (rank < 0 || rank > ranks)
                    fail("Your " + shuffleCardsMethodName + " method does not generate " + cardClassName + "s with valid " + intAttributeName1 + " values (1-" + ranks + ").");
                randomRanksValues.add(rank);
                int increment = -1;
                if (holdSuit.equals("Spades")) {
                    increment = 0;
                    randomSuitsValues.add(1);
                } else if (holdSuit.equals("Hearts")) {
                    increment = ranks;
                    randomSuitsValues.add(2);
                } else if (holdSuit.equals("Clubs")) {
                    if (suits <= 2)
                        fail("Your " + shuffleCardsMethodName + " method does not generate " + cardClassName + "s with valid " + stringAttributeName + " values (Spades and Hearts).");
                    increment = ranks * 2;
                    randomSuitsValues.add(3);
                } else if (holdSuit.equals("Diamonds")) {
                    if (suits <= 3) {
                        fail("Your " + shuffleCardsMethodName + " method does not generate " + cardClassName + "s with valid " + stringAttributeName + " values (Spades, Hearts, and Clubs).");
                    }
                    increment = ranks * 3;
                    randomSuitsValues.add(4);
                } else
                    fail("Your " + shuffleCardsMethodName + " method does not generate " + cardClassName + "s with valid " + stringAttributeName + " values.");
                int index = (rank - 1) + increment;
                if (unique[index] == 0)
                    unique[index]++;
                else
                    fail("Your " + shuffleCardsMethodName + " generated duplicates of a " + cardClassName + ".");
            }
        }

        // collect remaining values necessary for the randomization check
        for (int x = 0; x < repetitions; x++) {
            deckOfCards.callMethod(shuffleCardsMethodName, deckInstance);
            Object[] holdCards = (Object[]) deckOfCards.getFieldValue(deckInstance, cardArrayAttributeName);
            for (Object holdCard : holdCards) {
                String holdSuit = (String) card.getFieldValue(holdCard, stringAttributeName);
                randomRanksValues.add((int) card.getFieldValue(holdCard, intAttributeName1));
                if (holdSuit.equals("Spades"))
                    randomSuitsValues.add(1);
                else if (holdSuit.equals("Hearts"))
                    randomSuitsValues.add(2);
                else if (holdSuit.equals("Clubs"))
                    randomSuitsValues.add(3);
                else if (holdSuit.equals("Diamonds"))
                    randomSuitsValues.add(4);
            }
        }

        // test randomness
        RandomInteger randomInteger = new RandomInteger(1, ranks + 1); // Checking for values in range from 0 to max ranks
        randomInteger.validateRandom(randomRanksValues);
        randomInteger = new RandomInteger(1, suits + 1); // Checking for values in range from 0 to max suits
        randomInteger.validateRandom(randomSuitsValues);
    }

    private static Stream<Arguments> mapToStringInputProvider() {
        return Stream.of(Arguments.of(1, "Spades"), Arguments.of(2, "Hearts"), Arguments.of(3, "Clubs"), Arguments.of(4, "Diamonds"));
    }

    @ParameterizedTest
    @MethodSource("mapToStringInputProvider")
    public void correctMapToStringMethod(int input, String ans) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        Class<?>[] methodClassParameters = new Class[]{int.class};
        assertTrue(deckOfCards.hasMethod(mapSuitToStringMethodName, methodClassParameters),
                String.format(incorrectDefinition, deckOfCardsClassName, mapSuitToStringMethodName));
        assertTrue(deckOfCards.hasModifier(mapSuitToStringMethodName, methodClassParameters, "private"),
                String.format(incorrectModifier, mapSuitToStringMethodName));
        assertTrue(deckOfCards.hasReturnType(mapSuitToStringMethodName, methodClassParameters, String.class),
                String.format(incorrectReturnType, mapSuitToStringMethodName));

        /* Create instance of deck */
        Object deckInstance = deckOfCards.createInstance();

        /* Call method */
        String output = (String) deckOfCards.callMethod(mapSuitToStringMethodName, new Object[][]{{input, int.class}}, deckInstance);

        assertEquals(ans, output, "Your " + mapSuitToStringMethodName + " method does not return the correct output for a given input.");
    }

    @Test
    public void correctDealMethod() throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        assertTrue(deckOfCards.hasMethod(dealMethodName, null),
                String.format(incorrectDefinition, deckOfCardsClassName, dealMethodName));
        assertTrue(deckOfCards.hasModifier(dealMethodName, null, "public"),
                String.format(incorrectModifier, dealMethodName));
        assertTrue(deckOfCards.hasReturnType(dealMethodName, null, card.getObjectClass()),
                String.format(incorrectReturnType, dealMethodName));

        /* Create instance of deck */
        Object deckInstance = deckOfCards.createInstance();

        Object[] holdDeck = (Object[]) card.createArray(maxCards);
        for (int x = 0; x < suits; x++) {
            for (int y = 0; y < ranks; y++) {
                String suit = x == 0 ? "Spades" : x == 1 ? "Clubs" : x == 2 ? "Hearts" : "Diamonds";
                Object[][] arguments = new Object[][]{{y + 1, int.class}, {suit, String.class}};
                holdDeck[y + (x * ranks)] = card.createInstance(arguments);
            }
        }
        Object[] deckClone = holdDeck.clone();
        deckOfCards.setFieldValue(deckInstance, holdDeck, cardArrayAttributeName);
        deckOfCards.setFieldValue(deckInstance, 0, intAttributeName2);

        int position = 0;
        for (int x = 0; x < maxCards + 2; x++) {
            if (position < maxCards) {
                Object output = deckOfCards.callMethod(dealMethodName, deckInstance);
                assertEquals(deckClone[x], output,
                        "Your " + dealMethodName + " method does not return the " + cardClassName + " located at the " + intAttributeName2 + " index.");
            } else {
                Object output = deckOfCards.callMethod(dealMethodName, deckInstance, new Clause[]{new StringLiteral("There are no more cards left in the deck.")},
                        "Your " + dealMethodName + " method does not print the correct statement after the end of the " + cardArrayAttributeName + " is reached.");
                assertNull(output, "Your " + dealMethodName + " method does not return null after the end of the " + cardArrayAttributeName + " is reached.");
            }
            position++;
        }
    }

    private static Stream<Arguments> deckToStringInputProvider() {
        Object[][][] deck1 = new Object[maxCards][2][2];
        StringBuilder msg1 = new StringBuilder();
        for (int x = 0; x < maxCards; x++) {
            deck1[x] = new Object[][]{{5, int.class}, {"Spades", String.class}};
            msg1.append("5 of Spades\n");
        }

        Object[][][] deck2 = new Object[maxCards][2][2];
        StringBuilder msg2 = new StringBuilder();
        int count = 0;
        for (int x = 0; x < suits; x++) {
            for (int y = 0; y < ranks; y++) {
                String suit = x == 0 ? "Spades" : x == 1 ? "Clubs" : x == 2 ? "Hearts" : "Diamonds";
                deck2[count++] = new Object[][]{{y + 1, int.class}, {suit, String.class}};
                if (y + 1 == 1)
                    msg2.append("A");
                else if (y + 1 <= 10)
                    msg2.append(y + 1);
                else if (y + 1 == 11)
                    msg2.append("J");
                else if (y + 1 == 12)
                    msg2.append("Q");
                else
                    msg2.append("K");
                msg2.append(" of ").append(suit).append("\n");
            }
        }

        return Stream.of(
                Arguments.of(deck1, msg1.toString()), // all the same
                Arguments.of(deck2, msg2.toString()), // ascending
                Arguments.of(new Object[][][]{{{13, int.class}, {"Spades", String.class}}, {{13, int.class}, {"Hearts", String.class}},
                                {{5, int.class}, {"Spades", String.class}}, {{9, int.class}, {"Spades", String.class}}, {{13, int.class}, {"Clubs", String.class}},
                                {{5, int.class}, {"Hearts", String.class}}, {{4, int.class}, {"Spades", String.class}}, {{2, int.class}, {"Spades", String.class}},
                                {{13, int.class}, {"Diamonds", String.class}}, {{3, int.class}, {"Spades", String.class}}, {{12, int.class}, {"Spades", String.class}},
                                {{9, int.class}, {"Hearts", String.class}}, {{10, int.class}, {"Spades", String.class}}, {{2, int.class}, {"Hearts", String.class}},
                                {{9, int.class}, {"Clubs", String.class}}, {{5, int.class}, {"Clubs", String.class}}, {{12, int.class}, {"Hearts", String.class}},
                                {{4, int.class}, {"Hearts", String.class}}, {{7, int.class}, {"Spades", String.class}}, {{2, int.class}, {"Clubs", String.class}},
                                {{8, int.class}, {"Spades", String.class}}, {{11, int.class}, {"Spades", String.class}}, {{7, int.class}, {"Hearts", String.class}},
                                {{4, int.class}, {"Clubs", String.class}}, {{5, int.class}, {"Diamonds", String.class}}, {{11, int.class}, {"Hearts", String.class}},
                                {{2, int.class}, {"Diamonds", String.class}}, {{11, int.class}, {"Clubs", String.class}}, {{10, int.class}, {"Hearts", String.class}},
                                {{11, int.class}, {"Diamonds", String.class}}, {{10, int.class}, {"Clubs", String.class}}, {{10, int.class}, {"Diamonds", String.class}},
                                {{12, int.class}, {"Clubs", String.class}}, {{7, int.class}, {"Clubs", String.class}}, {{3, int.class}, {"Hearts", String.class}},
                                {{3, int.class}, {"Clubs", String.class}}, {{4, int.class}, {"Diamonds", String.class}}, {{7, int.class}, {"Diamonds", String.class}},
                                {{3, int.class}, {"Diamonds", String.class}}, {{8, int.class}, {"Hearts", String.class}}, {{1, int.class}, {"Spades", String.class}},
                                {{1, int.class}, {"Hearts", String.class}}, {{1, int.class}, {"Clubs", String.class}}, {{6, int.class}, {"Spades", String.class}},
                                {{9, int.class}, {"Diamonds", String.class}}, {{8, int.class}, {"Clubs", String.class}}, {{6, int.class}, {"Hearts", String.class}},
                                {{8, int.class}, {"Diamonds", String.class}}, {{1, int.class}, {"Diamonds", String.class}}, {{12, int.class}, {"Diamonds", String.class}},
                                {{6, int.class}, {"Clubs", String.class}}, {{6, int.class}, {"Diamonds", String.class}}},
                        "K of Spades\nK of Hearts\n5 of Spades\n9 of Spades\nK of Clubs\n5 of Hearts\n4 of Spades\n2 of Spades\nK of Diamonds\n3 of Spades\n" +
                                "Q of Spades\n9 of Hearts\n10 of Spades\n2 of Hearts\n9 of Clubs\n5 of Clubs\nQ of Hearts\n4 of Hearts\n7 of Spades\n2 of Clubs\n" +
                                "8 of Spades\nJ of Spades\n7 of Hearts\n4 of Clubs\n5 of Diamonds\nJ of Hearts\n2 of Diamonds\nJ of Clubs\n10 of Hearts\nJ of Diamonds\n" +
                                "10 of Clubs\n10 of Diamonds\nQ of Clubs\n7 of Clubs\n3 of Hearts\n3 of Clubs\n4 of Diamonds\n7 of Diamonds\n3 of Diamonds\n8 of Hearts\n" +
                                "A of Spades\nA of Hearts\nA of Clubs\n6 of Spades\n9 of Diamonds\n8 of Clubs\n6 of Hearts\n8 of Diamonds\nA of Diamonds\nQ of Diamonds\n" +
                                "6 of Clubs\n6 of Diamonds\n") //randomized
        );
    }

    @ParameterizedTest
    @MethodSource("deckToStringInputProvider")
    public void deckOfCardsHasCorrectToStringMethod(Object[][][] arguments, String msg) throws Throwable {
        String incorrectDefinition = "Your %s class is missing the %s method. Make sure it is defined, spelt correctly, and has the correct parameters.";
        String incorrectModifier = "The %s method does not have the correct visibility modifier.";
        String incorrectReturnType = "The %s method does not have the correct return type.";
        String methodNameToString = "toString";
        assertTrue(deckOfCards.hasMethod(methodNameToString, null),
                String.format(incorrectDefinition, deckOfCardsClassName, methodNameToString));
        assertTrue(deckOfCards.hasModifier(methodNameToString, null, "public"),
                String.format(incorrectModifier, methodNameToString));
        assertTrue(deckOfCards.hasReturnType(methodNameToString, null, String.class),
                String.format(incorrectReturnType, methodNameToString));

        Object deckInstance = deckOfCards.createInstance();

        deckOfCards.setFieldValue(deckInstance, card.createArray(maxCards, arguments), cardArrayAttributeName);
        String result = (String) deckOfCards.callMethod("toString", deckInstance);

        assertEquals(msg, result, "Your " + deckOfCardsClassName + " class's toString method does not return the correct String. Ensure it follows the formatting laid out in the question text.");
    }
}
