package oop.object_interactions.hard.q5;

public class Animal {
    private String DNASequence;
    private String name;

    public Animal(String DNASequence, String name) {
        this.DNASequence = DNASequence;
        this.name = name;
    }

    public String getDNASequence() {
        return this.DNASequence;
    }

    public String getName() {
        return this.name;
    }

    public void clone(Animal a1) {
        this.DNASequence = a1.getDNASequence();
    }

    public void mutate(Animal a1) {
        String genes = a1.getDNASequence();
        String newSpecies = "";
        for (int i = 0; i < this.DNASequence.length(); i++) {
            if (genes.length() > i)
                newSpecies += this.DNASequence.charAt(i) + "" + genes.charAt(i);
            else
                newSpecies += this.DNASequence.charAt(i);
        }
        if (genes.length() > DNASequence.length())
            newSpecies += genes.substring(DNASequence.length());

        DNASequence = newSpecies;
    }

    public String toString() {
        return this.name + " has DNA " + this.DNASequence;
    }
}
