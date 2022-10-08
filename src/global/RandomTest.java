package global;

import global.variables.Clause;
import global.variables.RandomClause;

import java.lang.reflect.Array;

import static global.tools.CustomAssertions._fail;
import static global.utils.RandomUtil.castRandomClause;

public class RandomTest {
    final static int NUM_RUNS = 1000;
    final static String MESSAGE_INCORRECT_RANDOM = "You do not seem to be properly generating random values.";

    public MethodTest methodTest;
    public Clause[] randomSentence;

    public RandomTest(MethodTest methodTest, Clause[] randomSentence) {
        this.randomSentence = randomSentence;
        this.methodTest = methodTest;
    }

    public void checkRandomness() throws Throwable {
        for (int repetitionCount = 1; repetitionCount <= NUM_RUNS; repetitionCount++) {
            Object output = methodTest.callMethod();
            Object[] randomArray;
            // Need to determine if output is an array or not, and turn the returned object into an object array accordingly
            if (!output.getClass().isArray()) {
                randomArray = new Object[]{output};
            } else {
                randomArray = new Object[Array.getLength(output)];
                for (int i = 0; i < randomArray.length; i++)
                    randomArray[i] = Array.get(output, i);
            }
            // Check if the object array equals the number of clauses. If not, the test will fail
            if (randomArray.length != randomSentence.length)
                _fail("Error with test definition: please contact an administrator.",
                        "Error with test definition: the number of clauses must be equal to number of items returned by the method.");
            // Store values in the appropriate clause
            storeRandomClauseValue(randomArray);
        }
    }

    public void storeRandomClauseValue(Object[] output) {
        for (int i = 0; i < randomSentence.length; i++) {
            Clause clause = randomSentence[i];
            RandomClause<?> randomVariable = castRandomClause(clause);
            if (randomVariable == null)
                continue;
            int matchGroupNum = i + 1;

        }
    }

}
