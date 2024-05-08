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
### FrontEnd:  
accountDetails.java: displays account details when a specific account is selected    
accountList.java: displays a list of accounts that the user have  
addStock.java: interface for manager so he can create stocks  
allTransaction.java: displays a list of all transactions by all users, for the manager.  
allUsers.java: displays a list of all users, for manager.  
currentUser.java: singleton class to keep track of the current user and its selected items.  
deposite.java: interface for user to deposite money in to their accounts.   
invest.java: interface for user to invest in to stocks through their securities account.  
Login.java: initial interface for user to log in from.  
mainGUI.java: initializes all the pages.  
managerMenu.java: menu for manager.  
managerStockList.java: lists all the stocks for the manager to view.  
managerStockMenu.java: stock menu for the manager, has different buttons than the user one.  
openAccount.java: interface for user to open an account.  
profit.java: displays the profit earned by the user from their stocks.  
register.java: register menu for soon to be users.  
stock.java: stock menu for the users.  
stockList.java: lists the stocks for the user.  
takeLoan.java: interface for the user to take a loan.  
transactionHistory.java: displays the transaction history for the current user.  
userMenu.java: initial menu for the user,  
withdraw.java: interface for user to withdraw money from their account.  

### BackEnd:  
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
2. Enter "manager" for both username and password to enter the manager menu.
3. User are able to close account.

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
