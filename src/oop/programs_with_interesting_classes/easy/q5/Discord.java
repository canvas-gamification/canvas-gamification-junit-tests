package oop.programs_with_interesting_classes.easy.q5;

public class Discord {
    private String content;
    private String user;

    public Discord(String c, String u) {
        content = c;
        user = u;
    }

    public void deleteMessage() {
        content = "";
    }

    public void setContent(String s) {
        content = s;
    }

    public void setUser(String s) {
        user = s;
    }

    public String getContent() {
        return content;
    }

    public String getUser() {
        return user;
    }

    public String toString() {
        return content + " From: " + user;
    }
}
