package oop.user_defined_classes.hard.q7;

public class Course
{
    private String topic;
    private int difficulty;
    public Course(String t, int d)
    {
        topic = t;
        difficulty = d;
    }

    public void determineDifficulty(int difficult){
        if(difficulty >= difficult){
            System.out.println(topic + " is a difficult course");
        }
        else {
            System.out.println(topic + " is not a difficult course");
        }
    }
}

