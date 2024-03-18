package oop.object_interactions.medium.q3;

public class Newspaper {
    private int myYear, myMonth, myDay;
    private String myStory;

    public Newspaper() {
        myYear = -1;
        myMonth = -1;
        myDay = -1;
        myStory = "";
    }

    public Newspaper(int year, int month, int day, String story) {
        myYear = year;
        myMonth = month;
        myDay = day;
        myStory = story;
    }

    public void makeCopy(Newspaper original) {
        myYear = original.getMyYear();
        myMonth = original.getMyMonth();
        myDay = original.getMyDay();
        myStory = original.getMyStory();
    }

    public int getMyYear() {
        return myYear;
    }

    public int getMyMonth() {
        return myMonth;
    }

    public int getMyDay() {
        return myDay;
    }

    public String getMyStory() {
        return myStory;
    }

    public String toString() {
        String str = myYear + "/" + myMonth + "/" + myDay + ":";
        str += "The story is: " + myStory;
        return str;
    }
}

