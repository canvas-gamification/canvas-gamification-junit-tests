package oop.programs_with_interesting_classes.hard.q10;

public class WorkSchedule {
    public final static int NUM_DAYS = 5;
    public final static int NUM_SLOTS = 4;
    private String week;
    private int[][] timetable = new int[NUM_DAYS][NUM_SLOTS];

    public WorkSchedule(String week, Employee[] people) {
        this.week = week;
        howManyAvailable(people);
    }

    private void howManyAvailable(Employee[] people) {
        for (int p = 0; p < people.length; p++) {
            boolean[][] employeeTT = people[p].getAvailability();
            for (int i = 0; i < employeeTT.length; i++)
                for (int j = 0; j < employeeTT[i].length; j++)
                    if (employeeTT[i][j] == true)
                        timetable[i][j]++;
        }
    }

    public String toString() {
        String str = "Number of employees available to work for each time slot: \n";
        for (int i = 0; i < timetable.length; i++) {
            if (i == 0) str += "Mon:";
            else if (i == 1) str += "Tue:";
            else if (i == 2) str += "Wed:";
            else if (i == 3) str += "Thu:";
            else str += "Fri:";
            for (int j = 0; j < timetable[i].length; j++)
                str += "  " + timetable[i][j];
            str += "\n";
        }
        return str;
    }
}
