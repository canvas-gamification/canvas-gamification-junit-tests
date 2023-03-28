package oop.creating_objects_from_classes.hard.q5;

public class SportsRoom {
    public Basketball[] makeBalls(double[] sizes) {
        Basketball[] balls = new Basketball[sizes.length];
        for (int i = 0; i < sizes.length; i++)
            balls[i] = new Basketball(sizes[i]);
        return balls;
    }
}
