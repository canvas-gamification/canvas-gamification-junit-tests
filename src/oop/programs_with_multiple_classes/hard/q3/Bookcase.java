package oop.programs_with_multiple_classes.hard.q3;

public class Bookcase {
    private int sizeCapacity;
    private Book[] shelf;

    public Bookcase(int sizeCapacity) {
        if (validate(sizeCapacity)) {
            this.sizeCapacity = sizeCapacity;
        } else {
            this.sizeCapacity = 0;
        }
        shelf = new Book[this.sizeCapacity];
    }

    public boolean validate(int sizeCapacity){
        if (sizeCapacity >= 0){
            return true;
        }
        else {
            System.out.println("Error! Size capacity cannot be negative.");
            return false;
        }
    }

    public void addBook(Book b){
        boolean placed = false;
        for(int x = 0; x < sizeCapacity; x ++){
            if(shelf[x] == null){
                shelf[x] = b;
                placed = true;
                break;
            }
        }
        if(!placed){
            System.out.println("The Bookshelf is full.");
        }
    }

    public void removeBook(int i){
        if(shelf[i] != null){
            shelf[i] = null;
        }
        else {
            System.out.println("There is nothing here.");
        }
    }
}
