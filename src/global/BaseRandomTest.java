package global;

import global.variables.RandomDouble;
import global.variables.RandomInteger;
import global.variables.RandomVariable;
import global.variables.Clause;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import static global.utils.RandomUtil.followsUniformDistribution;
import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class BaseRandomTest extends BaseTest {
    static Map<Integer, ArrayList<?>> randomMap = new HashMap<>();
    static boolean alreadyFailed = false;

    public void resetRandomMap() {
        randomMap = null;
        randomMap = new HashMap<>();
    }

    public void initializeRandomNumberMaps() {
        resetRandomMap();
        Clause[] regexSentence = getRegexSentence();
        for (int i = 0; i < regexSentence.length; i++) {
            Clause regexClause = regexSentence[i];
            if (!(regexClause instanceof RandomVariable)) continue;
            RandomVariable<?> randomVariable = (RandomVariable<?>) regexClause;

            int regexGroup = i + 1;
            randomMap.put(regexGroup, randomVariable.createArrayList());
        }
    }

    public void addValueToMapList(RandomVariable<?> randomVariable, int mapKey, Object newListValue) {
        randomVariable.addValueToMapListHelper((HashMap<Integer, ?>) randomMap, mapKey, newListValue);
    }

    // TODO: choose number
    @RepeatedTest(500)
    @Order(1)
    public void testRandomNumbers(RepetitionInfo repetitionInfo) {
        if (repetitionInfo.getCurrentRepetition() == 1) {
            initializeRandomNumberMaps();
        }

        if (alreadyFailed) fail();  // TODO: No message (?)

        String output = getOutput();
        Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        if (matcher.find()) {
            for (int i = 0; i < getRegexSentence().length; i++) {
                Clause regexClause = getRegexSentence()[i];
                if (!(regexClause instanceof RandomVariable)) continue;
                RandomVariable<?> randomVariable = (RandomVariable<?>) regexClause;

                int matchGroupNum = i + 1;
                String groupValue = matcher.group(matchGroupNum);
                addValueToMapList(randomVariable, matchGroupNum, randomVariable.convertFromRegexGroup(groupValue));
            }
        } else {
            alreadyFailed = true;
            fail("Incorrect format.");
        }

        if (repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            for (int i = 0; i < getRegexSentence().length; i++) {
                Clause regexClause = getRegexSentence()[i];
                if (!(regexClause instanceof RandomVariable)) continue;
                int mapKey = i + 1;

                boolean isUniformlyRandom = true;
                if (regexClause instanceof RandomInteger) {
                    ArrayList<Integer> values = (ArrayList<Integer>) randomMap.get(mapKey);
                    RandomInteger randomInteger = (RandomInteger) regexClause;
                    isUniformlyRandom = followsUniformDistribution(values, randomInteger.getLower(), randomInteger.getUpper());
                }

                if (regexClause instanceof RandomDouble) {
                    ArrayList<Double> values = (ArrayList<Double>) randomMap.get(mapKey);
                    RandomDouble randomDouble = (RandomDouble) regexClause;
                    isUniformlyRandom = followsUniformDistribution(values, randomDouble.getLower(), randomDouble.getUpper());
                }

//                if(regexClause instanceof RandomChar) {
//                    // TODO: handle this the smart way
//                    ArrayList<Character> values = (ArrayList<Character>) randomMap.get(mapKey);
//                    RandomChar randomChar = (RandomChar) regexClause;
//                    isUniformlyRandom &= followsUniformDistribution(values, randomChar.getLower(), randomChar.getUpper());
//                }

                // TODO: more info about which value, the way it's bad (out of bounds, within bounds, obviously hardcoded, etc) (?)
                assertTrue(isUniformlyRandom, "You do not seem to be properly generating random values.");
            }
        }
    }
}
