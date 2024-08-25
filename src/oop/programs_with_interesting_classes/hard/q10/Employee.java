package oop.programs_with_interesting_classes.hard.q10;

public class Employee {
    private String name;
    private boolean[][] availability;

    public Employee(String name) {
        this.name = name;
        this.availability = new boolean[WorkSchedule.NUM_DAYS][WorkSchedule.NUM_SLOTS];
    }

    public boolean[][] getAvailability() {
        return this.availability;
    }

    public void addTime(int day, int slot) {
        if (day >= 0 && day < WorkSchedule.NUM_DAYS)
            if (slot >= 0 && slot < WorkSchedule.NUM_SLOTS)
                availability[day][slot] = true;
    }

    public String toString() {
        String str = "Availability for " + name + ":\n";
        for (int i = 0; i < availability.length; i++) {
            if (i == 0) str += "Mon: ";
            else if (i == 1) str += "Tue: ";
            else if (i == 2) str += "Wed: ";
            else if (i == 3) str += "Thu: ";
            else str += "Fri: ";
            String[] shifts = new String[4];
            int count = 0;
            for (int j = 0; j < availability[i].length; j++)
                if (availability[i][j] == true) {
                    if (j == 0) shifts[count++] = "9am-noon";
                    else if (j == 1) shifts[count++] = "noon-3pm";
                    else if (j == 2) shifts[count++] = "3-6pm";
                    else shifts[count++] = "6-9pm";
                }
            for (int j = 0; j < count; j++) {
                if (j + 1 == count) {
                    str += shifts[j];
                } else {
                    str += shifts[j];
                    str += ", ";
                }
            }
            str += "\n";
        }
        return str;
    }
}
