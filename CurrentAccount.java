
class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber,
                          String accountHolder,
                          double initialBalance) {

        super(accountNumber, accountHolder, initialBalance);
    }

    @Override
    public void withdraw(double amount) {

        if (deductBalance(amount)) {
            System.out.println("Current account withdrawal successful!");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

