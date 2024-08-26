package oop.programs_with_interesting_classes.hard.q10;

public class StoreHours {
    public static void main(String[] args) {
        Employee ann = new Employee("Ann");
        ann.addTime(0, 0);
        ann.addTime(0, 1);
        ann.addTime(0, 2);
        ann.addTime(0, 3);
        ann.addTime(4, 1);
        ann.addTime(4, 2);
        ann.addTime(4, 3);
        System.out.println(ann);
        Employee bob = new Employee("Bob");
        bob.addTime(0, 0);
        bob.addTime(1, 0);
        bob.addTime(2, 0);
        bob.addTime(3, 0);
        bob.addTime(4, 0);
        Employee[] workers = {ann, bob};
        WorkSchedule timetable = new WorkSchedule("2nd week of February", workers);
        System.out.println(timetable);
    }
}
