package backEnd;
public class TransferTransaction extends Transaction {
    private Account toAccount;

    public TransferTransaction(Account fromAccount, Account toAccount, double amount) {
        super(fromAccount, amount);
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public void execute() throws InsufficientFundsException {
        this.account.withdraw(this.amount);
        this.toAccount.deposit(this.amount);
        isExecuted = true;
    }
}
