package oop.object_interactions.medium.q6;

public class Airplane {
    private int maxSeats;
    private int numPassengers;

    public Airplane(int seats) {
        maxSeats = seats;
        numPassengers = 0;
    }

    public Airplane(int seats, int people) {
        maxSeats = seats;
        numPassengers = people;
    }

    public void transferPassengers(Airplane busyPlane) {
        int emptySeats = maxSeats - numPassengers;
        if (emptySeats > 0) {
            int numToMove = busyPlane.getNumPassengers() - busyPlane.getMaxSeats();
            if (emptySeats > numToMove) {
                numPassengers += numToMove;
                busyPlane.setNumPassengers(busyPlane.getNumPassengers() - numToMove);
                System.out.println("We moved " + numToMove + " passengers");
            } else {

                numPassengers += emptySeats;
                busyPlane.setNumPassengers(busyPlane.getNumPassengers() - emptySeats);
                System.out.println("We moved " + emptySeats + " passengers");
            }

        } else
            System.out.println("This plane is full too and cannot accommodate anymore passengers");
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int np) {
        numPassengers = np;
    }
    public void setMaxSeats(int np) {
        maxSeats = np;
    }

    public String toString() {
        return numPassengers + " out of " + maxSeats + " seats are filled";
    }
}
