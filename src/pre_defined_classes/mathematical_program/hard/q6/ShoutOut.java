package pre_defined_classes.mathematical_program.hard.q6;

/*
Figuring out the intensity of sound in the decibel (dB) scale is an interesting application of logarithms.
To calculate the deciBel values of a particular sound, we use the formula: dB = 10 log(Ip/I0), Where Ip is the intensity
of the sound to be measured in W/m^2 ( Watts per metre squared), I0 is the minimum intensity of sound that can be heard
by the human ear (which is known to be 10^-12 W/m^2). Make a Java program to find the ratio between the decibel value
of a person speaking if the intensity of their voice is 10^-5 W/m^2  and a person shouting which has the intensity of
10^-4 W/m^2 .

Distractors:
int dB = 10 * ( Math.log( IpShout / I0 ) );
double dB = ( Math.log( IpShout / I0 ) );
int dB =   ( Math.log( IpShout / 10 ) );
double dBRatio = ( 10 * ( Math.log( IpSpeak / I0 ) ) ) / dB;
dB = ( 10 * ( Math.log( IpSpeak / I0 ) ) ) ;
dBRatio = ( 10 * ( Math.Log( IpSpeak / I0 ) ) ) / dB;
dBSpeak = 10 * ( log( IpSpeak / I0 ) );
dBShout = 10 * ( log( IpShout / I0 ) );
dBRatio = dBShout  / dBSpeak;
 */
public class ShoutOut {
    public static void main(String[] args) {
        double I0 = Math.pow(10, -12);
        double IpSpeak = Math.pow(10, -5);
        double IpShout = Math.pow(10, -4);
        double dBSpeak, dBShout, dBRatio;
        dBSpeak = 10 * (Math.log(IpSpeak / I0));
        dBShout = 10 * (Math.log(IpShout / I0));
        dBRatio = dBSpeak / dBShout;
        System.out.println("The ratio of the decibel values between a person speak and a person shouting is " + dBRatio);
    }

}
