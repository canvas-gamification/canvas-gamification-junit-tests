package test.object.sampleQuestion;

public class Person {
    private String name;
    private int age;
    private boolean employed;

    public Person() {
        name = "Bob";
        age = 21;
        employed = false;
    }

    public Person(String name) {
        this.name = name;
        this.age = 21;
        this.employed = false;
    }

    public Person(int age) {
        this.name = "Bob";
        this.age = age;
        this.employed = false;
    }

    public Person(boolean employed) {
        this.employed = false;
        this.age = 21;
        this.name = "Bob";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.employed = false;
    }

    public Person(String name, boolean employed) {
        this.name = name;
        this.employed = employed;
        this.age = 21;
    }

    public Person(int age, boolean employed) {
        this.employed = employed;
        this.age = age;
        this.name = "Bob";
    }

    public Person(String name, int age, boolean employed) {
        this.name = name;
        this.age = age;
        this.employed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }
}
