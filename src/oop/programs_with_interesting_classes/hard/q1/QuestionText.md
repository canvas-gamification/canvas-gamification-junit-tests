# oop-programs_with_interesting_classes-hard-q1

# Question Text

Word search puzzles are used in many classrooms to help children build their vocabulary. You are given the test class
below called `BuildVocab` that creates an object of the class called `WordSearch` with a list of 5 words
about sports. The program then displays that newly created puzzle. Your task is to complete the `WordSearch`
class in this question. More details below.

## WordSearch Class

### Attributes

- A two-dimensional `char` array called **grid**. This **grid** holds all the characters for the crossword puzzle.
  It should not be visible from another class.

### Constructor

- The constructor must be visible from another class.
- This constructor must accept an array of strings to use as the words in the crossword puzzle. Assume the words are
  spelled with only uppercase English letters.
- Using the input array, the constructor should find the longest word and use the length to initialize the *
  *grid** array. For example, if the longest word is "Computer" with eight letters, the **grid** array would be
  initialized to a 8x8 square array. You can assume that the number is words in the String array will be less than or
  equal to the grid size (if your grid size should be eight, there will be at most eight words in the array).
- If the array is empty, then initialize the **grid** with size zero.
- Then, sequentially insert the words into the **grid** array horizontally, with the word at index 0 going
  horizontally into the row at index zero, the word at index 1 going into the row at index 1, and so on. Use
  the `insertHorizontally` method described below to do this.
- Once all the words have been inserted, the remaining spaced need to be filled with random letters. Use
  the `randomFill` method described bellow to this.
- For example, if the constructor is called with the
  array `["VOLLEYBALL", "BASKETBALL", "SOCCER", "SWIMMING", "SKIING"]`, the **grid** would be initialized to:

  | Grid | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
                        |-------|---|---|---|---|---|---|---|---|---|---|
  | Row 0 | V | O | L | L | E | Y | B | A | L | L |
  | Row 1 | B | A | S | K | E | T | B | A | L | L |
  | Row 2 | S | O | C | C | E | R | * | * | * | * |
  | Row 3 | S | W | I | M | M | I | N | G | * | * |
  | Row 4 | S | K | I | I | N | G | * | * | * | * |
  | Row 5 | * | * | * | * | * | * | * | * | * | * |
  | Row 6 | * | * | * | * | * | * | * | * | * | * |
  | Row 7 | * | * | * | * | * | * | * | * | * | * |
  | Row 8 | * | * | * | * | * | * | * | * | * | * |
  | Row 9 | * | * | * | * | * | * | * | * | * | * |
  Note in the grid above that `*` represents a random letter which would vary for run to run.

### Methods

#### Insert Horizontally

- A method that returns a boolean and is accessible to other classes called `insertHorizontally`.
- This method must accept a **word** of type `string` and **index** of type `int` as parameters.
- The method places the **word** in the row of the **grid** array matching the input **index**.
- Before placing the **word**, the method should check to see if the **word** is longer than the **row** it is being
  inserted into. It should also check that the **index** passed is not out of bounds for the **grid**. If either of
  these conditions are not satisfied, the **grid** should not be modified and the method returns `false`.
- If the insertion can be completed, after inserting thr word the method must return `true`.
- Assume all the letters in the **word** are uppercase.

#### Random Fill

- A method that returns nothing and is not accessible from other classes called `randomFill`
- This method initializes all indices of the **grid** attribute which do not already have a letter to a random letter.
- Assume that all letters are uppercase English letters.

#### To String

- A `toString` method which prints out the values in the **grid** array. Each row of the array should be printed on a
  separate line and the characters in a row should have spaces in between them (a space at the end of the row is
  optional).
- ```
  Sample output:
  C A T
  H A T
  B A T
  ```
