package backEnd;

public class LoanTransaction extends Transaction{
    private String accountId;
    private double amount;
    private String collat;
    private double collatAmount;
    private double interestRate;
    private int term;
    private double monthlyPayment;
    private double totalPayment;
    private boolean isExecuted = false;

    public LoanTransaction(String accountId, double amount, String collat, double collatAmount) {
        super(accountId, amount);
        this.collat = collat;
        this.collatAmount = collatAmount;
    }

    public void execute() {
        Account account = Database.getInstance().getAccount(accountId);
        String username = account.getUsername();
        account.deposit(this.amount);
        User user = Database.getInstance().getUser(username);
        Collateral collateral = new Collateral(collat, collatAmount);
        user.addCollateral(collateral);
        user.setDebt(user.getDebt() + this.amount);

        isExecuted = true;
        Database.persist();
    }

    public double calculateMonthlyPayment() {
        double monthlyInterestRate = this.interestRate / 12;
        double monthlyPayment = (this.amount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -this.term));
        return monthlyPayment;
    }

    public double calculateTotalPayment() {
        return this.monthlyPayment * this.term;
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public double getTotalPayment() {
        return this.totalPayment;
    }

    public boolean isExecuted() {
        return isExecuted;
    }
}
