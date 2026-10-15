
class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber,
                          String accountHolder,
                          double initialBalance) {

        super(accountNumber, accountHolder, initialBalance);
    }

    @Override
    public void withdraw(double amount) {

        if (deductBalance(amount)) {
            System.out.println("Savings account withdrawal successful!");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

