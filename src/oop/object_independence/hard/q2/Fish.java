package oop.object_independence.hard.q2;

public class Fish
{
    private String colour;
    private String gender;
    private int age;
    public Fish( String col, String gen, int a )
    {
        colour = col;
        gender = gen;
        age = a;
    }
    public int getAge(){ return age; }
    public String getColour(){ return colour; }
    public String getGender(){ return gender; }
    public void setAge( int a ){ age = a; }
    public void setGender( String gen ){ gender = gen; }
    public void setColour( String col ){ colour = col; }
    public String toString()
    {
        return "This fish is " + colour + ", and is a " + gender + ", and is "+ age+ " years old";
    }
}

