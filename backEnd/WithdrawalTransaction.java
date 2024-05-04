package backEnd;
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(Account account, double amount) {
        super(account, amount);
    }

    @Override
    public void execute() throws InsufficientFundsException {
        this.account.withdraw(this.amount);
        isExecuted = true;
    }
}
