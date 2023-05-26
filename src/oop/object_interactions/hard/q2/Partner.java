package oop.object_interactions.hard.q2;

public class Partner
{
    private String firstName;
    private String lastName;

    public Partner ( String firstName, String lastName, int age )
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void marryMe( Partner otherHalf )
    {
        String newName = lastName + "-" + otherHalf.getLastName();
        otherHalf.setLastName( newName );
        this.lastName = newName;
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public void setFirstName( String ln )
    {
        this.firstName = ln;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public void setLastName( String ln )
    {
        this.lastName = ln;
    }
    public String toString()
    {
        return "My name is: " + firstName + " " + lastName;
    }
}
