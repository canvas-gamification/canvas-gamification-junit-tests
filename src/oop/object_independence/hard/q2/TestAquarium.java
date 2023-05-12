package oop.object_independence.hard.q2;

public class TestAquarium
{
    public static void main( String[] args )
    {
        Fish f1 = new Fish ( "Blue", "Male", 2 );
        Fish f2 = new Fish ( "White", "Female", 4 );
        Fish f3 = new Fish ( "Red", "Female", 3 );
        System.out.println( f1.toString() );
        System.out.println( f2.toString() );
        System.out.println( f3.toString() );
        f1.setAge( f1.getAge()+10 );
        f2.setAge( f2.getAge()+10 );
        f3.setAge( f3.getAge()+10 );
        System.out.println( f1.toString() );
        System.out.println( f2.toString() );
        System.out.println( f3.toString() );
    }
}

