package oop.object_interactions.medium.q5;

public class Person {
    private String myName;
    private int numEyes;

    public Person(String name, int eyes) {
        myName = name;
        numEyes = eyes;
    }

    public void receiveDonation(Person donor) {
        int available = donor.getNumEyes();
        if (available > 0) {
            donor.setNumEyes(available - 1);
            numEyes++;
            System.out.println("Transplant successful");
        }
        else{
            System.out.println("Transplant cannot be done");
        }
    }

    public String getMyName() {
        return myName;
    }

    public int getNumEyes() {
        return numEyes;
    }

    public void setMyName(String n) {
        myName = n;
    }

    public void setNumEyes(int e) {
        numEyes = e;
    }

    public String toString() {
        return myName + " has " + numEyes + " eyes";
    }
}

