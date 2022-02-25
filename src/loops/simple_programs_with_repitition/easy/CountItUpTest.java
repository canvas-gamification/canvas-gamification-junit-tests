package loops.simple_programs_with_repitition.easy;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class CountItUpTest extends BaseTest {
    
    String input1 = "This is just for testing. Do not copy!";
    String input2 = "s";

    public Clause[] testSentence() {

        Clause[] output = new Clause[5];

        output[0] = new StringLiteral("Enter a sentence: ");
        output[1] = new NewLine();
        output[2] = new StringLiteral("Enter the character to count: ");
        output[3] = new NewLine();
        output[4] = new StringLiteral("The number of times " + input2 + " occurs in the sentence is " + countingLetter(input1, input2.charAt(0)) + " times.");
        return output;
        
    }

    public void runMain() {
        provideInput(input1 + System.lineSeparator() + input2);
        CountItUp.main(new String[0]);
    }

    public static int countingLetter(String message, char c) {
        int count = 0; 
        for(int i = 0; i < message.length(); i++) 
            if( message.charAt(i) == c )
                count++;
        return count;
    }

}
