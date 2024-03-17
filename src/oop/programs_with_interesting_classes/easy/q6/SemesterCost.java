package oop.programs_with_interesting_classes.easy.q6;

public class SemesterCost {
    public static void main(String[] args) {
        Course c1 = new Course(215.50, 0, 0);
        Course c2 = new Course(15.50, 14.87, 10.99);
        Course c3 = new Course(0, 0, 89.99);
        Course c4 = new Course(0, 55, 185);
        Course c5 = new Course(10, 100.87, 39.99);
        Course[] semesterCourseLoad = {c1, c2, c3, c4, c5};
        double semesterTotal = 0;
        for (int i = 0; i < semesterCourseLoad.length; i++)
            semesterTotal += semesterCourseLoad[i].calcTotalCost();
        System.out.println("The total cost for this semester is: " + semesterTotal + " dollars");
    }
}
