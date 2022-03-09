package loops.simple_programs_with_repitition.easy.q6;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class MainTest extends BaseTest { // Parsons Test
    
    String input1 = "This is just for testing. Do not copy!";
    String input2 = "s";

    public Clause[] testSentence() {
        return new Clause[]{
            new StringLiteral("Enter a sentence: "),
            new NewLine(),
            new StringLiteral("Enter the character to count: "),
            new NewLine(),
            new StringLiteral("The number of times " + input2 + " occurs in the sentence is " + countingLetter(input1, input2.charAt(0)) + " times.")
        };
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
