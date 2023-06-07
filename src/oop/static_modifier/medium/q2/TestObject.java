package oop.static_modifier.medium.q2;

public class TestObject
{
    public static void main (String[] args)
    {
        Laptop l1 = new Laptop();
        Laptop l2 = new Laptop();
        System.out.println( "The first laptop id is " + l1.getIdentification() );
        System.out.println( "The second laptop id is " + l2.getIdentification() );
    }
}
