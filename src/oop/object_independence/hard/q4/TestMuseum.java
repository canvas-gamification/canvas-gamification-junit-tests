package oop.object_independence.hard.q4;

public class TestMuseum {
    public static void main(String[] args) {
        Painting p1 = new Painting("The Starry Night", "good");
        Painting p2 = new Painting("The Scream", "poor");
        Painting[] inventory = {p1, p2};
        for (int i = 0; i < inventory.length; i++)
            System.out.println(inventory[i].toString());
        System.out.println("Some time passed...");
        p1.setQuality("fair");
        for (int i = 0; i < inventory.length; i++) {
            Painting item = inventory[i];
            System.out.println(item.toString());
            if (item.getQuality().equals("poor"))
                System.out.println("This needs cleaning.");
        }
    }
}

