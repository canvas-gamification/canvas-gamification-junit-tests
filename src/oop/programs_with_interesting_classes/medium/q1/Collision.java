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
        if (v1.getSpeed() > v2.getSpeed()) {
            String[] oldParts = v2.getParts();
            String[] newParts = new String[oldParts.length - 2];
            copyParts(newParts, oldParts);
            v2.setParts(newParts);
        } else if (v2.getSpeed() > v1.getSpeed()) {
            String[] oldParts = v1.getParts();
            String[] newParts = new String[oldParts.length - 2];
            copyParts(newParts, oldParts);
            v1.setParts(newParts);
        } else {
            String[] oldParts1 = v1.getParts();
            String[] newParts1 = new String[oldParts1.length - 2];
            copyParts(newParts1, oldParts1);
            v1.setParts(newParts1);
            String[] oldParts2 = v2.getParts();
            String[] newParts2 = new String[oldParts2.length - 2];
            copyParts(newParts2, oldParts2);
            v2.setParts(newParts2);
        }
    }

    public static void copyParts(String[] newParts, String[] oldParts) {
        for (int i = 0; i < newParts.length; i++)
            newParts[i] = oldParts[i];
    }
}
