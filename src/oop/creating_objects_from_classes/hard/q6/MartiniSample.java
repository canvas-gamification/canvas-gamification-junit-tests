package oop.creating_objects_from_classes.hard.q6;

public class MartiniSample {
    private String[] ingredients;
    private double percentAlcohol;
    private boolean mixed;

    public MartiniSample(String[] i, double p){
        ingredients = i;
        percentAlcohol = p;
        mixed = false;
    }

    public void mix(){
        mixed = true;
    }

    public void detectFlavour(){
        String flavour = ingredients[(int)(Math.random()*ingredients.length)];
        System.out.println("I detect " + flavour);
    }
}
