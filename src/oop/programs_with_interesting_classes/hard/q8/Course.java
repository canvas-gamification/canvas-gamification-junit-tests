package oop.programs_with_interesting_classes.hard.q8;

public class Course {
    private final int STUDY_HOURS;
    private final int HOMEWORK_HOURS;
    private final String COURSE_CODE;
    private int numExams;
    private int numHwk;
    public Course( String cc, int ex, int hwk, int study_hours, int homework_hours )
    {
        COURSE_CODE = cc;
        numExams = ex;
        numHwk = hwk;
        STUDY_HOURS = study_hours;
        HOMEWORK_HOURS = homework_hours;
    }
    public int calcWeeklyLoad()
    {
        return (numExams * STUDY_HOURS) + (numHwk * HOMEWORK_HOURS);
    }
    public String getCOURSE_CODE() { return COURSE_CODE; }
    public void setNumExams(int n) {
        numExams = n;
    }
    public void setNumHwk(int n) {
        numHwk = n;
    }

    public String toString()
    {
        return "Course " + COURSE_CODE + " has " + numHwk + " homework assignments and " + numExams + " exams";
    }
}
