package arrays.arrays_with_methods.hard.q14;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    //use varying to swap which array is being called for which r value student must use, and modify the a value accordingly
    final static int a = 2;

    double[] rThreeOverFour = {1.0, 0.75, 0.5625, 0.421875, 0.31640625, 0.2373046875, 0.177978515625, 0.13348388671875,
            0.1001129150390625, 0.07508468627929688, 0.056313514709472656, 0.04223513603210449, 0.03167635202407837,
            0.023757264018058777, 0.017817948013544083, 0.013363461010158062, 0.010022595757618546, 0.00751694681821391,
            0.005637710113660432, 0.004228282585245324};
    double[] rOneOverTwo = {1.0, 0.5, 0.25, 0.125, 0.0625, 0.03125, 0.015625, 0.0078125, 0.00390625, 0.001953125,
            9.765625E-4, 4.8828125E-4, 2.44140625E-4, 1.220703125E-4, 6.103515625E-5, 3.0517578125E-5, 1.52587890625E-5,
            7.62939453125E-6, 3.814697265625E-6, 1.9073486328125E-6};
    double[] rOneOverThree = {1.0, 0.3333333333333333, 0.1111111111111111, 0.03703703703703703, 0.012345679012345677,
            0.004115226337448558, 0.0013717421124828527, 4.5724737082761756E-4, 1.524157902758725E-4, 5.0805263425290837E-5,
            1.693508780843028E-5, 5.645029269476759E-6, 1.8816764231589195E-6, 6.272254743863065E-7, 2.090751581287688E-7,
            6.969171937625627E-8, 2.3230573125418753E-8, 7.743524375139585E-9, 2.5811747917131946E-9, 8.603915972377315E-10};
    double[] rOneOverFour = {1.0, 0.25, 0.0625, 0.015625, 0.00390625, 9.765625E-4, 2.44140625E-4, 6.103515625E-5,
            1.52587890625E-5, 3.814697265625E-6, 9.5367431640625E-7, 2.384185791015625E-7, 5.9604644775390625E-8,
            1.4901161193847656E-8, 3.725290298461914E-9, 9.313225746154785E-10, 2.3283064365386963E-10, 5.820766091346741E-11,
            1.4551915228366852E-11, 3.637978807091713E-12};

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "40";
        return new Clause[]{
                new StringLiteral("Enter a value for n:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The first "),
                new IntegerLiteral("repetitions"),
                new StringLiteral(" values of the sequence are:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        GeometricSequence.main(new String[0]);
    }

    @RepeatedTest(20)
    void correctGeometricSequenceMethod(RepetitionInfo repetitionInfo) throws Throwable {
        double[] expected = new double[repetitionInfo.getCurrentRepetition()];
        for (int x = 0; x < expected.length; x++) {
            expected[x] = rOneOverTwo[x] * a;
        }
        Object[][] arguments = {
                {repetitionInfo.getCurrentRepetition(), int.class}
        };
        MethodTest m = new MethodTest(GeometricSequence.class, "geometricSequence", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(expected, output, "Your geometricSequence method does not calculate the sequence correctly.");
    }

    @RepeatedTest(20)
    void correctMainMethodOutput(RepetitionInfo repetitionInfo) throws InvalidClauseException {
        Clause[][] c = new Clause[1][repetitionInfo.getCurrentRepetition() * 2];
        int count = 0;

        for (int x = 0; x < repetitionInfo.getCurrentRepetition(); x++) {
            c[0][count++] = new DoubleLiteral(String.valueOf(x));
            c[0][count++] = new StringLiteral(" ");
        }

        runWithInput(String.valueOf(repetitionInfo.getCurrentRepetition()), c);

        assertEquals(repetitionInfo.getCurrentRepetition(), Integer.parseInt(getItemByName("repetitions")), "Your number of repetitions don't match the input value.");

        for (int x = 0; x < repetitionInfo.getCurrentRepetition(); x++) {
            assertEquals(rOneOverTwo[x] * a, Double.parseDouble(getItemByName(String.valueOf(x))), "Your program does not print the correct numbers in the sequence.");
        }
    }
}
