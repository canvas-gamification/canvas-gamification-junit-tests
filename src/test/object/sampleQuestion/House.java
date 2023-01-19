package test.object.sampleQuestion;

public class House {
    private Person[] residents;
    private int number;
    private String address;

    public House() {
        this.number = 0;
        this.address = "nowhere";
        this.residents = new Person[]{};
    }

    public House(int number, String address) {
        this.number = number;
        this.address = address;
        this.residents = new Person[]{};
    }

    public House(int number, String address, Person[] residents) {
        this.residents = residents;
        this.number = number;
        this.address = address;
    }

    public Person[] getResidents() {
        return residents;
    }

    public void setResidents(Person[] residents) {
        this.residents = residents;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String houseMessage() {
        return "This is a house";
    }
}
