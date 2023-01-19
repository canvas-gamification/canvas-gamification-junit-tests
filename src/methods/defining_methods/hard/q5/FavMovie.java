package methods.defining_methods.hard.q5;

/*
Write a Java program asking users for their favourite movie and how many times they've watched that movie. Then, write
a Java Method that takes the string and integer as parameters and returns a string. The returned string should be as
follows: if the integer is less than or equal to 0, then return a string saying "You've watched <the movie name> no times!";
if the integer is less than or equal to five and greater than 0, then return a string saying: "You've watched <the movie
name> a few times!"; if the integer is less than or equal to 10 and greater than 5, return a string saying: "You've
watched <the movie name> a lot of times!"; if the integer is greater than 10, then return a string saying: "You've watched
<the movie name> so many times! Wow!". Call your method movieCounter and pass in the movie name and the number of times
you have watched the movie respectively.

Sample Output:
  Enter your favourite movie:
  The Matrix
  How many times have you watched this movie?
  12
  You've watched The Matrix a lot of times! Wow!
 */

import java.util.Scanner;

public class FavMovie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your favourite movie: ");
        String movie = input.nextLine();
        System.out.println("How many times have you watched this movie?");
        int numTimes = input.nextInt();
        System.out.println(movieCounter(movie, numTimes));
    }

    public static String movieCounter(String a, int b) {
        if(b <= 0)
            return "You've watched " + a + " no times!";
        else if (b <= 5)
            return "You've watched " + a + " a few times!";
        else if (b <= 10)
            return "You've watched " + a + " a lot of times!";
        else
            return "You've watched " + a + " so many times! Wow!";
    }
}
