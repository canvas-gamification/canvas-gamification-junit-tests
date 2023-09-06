package oop.programs_with_interesting_classes.easy.q3;

public class AnnualCheckup {
    private String patient;
    private int numDays;

    public AnnualCheckup(String name, int daysSinceCheckup) {
        patient = name;
        numDays = daysSinceCheckup;
    }

    public void remindMe() {
        if (numDays >= 365) {
            System.out.println("Patient " + patient + " is due for a checkup.");
            numDays = 0;
        } else {
            System.out.println(patient + " still has " + (365 - numDays) + " day(s) until the checkup is due.");
            numDays++;
        }
    }
}
