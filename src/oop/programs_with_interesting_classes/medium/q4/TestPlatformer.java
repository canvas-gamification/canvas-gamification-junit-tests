package oop.programs_with_interesting_classes.medium.q4;

public class TestPlatformer {
    public static void main( String[] args )
    {
        Mario m1 = new Mario();
        System.out.println( m1.toString() );
        m1.eatPowerUp();
        System.out.println( m1.toString() );
        m1.takeDamage();
        m1.takeDamage();
        System.out.println( m1.toString() );
    }

}
