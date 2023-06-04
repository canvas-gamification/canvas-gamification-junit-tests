# oop-object_interactions-hard-q5

- Java question

## Question Text

You are considering working in a biotech company where researchers conduct experiments on cloning and mutating animals 
and insects. Write an `Animal` class using the requirements below, and create a `clone` and `mutate` method that alters
the **DNASequence** of the `Animal`.

### Animal Class:

Your `Animal` class must have the following items:

- Attributes:
    - A `String` attribute called **DNASequence**
    - A `String` attribute called **name**
    - Both of these attributes should not be accessible from another class

- Constructor:
    - A constructor visible from another class that accepts two `String` parameters, and initializes the **DNASequence**
      attribute with the first `String` and the **name** attribute with the second `String`
    - This constructor should be visible from other classes

- Methods
    - The following methods should be visible from another class
    - A `getDNASequence` method which returns the **DNASequence** attribute of the `Animal`
    - A `getName` method which returns the **name** attribute of the `Animal`
    - A `toString` method which returns a `String` describing the `Animal` object. It should be of the format `"x has
      DNA y"` where x is the **name** attribute and y is the **DNASequence** attribute of the `Animal`
    - A `clone` method which accepts an `Animal` object as input and changes the **DNASequence** of the object the 
      method is called upon to that of the input object's **DNASequence**
    - A `mutate` method which accepts an `Animal` object as input and change the **DNASequence** of the object the 
      method is called upon to a combination of the original sequence and the input object's sequence. Build the new DNA 
      sequence by interleaving the original sequence first with the input object's sequence following. For example, if 
      the original sequence is "ABCDE" and the input sequence is "VWXYZ", then the combined sequence becomes 
      "AVBWCXDYEZ". On the other hand, if the original sequence is a longer sequence such as "ABCDE" and the input 
      sequence is "XYZ", then the combined sequence becomes "AXBYCZDE". Finally, if the original sequence is a shorter 
      sequence such as "ABC" and the input sequence is "VWXYZ", then the combined sequence becomes "AVBWCXYZ".
    
# TestExperiment Class

Your `TestExperiment` class must have the following items:

- Main Method:
    - The main method should initialize three `Animal` objects
    - The first object should have the **DNASequence** `ACGT ACGT TAGC` and the **name** `Zebra`
    - The second object should have the **DNASequence** `TCGA ACGT AACT` and the **name** `Lion`
    - The third object should have an empty **DNASequence** and the **name** `Zebrion`
    - After initializing all objects, print the `toString` value of the first two objects, starting with the first one
    - Next, using the `clone` method to clone the **DNASequence** of the `Zebra` onto the `Zebrion`
    - Next, use the `mutate` method to interleave the `Lion`'s **DNASequence** with the `Zebrion` 
    - Finally, print the `toString` value of the `Zebrion` object
    - Make sure that each of the messages are printed on their own line
