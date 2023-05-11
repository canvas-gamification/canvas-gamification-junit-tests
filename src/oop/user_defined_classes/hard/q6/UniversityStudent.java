package oop.user_defined_classes.hard.q6;

public class UniversityStudent
{
    private int fatigueLevel;
    private int workload;
    public UniversityStudent( int level, int work )
    {
        fatigueLevel = level;
        workload = work;
    }
    public void workAllDay()
    {
        while( workload > 0 )
        {
            fatigueLevel++;
            workload--;
        }
        System.out.println( "Fatigue level is " + fatigueLevel );
    }
}
