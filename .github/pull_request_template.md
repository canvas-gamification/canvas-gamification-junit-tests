## PR Checklist
- [ ]  Are helper methods really needed here?
    > Opt for hardcoding input/output into the input provider when possible
- [ ]  Are the assertion fail messages good?
    - [ ]  Logical (does it make sense?)
    - [ ]  Readable (can a student understand what’s wrong?)
    - [ ]  Not too feed-y (does it give away the answer?)
    - [ ]  Grammatically sound (is the grammar and punctuation in the sentence proper?)
    - [ ]  Specific (does the fail message relate to the question?)
- [ ]  Is the code formatted well?
    > Run `CTRL` + `ALT` + `L` in IntelliJ
- [ ]  EOF newlines
- [ ]  Do the comments for Parsons follow the correct convention?
- [ ]  Is the question being tested sufficiently?
    - [ ]  Are there representative cases to test the program?
    - [ ]  What about edge cases? (empty strings, negatives, infinity, etc)
        > If the question doesn’t specify what to do, mark it as a bad question
---

## Not yet, but soon

- [ ]  Are the test method names good?
    > Test method names show up in a “What went well” section on the website, so “mathTest” will become “What went well: math test”, which doesn’t make much sense. A better name in this example would be “calculatesTaxCorrectly” so it shows up as “What went well: calculates tax correctly”
