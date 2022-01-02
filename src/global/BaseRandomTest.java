package global;

import global.variables.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class BaseRandomTest extends BaseTest {
    static Map<Integer, ArrayList<?>> randomMap = new HashMap<>();

    public void resetRandomMap() {
        randomMap = null;
        randomMap = new HashMap<>();
    }

    public void initializeRandomNumberMaps() {
        // TODO: need to adapt to multi line output
        Regexable[] regexSentence = getRegexSentence();
        for (int i = 0; i < regexSentence.length; i++) {
            Regexable regexClause = regexSentence[i];
            if (!(regexClause instanceof RandomVariable)) continue;
            int regexGroup = i + 1;

            if (regexClause instanceof RandomInteger) randomMap.put(regexGroup, new ArrayList<Integer>());
            if (regexClause instanceof RandomDouble) randomMap.put(regexGroup, new ArrayList<Double>());
            if (regexClause instanceof RandomChar) randomMap.put(regexGroup, new ArrayList<Character>());
        }
    }

    public void addValueToMapList(RandomVariable<?> randomVariable, int mapKey, Object newListValue) {
        if (randomVariable instanceof RandomInteger) {
            int castedValue = (int) newListValue;
            addValueToMapListHelper(mapKey, castedValue);
        }
        if (randomVariable instanceof RandomDouble) {
            double castedValue = (double) newListValue;
            addValueToMapListHelper(mapKey, castedValue);
        }
        if (randomVariable instanceof RandomChar) {
            char castedValue = (char) newListValue;
            addValueToMapListHelper(mapKey, castedValue);
        }
    }

    public void addValueToMapListHelper(int mapKey, int newListValue) {
        ((ArrayList<Integer>) randomMap.get(mapKey)).add(newListValue);
    }

    public void addValueToMapListHelper(int mapKey, double newListValue) {
        ((ArrayList<Double>) randomMap.get(mapKey)).add(newListValue);
    }

    public void addValueToMapListHelper(int mapKey, char newListValue) {
        ((ArrayList<Character>) randomMap.get(mapKey)).add(newListValue);
    }

    // TODO: choose number
    @RepeatedTest(500)
    public void testRandomNumbers(RepetitionInfo repetitionInfo) {
        if (repetitionInfo.getCurrentRepetition() == 1) {
            // Initialization and setup before the 1st iteration
            resetRandomMap();
            initializeRandomNumberMaps();
        }

        String output = getOutput();
        // TODO: not always println though (in general how do we handle multi line outputs?) - arrays for each line in regex sentence?
        Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        if (matcher.find()) {
            for (int i = 0; i < getRegexSentence().length; i++) {
                Regexable regexClause = getRegexSentence()[i];
                if (!(regexClause instanceof RandomVariable)) continue;
                RandomVariable<?> randomVariable = (RandomVariable<?>) regexClause;
                int matchGroupNum = i + 1;
                String groupValue = matcher.group(matchGroupNum);
                addValueToMapList(randomVariable, matchGroupNum, randomVariable.convertFromRegexGroup(groupValue));
            }
        } else {
            fail("Incorrect format.");
        }

        if (repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            int a = 2;
//            // TODO: inefficient as it runs through all sets for each call on the last repetition - this can be better
//            for (Set<Integer> randomIntegerSet : randomIntegerSets) {
//                assertNotEquals(1, randomIntegerSet.size(), "You do not seem to be properly generating random values.");
//            }
//            for (Set<Double> randomDoubleSet : randomDoubleSets) {
//                assertNotEquals(1, randomDoubleSet.size(), "You do not seem to be properly generating random values.");
//            }
        }
    }
}
