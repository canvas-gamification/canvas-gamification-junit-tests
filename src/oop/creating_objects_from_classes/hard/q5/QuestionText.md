# oop-creating_objects_from_classes-hard-q5

Basketball: Volleyball, Racketball, SoccerBall, TennisBall, Football, Baseball, GolfBall, BeachBall, PoolBall,
BowlingBall, SquashBall, PaddleBall, CriketBall, Dodgeball

## Java questions

## Question Text

Suppose you have defined a `Basketball` class to model your basketballs, and now you want to test it to make sure that 
it works. Given the basketball class below, create a test class called `SportsRoom` with a main method, and initialize 
a `Basketball` object with the following attributes:
- Size: 28.5
- Condition: poor

Then, call the `inflate` method on the created Basketball object, and the `orderMore` method to create 5 more 
basketballs and store them in an array. Then call the `playGame` method on the first Basketball in the array. The 
result from doing this should be the printing of the `String` "Cheers!".

Note: You do not need to place the Basketball class in your submission code, the website will handle this for you. It 
is just for you to reference.

### Basketball Class:

```java
public class Basketball {
  double size;
  String condition;

  public Basketball(double s, String c) {
    size = s;
    condition = c;
  }

  public void inflate(){
    condition = "great";
  }

  public void playGame(){
    System.out.println("Cheers!");
  }

  public Basketball[] orderMore(int amount){
    Basketball[] newBalls = new Basketball[amount];
    for(int x = 0; x < amount; x++){
      newBalls[x] = new Basketball(this.size, "new");
    }
    return newBalls;
  }
}
```
