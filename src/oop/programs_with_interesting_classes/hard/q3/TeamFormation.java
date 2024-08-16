package oop.programs_with_interesting_classes.hard.q3;

public class TeamFormation {
    public static void main(String[] args)
    {
        Person ann = new Person( "Ann", 4, 4 );
        Person bob = new Person( "Bob", 5, 4 );
        Person cam = new Person( "Cam", 3, 2 );
        Person dan = new Person( "Dan", 1, 5 );
        Person eve = new Person( "Eve", 4, 3 );
        Person fin = new Person( "Fin", 2, 5 );
        Person[] everyone = { ann, bob, cam, dan, eve, fin };
        Team team1 = new Team( 3 );
        Team team2 = new Team( 3 );
        Team[] teamSet = { team1, team2 };
        assignRandomly( everyone, teamSet );
        for( int i=0; i<teamSet.length; i++ )
            System.out.println( "Team " + (i+1) + ":\n" + teamSet[i].toString() +
                    teamSet[i].getAverageSkills() );
    }

    public static void assignRandomly( Person[] people, Team[] teamSet )
    {
        // some code
    }
}
