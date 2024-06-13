package oop.object_interactions.medium.q2;

public class Person {
    private String myName;
    private String mySecret;
    private String[] friendNames;
    private String[] friendSecrets;

    public Person(String name, String secret, String[] list) {
        myName = name;
        mySecret = secret;
        friendNames = list;
        friendSecrets = new String[friendNames.length];
    }

    public String getName() {
        return myName;
    }

    public String getSecret() {
        return mySecret;
    }

    public void hearSecret(String friend, String secret) {
        int friendIndex = friendSecrets.length;
        for (int i = 0; i < friendNames.length; i++)
            if (friendNames[i].equals(friend)) {
                friendIndex = i;
                break;
            }
        if (friendIndex < friendNames.length)
            friendSecrets[friendIndex] = secret;
    }

    public void writeInDiary() {
        System.out.println("I have the following secrets:");
        for (int i = 0; i < friendNames.length; i++) {
            if (friendSecrets[i] != null)
                System.out.println(friendNames[i] + " told me " + friendSecrets[i] + ".");
        }
    }
}

