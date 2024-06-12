package oop.object_interactions.medium.q4;

public class TestTransfusion {
    public static void main( String[] args )
    {
        Snail sarah = new Snail( 'A', 10.5 );
        Snail jones = new Snail( 'B', 8 );
        Snail cindy = new Snail( 'B', 0.5 );
        cindy.transfusionFrom( sarah );
        cindy.transfusionFrom( jones );
        System.out.println( "Sarah: " + sarah.toString() );
        System.out.println( "Jones: " + jones.toString() );
        System.out.println( "Cindy: " + cindy.toString() );
    }
}

