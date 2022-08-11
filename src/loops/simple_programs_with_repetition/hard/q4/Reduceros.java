package loops.simple_programs_with_repetition.hard.q4;

/*
Write a program to display a "single-digit reduction" of a number taken from the user by adding up its digits until
a single-digit number is obtained. Eg. 567 becomes 5 + 6 + 7 = 18 = 1 + 8 => 9). Ensure your output matches the sample.

Sample Output:
Enter a number:
567
567's single number reduction is 9
 */

//Commented out code is an alternate solution. The code that is not commented out is the original and was deemed unlikely
//for the students to get so another solution was written up.

//import java.util.Scanner;
//
//public class Reduceros {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter a number: ");
//        int n = input.nextInt();
//        int nn = n;
//        while (n >= 10) {
//            String s = String.valueOf(n);
//            n = 0;
//            for (int x = 0; x < s.length(); x++) {
//                n += Integer.parseInt(String.valueOf(s.charAt(x)));
//            }
//        }
//        System.out.println(nn + "'s single number reduction is " + n);
//    }
//}


import java.util.Scanner;
public class Reduceros
{
   public static void main( String[] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println( "Enter a number: " );
      int n = input.nextInt();
      int nn = n;
      int result  = 0;
      while( true )
      {
         result += n % 10;
         n = n / 10;
         if( n <= 0 )
         {
            if( result >= 10 )
            {
               n = result;
               result = 0;
               continue;
            }
            break;
         }
      }
      System.out.println( nn + "'s single number reduction is " + result );
   }
}

