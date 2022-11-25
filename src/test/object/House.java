package test.object;

public class House {
    public int number;
    String address;

    public House(){
        this.number = 0;
        this.address = "nowhere";
    }

    public House(int number){
        this.number = number;
        this.address = "nowhere";
    }

    public House(String address){
        this.address = address;
        this.number = 0;
    }

    public House(int number, String address){
        this.number = number;
        this.address = address;
    }

    public void printNumber(){
        System.out.println(number);
    }

    public String getAddress(){
        return address;
    }

    public int getNumber(){
        return number;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setNumber(int number){
        this.number = number;
    }
}
