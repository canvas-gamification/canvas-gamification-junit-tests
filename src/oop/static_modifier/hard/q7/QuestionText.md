# oop-static_modifier-hard-q7

- Question Type: Java question

## Question Text

Taxes such as GST and PST vary by province in Canada. Write a Java class called `Taxes` to keep track of the relevant 
taxes when travelling between provinces using the requirements below. Then write a class called `RoadTrip` to test
`Taxes`.

## Taxes Class

Your `Taxes` class must have the following requirements:

- Attributes:
    - A _static_ `int` called **GST**. This represents the Goods and Services Tax of the current province, and should
      be initially set to 5, which is British Columbia's GST.
    - A _static_ `double` called **PST**. This represents the Provincial Sales Tax of the current province, and should be
    - initially set to 7, which is British Columbia's PST.
    - Neither of these attributes should be visible from other classes.

- Methods:
    - Note that both methods should be _static_ and visible from other classes.
    - A `calculateTotal` method that has a `double` parameter which is the cost of an item. The method should add **GST**
      and **PST** and use the combined percentage to calculate and return the final cost of the purchase.
    - A `changeLocation` method that has a `String` parameter which will be the name of one of Canada's provinces. It
      should change the values of **GST** and **PST** to match accordingly with the table below. The method should not
      return anything. 

| Province                  | GST   | PST    |
|---------------------------|-------|--------|
| Alberta                   | 	5%   | 	0%    |
| British Columbia          | 	5%	  | 7%     |
| Manitoba                  | 	5%   | 	7%    |
| New Brunswick             | 	15%  | 0%     |
| Newfoundland and Labrador | 	15%	 | 0%     |
| Northwest Territories     | 	5%   | 	0%    |
| Nova Scotia               | 	15%  | 0%     |
| Nunavut                   | 	5%   | 	0%    |
| Ontario                   | 	13%  | 	0%    |
| Quebec	                   | 5%	   | 9.975% |
| Prince Edward Island	     | 15%	  | 0%     |
| Saskatchewan              | 	5%	  | 6%     |
| Yukon                     | 	5%	  | 0%     |

## RoadTrip Class

Your `RoadTrip` class must have the following items:

- Main method:
    - A `main` method which prints a series of statements each on their own line in the following formats: 
      "Pay $x for y" where x is the total cost and y is the item being paid for.
      "Driving to z" where z is the name of a Canadian province, printed each time the location is changed.
      First calculate the total cost of $83.45 of gas, then change the province to Alberta. Then calculate the 
      total cost of $23 for lunch and change the province to Saskatchewan. Finally, calculate the total cost for an
      $86 motel and $75.81 of gas. Each price should be printed to 2 decimal places.
    - Note that static attributes and methods of a class can be called using the class name.
    