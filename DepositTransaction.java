public class DepositTransaction extends Transaction {

    public DepositTransaction(Account account, double amount) {
        super(account, amount);
    }

    @Override
    public void execute() throws InsufficientFundsException {
        this.account.deposit(this.amount);
        isExecuted = true;
    }
}
