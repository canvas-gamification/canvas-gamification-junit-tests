package pre_defined_classes.simple_programs_taking_string_user_input.hard.q6;

/*
Emailing is the most popular asynchronous communication tool in the 20th century so far. Suppose all UBC emails must
end with @ubc.ca. Make a program that takes in a user's email address and answers true or false depending on whether
it is a UBC address.

Sample output:
Please enter your email:
example@ubc.ca
Is this a UBC email? true

Please enter your email:
example2@gmail.com
Is this a UBC email? false

Distractors:
String email = input.nextInput();
String email, suffix;
System.out.println( email + " is a valid Canadian email address." );
System.out.println( "Is this a Canadian Email Address? " + email.endsWith( suffix ) );

 */

import java.util.Scanner;

public class CanValidator {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Please enter your email:" );
        String email = input.nextLine();
        boolean suffix = email.endsWith( "@ubc.ca" );
        System.out.println( "Is this a UBC email? " + suffix );
    }

}
