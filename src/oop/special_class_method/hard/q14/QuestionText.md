# oop-special_class_method-hard-q14

## Question Text

As part of a larger virtual reality program, you want to build more life-like objects. Make a Java class called 
**Bottle** that has an attribute called **isFull** which is initialized to **false** in the constructor.

### Bottle Class:

Your `Bottle` class must have the following items:

- Attributes:
    - A `boolean` called **isFull**
    - This is not visible from other classes

- Constructor:
    - A `Bottle` constructor that initialize the **isFull** attribute to false.

- Methods:
    - A `setIsFull` method which accepts a `boolean` and uses it to set the value of the **isFull** attribute
    - A `getIsFull` method which returns the value stored in the **isFull** attribute
    - These methods must be visible from other classes.
    - A `toString` method which returns `I am full` if the **isFull** value is true and `I am empty` otherwise.

### Distractors

    public Bottle()
    isFull = true;
    isFull = FALSE;
    isFull = TRUE;
    {
    }
    private Bottle
    private String toString( String str )
    public boolean isFull;
    isFull = full;
    String str = "";
    Bottle b1 = new Bottle( false );
    Bottle b1 = new Bottle( "true" );
    b1.setIsFull();
    b1.toString();
    System.out.println( toString() );
    System.out.println( b1.toString );
    b1.getIsFull( true );
