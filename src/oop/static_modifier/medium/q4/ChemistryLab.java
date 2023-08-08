package oop.static_modifier.medium.q4;

public class ChemistryLab {
    private static double liquid1 = 10.5;
    private static double liquid2 = 10.5;
    private final static int MIX_1 = 0;
    private final static int MIX_2 = 1;
    private double[] guide;

    public ChemistryLab(double[] mix) {
        guide = mix;
    }

    public void mixFun() {
        if (guide[MIX_1] <= liquid1 && guide[MIX_2] <= liquid2) {
            System.out.println("Mixing … ");
            liquid1 = liquid1 - guide[MIX_1];
            liquid2 = liquid2 - guide[MIX_2];
            System.out.println("Mixing Successful");
        } else {
            System.out.println("There's not enough ingredients to create the mixture");
        }
    }

}
