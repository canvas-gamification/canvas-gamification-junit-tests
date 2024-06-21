package oop.static_modifier.hard.q6;

public class TestFeeding {
    public static void main(String[] args) {
        Farm[] a = new Farm[]{
                new Farm(0.5, 10),
                new Farm(0.2, 20),
                new Farm(1, 50)
        };
        for(int x = 0; x < a.length; x++){
            System.out.println("Try to feed animals here... ");
            if(!a[x].feedAnimals()) {
                System.out.println("There is no more food left today.");
                break;
            }

        }
    }
}

