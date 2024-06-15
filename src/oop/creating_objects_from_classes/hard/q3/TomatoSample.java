package oop.creating_objects_from_classes.hard.q3;

public class TomatoSample {
    private String type;
    private String nickname;

    public TomatoSample() {
    }

    public TomatoSample(String t) {
        type = t;
    }

    public TomatoSample(String t, String n) {
        type = t;
        nickname = n;
    }

    public TomatoSample produceSeed(String n) {
        return new TomatoSample(this.type, n);
    }
}
