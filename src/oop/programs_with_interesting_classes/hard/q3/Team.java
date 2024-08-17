package oop.programs_with_interesting_classes.hard.q3;

public class Team {
    private Person[] members;
    private int index;

    public Team(int size) {
        members = new Person[size];
        index = 0;
    }

    public boolean addMember(Person newMember) {
        if (index < members.length) {
            members[index] = newMember;
            index++;
            return true;
        } else
            return false;
    }

    public int getIndex() {
        return index;
    }

    public String getAverageSkills() {
        double avg1 = 0.0;
        double avg2 = 0.0;
        for (int i = 0; i < index; i++) {
            avg1 += members[i].getProgramming();
            avg2 += members[i].getCommunication();
        }
        avg1 = avg1 / index;
        avg2 = avg2 / index;
        String result = "Team's average skill level is:\n";
        result += "\t Programming:   " + avg1 + "\n";
        result += "\t Communication: " + avg2 + "\n";
        return result;
    }

    public String toString() {
        String out = " ";
        for (int i = 0; i < index; i++)
            out += members[i].toString() + " ";
        return out;
    }
}
