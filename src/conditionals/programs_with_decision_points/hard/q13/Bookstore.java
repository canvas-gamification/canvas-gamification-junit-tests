package conditionals.programs_with_decision_points.hard.q13;

// A store sells books based on color and book genre.
// The user selects a color:
// (1 for Pink)
// (2 for Blue)
// (3 for Green)

// Then, the user selects a book genre:
// (1 for Fiction)
// (2 for Non-Fiction)
// (3 for Mystery)

// Write a program using nested switches to print the selected book.
// If the user enters an invalid answer, print "Invalid selection."

import java.util.Scanner;

public class Bookstore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select book color: (1 - Pink, 2 - Blue, 3 - Green)");
        int color = input.nextInt();

        System.out.println("Select book genre: (1 - Fiction, 2 - Non-Fiction, 3 - Mystery)");
        int genre = input.nextInt();

        switch (color) {
            case 1:
                switch (genre) {
                    case 1: System.out.println("You selected a Pink Fiction book."); break;
                    case 2: System.out.println("You selected a Pink Non-Fiction book."); break;
                    case 3: System.out.println("You selected a Pink Mystery book."); break;
                    default: System.out.println("Invalid selection."); break;
                }
                break;
            case 2:
                switch (genre) {
                    case 1: System.out.println("You selected a Blue Fiction book."); break;
                    case 2: System.out.println("You selected a Blue Non-Fiction book."); break;
                    case 3: System.out.println("You selected a Blue Mystery book."); break;
                    default: System.out.println("Invalid selection."); break;
                }
                break;
            case 3:
                switch (genre) {
                    case 1: System.out.println("You selected a Green Fiction book."); break;
                    case 2: System.out.println("You selected a Green Non-Fiction book."); break;
                    case 3: System.out.println("You selected a Green Mystery book."); break;
                    default: System.out.println("Invalid selection."); break;
                }
                break;
            default:
                System.out.println("Invalid selection.");
        }

        input.close();
    }
}
    
