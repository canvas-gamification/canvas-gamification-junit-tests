package oop.programs_with_multiple_classes.medium.q1;

public class Table {
    private String woodType;
    private int numSeats;

    public Table(String wt, int ns) {
        woodType = wt;
        numSeats = ns;
    }

    public void woodType() {
        System.out.println("This table is made out of " + woodType);
    }
}
