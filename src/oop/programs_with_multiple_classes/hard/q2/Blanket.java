package oop.programs_with_multiple_classes.hard.q2;

public class Blanket {
    private String size;
    private int threadCount;

    public Blanket(String size, int threadCount) {
        this.size = size;
        this.threadCount = threadCount;
    }

    public String toString() {
        return "Blanket{" +
                "size='" + size + '\'' +
                ", threadCount=" + threadCount +
                '}';
    }
}
