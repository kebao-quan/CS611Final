package backEnd;
public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(String accountId, double amount) {
        super(accountId, amount);
    }

    @Override
    public void execute() throws InsufficientFundsException {
        Database.getInstance().getAccount(accountId).withdraw(this.amount);
        isExecuted = true;
        Database.persist();
    }
}
