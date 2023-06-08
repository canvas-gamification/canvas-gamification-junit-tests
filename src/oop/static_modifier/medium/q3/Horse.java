package oop.static_modifier.medium.q3;


/*
private static void lengthenSound()
private static void shortenSound()
public void lengthenSound()
public void shortenSound()
{
}
public String noise = "Neigh!";
public static String noise = "Neigh!";
 */

public class Horse
{
    private static String noise = "Neigh!";
    private String name;

    public Horse(String n )
    {
        name = n;
    }
    public static void lengthenSound()
    {
        String newNoise = "";
        boolean firstVowel = true;
        for(int i = 0; i < noise.length(); i++)
        {
            char c = noise.charAt(i);
            if(( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) && firstVowel)
            {
                for(int j = 0; j < 5; j++)
                    newNoise += c;
                firstVowel = false;
            }
            else
                newNoise += c;
        }
        noise = newNoise;
    }
    public static void shortenSound()
    {
        String newNoise = "";
        boolean firstVowel = true;
        for(int i = 0; i < noise.length(); i++)
        {
            char c = noise.charAt(i);
            if(( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) && firstVowel) {
                if (noise.contains(c + "" + c + "" + c + "" + c + "" + c)) {
                    i += 4;
                }
                firstVowel = false;
                newNoise += c;
            }
            else
                newNoise += c;
        }
        noise = newNoise;
    }
    public String toString() { return name + " calls out " + noise; }
}
