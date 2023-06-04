package oop.object_interactions.hard.q5;

public class TestExperiment
{
    public static void main (String[] args)
    {
        Animal a1 = new Animal( "ACGT ACGT TAGC", "Zebra" );
        Animal a2 = new Animal( "TCGA ACGT AACT", "Lion" );
        Animal a3 = new Animal( "", "Zebrion" );
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        a3.clone(a1);
        a3.mutate(a2);
        System.out.println(a3.toString());
    }
}
