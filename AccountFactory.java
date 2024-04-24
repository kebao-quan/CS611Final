


public class AccountFactory {
    public Account createAccount(String accountType, String accountNumber, double balance) {
        if (accountType.equals("Savings")) {
            return new SavingsAccount(accountNumber, balance);
        } else if (accountType.equals("Checking")) {
            return new CheckingAccount(accountNumber, balance);
        } else {
            return null;
        }
    }
}
