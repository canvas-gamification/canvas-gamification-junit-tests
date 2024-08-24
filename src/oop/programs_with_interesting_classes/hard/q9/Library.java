package oop.programs_with_interesting_classes.hard.q9;

public class Library {
    public static void main( String[] args )
    {
        Book captainUnderpants = new Book( "The Adventures of Captain Underpants" );
        Borrower b1 = new Borrower( "Bob", "Feb 12" );
        captainUnderpants.signOut( b1 );
        Borrower b2 = new Borrower( "Billy", "Apr 24" );
        captainUnderpants.signOut( b2 );
        Borrower b3 = new Borrower( "Fred", "Jun 03" );
        captainUnderpants.signOut( b3 );
        System.out.println(captainUnderpants);
    }
}
