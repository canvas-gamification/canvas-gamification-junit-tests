# oop-programs_with_interesting_classes-medium-q9

- Parsons Question

## Question Text

People who give ratings tend to have diverse reactions to them because they want to express their individual preferences.
Using the requirements below, create a `Review` and `CollMovieision` class to model movie reviews and a `TestExpertReview`
class to test them.

### Review Class

Your `Review` class must have the following requirements:

- Attributes:
    - a `String` attribute called **user**
    - an `int` attribute called **rating**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `String` and an `int` in that order to initialize the **user** and **rating**
      attributes.
    - It should check that the `int` value is within the acceptable range of 1-5. If it not, set **rating** to `-1`.
    - This constructor should be accessible from another class.

- Methods:
    - A `getUser` method which returns the **user** attribute.
    - A `getRating` method which returns the value of the **rating** attribute.
    - A `toString` method that returns a String of the form "x rates this y stars." where x is the value of the **user** 
      attribute and y is the value of the **rating** attribute.

### Movie Class

Your `Movie` class must have the following requirements:

- Attributes:
    - a `String` attribute called **name**
    - an `Review[]` attribute called **reviews**
    - all of these attributes must not be accessible from another class

- Constructor:
    - The constructor should accept a `String` to initialize the **name** attribute and initialize the **reviews** attribute
      to an array of size 0.
    - This constructor should be accessible from another class.

- Methods:
    - All the following methods should be visible from another class, and if there is no return type specified, assume
      it should return nothing.
    - A `setReviews` method which accepts a `Review[]` and updates the **reviews** attribute to that array.
    - An `addReview` method which accepts a `Review` and copies the existing reviews to a new array, adding the passed
      object to the end of the new array and updating the **reviews** attribute to the new array.
    - A `calcAvgRating` method which returns a `double` representing the average of the **rating** values in the 
      **reviews** attribute.
    - A `getHighestRating` method which returns the highest **rating** present in the **reviews** array.

### TestExpertReview Class

Your `TestExpertReview` Class must have the following methods:

- Main method:
    - A `main` method to run the class from.
    - It must initialize a new `Movie` object called `"The Revenge of the Sharks 2"`.
    - Then, initialize 5 Review objects, add them to an array, and add that array to the `Movie` using the `setReviews` 
      method.
    - Finally, print the result of the `calcAvgRating` method and then the result of the `getHighestRating` method on
      separate lines.
