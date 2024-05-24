package oop.creating_objects_from_classes.hard.q5;

public class BasketballSample {
    double size;
    String condition;

    public BasketballSample(double s, String c) {
        size = s;
        condition = c;
    }

    public void inflate(){
        condition = "great";
    }

    public void playGame(){
        System.out.println("Cheers!");
    }

    public BasketballSample[] orderMore(int amount){
        BasketballSample[] newBalls = new BasketballSample[amount];
        for(int x = 0; x < amount; x++){
            newBalls[x] = new BasketballSample(this.size, "new");
        }
        return newBalls;
    }
}
