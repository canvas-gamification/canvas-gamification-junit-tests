package oop.static_modifier.medium.q3;

public class TestAnimal
{
    public static void main (String[] args)
    {
        Horse h1 = new Horse("Marly");
        Horse h2 = new Horse("Darling");
        Horse.lengthenSound();
        System.out.println(h1 + " " + h2);
        Horse.shortenSound();
        System.out.println(h1 + " " + h2);
    }
}

