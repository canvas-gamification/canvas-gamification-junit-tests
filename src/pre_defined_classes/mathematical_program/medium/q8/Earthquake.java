package pre_defined_classes.mathematical_program.medium.q8;

/*
The Richter scale is a useful indication of the magnitude of an earthquake. Using a logarithmic formula, it classifies
earthquakes based on their intensity. The formula to determine the magnitude of an earthquake is: M = log(II0), where I
is the intensity of that earthquake and I0 is the baseline intensity of an earthquake with magnitude 0
(and hence always has a value of 1). Make a Java program that prints out the magnitude of an earthquake that had an
intensity of 2.32*10^4 units.
 */

public class Earthquake {
    public static void main(String[] args) {
        double intensity = 23200;
        double magnitude = Math.log(intensity / 1);
        System.out.println("The magnitude of an earthquake with intensity " + intensity + " is " + magnitude + " on the Richter scale.");
    }
}
