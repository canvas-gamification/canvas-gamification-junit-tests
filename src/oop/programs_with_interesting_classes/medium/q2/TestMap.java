package oop.programs_with_interesting_classes.medium.q2;

import java.util.Scanner;

public class TestMap
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two cities: ");
        String city1 = in.next();
        String city2 = in.next();

        int index1 = convertStringToIndex(city1);
        int index2 = convertStringToIndex(city2);

        int distance = Map.calculateDistance( index1, index2 );
        System.out.println( "The travel distance is: " + distance );
    }

    public static int convertStringToIndex(String name) {
        switch (name) {
            case "Milan":
                return 0;
            case "Venice":
                return 1;
            case "London":
                return 2;
            case "Stockholm":
                return 3;
            case "Berlin":
                return 4;
            default:
                return -1;
        }
    }
}
