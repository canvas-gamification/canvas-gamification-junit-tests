package oop.programs_with_interesting_classes.medium.q1;

public class Collision {
    public static void main(String[] args) {
        Car vehicle1 = new Car("Volkswagen Golf", 60);
        Car vehicle2 = new Car("Mini Cooper", 65.5);
        System.out.println(vehicle1);
        System.out.println(vehicle2);
        collide(vehicle1, vehicle2);
        System.out.println(vehicle1);
        System.out.println(vehicle2);
    }

    public static void collide(Car v1, Car v2) {
        String[] partsCopy;
        if (v1.getSpeed() > v2.getSpeed())
            partsCopy = v2.getParts();
        else
            partsCopy = v1.getParts();

        String[] newParts = new String[partsCopy.length - 2];
        for (int i = 0; i < newParts.length; i++)
            newParts[i] = partsCopy[i];

        if (v1.getSpeed() > v2.getSpeed())
            v2.setParts(newParts);
        else
            v1.setParts(newParts);
    }
}
