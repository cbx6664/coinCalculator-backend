# Backend Service for CoinCalculator
It calculates minimum number of coins needed to make up a target amount. 


The inputs are:

Target amount – amount of money you need to make up to. Target amount must be within the range between 0 and 10,000.00

Coin denominations – a list of coin denominations to be used to make up the target amount. Coin denomination must be one of the following values [0.01, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 50, 100, 1000]


Output:

A list of minimum number of coins in ascending order

You can assume that you have infinite number of coins for each denomination


- Example 1:

Input:

Target amount: 7.03

Coin denominator: [0.01, 0.5, 1, 5, 10]

Output: 

[0.01, 0.01, 0.01, 1, 1, 5]

 
- Example 2:

Input:

Target amount: 103

Coin denominator: [1, 2, 50]

Output: 

[1, 2, 50, 50]
