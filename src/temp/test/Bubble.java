package temp.test;

public class Bubble {
    private int radius;
    private int x;
    private int y;

    public Bubble(int radius) {
        this.radius = radius;
        this.x = 0;
        this.y = 0;
    }

    public Bubble(int x, int y) {
        this.radius = 1;
        this.x = x;
        this.y = y;
    }

    public Bubble(int radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
