# oop-creating_objects_from_classes-hard-q4

investment account types:
Savings, Checkings, Tfsa, Gic, Rrsp, Resp, Rrif, GrowthInvestment, Shares, Stocks, PropertyInvestment, CashInvestment,
FixedRateInvestment, HighRiskInvestment, BrokerageAccount, TermInvestment, MutualFund

vary initial deposit: integer from 100 to 1000
vary bonus amount: integer from 0 to 100

## Question Text

Suppose you have defined a `Savings` class, and now you want to define a `BankAccount` class. In the `BankAccount`
class, you need to define a method called `startInvestment()` that takes no input and returns a **Savings** object with
a random double value between 0 and 200 for the `initial` and 0 for the `bonus`. Use the constructor in the
provided `Savings` class to do this.