package arrays.programs_involving_data_sequences.hard.q9;

/*
Create a Java program to quiz the user on the capitals of the Canadian provinces and territories. To do this, create a
method called quiz, which accepts a String[] jurisdictions and a String [] answers. The program should then ask for each
province and territory on the jurisdictions list what the capital is of that jurisdiction, and lets the user enter a
string to answer the question. Track how many the user gets correct, and print out this value at the end. Refer to the
table below for the capitals of each province and territory. Make sure to pass the jurisdictions in alphabetical order.

    Jurisdiction                    	Capital
    Alberta                         	Edmonton
    British Columbia                	Victoria
    Manitoba                        	Winnipeg
    New Brunswick                  		Fredericton
    Newfoundland and Labrador       	St. John's
    Northwest Territories           	Yellowknife
    Nova Scotia                     	Halifax
    Nunavut                        		Iqaluit
    Ontario                      		Toronto
    Prince Edward Island            	Charlottetown
    Quebec                          	Quebec City
    Saskatchewan                    	Regina
    Yukon                          		Whitehorse

    Sample Output:
        What is the capital of the Canadian jurisdiction of Alberta?
        Edmonton
        What is the capital of the Canadian jurisdiction of British Columbia?
        Victoria
        What is the capital of the Canadian jurisdiction of Manitoba?
        Winnipeg
        ....
        What is the capital of the Canadian jurisdiction of Yukon?
        Whitehorse
        You got 10 questions correct!

 */

import java.util.Scanner;

public class QuizGameEh {
    public static void main(String[] args) {
        String[] jurisdictions = {
                "Alberta",
                "British Columbia",
                "Manitoba",
                "New Brunswick",
                "Newfoundland and Labrador",
                "Northwest Territories",
                "Nova Scotia",
                "Nunavut",
                "Ontario",
                "Prince Edward Island",
                "Quebec",
                "Saskatchewan",
                "Yukon",
        };
        String[] answers = {
                "Edmonton",
                "Victoria",
                "Winnipeg",
                "Fredericton",
                "St. John's",
                "Yellowknife",
                "Halifax",
                "Iqaluit",
                "Toronto",
                "Charlottetown",
                "Quebec City",
                "Regina",
                "Whitehorse"
        };
        quiz(jurisdictions, answers);
    }

    public static void quiz(String[] jurisdictions, String[] answers) {
        String question = "What is the capital of the Canadian jurisdiction of %s?";
        int correct = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < jurisdictions.length; i++) {
            System.out.printf(question + "\n", jurisdictions[i]);
            String answer = input.nextLine().trim();
            correct += answer.equals(answers[i]) ? 1 : 0;
        }
        System.out.printf("You got %d questions correct!", correct);
    }

}
