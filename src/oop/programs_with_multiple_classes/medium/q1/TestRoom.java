package oop.programs_with_multiple_classes.medium.q1;

public class TestRoom {
    public static void main(String[] args) {
        Chair ch1 = new Chair("couchy", 350, 5);
        Chair ch2 = new Chair("back support", 250, 10);
        Table tbl = new Table("cherry", 8);
        System.out.print("Chair 1: ");
        System.out.println(ch1.toString());
        System.out.print("Chair 2: ");
        System.out.println(ch2.toString());
        System.out.print("Table: ");
        System.out.println(tbl.toString());
    }
}
