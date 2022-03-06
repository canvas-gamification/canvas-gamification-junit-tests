package global.tools;

import global.variables.Clause;
import global.variables.clauses.PlaceHolder;

public class TestSentenceUtil {
    public static boolean hasPlaceHolders(Clause[] testSentence) {
        // TODO: does the sentence contain placeholders
        return false;
    }

    public static int placeHolderCount(Clause[] testSentence) {
        // TODO: return number of placeholders
        return 1;
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
