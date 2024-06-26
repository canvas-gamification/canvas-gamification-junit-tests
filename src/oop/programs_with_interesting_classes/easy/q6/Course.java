package oop.programs_with_interesting_classes.easy.q6;

public class Course {
    private double textbookFee;
    private double suppliesFee;
    private double labFee;

    public Course(double fee1, double fee2, double fee3) {
        textbookFee = fee1;
        suppliesFee = fee2;
        labFee = fee3;
    }

    public double calcTotalCost() {
        return textbookFee + suppliesFee + labFee;
    }
}
