package oop.object_interactions.medium.q2;

public class TestFriendship {
    public static void main(String[] args) {
        Person ann = new Person("Ann", "she hates chocolates", new String[]{"Bob", "Cam"});
        Person cam = new Person("Cam", "she is scared of heights", new String[]{"Ann"});
        cam.hearSecret("Ann", "she is scared of heights");
        cam.writeInDiary();
    }
}
