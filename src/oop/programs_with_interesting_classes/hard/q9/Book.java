package oop.programs_with_interesting_classes.hard.q9;

public class Book {
    private Borrower[] borrowers;
    private int usedSpaces;
    private String title;
    public Book( String t )
    {
        title = t;
        borrowers = new Borrower[ 10 ];
        usedSpaces = 0;
    }
    private void expand()
    {
        Borrower[] expanded = new Borrower[ borrowers.length * 2 ];
        for(int i = 0; i < borrowers.length; i++ )
            expanded[i] = borrowers[i];
        borrowers = expanded;
    }
    public void signOut( Borrower newBorrower )
    {
        if( usedSpaces >= borrowers.length )
            expand();
        borrowers[usedSpaces] = newBorrower;
        usedSpaces++;
    }
    public String toString()
    {
        String result = "Title: " + title + "\n";
        for(int i = 0; i < usedSpaces; i++)
            result += borrowers[i].toString() + "\n";
        return result;
    }
}
