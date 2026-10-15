
import java.util.ArrayList;

class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    public Account findAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    public void showAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (Account account : accounts) {
            System.out.println("--------------------");
            account.displayDetails();
        }
    }
}

