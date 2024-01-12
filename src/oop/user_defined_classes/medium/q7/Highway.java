package oop.user_defined_classes.medium.q7;

public class Highway {
    private int speedLimit;
    private int fine;

    public Highway(int spd) {
        speedLimit = spd;
        fine = 250;
    }

    public int issueTicket(int spd) {
        if (spd > speedLimit)
            return fine;
        else
            return 0;
    }
}
