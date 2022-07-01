package pre_defined_classes.simple_programs_taking_string_user_input.medium.q7;

/*
A website address typically begins with <tt>www.</tt> and ends in <tt>.ca</tt>, <tt>.com</tt>, <tt>.edu</tt>,
among others. Originally, the ending of the address signifies the type of website it is.
For example, the ending <tt>.ca</tt> is used to designate Canadian websites (although Canadian websites do not have
to use this ending at all). Make a program that answers <tt>true</tt> or <tt>false</tt> to the question of whether
the inputted address is a Canadian website.

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
