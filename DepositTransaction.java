public class DepositTransaction extends Transaction {

    public DepositTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        this.account.deposit(this.amount);
    }
}
