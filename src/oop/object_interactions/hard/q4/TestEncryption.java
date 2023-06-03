package oop.object_interactions.hard.q4;

public class TestEncryption
{
    public static void main (String[] args)
    {
        CryptBox c1 = new CryptBox("Hello there", 3);
        CryptBox c2 = new CryptBox("The car is new", 7);
        System.out.println( "Encrypted message is: " + c1.crossEncrypt(c2) );
    }
}

