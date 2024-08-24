package oop.programs_with_interesting_classes.hard.q8;

public class TestSemester {
    public static void main(String[] args) {
        Course c1 = new Course("COSC 111", 2, 3, 3, 6);
        Course c2 = new Course("COSC 121", 1, 3, 4, 4);
        Course c3 = new Course("COSC 101", 0, 1, 0, 2);
        Course c4 = new Course("COSC 122", 1, 1, 2, 3);
        Course c5 = new Course("COSC 123", 2, 2, 8, 1);
        Course[] semesterCourseLoad = {c1, c2, c3, c4, c5};

        int schoolTime = calculateWorkload(semesterCourseLoad);
        displaySpareTime(schoolTime);
    }

    public static int calculateWorkload(Course[] courses) {
        int time = 0;
        for (Course course : courses) {
            time += course.calcWeeklyLoad();
            time += 3; //credit hours
        }
        return time;
    }

    public static void displaySpareTime(int timeToStudy) {
        int time = 7 * 24;
        time -= (7 * 8);
        time -= timeToStudy;

        System.out.println("This week you will have " + time + " hours of spare time.");
    }
}
