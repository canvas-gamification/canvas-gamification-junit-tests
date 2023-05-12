package oop.object_independence.hard.q3;

public class Tree
{

    private boolean isRare;
    private double height;
    public Tree( boolean rarity, double hght )
    {
        isRare = rarity;
        height = hght;
    }
    public boolean getIsRare(){ return isRare; }
    public double getHeight(){ return height; }
    public void setIsRare( boolean a ){ isRare = a; }
    public void setHeight( double gen ){ height = gen; }
    public void deforestation()
    {
        height = 0;
    }
    public String toString()
    {
        return "This tree’s rarity is " + isRare+ ", and is " + height+ "m tall";
    }
}
