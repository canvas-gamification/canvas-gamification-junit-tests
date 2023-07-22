package oop.static_modifier.hard.q1;

public class Fence {
    private static String[] colours = {"Red", "Blue", "Green", "Yellow", "Black", "White", "Purple", "Brown"};
    private static double[] leftoverAmount = {100.00, 100.00, 100.00, 100.00, 100.00, 100.00, 100.00, 100.00};
    private String colour;

    public Fence(String c) {
        colour = "Blue";
        for (int i = 0; i < colours.length; i++) {
            if (c.equals(colours[i]))
                this.colour = c;
        }
    }

    public void paintColour(String colourName, double neededVolume) {
        int i;
        for (i = 0; i < colours.length; i++) {
            if (colourName.equals(colours[i])) {
                if (leftoverAmount[i] >= neededVolume) {
                    leftoverAmount[i] -= neededVolume;
                    this.colour = colourName;
                } else {
                    System.out.println("There is not enough " + colours[i] + " paint for this job");
                }
                break;
            }
        }
        System.out.println("The input colour does not match any of the paint colours.");
    }

    public String toString() {
        return "My paint colour is " + this.colour + ".";
    }

}
