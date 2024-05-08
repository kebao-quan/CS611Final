# CS611-Final Assignment
## Name of Assignment
---------------------------------------------------------------------------
Name: Ziping(Peter) Wang  
Email: pwang78@bu.edu  
Student ID: U34449628  

Name: Kebao Quan
Email: kbquan@bu.edu  
Student ID: U72941647  

## Files
---------------------------------------------------------------------------
FrontEnd:
accountDetails.java: displays account details when a specific account is selected  

BackEnd:
Account.java:  Account class is an abstract class that represents a generic account. It contains the basic information of an account such as the account ID, balance, currency, and username.  
AccountFactory.java: AccountFactory class is a factory class that creates an account object based on the account type. It contains a createAccount method that takes the username, account type, initial balance, and currency as parameters.  
App.java: This class define the method for frontend to interact with the backend.  
CheckingAccount: Extend from Account.  
SavingsAccount.java: Extend from Account.  
SecurityAccount.java: Extend from Account.  
Collateral.java: Collateral of User.  
Database.java: This class is the database of the application, it stores all the users, accounts, transactions and stocks. It is a singleton class, and the instance can be accessed by calling Database.getInstance().  
Transaction.java: This class is an abstract class that represents a transaction. It contains the transaction ID, date, amount, and account ID. It also contains an abstract method to execute the transaction.  
DepositTransaction.java: Extend from Transaction.  
TransferTransaction.java: Extend from Transaction.  
LoanTransactioin.java: Extend from Transaction.  
WithdrawalTransaction.java Extend from Transaction.  
InsufficientFundsException.java: InsufficientFundsException is thrown when a user tries to withdraw more money than they have in their account.  
User.java: This class represents a user of the application. It contains the username, password, debt, and a list of collaterals.  
Util.java: some util method.  
Stock.java: Stock class that represents a stock object with a symbol, name, and price. This class is used to store stock information.  

## Notes
---------------------------------------------------------------------------
1. We implement strict data consistency. We can have multiple programs accessing the same database.

## Citaions
---------------------------------------------------------------------------
ChatGPT for java syntax, Swing usage example.


## How to compile and run
---------------------------------------------------------------------------
Your directions on how to run the code. Ideally should resemble the lines below

1. Navigate to the directory after unzipping the files
2. Run the following instructions:  
mkdir -p bin  
javac src/*.java -d bin  
java -cp ./bin Main
