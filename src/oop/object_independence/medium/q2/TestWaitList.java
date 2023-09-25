package oop.object_independence.medium.q2;

public class TestWaitList {
    public static void main(String[] args) {
        PhoneWaitList wlA = new PhoneWaitList(5);
        PhoneWaitList wlB = new PhoneWaitList(3);
        wlB.setNumAhead(2);
        System.out.println(wlA.toString());
        System.out.println(wlB.toString());
    }
}

