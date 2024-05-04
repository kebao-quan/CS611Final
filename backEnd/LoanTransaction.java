package backEnd;

public class LoanTransaction {
    private Account account;
    private double amount;
    private double interestRate;
    private int term;
    private double monthlyPayment;
    private double totalPayment;
    private boolean isExecuted = false;

    public LoanTransaction(Account account, double amount, double interestRate, int term) {
        this.account = account;
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
    }

    public void execute() {
        this.monthlyPayment = calculateMonthlyPayment();
        this.totalPayment = calculateTotalPayment();
        this.account.deposit(this.amount);
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
