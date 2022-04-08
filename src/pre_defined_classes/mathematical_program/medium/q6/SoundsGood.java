package pre_defined_classes.mathematical_program.medium.q6;

/*
An interesting use of logarithms and exponents can be found in the decibel (dB) scale for measuring the intensity of a
sound. To calculate the decibel values of a particular sound, we use the formula : dB = 10 log(IpI0), where Ip is the
intensity of the sound to be measured in W/m2 ( Watts per metre squared ), I0 is the minimum intensity of sound that
can be heard by the human ear which is known as 10-12 W/m2. Make a Java program that finds the decibel value of a person
speaking if the intensity of the voice is 10-5 W/m2.
 */

public class SoundsGood {
    public static void main(String[] args) {
        double I0 = Math.pow(10, -12);
        double Ip = Math.pow(10, -5);
        double dB = 10 * (Math.log(Ip / I0));
        System.out.println("A person speaking is " + dB + " decibels loud!");
    }
}
