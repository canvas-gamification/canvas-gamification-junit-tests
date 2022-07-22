package pre_defined_classes.simple_programs_taking_string_user_input.medium.q7;

/*
A website address typically begins with www. and ends in .ca, .com, .edu,
among others. Originally, the ending of the address signifies the type of website it is.
For example, the ending .ca is used to designate Canadian websites (although Canadian websites do not have
to use this ending at all). Make a program that answers true or false to the question of whether
the inputted address is a Canadian website. Assume the user will enter a valid URL.

Sample output:
    Please enter a website URL:
    https://www.canada.ca
    Is this a Canadian website? true

Sample output:
    Please enter a website URL:
    https://www.gouvernement.fr
    Is this a Canadian website? false
*/

import java.util.Scanner;

public class UrlValidator {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Please enter a website URL:" );
        String url = input.nextLine();
        System.out.println( "Is this a Canadian website? " +  url.endsWith( ".ca" ) );
    }

}
