package oop.special_class_method.medium.q5;

public class Calculator {
    private double sum;
    private boolean isCorrect;

    public Calculator(double s, boolean ic) {
        sum = s * 7;
        isCorrect = ic;
    }

    public void setSum(double s) {
        sum = s;
    }

    public double getSum() {
        return sum;
    }

    public void setIsCorrect(boolean ic) {
        isCorrect = ic;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }
}
