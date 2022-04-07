package global.tools;

import global.variables.Clause;
import global.variables.RandomClause;
import global.variables.clauses.PlaceHolder;

public class TestSentenceUtil {
    public static boolean hasRandom(Clause[] testSentence) {
        // does the sentence contain random clauses
        for (Clause clause : testSentence) {
            if (clause instanceof RandomClause) return true;
        }
        return false;
    }

    public static boolean hasPlaceHolders(Clause[] testSentence) {
        for (Clause clause : testSentence) {
            if (clause instanceof PlaceHolder) return true;
        }
        return false;
    }

    public static int placeHolderCount(Clause[] testSentence) {
        if (hasPlaceHolders(testSentence)) {
            int count = 0;
            for (Clause clause : testSentence) {
                if (clause instanceof PlaceHolder)
                    count++;
            }
            return count;
        }
        return 0;
    }

    public static Clause[] injectClauses(Clause[] testSentence, Clause[] injectedClauses) {
        // TODO: make sure the count is appropriate to do this here, too (or assume and let the error happen idk yet)

        if (injectedClauses == null) {
            return testSentence;
        }

        Clause[] modifiedTestSentence = new Clause[testSentence.length];
        int injectIndex = 0;
        for (int i = 0; i < testSentence.length; i++) {
            if (testSentence[i] instanceof PlaceHolder) {
                modifiedTestSentence[i] = injectedClauses[injectIndex++];
            } else {
                modifiedTestSentence[i] = testSentence[i];
            }
        }
        return modifiedTestSentence;  // return modified version of the test sentence
    }
}
