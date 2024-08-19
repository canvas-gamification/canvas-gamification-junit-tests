package oop.programs_with_interesting_classes.hard.q5;

public class JobAd
{
    private String title;
    private int salary;
    private String[] skills;
    private int numSkills;
    public JobAd( String name, int amount )
    {
        title = name;
        salary = amount;
        skills = new String[ 2 ];
        numSkills = 0;
    }
    public void addSkill( String sk )
    {
        if( numSkills >= skills.length )
        {
            String[] newArray = new String[ skills.length*2 ];
            for(int i=0; i<skills.length; i++ )
                newArray[i] = skills[i];
            skills = newArray;
        }
        skills[numSkills] = sk;
        numSkills++;
    }
    public int getSalary() { return salary; }
    public String getTitle()  { return title; }
    public String[] getSkills() { return skills; }
    public String toString()
    {
        String str = "";
        str += "Title:  " + title  + "\n";
        str += "Salary: " + salary + "\n";
        str += "Skills: ";
        for(int i = 0; i< numSkills; i++ )
            if( i == (numSkills -1) )
                str += skills[i];
            else
                str += skills[i] + ", ";

        str += "\n";
        return str;
    }
}
