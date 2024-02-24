# oop-creating_objects_from_classes-hard-q4

investment account types:
Savings, Checkings, Tfsa, Gic, Rrsp, Resp, Rrif, GrowthInvestment, Shares, Stocks, PropertyInvestment, CashInvestment,
FixedRateInvestment, HighRiskInvestment, BrokerageAccount, TermInvestment, MutualFund

## Java questions

## Question Text

Suppose you have defined a `Savings` class to model your investment account, and now you want to test it to make sure 
that it works. Given the savings class below, create a test class called `BankAccount` with a main method and 
initialize a `Savings` object with the following attribute:
- Initial: 500.32

Then, call the `getTotal` method and print the balance of the created Savings object on its own line. The result from 
doing this should be the printing of the `String` "Balance: x" where x is the value of the total.

Then, call the `recieveBonus` method and print the above String again with the updated balance.

Note: You do not need to place the savings class in your submission code, the website will handle this for you. It is 
just for you to reference.

### Savings Class:

```java
public class Savings {
    double initial;
    double bonus;

    public Savings(double initial) {
        this.initial = initial;
        bonus = Math.random() * 200;
    }

    public double getTotal() {
        return initial + bonus;
    }

    public double receiveBonus() {
        return bonus += Math.random() * 200;
    }
}
```
