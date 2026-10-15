
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("       WELCOME TO MY BANK");
            System.out.println("================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. View All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1: {

                    System.out.print("Enter account number: ");
                    int accountNumber = sc.nextInt();

                    if (bank.findAccount(accountNumber) != null) {
                        System.out.println("Account number already exists.");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();

                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.print("Choose account type: ");

                    int type = sc.nextInt();

                    System.out.print("Enter initial deposit: Rs. ");
                    double initialBalance = sc.nextDouble();

                    if (initialBalance < 0 ||
                        (type != 1 && type != 2)) {

                        System.out.println("Invalid input.");
                        break;
                    }

                    Customer customer = new Customer(name, phone);

                    Account account;

                    if (type == 1) {
                        account = new SavingsAccount(
                            accountNumber,
                            customer.getName(),
                            initialBalance
                        );
                    } else {
                        account = new CurrentAccount(
                            accountNumber,
                            customer.getName(),
                            initialBalance
                        );
                    }

                    bank.addAccount(account);

                    break;
                }

                case 2: {

                    System.out.print("Enter account number: ");
                    int accountNumber = sc.nextInt();

                    Account account = bank.findAccount(accountNumber);

                    if (account == null) {
                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.print("Enter deposit amount: Rs. ");
                    double amount = sc.nextDouble();

                    account.deposit(amount);

                    break;
                }

                case 3: {

                    System.out.print("Enter account number: ");
                    int accountNumber = sc.nextInt();

                    Account account = bank.findAccount(accountNumber);

                    if (account == null) {
                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.print("Enter withdrawal amount: Rs. ");
                    double amount = sc.nextDouble();

                    account.withdraw(amount);

                    break;
                }

                case 4: {

                    System.out.print("Enter account number: ");
                    int accountNumber = sc.nextInt();

                    Account account = bank.findAccount(accountNumber);

                    if (account == null) {
                        System.out.println("Account not found.");
                    } else {
                        System.out.println(
                            "Available Balance: Rs. "
                            + account.getBalance()
                        );
                    }

                    break;
                }

                case 5: {

                    System.out.print("Enter account number: ");
                    int accountNumber = sc.nextInt();

                    Account account = bank.findAccount(accountNumber);

                    if (account == null) {
                        System.out.println("Account not found.");
                    } else {
                        account.displayDetails();
                    }

                    break;
                }

                case 6: {

                    bank.showAllAccounts();

                    break;
                }

                case 7: {

                    System.out.println("Thank you for using My Bank!");

                    break;
                }

                default: {

                    System.out.println("Invalid choice. Try again.");

                }
            }

        } while (choice != 7);

        sc.close();
    }
}

