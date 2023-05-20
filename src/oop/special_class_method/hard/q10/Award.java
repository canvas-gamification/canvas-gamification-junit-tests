package oop.special_class_method.hard.q10;

public class Award {
    private String awardRecipient;
    private String awardCategory;

    public Award(String awardRecipient, String awardCategory) {
        this.awardRecipient = awardRecipient;
        this.awardCategory = awardCategory;
    }

    public void setAwardRecipient(String awardRecipient) {
        this.awardRecipient = awardRecipient;
    }

    public String getAwardRecipient() {
        return this.awardRecipient;
    }

    public void setAwardCategory(String awardCategory) {
        this.awardCategory = awardCategory;
    }

    public String getAwardCategory() {
        return this.awardCategory;
    }

    public String toString(){
        return "The award for " + awardCategory + " category goes to " + awardRecipient;
    }
}

